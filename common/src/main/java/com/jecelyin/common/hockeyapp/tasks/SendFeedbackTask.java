package com.jecelyin.common.hockeyapp.tasks;

import android.content.Context;
import android.content.SharedPreferences;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import com.jecelyin.common.R;
import com.jecelyin.common.app.NetLoadingDialog;
import com.jecelyin.common.hockeyapp.Constants;
import com.jecelyin.common.hockeyapp.utils.Util;
import com.jecelyin.common.http.HttpURLConnectionBuilder;
import com.jecelyin.common.utils.L;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <h3>Description</h3>
 *
 * Internal helper class. Sends feedback to server.
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
 * @author Bogdan Nistor
 **/
public class SendFeedbackTask extends ConnectionTask<Void, Void, HashMap<String, String>> {

    public static final String BUNDLE_FEEDBACK_RESPONSE = "feedback_response";
    public static final String BUNDLE_FEEDBACK_STATUS = "feedback_status";
    public static final String BUNDLE_REQUEST_TYPE = "request_type";

    private static final String TAG = "SendFeedbackTask";
    private static final String FILE_TAG = "HockeyApp";

    private Context mContext;
    private Handler mHandler;
    private String mUrlString;
    private String mName;
    private String mEmail;
    private String mSubject;
    private String mText;
    private List<Uri> mAttachmentUris;
    private String mToken;
    private boolean mIsFetchMessages;
    private NetLoadingDialog mProgressDialog;
    private boolean mShowProgressDialog;
    private int mLastMessageId;

    /**
     * Send feedback {@link AsyncTask}.
     * If the class is intended to send a simple feedback message, the a POST is made with the
     * specific data
     * If the class is intended to fetch the messages by providing a token, a GET is made
     *
     * @param context         {@link Context} object
     * @param name            Name of the feedback sender
     * @param email           Email of the feedback sender
     * @param subject         Message subject
     * @param text            The message
     * @param attachmentUris  List of all attached files
     * @param token           Token received after sending the first feedback. This should be
     *                        stored in {@link SharedPreferences}
     * @param handler         Handler object to send data back to the activity
     */
    public SendFeedbackTask(Context context, String name, String email, String subject,
                            String text, List<Uri> attachmentUris, String token, Handler handler) {
        Constants.loadFromContext(context);
        this.mContext = context;
        this.mUrlString = Constants.BASE_URL + "api/2/apps/" + Constants.identifier + "/feedback/";
        this.mName = name;
        this.mEmail = email;
        this.mSubject = subject;
        this.mText = text;
        this.mAttachmentUris = attachmentUris;
        this.mToken = token;
        this.mHandler = handler;
        this.mIsFetchMessages = false;
        this.mShowProgressDialog = true;
        this.mLastMessageId = -1;
    }

    public void setShowProgressDialog(boolean showProgressDialog) {
        this.mShowProgressDialog = showProgressDialog;
    }

    public void setLastMessageId(int lastMessageId) {
        this.mLastMessageId = lastMessageId;
    }

    public void attach(Context context) {
        this.mContext = context;
    }

    public void detach() {
        mContext = null;
        mProgressDialog = null;
    }

    @Override
    protected void onPreExecute() {
        if ((mProgressDialog == null || !mProgressDialog.isShowing()) && mShowProgressDialog) {
            mProgressDialog = new NetLoadingDialog(mContext, R.string.submitting);
            mProgressDialog.show();
        }
    }

    @Override
    protected HashMap<String, String> doInBackground(Void... args) {
        if (mIsFetchMessages && mToken != null) {
            /** If we are fetching messages then do a GET */
            return doGet();
        } else {
            /**
             * If we are sending a feedback do POST, and if we are sending a feedback
             * to an existing discussion do PUT
             */
            if (!mIsFetchMessages) {
                if (mAttachmentUris == null ||  mAttachmentUris.isEmpty()) {
                    return doPostPut();
                } else {
                    HashMap<String, String> result = doPostPutWithAttachments();
                    if (result != null) {
                        clearTemporaryFolder(result);
                    }
                    return result;
                }
            } else {
                return null;
            }
        }
    }

    private void clearTemporaryFolder(HashMap<String, String> result) {
        String status = result.get("status");
        if ((status != null) && (status.startsWith("2")) && (mContext != null)) {
            File folder = new File(mContext.getCacheDir(), FILE_TAG);
            if ((folder != null) && folder.exists()) {
                for (File file : folder.listFiles()) {
                    if (file != null) {
                        Boolean success = file.delete();
                        if (!success) {
                            L.d(TAG, "Error deleting file from temporary folder");
                        }
                    }
                }
            }
        }
    }

