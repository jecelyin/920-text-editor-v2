
package com.jecelyin.editor.v2.highlight.jedit.util;

import android.support.annotation.Nullable;

import java.io.Closeable;
import java.io.File;
import java.io.Flushable;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectOutput;


/**
 * IO tools that depend on JDK only.
 *
 * @author Matthieu Casanova
 * @version $Id: IOUtilities.java 23221 2013-09-29 20:03:32Z shlomy $
 * @since 4.3pre5
 */
public class IOUtilities {

    //{{{ fileLength() method

    /**
     * Returns the length of a file. If it is a directory it will calculate recursively the length.
     *
     * @param file the file or directory
     * @return the length of the file or directory. If the file doesn't exist it will return 0
     * @since 4.3pre10
     */
    public static long fileLength(File file) {
        long length = 0L;
        if (file.isFile())
            length = file.length();
        else if (file.isDirectory()) {
            File[] files = file.listFiles();
            if (files != null) {
                for (File f : files)
                    length += fileLength(f);
            }
        }
        return length;
    } // }}}

    //{{{ closeQuietly() methods

    /**
     * Method that will close a {@link Closeable} ignoring it if it is null and ignoring exceptions.
     *
     * @param closeable the closeable to close.
     * @since jEdit 4.3pre8
     */
    public static void closeQuietly(@Nullable Closeable closeable) {
        if (closeable != null) {
            try {
                if (closeable instanceof Flushable) {
                    ((Flushable) closeable).flush();
                }
            } catch (IOException e) {
                // ignore
            }
            try {
                closeable.close();
            } catch (IOException e) {
                //ignore
            }
        }
    }


    /**
     * Method that will close an {@link ObjectInput} ignoring it if it is null and ignoring exceptions.
     *
     * @param in the closeable to close.
     * @since jEdit 5.1pre1
     */
    public void closeQuietly(@Nullable ObjectInput in) {
        if (in != null) {
            try {
                in.close();
            } catch (IOException e) {
                // ignore
            }
        }
    }


    /**
     * Method that will close an {@link ObjectOutput} ignoring it if it is null and ignoring exceptions.
     *
     * @param out the closeable to close.
     * @since jEdit 5.1pre1
     */
    public void closeQuietly(@Nullable ObjectOutput out) {
        if (out != null) {
            try {
                out.close();
            } catch (IOException e) {
                // ignore
            }
        }
    } //}}}

    //{{{ IOUtilities() constructor
    private IOUtilities() {
    } //}}}
}
