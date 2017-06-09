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

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import android.util.AttributeSet;
import android.view.ActionMode;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.jecelyin.common.utils.L;
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
    private ActionMode.Callback actionModeCallback;
    private ActionMode actionMode;
    private OnTextChangeListener onTextChangeListener;
    private String modeName = "Text";
    private boolean selected;
    private boolean textChanged;

    public EditAreaView(Context context, AttributeSet attrs) {
        super(context, attrs);

        if (L.debug) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                setWebContentsDebuggingEnabled(true);
            }
        }

        setLongClickable(false);
        setOnLongClickListener(new OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                return true;
            }
        });

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
                execCommand(new EditorCommand.Builder("setFontSize").put("value", pref.getFontSize()).build());
                break;
            case Pref.KEY_CURSOR_WIDTH:
                execCommand(new EditorCommand.Builder("setCursorWidth").put("value", pref.getCursorThickness()).build());
                break;
            case Pref.KEY_SHOW_LINE_NUMBER:
                execCommand(new EditorCommand.Builder("setShowLineNumber").put("value", pref.isShowLineNumber()).build());
                break;
            case Pref.KEY_WORD_WRAP:
                execCommand(new EditorCommand.Builder("setWordWrap").put("value", pref.isWordWrap()).build());
                break;
            case Pref.KEY_SHOW_WHITESPACE:
                execCommand(new EditorCommand.Builder("setShowInvisible").put("value", pref.isShowWhiteSpace()).build());
                break;
            case Pref.KEY_TAB_SIZE:
                execCommand(new EditorCommand.Builder("setTabSize").put("value", pref.getTabSize()).build());
                break;
            case Pref.KEY_AUTO_INDENT:
                execCommand(new EditorCommand.Builder("setAutoIndent").put("value", pref.isAutoIndent()).build());
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
            case Pref.KEY_THEME:
                //todo:
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

        @JavascriptInterface
        public void showActionMode() {
            if (actionModeCallback == null)
                return;

            post(new Runnable() {
                @Override
                public void run() {
                    if (actionMode != null){
                        actionMode.finish();
                    }
                    actionMode = startActionMode(actionModeCallback);
                }
            });
        }

        @JavascriptInterface
        public void hideActionMode() {
            if (actionMode != null){
                post(new Runnable() {
                    @Override
                    public void run() {
                        actionMode.finish();
                    }
                });
            }
        }

        @JavascriptInterface
        public void onSelectionChange(boolean s) {
            selected = s;
        }

        @JavascriptInterface
        public void onTextChanged(boolean s) {
            textChanged = s;

            if (onTextChangeListener != null) {
                post(new Runnable() {
                    @Override
                    public void run() {
                        onTextChangeListener.onTextChanged();
                    }
                });
            }
        }

        @JavascriptInterface
        public void onModeChanged(String name) {
            modeName = name;
        }
    }

    private class EditorViewClient extends WebViewClient {
        @Override
        public void onPageFinished(WebView view, String url) {
            pageLoaded = true;

            for (EditorCommand command : cmdQueue) {
                execCommand(command);
            }
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

    public void canRedo(JsCallback<Boolean> callback) {
        execCommand(new EditorCommand.Builder("canRedo").callback(callback).build());
    }

    public void canUndo(JsCallback<Boolean> callback) {
        execCommand(new EditorCommand.Builder("canUndo").callback(callback).build());
    }

    public boolean copy() {
        getSelectedText(new JsCallback<String>() {
            @Override
            public void onCallback(String data) {
                setPrimaryClip(ClipData.newPlainText(null, data));
                execCommand(new EditorCommand.Builder("onCopy").build());
            }
        });

        return true;
    }

    public boolean paste() {
        ClipboardManager clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);

// Gets the clipboard as text.
        CharSequence pasteData = item.getText();
        if (pasteData == null)
            return false;

        execCommand(new EditorCommand.Builder("onPaste").put("text", pasteData.toString()).build());
        return true;
    }

    public boolean cut() {
        getSelectedText(new JsCallback<String>() {
            @Override
            public void onCallback(String data) {
                setPrimaryClip(ClipData.newPlainText(null, data));
                execCommand(new EditorCommand.Builder("onCut").build());
            }
        });
        return true;
    }

    private void setPrimaryClip(ClipData clip) {
        ClipboardManager clipboard = (ClipboardManager) getContext().
                getSystemService(Context.CLIPBOARD_SERVICE);
        clipboard.setPrimaryClip(clip);
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
        this.actionModeCallback = callback;
    }

    public boolean hasSelection() {
        return selected;
    }

    public boolean selectAll() {
        execCommand(new EditorCommand.Builder("selectAll").build());
        return true;
    }

    public void forwardLocation() {
        execCommand(new EditorCommand.Builder("forwardLocation").build());
    }

    public void backLocation() {
        execCommand(new EditorCommand.Builder("backLocation").build());
    }

    public void insertOrReplaceText(CharSequence text, boolean requireSelected) {
        execCommand(new EditorCommand.Builder("insertOrReplaceText")
                .put("text", text.toString())
                .put("requireSelected", requireSelected)
                .build());
    }

    public void hideSoftInput() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
    }

    public void showSoftInput() {
        InputMethodManager imm = (InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(this, InputMethodManager.SHOW_FORCED);
    }

    public void addTextChangedListener(OnTextChangeListener onTextChangeListener) {
        this.onTextChangeListener = onTextChangeListener;
    }

    public void setText(String file, CharSequence text) {
        execCommand(new EditorCommand.Builder("setText")
                .put("text", text)
                .put("file", file)
                .build());
    }

    public void getText(JsCallback<String> callback) {
        execCommand(new EditorCommand.Builder("getText").callback(callback).build());
    }

    public void getSelectedText(JsCallback<String> callback) {
        execCommand(new EditorCommand.Builder("getSelectedText").callback(callback).build());
    }

    public void getLineText(int line, int limitLength, JsCallback<String> callback) {
        execCommand(new EditorCommand.Builder("getLineText")
                .put("line", line)
                .put("limitLength", limitLength)
                .callback(callback).build());
    }


    public void enableHighlight(boolean enable) {
        execCommand(new EditorCommand.Builder("enableHighlight").put("value", enable).build());
    }

    /**
     *
     * @param mode [null, ace/mode/js,,,]
     */
    public void setMode(String mode) {
        execCommand(new EditorCommand.Builder("setMode").put("mode", mode).build());
    }

    public String getModeName() {
        return modeName;
    }

    public void doFind(String findText, String replaceText, boolean caseSensitive, boolean wholeWordOnly, boolean regex) {
        execCommand(new EditorCommand.Builder("doFind")
                .put("findText", findText)
                .put("replaceText", replaceText)
                .put("caseSensitive", caseSensitive)
                .put("wholeWordOnly", wholeWordOnly)
                .put("regex", regex)
                .build());
    }

    public boolean isTextChanged() {
        return textChanged;
    }

    public void resetTextChange() {
        execCommand(new EditorCommand.Builder("resetTextChange").build());
    }
}
