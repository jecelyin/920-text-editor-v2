/* ***** BEGIN LICENSE BLOCK *****
 * Distributed under the BSD license:
 *
 * Copyright (c) 2010, Ajax.org B.V.
 * All rights reserved.
 * 
 * Redistribution and use in source and binary forms, with or without
 * modification, are permitted provided that the following conditions are met:
 *     * Redistributions of source code must retain the above copyright
 *       notice, this list of conditions and the following disclaimer.
 *     * Redistributions in binary form must reproduce the above copyright
 *       notice, this list of conditions and the following disclaimer in the
 *       documentation and/or other materials provided with the distribution.
 *     * Neither the name of Ajax.org B.V. nor the
 *       names of its contributors may be used to endorse or promote products
 *       derived from this software without specific prior written permission.
 * 
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND
 * ANY EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED
 * WARRANTIES OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE
 * DISCLAIMED. IN NO EVENT SHALL AJAX.ORG B.V. BE LIABLE FOR ANY
 * DIRECT, INDIRECT, INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES
 * (INCLUDING, BUT NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES;
 * LOSS OF USE, DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND
 * ON ANY THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 * (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF THIS
 * SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 * ***** END LICENSE BLOCK ***** */

define(function(require, exports, module) {
"use strict";

var Pinch = require("../mouse/pinch_zoom").Pinch;
var dom = require("../lib/dom");
var event = require("../lib/event");
var useragent = require("../lib/useragent");
var FastScroller = require("../fastscroll/Scroller").Scroller;
var SelectDrawableEventHandler = require("./select_drawables_event_handler").SelectDrawableEventHandler;
var DRAG_OFFSET = 0; // pixels

function DefaultHandlers(mouseHandler) {
    mouseHandler.$clickSelection = null;
    this.longTouchTimer = null;
    this.lastTouchTime = 0;
    this.stacks = [];
    this.stackPosition = 0;

    var editor = mouseHandler.editor;
    this.editor = editor;

    this.pinch = new Pinch(editor);

    this.mousedown = this.onMouseDown.bind(mouseHandler);
    editor.setDefaultHandler("mousedown", this.mousedown);
    this.onDoubleClickHandler = this.onDoubleClick.bind(mouseHandler);
    // editor.setDefaultHandler("dblclick", this.onDoubleClick.bind(mouseHandler));
    editor.setDefaultHandler("tripleclick", this.onTripleClick.bind(mouseHandler));
    editor.setDefaultHandler("quadclick", this.onQuadClick.bind(mouseHandler));
    editor.setDefaultHandler("mousewheel", this.onMouseWheel.bind(mouseHandler));
    // editor.setDefaultHandler("touchmove", this.onTouchMove.bind(mouseHandler));
    editor.setDefaultHandler("touchmove", this.onTouchMove.bind(this));
    editor.setDefaultHandler("touchstart", this.onTouchStart.bind(this));
    editor.setDefaultHandler("touchend", this.onTouchEnd.bind(this));
    editor.setDefaultHandler("touchcancel", this.onTouchEnd.bind(this));
    editor.setDefaultHandler("forwardLocation", this.forwardLocation.bind(this));
    editor.setDefaultHandler("backLocation", this.backLocation.bind(this));

    var exports = ["select", "startSelect", "selectEnd", "selectAllEnd", "selectByWordsEnd",
        "selectByLinesEnd", "dragWait", "dragWaitEnd", "focusWait"];

    exports.forEach(function(x) {
        mouseHandler[x] = this[x];
    }, this);

    mouseHandler.selectByLines = this.extendSelectionBy.bind(mouseHandler, "getLineRange");
    mouseHandler.selectByWords = this.extendSelectionBy.bind(mouseHandler, "getWordRange");
    new SelectDrawableEventHandler(this, mouseHandler);

    this.fastScroller = new FastScroller(function (left, top, zoom) {
        // console.log("fast scroll left="+left+" top="+top+" zoom="+zoom);
        editor.session.setScrollLeft(left);
        editor.session.setScrollTop(top);
    }, {"scrollingX": true});
}

(function() {

    this.onMouseDown = function(ev, isSelectDrawable) {
        var inSelection = ev.inSelection();
        var pos = ev.getDocumentPosition();
        this.mousedownEvent = ev;
        var editor = this.editor;

        var button = ev.getButton();
        if (button !== 0 && !isSelectDrawable) {
            var selectionRange = editor.getSelectionRange();
            var selectionEmpty = selectionRange.isEmpty();
            editor.$blockScrolling++;
            if (selectionEmpty || button == 1)
                editor.selection.moveToPosition(pos);
            editor.$blockScrolling--;
            // 2: contextmenu, 1: linux paste
            if (button == 2) {
                editor.textInput.onContextMenu(ev.domEvent);
                if (!useragent.isMozilla)
                    ev.preventDefault();
            }
            // stopping event here breaks contextmenu on ff mac
            // not stoping breaks it on chrome mac
            return;
        }

        this.mousedownEvent.time = Date.now();
        // if this click caused the editor to be focused should not clear the
        // selection
        if (inSelection && !editor.isFocused()) {
            editor.focus();
            if (this.$focusTimout && !this.$clickSelection && !editor.inMultiSelectMode) {
                this.setState("focusWait");
                this.captureMouse(ev);
                return;
            }
        }

        this.captureMouse(ev);
        this.startSelect(pos, ev.domEvent._clicks > 1);
        return ev.preventDefault();
    };

    this.startSelect = function(pos, waitForClickSelection) {
        pos = pos || this.editor.renderer.screenToTextCoordinates(this.x, this.y);
        var editor = this.editor;
        // allow double/triple click handlers to change selection
        editor.$blockScrolling++;
        if (this.mousedownEvent.getShiftKey())
            editor.selection.selectToPosition(pos);
        else if (!waitForClickSelection)
            editor.selection.moveToPosition(pos);
        if (!waitForClickSelection)
            this.select();
        if (editor.renderer.scroller.setCapture) {
            editor.renderer.scroller.setCapture();
        }
        editor.setStyle("ace_selecting");
        this.setState("select");
        editor.$blockScrolling--;
    };

    this.select = function() {
        var anchor, editor = this.editor;
        var cursor = editor.renderer.screenToTextCoordinates(this.x, this.y);
        editor.$blockScrolling++;
        if (this.$clickSelection) {
            var cmp = this.$clickSelection.comparePoint(cursor);

            if (cmp == -1) {
                anchor = this.$clickSelection.end;
            } else if (cmp == 1) {
                anchor = this.$clickSelection.start;
            } else {
                var orientedRange = calcRangeOrientation(this.$clickSelection, cursor);
                cursor = orientedRange.cursor;
                anchor = orientedRange.anchor;
            }
            editor.selection.setSelectionAnchor(anchor.row, anchor.column);
        }
        editor.selection.selectToPosition(cursor);
        editor.$blockScrolling--;
        editor.renderer.scrollCursorIntoView();
    };

    this.extendSelectionBy = function(unitName) {
        var anchor, editor = this.editor;
        var cursor = editor.renderer.screenToTextCoordinates(this.x, this.y);
        var range = editor.selection[unitName](cursor.row, cursor.column);
        editor.$blockScrolling++;
        if (this.$clickSelection) {
            var cmpStart = this.$clickSelection.comparePoint(range.start);
            var cmpEnd = this.$clickSelection.comparePoint(range.end);

            if (cmpStart == -1 && cmpEnd <= 0) {
                anchor = this.$clickSelection.end;
                if (range.end.row != cursor.row || range.end.column != cursor.column)
                    cursor = range.start;
            } else if (cmpEnd == 1 && cmpStart >= 0) {
                anchor = this.$clickSelection.start;
                if (range.start.row != cursor.row || range.start.column != cursor.column)
                    cursor = range.end;
            } else if (cmpStart == -1 && cmpEnd == 1) {
                cursor = range.end;
                anchor = range.start;
            } else {
                var orientedRange = calcRangeOrientation(this.$clickSelection, cursor);
                cursor = orientedRange.cursor;
                anchor = orientedRange.anchor;
            }
            editor.selection.setSelectionAnchor(anchor.row, anchor.column);
        }
        editor.selection.selectToPosition(cursor);
        editor.$blockScrolling--;
        editor.renderer.scrollCursorIntoView();
    };

    this.selectEnd =
    this.selectAllEnd =
    this.selectByWordsEnd =
    this.selectByLinesEnd = function() {
        this.$clickSelection = null;
        this.editor.unsetStyle("ace_selecting");
        if (this.editor.renderer.scroller.releaseCapture) {
            this.editor.renderer.scroller.releaseCapture();
        }
    };

    this.focusWait = function() {
        var distance = calcDistance(this.mousedownEvent.x, this.mousedownEvent.y, this.x, this.y);
        var time = Date.now();

        if (distance > DRAG_OFFSET || time - this.mousedownEvent.time > this.$focusTimout)
            this.startSelect(this.mousedownEvent.getDocumentPosition());
    };

    this.onDoubleClick = function(ev) {
        var pos = ev.getDocumentPosition();
        var editor = this.editor;
        var session = editor.session;

        var range = session.getBracketRange(pos);
        if (range) {
            if (range.isEmpty()) {
                range.start.column--;
                range.end.column++;
            }
            this.setState("select");
        } else {
            range = editor.selection.getWordRange(pos.row, pos.column);
            this.setState("selectByWords");
        }
        this.$clickSelection = range;
        this.select();
    };

    this.onTripleClick = function(ev) {
        var pos = ev.getDocumentPosition();
        var editor = this.editor;

        this.setState("selectByLines");
        var range = editor.getSelectionRange();
        if (range.isMultiLine() && range.contains(pos.row, pos.column)) {
            this.$clickSelection = editor.selection.getLineRange(range.start.row);
            this.$clickSelection.end = editor.selection.getLineRange(range.end.row).end;
        } else {
            this.$clickSelection = editor.selection.getLineRange(pos.row);
        }
        this.select();
    };

    this.onQuadClick = function(ev) {
        var editor = this.editor;

        editor.selectAll();
        this.$clickSelection = editor.getSelectionRange();
        this.setState("selectAll");
    };

    this.onMouseWheel = function(ev) {
        if (ev.getAccelKey())
            return;

        //shift wheel to horiz scroll
        if (ev.getShiftKey() && ev.wheelY && !ev.wheelX) {
            ev.wheelX = ev.wheelY;
            ev.wheelY = 0;
        }

        var t = ev.domEvent.timeStamp;
        var dt = t - (this.$lastScrollTime||0);
        
        var editor = this.editor;
        var isScrolable = editor.renderer.isScrollableBy(ev.wheelX * ev.speed, ev.wheelY * ev.speed);
        if (isScrolable || dt < 200) {
            this.$lastScrollTime = t;
            editor.renderer.scrollBy(ev.wheelX * ev.speed, ev.wheelY * ev.speed);
            return ev.stop();
        }
    };

    this.onTouchMove = function (ev) {
        if (ev.editor.renderer.scrollBar.isDragging)
            return;
        if (this.longTouchTimer !== null) {
            clearTimeout(this.longTouchTimer);
            this.longTouchTimer = null;
        }

        this.pinch.ontouchmove(ev.domEvent);

        var touches = ev.domEvent.changedTouches || ev.domEvent.touches;

        this.fastScroller.doTouchMove(touches, ev.domEvent.timeStamp);
        var t = ev.domEvent.timeStamp;
        var dt = t - (this.$lastScrollTime || 0);
        var isScrolable = editor.renderer.isScrollableBy(ev.wheelX * ev.speed, ev.wheelY * ev.speed);
        if (isScrolable || dt < 200) {
            this.$lastScrollTime = t;
            // editor.renderer.scrollBy(ev.wheelX * ev.speed, ev.wheelY * ev.speed);
            return ev.stop();
        }
    };

    this.onTouchStart = function (ev) {
        var editor = ev.editor;
        var container = editor.container;
        var renderer = editor.renderer;
        var content = renderer.content;
        var layerConfig = renderer.layerConfig;
        var touches = ev.domEvent.touches || ev.domEvent.changedTouches;

        if (renderer.scrollBar.isDragging)
            return;

        renderer.showScrollBarV();
        this.fastScroller.setPosition(renderer.getScrollLeft(), renderer.getScrollTop());
        this.fastScroller.setDimensions(container.clientWidth, layerConfig.height, content.clientWidth, layerConfig.maxHeight);
        this.fastScroller.doTouchStart(touches, ev.domEvent.timeStamp);
        renderer.scrollBar._emit("startScroll");

        if (touches.length === 1) {
            var now = ev.domEvent.timeStamp;
            var delta = this.lastTouchTime ? now - this.lastTouchTime : 0;

            if (delta < 250 && delta > 30) {
                this.onDoubleClickHandler(ev);
                return;
            }
            this.lastTouchTime = now;

            this.longTouchTimer = setTimeout(function () {
                editor._signal("onLongTouch");
            }, 500);
        } else {
            this.pinch.ontouchstart(ev.domEvent);
        }
    };

    this.onTouchEnd = function (ev) {
        if (this.longTouchTimer !== null) {
            clearTimeout(this.longTouchTimer);
            this.longTouchTimer = null;
        } else {
            var touches = ev.domEvent.touches || ev.domEvent.changedTouches;
            if (!touches || touches.length === 1) {
                ev.editor._signal("onClick");
            }
        }
        ev.editor.renderer.scrollBar._emit("endScroll");
        ev.editor.renderer.hideScrollBarV();
        this.fastScroller.doTouchEnd(ev.domEvent.timeStamp);
        this.pinch.ontouchend(ev.domEvent);

        this.updateStacks(ev.editor);
    };

    this.updateStacks = function (editor) {
        var pos = editor.selection.getSelectionLead();
        var entity = {'row':pos.row, 'column':pos.column};
        if (this.stacks.length > 0) {
            if (this.stacks[this.stacks.length - 1].row != pos.row) {
                this.stacks.push(entity);
            }
        } else {
            this.stacks.push(entity);
        }
        this.stackPosition = this.stacks.length - 1;
    };

    this.forwardLocation = function () {
        if ( (this.stackPosition + 1) >= this.stacks.length)
            return;

        this.stackPosition++;
        var pos = this.stacks[this.stackPosition];
        this.editor.selection.moveToPosition(pos);
    };

    this.backLocation = function () {
        if (this.stacks.length === 0 || (this.stackPosition - 1) < 0)
            return;

        this.stackPosition--;
        var pos = this.stacks[this.stackPosition];
        this.editor.selection.moveToPosition(pos);
    };

}).call(DefaultHandlers.prototype);

exports.DefaultHandlers = DefaultHandlers;

function calcDistance(ax, ay, bx, by) {
    return Math.sqrt(Math.pow(bx - ax, 2) + Math.pow(by - ay, 2));
}

function calcRangeOrientation(range, cursor) {
    if (range.start.row == range.end.row)
        var cmp = 2 * cursor.column - range.start.column - range.end.column;
    else if (range.start.row == range.end.row - 1 && !range.start.column && !range.end.column)
        var cmp = cursor.column - 4;
    else
        var cmp = 2 * cursor.row - range.start.row - range.end.row;

    if (cmp < 0)
        return {cursor: range.start, anchor: range.end};
    else
        return {cursor: range.end, anchor: range.start};
}

});
