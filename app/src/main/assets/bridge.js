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
    this.editor = editor;

    this.execCommand = function(cmd, data) {
        if (this[cmd]) {
            this[cmd](data);
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

    this.copy = function () {
        editor.onCopy();
    };

    this.paste = function () {
        editor.onPaste();
    };

    this.cut = function () {
        editor.onCut();
    };

    this.duplication = function () {
        editor.duplicateSelection();
    };

    this.convertWrapCharTo = function (data) {
        editor.replaceAll(data['value'], {'needle':"\r\n|\n|\r", 'regExp':true});
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
        editor.selection.selectAll();
    };

    this.forwardLocation = function () {
        //todo:
    };

    this.backLocation = function () {
        //todo:
    };

    this.insertOrReplaceText = function (data) {
        var requireSelected = data['requireSelected'];
        var text = data['text'];
        if (requireSelected && editor.selection.isEmpty()) {
            return;
        }
        editor.insert(text);
    };

    this.setText = function (data) {
        var text = data['text'];
        var file = data['file'];
        var modeCls = modelist.getModeForPath(file ? file : '');
        editor.session.setMode(modeCls.mode);
        editor.setValue(text);
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

    this.setMode = function (data) {
        var mode = data['mode'];
        //editor.session.setMode("ace/mode/java");
        editor.session.setMode(mode);
    };

    /**
     * 保存文件后，设置文本为非改变状态
     */
    this.resetTextChange = function () {
        //todo:
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
        //todo:
    };

    this.setTabSize = function (data) {
        //todo:
    };

    this.setAutoIndent = function (data) {
        //todo:
    };
}

(function () {
    this.bindEditorEventToJava = function () {
        //todo:
    };
}).call(Bridge.prototype);