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

import android.content.ClipboardManager;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.view.ActionMode;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;
import com.jecelyin.editor.v2.common.OnVisibilityChangedListener;
import com.jecelyin.editor.v2.common.SaveListener;
import com.jecelyin.editor.v2.ui.dialog.DocumentInfoDialog;
import com.jecelyin.editor.v2.ui.dialog.FinderDialog;
import com.jecelyin.editor.v2.utils.AppUtils;
import com.jecelyin.editor.v2.view.EditorView;
import com.jecelyin.editor.v2.view.menu.MenuDef;
import com.jecelyin.editor.v2.widget.text.EditAreaView;
import com.jecelyin.editor.v2.widget.text.JsCallback;
import com.jecelyin.editor.v2.widget.text.OnTextChangeListener;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditorDelegate implements OnVisibilityChangedListener, OnTextChangeListener {
    public final static String KEY_CLUSTER = "is_cluster";

    private Context context;
    public EditAreaView mEditText;
    private EditorView mEditorView;
    private Document document;

    private static boolean disableAutoSave = false;

    private SavedState savedState;
    private int orientation;
    private boolean loaded = true;

    public EditorDelegate(SavedState ss) {
        savedState = ss;
    }

    public EditorDelegate(int index, @Nullable File file, int line, int column, String encoding) {
        savedState = new SavedState();
        savedState.index = index;
        savedState.file = file;
        savedState.encoding = encoding;
        savedState.line = line;
        savedState.column = column;
        if (savedState.file != null) {
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
        savedState.text = (content != null ? content.toString() : null);
    }

    public static void setDisableAutoSave(boolean b) {
        disableAutoSave = b;
    }

    private void init() {
        if (document != null)
            return;

        document = new Document(context, this);
        mEditText.setReadOnly(Pref.getInstance(context).isReadOnly());
        mEditText.setCustomSelectionActionModeCallback(new EditorSelectionActionModeCallback());

        //还原文本时，onTextChange事件触发高亮
//        if (savedState.editorState != null) {
//            document.onRestoreInstanceState(savedState);
//            mEditText.onRestoreInstanceState(savedState.editorState);
//        } else
        if (savedState.file != null) {
            document.loadFile(savedState.file, savedState.encoding);
        } else if (!TextUtils.isEmpty(savedState.text)) {
            mEditText.setText(null, savedState.text);
        }

        mEditText.addTextChangedListener(this);

        // 更新标题
        noticeDocumentChanged();

        if (!AppUtils.verifySign(context)) {
            mEditText.setText(null, context.getString(R.string.verify_sign_failure));
        }

        if (savedState.object != null) {
            EditorObjectProcessor.process(savedState.object, this);
        }
    }

    public void setEditorView(EditorView editorView) {
        context = editorView.getContext();
        this.mEditorView = editorView;
        this.mEditText = editorView.getEditAreaView();

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

        noticeDocumentChanged();

        if (!"com.jecelyin.editor.v2".equals(context.getPackageName())) {
            mEditText.setEnabled(false);
        }
        loaded = true;

        if (savedState.line > 0 || savedState.column > 0) {
            mEditText.gotoLine(savedState.line, savedState.column);
        }
    }

    public Context getContext() {
        return context;
    }

    public MainActivity getMainActivity() {
        return (MainActivity) context;
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

    public void getText(JsCallback<String> callback) {
        mEditText.getText(callback);
    }

    public void getSelectedText(JsCallback<String> callback) {
        mEditText.getSelectedText(callback);
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
                , getModeName()
        );
    }

    public void startSaveFileSelectorActivity() {
        mEditText.getLineText(0, 50, new JsCallback<String>() {
            @Override
            public void onCallback(String data) {
                getMainActivity().startPickPathActivity(document.getPath(), data, document.getEncoding());
            }
        });

    }

    public void saveTo(File file, String encoding) {
        if (document == null)
            return;
        document.saveTo(file, encoding == null ? document.getEncoding() : encoding);
    }

    /**
     * @param command
     * @return 执行结果
     */
    public boolean doCommand(Command command) {
        if (mEditText == null)
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
                mEditText.getText(new JsCallback<String>() {
                    @Override
                    public void onCallback(String data) {
                        DocumentInfoDialog documentInfoDialog = new DocumentInfoDialog(context);
                        documentInfoDialog.setDocument(document);
                        documentInfoDialog.setText(data);
                        documentInfoDialog.setPath(document.getPath());
                        documentInfoDialog.show();
                    }
                });

                break;
            case READONLY_MODE:
                Pref pref = Pref.getInstance(context);
                boolean readOnly = pref.isReadOnly();
                mEditText.setReadOnly(readOnly);
                ((MainActivity) context).doNextCommand();
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
            case ENABLE_HIGHLIGHT:
                mEditText.enableHighlight((boolean) command.object);
                ((MainActivity) context).doNextCommand();
                break;
            case CHANGE_MODE:
                String scope = (String) command.object;
                mEditText.setMode(scope);
                break;
            case INSERT_TEXT:
                if (!readonly) {
                    mEditText.insertOrReplaceText((CharSequence) command.object, false);
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
        final MainActivity mainActivity = (MainActivity) this.context;
        mainActivity.setMenuStatus(R.id.m_save, isChanged() ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
//        mainActivity.setMenuStatus(R.id.m_undo, MenuDef.STATUS_DISABLED);
//        mainActivity.setMenuStatus(R.id.m_redo, MenuDef.STATUS_DISABLED);
        if (mEditText != null) {
            mEditText.canUndo(new JsCallback<Boolean>() {
                @Override
                public void onCallback(Boolean data) {
                    if (data == null) return;
                    mainActivity.setMenuStatus(R.id.m_undo, data ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
                }
            });
            mEditText.canRedo(new JsCallback<Boolean>() {
                @Override
                public void onCallback(Boolean data) {
                    if (data == null) return;
                    mainActivity.setMenuStatus(R.id.m_redo, data ? MenuDef.STATUS_NORMAL : MenuDef.STATUS_DISABLED);
                }
            });
        }
        ((MainActivity) context).getTabManager().onDocumentChanged(savedState.index);
    }

    @Override
    public void onTextChanged() {
        if (loaded)
            noticeMenuChanged();
    }

    public String getModeName() {
        if (mEditText == null)
            return "";
        return mEditText.getModeName();
    }

    public boolean isTextChanged() {
        return mEditText.isTextChanged();
    }

    public void resetTextChange() {
        mEditText.resetTextChange();
    }

    private class EditorSelectionActionModeCallback implements ActionMode.Callback {

        @Override
        public boolean onCreateActionMode(ActionMode mode, Menu menu) {
            final TypedArray styledAttributes = context.obtainStyledAttributes(
                    R.styleable.SelectionModeDrawables);

            boolean readOnly = Pref.getInstance(context).isReadOnly();
            boolean selected = mEditText.hasSelection();
            if (selected) {
                if (!readOnly) {
                    menu.add(0, R.id.m_cut, 0,
                            R.string.cut).
                            setIcon(styledAttributes.getResourceId(
                                    R.styleable.SelectionModeDrawables_actionModeCutDrawable, 0)).
                            setAlphabeticShortcut('x').
                            setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
                }
                menu.add(0, R.id.m_copy, 0,
                        R.string.copy).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModeCopyDrawable, 0)).
                        setAlphabeticShortcut('c').
                        setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            }

            if (((ClipboardManager) getContext().getSystemService(Context.CLIPBOARD_SERVICE)).
                    hasPrimaryClip()) {
                menu.add(Menu.NONE, R.id.m_paste, 0,
                        R.string.paste).
                        setIcon(styledAttributes.getResourceId(
                                R.styleable.SelectionModeDrawables_actionModePasteDrawable, 0)).
                        setAlphabeticShortcut('v').
                        setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
            }

            menu.add(Menu.NONE, R.id.m_select_all, 0,
                    R.string.selectAll)
                    .setIcon(styledAttributes.getResourceId(
                            R.styleable.SelectionModeDrawables_actionModeSelectAllDrawable, 0))
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_IF_ROOM);

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
                case R.id.m_select_all:
                    mEditText.selectAll();
                    break;
                case R.id.m_cut:
                    mEditText.cut();
                    break;
                case R.id.m_copy:
                    mEditText.copy();
                    break;
                case R.id.m_paste:
                    mEditText.paste();
                    break;
                case R.id.m_find_replace:
                    doCommand(new Command(Command.CommandEnum.FIND));
                    break;
                case R.id.m_convert_to_uppercase:
                case R.id.m_convert_to_lowercase:
                    convertSelectedText(item.getItemId());
                    break;
                case R.id.m_duplication:
                    mEditText.duplication();
                    break;
            }
            mode.finish();
            return true;
        }

        @Override
        public void onDestroyActionMode(ActionMode mode) {

        }
    }

    private void convertSelectedText(final int id) {
        if (mEditText == null || !mEditText.hasSelection())
            return;

        mEditText.getSelectedText(new JsCallback<String>() {
            @Override
            public void onCallback(String selectedText) {
                switch (id) {
                    case R.id.m_convert_to_uppercase:
                        selectedText = selectedText.toUpperCase();
                        break;
                    case R.id.m_convert_to_lowercase:
                        selectedText = selectedText.toLowerCase();
                        break;
                }
                mEditText.insertOrReplaceText(selectedText, true);
            }
        });
    }

    public Parcelable onSaveInstanceState() {
        SavedState ss = savedState;
        if (document != null) {
            document.onSaveInstanceState(ss);
        }

        if (loaded && !disableAutoSave && document != null && document.getFile() != null && Pref.getInstance(context).isAutoSave()) {
            int newOrientation = context.getResources().getConfiguration().orientation;
            if (orientation != newOrientation) {
                orientation = newOrientation;
            } else {
                document.save();
            }
        }

        return ss;
    }

    public static class SavedState implements Parcelable {
        int index;
        File file;
        String title;
        String encoding;
        String text;

        boolean root;
        File rootFile;
        Parcelable object;
        int line;
        int column;

        @Override
        public int describeContents() {
            return 0;
        }

        @Override
        public void writeToParcel(Parcel dest, int flags) {
            dest.writeInt(this.index);
            dest.writeSerializable(this.file);
            dest.writeString(this.title);
            dest.writeString(this.encoding);
            dest.writeString(this.text);
            dest.writeByte(this.root ? (byte) 1 : (byte) 0);
            dest.writeSerializable(this.rootFile);
            dest.writeParcelable(this.object, flags);
            dest.writeInt(this.line);
            dest.writeInt(this.column);
        }

        public SavedState() {
        }

        protected SavedState(Parcel in) {
            this.index = in.readInt();
            this.file = (File) in.readSerializable();
            this.title = in.readString();
            this.encoding = in.readString();
            this.text = in.readString();
            this.root = in.readByte() != 0;
            this.rootFile = (File) in.readSerializable();
            this.object = in.readParcelable(Parcelable.class.getClassLoader());
            this.line = in.readInt();
            this.column = in.readInt();
        }

        public static final Parcelable.Creator<SavedState> CREATOR = new Parcelable.Creator<SavedState>() {
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
