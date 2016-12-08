/*
 * Copyright (C) 2016 Jecelyin Peng <jecelyin@gmail.com>
 *
 * This file is part of 920 Text Editor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jecelyin.editor.v2.ui;

import android.content.Context;
import android.os.AsyncTask;
import android.text.Editable;
import android.text.Spannable;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.StringUtils;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.ReadFileListener;
import com.jecelyin.editor.v2.common.SaveListener;
import com.jecelyin.editor.v2.core.text.SpannableStringBuilder;
import com.jecelyin.editor.v2.highlight.Buffer;
import com.jecelyin.editor.v2.highlight.HighlightInfo;
import com.jecelyin.editor.v2.highlight.jedit.Catalog;
import com.jecelyin.editor.v2.highlight.jedit.LineManager;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.StyleLoader;
import com.jecelyin.editor.v2.highlight.jedit.syntax.DefaultTokenHandler;
import com.jecelyin.editor.v2.highlight.jedit.syntax.ModeProvider;
import com.jecelyin.editor.v2.highlight.jedit.syntax.SyntaxStyle;
import com.jecelyin.editor.v2.highlight.jedit.syntax.Token;
import com.jecelyin.editor.v2.io.FileReader;
import com.jecelyin.editor.v2.task.SaveTask;
import com.stericson.RootTools.RootTools;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Document implements ReadFileListener, TextWatcher {
    public static SyntaxStyle[] styles;

    private final EditorDelegate editorDelegate;
    private final Context context;
    private final SaveTask saveTask;
    private final Pref pref;
    private int lineNumber;
    private String encoding = "UTF-8";
    private byte[] srcMD5;
    private int srcLength;
    private final Buffer buffer;
    private final HashMap<Integer, ArrayList<ForegroundColorSpan>> colorSpanMap;
    private File file, rootFile;
    private String modeName;
    private boolean root;

    public Document(Context context, EditorDelegate EditorDelegate) {
        this.editorDelegate = EditorDelegate;
        this.context = context;
        pref = Pref.getInstance(context);
        root = false;

        buffer = new Buffer(context);
        colorSpanMap = new HashMap<>();
        this.saveTask = new SaveTask(context, EditorDelegate, this);
        EditorDelegate.mEditText.addTextChangedListener(this);
    }

    public void onSaveInstanceState(EditorDelegate.SavedState ss) {
        ss.lineNumber = lineNumber;
        ss.textMd5 = srcMD5;
        ss.textLength = srcLength;
        ss.encoding = encoding;
        ss.modeName = modeName;
        ss.file = file;
        ss.rootFile = rootFile;
        ss.root = root;
    }

    public void onRestoreInstanceState(EditorDelegate.SavedState ss) {
        //为了避免光标不正确的现象（原因暂时不研究），先设置好高亮类型
        if (ss.modeName != null) {
            setMode(ss.modeName);
        }

        //还原行数，不能放在上面，避免因还没设置文本导致高亮崩溃
        if (ss.lineNumber > 0) {
            lineNumber = ss.lineNumber;
        }
        srcMD5 = ss.textMd5;
        srcLength = ss.textLength;
        encoding = ss.encoding;
        file = ss.file;
        rootFile = ss.rootFile;
        root = ss.root;
    }

    public void loadFile(File file) {
        loadFile(file, null);
    }
    public void loadFile(File file, String encodingName) {
        if(!file.isFile() || !file.exists()) {
            UIUtils.alert(context, context.getString(R.string.cannt_access_file, file.getPath()));
            return;
        }
        root = false;
        if ((!file.canRead() || !file.canWrite()) && pref.isRootable()) {
            rootFile = new File(SysUtils.getAppStoragePath(context), file.getName() + ".root");
            if (rootFile.exists())
                rootFile.delete();

            root = RootTools.copyFile(file.getPath(), rootFile.getPath(), false, true);
        }
        if(!file.canRead() && !root) {
            UIUtils.alert(context, context.getString(R.string.cannt_read_file, file.getPath()));
            return;
        }
        this.file = file;
        FileReader reader = new FileReader(root ? rootFile : file, encodingName);
        new ReadFileTask(reader, this).execute();
    }

    @Override
    public void onStart() {
        editorDelegate.onLoadStart();
    }

    @Override
    public SpannableStringBuilder onAsyncReaded(FileReader fileReader, boolean ok) {
        Editable text = fileReader.getBuffer();
        Mode mode = ModeProvider.instance.getModeForFile(file == null ? null : file.getPath(), null, text.subSequence(0, Math.min(80, text.length())).toString());
        if(mode == null)
            mode = ModeProvider.instance.getMode(Catalog.DEFAULT_MODE_NAME);
        modeName = mode.getName();
        buffer.setMode(mode);

        lineNumber = fileReader.getLineNumber();
        encoding = fileReader.getEncoding();

        srcMD5 = md5(text);
        srcLength = text.length();

        return (SpannableStringBuilder)text;

    }

    @Override
    public void onDone(SpannableStringBuilder spannableStringBuilder, boolean ok) {
        //给回收了。。
        if(editorDelegate == null || editorDelegate.mEditText == null)
            return;
        if(!ok) {
            editorDelegate.onLoadFinish();
            UIUtils.alert(context, context.getString(R.string.read_file_exception));
            return;
        }

        editorDelegate.mEditText.setLineNumber(lineNumber);
        editorDelegate.mEditText.setText(spannableStringBuilder);
        editorDelegate.onLoadFinish();

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
//        L.d("","onTextChanged: start=" + start + " before=" + before + " count=" + count, new Exception());

        Editable editableText = editorDelegate.getEditableText();
        buffer.setEditable(editableText);

        if(before > 0) {
            buffer.remove(start, before);
        }
        if(count > 0) {
            buffer.insert(start, s.subSequence(start, start + count));
        }

        lineNumber = buffer.getLineManager().getLineCount();

        if (!pref.isHighlight() || editableText.length() > pref.getHighlightSizeLimit())
            return;

        LineManager lineManager = buffer.getLineManager();
        int startLine = lineManager.getLineOfOffset(start);
        int endLine = lineManager.getLineOfOffset(start + count);
        int lineStartOffset = lineManager.getLineStartOffset(startLine);
        int lineEndOffset = lineManager.getLineEndOffset(endLine);

        boolean canHighlight = buffer.isCanHighlight();
        if(startLine == 0 && !canHighlight) {
            Mode mode = ModeProvider.instance.getModeForFile(file == null ? null : file.getPath(), null, s.subSequence(0, Math.min(80, s.length())).toString());
            if (mode != null)
                modeName = mode.getName();
            buffer.setMode(mode);
        }

        if (!canHighlight)
            return;

        ForegroundColorSpan[] spans = editableText.getSpans(lineStartOffset, lineEndOffset, ForegroundColorSpan.class);
        for(ForegroundColorSpan span : spans) {
            editableText.removeSpan(span);
        }

        highlight(editableText, startLine, endLine);
    }

    @Override
    public void afterTextChanged(Editable s) {

    }

    private final static class ReadFileTask extends AsyncTask<File, Void, SpannableStringBuilder> {
        private final ReadFileListener listener;
        private final FileReader fileReader;

        public ReadFileTask(FileReader reader, ReadFileListener listener) {
            this.fileReader = reader;
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            listener.onStart();
        }

        @Override
        protected SpannableStringBuilder doInBackground(File... params) {
            if(! fileReader.read() )
                return null;

            return listener.onAsyncReaded(fileReader, true);
        }

        @Override
        protected void onPostExecute(SpannableStringBuilder spannableStringBuilder) {
            listener.onDone(spannableStringBuilder, spannableStringBuilder != null);
        }
    }

    public void setMode(String name) {
        modeName = name;

        buffer.setMode(Catalog.getModeByName(name));
        editorDelegate.getEditableText().clearSpans();

        highlight(editorDelegate.getEditableText());
    }

    public String getModeName() {
        return modeName;
    }

    public Buffer getBuffer() {
        return buffer;
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return file == null ? null : file.getPath();
    }

    public int getLineNumber() {
        return lineNumber;
    }

    public String getEncoding() {
        return encoding;
    }

    public File getRootFile() {
        return rootFile;
    }

    public boolean isRoot() {
        return root;
    }

    public void save() {
        save(false, null);
    }

    public void save(boolean isCluster, SaveListener listener) {
        if (saveTask.isWriting()) {
            UIUtils.toast(context, R.string.writing);
            return;
        }
        if (isCluster && file == null) {
            listener.onSaved();
            UIUtils.toast(context, R.string.save_all_without_new_document_message);
            return;
        }
        saveTask.save(isCluster, listener);
    }

    public void saveAs() {
        editorDelegate.startSaveFileSelectorActivity();
    }

    void saveTo(File file, String encoding) {
        saveTask.saveTo(file, encoding);
    }

    public void onSaveSuccess(File file, String encoding) {
        this.file = file;
        this.encoding = encoding;
        srcMD5 = md5(editorDelegate.getText());
        srcLength = editorDelegate.getText().length();
        editorDelegate.noticeDocumentChanged();
    }

    public boolean isChanged() {
        if(srcMD5 == null) {
            return editorDelegate.getText().length() != 0;
        }
        if (srcLength != editorDelegate.getEditableText().length())
            return true;

        byte[] curMD5 = md5(editorDelegate.getEditableText());

        return !StringUtils.isEqual(srcMD5, curMD5);
    }


    /**
     * Returns the md5sum for given string. Or dummy byte array on error
     * Suppress NoSuchAlgorithmException because MD5 algorithm always present in JRE
     * @param charSequence Given string
     * @return md5 sum of given string
     */
    private static byte[] md5(CharSequence charSequence)
    {
        try
        {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            byte[] ba = new byte[2];
            for(int i = 0, n = charSequence.length(); i < n; i++)
            {
                char cp = charSequence.charAt(i);
                ba[0] = (byte)(cp & 0xff);
                ba[1] = (byte)(cp >> 8 & 0xff);
                digest.update(ba);
            }
            return digest.digest();
        }
        catch (NoSuchAlgorithmException e)
        {
            L.e("Can't Calculate MD5 hash!", e);
            return charSequence.toString().getBytes();
        }
    }

    private void highlight(Spannable spannableStringBuilder) {
        highlight(spannableStringBuilder, 0, lineNumber - 1);
    }

    private void highlight(Spannable spannableStringBuilder, int startLine, int endLine) {
        if(!buffer.isCanHighlight())
            return;
        DefaultTokenHandler tokenHandler;
//        L.d("hl startLine=" + startLine + " endLine=" + endLine);
        L.startTracing(null);
        if(styles == null)
            styles = StyleLoader.loadStyles(context);
        ArrayList<HighlightInfo> mergerArray;

        for (int i = startLine; i <= endLine; i++) {
            tokenHandler = new DefaultTokenHandler();
            buffer.markTokens(i, tokenHandler);
            Token token = tokenHandler.getTokens();

            mergerArray = new ArrayList<>();
            collectToken(buffer, i, token, mergerArray);
            addTokenSpans(spannableStringBuilder, i, mergerArray);
        }
        L.stopTracing();
    }

    private void addTokenSpans(Spannable spannableStringBuilder, int line, ArrayList<HighlightInfo> mergerArray) {
        ForegroundColorSpan fcs;

        ArrayList<ForegroundColorSpan> oldSpans = colorSpanMap.remove(line);
        if(oldSpans != null) {
            for(ForegroundColorSpan span : oldSpans) {
                spannableStringBuilder.removeSpan(span);
            }
        }

        int length = spannableStringBuilder.length();

        ArrayList<ForegroundColorSpan> spans = new ArrayList<>(mergerArray.size());
        for(HighlightInfo hi : mergerArray) {
            if(hi.endOffset > length) {
                // TODO: 15/12/27 不应该出现这种情况，要找到原因并解决
                L.e("assert hi.endOffset %d > maxLength %d", hi.endOffset, length);
                hi.endOffset = length;
            }
            if(hi.startOffset >= hi.endOffset) {
                L.e("hi.startOffset %d >= hi.endOffset %d", hi.startOffset, hi.endOffset);
                continue;
            }
            fcs = new ForegroundColorSpan(hi.color);
            spannableStringBuilder.setSpan(fcs, hi.startOffset, hi.endOffset, SpannableStringBuilder.SPAN_EXCLUSIVE_EXCLUSIVE);
            spans.add(fcs);
        }
        colorSpanMap.put(line, spans);
    }

    private void collectToken(Buffer buffer, int lineNumber, Token token
            , ArrayList<HighlightInfo> mergerArray) {
//        Segment segment = new Segment();
//        buffer.getLineText(lineNumber, segment);
//        String line = segment.toString();
//        String match;

        int lineStartOffset = buffer.getLineManager().getLineStartOffset(lineNumber);

        HighlightInfo hi;
        while(token.id != Token.END)
        {
            int startIndex = lineStartOffset + token.offset;
            int endIndex = lineStartOffset + token.offset+token.length;
            SyntaxStyle style = styles[token.id];
            //注意下面这句的使用
            token = token.next;

            if(style == null)
                continue;

//            int color = 0xFFFFFF & style.getForegroundColor();
            int color = style.getForegroundColor();

            if(mergerArray.isEmpty()) {
                mergerArray.add(new HighlightInfo(startIndex, endIndex, color));
            } else {
                hi = mergerArray.get(mergerArray.size() - 1);
                if(hi.color == color && hi.endOffset == startIndex) {
                    hi.endOffset = endIndex;
                } else {
                    mergerArray.add(new HighlightInfo(startIndex, endIndex, color));
                }
            }
        }

//        for(HighlightInfo hl : mergerArray) {
//            match = line.substring(hl.startOffset, hl.endOffset);
//            System.err.println("<" + String.format("#%06X", hl.color) + ">" + match + "</" + String.format("#%06X", hl.color) + ">");
//        }

    }
}
