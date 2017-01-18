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
import android.content.res.TypedArray;
import android.graphics.Color;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.Editable;
import android.text.Spanned;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.BackgroundColorSpan;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;
import com.jecelyin.editor.v2.common.OnVisibilityChangedListener;
import com.jecelyin.editor.v2.common.SaveListener;
import com.jecelyin.editor.v2.core.widget.JecEditText;
import com.jecelyin.editor.v2.core.widget.TextView;
import com.jecelyin.editor.v2.highlight.jedit.Catalog;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.syntax.ModeProvider;
import com.jecelyin.editor.v2.ui.dialog.DocumentInfoDialog;
import com.jecelyin.editor.v2.ui.dialog.FinderDialog;
import com.jecelyin.editor.v2.utils.AppUtils;
import com.jecelyin.editor.v2.view.EditorView;
import com.jecelyin.editor.v2.view.menu.MenuDef;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditorDelegate implements OnVisibilityChangedListener, TextWatcher {
    public final static String KEY_CLUSTER = "is_cluster";

    private Context context;
    public JecEditText mEditText;
    private EditorView mEditorView;
    private Document document;

    private static boolean disableAutoSave = false;

    private SavedState savedState;
    private int orientation;
    private boolean loaded = true;
    private int findResultsKeywordColor;

    public EditorDelegate(SavedState ss) {
        savedState = ss;
    }

    public EditorDelegate(int index, @Nullable File file, int offset, String encoding) {
        savedState = new SavedState();
        savedState.index = index;
        savedState.file = file;
        savedState.offset = offset;
        savedState.encoding = encoding;
        if(savedState.file != null) {
            savedState.title = savedState.file.getName();
        }
    }

    public EditorDelegate(int index, String title, Parcelable object) {
        savedState = new SavedState();
        savedState.index = index;
        savedState.title = title;
        savedState.object = object;
    }

    public EditorDelegate(int index, String title, CharSequence content) {
        savedState = new SavedState();
        savedState.index = index;
        savedState.title = title;
        savedState.content = content;
    }

    public static void setDisableAutoSave(boolean b) {
        disableAutoSave = b;
    }

    private void init() {
        if (document != null)
            return;

        TypedArray a = context.obtainStyledAttributes(new int[]{
                R.attr.findResultsKeyword,
        });
        findResultsKeywordColor = a.getColor(0, Color.BLACK);
        a.recycle();

        document = new Document(context, this);
        mEditText.setReadOnly(Pref.getInstance(context).isReadOnly());
        mEditText.setCustomSelectionActionModeCallback(new EditorSelectionActionModeCallback());

        //还原文本时，onTextChange事件触发高亮
        if (savedState.editorState != null) {
            document.onRestoreInstanceState(savedState);
            mEditText.onRestoreInstanceState(savedState.editorState);
        } else if (savedState.file != null) {
            document.loadFile(savedState.file, savedState.encoding);
        } else if(!TextUtils.isEmpty(savedState.content)) {
            mEditText.setText(savedState.content);
        }

        mEditText.addTextChangedListener(this);

        // 更新标题
        noticeDocumentChanged();

        if(!AppUtils.verifySign(context)) {
            mEditText.setText(context.getString(R.string.verify_sign_failure));
        }

        if(savedState.object != null) {
            EditorObjectProcessor.process(savedState.object, this);
        }
    }

    public void setEditorView(EditorView editorView) {
        context = editorView.getContext();
        this.mEditorView = editorView;
        this.mEditText = editorView.getEditText();

        this.orientation = context.getResources().getConfiguration().orientation;

        editorView.setVisibilityChangedListener(this);

        init();
    }

    public void onLoadStart() {
        loaded = false;
        mEditText.setEnabled(false);
        mEditorView.setLoading(true);
    }

    public void onLoadFinish() {
        mEditorView.setLoading(false);
        mEditText.setEnabled(true);
        mEditText.post(new Runnable() {
            @Override
            public void run() {
                if (savedState.offset < mEditText.getText().length())
                    mEditText.setSelection(savedState.offset);
            }
        });

        noticeDocumentChanged();

        if(!"com.jecelyin.editor.v2".equals(context.getPackageName())) {
            mEditText.setEnabled(false);
        }
        loaded = true;

    }

    public Context getContext() {
        return context;
    }

    public MainActivity getMainActivity() {
        return (MainActivity)context;
    }

    public String getTitle() {
        return savedState.title;
    }

    public String getPath() {
        return document == null ? (savedState.file == null ? null : savedState.file.getPath()) : document.getPath();
    }

    public String getEncoding() {
        return document == null ? null : document.getEncoding();
    }

    public String getText() {
        return mEditText.getText().toString();
    }

    public Editable getEditableText() {
        return mEditText.getText();
    }

    public CharSequence getSelectedText() {
        return mEditText.hasSelection() ? mEditText.getEditableText().subSequence(mEditText.getSelectionStart(), mEditText.getSelectionEnd()) : "";
    }

    public boolean isChanged() {
        //如果多个标签情况下，屏幕旋转后，可能某个标签没有初始化
        if (document == null)
            return false;
        return document.isChanged();
    }

    public CharSequence getToolbarText() {
        return String.format("%s%s  \t|\t  %s \t %s", isChanged() ? "*" : "", getTitle()
                , document == null ? "UTF-8" : document.getEncoding()
                , document == null || document.getModeName() == null ? "" : document.getModeName()
        );
    }

    public void startSaveFileSelectorActivity() {
        getMainActivity().startPickPathActivity(document.getPath(), document.getEncoding());
    }

    public void saveTo(File file, String encoding) {
        document.saveTo(file, encoding == null ? document.getEncoding() : encoding);
    }

    public void addHightlight(int start, int end) {
        mEditText.getText().setSpan(new BackgroundColorSpan(findResultsKeywordColor), start, end, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
        mEditText.setSelection(end, end);
    }

    public int getCursorOffset() {
        if (mEditText == null)
            return -1;
        return mEditText.getSelectionEnd();
    }

    /**
     * @param command
     * @return 执行结果
     */
    public boolean doCommand(Command command) {
        if(mEditText == null)
            return false;
        boolean readonly = Pref.getInstance(context).isReadOnly();
        switch (command.what) {
            case HIDE_SOFT_INPUT:
                mEditText.hideSoftInput();
                break;
            case SHOW_SOFT_INPUT:
                mEditText.showSoftInput();
                break;
            case UNDO:
                if (!readonly)
                    mEditText.undo();
                break;
            case REDO:
                if (!readonly)
                    mEditText.redo();
                break;
            case CUT:
                if (!readonly)
                    return mEditText.cut();
            case COPY:
                return mEditText.copy();
            case PASTE:
                if (!readonly)
                    return mEditText.paste();
            case SELECT_ALL:
                return mEditText.selectAll();
            case DUPLICATION:
                if (!readonly)
                    mEditText.duplication();
                break;
            case CONVERT_WRAP_CHAR:
                if (!readonly)
                    mEditText.convertWrapCharTo((String) command.object);
                break;
            case GOTO_LINE:
                mEditText.gotoLine(command.args.getInt("line"));
                break;
            case GOTO_TOP:
                mEditText.gotoTop();
                break;
            case GOTO_END:
                mEditText.gotoEnd();
                break;
            case DOC_INFO:
                DocumentInfoDialog documentInfoDialog = new DocumentInfoDialog(context);
                documentInfoDialog.setDocument(document);
                documentInfoDialog.setJecEditText(mEditText);
                documentInfoDialog.setPath(document.getPath());
                documentInfoDialog.show();
                break;
            case READONLY_MODE:
                Pref pref = Pref.getInstance(context);
                boolean readOnly = pref.isReadOnly();
                mEditText.setReadOnly(readOnly);
                ((MainActivity)context).doNextCommand();
                break;
            case SAVE:
                if (!readonly)
                    document.save(command.args.getBoolean(KEY_CLUSTER, false), (SaveListener) command.object);
                break;
            case SAVE_AS:
                document.saveAs();
                break;
            case FIND:
                FinderDialog.showFindDialog(this);
                break;
            case HIGHLIGHT:
                String scope = (String) command.object;
                if (scope == null) {
                    Mode mode;
                    String firstLine = getEditableText().subSequence(0, Math.min(80, getEditableText().length())).toString();
                    if (TextUtils.isEmpty(document.getPath()) || TextUtils.isEmpty(firstLine)) {
                        mode = ModeProvider.instance.getMode(Catalog.DEFAULT_MODE_NAME);
                    } else {
                        mode = ModeProvider.instance.getModeForFile(document.getPath(), null, firstLine);
                    }

                    if (mode == null) {
                        mode = ModeProvider.instance.getMode(Catalog.DEFAULT_MODE_NAME);
                    }

                    scope = mode.getName();
                }
                document.setMode(scope);
                ((MainActivity)context).doNextCommand();
                break;
            case INSERT_TEXT:
                if (!readonly) {
                    int selStart = mEditText.getSelectionStart();
                    int selEnd = mEditText.getSelectionEnd();
                    if (selStart == -1 || selEnd == -1) {
                        mEditText.getText().insert(0, (CharSequence) command.object);
                    } else {
                        mEditText.getText().replace(selStart, selEnd, (CharSequence) command.object);
                    }
                }
                break;
            case RELOAD_WITH_ENCODING:
                reOpenWithEncoding((String) command.object);
                break;
            case FORWARD:
                mEditText.forwardLocation();
                break;
            case BACK:
                mEditText.backLocation();
                break;
        }
        return true;
    }

    private void reOpenWithEncoding(final String encoding) {
        final File file = document.getFile();
        if (file == null) {
            UIUtils.toast(context, R.string.please_save_as_file_first);
            return;
        }
        if (document.isChanged()) {
            new MaterialDialog.Builder(context)
                    .title(R.string.document_changed)
                    .content(R.string.give_up_document_changed_message)
                    .positiveText(R.string.cancel)
                    .negativeText(R.string.ok)
                    .callback(new MaterialDialog.ButtonCallback() {
                        @Override
                        public void onNegative(MaterialDialog dialog) {
                            dialog.dismiss();
                            document.loadFile(file, encoding);
                        }

                        @Override
                        public void onPositive(MaterialDialog dialog) {
                            dialog.dismiss();
                        }
                    }).show();
            return;
        }
        document.loadFile(file, encoding);
    }

    void noticeDocumentChanged() {
        File file = document.getFile();
        if (file != null) {
            // 另存为后更新一下文件名
            savedState.title = file.getName();
        }

        //保存文件后判断改变
        noticeMenuChanged();
    }

    public void setRemoved() {
        if (mEditorView == null)
            return;
        mEditorView.setRemoved();
    }

    @Override
    public void onVisibilityChanged(int visibility) {
        if (visibility != View.VISIBLE)
            return;

        noticeMenuChanged();
    }

    private void noticeMenuChanged() {
        MainActivity mainActivity = (MainActivity) this.context;
        mainActivity.setMenuStatus(R.id.m_save, isChanged() ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
        mainActivity.setMenuStatus(R.id.m_undo, mEditText != null && mEditText.canUndo() ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
        mainActivity.setMenuStatus(R.id.m_redo, mEditText != null && mEditText.canRedo() ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
        ((MainActivity)context).getTabManager().onDocumentChanged(savedState.index);
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void afterTextChanged(Editable s) {
        if (loaded)
            noticeMenuChanged();
    }

    public String getLang() {
        if (document == null)
            return null;
        return document.getModeName();
    }

    private class EditorSelectionActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            final TypedArray styledAttributes = context.obtainStyledAttributes(
                    R.styleable.SelectionModeDrawables);

            boolean readOnly = Pref.getInstance(context).isReadOnly();
            boolean selected = mEditText.hasSelection();
            if (selected) {
                menu.add(0, R.id.m_find_replace, 0, R.string.find).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModeFindDrawable, 0)).
                        setAlphabeticShortcut('f').
                        setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

                if (!readOnly) {
                    menu.add(0, R.id.m_convert_to_uppercase, 0, R.string.convert_to_uppercase)
                            .setIcon(R.drawable.m_uppercase)
                            .setAlphabeticShortcut('U')
                            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

                    menu.add(0, R.id.m_convert_to_lowercase, 0, R.string.convert_to_lowercase)
                            .setIcon(R.drawable.m_lowercase)
                            .setAlphabeticShortcut('L')
                            .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                }
            }

            if (!readOnly) {
                menu.add(0, R.id.m_duplication, 0, selected ? R.string.duplication_text : R.string.duplication_line)
                        .setIcon(R.drawable.m_duplication)
                        .setAlphabeticShortcut('L')
                        .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }

            styledAttributes.recycle();
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
            return false;
        }

        @Override
        public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
            switch (item.getItemId()) {
                case R.id.m_find_replace:
                    doCommand(new Command(Command.CommandEnum.FIND));
                    return true;
                case R.id.m_convert_to_uppercase:
                case R.id.m_convert_to_lowercase:
                    convertSelectedText(item.getItemId());
                    return true;
                case R.id.m_duplication:
                    mEditText.duplication();
                    return true;
            }
            return false;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }

    private void convertSelectedText(int id) {
        if (mEditText == null || !mEditText.hasSelection())
            return;

        int start = mEditText.getSelectionStart();
        int end = mEditText.getSelectionEnd();

        String selectedText = getEditableText().subSequence(start, end).toString();

        switch (id) {
            case R.id.m_convert_to_uppercase:
                selectedText = selectedText.toUpperCase();
                break;
            case R.id.m_convert_to_lowercase:
                selectedText = selectedText.toLowerCase();
                break;
        }
        getEditableText().replace(start, end, selectedText);
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = savedState;
        if (document != null) {
            document.onSaveInstanceState(ss);
        }
        if (mEditText != null) {
            mEditText.setFreezesText(true);
            ss.editorState = (TextView.SavedState) mEditText.onSaveInstanceState();
        }

        if (loaded && !disableAutoSave && document != null && document.getFile() != null && Pref.getInstance(context).isAutoSave()) {
            int newOrientation = context.getResources().getConfiguration().orientation;
            if (orientation != newOrientation) {
                L.d("current is screen orientation, discard auto save!");
                orientation = newOrientation;
            } else {
                document.save();
            }
        }

        return ss;
    }

    private static class Arguments {
        CharSequence content;
        Parcelable object;
    }

    public static class SavedState extends Arguments implements Parcelable {
        int index;
        int offset;
        int lineNumber;
        File file;
        String title;
        String encoding;
        String modeName;
        TextView.SavedState editorState;
        byte[] textMd5;

        boolean root;
        File rootFile;
        int textLength;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.index);
            dest.writeInt(this.offset);
            dest.writeInt(this.lineNumber);
            dest.writeString(this.file == null ? null : this.file.getPath());
            dest.writeString(this.rootFile == null ? null : this.rootFile.getPath());
            dest.writeInt(root ? 1 : 0);
            dest.writeString(this.title);
            dest.writeString(this.encoding);
            dest.writeString(this.modeName);
            dest.writeInt(this.editorState == null ? 0 : 1);
            if (this.editorState != null)
                dest.writeParcelable(this.editorState, flags);
            dest.writeByteArray(this.textMd5);
            dest.writeInt(textLength);
        }

        public SavedState() {
        }

        protected SavedState(Parcel in) {
            this.index = in.readInt();
            this.offset = in.readInt();
            this.lineNumber = in.readInt();
            String file, rootFile;
            file = in.readString();
            rootFile = in.readString();
            this.file = TextUtils.isEmpty(file) ? null : new File(file);
            this.rootFile = TextUtils.isEmpty(rootFile) ? null : new File(rootFile);
            this.root = in.readInt() == 1;
            this.title = in.readString();
            this.encoding = in.readString();
            this.modeName = in.readString();
            int hasState = in.readInt();
            if (hasState == 1)
                this.editorState = in.readParcelable(TextView.SavedState.class.getClassLoader());
            this.textMd5 = in.createByteArray();
            this.textLength = in.readInt();
        }

        public static final Creator<SavedState> CREATOR = new Creator<SavedState>() {
            @Override
            public SavedState createFromParcel(Parcel source) {
                return new SavedState(source);
            }

            @Override
            public SavedState[] newArray(int size) {
                return new SavedState[size];
            }
        };
    }

}
