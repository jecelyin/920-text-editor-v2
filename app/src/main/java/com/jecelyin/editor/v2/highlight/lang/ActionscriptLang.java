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

package com.jecelyin.editor.v2.highlight.lang;

import com.jecelyin.editor.v2.highlight.LangDefine;
import com.jecelyin.editor.v2.highlight.syntax.*;
/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class ActionscriptLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "{";
        PROPERTY1.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "}";
        PROPERTY2.NAME = "indentCloseBrackets";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "\\s*(if|while)\\s*(|else|case|default:)[^;]*|for\\s*\\(.*)";
        PROPERTY3.NAME = "indentPrevLine";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "false";
        PROPERTY4.NAME = "doubleBracketIndent";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "/*";
        PROPERTY5.NAME = "commentStart";
        PROPERTY PROPERTY6 = new PROPERTY();
        PROPERTY6.VALUE = "*/";
        PROPERTY6.NAME = "commentEnd";
        PROPERTY PROPERTY7 = new PROPERTY();
        PROPERTY7.VALUE = "//";
        PROPERTY7.NAME = "lineComment";
        PROPERTY PROPERTY8 = new PROPERTY();
        PROPERTY8.VALUE = ",+-=<>/?^&*";
        PROPERTY8.NAME = "wordBreakChars";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, PROPERTY6, PROPERTY7, PROPERTY8, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.ESCAPE = "\\";
        RULES1.IGNORE_CASE = "FALSE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.NO_LINE_BREAK = "TRUE";
        SPAN2.TYPE = "LITERAL1";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.NO_LINE_BREAK = "TRUE";
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "CONTEXT";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "//";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "NULL";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "(";
        SEQ2.TYPE = "NULL";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "=";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "!";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = ">=";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "<=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "+";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "-";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "/";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "*";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = ">";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "<";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "%";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "&";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "|";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "^";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "~";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = ".";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "}";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "{";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = ",";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = ";";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "]";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "[";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "?";
        SEQ25.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.AT_LINE_START = "TRUE";
        MARK_PREVIOUS2.MATCH_TYPE = "CONTEXT";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = ":";
        SEQ26.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"this", "NaN", "Infinity", "false", "null", "true", "undefined", "Boolean", "call", "Date", "escape", "eval", "fscommand", "getProperty", "getTimer", "getURL", "getVersion", "gotoAndPlay", "gotoAndStop", "#include", "int", "isFinite", "isNaN", "loadMovie", "loadMovieNum", "loadVariables", "loadVariablesNum", "maxscroll", "newline", "nextFrame", "nextScene", "Number", "parseFloat", "parseInt", "play", "prevFrame", "prevScene", "print", "printAsBitmap", "printAsBitmapNum", "printNum", "random", "removeMovieClip", "scroll", "setProperty", "startDrag", "stop", "stopAllSounds", "stopDrag", "String", "targetPath", "tellTarget", "toggleHighQuality", "trace", "unescape", "unloadMovie", "unloadMovieNum", "updateAfterEvent", "prototype", "clearInterval", "getVersion", "length", "__proto__", "__constructor__", "ASSetPropFlags", "setInterval", "setI", "attachMovie", "createEmptyMovieClip", "createTextField", "duplicateMovieClip", "getBounds", "getBytesLoaded", "getBytesTotal", "getDepth", "globalToLocal", "hitTest", "localToGlobal", "setMask", "swapDepths", "attachAudio", "getInstanceAtDepth", "getNextHighestDepth", "getSWFVersion", "getTextSnapshot", "getSWFVersion", "getSWFVersion", "beginFill", "beginGradientFill", "clear", "curveTo", "endFill", "lineStyle", "lineTo", "moveTo", "enabled", "focusEnabled", "hitArea", "tabChildren", "tabEnabled", "tabIndex", "trackAsMenu", "menu", "useHandCursor", "onData", "onDragOut", "onDragOver", "onEnterFrame", "onKeyDown", "onKeyUp", "onKillFocus", "onLoad", "onMouseDown", "onMouseMove", "onMouseUp", "onPress", "onRelease", "onReleaseOutside", "onRollOut", "onRollOver", "onSetFocus", "onUnload", "MovieClipLoader", "getProgress", "loadClip", "onLoadComplete", "onLoadError", "onLoadInit", "onLoadProgress", "onLoadStart", "unloadClip", "PrintJob", "addPage", "Camera", "activityLevel", "bandwidth", "currentFps", "fps", "index", "motionLevel", "motionTimeOut", "muted", "name", "names", "onActivity", "onStatus", "quality", "setMode", "setMotionLevel", "setQuality", "Microphone", "gain", "rate", "setGain", "setRate", "setSilenceLevel", "setUseEchoSuppression", "silenceLevel", "silenceTimeout", "useEchoSuppression", "ContextMenu", "builtInItems", "copy", "customItems", "hideBuiltInItems", "onSelect", "caption", "ContextMenuItem", "separatorBefore", "visible", "Error", "visible", "message", "_alpha", "_currentframe", "_droptarget", "_focusrect", "_framesloaded", "_height", "_name", "_quality", "_rotation", "_soundbuftime", "_target", "_totalframes", "_url", "_visible", "_width", "_x", "_xmouse", "_xscale", "_y", "_ymouse", "_yscale", "_parent", "_root", "_level", "_lockroot", "_accProps", "sortOn", "toString", "splice", "sort", "slice", "shift", "reverse", "push", "join", "pop", "concat", "unshift", "arguments", "callee", "caller", "valueOf", "getDate", "getDay", "getFullYear", "getHours", "getMilliseconds", "getMinutes", "getMonth", "getSeconds", "getTime", "getTimezoneOffset", "getUTCDate", "getUTCDay", "getUTCFullYear", "getUTCHours", "getUTCMilliseconds", "getUTCMinutes", "getUTCMonth", "getUTCSeconds", "getYear", "setDate", "setFullYear", "setHours", "setMilliseconds", "setMinutes", "setMonth", "setSeconds", "setTime", "setUTCDate", "setUTCFullYear", "setUTCHours", "setUTCMilliseconds", "setUTCMinutes", "setUTCMonth", "setUTCSeconds", "setYear", "UTC", "_global", "apply", "abs", "acos", "asin", "atan", "atan2", "ceil", "cos", "exp", "floor", "log", "max", "min", "pow", "round", "sin", "sqrt", "tan", "E", "LN2", "LN10", "LOG2E", "LOG10E", "PI", "SQRT1_2", "SQRT2", "MAX_VALUE", "MIN_VALUE", "NEGATIVE_INFINITY", "POSITIVE_INFINITY", "addProperty", "registerClass", "unwatch", "watch", "charAt", "charCodeAt", "fromCharCode", "lastIndexOf", "indexOf", "split", "substr", "substring", "toLowerCase", "toUpperCase", "Accessibility", "isActive", "updateProperties", "System", "capabilities", "exactSettings", "setClipboard", "showSettings", "useCodepage", "avHardwareDisable", "hasAccessibility", "hasAudio", "hasAudioEncoder", "hasMP3", "hasVideoEncoder", "pixelAspectRatio", "screenColor", "screenDPI", "screenResolutionX", "screenResolutionY", "hasEmbeddedVideo", "hasPrinting", "hasScreenBroadcast", "hasScreenPlayback", "hasStreamingAudio", "hasStreamingVideo", "isDebugger", "language", "manufacturer", "os", "playerType", "serverString", "localFileReadDisable", "version", "security", "getRGB", "getTransform", "setRGB", "setTransform", "addListener", "getAscii", "isDown", "getCode", "isToggled", "removeListener", "BACKSPACE", "CAPSLOCK", "CONTROL", "DELETEKEY", "DOWN", "END", "ENTER", "ESCAPE", "HOME", "INSERT", "LEFT", "PGDN", "PGUP", "SHIFT", "RIGHT", "SPACE", "TAB", "UP", "hide", "show", "onMouseWheel", "getBeginIndex", "getCaretIndex", "getEndIndex", "getFocus", "setFocus", "setSelection", "SharedObject", "data", "flush", "getLocal", "getSize", "attachSound", "getVolume", "loadSound", "setPan", "getPan", "setVolume", "start", "duration", "position", "onSoundComplete", "id3", "onID3", "Video", "deblocking", "smoothing", "Stage", "align", "height", "scaleMode", "showMenu", "width", "onResize", "getFontList", "getNewTextFormat", "getTextFormat", "removeTextField", "replaceSel", "setNewTextFormat", "setTextFormat", "autoSize", "background", "backgroundColor", "border", "borderColor", "bottomScroll", "embedFonts", "hscroll", "html", "htmlText", "maxChars", "maxhscroll", "multiline", "password", "restrict", "selectable", "text", "textColor", "textHeight", "textWidth", "type", "variable", "wordWrap", "onChanged", "onScroller", "TextField", "mouseWheelEnabled", "replaceText", "StyleSheet", "getStyle", "getStyleNames", "parseCSS", "setStyle", "styleSheet", "TextFormat", "getTextExtent", "blockIndent", "bold", "bullet", "color", "font", "indent", "italic", "leading", "leftMargin", "rightMargin", "size", "tabStops", "target", "underline", "url", "TextSnapshot", "findText", "getCount", "getSelected", "getSelectedText", "hitTestTextNearPos", "getText", "setSelectColor", "setSelected", "LoadVars", "load", "send", "sendAndLoad", "contentType", "loaded", "addRequestHeader", "LocalConnection", "allowDomain", "allowInsecureDomain", "domain", "appendChild", "cloneNode", "createElement", "createTextNode", "hasChildNodes", "insertBefore", "parseXML", "removeNode", "attributes", "childNodes", "docTypeDecl", "firstChild", "ignoreWhite", "lastChild", "nextSibling", "nodeName", "nodeType", "nodeValue", "parentNode", "previousSibling", "status", "xmlDecl", "close", "connect", "onClose", "onConnect", "onXML", "CustomActions", "onUpdate", "uninstall", "list", "install", "get", "NetConnection", "NetStream", "bufferLength", "bufferTime", "bytesLoaded", "bytesTotal", "pause", "seek", "setBufferTime", "time", "DataGlue", "bindFormatFunction", "bindFormatStrings", "getDebugConfig", "getDebugID", "getService", "setCredentials", "setDebugID", "getDebug", "setDebug", "createGatewayConnection", "NetServices", "setDefaultGatewayURL", "addItem", "addItemAt", "addView", "filter", "getColumnNames", "getItemAt", "getLength", "getNumberAvailable", "isFullyPopulated", "isLocal", "removeAll", "removeItemAt", "replaceItemAt", "setDeliveryMode", "setField", "sortItemsBy", "super", });
        KEYWORDS1.add("KEYWORD1", new String[]{"add", "and", "break", "continue", "delete", "do", "else", "eq", "for", "function", "ge", "gt", "if", "ifFrameLoaded", "in", "le", "lt", "ne", "new", "not", "on", "onClipEvent", "or", "return", "tellTarget", "typeof", "var", "while", "with", "instanceof", "#endinitclip", "#initclip", "abstract", "case", "catch", "class", "const", "debugger", "default", "enum", "extends", "final", "finally", "goto", "implements", "instanceof", "interface", "native", "private", "Void", "protected", "public", "dynamic", "override", "static", "switch", "synchronized", "throw", "throws", "transient", "try", "volatile", });
        KEYWORDS1.add("KEYWORD2", new String[]{"Bindable", "chr", "mbchr", "mblength", "mbord", "mbsubstring", "ord", "_highquality", "export", "import", "package", });
        KEYWORDS1.add("KEYWORD3", new String[]{"void", "Array", "Boolean", "Color", "Date", "Function", "Key", "MovieClip", "Sprite", "Math", "Mouse", "Number", "uint", "Object", "Selection", "Sound", "String", "XML", "XMLNode", "XMLSocket", "MMExecute", "boolean", "byte", "char", "double", "float", "int", "long", "short", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
