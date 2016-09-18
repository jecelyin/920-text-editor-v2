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

package com.jecelyin.editor.v2.ui.dialog;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.net.Uri;
import android.text.TextUtils;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.android.file_explorer.util.MimeTypes;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.adapter.IntentChooserAdapter;
import com.jecelyin.editor.v2.utils.SL4AIntentBuilders;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class RunDialog extends AbstractDialog {
    private ArrayList<Executor> list;

    public static class Executor {
        public int id;
        public String name;

        public Executor(int id, String name) {
            this.id = id;
            this.name = name;
        }
    }

    public RunDialog(Context context) {
        super(context);

        list = new ArrayList<Executor>();
        list.add(new Executor(R.string.use_sl4a_in_background_run_script, context.getString(R.string.use_sl4a_in_background_run_script)));
        list.add(new Executor(R.string.use_sl4a_in_terminal_run_script, context.getString(R.string.use_sl4a_in_terminal_run_script)));
        list.add(new Executor(R.string.preview_in_browser, context.getString(R.string.preview_in_browser)));
        list.add(new Executor(R.string.other_application, context.getString(R.string.other_application)));
    }

    @Override
    public void show() {
        int size = list.size();
        String[] items = new String[size];
        for (int i=0; i<size; i++) {
            items[i] = list.get(i).name;
        }
        MaterialDialog dlg = getDialogBuilder().items(items)
                .title(R.string.run)
                .positiveText(R.string.close)
                .itemsCallback(new MaterialDialog.ListCallback() {
                    @Override
                    public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                        onItemClick(i);
                    }
                })
                .show();

        handleDialog(dlg);
    }

    private void onItemClick(int i) {
        String path = null;
        try {
            path = getMainActivity().getTabManager().getEditorAdapter().getCurrentEditorDelegate().getPath();
        } catch (Exception e) {
            L.e(e);
            UIUtils.toast(context, R.string.editor_initialing);
            return;
        }
        if(TextUtils.isEmpty(path)) {
            UIUtils.toast(context, R.string.please_save_as_file_first);
            return;
        }
        File file = new File(path);
        Uri data = Uri.fromFile(file);
        String type = MimeTypes.getInstance().getMimeType(file.getName());
        Executor executor = list.get(i);
        Intent it = null;
        switch (executor.id) {
            case R.string.use_sl4a_in_background_run_script:
                it = SL4AIntentBuilders.buildStartInBackgroundIntent(file);
                break;
            case R.string.use_sl4a_in_terminal_run_script:
                it = SL4AIntentBuilders.buildStartInTerminalIntent(file);
                break;
            case R.string.preview_in_browser:
                showBrowsersChooser(file);
                //下面方法会显示非浏览器，不建议用
//                it = new Intent(Intent.ACTION_VIEW);//注意调用it.setType会设置Data为null
//                it.setDataAndType(data, type); //注意调用it.setType会设置Data为null
//                it = Intent.createChooser(it, context.getString(R.string.chooser_browser));
                break;
            case R.string.other_application:
                it = new Intent(Intent.ACTION_VIEW);//注意调用it.setType会设置Data为null
                it.setDataAndType(data, type); //注意调用it.setType会设置Data为null
//                it.setComponent(new ComponentName("com.n0n3m4.droidc", "com.n0n3m4.droidc.CCompilerMain"));
                it = Intent.createChooser(it, context.getString(R.string.chooser_application));
                break;
        }
        if(it != null) {
            if (it.resolveActivity(context.getPackageManager()) != null) {
                try {
                    getMainActivity().startActivity(it);
                } catch (Exception e) {
                    L.d(e);
                    UIUtils.toast(context, R.string.run_fail_message);
                }
            }
        }
    }

    private void showBrowsersChooser(final File file) {
        Intent it = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.jecelyin.com"));
        final List<ResolveInfo> apps = context.getPackageManager().queryIntentActivities(it, PackageManager.MATCH_DEFAULT_ONLY);

        getDialogBuilder().adapter(new IntentChooserAdapter(context, apps), new MaterialDialog.ListCallback() {
            @Override
            public void onSelection(MaterialDialog dialog, View itemView, int which, CharSequence text) {
                dialog.dismiss();
                ResolveInfo info = apps.get(which);
                //该应用的包名
                String pkg = info.activityInfo.packageName;
                //应用的主activity类
                String cls = info.activityInfo.name;

                Intent it = new Intent(Intent.ACTION_VIEW, Uri.fromFile(file));
                it.setComponent(new ComponentName(pkg, cls));
                try {
                    getMainActivity().startActivity(it);
                } catch (Exception e) {
                    L.d(e);
                    UIUtils.toast(context, R.string.run_fail_message);
                }
            }
        })
        .title(R.string.chooser_browser)
        .show();
    }
}
