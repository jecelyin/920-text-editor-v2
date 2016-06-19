package com.jecelyin.common.app.crash;

import android.annotation.SuppressLint;
import android.content.ContentResolver;
import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;

import com.jecelyin.common.utils.L;

import java.io.File;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class CrashConstants {

    private static final String BUNDLE_BUILD_NUMBER = "buildNumber";
    /**
     * Path where crash logs and temporary files are stored.
     */
    public static String FILES_PATH = null;
    /**
     * The app's version code.
     */
    public static String APP_VERSION = null;
    /**
     * The app's version name.
     */
    public static String APP_VERSION_NAME = null;
    /**
     * The app's package name.
     */
    public static String APP_PACKAGE = null;
    /**
     * The device's OS version.
     */
    public static String ANDROID_VERSION = null;
    /**
     * The device's OS build.
     */
    public static String ANDROID_BUILD = null;

    /**
     * The device's model name.
     */
    public static String PHONE_MODEL = null;
    /**
     * The device's model manufacturer name.
     */
    public static String PHONE_MANUFACTURER = null;
    /**
     * Unique identifier for crash reports. This is package and device specific.
     */
    public static String CRASH_IDENTIFIER = null;
    /**
     * Unique identifier for device, not dependent on package or device.
     */
    public static String DEVICE_IDENTIFIER = null;

    /**
     * Initializes constants from the given context. The context is used to set
     * the package name, version code, and the files path.
     *
     * @param context The context to use. Usually your Activity object.
     */
    public static void loadFromContext(Context context) {
        CrashConstants.ANDROID_VERSION = android.os.Build.VERSION.RELEASE;
        CrashConstants.ANDROID_BUILD = android.os.Build.DISPLAY;
        CrashConstants.PHONE_MODEL = android.os.Build.MODEL;
        CrashConstants.PHONE_MANUFACTURER = android.os.Build.MANUFACTURER;

        loadFilesPath(context);
        loadPackageData(context);
        loadCrashIdentifier(context);
        loadDeviceIdentifier(context);
    }

    /**
     * Helper method to set the files path. If an exception occurs, the files
     * path will be null!
     *
     * @param context The context to use. Usually your Activity object.
     */
    private static void loadFilesPath(Context context) {
        if (context != null) {
            try {
                File file = context.getFilesDir();

                // The file shouldn't be null, but apparently it still can happen, see
                // http://code.google.com/p/android/issues/detail?id=8886
                if (file != null) {
                    CrashConstants.FILES_PATH = file.getAbsolutePath();
                }
            } catch (Exception e) {
                L.e("Exception thrown when accessing the files dir:");
                e.printStackTrace();
            }
        }
    }

    /**
     * Helper method to set the package name and version code. If an exception
     * occurs, these values will be null!
     *
     * @param context The context to use. Usually your Activity object.
     */
    private static void loadPackageData(Context context) {
        if (context != null) {
            try {
                PackageManager packageManager = context.getPackageManager();
                PackageInfo packageInfo = packageManager.getPackageInfo(context.getPackageName(), 0);
                CrashConstants.APP_PACKAGE = packageInfo.packageName;
                CrashConstants.APP_VERSION = "" + packageInfo.versionCode;
                CrashConstants.APP_VERSION_NAME = packageInfo.versionName;

                int buildNumber = loadBuildNumber(context, packageManager);
                if ((buildNumber != 0) && (buildNumber > packageInfo.versionCode)) {
                    CrashConstants.APP_VERSION = "" + buildNumber;
                }
            } catch (PackageManager.NameNotFoundException e) {
                L.e("Exception thrown when accessing the package info:");
                e.printStackTrace();
            }
        }
    }

    /**
     * Helper method to load the build number from the AndroidManifest.
     *
     * @param context        the context to use. Usually your Activity object.
     * @param packageManager an instance of PackageManager
     */
    private static int loadBuildNumber(Context context, PackageManager packageManager) {
        try {
            ApplicationInfo appInfo = packageManager.getApplicationInfo(context.getPackageName(), PackageManager.GET_META_DATA);
            Bundle metaData = appInfo.metaData;
            if (metaData != null) {
                return metaData.getInt(BUNDLE_BUILD_NUMBER, 0);
            }
        } catch (PackageManager.NameNotFoundException e) {
            L.e("Exception thrown when accessing the application info:");
            e.printStackTrace();
        }

        return 0;
    }

    /**
     * Helper method to load the crash identifier.
     *
     * @param context the context to use. Usually your Activity object.
     */
    private static void loadCrashIdentifier(Context context) {
        String deviceIdentifier = Settings.Secure.getString(context.getContentResolver(), Settings.Secure.ANDROID_ID);
        if (!TextUtils.isEmpty(CrashConstants.APP_PACKAGE) && !TextUtils.isEmpty(deviceIdentifier)) {
            String combined = CrashConstants.APP_PACKAGE + ":" + deviceIdentifier + ":" + createSalt(context);
            try {
                MessageDigest digest = MessageDigest.getInstance("SHA-1");
                byte[] bytes = combined.getBytes("UTF-8");
                digest.update(bytes, 0, bytes.length);
                bytes = digest.digest();

                CrashConstants.CRASH_IDENTIFIER = bytesToHex(bytes);
            } catch (Throwable e) {
                L.e("Couldn't create CrashIdentifier with Exception:" + e.toString());
                //TODO handle the exeption
            }
        }
    }

    /**
     * Helper method to generate a device identifier for telemetry and crashes,
     *
     * @param context The context to use. Usually your Activity object.
     */
    private static void loadDeviceIdentifier(Context context) {
        // get device ID
        ContentResolver resolver = context.getContentResolver();
        String deviceIdentifier = Settings.Secure.getString(resolver, Settings.Secure.ANDROID_ID);
        if (deviceIdentifier != null) {
            CrashConstants.DEVICE_IDENTIFIER = tryHashStringSha256(context, deviceIdentifier);
        }
    }

    /**
     * Get a SHA-256 hash of the input string if the algorithm is available. If the algorithm is
     * unavailable, return empty string.
     *
     * @param input the string to hash.
     * @return a SHA-256 hash of the input or the input if SHA-256 is not available (should not happen).
     */
    private static String tryHashStringSha256(Context context, String input) {
        String salt = createSalt(context);
        try {
            // Get a Sha256 digest
            MessageDigest hash = MessageDigest.getInstance("SHA-256");
            hash.reset();
            hash.update(input.getBytes());
            hash.update(salt.getBytes());
            byte[] hashedBytes = hash.digest();

            return bytesToHex(hashedBytes);
        } catch (NoSuchAlgorithmException e) {
            // All android devices should support SHA256, but if unavailable return input
            return input;
        }
    }

    /**
     * Helper method to create a salt for the crash identifier.
     *
     * @param context the context to use. Usually your Activity object.
     */
    @SuppressLint("InlinedApi")
    @SuppressWarnings("deprecation")
    private static String createSalt(Context context) {
        String abiString;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            abiString = Build.SUPPORTED_ABIS[0];
        } else {
            abiString = Build.CPU_ABI;
        }

        String fingerprint = "HA" + (Build.BOARD.length() % 10) + (Build.BRAND.length() % 10) +
                (abiString.length() % 10) + (Build.PRODUCT.length() % 10);
        String serial = "";
        try {
            serial = android.os.Build.class.getField("SERIAL").get(null).toString();
        } catch (Throwable t) {
        }

        return fingerprint + ":" + serial;
    }

    /**
     * Helper method to convert a byte array to the hex string.
     * Based on http://stackoverflow.com/questions/9655181/convert-from-byte-array-to-hex-string-in-java
     *
     * @param bytes a byte array
     */
    private static String bytesToHex(byte[] bytes) {
        final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
        char[] hex = new char[bytes.length * 2];
        for (int index = 0; index < bytes.length; index++) {
            int value = bytes[index] & 0xFF;
            hex[index * 2] = HEX_ARRAY[value >>> 4];
            hex[index * 2 + 1] = HEX_ARRAY[value & 0x0F];
        }
        String result = new String(hex);
        return result.replaceAll("(\\w{8})(\\w{4})(\\w{4})(\\w{4})(\\w{12})", "$1-$2-$3-$4-$5");
    }
}