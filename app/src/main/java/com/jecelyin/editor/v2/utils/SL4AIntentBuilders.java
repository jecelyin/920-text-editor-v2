package com.jecelyin.editor.v2.utils;

import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.os.Parcelable;

import java.io.File;


public class SL4AIntentBuilders {
    /** An arbitrary value that is used to identify pending intents for executing scripts. */
    private static final int EXECUTE_SCRIPT_REQUEST_CODE = 0x12f412a;

    private SL4AIntentBuilders() {
        // Utility class.
    }

    public static Intent buildTriggerServiceIntent() {
        Intent intent = new Intent();
        intent.setComponent(Constants.TRIGGER_SERVICE_COMPONENT_NAME);
        return intent;
    }

    /**
     * Builds an intent that will launch a script in the background.
     *
     * @param script
     *          the script to launch
     * @return the intent that will launch the script
     */
    public static Intent buildStartInBackgroundIntent(File script) {
        final ComponentName componentName = Constants.SL4A_SERVICE_LAUNCHER_COMPONENT_NAME;
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setAction(Constants.ACTION_LAUNCH_BACKGROUND_SCRIPT);
        intent.putExtra(Constants.EXTRA_SCRIPT_PATH, script.getAbsolutePath());
        return intent;
    }

    /**
     * Builds an intent that launches a script in a terminal.
     *
     * @param script
     *          the script to launch
     * @return the intent that will launch the script
     */
    public static Intent buildStartInTerminalIntent(File script) {
        final ComponentName componentName = Constants.SL4A_SERVICE_LAUNCHER_COMPONENT_NAME;
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setAction(Constants.ACTION_LAUNCH_FOREGROUND_SCRIPT);
        intent.putExtra(Constants.EXTRA_SCRIPT_PATH, script.getAbsolutePath());
        return intent;
    }

    /**
     * Builds an intent that launches an interpreter.
     *
     * @param interpreterName
     *          the interpreter to launch
     * @return the intent that will launch the interpreter
     */
    public static Intent buildStartInterpreterIntent(String interpreterName) {
        final ComponentName componentName = Constants.SL4A_SERVICE_LAUNCHER_COMPONENT_NAME;
        Intent intent = new Intent();
        intent.setComponent(componentName);
        intent.setAction(Constants.ACTION_LAUNCH_INTERPRETER);
        intent.putExtra(Constants.EXTRA_INTERPRETER_NAME, interpreterName);
        return intent;
    }

    /**
     * Builds an intent that creates a shortcut to launch the provided interpreter.
     *
     * @param interpreter
     *          the interpreter to link to
     * @param iconResource
     *          the icon resource to associate with the shortcut
     * @return the intent that will create the shortcut
     */
//    public static Intent buildInterpreterShortcutIntent(Interpreter interpreter,
//                                                        Parcelable iconResource) {
//        Intent intent = new Intent();
//        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT,
//                buildStartInterpreterIntent(interpreter.getName()));
//        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, interpreter.getNiceName());
//        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
//        return intent;
//    }

