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
        editor.gotoLine(data['line'], data['column'], true);
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
        if (editor.getReadOnly())return;
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

    this.setSearchResult = function (data) {
        var event = require("ace/lib/event");

        data['file'] = "file.searchresult";
        window.findText = data['find'];
        window.findData = data['data'];

        editor.selection.on('changeCursor', function (e, selection) {
            if(!window.findData)return;
            var lead = selection.getSelectionLead();
            var token = selection.session.getTokenAt(lead.row, lead.column);
            if (!token || token.type !== 'keyword')return;
            var doc = selection.session.getDocument();
            if (lead.row >= window.findData.length)return;
            var data = window.findData[lead.row];
            AndroidEditor.openFile(data['file'], data['line'], data['column']);
        });
        editor.setReadOnly(true);
        this.setText(data);
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
        var line = data['line'] || 0;
        var column = data['column'] || 0;
        if (line > 0 || column > 0) {
            editor.gotoLine(line, column, true);
        }

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
        (new Finder(data)).show();
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

    this.setZoomable = function (data) {
        editor.setZoomable(data['value']);
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

    this.getCurrentPosition = function () {
        var lead = editor.selection.getSelectionLead();
        return [lead.row, lead.column];
    };

    this.clearSelection = function () {
        editor.clearSelection();
    };
}

(function () {
    this.bindEditorEventToJava = function () {
        var self = this;
        this.editor.on("change", function (data) {
            if (self.loading)
                return;
            var len = self.editor.session.getDocument().getTextLength();
            AndroidEditor.onTextChanged(len != self.lastTextLength || (len == self.lastTextLength && self.canUndo()) );
        });

        self.selected = false;
        this.editor.getSelection().on("changeSelection", function () {
            if (self.loading)
                return;
            var s = self.getSelectedText();
            var selected = !!s;
            AndroidEditor.onSelectionChange(selected, s ? s : '');

            if (selected === self.selected)
                return;
            self.selected = selected;

            if (s) {
                self.showActionMode();
            } else {
                self.hideActionMode();
            }

        });
        var Range = require("ace/range").Range;
        this.editor.getSelection().on("changeCursor", function () {
            try {
                var cursor = self.editor.getSelection().getCursor();
                var range = new Range(cursor.row, Math.max(0, cursor.column - 30), cursor.row, cursor.column);
                var text = self.editor.session.getDocument().getTextRange(range);
                AndroidEditor.updateCursorBeforeText(text);
            } catch (e) { }
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

/**
 *
 *
 * Creates a new `Search` object. The following search options are avaliable:
 *
 * - `needle`: The string or regular expression you're looking for
 * - `backwards`: Whether to search backwards from where cursor currently is. Defaults to `false`.
 * - `wrap`: Whether to wrap the search back to the beginning when it hits the end. Defaults to `false`.
 * - `caseSensitive`: Whether the search ought to be case-sensitive. Defaults to `false`.
 * - `wholeWord`: Whether the search matches only on whole words. Defaults to `false`.
 * - `range`: The [[Range]] to search within. Set this to `null` for the whole document
 * - `regExp`: Whether the search is a regular expression or not. Defaults to `false`.
 * - `start`: The starting [[Range]] or cursor position to begin the search
 * - `skipCurrent`: Whether or not to include the current line in the search. Default to `false`.
 *
 * @constructor
 **/
function Finder(data) {
    var dom = require("ace/lib/dom");
    var event = require("ace/lib/event");

    this.searchInput = null;
    this.replaceInput = null;
    this.replaceText = null;
    this.fineNextBtn = null;

    var options = {};
    options['needle'] = data['findText'];
    if (data['regex']) {
        options['regExp'] = true;
    }
    options['wholeWord'] = data['wholeWordOnly'];
    options['caseSensitive'] = data['caseSensitive'];
    options['wrap'] = true;

    var searchBar = dom.createElement("div");
    searchBar.id = "searchbar";
    if (dom.hasCssClass(editor.container, "ace_dark")) {
        searchBar.className = "ace_dark";
    }

    this.show = function () {
        var old = document.getElementById(searchBar.id);
        if (old) {
            old.parentNode.removeChild(old);
        }
        this.createSearchBox();
        if (data['replaceText'] || data['replaceText'] === "") {
            this.createReplaceBox();
        }

        var closeBox = dom.createElement("div");
        closeBox.id = "close_box";
        var closeBtn = dom.createElement("i");
        closeBtn.className = "css-icon icon-up-open-big";
        closeBtn.innerHTML = "&#xe805;";
        closeBox.appendChild(closeBtn);
        event.addListener(closeBox, 'click', function (e) {
            editor.container.style.top = "0px";
            searchBar.parentNode.removeChild(searchBar);
            editor.clearSelection();
        });
        searchBar.appendChild(closeBox);

        document.body.appendChild(searchBar);

        editor.container.style.top = searchBar.clientHeight + "px";
        this.fineNextBtn.click();
    };

    this.updateData = function () {
        if (this.searchInput) {
            options['needle'] = this.searchInput.value;
        }
        if (this.replaceInput) {
            this.replaceText = this.replaceInput.value;
        }
    };

    this.createSearchBox = function () {
        var self = this;
        var searchBox = dom.createElement("div");
        searchBox.id = "search_box";

        var searchInput = dom.createElement("input");
        searchInput.setAttribute("type", "text");
        searchInput.value = data['findText'];
        searchBox.appendChild(searchInput);
        this.searchInput = searchInput;

        var finePrevBtn = dom.createElement("i");
        finePrevBtn.className = "css-icon icon-up-1";
        finePrevBtn.innerHTML = "&#xe802;";
        event.addListener(finePrevBtn, 'click', function (e) {
            self.updateData();
            editor.findPrevious(options, true);
        });
        searchBox.appendChild(finePrevBtn);

        var fineNextBtn = dom.createElement("i");
        fineNextBtn.className = "css-icon icon-down";
        fineNextBtn.innerHTML = "&#xe801;";
        event.addListener(fineNextBtn, 'click', function (e) {
            self.updateData();
            editor.findNext(options, true);
        });
        searchBox.appendChild(fineNextBtn);
        this.fineNextBtn = fineNextBtn;

        searchBar.appendChild(searchBox);
    };

    this.createReplaceBox = function () {
        var self = this;
        var replaceBox = dom.createElement("div");
        replaceBox.id = "replace_box";

        var replaceInput = dom.createElement("input");
        replaceInput.setAttribute("type", "text");
        replaceBox.appendChild(replaceInput);
        this.replaceInput = replaceInput;

        var replaceOnceBtn = dom.createElement("i");
        replaceOnceBtn.className = "css-icon icon-ccw";
        replaceOnceBtn.innerHTML = "&#xe803;";
        event.addListener(replaceOnceBtn, 'click', function (e) {
            self.updateData();
            editor.replace(self.replaceText, options);
            editor.clearSelection();
        });
        replaceBox.appendChild(replaceOnceBtn);

        var replaceAllBtn = dom.createElement("i");
        replaceAllBtn.className = "css-icon icon-arrows-ccw";
        replaceAllBtn.innerHTML = "&#xe804;";
        event.addListener(replaceAllBtn, 'click', function (e) {
            self.updateData();
            editor.replaceAll(self.replaceText, options);
            editor.clearSelection();
        });
        replaceBox.appendChild(replaceAllBtn);

        searchBar.appendChild(replaceBox);
    };
}