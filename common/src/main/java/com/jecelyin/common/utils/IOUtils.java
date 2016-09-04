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

package com.jecelyin.common.utils;

import android.text.TextUtils;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.util.Arrays;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class IOUtils {
    public static final char[] ILLEGAL_FILENAME_CHARS = {34, 60, 62, 124, 0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13,
            14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 58, 42, 63, 92, 47};

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
            L.e(e);
            file.delete();
            return false;
        }
    }

    public static boolean isInvalidFilename(String fileName) {
        if (TextUtils.isEmpty(fileName))
            return false;

        int size = fileName.length();
        char c;
        for (int i = 0; i < size; i++) {
            c = fileName.charAt(i);
            if (Arrays.binarySearch(ILLEGAL_FILENAME_CHARS, c) >= 0)
                return true;
        }

        return false;
    }

    public static String getFileName(String path) {
        if (TextUtils.isEmpty(path))
            return "";

        return path.substring(path.lastIndexOf('/') + 1);
    }

    public static String toString(InputStream inputStream) throws IOException {
        return toString(inputStream, 16*1024, "UTF-8");
    }

    public static String toString(InputStream inputStream, final int bufferSize, String encoding) throws IOException {
        final char[] buffer = new char[bufferSize];
        final StringBuilder out = new StringBuilder();

        Reader in = new InputStreamReader(inputStream, encoding);
        for (; ; ) {
            int rsz = in.read(buffer, 0, buffer.length);
            if (rsz < 0)
                break;
            out.append(buffer, 0, rsz);
        }

        return out.toString();
    }

    public static boolean isBinaryFile(File f) {
        FileInputStream in = null;
        try {
            in = new FileInputStream(f);
        } catch (FileNotFoundException e) {
            try {
                if (in != null) {
                    in.close();
                }
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return false;
        }
        byte[] data = null;
        try {
            int size = in.available();
            if(size > 1024) size = 1024;
            data = new byte[size];
            in.read(data);
            in.close();
        } catch (IOException e) {
            e.printStackTrace();
            try {
                in.close();
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            return false;
        }

        for (byte b : data) {
            if (b < 0x09) return true;
        }

        return false;
    }

    public static boolean copyFile(File oldLocation, File newLocation) {
        if (!oldLocation.exists()) {
            return false;
        }

        try {
            return copyFile(new FileInputStream(oldLocation), new FileOutputStream(newLocation, false));
        } catch (Exception ex) {
            L.e(ex);
            return false;
        }
    }

    public static boolean copyFile(InputStream inputStream, OutputStream outputStream) {

        BufferedInputStream reader = null;
        BufferedOutputStream writer = null;
        try {
            reader = new BufferedInputStream(inputStream);
            writer = new BufferedOutputStream(outputStream);

            byte[] buff = new byte[8192];
            int numChars;
            while ((numChars = reader.read(buff, 0, buff.length)) != -1) {
                writer.write(buff, 0, numChars);
            }

            return true;
        } catch (Exception ex) {
            return false;
        } finally {
            try {
                if (reader != null) {
                    reader.close();
                }
            } catch (IOException ex) {
                L.d(ex);
            }
            try {
                if (writer != null) {
                    writer.close();
                }
            } catch (IOException ex) {
                L.d(ex);
            }
        }
    }
}
