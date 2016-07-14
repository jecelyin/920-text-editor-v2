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

package com.jecelyin.editor.v2.utils;

import android.content.Context;
import android.content.res.AssetManager;

import com.jecelyin.common.utils.L;
import com.jecelyin.common.utils.SysUtils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class BundlesUtils {
    public static File getBundlesDir(Context context) {
        return new File(SysUtils.getCacheDir(context), "Bundles");
    }

    public static void unzipBundles(Context context) throws IOException {
        File cacheDir = SysUtils.getCacheDir(context);
        File okFile = new File(cacheDir, ".bundles_unzip_ok");
        if(L.debug && okFile.isFile())
            return;
        AssetManager assetManager = context.getAssets();
        BufferedReader reader = null;
        InputStream in = null;
        OutputStream out = null;
        try {
            reader = new BufferedReader(new InputStreamReader(assetManager.open("assets.index")));

            // do reading, usually loop until end of file reading
            String mLine;
            while ( (mLine = reader.readLine()) != null ) {
                //process line
                if(!mLine.startsWith("Bundles/"))
                    continue;

                try {
                    in = assetManager.open(mLine);
                    File outFile = new File(cacheDir, mLine);
                    File path = outFile.getParentFile();
                    if(!path.isDirectory() && !path.mkdirs()) {
                        L.e("can't create dir: "+path.getPath());
                        continue;
                    }
                    out = new FileOutputStream(outFile);
                    copyFile(in, out);
                } catch(IOException e) {
                    throw e;
                }
                finally {
                    if (in != null) {
                        try {
                            in.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                    if (out != null) {
                        try {
                            out.close();
                        } catch (IOException e) {
                            // NOOP
                        }
                    }
                }
            }
            okFile.createNewFile();
        } catch (IOException e) {
            throw e;
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    //log the exception
                }
            }
        }

    }
    private static void copyFile(InputStream in, OutputStream out) throws IOException {
        byte[] buffer = new byte[12024];
        int read;
        while((read = in.read(buffer)) != -1){
            out.write(buffer, 0, read);
        }
    }
}
