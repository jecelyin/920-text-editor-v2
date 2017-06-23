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

package com.jecelyin.editor.v2.ui;

import android.os.Parcelable;

import com.alibaba.fastjson.JSON;
import com.jecelyin.common.task.TaskListener;
import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.utils.ExtGrep;

import java.io.File;
import java.util.List;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class EditorObjectProcessor {
    public static void process(Parcelable object, EditorDelegate editorDelegate) {
        if (object instanceof ExtGrep) {
            new FindInFilesProcessor(object, editorDelegate);
        }
    }

    private static class FindInFilesProcessor {
        ExtGrep grep;

        public FindInFilesProcessor(Parcelable object, EditorDelegate editorDelegate) {
            grep = (ExtGrep) object;

            find();
        }

        private void find() {
            grep.execute(new TaskListener<List<ExtGrep.Result>>() {
                @Override
                public void onCompleted() {

                }

                @Override
                public void onSuccess(List<ExtGrep.Result> result) {
                    buildResults(result);
                }

                @Override
                public void onError(Exception e) {
                    L.e(e);
                }
            });
        }

        private void buildResults(List<ExtGrep.Result> results) {
            StringBuilder ssb = new StringBuilder();

            File file = null;
            for(ExtGrep.Result rs : results) {
                if(file == null || !rs.file.equals(file)) {
                    file = rs.file;
                    ssb.append("\n")
                    .append("<div class=\"ace_line\"><span class=\"ace_constant ace_language\">")
                    .append(file.getPath())
                    .append("</span></div>")
//                    ssb.append(file.getPath(), new ForegroundColorSpan(findResultsPathColor), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                    .append("\n");
                }
                //%[index$][标识]*[最小宽度][.精度]转换符
//                ssb.append(String.format("%1$4d  %2$s\n", rs.lineNumber, rs.line), new FileClickableSpan(editorDelegate, rs), Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssb.append("<div class=\"ace_line\">");
                ssb.append(String.format("%1$4d  ", rs.lineNumber));
                int length = ssb.length();
                int start = length + rs.matchStart;
                int end = length + rs.matchEnd;
                ssb.append(rs.line.substring(0, start));
                ssb.append("<span onclick=\"AndroidEditor.openFile(")
                   .append(JSON.toJSONString(rs.file.getPath()))
                   .append(", ")
                   .append(rs.startOffset)
                   .append(")\" class=\"ace_constant ace_language\">")
                   .append(rs.line.substring(start, end))
                   .append("</span>")
                   .append(rs.line.substring(end));
//                ssb.setSpan(new ForegroundColorSpan(findResultsKeywordColor), length + rs.matchStart, length + rs.matchEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
//                ssb.setSpan(new FileClickableSpan(findResultsKeywordColor, editorDelegate, rs), length + rs.matchStart, length + rs.matchEnd, Spanned.SPAN_EXCLUSIVE_EXCLUSIVE);
                ssb.append('\n');
            }
//            editText.setText(ssb);
        }

    }

}
