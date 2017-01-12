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
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.afollestad.materialdialogs.MaterialDialog;
import com.jecelyin.editor.v2.R;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Locale;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class InsertDateTimeDialog extends AbstractDialog implements AdapterView.OnItemClickListener {

    private static final String[] english = new String[]{
            "yyyy-MM-dd HH:mm:ss",
            "yyyy-MM-dd",
            "dd/MM/yyyy",
            "dd/MM/yy",
            "d/M/yy",
            "d.M.yy",
            "dd-MMM-yyyy",
            "MMMM dd, yyyy",
            "M/d/yy HH:mm",
            "M/d/yy K:m a",
            "HH:mm:ss",
            "H:m:s",
            "K:mm:ss a",
            "H:m a"
    };
    private static final String[] chinese = new String[]{
            "yyyy年M月d日 EEEE",
            "yyyy年M月d日 HH:mm EEEE",
            "yyyy年M月d日",
            "'EEEE'年'O'月",
            "'O'月'A'日",
            "'EEEE'年'O'月'A'日",
            "yyyy/M/d",
            "yyyy/M/d K:m a",
            "yyyy/M/d HH:mm",
            "H时m分s秒",
            "K时m分s秒 a",
    };
    private MaterialDialog dialog;

    public InsertDateTimeDialog(Context context) {
        super(context);
    }

    @Override
    public void show() {
        dialog = getDialogBuilder()
                .title(R.string.insert_datetime)
                .positiveText(R.string.close)
                .customView(R.layout.insert_datetime_layout, false)
                .show();
        handleDialog(dialog);
        View view = dialog.getCustomView();

        Spinner langSpinner = (Spinner) view.findViewById(R.id.langSpinner);
        ListView formatListView = (ListView) view.findViewById(R.id.formatListView);

        Date date = new Date();
        SimpleDateFormat usDateFormat = new SimpleDateFormat("a", Locale.US);
        SimpleDateFormat cnDateFormat = new SimpleDateFormat("a", Locale.CHINA);

        final ArrayList<CharSequence> englishList = new ArrayList<CharSequence>(english.length);
        for(String format : english) {
            usDateFormat.applyPattern(format);
            englishList.add(usDateFormat.format(date));
        }
        final ArrayList<CharSequence> chineseList = new ArrayList<CharSequence>(chinese.length);
        for(String format : chinese) {
            cnDateFormat.applyPattern(format);
            chineseList.add(convertFormat(context, cnDateFormat, date, cnDateFormat.format(date)));
        }

        final ArrayAdapter<CharSequence> adapter = new ArrayAdapter<CharSequence>(context, R.layout.dialog_list_item, R.id.title, (ArrayList<CharSequence>)englishList.clone());
        adapter.setNotifyOnChange(false);
        formatListView.setAdapter(adapter);
        formatListView.setOnItemClickListener(this);
        adapter.notifyDataSetChanged();

        langSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                adapter.clear();
                if (position == 1) {
                    adapter.addAll(chineseList);
                } else {
                    adapter.addAll(englishList);
                }
                adapter.notifyDataSetChanged();
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }

    private static String convertFormat(Context context, SimpleDateFormat sdf, Date date, String text) {
        if (text.contains("EEEE")) {
            sdf.applyPattern("yyyy");
            String year = sdf.format(date);
            text = text.replace("EEEE", convertNumber(context, year));
        }
        if (text.contains("A")) {
            sdf.applyPattern("d");
            String day = sdf.format(date);
            text = text.replace("A", convertNumber(context, day));
        }
        if (text.contains("O")) {
            sdf.applyPattern("M");
            String day = sdf.format(date);
            text = text.replace("O", convertNumber(context, day));
        }
        return text;
    }

    private static String convertNumber(Context context, String number) {
        String[] numArr = context.getResources().getStringArray(R.array.date_number);
        int length = number.length();
        char c;
        StringBuilder sb = new StringBuilder();
        for (int i=0; i<length; i++) {
            c = number.charAt(i);
            if(c >= '0' && c <= '9') {
                sb.append(numArr[c-'0']);
            } else {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        dialog.dismiss();
        getMainActivity().insertText(((TextView)view).getText().toString());
        dialog = null;
    }
}
