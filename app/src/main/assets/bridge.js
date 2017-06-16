/**
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

/**
 *
 * @param editor Editor
 * @constructor
 */
function Bridge(editor) {
    this.mode = null;
    this.lastTextLength = 0;
    this.editor = editor;
    this.loading = false;

    this.execCommand = function(cmd, data) {
        if (this[cmd]) {
            return this[cmd](data);
        } else {
            alert('Unknown cmd: ' + cmd);
        }
    };

    this.redo = function () {
        editor.redo();
    };

    this.undo = function () {
        editor.undo();
    };

    this.canUndo = function () {
        return editor.session.getUndoManager().hasUndo();
    };

    this.canRedo = function () {
        return editor.session.getUndoManager().hasRedo();
    };

    this.onCopy = function () {
        editor.onCopy();
        editor.clearSelection();
    };

    this.onPaste = function (data) {
        editor.onPaste(data['text']);
        editor.clearSelection();
    };

    this.onCut = function () {
        editor.onCut();
        editor.clearSelection();
    };

    this.duplication = function () {
        editor.duplicateSelection();
        editor.clearSelection();
    };

    this.convertWrapCharTo = function (data) {
        // editor.replaceAll(data['value'], {'needle':"\r\n|\n|\r", 'regExp':true});
        var mode = "auto";
        if(data['value'] === "\r\n") {
            mode = "windows";
        } else if (data['value'] === "\n") {
            mode = "unix";
        }
        editor.getSession().getDocument().setNewLineMode(mode);
    };

    this.gotoTop = function () {
        editor.navigateFileStart();
    };

    this.gotoEnd = function () {
        editor.navigateFileEnd();
    };

    this.gotoLine = function (data) {
        editor.gotoLine(data['value'], 0, true);
    };

    this.readOnly = function (data) {
        editor.setReadOnly(data['value']);
    };

    this.selectAll = function () {
        editor.selectAll();
    };

    this.forwardLocation = function () {
        editor._emit('forwardLocation');
    };

    this.backLocation = function () {
        editor._emit('backLocation');
    };

    this.insertOrReplaceText = function (data) {
        var requireSelected = data['requireSelected'];
        var text = data['text'];
        if (requireSelected && !this.hasSelection()) {
            return;
        }
        editor.insert(text);
    };

    this.hasSelection = function () {
        return !editor.selection.isEmpty();
    };

    this.setText = function (data) {
        this.loading = true;

        editor.session.getUndoManager().reset();
        editor.session.getUndoManager().setInitializeOnce(true);

        var text = data['text'];
        var file = data['file'];
        var modeCls = modelist.getModeForPath(file ? file : '');
        this.setMode({'mode':modeCls.mode});
        editor.setValue(text, -1);
        editor.clearSelection();

        this.resetTextChange();

        this.loading = false;
    };

    this.getText = function () {
        return editor.getValue();
    };

    this.getSelectedText = function () {
        var range = editor.getSelection().getRange();
        return editor.session.getTextRange(range);
    };

    this.getLineText = function (data) {
        var line = data['line'];
        var limitLength = data['limitLength'];
        var text = editor.session.getLine(line);
        return text.substring(0, Math.min(limitLength, text.length));
    };

    this.enableHighlight = function (data) {
        var value = data['value'];
        if (value) {
            editor.session.setMode(this.mode);
        } else {
            editor.session.setMode(null);
        }
    };

    this.setMode = function (data) {
        this.mode = data['mode'];
        //editor.session.setMode("ace/mode/java");
        editor.session.setMode(this.mode);
        var modeName = "Text";
        var m;
        for (var i in modelist.modes) {
            m = modelist.modes[i];
            if (this.mode == m.mode) {
                modeName = m.caption;
                break;
            }
        }
        AndroidEditor.onModeChanged(modeName);
    };

    /**
     * 保存文件后，设置文本为非改变状态
     */
    this.resetTextChange = function () {
        this.lastTextLength = editor.session.getDocument().getTextLength();
        return true;
    };

    /**
     *
     * @param data object {String findText, String replaceText, boolean caseSensitive, boolean wholeWordOnly, boolean regex}
     */
    this.doFind = function (data) {
        //todo:
    };

    this.setFontSize = function (data) {
        editor.setFontSize(data['value']);
    };

    this.setShowLineNumber = function (data) {
        editor.renderer.setShowGutter(data['value']);
    };

    this.setShowInvisible = function (data) {
        editor.setShowInvisibles(data['value']);
    };

    this.setWordWrap = function (data) {
        editor.setOption("wrap", data['value'] ? 'free' : 'off');
    };

    this.setCursorWidth = function (data) {
        editor.renderer.$cursorLayer.setCursorWidth(data['value']);
        editor.renderer.updateCursor();
    };

    this.setTabSize = function (data) {
        editor.session.setTabSize(data['value']);
    };

    this.setAutoIndent = function (data) {
        editor.setAutoIndent(data['value']);
    };

    this.setSpaceAsTab = function (data) {
        editor.session.setUseSoftTabs(data['value']);
    };

    this.setAutoCapitalize = function (data) {
        editor.textInput.setAutoCapitalize(data['value']);
    };

    this.setTheme = function (data) {
        editor.setTheme(data['value']);
        setTimeout(function(){
            var style = document.getElementById('theme');
            if (style) {
                style.parentNode.removeChild(style);
            }
        }, 380);
    };
}

(function () {
    this.bindEditorEventToJava = function () {
        var self = this;
        this.editor.on("change", function (data) {
            if (self.loading)
                return;
            var len = self.editor.session.getDocument().getTextLength();
            AndroidEditor.onTextChanged(len != self.lastTextLength);
        });

        self.selected = false;
        this.editor.getSelection().on("changeSelection", function () {
            if (self.loading)
                return;
            var s = self.hasSelection();
            if (s == self.selected)
                return;
            self.selected = s;

            AndroidEditor.onSelectionChange(s);

            if (s) {
                self.showActionMode();
            } else {
                self.hideActionMode();
            }

        });
        this.editor.on("onLongTouch", function () {
            self.showActionMode();
        });
        this.editor.on("onClick", function () {
            if (self.hasSelection())
                return;
            self.hideActionMode();
        });
        this.editor.renderer.scrollBar.on("startScroll", function () {
            AndroidEditor.onScrollStart();
        });
        this.editor.renderer.scrollBar.on("endScroll", function () {
            AndroidEditor.onScrollEnd();
        });
    };

    this.actionModeTimer = null;
    this.showActionMode = function() {
        if (this.actionModeTimer)
            clearTimeout(this.actionModeTimer);

        this.actionModeTimer = setTimeout(function(){
            AndroidEditor.showActionMode();
        }, 500);
    };

    this.hideActionMode = function() {
        if (this.actionModeTimer)
            clearTimeout(this.actionModeTimer);

        this.actionModeTimer = setTimeout(function(){
            AndroidEditor.hideActionMode();
        }, 500);
    };
}).call(Bridge.prototype);