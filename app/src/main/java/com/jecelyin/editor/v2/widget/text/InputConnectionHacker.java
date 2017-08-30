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

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.KeyEvent;
import android.view.inputmethod.CompletionInfo;
import android.view.inputmethod.CorrectionInfo;
import android.view.inputmethod.ExtractedText;
import android.view.inputmethod.ExtractedTextRequest;
import android.view.inputmethod.InputConnection;
import android.view.inputmethod.InputContentInfo;

import com.jecelyin.common.utils.L;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class InputConnectionHacker implements InputConnection {
    private final InputConnection ic;
    private final EditAreaView editAreaView;
    private boolean isShiftPressed;
    private boolean isAltPressed;
    private boolean isSymPressed;
    private boolean isCtrlPressed;
    public String cursorBeforeText;

    public InputConnectionHacker(InputConnection ic, EditAreaView editAreaView) {
        this.ic = ic;
        this.editAreaView = editAreaView;
    }

    @Override
    public CharSequence getTextBeforeCursor(int n, int flags) {
//        return ic.getTextBeforeCursor(n, flags);
        // TODO: 2017/8/28
        return cursorBeforeText == null ? "" : cursorBeforeText;
    }

    @Override
    public CharSequence getTextAfterCursor(int n, int flags) {
        return ic.getTextAfterCursor(n, flags);
    }

    @Override
    public CharSequence getSelectedText(int flags) {
        return editAreaView.getSelectedText();
    }

    @Override
    public int getCursorCapsMode(int reqModes) {
        return ic.getCursorCapsMode(reqModes);
    }

    @Override
    public ExtractedText getExtractedText(ExtractedTextRequest request, int flags) {
//        return ic.getExtractedText(request, flags);
        String text = editAreaView.getSelectedText();
        if (text == null) text = "";
        ExtractedText et = new ExtractedText();
        et.text = text;
        et.partialEndOffset = text.length();
        et.selectionStart = 0;
        et.selectionEnd = text.length();
        et.flags = 0;
        return et;
    }

    @Override
    public boolean deleteSurroundingText(int beforeLength, int afterLength) {
        boolean b = ic.deleteSurroundingText(beforeLength, afterLength);
        beginBatchEdit();
        sendKeyEvent(new KeyEvent(KeyEvent.ACTION_DOWN, KeyEvent.KEYCODE_DEL));
        sendKeyEvent(new KeyEvent(KeyEvent.ACTION_UP, KeyEvent.KEYCODE_DEL));
        endBatchEdit();
        return b;
    }

    @Override
    public boolean setComposingText(CharSequence text, int newCursorPosition) {
        return ic.setComposingText(text, newCursorPosition);
    }

    @Override
    public boolean setComposingRegion(int start, int end) {
        return ic.setComposingRegion(start, end);
    }

    @Override
    public boolean finishComposingText() {
        L.d("ICH", "finishComposingText");
        return ic.finishComposingText();
    }

    @Override
    public boolean commitText(CharSequence text, int newCursorPosition) {
        return ic.commitText(text, newCursorPosition);
    }

    @Override
    public boolean commitCompletion(CompletionInfo text) {
        L.d("ICH", "commitCompletion text=" + text);
        return ic.commitCompletion(text);
    }

    @Override
    public boolean commitCorrection(CorrectionInfo correctionInfo) {
        return ic.commitCorrection(correctionInfo);
    }

    @Override
    public boolean setSelection(int start, int end) {
        return ic.setSelection(start, end);
    }

    @Override
    public boolean performEditorAction(int editorAction) {
        return ic.performEditorAction(editorAction);
    }

    @Override
    public boolean performContextMenuAction(int id) {
        return ic.performContextMenuAction(id);
    }

    @Override
    public boolean beginBatchEdit() {
        L.d("ICH", "beginBatchEdit");
        return ic.beginBatchEdit();
    }

    @Override
    public boolean endBatchEdit() {
        L.d("ICH", "endBatchEdit");
        return ic.endBatchEdit();
    }

    @Override
    public boolean sendKeyEvent(KeyEvent event) {
        int keyCode = event.getKeyCode();
        if (keyCode == KeyEvent.KEYCODE_SHIFT_LEFT || keyCode == KeyEvent.KEYCODE_SHIFT_RIGHT) {
            isShiftPressed = event.getAction() == KeyEvent.ACTION_DOWN;
        } else if (keyCode == KeyEvent.KEYCODE_ALT_LEFT || keyCode == KeyEvent.KEYCODE_ALT_RIGHT
                || keyCode == KeyEvent.KEYCODE_NUM) {
            isAltPressed = event.getAction() == KeyEvent.ACTION_DOWN;
        } else if (keyCode == KeyEvent.KEYCODE_SYM) {
            isSymPressed = event.getAction() == KeyEvent.ACTION_DOWN;
        } else if (keyCode == KeyEvent.KEYCODE_CTRL_LEFT || keyCode == KeyEvent.KEYCODE_CTRL_RIGHT) {
            isCtrlPressed = event.getAction() == KeyEvent.ACTION_DOWN;
        }
        return ic.sendKeyEvent(event);
    }

    @Override
    public boolean clearMetaKeyStates(int states) {
        isAltPressed = false;
        isShiftPressed = false;
        isCtrlPressed = false;
        isSymPressed = false;
        editAreaView.clearSelection();
        return ic.clearMetaKeyStates(states);
    }

    @Override
    public boolean reportFullscreenMode(boolean enabled) {
        return ic.reportFullscreenMode(enabled);
    }

    @Override
    public boolean performPrivateCommand(String action, Bundle data) {
        return ic.performPrivateCommand(action, data);
    }

    @Override
    public boolean requestCursorUpdates(int cursorUpdateMode) {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            return ic.requestCursorUpdates(cursorUpdateMode);
        }
        return false;
    }

    public boolean isShiftPressed() {
        return isShiftPressed;
    }

    public boolean isAltPressed() {
        return isAltPressed;
    }

    public boolean isSymPressed() {
        return isSymPressed;
    }

    public boolean isCtrlPressed() {
        return isCtrlPressed;
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public boolean deleteSurroundingTextInCodePoints(int beforeLength, int afterLength) {
        return ic.deleteSurroundingTextInCodePoints(beforeLength, afterLength);
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public Handler getHandler() {
        return ic.getHandler();
    }

    @TargetApi(Build.VERSION_CODES.N)
    @Override
    public void closeConnection() {
        ic.closeConnection();
    }

    @TargetApi(Build.VERSION_CODES.N_MR1)
    @Override
    public boolean commitContent(@NonNull InputContentInfo inputContentInfo, int flags, @Nullable Bundle opts) {
        return ic.commitContent(inputContentInfo, flags, opts);
    }
}
