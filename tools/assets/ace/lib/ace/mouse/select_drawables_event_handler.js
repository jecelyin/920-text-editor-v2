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

define(function(require, exports, module) {
"use strict";
var dom = require("../lib/dom");
var oop = require("../lib/oop");
var event = require("../lib/event");
var MouseEvent = require("./mouse_event").MouseEvent;
var Range = require("../range").Range;

var auchorRow, auchorColumn;
var diffX = 0, diffY = 0;

function SelectDrawableEventHandler(defaultHandler, mouseHandler) {
    this.editor = mouseHandler.editor;
    var selectHandleDrawables = this.editor.renderer.$cursorLayer.selectHandleDrawables;

    event.addListener(selectHandleDrawables.selectHandleMid, "touchstart", function (e) {
        event.stopEvent(e);
        // debugger;
        diffX = getClientX(e) - this.x;
        diffY = getClientY(e) - this.y;
        console.log("touchstart diffX="+diffX+" diffY="+diffY);
        var mouseEvent = new MouseEvent(e, editor, this.x + this.clientWidth/2, this.y - editor.renderer.layerConfig.lineHeight);
        defaultHandler.mousedown(mouseEvent, true);

    });
    event.addListener(selectHandleDrawables.selectHandleMid, "touchmove", function (e) {
        event.stopEvent(e);
        var x, y;
        x = getClientX(e) - diffX + this.clientWidth/2;
        y = getClientY(e) - diffY - this.clientHeight*0.2;
        console.log("move x="+x+" y="+y);
        // mouseHandler.x = getClientX(e) + this.clientWidth/2;
        // mouseHandler.y = getClientY(e) - editor.renderer.layerConfig.lineHeight;
        mouseHandler.x = x;
        mouseHandler.y = y;
        mouseHandler.startSelect(false, false);
        // editor._emit("mousemove", new MouseEvent(e, editor, 0, -selectHandleDrawables.selectHandleMid.style.height));
    });

    var onTouchStart = this.onTouchStart.bind(this);
    var onTouchMove = this.onTouchMove.bind(this);
    event.addListener(selectHandleDrawables.selectHandleLeft, "touchstart", onTouchStart);
    event.addListener(selectHandleDrawables.selectHandleLeft, "touchmove", onTouchMove);
    event.addListener(selectHandleDrawables.selectHandleRight, "touchstart", onTouchStart);
    event.addListener(selectHandleDrawables.selectHandleRight, "touchmove", onTouchMove);

}

(function () {
    this.onTouchStart = function (e) {
        event.stopEvent(e);
        var elem = e.target || e.srcElement;
        // debugger;
        diffX = getClientX(e) - elem.x;
        diffY = getClientY(e) - elem.y;
        var selection = this.editor.selection;

        var anchor = selection.getSelectionAnchor();
        var lead = selection.getSelectionLead();
        var marginLeft = elem.style.marginLeft;
        var x = elem.x + (dom.hasCssClass(elem, "ace_r_select_handle") ? 11 : 33);
        var y = elem.y - this.editor.renderer.layerConfig.lineHeight;
        var pos = this.editor.renderer.screenToTextCoordinates(x, y);
        if (pos.row == lead.row && lead.column == pos.column) {
            auchorRow = anchor.row;
            auchorColumn = anchor.column;
        } else {
            auchorRow = lead.row;
            auchorColumn = lead.column;
        }
    };

    this.onTouchMove = function (e) {
        event.stopEvent(e);
        var elem = e.target || e.srcElement;
        var x, y;
        x = getClientX(e) - diffX + elem.clientWidth/2;
        y = getClientY(e) - diffY - elem.clientHeight*0.2;
        var pos = this.editor.renderer.screenToTextCoordinates(x, y);
        var selection = this.editor.selection;

        var auchor = selection.getSelectionAnchor();
        var lead = selection.getSelectionLead();
        console.log("row="+auchorRow+" col="+auchorColumn+" -> row="+pos.row+" col="+pos.column);

        this.editor.$blockScrolling++;
        this.editor.selection.setSelectionAnchor(auchorRow, auchorColumn);
        this.editor.selection.selectToPosition(pos);
        this.editor.$blockScrolling--;
        this.editor.renderer.scrollCursorIntoView();
    };
}).call(SelectDrawableEventHandler.prototype);

exports.SelectDrawableEventHandler = SelectDrawableEventHandler;

});