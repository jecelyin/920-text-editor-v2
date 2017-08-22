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

package com.jecelyin.editor.v2;

import android.support.annotation.IntDef;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Environment;
import android.preference.PreferenceManager;
import android.text.TextUtils;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.StringUtils;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Pref implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String KEY_FONT_SIZE = "pref_font_size";
    public static final String KEY_CURSOR_WIDTH = "pref_cursor_width";
    public static final String KEY_TOUCH_TO_ADJUST_TEXT_SIZE = "pref_touch_to_adjust_text_size";
    public static final String KEY_WORD_WRAP = "pref_word_wrap";
    public static final String KEY_SHOW_LINE_NUMBER = "pref_show_linenumber";
    public static final String KEY_SHOW_WHITESPACE = "pref_show_whitespace";
    public static final String KEY_AUTO_INDENT = "pref_auto_indent";
    public static final String KEY_INSERT_SPACE_FOR_TAB = "pref_insert_space_for_tab";
    public static final String KEY_TAB_SIZE = "pref_tab_size";
    public static final String KEY_SYMBOL = "pref_symbol";
    public static final String KEY_AUTO_CAPITALIZE = "pref_auto_capitalize";
    public static final String KEY_ENABLE_HIGHLIGHT = "pref_enable_highlight";
    public static final String KEY_HIGHLIGHT_FILE_SIZE_LIMIT = "pref_highlight_file_size_limit";
    public static final String KEY_THEME = "pref_current_theme";
    public static final String KEY_AUTO_SAVE = "pref_auto_save";
    public static final String KEY_REMEMBER_LAST_OPENED_FILES = "pref_remember_last_opened_files";
    public static final String KEY_SCREEN_ORIENTATION = "pref_screen_orientation";
    public static final String KEY_KEEP_SCREEN_ON = "pref_keep_screen_on";
    public static final String KEY_ENABLE_ROOT = "pref_enable_root";
    public static final String KEY_TOOLBAR_ICONS = "pref_toolbar_icons";
    public static final String KEY_PREF_AUTO_CHECK_UPDATES = "pref_auto_check_updates";
    public static final String KEY_PREF_KEEP_BACKUP_FILE = "pref_keep_backup_file";
    public static final String KEY_PREF_ENABLE_DRAWERS = "pref_enable_drawers";
    public static final String KEY_LAST_OPEN_PATH = "last_open_path2";
    public static final String KEY_READ_ONLY = "readonly_mode";
    public static final String KEY_SHOW_HIDDEN_FILES = "show_hidden_files";
    public static final String KEY_FILE_SORT_TYPE = "show_file_sort";
    public static final String KEY_FULL_SCREEN = "fullscreen_mode";
    public static final String KEY_LAST_TAB = "last_tab";

    public static final int DEF_MIN_FONT_SIZE = 9;
    public static final int DEF_MAX_FONT_SIZE = 32;

    public static final int SCREEN_ORIENTATION_AUTO = 0;
    public static final int SCREEN_ORIENTATION_LANDSCAPE = 1;
    public static final int SCREEN_ORIENTATION_PORTRAIT = 2;
    public static final String VALUE_SYMBOL = TextUtils.join("\n", new String[]{"{", "}", "<", ">"
            , ",", ";", "'", "\"", "(", ")", "/", "\\", "%", "[", "]", "|", "#", "=", "$", ":"
            , "&", "?", "!", "@", "^", "+", "*", "-", "_", "`", "\\t", "\\n" });

    @IntDef({SCREEN_ORIENTATION_AUTO, SCREEN_ORIENTATION_LANDSCAPE, SCREEN_ORIENTATION_PORTRAIT})
    public @interface ScreenOrientation {}

    private static Pref instance;
    private final SharedPreferences pm;

    private final Map<String, Object> map;
    private Set<String> toolbarIcons;

    private static final Object mContent = new Object();
    private final WeakHashMap<SharedPreferences.OnSharedPreferenceChangeListener, Object> mListeners = new WeakHashMap<>();

    public static Pref getInstance(Context context) {
        if(instance == null) {
            instance = new Pref(context.getApplicationContext());
        }
        return instance;
    }

    static {
        // All Private Keys should go here like this:
//        privateKeys.put("box_key", "zqjxn1m3i4eg4iud158e0nz7u9oi2cpu");
//        privateKeys.put("box_secret", "BcTh1GpJpma1cJc58sqcfZSjDZeuiYZ2");
//        privateKeys.put("dropbox_key", "vajaedmhzkkp3sw");
//        privateKeys.put("dropbox_secret", "plkrfrygu17glgn");
//        privateKeys.put("drive_key", "645291897772.apps.googleusercontent.com");
//        privateKeys.put("drive_secret", "xo9-oPP7P7Rj5er3J1qmzhoG");
//        privateKeys.put("skydrive_key", "00000000400F4500");
//        privateKeys.put("skydrive_secret", "0uUmcI0Bjdxux9KdSWVxmgRCZcpzacyz");
    }
    
    public Pref(Context context) {
        pm =  PreferenceManager.getDefaultSharedPreferences(context);
        pm.registerOnSharedPreferenceChangeListener(this);

        //init variable
        map = new HashMap<>();
        map.put(KEY_FONT_SIZE, 13);
        map.put(KEY_CURSOR_WIDTH, 2);
        map.put(KEY_TOUCH_TO_ADJUST_TEXT_SIZE, false);
        map.put(KEY_WORD_WRAP, true);
        map.put(KEY_SHOW_LINE_NUMBER, true);
        map.put(KEY_SHOW_WHITESPACE, true);
        map.put(KEY_AUTO_INDENT, true);
        map.put(KEY_INSERT_SPACE_FOR_TAB, true);
        map.put(KEY_TAB_SIZE, 4);
        map.put(KEY_SYMBOL, VALUE_SYMBOL);
        map.put(KEY_AUTO_CAPITALIZE, true);
        map.put(KEY_ENABLE_HIGHLIGHT, true);
        map.put(KEY_HIGHLIGHT_FILE_SIZE_LIMIT, 800);
        map.put(KEY_THEME, 2);
        map.put(KEY_AUTO_SAVE, false);
        map.put(KEY_ENABLE_ROOT, true);
        map.put(KEY_REMEMBER_LAST_OPENED_FILES, true);
        map.put(KEY_SCREEN_ORIENTATION, "auto");
        map.put(KEY_KEEP_SCREEN_ON, false);
        map.put(KEY_PREF_AUTO_CHECK_UPDATES, true);
        map.put(KEY_PREF_KEEP_BACKUP_FILE, true);
        map.put(KEY_PREF_ENABLE_DRAWERS, false);

        //not at preference setting
        toolbarIcons = pm.getStringSet(KEY_TOOLBAR_ICONS, null);
        map.put(KEY_LAST_OPEN_PATH, Environment.getExternalStorageDirectory().getPath());
        map.put(KEY_READ_ONLY, false);
        map.put(KEY_SHOW_HIDDEN_FILES, false);
        map.put(KEY_FILE_SORT_TYPE, 0);
        map.put(KEY_FULL_SCREEN, false);
        map.put(KEY_LAST_TAB, 0);

        Map<String, ?> values = pm.getAll();
        for(String key : map.keySet()) {
            updateValue(key, values);
        }
    }

    private void updateValue(String key, Map<String, ?> values) {
        Object value = map.get(key);
        // 跳过一些不能通过本方法取值的东东
        if(value == null)
            return;
        Class cls = value.getClass();

        try {
            if(cls == int.class || cls == Integer.class) {
//                value = StringUtils.toInt(pm.getString(key, String.valueOf(value)));
                Object in = values.get(key);
                if (in != null)
                    value = in instanceof Integer ? (int)in : StringUtils.toInt(String.valueOf(in));
            } else if(cls == boolean.class || cls == Boolean.class) {
//                value = pm.getBoolean(key, (boolean)value);
                Boolean b = (Boolean) values.get(key);
                value = b == null ? (boolean)value : b;
            } else {
//                value = pm.getString(key, (String)value);
                String str = (String) values.get(key);
                value = str == null ? (String)value : str;
            }
        } catch (Exception e) {
            L.e("key = " + key, e);
            return;
        }
        map.put(key, value);
    }

    public void registerOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        synchronized(this) {
            mListeners.put(listener, mContent);
        }
    }

    public void unregisterOnSharedPreferenceChangeListener(SharedPreferences.OnSharedPreferenceChangeListener listener) {
        synchronized(this) {
            mListeners.remove(listener);
        }
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        updateValue(key, sharedPreferences.getAll());
        Set<SharedPreferences.OnSharedPreferenceChangeListener> listeners = mListeners.keySet();
        for(SharedPreferences.OnSharedPreferenceChangeListener listener : listeners) {
            if (listener != null) {
                listener.onSharedPreferenceChanged(sharedPreferences, key);
            }
        }
    }

    public static String getGoogleDriveKey() {
        return null; //drive_key
    }

    public static String getGoogleDriveSecret() {
        return null; //drive_key
    }

    public static String getBoxAPIKey() {
        return null; // TODO: 16/1/2
    }

    public static String getBoxApiSecret() {
        return null;
    }
    
    public boolean isShowLineNumber() {
        return (boolean) map.get(KEY_SHOW_LINE_NUMBER);
    }

    public boolean isShowWhiteSpace() {
        return (boolean) map.get(KEY_SHOW_WHITESPACE);
    }

    public int getTheme() {
        return (int) map.get(KEY_THEME);
    }

    public ThemeList.Theme getThemeInfo() {
        int themeIndex = getTheme();
        if (themeIndex >= 0 && themeIndex < ThemeList.themes.length) {
            return ThemeList.themes[themeIndex];
        }
        return null;
    }

    public void setTheme(int theme) {
        map.put(KEY_THEME, theme);
        pm.edit().putInt(KEY_THEME, theme).commit();
    }

    public boolean isHighlight() {
        return (boolean) map.get(KEY_ENABLE_HIGHLIGHT);
    }

    public int getHighlightSizeLimit() {
        return 1024 * (int) map.get(KEY_HIGHLIGHT_FILE_SIZE_LIMIT);
    }

    public boolean isAutoSave() {
        return (boolean) map.get(KEY_AUTO_SAVE);
    }

    public boolean isKeepScreenOn() {
        return (boolean) map.get(KEY_KEEP_SCREEN_ON);
    }

    public Integer[] getToolbarIcons() {
        if (toolbarIcons == null)
            return null;
        Integer[] list = new Integer[toolbarIcons.size()];
        int i = 0;
        for (String id : toolbarIcons) {
            list[i++] = Integer.valueOf(id);
        }
        return list;
    }

    public void setToolbarIcons(Integer[] toolbarIcons) {
        this.toolbarIcons = new HashSet<>();
        for (Integer id : toolbarIcons) {
            this.toolbarIcons.add(String.valueOf(id));
        }
        pm.edit().putStringSet(KEY_TOOLBAR_ICONS, this.toolbarIcons).apply();
    }

    public Object getValue(String key) {
        return map.get(key);
    }

    public String getLastOpenPath() {
        return (String)map.get(KEY_LAST_OPEN_PATH);
    }

    public void setLastOpenPath(String path) {
        pm.edit().putString(KEY_LAST_OPEN_PATH, path).apply();
        map.put(KEY_LAST_OPEN_PATH, path);
    }

    public int getFontSize() {
        return (int)map.get(KEY_FONT_SIZE);
    }

    public int getCursorThickness() {
        int width = (int) map.get(KEY_CURSOR_WIDTH);
        if (width == 0)
            return 0;

        return width;
    }

    public boolean isReadOnly() {
        return (boolean) map.get(KEY_READ_ONLY);
    }

    public void setReadOnly(boolean b) {
        pm.edit().putBoolean(KEY_READ_ONLY, b).apply();
        map.put(KEY_READ_ONLY, b);
    }

    public boolean isAutoIndent() {
        return (boolean) map.get(KEY_AUTO_INDENT);
    }

    public boolean isWordWrap() {
        return (boolean) map.get(KEY_WORD_WRAP);
    }

    public boolean isTouchScaleTextSize() {
        return (boolean) map.get(KEY_TOUCH_TO_ADJUST_TEXT_SIZE);
    }

    public boolean isAutoCheckUpdates() {
        return (boolean) map.get(KEY_PREF_AUTO_CHECK_UPDATES);
    }

    public boolean isAutoCapitalize() {
        return (boolean) map.get(KEY_AUTO_CAPITALIZE);
    }

    public boolean isOpenLastFiles() {
        return (boolean) map.get(KEY_REMEMBER_LAST_OPENED_FILES);
    }

    public int getTabSize() {
        return (int)map.get(KEY_TAB_SIZE);
    }

    @ScreenOrientation
    public int getScreenOrientation() {
        String ori = (String) map.get(KEY_SCREEN_ORIENTATION);
        if ("landscape".equals(ori)) {
            return SCREEN_ORIENTATION_LANDSCAPE;
        } else if("portrait".equals(ori)) {
            return SCREEN_ORIENTATION_PORTRAIT;
        } else {
            return SCREEN_ORIENTATION_AUTO;
        }
    }

    public boolean isRootEnabled() {
        return ((boolean)map.get(KEY_ENABLE_ROOT));
    }

    public boolean isKeepBackupFile() {
        return (boolean) map.get(KEY_PREF_KEEP_BACKUP_FILE);
    }

    public String getSymbol() {
        return (String) map.get(KEY_SYMBOL);
    }

    public boolean isShowHiddenFiles() {
        return (boolean) map.get(KEY_SHOW_HIDDEN_FILES);
    }

    public void setShowHiddenFiles(boolean b) {
        pm.edit().putBoolean(KEY_SHOW_HIDDEN_FILES, b).apply();
        map.put(KEY_SHOW_HIDDEN_FILES, b);
    }

    public int getFileSortType() {
        return (int) map.get(KEY_FILE_SORT_TYPE);
    }

    public void setFileSortType(int type) {
        pm.edit().putInt(KEY_FILE_SORT_TYPE, type).apply();
        map.put(KEY_FILE_SORT_TYPE, type);
    }

    public void setFullScreenMode(boolean b) {
        pm.edit().putBoolean(KEY_FULL_SCREEN, b).apply();
        map.put(KEY_FULL_SCREEN, b);
    }

    public boolean isFullScreenMode() {
        return (boolean)map.get(KEY_FULL_SCREEN);
    }

    public void setLastTab(int index) {
        pm.edit().putInt(KEY_LAST_TAB, index).apply();
        map.put(KEY_LAST_TAB, index);
    }

    public int getLastTab() {
        return (int)map.get(KEY_LAST_TAB);
    }

    public boolean isEnabledDrawers() {
        return (boolean)map.get(KEY_PREF_ENABLE_DRAWERS);
    }

    public boolean isInsertSpaceForTab() {
        return (boolean)map.get(KEY_INSERT_SPACE_FOR_TAB);
    }
}
