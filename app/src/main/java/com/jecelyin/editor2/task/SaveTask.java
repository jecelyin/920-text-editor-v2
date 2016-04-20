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

package com.jecelyin.editor2.task;

import android.content.Context;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor2.R;
import com.jecelyin.editor2.common.SaveListener;
import com.jecelyin.editor2.io.FileWriter;
import com.jecelyin.editor2.ui.Document;
import com.jecelyin.editor2.ui.EditorDelegate;

import java.io.File;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SaveTask {
    private final Context context;
    private final EditorDelegate editorDelegate;
    private final Document document;
    private boolean writing = false;
    private boolean isCluster;

    public SaveTask(Context context, EditorDelegate editorDelegate, Document document) {
        this.context = context;
        this.editorDelegate = editorDelegate;
        this.document = document;
    }

    public boolean isWriting() {
        return writing;
    }

    public void save(boolean isCluster, SaveListener listener) {
        if(writing)
            return;
        if(!document.isChanged()) {
//            if(!isCluster)
//                UIUtils.toast(context, R.string.no_change);
            return;
        }
        this.isCluster = isCluster;
        File file = document.getFile();
        if(file == null) {
            editorDelegate.startSaveFileSelectorActivity();
            return;
        }
        if (document.isRoot()) {
            saveTo(document.getRootFile(), file, document.getEncoding(), listener);
        } else {
            saveTo(file, null, document.getEncoding(), listener);
        }

    }

    public void saveTo(final File file, final String encoding) {
        saveTo(file, null, encoding, null);
    }

    /**
     *
     * @param rootFile 要注意这里是否ROOT处理
     * @param orgiFile 如果是Root处理，保存成功后要回写到原始文件
     * @param encoding
     * @param listener
     */
    private void saveTo(final File rootFile, final File orgiFile, final String encoding, final SaveListener listener) {
        writing = true;
        FileWriter fileWriter = new FileWriter(rootFile, orgiFile, encoding);
        fileWriter.setFileWriteListener(new FileWriter.FileWriteListener() {
            @Override
            public void onSuccess() {
                writing = false;

                document.onSaveSuccess(orgiFile != null ? orgiFile : rootFile, encoding);
                if(!isCluster) {
                    UIUtils.toast(context, R.string.save_success);
                } else {
                    editorDelegate.getMainActivity().doNextCommand();
                }
                if(listener != null)
                    listener.onSaved();
            }

            @Override
            public void onError(Exception e) {
                writing = false;
                L.e(e);
                UIUtils.alert(context, e.getMessage());
            }
        });
        fileWriter.write(editorDelegate.getEditableText());
    }
}
