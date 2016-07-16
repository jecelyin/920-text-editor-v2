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

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.BaseActivity;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.adapter.FindInFilesAdapter;
import com.jecelyin.editor.v2.utils.ExtGrep;

import java.util.List;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FindInFileActivity extends BaseActivity implements AdapterView.OnItemClickListener {
    ListView mList;
    ProgressBar mProgressView;
    TextView mLoadingTextView;
    LinearLayout mLoadingLayout;
    TextView mErrorMsgTextView;
    Button mTryBtn;
    FrameLayout mErrorLayout;
    Toolbar mToolbar;
    TextView mEmptyTextView;

    private ExtGrep grep;
    private FindInFilesAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.find_in_files_activity);

        mList = (ListView) findViewById(android.R.id.list);
        mProgressView = (ProgressBar) findViewById(R.id.progress_view);
        mLoadingTextView = (TextView) findViewById(R.id.loading_text_view);
        mLoadingLayout = (LinearLayout) findViewById(R.id.loading_layout);
        mErrorMsgTextView = (TextView) findViewById(R.id.error_msg_textView);
        mTryBtn = (Button) findViewById(R.id.try_btn);
        mErrorLayout = (FrameLayout) findViewById(R.id.error_layout);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        mEmptyTextView = (TextView) findViewById(R.id.emptyLayout);

        mTryBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                find();
            }
        });

        setSupportActionBar(mToolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mLoadingTextView.setText(R.string.searching);

        adapter = new FindInFilesAdapter();
        mList.setEmptyView(mEmptyTextView);
        mList.setAdapter(adapter);
        mList.setOnItemClickListener(this);

        Intent intent = getIntent();
        grep = intent.getParcelableExtra("grep");
        adapter.setFindFiles(grep.getFilesToProcess());

        find();
    }

    private void find() {
        grep.execute(new TaskListener<List<ExtGrep.Result>>() {
            @Override
            public void onCompleted() {
                mLoadingLayout.setVisibility(View.GONE);
                mErrorLayout.setVisibility(View.GONE);
            }

            @Override
            public void onSuccess(List<ExtGrep.Result> result) {
                mList.setVisibility(result.isEmpty() ? View.GONE : View.VISIBLE);
                adapter.setResults(result);
            }

            @Override
            public void onError(Exception e) {
                mLoadingLayout.setVisibility(View.GONE);
                mList.setVisibility(View.GONE);
                mErrorMsgTextView.setText(e.getMessage());
                mErrorLayout.setVisibility(View.VISIBLE);
                L.e(e);
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        ExtGrep.Result item = adapter.getItem(position);
        setResult(RESULT_OK, MainActivity.getOpenFileIntent(item.file, item.startOffset));
        finish();
    }
}
