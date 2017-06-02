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

package com.jecelyin.editor.v2.widget.text;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.webkit.JavascriptInterface;
import android.webkit.ValueCallback;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.google.gson.Gson;
import com.jecelyin.editor.v2.Pref;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicLong;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditAreaView extends WebView implements SharedPreferences.OnSharedPreferenceChangeListener {
    private final Pref pref;
    private ArrayList<EditorCommand> cmdQueue = new ArrayList<>();
    private boolean pageLoaded;
    private Gson gson = new Gson();
    private AtomicLong cmdID = new AtomicLong(0);
    private HashMap<Long, ValueCallback<String>> callbackMap;

    public EditAreaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        WebSettings ws = getSettings();
        ws.setJavaScriptEnabled(true);
        ws.setAppCacheEnabled(false);
        ws.setDomStorageEnabled(true);
        ws.setAppCacheMaxSize(1024*1024*80);
        ws.setAppCachePath(context.getCacheDir().getPath());
//        ws.setAllowFileAccess(true);
        ws.setCacheMode(WebSettings.LOAD_DEFAULT);

        addJavascriptInterface(new JavascriptApi(), "AndroidEditor");

        setWebViewClient(new EditorViewClient());
        setWebChromeClient(new EditorViewChromeClient());

        loadUrl("file:///android_asset/editor.html");

        pref = Pref.getInstance(getContext());
        pref.registerOnSharedPreferenceChangeListener(this);
        onSharedPreferenceChanged(null, Pref.KEY_FONT_SIZE);
        onSharedPreferenceChanged(null, Pref.KEY_CURSOR_WIDTH);
        onSharedPreferenceChanged(null, Pref.KEY_SHOW_LINE_NUMBER);
        onSharedPreferenceChanged(null, Pref.KEY_WORD_WRAP);
        onSharedPreferenceChanged(null, Pref.KEY_SHOW_WHITESPACE);
        onSharedPreferenceChanged(null, Pref.KEY_TAB_SIZE);
        onSharedPreferenceChanged(null, Pref.KEY_AUTO_INDENT);
        onSharedPreferenceChanged(null, Pref.KEY_AUTO_CAPITALIZE);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case Pref.KEY_FONT_SIZE:
                execCommand(new EditorCommand.Builder(Pref.KEY_FONT_SIZE).put("value", pref.getFontSize()).build());
                break;
            case Pref.KEY_CURSOR_WIDTH:
                execCommand(new EditorCommand.Builder(Pref.KEY_CURSOR_WIDTH).put("value", pref.getCursorThickness()).build());
                break;
            case Pref.KEY_SHOW_LINE_NUMBER:
                execCommand(new EditorCommand.Builder(Pref.KEY_SHOW_LINE_NUMBER).put("value", pref.isShowLineNumber()).build());
                break;
            case Pref.KEY_WORD_WRAP:
                execCommand(new EditorCommand.Builder(Pref.KEY_WORD_WRAP).put("value", pref.isWordWrap()).build());
                break;
            case Pref.KEY_SHOW_WHITESPACE:
                execCommand(new EditorCommand.Builder(Pref.KEY_SHOW_WHITESPACE).put("value", pref.isShowWhiteSpace()).build());
                break;
            case Pref.KEY_TAB_SIZE:
                execCommand(new EditorCommand.Builder(Pref.KEY_TAB_SIZE).put("value", pref.getTabSize()).build());
                break;
            case Pref.KEY_AUTO_INDENT:
                execCommand(new EditorCommand.Builder(Pref.KEY_AUTO_INDENT).put("value", pref.isAutoIndent()).build());
                break;
            case Pref.KEY_AUTO_CAPITALIZE:
//                if (mEditor != null) {
//                    if (!pref.isAutoCapitalize()) {
//                        mEditor.mInputType &= ~EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
//                    } else {
//                        mEditor.mInputType |= EditorInfo.TYPE_TEXT_FLAG_CAP_SENTENCES;
//                    }
//                }
                break;
        }
    }

    private class JavascriptApi {

        @JavascriptInterface
        public void returnValue(long id, String value) {
            ValueCallback<String> callback = callbackMap.get(id);
            if (callback != null) {
                callback.onReceiveValue(value);
                callbackMap.remove(id);
            }
        }
    }

    private class EditorViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            pageLoaded = true;
        }

        @Override
        public void onReceivedError(WebView view, WebResourceRequest request, WebResourceError error) {
            super.onReceivedError(view, request, error);
        }

        @Override
        public void onReceivedHttpError(WebView view, WebResourceRequest request, WebResourceResponse errorResponse) {
            super.onReceivedHttpError(view, request, errorResponse);
        }
    }

    private class EditorViewChromeClient extends WebChromeClient {

    }

    public void execCommand(EditorCommand ec) {
        if (!pageLoaded) {
            cmdQueue.add(ec);
            return;
        }
        String json = gson.toJson(ec);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            evaluateJavascript(String.format("handleJava(%d, %s);", 0, json), ec.callback);
        } else {
            long id = cmdID.incrementAndGet();
            if (ec.callback != null) {
                if (callbackMap == null)
                    callbackMap = new HashMap<>();
                callbackMap.put(id, ec.callback);
            }

            loadUrl(String.format("javascript:handleJava(%d, %s);", id, json));
        }
    }

    public void redo() {
        execCommand(new EditorCommand.Builder("redo").build());
    }

    public void undo() {
        execCommand(new EditorCommand.Builder("undo").build());
    }

    public boolean canRedo() {
        return false;
    }

    public boolean canUndo() {
        return false;
    }

    public boolean copy() {
        execCommand(new EditorCommand.Builder("copy").build());
        return true;
    }

    public boolean paste() {
        execCommand(new EditorCommand.Builder("paste").build());
        return true;
    }

    public boolean cut() {
        execCommand(new EditorCommand.Builder("cut").build());
        return true;
    }

    public void duplication() {
        execCommand(new EditorCommand.Builder("duplication").build());
    }

    public void convertWrapCharTo(String chars) {
        execCommand(new EditorCommand.Builder("convertWrapCharTo").put("value", chars).build());
    }

    public void gotoTop() {
        execCommand(new EditorCommand.Builder("gotoTop").build());
    }

    public void gotoEnd() {
        execCommand(new EditorCommand.Builder("gotoEnd").build());
    }

    public void gotoLine(int line) {
        execCommand(new EditorCommand.Builder("gotoLine").put("value", line).build());
    }

    public void setReadOnly(boolean readOnly) {
        execCommand(new EditorCommand.Builder("readOnly").put("value", readOnly).build());
    }

    public void setCustomSelectionActionModeCallback(ActionMode.Callback callback) {

    }

    public boolean hasSelection() {
        return false;
    }

    public int getSelectionStart() {
        return 0;
    }

    public int getSelectionEnd() {
        return 0;
    }

    public boolean selectAll() {
        return true;
    }

    public void setSelection(int index) {

    }

    public void forwardLocation() {

    }

    public void backLocation() {

    }

    public void insert(int index, CharSequence text) {

    }

    public void replace(int startIndex, int endIndex, CharSequence text) {

    }

    public void hideSoftInput() {

    }

    public void showSoftInput() {

    }

    public void addTextChangedListener(TextWatcher textWatcher) {

    }

    public void setText(CharSequence text) {

    }

    public String getText() {
        return null;
    }

    public String getSelectedText() {
        return null;
    }

    public String getLineText(int line, int limitLength) {
        return null;
    }

    /**
     *
     * @param mode [auto, null, ace/mode/js,,,]
     */
    public void setMode(String mode) {

    }

    public String getModeName() {
        return null;
    }

    public void doFind(String findText, String replaceText, boolean caseSensitive, boolean wholeWordOnly, boolean regex) {

    }
}
