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
    var event = require("../lib/event");
    var minFontSize = 8;
    var maxFontSize = 72;

    function Pinch(editor) {
        this.editor = editor;
        this.fn = function(e){
            var size = minFontSize * e.scale;
            // console.log("pinch: scale=" + e.scale + " size=" + size);
            editor.setFontSize(size);
        };

        this.midpoint = null;
        this.scale = 1;
        this.lastScale = 1;
        this.pinching = false;
        this.fingers = {};
    }

    /**
     * Touch start
     *
     * @param {Event} e
     * @return {Pinch}
     * @api private
     */

    Pinch.prototype.ontouchstart = function(e) {
        var touches = e.touches;
        if (!touches || 2 !== touches.length || !this.editor.getZoomable()) return false;

        e.preventDefault();

        if (this.scale === 1) {
            var size = this.editor.getFontSize();
            this.scale = size / minFontSize;
            this.scale = Math.max(this.scale, 1);
        }

        var coords = [];
        for(var i = 0, finger; finger = touches[i]; i++) {
            coords.push(finger.pageX, finger.pageY);
        }

        this.pinching = true;
        this.distance = distance(coords);
        this.midpoint = midpoint(coords);
        return true;
    };

    /**
     * Touch move
     *
     * @param {Event} e
     * @return {Pinch}
     * @api private
     */

    Pinch.prototype.ontouchmove = function(e) {
        var touches = e.touches;
        if (!touches || touches.length !== 2 || !this.pinching || !this.editor.getZoomable()) return false;

        var coords = [];
        for(var i = 0, finger; finger = touches[i]; i++) {
            coords.push(finger.pageX, finger.pageY);
        }

        var changed = e.changedTouches;

        var dist = distance(coords);
        var mid = midpoint(coords);

        // make event properties mutable
        e = event.makeEventMutable(e);

        // iphone does scale natively, just use that
        e.scale = dist / this.distance * this.scale;
        e.scale = Math.min(e.scale, maxFontSize / minFontSize);
        e.scale = Math.max(e.scale, 1);
        e.x = mid.x;
        e.y = mid.y;

        this.fn(e);

        this.lastScale = e.scale;
        return true;
    };

    /**
     * Touchend
     *
     * @param {Event} e
     * @return {Pinch}
     * @api private
     */

    Pinch.prototype.ontouchend = function(e) {
        var touches = e.touches;
        if (!touches || touches.length === 2 || !this.pinching) return false;
        this.scale = this.lastScale;
        this.pinching = false;
        return true;
    };

    /**
     * Get the distance between two points
     *
     * @param {Array} arr
     * @return {Number}
     * @api private
     */

    function distance(arr) {
        var x = Math.pow(arr[0] - arr[2], 2);
        var y = Math.pow(arr[1] - arr[3], 2);
        return Math.sqrt(x + y);
    }

    /**
     * Get the midpoint
     *
     * @param {Array} arr
     * @return {Object} coords
     * @api private
     */

    function midpoint(arr) {
        var coords = {};
        coords.x = (arr[0] + arr[2]) / 2;
        coords.y = (arr[1] + arr[3]) / 2;
        return coords;
    }

    exports.Pinch = Pinch;

});