    @Override
    protected void onPostExecute(HashMap<String, String> result) {
        if (mProgressDialog != null) {
            try {
                mProgressDialog.dismiss();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        /** If the Handler object is not NULL, send a message to the Activity with the result */
        if (mHandler != null) {
            Message msg = new Message();
            Bundle bundle = new Bundle();

            if (result != null) {
                bundle.putString(BUNDLE_REQUEST_TYPE, result.get("type"));
                bundle.putString(BUNDLE_FEEDBACK_RESPONSE, result.get("response"));
                bundle.putString(BUNDLE_FEEDBACK_STATUS, result.get("status"));
            } else {
                bundle.putString(BUNDLE_REQUEST_TYPE, "unknown");
            }

            msg.setData(bundle);

            mHandler.sendMessage(msg);
        }
    }

    /**
     * POST/PUT
     *
     * @return
     */
    private HashMap<String, String> doPostPut() {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("type", "send");

        HttpURLConnection urlConnection = null;
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("name", mName);
            parameters.put("email", mEmail);
            parameters.put("subject", mSubject);
            parameters.put("text", mText);
            parameters.put("bundle_identifier", Constants.APP_PACKAGE);
            parameters.put("bundle_short_version", Constants.APP_VERSION_NAME);
            parameters.put("bundle_version", Constants.APP_VERSION);
            parameters.put("os_version", Constants.ANDROID_VERSION);
            parameters.put("oem", Constants.PHONE_MANUFACTURER);
            parameters.put("model", Constants.PHONE_MODEL);

            if (mToken != null) {
                mUrlString += mToken + "/";
            }

            urlConnection = new HttpURLConnectionBuilder(mUrlString)
                    .setRequestMethod(mToken != null ? "PUT" : "POST")
                    .writeFormFields(parameters)
                    .build();

            urlConnection.connect();

            result.put("status", String.valueOf(urlConnection.getResponseCode()));
            result.put("response", getStringFromConnection(urlConnection));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    /**
     * POST/PUT with attachments
     *
     * @return
     */
    private HashMap<String, String> doPostPutWithAttachments() {
        HashMap<String, String> result = new HashMap<String, String>();
        result.put("type", "send");

        HttpURLConnection urlConnection = null;
        try {
            Map<String, String> parameters = new HashMap<String, String>();
            parameters.put("name", mName);
            parameters.put("email", mEmail);
            parameters.put("subject", mSubject);
            parameters.put("text", mText);
            parameters.put("bundle_identifier", Constants.APP_PACKAGE);
            parameters.put("bundle_short_version", Constants.APP_VERSION_NAME);
            parameters.put("bundle_version", Constants.APP_VERSION);
            parameters.put("os_version", Constants.ANDROID_VERSION);
            parameters.put("oem", Constants.PHONE_MANUFACTURER);
            parameters.put("model", Constants.PHONE_MODEL);

            if (mToken != null) {
                mUrlString += mToken + "/";
            }

            urlConnection = new HttpURLConnectionBuilder(mUrlString)
                    .setRequestMethod(mToken != null ? "PUT" : "POST")
                    .writeMultipartData(parameters, mContext, mAttachmentUris)
                    .build();

            urlConnection.connect();

            result.put("status", String.valueOf(urlConnection.getResponseCode()));
            result.put("response", getStringFromConnection(urlConnection));

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }

    /**
     * GET
     *
     * @return
     */
    private HashMap<String, String> doGet() {
        StringBuilder sb = new StringBuilder();
        sb.append(mUrlString + Util.encodeParam(mToken));

        if (mLastMessageId != -1) {
            sb.append("?last_message_id=" + mLastMessageId);
        }

        HashMap<String, String> result = new HashMap<String, String>();

        HttpURLConnection urlConnection = null;
        try {

            urlConnection = new HttpURLConnectionBuilder(sb.toString())
                    .build();

            result.put("type", "fetch");

            urlConnection.connect();

            result.put("status", String.valueOf(urlConnection.getResponseCode()));
            result.put("response", getStringFromConnection(urlConnection));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (urlConnection != null) {
                urlConnection.disconnect();
            }
        }

        return result;
    }
}
