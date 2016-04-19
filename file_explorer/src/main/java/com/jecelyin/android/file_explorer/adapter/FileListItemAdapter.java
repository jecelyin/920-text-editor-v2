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

package com.jecelyin.android.file_explorer.adapter;

import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.text.TextUtils;
import android.util.SparseIntArray;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.jecelyin.android.file_explorer.R;
import com.jecelyin.android.file_explorer.databinding.FileListItemBinding;
import com.jecelyin.android.file_explorer.io.JecFile;
import com.jecelyin.android.file_explorer.model.FileItemModel;
import com.jecelyin.android.file_explorer.util.MimeTypes;
import com.jecelyin.common.adapter.BindingViewHolder;
import com.jecelyin.common.listeners.OnCheckedChangeListener;
import com.jecelyin.common.listeners.OnItemClickListener;
import com.jecelyin.common.utils.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class FileListItemAdapter extends RecyclerView.Adapter<BindingViewHolder<FileListItemBinding>> {
    private JecFile[] data;
    private final String year;
    private final SparseIntArray checkedArray;
    private OnCheckedChangeListener onCheckedChangeListener;
    private OnItemClickListener onItemClickListener;
    private JecFile[] mOriginalValues;
    private int itemCount;

    public FileListItemAdapter() {
//        year = String.valueOf(new Date().getYear());
        year = String.valueOf(Calendar.getInstance().get(Calendar.YEAR));
        checkedArray = new SparseIntArray();
    }

    public void setData(JecFile[] data) {
        this.data = data;
        itemCount = data.length;
        mOriginalValues = data.clone();
        notifyDataSetChanged();
    }

    public void filter(CharSequence filterText) {
        if (mOriginalValues == null)
            return;

        if (TextUtils.isEmpty(filterText)) {
            data = mOriginalValues;
            itemCount = mOriginalValues.length;
            notifyDataSetChanged();
            return;
        }

        data = new JecFile[mOriginalValues.length];

        filterText = filterText.toString().toLowerCase();
        int index = 0;
        for(JecFile path : mOriginalValues) {
            if (path.getName().toLowerCase().contains(filterText)) {
                data[index++] = path;
            }
        }
        itemCount = index;
        notifyDataSetChanged();
    }

    public JecFile getItem(int position) {
        return data[position];
    }

    public void setOnCheckedChangeListener(OnCheckedChangeListener onCheckedChangeListener) {
        this.onCheckedChangeListener = onCheckedChangeListener;
    }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    @Override
    public int getItemCount() {
        return itemCount;
    }

    @Override
    public BindingViewHolder<FileListItemBinding> onCreateViewHolder(ViewGroup parent, int viewType) {
        FileListItemBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.file_list_item, parent, false);

        return new BindingViewHolder<>(binding);
    }

    @Override
    public void onBindViewHolder(final BindingViewHolder<FileListItemBinding> holder, final int position) {
        JecFile path = data[position];

        MimeTypes mimeTypes = MimeTypes.getInstance();
        Resources res = holder.itemView.getResources();
        int color, icon;
        if (path.isDirectory()) {
            color = R.color.type_folder;
            icon = R.drawable.file_type_folder;

        } else if (mimeTypes.isImageFile(path)) {
            color = R.color.type_media;
            icon = R.drawable.file_type_image;

        } else if (mimeTypes.isVideoFile(path)) {
            color = R.color.type_media;
            icon = R.drawable.file_type_video;

        } else if (mimeTypes.isAudioFile(path)) {
            color = R.color.type_media;
            icon = R.drawable.file_type_audio;

        } else if (mimeTypes.isAPKFile(path)) {
            color = R.color.type_apk;
            icon = R.drawable.file_type_apk;

        } else if (mimeTypes.isArchive(path)) {
            color = R.color.type_archive;
            icon = R.drawable.file_type_archive;

        } else if (mimeTypes.isCodeFile(path)) {
            color = R.color.type_code;
            icon = R.drawable.file_type_code;

        } else if (mimeTypes.isTextFile(path)) {
            color = R.color.type_text;
            icon = R.drawable.file_type_text;

        } else {
            color = R.color.type_file;
            icon = TextUtils.isEmpty(path.getExtension()) ? R.drawable.file_type_file : 0;
        }

        FileListItemBinding binding = holder.getBinding();
        binding.iconImageView.setImageResource(icon);
        binding.iconImageView.setBackgroundColor(res.getColor(color));

        FileItemModel item = new FileItemModel();
        item.setName(path.getName());
        item.setExt(icon == 0 && color == R.color.type_file ? path.getExtension() : "");
        item.setDate(getDate(path.lastModified()));
        item.setSecondLine(path.isFile() ? StringUtils.formatSize(path.length()) : "");
        binding.setItem(item);

        binding.iconImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                toggleChecked(position, holder);
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                toggleChecked(position, holder);
                return true;
            }
        });
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(checkedArray != null && checkedArray.size() > 0) {
                    toggleChecked(position, holder);
                    return;
                }
                if(onItemClickListener != null)
                    onItemClickListener.onItemClick(position, v);
            }
        });
    }

    private void toggleChecked(int position, BindingViewHolder<FileListItemBinding> holder) {
        FileListItemBinding binding = holder.getBinding();
        boolean isChecked = isChecked(position);

        ImageSwap.swap(binding.iconImageView, isChecked);

        if(isChecked) {
            binding.getRoot().setBackgroundResource(R.drawable.white_selectable_item_background);
            binding.extTextView.setVisibility(View.VISIBLE);
            checkedArray.delete(position);
        } else {
            binding.getRoot().setBackgroundResource(R.drawable.gray_seletable_item_background);
            binding.extTextView.setVisibility(View.INVISIBLE);
            checkedArray.put(position, 1);
        }

        if(onCheckedChangeListener != null)
            onCheckedChangeListener.onCheckedChanged(checkedArray.size(), position, isChecked);
    }

    public boolean isChecked(int position) {
        return checkedArray.get(position) == 1;
    }

    private String getDate(long f) {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        String date = (sdf.format(f));
        if (date.substring(0, 4).equals(year))
            date = date.substring(5);
        return date;
    }

    static class ImageSwap {
        Drawable image;
        Drawable background;

        public static void swap(ImageView iv, boolean isChecked) {
            ImageSwap is = (ImageSwap) iv.getTag();
            if(is == null) {
                is = new ImageSwap();
                iv.setTag(is);
            } else {
                is = (ImageSwap) iv.getTag();
            }
            if(!isChecked) {
                is.image = iv.getDrawable();
                is.background = iv.getBackground();

                iv.setImageResource(R.drawable.file_checked);
                iv.setBackgroundColor(iv.getResources().getColor(R.color.item_icon_select_status));
            } else {
                iv.setImageDrawable(is.image);
                iv.setBackground(is.background);
            }
        }
    }
}
