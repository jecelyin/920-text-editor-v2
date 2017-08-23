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

package com.jecelyin.editor.v2.preference;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.preference.ListPreference;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;

import com.afollestad.materialdialogs.MaterialDialog;
import com.afollestad.materialdialogs.prefs.MaterialListPreference;
import com.jecelyin.editor.v2.adapter.PreferenceAdapter;

import java.lang.reflect.Field;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class JecListPreference extends MaterialListPreference {
    private RecyclerView.Adapter adapter;

    public JecListPreference(Context context) {
        super(context);
    }

    public JecListPreference(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public JecListPreference(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public JecListPreference(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void showDialog(Bundle state) {
        super.showDialog(state);

        MaterialDialog dialog = (MaterialDialog) getDialog();
        if(adapter != null)
            dialog.getRecyclerView().setAdapter(adapter);
    }

    public void setAdapter(PreferenceAdapter adapter) {
        this.adapter = adapter;
        adapter.setOnItemClickListener(new PreferenceAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(RecyclerView.ViewHolder holder, int position) {
                if (position >= 0 && getEntryValues() != null) {
                    try {
                        Field clickedIndex = ListPreference.class.getDeclaredField("mClickedDialogEntryIndex");
                        clickedIndex.setAccessible(true);
                        clickedIndex.set(JecListPreference.this, position);
                        onClick(null, DialogInterface.BUTTON_POSITIVE);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    getDialog().dismiss();
                }
            }
        });
    }
}
