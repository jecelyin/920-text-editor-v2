
package com.jecelyin.common.github;

import com.alibaba.fastjson.JSON;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Type;

/**
 * Gson utilities.
 */
public abstract class GsonUtils {
    
    private final static ThreadLocal<char[]> charsLocal = new ThreadLocal<char[]>();
    
    private static char[] allocatechars(int length) {
        char[] chars = charsLocal.get();

        if (chars == null) {
            if (length <= 1024 * 64) {
                chars = new char[1024 * 64];
                charsLocal.set(chars);
            } else {
                chars = new char[length];
            }
        } else if (chars.length < length) {
            chars = new char[length];
        }

        return chars;
    }


    /**
     * @since 1.2.11
     */
    @SuppressWarnings("unchecked")
    public static <T> T parseObject(Reader is, //
                                    Type type) throws IOException {
 
        char[] chars = allocatechars(1024 * 64);
        int offset = 0;
        for (;;) {
            int readCount = is.read(chars, offset, chars.length - offset);
            if (readCount == -1) {
                break;
            }
            offset += readCount;
            if (offset == chars.length) {
                char[] newchars = new char[chars.length * 3 / 2];
                System.arraycopy(chars, 0, newchars, 0, chars.length);
                chars = newchars;
            }
        }

        return (T) JSON.parseObject(chars, offset, type);
    }

}
