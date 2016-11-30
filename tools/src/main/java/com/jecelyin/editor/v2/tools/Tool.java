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

package com.jecelyin.editor.v2.tools;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class Tool {
    public static void o(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    public static String fileNameToResName(String filename) {
        StringBuilder sb = new StringBuilder(filename.length());
        int size = filename.length();
        for (int i = 0; i < size; i++) {
            char c = filename.charAt(i);
            if (c == '-') {
                i++;
                sb.append('_');
            } else if (c == '.') {
                return sb.toString();
            } else {
                sb.append(Character.toLowerCase(filename.charAt(i)));
            }
        }
        return sb.toString();
    }

    public static String textString(String string) {
        StringBuilder sb = new StringBuilder(string.length() * 2);
        sb.append('"');
        int size = string.length();
        for (int i = 0; i < size; i++) {
            char c = string.charAt(i);
            switch (c) {
                case '\\':
                    sb.append("\\\\");
                    break;
                case '"':
                    sb.append("\\\"");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        sb.append('"');
        return sb.toString();
    }

    public static String space(int count) {
        return new String(new char[count]).replace("\0", " ");
    }

    public static String readFile(File file) throws IOException {
        return readFile(file, "UTF-8");
    }

    public static String readFile(File file, String encoding) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        char[] buf = new char[8192];
        int size;
        StringBuilder sb = new StringBuilder((int) file.length());
        while ((size = br.read(buf)) != -1) {
            sb.append(buf, 0, size);
        }
        return sb.toString();
    }


    public static boolean writeFile(File file, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            file.delete();
            return false;
        }
    }

    public static String globToRE(String glob) {
        if (glob.startsWith("(re)")) {
            return glob.substring(4);
        }

        final Object NEG = new Object();
        final Object GROUP = new Object();
        Stack<Object> state = new Stack<Object>();

        StringBuilder buf = new StringBuilder();
        boolean backslash = false;

        int length = glob.length();
        for (int i = 0; i < length; i++) {
            char c = glob.charAt(i);
            if (backslash) {
                buf.append('\\');
                buf.append(c);
                backslash = false;
                continue;
            }

            switch (c) {
                case '\\':
                    backslash = true;
                    break;
                case '?':
                    buf.append('.');
                    break;
                case '.':
                case '+':
                case '(':
                case ')':
                    buf.append('\\');
                    buf.append(c);
                    break;
                case '*':
                    buf.append(".*");
                    break;
                case '|':
                    if (backslash)
                        buf.append("\\|");
                    else
                        buf.append('|');
                    break;
                case '{':
                    buf.append('(');
                    if (i + 1 != length && glob.charAt(i + 1) == '!') {
                        buf.append('?');
                        state.push(NEG);
                    } else
                        state.push(GROUP);
                    break;
                case ',':
                    if (!state.isEmpty() && state.peek() == GROUP)
                        buf.append('|');
                    else
                        buf.append(',');
                    break;
                case '}':
                    if (!state.isEmpty()) {
                        buf.append(')');
                        if (state.pop() == NEG)
                            buf.append(".*");
                    } else
                        buf.append('}');
                    break;
                default:
                    buf.append(c);
            }
        }

        return buf.toString();
    } //}}}

}
