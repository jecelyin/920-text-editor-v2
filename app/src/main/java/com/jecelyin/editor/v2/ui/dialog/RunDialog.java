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
import android.support.v7.widget.LinearLayoutManager;
import android.text.TextUtils;
import android.view.View;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.android.file_explorer.util.MimeTypes;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.adapter.IntentChooserAdapter;
import com.jecelyin.editor.v2.ui.EditorDelegate;
import com.jecelyin.editor.v2.utils.SL4AIntentBuilders;
import com.jecelyin.editor.v2.widget.text.JsCallback;

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
        list.add(new Executor(R.string.share_menu, context.getString(R.string.share_menu)));
        list.add(new Executor(R.string.share_html_menu, context.getString(R.string.share_html_menu)));
    }

    @Override
    public void show() {
        int size = list.size();
        String[] items = new String[size];
        for (int i=0; i<size; i++) {
            items[i] = list.get(i).name;
        }
        try {
            MaterialDialog dlg = getDialogBuilder().items(items)
                    .title(R.string.call_external_app_or_share)
                    .positiveText(R.string.close)
                    .itemsCallback(new MaterialDialog.ListCallback() {
                        @Override
                        public void onSelection(MaterialDialog materialDialog, View view, int i, CharSequence charSequence) {
                            onItemClick(i);
                        }
                    })
                    .show();

            handleDialog(dlg);
        } catch (Exception e) {
            // android.view.WindowLeaked: Activity com.jecelyin.editor.v2.ui.MainActivity has leaked window com.android.internal.policy.impl.PhoneWindow$DecorView{65c348b8 V.E..... R......D 0,0-684,914} that was originally added here
        }
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
        final File file = new File(path);
        final Uri data = Uri.fromFile(file);
        final String fileName = file.getName();
        final String type = MimeTypes.getInstance().getMimeType(fileName);
        final Executor executor = list.get(i);
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
            case R.string.share_menu:
            case R.string.share_html_menu:
                EditorDelegate editorDelegate = getMainActivity().getTabManager().getEditorAdapter().getCurrentEditorDelegate();
                if (editorDelegate != null) {
                    final int id = executor.id;
                    editorDelegate.getText(new JsCallback<String>() {
                        @Override
                        public void onCallback(String text) {
                            if (id == R.string.share_html_menu && text != null && text.length() > 0) {
                                text = TextUtils.htmlEncode(text);
                                text = text.replace("\n", "<br/>\n");
                            }
                            Intent it = new Intent(Intent.ACTION_SEND);//注意调用it.setType会设置Data为null
                            it.setDataAndType(data, type); //注意调用it.setType会设置Data为null
                            it.putExtra(Intent.EXTRA_TITLE, fileName); //for youdaoNote
                            it.putExtra(Intent.EXTRA_TEXT, text); //for youdaoNote
                            it = Intent.createChooser(it, context.getString(R.string.share_menu));
                            getMainActivity().startActivity(it);
                        }
                    });
                }

                return;
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

        IntentChooserAdapter adapter = new IntentChooserAdapter(context, apps);
        adapter.setOnIntentItemSelectedListener(new IntentChooserAdapter.OnIntentItemSelectedListener() {
            @Override
            public void onItemSelected(ResolveInfo info) {
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
        });
        getDialogBuilder().adapter(adapter, new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false))
        .title(R.string.chooser_browser)
        .show();
    }
}
