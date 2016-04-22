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

package com.jecelyin.common.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashDbHelper extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "crash.db";
    private static final int DATABASE_VERSION = 1; // Version must be >= 1
    private final SQLiteDatabase writeDb;
    private final SQLiteDatabase readDb;
    private final int version;

    public static CrashDbHelper getInstance(Context context) {
        return new CrashDbHelper(context.getApplicationContext());
    }

    public CrashDbHelper(Context context) {
        this(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public CrashDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        this(context, name, factory, version, null);
    }

    public CrashDbHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version, DatabaseErrorHandler errorHandler) {
        super(context, name, factory, version, errorHandler);
        writeDb = getWritableDatabase();
        readDb = getReadableDatabase();
        this.version = version;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE \"errors\" (\n" +
                " \"id\" INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT,\n" +
                " \"committed\" integer NOT NULL DEFAULT 0,\n" +
                " \"sign\" text NOT NULL,\n" +
                " \"trace\" text NOT NULL,\n" +
                "CONSTRAINT \"sign\" UNIQUE (sign) )");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    @Override
    public synchronized void close() {
        super.close();
        writeDb.close();
        readDb.close();
    }

    public void insertCrash(String trace) {
        String key = StringUtils.md5(trace + version);
//        Cursor cursor = readDb.query("errors", new String[]{"id"}, "sign=?", new String[]{key}, null, null, null, "1");
//        if(cursor != null) {
//            boolean exists = cursor.moveToFirst();
//            cursor.close();
//
//            if(exists)
//                return;
//        }
        //在并发情况下，先select判断是否存在后再insert into还是可以导致数据已经存在报错
        writeDb.execSQL("replace into errors (committed, sign, trace) values(?, ?, ?)"
                , new Object[]{0, key, trace});
    }

    public void crashToString(StringBuilder sb) {
        Cursor cursor = readDb.query("errors", new String[]{"trace"}, "committed=?", new String[]{"0"}, null, null, null, "30");
        if(cursor == null)
            return;
        while (cursor.moveToNext()) {
            sb.append(cursor.getString(0));
        }
        cursor.close();
    }

    public void updateCrashCommitted() {
        ContentValues cv = new ContentValues();
        cv.put("committed", 1);
        writeDb.update("errors", cv, null, null);
    }
}