    /**
     * Builds an intent that creates a shortcut to launch the provided script in the background.
     *
     * @param script
     *          the script to link to
     * @param iconResource
     *          the icon resource to associate with the shortcut
     * @return the intent that will create the shortcut
     */
    public static Intent buildBackgroundShortcutIntent(File script, Parcelable iconResource) {
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, buildStartInBackgroundIntent(script));
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, script.getName());
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
        return intent;
    }

    /**
     * Builds an intent that creates a shortcut to launch the provided script in a terminal.
     *
     * @param script
     *          the script to link to
     * @param iconResource
     *          the icon resource to associate with the shortcut
     * @return the intent that will create the shortcut
     */
    public static Intent buildTerminalShortcutIntent(File script, Parcelable iconResource) {
        Intent intent = new Intent();
        intent.putExtra(Intent.EXTRA_SHORTCUT_INTENT, buildStartInTerminalIntent(script));
        intent.putExtra(Intent.EXTRA_SHORTCUT_NAME, script.getName());
        intent.putExtra(Intent.EXTRA_SHORTCUT_ICON_RESOURCE, iconResource);
        return intent;
    }

    /**
     * Creates a pending intent that can be used to start the trigger service.
     *
     * @param context
     *          the context under whose authority to launch the intent
     *
     * @return {@link PendingIntent} object for running the trigger service
     */
    public static PendingIntent buildTriggerServicePendingIntent(Context context) {
        final Intent intent = buildTriggerServiceIntent();
        return PendingIntent.getService(context, EXECUTE_SCRIPT_REQUEST_CODE, intent,
                PendingIntent.FLAG_UPDATE_CURRENT);
    }

    public static class Constants {

        public static final String ACTION_LAUNCH_FOREGROUND_SCRIPT =
                "com.googlecode.android_scripting.action.LAUNCH_FOREGROUND_SCRIPT";
        public static final String ACTION_LAUNCH_BACKGROUND_SCRIPT =
                "com.googlecode.android_scripting.action.LAUNCH_BACKGROUND_SCRIPT";
        public static final String ACTION_LAUNCH_SCRIPT_FOR_RESULT =
                "com.googlecode.android_scripting.action.ACTION_LAUNCH_SCRIPT_FOR_RESULT";
        public static final String ACTION_LAUNCH_INTERPRETER =
                "com.googlecode.android_scripting.action.LAUNCH_INTERPRETER";
        public static final String ACTION_EDIT_SCRIPT =
                "com.googlecode.android_scripting.action.EDIT_SCRIPT";
        public static final String ACTION_SAVE_SCRIPT =
                "com.googlecode.android_scripting.action.SAVE_SCRIPT";
        public static final String ACTION_SAVE_AND_RUN_SCRIPT =
                "com.googlecode.android_scripting.action.SAVE_AND_RUN_SCRIPT";
        public static final String ACTION_KILL_PROCESS =
                "com.googlecode.android_scripting.action.KILL_PROCESS";
        public static final String ACTION_KILL_ALL = "com.googlecode.android_scripting.action.KILL_ALL";
        public static final String ACTION_SHOW_RUNNING_SCRIPTS =
                "com.googlecode.android_scripting.action.SHOW_RUNNING_SCRIPTS";
        public static final String ACTION_CANCEL_NOTIFICATION =
                "com.googlecode.android_scripting.action.CANCEL_NOTIFICAITON";
        public static final String ACTION_ACTIVITY_RESULT =
                "com.googlecode.android_scripting.action.ACTIVITY_RESULT";
        public static final String ACTION_LAUNCH_SERVER =
                "com.googlecode.android_scripting.action.LAUNCH_SERVER";

        public static final String EXTRA_RESULT = "SCRIPT_RESULT";
        public static final String EXTRA_SCRIPT_PATH =
                "com.googlecode.android_scripting.extra.SCRIPT_PATH";
        public static final String EXTRA_SCRIPT_CONTENT =
                "com.googlecode.android_scripting.extra.SCRIPT_CONTENT";
        public static final String EXTRA_INTERPRETER_NAME =
                "com.googlecode.android_scripting.extra.INTERPRETER_NAME";

        public static final String EXTRA_USE_EXTERNAL_IP =
                "com.googlecode.android_scripting.extra.USE_PUBLIC_IP";
        public static final String EXTRA_USE_SERVICE_PORT =
                "com.googlecode.android_scripting.extra.USE_SERVICE_PORT";
        public static final String EXTRA_SCRIPT_TEXT =
                "com.googlecode.android_scripting.extra.SCRIPT_TEXT";
        public static final String EXTRA_RPC_HELP_TEXT =
                "com.googlecode.android_scripting.extra.RPC_HELP_TEXT";
        public static final String EXTRA_API_PROMPT_RPC_NAME =
                "com.googlecode.android_scripting.extra.API_PROMPT_RPC_NAME";
        public static final String EXTRA_API_PROMPT_VALUES =
                "com.googlecode.android_scripting.extra.API_PROMPT_VALUES";
        public static final String EXTRA_PROXY_PORT = "com.googlecode.android_scripting.extra.PROXY_PORT";
        public static final String EXTRA_PROCESS_ID =
                "com.googlecode.android_scripting.extra.SCRIPT_PROCESS_ID";
        public static final String EXTRA_IS_NEW_SCRIPT =
                "com.googlecode.android_scripting.extra.IS_NEW_SCRIPT";
        public static final String EXTRA_TRIGGER_ID =
                "com.googlecode.android_scripting.extra.EXTRA_TRIGGER_ID";
        public static final String EXTRA_LAUNCH_IN_BACKGROUND =
                "com.googlecode.android_scripting.extra.EXTRA_LAUNCH_IN_BACKGROUND";
        public static final String EXTRA_TASK_ID = "com.googlecode.android_scripting.extra.EXTRA_TASK_ID";

        // BluetoothDeviceManager
        public static final String EXTRA_DEVICE_ADDRESS =
                "com.googlecode.android_scripting.extra.device_address";

        public static final ComponentName SL4A_SERVICE_COMPONENT_NAME = new ComponentName(
                "com.googlecode.android_scripting",
                "com.googlecode.android_scripting.activity.ScriptingLayerService");
        public static final ComponentName SL4A_SERVICE_LAUNCHER_COMPONENT_NAME = new ComponentName(
                "com.googlecode.android_scripting",
                "com.googlecode.android_scripting.activity.ScriptingLayerServiceLauncher");
        public static final ComponentName BLUETOOTH_DEVICE_LIST_COMPONENT_NAME = new ComponentName(
                "com.googlecode.android_scripting",
                "com.googlecode.android_scripting.activity.BluetoothDeviceList");
        public static final ComponentName TRIGGER_SERVICE_COMPONENT_NAME = new ComponentName(
                "com.googlecode.android_scripting",
                "com.googlecode.android_scripting.activity.TriggerService");

        // Preference Keys

        public static final String FORCE_BROWSER = "helpForceBrowser";
        public final static String HIDE_NOTIFY = "hideServiceNotifications";
    }
}
