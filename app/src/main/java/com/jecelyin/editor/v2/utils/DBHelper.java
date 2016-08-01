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

package com.jecelyin.editor.v2.utils;

import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import java.util.ArrayList;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class DBHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "920-text-editor.db";
    private static final int DATABASE_VERSION = 3; // Version must be >= 1

    public static DBHelper getInstance(Context context) {
        return new DBHelper(context.getApplicationContext());
    }

    public DBHelper(Context context) {
        this(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null);
    }

    public DBHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"recent_files\" (\n" +
                "\t \"path\" TEXT NOT NULL,\n" +
                "\t \"open_time\" integer,\n" +
                "\t \"encoding\" TEXT,\n" +
                "\t \"offset\" integer,\n" +
                "\t \"last_open\" integer,\n" +
                "\tPRIMARY KEY(\"path\")\n" +
                ")");
        db.execSQL("CREATE INDEX \"open_time\" ON recent_files (\"open_time\" DESC)");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        if(oldVersion == 1 && newVersion == 2) {
            db.execSQL("alter table recent_files ADD COLUMN encoding TEXT");
        } else if(oldVersion == 2 && newVersion == 3) {
            db.execSQL("alter table recent_files ADD COLUMN offset integer");
            db.execSQL("alter table recent_files ADD COLUMN last_open integer");
        }
    }

    public void addRecentFile(String path, String encoding) {
        if (TextUtils.isEmpty(path))
            return;
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("REPLACE INTO recent_files VALUES (?, ?, ?, ?, ?)", new Object[]{path, System.currentTimeMillis(), encoding, 0, 1});
        db.close();
    }

    public void updateRecentFile(String path, boolean lastOpen) {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("UPDATE recent_files SET last_open = ? WHERE path = ?", new Object[]{lastOpen ? 1 : 0, path});
        db.close();
    }

    public void updateRecentFile(String path, String encoding, int offset) {
        SQLiteDatabase db = getWritableDatabase();
        if (offset >= 0)
            db.execSQL("UPDATE recent_files SET encoding = ?, offset = ? WHERE path = ?", new Object[]{encoding, offset, path});
        else
            db.execSQL("UPDATE recent_files SET encoding = ? WHERE path = ?", new Object[]{encoding, path});
        db.close();
    }

    public static class RecentFileItem {
        public long time;
        public String path;
        public String encoding;
        public int offset;
        public boolean isLastOpen;
    }

    public ArrayList<RecentFileItem> getRecentFiles() {
        return getRecentFiles(false);
    }

    public ArrayList<RecentFileItem> getRecentFiles(boolean lastOpenFiles) {
        ArrayList<RecentFileItem> list = new ArrayList<RecentFileItem>(30);
        SQLiteDatabase db = getReadableDatabase();
        Cursor cursor = db.query("recent_files", null, null, null, null, null, lastOpenFiles ? "open_time asc" : "open_time desc", "30");
        RecentFileItem item;
        boolean isLastOpen;
        while (cursor.moveToNext()) {
            isLastOpen = cursor.getInt(4) == 1;

            if (lastOpenFiles && !isLastOpen)
                continue;

            item = new RecentFileItem();
            item.path = cursor.getString(0);
            item.time = cursor.getLong(1);
            item.encoding = cursor.getString(2);
            item.offset = cursor.getInt(3);
            item.isLastOpen = isLastOpen;
            list.add(item);
        }
        cursor.close();
        db.close();
        return list;
    }

    public void clearRecentFiles() {
        SQLiteDatabase db = getWritableDatabase();
        db.execSQL("delete from recent_files");
        db.close();
    }
}
