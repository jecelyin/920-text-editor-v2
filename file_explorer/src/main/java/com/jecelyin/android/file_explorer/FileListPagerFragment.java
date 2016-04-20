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

package com.jecelyin.android.file_explorer;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.ActionMode;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jecelyin.android.file_explorer.adapter.FileListItemAdapter;
import com.jecelyin.android.file_explorer.adapter.PathButtonAdapter;
import com.jecelyin.android.file_explorer.databinding.FileExplorerFragmentBinding;
import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.io.RootFile;
import com.jecelyin.android.file_explorer.util.FileListSorter;
import com.jecelyin.common.app.JecFragment;
import com.jecelyin.common.listeners.OnCheckedChangeListener;
import com.jecelyin.common.listeners.OnItemClickListener;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor2.Pref;
import com.stericson.RootTools.RootTools;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.Arrays;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileListPagerFragment extends JecFragment implements SwipeRefreshLayout.OnRefreshListener, OnCheckedChangeListener, ActionMode.Callback, OnItemClickListener {
    private FileListItemAdapter adapter;
    private JecFile path;
    private FileExplorerFragmentBinding binding;
    private ActionMode actionMode;
    private String topPath;
    private PathButtonAdapter pathAdapter;
    private boolean isRoot;

    public static Fragment newFragment(JecFile path) {
        FileListPagerFragment f = new FileListPagerFragment();
        Bundle b = new Bundle();
        b.putParcelable("path", path);
        f.setArguments(b);
        return f;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        isRoot = Pref.getInstance(getContext()).isRootable();
        path = (JecFile) getArguments().getParcelable("path");
        topPath = path.getPath();
        binding = DataBindingUtil.inflate(inflater, R.layout.file_explorer_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        adapter = new FileListItemAdapter();
        adapter.setOnCheckedChangeListener(this);
        adapter.setOnItemClickListener(this);
        adapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                binding.emptyLayout.post(new Runnable() {
                    @Override
                    public void run() {
                        binding.emptyLayout.setVisibility(adapter.getItemCount() > 0 ? View.GONE : View.VISIBLE);
                    }
                });

            }
        });

        binding.pathScrollView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
        pathAdapter = new PathButtonAdapter();
        pathAdapter.setPath(path);
        pathAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                binding.pathScrollView.scrollToPosition(pathAdapter.getItemCount() - 1);
            }
        });
        pathAdapter.setOnItemClickListener(new OnItemClickListener() {
            @Override
            public void onItemClick(int position, View view) {
                JecFile file = pathAdapter.getItem(position);
                switchToPath(file);
            }
        });
        binding.pathScrollView.setAdapter(pathAdapter);

        binding.explorerSwipeRefreshLayout.setOnRefreshListener(this);
        binding.recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        binding.recyclerView.setAdapter(adapter);
        binding.recyclerView.addItemDecoration(new HorizontalDividerItemDecoration.Builder(getContext()).margin(getResources().getDimensionPixelSize(R.dimen.file_list_item_divider_left_margin), 0).build());
        binding.explorerSwipeRefreshLayout.post(new Runnable() {
            @Override
            public void run() {
                binding.explorerSwipeRefreshLayout.setRefreshing(true);
            }
        });
        binding.nameFilterEditText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                adapter.filter(s);
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        onRefresh();
    }

    @Override
    public void onRefresh() {
        if (isRoot && !path.canRead() && !(path instanceof RootFile)) {
            path = new RootFile(path.getPath());
        }
        Observable.create(new Observable.OnSubscribe<JecFile[]>() {
            @Override
            public void call(final Subscriber<? super JecFile[]> subscriber) {
                try {
                    path.listFiles(new JecFile.FileListResultListener() {
                        @Override
                        public void onResult(JecFile[] result) {
                            Arrays.sort(result, new FileListSorter());
                            subscriber.onNext(result);
                            subscriber.onCompleted();
                        }
                    });

                } catch (Exception e) {
                    subscriber.onError(e);
                }

            }
        })
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Subscriber<JecFile[]>() {
            @Override
            public void onCompleted() {
                binding.explorerSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onError(Throwable e) {
                binding.explorerSwipeRefreshLayout.setRefreshing(false);
                UIUtils.toast(getContext(), e);
            }

            @Override
            public void onNext(JecFile[] s) {
                adapter.setData(s);
            }
        });
    }

    @Override
    public void onCheckedChanged(int checkedCount, int position, boolean checked) {
        if(checkedCount > 0) {
            actionMode = getView().startActionMode(this);
            actionMode.setTitle(getString(R.string.selected_x_items, checkedCount));
        } else {
            if(actionMode != null)
                actionMode.finish();
        }
    }

    @Override
    public boolean onCreateActionMode(ActionMode mode, Menu menu) {
        return true;
    }

    @Override
    public boolean onPrepareActionMode(ActionMode mode, Menu menu) {
        return false;
    }

    @Override
    public boolean onActionItemClicked(ActionMode mode, MenuItem item) {
        return false;
    }

    @Override
    public void onDestroyActionMode(ActionMode mode) {

    }

    @Override
    public void onItemClick(int position, View view) {
        JecFile file = adapter.getItem(position);
        if(!((FileExplorerActivity)getActivity()).onSelectFile(file)) {
            if(file.isDirectory()) {
                switchToPath(file);
            }
        }
    }

    public boolean onBackPressed() {
        JecFile parent = path.getParentFile();
        if(parent == null || parent.getPath().startsWith(topPath)) {
            switchToPath(parent);
            return true;
        }
        return false;
    }

    private void switchToPath(JecFile file) {
        path = file;
        pathAdapter.setPath(file);
        onRefresh();
    }
}
