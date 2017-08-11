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

import android.content.Context;
import android.content.DialogInterface;
import android.support.annotation.NonNull;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.folderselector.FolderChooserDialog;
import com.jecelyin.common.utils.SysUtils;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.common.widget.DrawClickableEditText;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.ui.EditorDelegate;
import com.jecelyin.common.utils.DBHelper;
import com.jecelyin.editor.v2.utils.ExtGrep;
import com.jecelyin.editor.v2.utils.GrepBuilder;
import com.jecelyin.editor.v2.widget.text.JsCallback;
import com.rengwuxian.materialedittext.MaterialEditText;

import java.io.File;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FinderDialog extends AbstractDialog implements DrawClickableEditText.DrawableClickListener {
    private static final int ID_FIND_PREV = 1;
    private static final int ID_FIND_NEXT = 2;
    private static final int ID_REPLACE = 3;
    private static final int ID_REPLACE_ALL = 4;
    private static final int ID_FIND_TEXT = 5;
    /**
     * 0 = find
     * 1 = replace
     * 2 = find in files
     */
    int mode = 0;

    EditorDelegate fragment;

    CharSequence findText;

    public FinderDialog(Context context) {
        super(context);
    }

    public static void showFindDialog(EditorDelegate fragment) {
        final FinderDialog dialog = new FinderDialog(fragment.getContext());
        dialog.mode = 0;
        dialog.fragment = fragment;

        fragment.getSelectedText(new JsCallback<String>() {
            @Override
            public void onCallback(String selectedText) {
                dialog.findText = selectedText;
                dialog.show();
            }
        });
    }

    @Override
    public void show() {
        View view = LayoutInflater.from(context).inflate(R.layout.search_replace, null);

        final ViewHolder holder = new ViewHolder(view);
        holder.mFindEditText.setDrawableClickListener(this);
        holder.mReplaceEditText.setDrawableClickListener(this);
        if (findText != null)
            holder.mFindEditText.setText(findText.toString());
        if (Pref.getInstance(context).isReadOnly()) {
            holder.mReplaceCheckBox.setVisibility(View.GONE);
            holder.mReplaceEditText.setVisibility(View.GONE);
        } else {
            holder.mReplaceCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                @Override
                public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                    holder.mReplaceEditText.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                }
            });
            holder.mReplaceCheckBox.setChecked(mode == 1);
            holder.mReplaceEditText.setVisibility(mode == 1 ? View.VISIBLE : View.GONE);
        }

        holder.mPathLayout.setVisibility(mode == 2 ? View.VISIBLE : View.GONE);
        holder.mRecursivelyCheckBox.setVisibility(mode == 2 ? View.VISIBLE : View.GONE);
        holder.mInPathCheckBox.setChecked(mode == 2);
        holder.mInPathCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                holder.mPathLayout.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                holder.mRecursivelyCheckBox.setVisibility(isChecked ? View.VISIBLE : View.GONE);
                if(isChecked)
                    holder.mReplaceCheckBox.setChecked(false);
            }
        });
        getMainActivity().setFindFolderCallback(new FolderChooserDialog.FolderCallback() {
            @Override
            public void onFolderSelection(@NonNull FolderChooserDialog dialog, @NonNull File folder) {
                holder.mPathEditText.setText(folder.getPath());
            }
        });
        holder.mBrowserBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String path = Pref.getInstance(context).getLastOpenPath();
                if(! new File(path).isDirectory())
                    path = SysUtils.getInternalStorageDirectory();
                new FolderChooserDialog.Builder(getMainActivity())
                        .initialPath(path)
                        .cancelButton(android.R.string.cancel)
                        .chooseButton(android.R.string.ok)
                        .show();
            }
        });
        if(fragment.getPath() != null) {
            holder.mPathEditText.setText(new File(fragment.getPath()).getParent());
        }
        holder.mRegexCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    UIUtils.toast(context, R.string.use_regex_to_find_tip);
                }
            }
        });

        MaterialDialog dlg = getDialogBuilder().title(R.string.find_replace)
                .customView(view, false)
                .negativeText(R.string.close)
                .positiveText(R.string.find)
                .autoDismiss(false)
                .onNegative(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        dialog.dismiss();
                    }
                })
                .onPositive(new MaterialDialog.SingleButtonCallback() {
                    @Override
                    public void onClick(@NonNull MaterialDialog dialog, @NonNull DialogAction which) {
                        if (onFindButtonClick(holder)) {
                            dialog.dismiss();
                        }
                    }
                })
                .dismissListener(new DialogInterface.OnDismissListener() {
                    @Override
                    public void onDismiss(DialogInterface dialog) {
                        getMainActivity().setFindFolderCallback(null);
                    }
                })
                .show();

        handleDialog(dlg);
    }

    private boolean onFindButtonClick(ViewHolder holder) {
        //注意不要trim
        String findText = holder.mFindEditText.getText().toString();
        if(TextUtils.isEmpty(findText)) {
            holder.mFindEditText.setError(context.getString(R.string.cannot_be_empty));
            return false;
        }

        String replaceText = holder.mReplaceCheckBox.isChecked() ? holder.mReplaceEditText.getText().toString() : null;
        boolean findInFiles = holder.mInPathCheckBox.isChecked();
        String path = holder.mPathEditText.getText().toString().trim();
        if(findInFiles) {
            if(TextUtils.isEmpty(path)) {
                holder.mPathEditText.setError(context.getString(R.string.cannot_be_empty));
                return false;
            }
            if(!(new File(path).exists())) {
                holder.mPathEditText.setError(context.getString(R.string.path_not_exists));
                return false;
            }
        }

        GrepBuilder builder = GrepBuilder.start();
        boolean caseSensitive = holder.mCaseSensitiveCheckBox.isChecked();
        if (!caseSensitive) {
            builder.ignoreCase();
        }
        boolean wholeWordOnly = holder.mWholeWordsOnlyCheckBox.isChecked();
        if(wholeWordOnly) {
            builder.wordRegex();
        }
        boolean regex = holder.mRegexCheckBox.isChecked();
        builder.setRegex(findText, regex);
        if(findInFiles) {
            if(holder.mRecursivelyCheckBox.isChecked()) {
                builder.recurseDirectories();
            }
            builder.addFile(path);
        }

        ExtGrep grep = builder.build();

        DBHelper.getInstance(context).addFindKeyword(findText, false);
        DBHelper.getInstance(context).addFindKeyword(replaceText, true);

        if(findInFiles) {
            doInFiles(grep, replaceText);
        } else {
            fragment.mEditText.doFind(findText, replaceText, caseSensitive, wholeWordOnly, regex);
        }
        return true;
    }

    @Override
    public void onClick(DrawClickableEditText editText, DrawClickableEditText.DrawablePosition target) {
        new FindKeywordsDialog(context, editText, editText.getId() != R.id.find_edit_text).show();
    }

    private void doInFiles(ExtGrep grep, String replaceText) {
//        Intent intent = new Intent(context, FindInFileActivity.class);
//        intent.putExtra("grep", grep);
//        getMainActivity().startFileSelectorActivity(intent);
        getMainActivity().getTabManager().newTab(grep);
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'search_replace.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Inmite Developers (http://inmite.github.io)
     */
    static class ViewHolder {
        DrawClickableEditText mFindEditText;
        DrawClickableEditText mReplaceEditText;
        CheckBox mReplaceCheckBox;
        CheckBox mCaseSensitiveCheckBox;
        CheckBox mWholeWordsOnlyCheckBox;
        CheckBox mRegexCheckBox;
        CheckBox mInPathCheckBox;
        MaterialEditText mPathEditText;
        View mBrowserBtn;
        CheckBox mRecursivelyCheckBox;
        View mPathLayout;

        ViewHolder(View view) {
            mFindEditText = (DrawClickableEditText) view.findViewById(R.id.find_edit_text);
            mReplaceEditText = (DrawClickableEditText) view.findViewById(R.id.replace_edit_text);
            mReplaceCheckBox = (CheckBox) view.findViewById(R.id.replace_check_box);
            mCaseSensitiveCheckBox = (CheckBox) view.findViewById(R.id.case_sensitive_check_box);
            mWholeWordsOnlyCheckBox = (CheckBox) view.findViewById(R.id.whole_words_only_check_box);
            mRegexCheckBox = (CheckBox) view.findViewById(R.id.regex_check_box);
            mInPathCheckBox = (CheckBox) view.findViewById(R.id.in_path_check_box);
            mPathEditText = (MaterialEditText) view.findViewById(R.id.path_edit_text);
            mBrowserBtn = view.findViewById(R.id.browserBtn);
            mRecursivelyCheckBox = (CheckBox) view.findViewById(R.id.recursively_check_box);
            mPathLayout = view.findViewById(R.id.pathLayout);
        }
    }
}
