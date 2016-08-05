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

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * String工具类
 */
public class StringUtils {

    public static boolean isEmpty(String input) {
        return TextUtils.isEmpty(input);
    }

    /**
     * 不能使用 {@link MessageDigest#isEqual} 因为像华为emui 2.3这个函数不能正确比较
     * @param digesta
     * @param digestb
     * @return
     */
    public static boolean isEqual(byte[] digesta, byte[] digestb) {
        if (digesta.length != digestb.length) {
            return false;
        }
        // Perform a constant time comparison to avoid timing attacks.
        int v = 0;
        for (int i = 0; i < digesta.length; i++) {
            v |= (digesta[i] ^ digestb[i]);
        }
        return v == 0;
    }

    /**
     * 检测变量的值是否为一个整型数据；
     */
    public final static boolean isInt(String value) {
        if (isEmpty(value))
            return false;

        try {
            Integer.parseInt(value);
        } catch (NumberFormatException e) {
            return false;
        }

        return true;
    }

    /**
     * 判断变量的值是否为double类型
     */
    public final static boolean isDouble(String value) {
        if (isEmpty(value))
            return false;
        try {
            Double.parseDouble(value);
        } catch (NumberFormatException e) {
            return false;
        }
        return true;
    }
    /**
     * 解析一个字符串为整数；
     */
    public final static int toInt(String value) {
        return toInt(value, 0);
    }

    public final static int toInt(String value, int defaultValue) {
        try {
            return Integer.parseInt(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 解析一个字符串为double
     */
    public final static double toDouble(String value) {
        return toDouble(value, 0);
    }

    public final static double toDouble(String value, double defaultValue) {
        if (isDouble(value))
            return Double.parseDouble(value);
        return defaultValue;
    }

    /**
     * 解析一个字符串为float
     */
    public static float toFloat(String value) {
        return toFloat(value, 0);
    }

    public static float toFloat(String value, float defaultValue) {
        try {
            return Float.parseFloat(value);
        } catch (Exception e) {
            return defaultValue;
        }
    }

    /**
     * 对象转整数
     *
     * @param obj
     * @return 转换异常返回 0
     */
    public static long toLong(String obj) {
        try {
            return Long.parseLong(obj);
        } catch (Exception e) {
        }
        return 0;
    }

    /**
     * 字符串转布尔值
     *
     * @param b
     * @return 转换异常返回 false
     */
    public static boolean toBool(String b) {
        try {
            return Boolean.parseBoolean(b);
        } catch (Exception e) {
        }
        return false;
    }

    /**
     * 判定输入汉字
     * @param c
     * @return
     */
    public  final static boolean isChinese(char c) {
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

    /**
     * Returns a string containing the tokens joined by delimiters.
     * @param tokens an array objects to be joined.
     */
    public static String join(CharSequence delimiter, int[] tokens) {
        StringBuilder sb = new StringBuilder();
        boolean firstTime = true;
        for (Object token: tokens) {
            if (firstTime) {
                firstTime = false;
            } else {
                sb.append(delimiter);
            }
            sb.append(token);
        }
        return sb.toString();
    }

    public static String urlencode(String s) {
        try {
            s = URLEncoder.encode(s, "UTF-8");
        } catch (Exception e) {
        }
        return s;
    }

    public static String urldecode(String s) {
        try {
            s = URLDecoder.decode(s, "UTF-8");
        } catch (Exception e) {
        }
        return s;
    }

    public static String md5(String s) {
        try {
            // Create MD5 Hash
            MessageDigest digest = java.security.MessageDigest.getInstance("MD5");
            digest.update(s.getBytes());
            byte messageDigest[] = digest.digest();

            // Create Hex String
            StringBuffer hexString = new StringBuffer();
            for (int i = 0; i < messageDigest.length; i++)
                hexString.append(Integer.toHexString(0xFF & messageDigest[i]));
            return hexString.toString();

        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return "";
    }

    public static String formatSize(long size, int decimalPoints) {
        return formatSize(size, decimalPoints, true);
    }

    public static String formatSize(long size) {
        return formatSize(size, true);
    }

    public static String formatSize(long size, boolean includeUnits) {
        return formatSize(size, 2, includeUnits);
    }

    public static String formatSize(long size, int decimalPoints, boolean includeUnits) {

        int kb = 1024;
        int mb = kb * kb;
        int gb = mb * kb;

        if(size < 0) return "";

        int factor = (10 ^ decimalPoints);

        String ssize = "";

        if (size <= kb)
            ssize = size + " B";
        else if (size > kb && size <= mb)
            ssize = ((double)Math.round(((double)size / kb) * factor) / factor)
                    + (includeUnits ? " KB" : "");
        else if (size > mb && size <= gb)
            ssize = ((double)Math.round(((double)size / mb) * factor) / factor)
                    + (includeUnits ? " MB" : "");
        else if (size > gb)
            ssize = ((double)Math.round(((double)size / gb) * factor) / factor)
                    + (includeUnits ? " GB" : "");

        return ssize;
    }

}
