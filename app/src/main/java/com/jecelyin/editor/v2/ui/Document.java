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

import com.jecelyin.common.listeners.OnResultCallback;
import com.jecelyin.common.utils.RootShellRunner;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.ReadFileListener;
import com.jecelyin.editor.v2.common.SaveListener;
import com.jecelyin.editor.v2.io.FileReader;
import com.jecelyin.editor.v2.task.SaveTask;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Document implements ReadFileListener {

    private final EditorDelegate editorDelegate;
    private final Context context;
    private final SaveTask saveTask;
    private final Pref pref;
    private String encoding = "UTF-8";
    private File file;
    private boolean root;

    public Document(Context context, EditorDelegate EditorDelegate) {
        this.editorDelegate = EditorDelegate;
        this.context = context;
        pref = Pref.getInstance(context);
        root = false;

        this.saveTask = new SaveTask(context, EditorDelegate, this);
    }

    public void onSaveInstanceState(EditorDelegate.SavedState ss) {
        ss.encoding = encoding;
        ss.file = file;
        ss.root = root;
    }

    public void onRestoreInstanceState(EditorDelegate.SavedState ss) {
        encoding = ss.encoding;
        file = ss.file;
        root = ss.root;
    }

    public void loadFile(File file) {
        loadFile(file, null);
    }
    public void loadFile(File f, String encodingName) {
        encoding = encodingName;
        this.file = f;
        root = pref.isRootEnabled();
        if (root) {
            if (RootShellRunner.isRootPath(file.getPath())) {
                final RootShellRunner runner = new RootShellRunner();
                runner.isRootAvailable(new OnResultCallback<Boolean>() {
                    @Override
                    public void onError(String error) {
                        runner.close();
                        doLoad();
                    }

                    @Override
                    public void onSuccess(Boolean result) {
                        root = result;
                        runner.close();
                        doLoad();
                    }
                });
                return;
            } else {
                root = false;
            }
        }
        if(!f.isFile() || !f.exists()) {
            UIUtils.alert(context, context.getString(R.string.cannt_access_file, f.getPath()));
            return;
        }
        doLoad();
    }

    private void doLoad() {
        if(!file.canRead() && !root) {
            UIUtils.alert(context, context.getString(R.string.cannt_read_file, file.getPath()));
            return;
        }

        FileReader reader = new FileReader(context, file, encoding, root, this);
        reader.start();
    }

    @Override
    public void onStart() {
        editorDelegate.onLoadStart();
    }

    @Override
    public void onDone(StringBuilder StringBuilder, String encoding, Throwable throwable) {
        //给回收了。。
        if(editorDelegate == null || editorDelegate.mEditText == null)
            return;
        this.encoding = encoding;
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

        editorDelegate.mEditText.setText(file.getPath(), StringBuilder);
        editorDelegate.onLoadFinish();

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

        editorDelegate.resetTextChange();

        editorDelegate.noticeDocumentChanged();
    }

    public boolean isChanged() {
        return editorDelegate.isTextChanged();
    }

}
