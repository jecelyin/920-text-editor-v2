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
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.v7.view.ActionMode;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import com.afollestad.materialdialogs.DialogAction;
import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.folderselector.FolderChooserDialog;
import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.common.widget.DrawClickableEditText;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.ui.EditorDelegate;
import com.jecelyin.editor.v2.utils.DBHelper;
import com.jecelyin.editor.v2.utils.ExtGrep;
import com.jecelyin.editor.v2.utils.GrepBuilder;
import com.jecelyin.editor.v2.utils.MatcherResult;
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
        FinderDialog dialog = new FinderDialog(fragment.getContext());
        dialog.mode = 0;
        dialog.fragment = fragment;
        dialog.findText = fragment.getSelectedText();
        dialog.show();
    }

    public static void showReplaceDialog(EditorDelegate fragment) {
        FinderDialog dialog = new FinderDialog(fragment.getContext());
        dialog.mode = 1;
        dialog.fragment = fragment;
        dialog.findText = fragment.getSelectedText();
        dialog.show();
    }

    public static void showFindInFilesDialog(EditorDelegate fragment) {
        FinderDialog dialog = new FinderDialog(fragment.getContext());
        dialog.mode = 2;
        dialog.fragment = fragment;
        dialog.findText = fragment.getSelectedText();
        dialog.show();
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
                    path = Environment.getExternalStorageDirectory().getPath();
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
        if (!holder.mCaseSensitiveCheckBox.isChecked()) {
            builder.ignoreCase();
        }
        if(holder.mWholeWordsOnlyCheckBox.isChecked()) {
            builder.wordRegex();
        }
        builder.setRegex(findText, holder.mRegexCheckBox.isChecked());
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
            findNext(grep, replaceText);
        }
        return true;
    }

    private void findNext(final ExtGrep grep, final String replaceText) {
        grep.grepText(ExtGrep.GrepDirect.NEXT,
                fragment.getEditableText(),
                fragment.getCursorOffset(),
                new TaskListener<MatcherResult>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onSuccess(MatcherResult match) {
                        if (match == null) {
                            UIUtils.toast(context, R.string.find_not_found);
                            return;
                        }
                        fragment.addHightlight(match.start(), match.end());
                        getMainActivity().startSupportActionMode(new FindTextActionModeCallback(replaceText, fragment, grep, match));
                    }

                    @Override
                    public void onError(Exception e) {
                        L.e(e);
                        UIUtils.toast(context, e.getMessage());
                    }
                }
        );
    }

    @Override
    public void onClick(DrawClickableEditText editText, DrawClickableEditText.DrawablePosition target) {
        new FindKeywordsDialog(context, editText, editText.getId() != R.id.find_edit_text).show();
    }

    private static class FindTextActionModeCallback implements ActionMode.Callback {
        private String replaceText;
        EditorDelegate fragment;
        ExtGrep grep;
        private MatcherResult lastResults;

        public FindTextActionModeCallback(String replaceText, EditorDelegate fragment, ExtGrep grep, MatcherResult match) {
            this.replaceText = replaceText;
            this.fragment = fragment;
            this.grep = grep;
            this.lastResults = match;
        }

        @Override
        public boolean onCreateActionMode(ActionMode actionMode, Menu menu) {
            actionMode.setTitle(null);
            actionMode.setSubtitle(null);

            View view = LayoutInflater.from(fragment.getContext()).inflate(R.layout.search_replace_action_mode_layout, null);
            int w = fragment.getContext().getResources().getDimensionPixelSize(R.dimen.cab_find_text_width);
            view.setLayoutParams(new ViewGroup.LayoutParams(w, ViewGroup.LayoutParams.MATCH_PARENT));

            TextView searchTextView = (TextView) view.findViewById(R.id.searchTextView);
            searchTextView.setText(grep.getRegex());

            TextView replaceTextView = (TextView) view.findViewById(R.id.replaceTextView);
            if (replaceText == null) {
                replaceTextView.setVisibility(View.GONE);
            } else {
                replaceTextView.setText(replaceText);
            }

            menu.add(0, ID_FIND_TEXT, 0, R.string.keyword)
                    .setActionView(view)
                    .setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);

            menu.add(0, ID_FIND_PREV, 0, R.string.previous_occurrence)
                    .setIcon(R.drawable.up)
                    .setAlphabeticShortcut('p')
                    .setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

            menu.add(0, ID_FIND_NEXT, 0, R.string.next_occurrence)
                    .setIcon(R.drawable.down)
                    .setAlphabeticShortcut('n')
                    .setShowAsAction(
                            MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);

            if(replaceText != null) {
                menu.add(0, ID_REPLACE, 0, R.string.replace)
                        .setIcon(R.drawable.replace)
                        .setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
                menu.add(0, ID_REPLACE_ALL, 0, R.string.replace_all)
                        .setIcon(R.drawable.replace_all)
                        .setShowAsAction(
                                MenuItem.SHOW_AS_ACTION_ALWAYS | MenuItem.SHOW_AS_ACTION_WITH_TEXT);
            }
            return true;
        }

        @Override
        public boolean onPrepareActionMode(ActionMode actionMode, Menu menu) {
            return true;
        }

        @Override
        public boolean onActionItemClicked(ActionMode actionMode, MenuItem menuItem) {
            if (TextUtils.isEmpty(grep.getRegex())) {
                UIUtils.toast(fragment.getContext(), R.string.find_keyword_is_empty);
                return false;
            }
            int id = menuItem.getItemId();
            switch (id) {
                case ID_FIND_PREV:
                case ID_FIND_NEXT:
                    doFind(id);
                    break;
                case ID_REPLACE:
                    if(lastResults != null) {
                        fragment.getEditableText().replace(lastResults.start(), lastResults.end(), ExtGrep.parseReplacement(lastResults, replaceText));
                        lastResults = null;
                    }
                    break;
                case ID_REPLACE_ALL:
                    grep.replaceAll(fragment.getEditableText(), replaceText);
                    break;
                default:
                    return false;
            }
            return true;
        }

        private void doFind(int id) {
            id = id == ID_FIND_PREV ? ID_FIND_PREV : ID_FIND_NEXT;
            grep.grepText(id == ID_FIND_PREV ? ExtGrep.GrepDirect.PREV : ExtGrep.GrepDirect.NEXT,
                    fragment.getEditableText(),
                    fragment.getCursorOffset(),
                    new TaskListener<MatcherResult>() {
                        @Override
                        public void onCompleted() {

                        }

                        @Override
                        public void onSuccess(MatcherResult match) {
                            if (match == null) {
                                UIUtils.toast(fragment.getContext(), R.string.find_not_found);
                                return;
                            }
                            fragment.addHightlight(match.start(), match.end());
                            lastResults = match;
                        }

                        @Override
                        public void onError(Exception e) {
                            L.e(e);
                            UIUtils.toast(fragment.getContext(), e.getMessage());
                        }
                    });
        }

        @Override
        public void onDestroyActionMode(ActionMode actionMode) {

        }
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
