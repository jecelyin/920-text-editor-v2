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

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.StringUtils;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.ReadFileListener;
import com.jecelyin.editor.v2.common.SaveListener;
import com.jecelyin.editor.v2.io.FileReader;
import com.jecelyin.editor.v2.task.SaveTask;
import com.stericson.RootTools.RootTools;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Document implements ReadFileListener {

    private final EditorDelegate editorDelegate;
    private final Context context;
    private final SaveTask saveTask;
    private final Pref pref;
    private String encoding = "UTF-8";
    private byte[] srcMD5;
    private int srcLength;
    private File file, rootFile;
    private boolean root;

    public Document(Context context, EditorDelegate EditorDelegate) {
        this.editorDelegate = EditorDelegate;
        this.context = context;
        pref = Pref.getInstance(context);
        root = false;

        this.saveTask = new SaveTask(context, EditorDelegate, this);
    }

    public void onSaveInstanceState(EditorDelegate.SavedState ss) {
        ss.textMd5 = srcMD5;
        ss.textLength = srcLength;
        ss.encoding = encoding;
        ss.file = file;
        ss.rootFile = rootFile;
        ss.root = root;
    }

    public void onRestoreInstanceState(EditorDelegate.SavedState ss) {
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
    public StringBuilder onAsyncReaded(FileReader fileReader) {
        StringBuilder text = fileReader.getBuffer();

        encoding = fileReader.getEncoding();

        srcMD5 = md5(text);
        srcLength = text.length();

        return text;

    }

    @Override
    public void onDone(StringBuilder StringBuilder, Throwable throwable) {
        //给回收了。。
        if(editorDelegate == null || editorDelegate.mEditText == null)
            return;
        if(throwable != null) {
            editorDelegate.onLoadFinish();
            String message;
            if (throwable instanceof OutOfMemoryError) {
                message = context.getString(R.string.out_of_memory_error);
            } else {
                message = context.getString(R.string.read_file_exception) + throwable.getMessage();
            }
            UIUtils.alert(context, message);
            return;
        }

        editorDelegate.mEditText.setText(StringBuilder);
        editorDelegate.onLoadFinish();

    }

    private final static class ReadFileTask extends AsyncTask<File, Void, StringBuilder> {
        private final ReadFileListener listener;
        private final FileReader fileReader;
        private Throwable error;

        public ReadFileTask(FileReader reader, ReadFileListener listener) {
            this.fileReader = reader;
            this.listener = listener;
        }

        @Override
        protected void onPreExecute() {
            listener.onStart();
        }

        @Override
        protected StringBuilder doInBackground(File... params) {
            try {
                fileReader.read();
            } catch (Throwable t) {
                error = t;
            }

            return listener.onAsyncReaded(fileReader);
        }

        @Override
        protected void onPostExecute(StringBuilder StringBuilder) {
            listener.onDone(StringBuilder, error);
        }
    }

    public File getFile() {
        return file;
    }

    public String getPath() {
        return file == null ? null : file.getPath();
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
        String text = editorDelegate.getText();
        if(srcMD5 == null) {
            return text.length() != 0;
        }
        if (srcLength != text.length())
            return true;

        byte[] curMD5 = md5(text);

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

}
