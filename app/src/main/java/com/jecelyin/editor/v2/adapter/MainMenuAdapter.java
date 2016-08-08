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

package com.jecelyin.editor.v2.adapter;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.jecelyin.common.widget.CheckableImageView;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.common.Command;
import com.jecelyin.editor.v2.ui.MenuManager;
import com.jecelyin.editor.v2.view.menu.MenuFactory;
import com.jecelyin.editor.v2.view.menu.MenuGroup;
import com.jecelyin.editor.v2.view.menu.MenuItemInfo;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class MainMenuAdapter extends RecyclerView.Adapter {
    private static final int ITEM_TYPE_GROUP = 1;
    private final List<MenuItemInfo> menuItems;
    private final LayoutInflater inflater;
    private MenuItem.OnMenuItemClickListener menuItemClickListener;

    public MainMenuAdapter(Context context) {
        inflater = LayoutInflater.from(context);

        MenuFactory menuFactory = MenuFactory.getInstance(context);
        MenuGroup[] groups = MenuGroup.values();
        menuItems = new ArrayList<MenuItemInfo>();

        for (MenuGroup group : groups) {
            if(group.getNameResId() == 0)
                continue; //top group
            menuItems.add(new MenuItemInfo(group, 0, Command.CommandEnum.NONE, 0, 0));
            menuItems.addAll(menuFactory.getMenuItemsWithoutToolbarMenu(group));
        }
    }

    public void setMenuItemClickListener(MenuItem.OnMenuItemClickListener menuItemClickListener) {
        this.menuItemClickListener = menuItemClickListener;
    }

    @Override
    public int getItemViewType(int position) {
        return menuItems.get(position).getItemId() == 0 ? ITEM_TYPE_GROUP : super.getItemViewType(position);
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        if (viewType == ITEM_TYPE_GROUP) {
            return new GroupViewHolder(inflater.inflate(R.layout.main_menu_group, parent, false));
        } else {
            return new ItemViewHolder(inflater.inflate(R.layout.main_menu_item, parent, false));
        }
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        final MenuItemInfo item = menuItems.get(position);
        if(holder instanceof ItemViewHolder) {
            final ItemViewHolder vh = (ItemViewHolder)holder;
            vh.mTextView.setText(item.getTitleResId());
            Drawable icon = MenuManager.makeMenuNormalIcon(vh.itemView.getResources(), item.getIconResId());
            vh.mTextView.setCompoundDrawablesWithIntrinsicBounds(icon, null, null, null);
            vh.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(menuItemClickListener != null) {
                        menuItemClickListener.onMenuItemClick(item);
                        if(MenuFactory.isCheckboxMenu(item.getItemId())) {
                            vh.mCheckBox.setChecked(!vh.mCheckBox.isChecked());
                        }
                    }
                }
            });
            if(MenuFactory.isCheckboxMenu(item.getItemId())) {
                vh.mCheckBox.setVisibility(View.VISIBLE);
                vh.mCheckBox.setChecked(MenuFactory.isChecked(vh.itemView.getContext(), item.getItemId()));
            } else {
                vh.mCheckBox.setVisibility(View.GONE);
            }
        } else {
            GroupViewHolder vh = (GroupViewHolder)holder;
            vh.mNameTextView.setText(item.getGroup().getNameResId());
        }
    }

    @Override
    public int getItemCount() {
        return menuItems == null ? 0 : menuItems.size();
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'main_menu_item.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class ItemViewHolder extends RecyclerView.ViewHolder {
        TextView mTextView;
        CheckableImageView mCheckBox;

        ItemViewHolder(View view) {
            super(view);
            mTextView = (TextView) view.findViewById(R.id.textView);
            mCheckBox = (CheckableImageView) view.findViewById(R.id.checkbox);
        }
    }

    /**
     * This class contains all butterknife-injected Views & Layouts from layout file 'main_menu_group.xml'
     * for easy to all layout elements.
     *
     * @author ButterKnifeZelezny, plugin for Android Studio by Avast Developers (http://github.com/avast)
     */
    static class GroupViewHolder extends RecyclerView.ViewHolder {
        TextView mNameTextView;

        GroupViewHolder(View view) {
            super(view);
            mNameTextView = (TextView) view.findViewById(R.id.nameTextView);
        }
    }
}
