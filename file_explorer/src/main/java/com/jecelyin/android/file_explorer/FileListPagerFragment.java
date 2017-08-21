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

import android.content.Context;
import android.content.SharedPreferences;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.os.Environment;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.view.ActionMode;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import com.jecelyin.android.file_explorer.adapter.FileListItemAdapter;
import com.jecelyin.android.file_explorer.adapter.PathButtonAdapter;
import com.jecelyin.android.file_explorer.databinding.FileExplorerFragmentBinding;
import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.io.LocalFile;
import com.jecelyin.android.file_explorer.io.RootFile;
import com.jecelyin.android.file_explorer.listener.FileListResultListener;
import com.jecelyin.android.file_explorer.listener.OnClipboardPasteFinishListener;
import com.jecelyin.android.file_explorer.util.FileListSorter;
import com.jecelyin.common.app.JecFragment;
import com.jecelyin.common.listeners.OnItemClickListener;
import com.jecelyin.common.listeners.OnResultCallback;
import com.jecelyin.common.task.JecAsyncTask;
import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.task.TaskResult;
import com.jecelyin.common.utils.DBHelper;
import com.jecelyin.common.utils.RootShellRunner;
import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.common.utils.command.ShellDaemon;
import com.jecelyin.editor.v2.Pref;
import com.yqritc.recyclerviewflexibledivider.HorizontalDividerItemDecoration;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileListPagerFragment extends JecFragment implements SwipeRefreshLayout.OnRefreshListener, OnItemClickListener, FileExplorerView, ExplorerContext, SharedPreferences.OnSharedPreferenceChangeListener {
    private FileListItemAdapter adapter;
    private JecFile path;
    private FileExplorerFragmentBinding binding;
    private PathButtonAdapter pathAdapter;
    private boolean isRoot;
    private ScanFilesTask task;
    private FileExplorerAction action;

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
        path = (JecFile) getArguments().getParcelable("path");
        binding = DataBindingUtil.inflate(inflater, R.layout.file_explorer_fragment, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        action = new FileExplorerAction(getContext(), this, ((FileExplorerActivity)getActivity()).getFileClipboard(), this);
        adapter = new FileListItemAdapter();
        adapter.setOnCheckedChangeListener(action);
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
        pathAdapter.registerAdapterDataObserver(new RecyclerView.AdapterDataObserver() {
            @Override
            public void onChanged() {
                binding.pathScrollView.scrollToPosition(pathAdapter.getItemCount() - 1);
            }
        });
        pathAdapter.setPath(path);
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

        binding.recentPathBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                RecentPathsMenu menu = new RecentPathsMenu(getContext(), v);
                menu.setOnPathSelectListener(new RecentPathsMenu.OnPathSelectListener() {
                    @Override
                    public void onSelect(String path) {
                        switchToPath(new LocalFile(path));
                    }
                });
                menu.show();
            }
        });

        Pref.getInstance(getContext()).registerOnSharedPreferenceChangeListener(this);

        if (Pref.getInstance(getContext()).isRootEnabled()) {
            new RootShellRunner().isRootAvailable(new OnResultCallback<Boolean>() {
                @Override
                public void onError(String error) {
                    onRefresh();
                }

                @Override
                public void onSuccess(Boolean result) {
                    if (getActivity() == null)
                        return;

                    isRoot = result;
                    onRefresh();
                }
            });
        } else {
            isRoot = false;
            onRefresh();
        }
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Pref.getInstance(getContext()).unregisterOnSharedPreferenceChangeListener(this);
        if (action != null) {
            action.destroy();
        }
        ShellDaemon.getShell().reset();
    }

    @Override
    public void onStop() {
        super.onStop();
        // 不能加在onPause，因为请求Root UI会导致pause
        if (task != null) {
            task.cancel(true);
            task = null;
        }
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.paste_menu) {
            final FileClipboard fileClipboard = ((FileExplorerActivity) getActivity()).getFileClipboard();
            fileClipboard.paste(getContext(), getCurrentDirectory(), new OnClipboardPasteFinishListener() {
                @Override
                public void onFinish(int count, String error) {
                    onRefresh();
                    fileClipboard.showPasteResult(getContext(), count, error);
                }
            });
            item.setVisible(false);
        } else if (item.getItemId() == R.id.add_folder_menu) {
            action.doCreateFolder();
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onRefresh() {
        UpdateRootInfo updateRootInfo = new UpdateRootInfo() {

            @Override
            public void onUpdate(JecFile f) {
                path = f;
            }
        };
        task = new ScanFilesTask(getActivity(), path, isRoot, updateRootInfo);
        task.setTaskListener(new TaskListener<JecFile[]>() {
            @Override
            public void onCompleted() {
                if (binding.explorerSwipeRefreshLayout != null)
                    binding.explorerSwipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onSuccess(JecFile[] result) {
                if (adapter != null) {
                    pathAdapter.setPath(path);
                    adapter.setData(result);
                    Pref.getInstance(getContext()).setLastOpenPath(path.getPath());
                    DBHelper.getInstance(getContext()).addRecentPath(path.getPath());
                }

            }

            @Override
            public void onError(Exception e) {
                if (binding.explorerSwipeRefreshLayout == null)
                    return;
                binding.explorerSwipeRefreshLayout.setRefreshing(false);
                final String storage = Environment.getExternalStorageDirectory().getPath();
                UIUtils.showConfirmDialog(getContext()
                        , null
                        , getString(R.string.error_occurred_x, e.getMessage())
                        , new UIUtils.OnClickCallback() {
                            @Override
                            public void onOkClick() {
                                switchToPath(new LocalFile(storage));
                            }
                        }
                        , getString(R.string.goto_x, storage)
                        , getString(android.R.string.cancel)
                );
            }
        });
        task.execute();
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

    private void switchToPath(JecFile file) {
        path = file;

        onRefresh();
    }

    @Override
    public ActionMode startActionMode(ActionMode.Callback callback) {
        return ((AppCompatActivity)getActivity()).startSupportActionMode(callback);
    }

    @Override
    public void setSelectAll(boolean checked) {
        adapter.checkAll(checked);
    }

    @Override
    public void refresh() {
        onRefresh();
    }

    @Override
    public void finish() {
        getActivity().finish();
    }

    @Override
    public JecFile getCurrentDirectory() {
        return path;
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        if (!key.equals(Pref.KEY_LAST_OPEN_PATH))
            onRefresh();
    }

    private static interface UpdateRootInfo {
        public void onUpdate(JecFile path);
    }

    private static class ScanFilesTask extends JecAsyncTask<Void, Void, JecFile[]> {
        private final UpdateRootInfo updateRootInfo;
        private JecFile path;
        private boolean isRoot;
        private final Context context;

        private ScanFilesTask(Context context, JecFile path, boolean isRoot, UpdateRootInfo updateRootInfo) {
            this.context = context.getApplicationContext();
            this.path = path;
            this.isRoot = isRoot;
            this.updateRootInfo = updateRootInfo;
        }

        @Override
        protected void onRun(final TaskResult<JecFile[]> taskResult, Void... params) throws Exception {

            if (!(path instanceof RootFile) && (isRoot || RootShellRunner.isRootPath(path.getPath()))) {
                RootFile.obtain(path.getPath(), new OnResultCallback<RootFile>() {
                    @Override
                    public void onError(String error) {
                        updateList(taskResult);
                    }

                    @Override
                    public void onSuccess(RootFile result) {
                        path = result;
                        updateList(taskResult);
                    }
                });
            } else {
                updateList(taskResult);
            }
        }

        private void updateList(final TaskResult<JecFile[]> taskResult) {
            Pref pref = Pref.getInstance(context);
            final boolean showHiddenFiles = pref.isShowHiddenFiles();
            final int sortType = pref.getFileSortType();
            updateRootInfo.onUpdate(path);
            path.listFiles(new FileListResultListener() {
                @Override
                public void onResult(JecFile[] result) {
                    if (result == null || result.length == 0) {
                        taskResult.setResult(result);
                        return;
                    }
                    if (!showHiddenFiles) {
                        List<JecFile> list = new ArrayList<>(result.length);
                        for (JecFile file : result) {
                            if (file.getName().charAt(0) == '.') {
                                continue;
                            }
                            list.add(file);
                        }
                        result = new JecFile[list.size()];
                        list.toArray(result);
                    }
                    Arrays.sort(result, new FileListSorter(true, sortType, true));
                    taskResult.setResult(result);
                }

                @Override
                public void onError(String error) {
                    taskResult.setError(new Exception(error));
                }
            });
        }
    }
}
