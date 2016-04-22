package com.jecelyin.common.http;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Random;

/**
 * <h3>Description</h3>
 *
 * To avoid external apache library "httpmime" this is a simple implementation for a MultipartEntity.
 * Please note that first all key value pairs have to be written and then at least one file part has to be added.
 * Otherwise the boundaries are not written correctly.
 *
 * Based on:
 * http://derivedcode.wordpress.com/2014/11/04/android-uploading-files-to-server-over-http-using-multipart-entity/
 *
 * <h3>License</h3>
 *
 * <pre>
 * Copyright (c) 2011-2014 Bit Stadium GmbH
 *
 * Permission is hereby granted, free of charge, to any person
 * obtaining a copy of this software and associated documentation
 * files (the "Software"), to deal in the Software without
 * restriction, including without limitation the rights to use,
 * copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the
 * Software is furnished to do so, subject to the following
 * conditions:
 *
 * The above copyright notice and this permission notice shall be
 * included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND,
 * EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES
 * OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
 * NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT
 * HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY,
 * WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING
 * FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR
 * OTHER DEALINGS IN THE SOFTWARE.
 * </pre>
 *
 * @author Patrick Eschenbach
 */
public class SimpleMultipartEntity {

    private final static char[] BOUNDARY_CHARS = "-_1234567890abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ".toCharArray();

    private boolean mIsSetLast;

    private boolean mIsSetFirst;

    private ByteArrayOutputStream mOut;

    private String mBoundary;

    public SimpleMultipartEntity() {
        this.mIsSetFirst = false;
        this.mIsSetLast = false;
        this.mOut = new ByteArrayOutputStream();

        /** Create boundary String */
        final StringBuffer buffer = new StringBuffer();
        final Random rand = new Random();

        for (int i = 0; i < 30; i++) {
            buffer.append(BOUNDARY_CHARS[rand.nextInt(BOUNDARY_CHARS.length)]);
        }
        this.mBoundary = buffer.toString();
    }

    public String getBoundary() {
        return mBoundary;
    }

    public void writeFirstBoundaryIfNeeds() throws IOException {
        if (!mIsSetFirst) {
            mOut.write(("--" + mBoundary + "\r\n").getBytes());
        }
        mIsSetFirst = true;
    }

    public void writeLastBoundaryIfNeeds() {
        if (mIsSetLast) {
            return;
        }
        try {
            mOut.write(("\r\n--" + mBoundary + "--\r\n").getBytes());

        } catch (final IOException e) {
            e.printStackTrace();
        }
        mIsSetLast = true;
    }

    public void addPart(final String key, final String value) throws IOException {
        writeFirstBoundaryIfNeeds();

        mOut.write(("Content-Disposition: form-data; name=\"" + key + "\"\r\n").getBytes());
        mOut.write("Content-Type: text/plain; charset=UTF-8\r\n".getBytes());
        mOut.write("Content-Transfer-Encoding: 8bit\r\n\r\n".getBytes());
        mOut.write(value.getBytes());
        mOut.write(("\r\n--" + mBoundary + "\r\n").getBytes());
    }

    public void addPart(final String key, final File value, boolean lastFile) throws IOException {
        addPart(key, value.getName(), new FileInputStream(value), lastFile);
    }

    public void addPart(final String key, final String fileName, final InputStream fin, boolean lastFile) throws IOException {
        addPart(key, fileName, fin, "application/octet-stream", lastFile);
    }

    public void addPart(final String key, final String fileName, final InputStream fin, String type, boolean lastFile) throws IOException {
        writeFirstBoundaryIfNeeds();
        try {
            type = "Content-Type: " + type + "\r\n";
            mOut.write(("Content-Disposition: form-data; name=\"" + key + "\"; filename=\"" + fileName + "\"\r\n").getBytes());
            mOut.write(type.getBytes());
            mOut.write("Content-Transfer-Encoding: binary\r\n\r\n".getBytes());

            final byte[] tmp = new byte[4096];
            int l = 0;
            while ((l = fin.read(tmp)) != -1) {
                mOut.write(tmp, 0, l);
            }
            mOut.flush();

            if (lastFile) {
                /** This is the last file: write last boundary. */
                writeLastBoundaryIfNeeds();

            } else {
                /** Another file will follow: write normal boundary. */
                mOut.write(("\r\n--" + mBoundary + "\r\n").getBytes());
            }

        } finally {
            try {
                fin.close();
            } catch (final IOException e) {
                e.printStackTrace();
            }
        }
    }

    public long getContentLength() {
        writeLastBoundaryIfNeeds();
        return mOut.toByteArray().length;
    }

    public String getContentType() {
        return "multipart/form-data; boundary=" + getBoundary();
    }

    public ByteArrayOutputStream getOutputStream() {
        writeLastBoundaryIfNeeds();
        return mOut;
    }

}
