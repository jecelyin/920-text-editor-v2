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

var SelectHandleDrawables = function(cursor) {
    this.isMidVisible = false;
    this.isLRVisible = false;
    this.element = cursor.element;
    this.cursor = cursor;

    this.addSelectHandle();
};

(function() {

    this.addSelectHandle = function() {
        this.selectHandleLeft = dom.createElement("img");
        this.selectHandleLeft.className = "ace_select_handle ace_l_select_handle";
        this.selectHandleLeft.style.display = "none";
        this.selectHandleLeft.src = "img/text_select_handle_left.png";
        this.element.appendChild(this.selectHandleLeft);

        this.selectHandleMid = dom.createElement("img");
        this.selectHandleMid.className = "ace_select_handle ace_mid_select_handle";
        this.selectHandleMid.style.display = "none";
        this.selectHandleMid.src = "img/text_select_handle_middle.png";
        this.element.appendChild(this.selectHandleMid);

        this.selectHandleRight = dom.createElement("img");
        this.selectHandleRight.className = "ace_select_handle ace_r_select_handle";
        this.selectHandleRight.style.display = "none";
        this.selectHandleRight.src = "img/text_select_handle_right.png";
        this.element.appendChild(this.selectHandleRight);
    };

    this.showMidSelectHandle = function() {
        this.isMidVisible = true;
        this.selectHandleMid.style.display = "";
        this.hideLeftRightSelectHandle();
    };

    this.showLeftRightSelectHandle = function() {
        this.isLRVisible = true;
        this.selectHandleLeft.style.display = "";
        this.selectHandleRight.style.display = "";
        this.hideMidSelectHandle();
    };

    this.hideMidSelectHandle = function() {
        this.selectHandleMid.style.display = "none";
        this.isMidVisible = false;
    };

    this.hideLeftRightSelectHandle = function() {
        this.selectHandleLeft.style.display = "none";
        this.selectHandleRight.style.display = "none";
        this.isLRVisible = false;
    };

    this.update = function(config) {
        this.config = config;
        console.trace("update drawable");
        if (!this.cursor.isVisible) {
            if (this.isMidVisible) this.hideMidSelectHandle();
            if (this.isLRVisible) this.hideLeftRightSelectHandle();
            return;
        }

        var selection = this.cursor.session.selection;
        var lead = selection.getSelectionLead();
        var anchor = selection.getSelectionAnchor();
        var start, end;
        if (anchor.row < lead.row || (anchor.row == lead.row && anchor.column < lead.column)) {
            start = anchor;
            end = lead;
        } else {
            start = lead;
            end = anchor;
        }

        var startPos = this.cursor.session.documentToScreenPosition(start);
        var startCursorLeft = this.cursor.$padding + startPos.column * config.characterWidth;
        var startCursorTop = (startPos.row - config.firstRowScreen) * config.lineHeight + config.lineHeight;

        var style;
        if (anchor.row == lead.row &&
            anchor.column == lead.column) {
            //no selection
            style = this.selectHandleMid.style;
            style.left = startCursorLeft + "px";
            style.top = startCursorTop + "px";
            if (!this.isMidVisible) this.showMidSelectHandle();
        } else {
            style = this.selectHandleLeft.style;
            style.left = startCursorLeft + "px";
            style.top = startCursorTop + "px";

            var endPos = this.cursor.session.documentToScreenPosition(end);
            var endCursorLeft = this.cursor.$padding + endPos.column * config.characterWidth;
            var endCursorTop = (endPos.row - config.firstRowScreen) * config.lineHeight + config.lineHeight;

            style = this.selectHandleRight.style;
            style.left = endCursorLeft + "px";
            style.top = endCursorTop + "px";

            if (!this.isLRVisible) this.showLeftRightSelectHandle();
        }
    };

    this.destroy = function() {

    };

}).call(SelectHandleDrawables.prototype);

exports.SelectHandleDrawables = SelectHandleDrawables;

});