package com.jecelyin.editor.v2.core.content;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Parcelable containing a raw Parcel of data.
 * @hide
 */
public class ParcelableParcel implements Parcelable {
    final Parcel mParcel;
    final ClassLoader mClassLoader;

    public ParcelableParcel(ClassLoader loader) {
        mParcel = Parcel.obtain();
        mClassLoader = loader;
    }

    public ParcelableParcel(Parcel src, ClassLoader loader) {
        mParcel = Parcel.obtain();
        mClassLoader = loader;
        int size = src.readInt();
        int pos = src.dataPosition();
        mParcel.appendFrom(src, src.dataPosition(), size);
        src.setDataPosition(pos + size);
    }

    public Parcel getParcel() {
        mParcel.setDataPosition(0);
        return mParcel;
    }

    public ClassLoader getClassLoader() {
        return mClassLoader;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mParcel.dataSize());
        dest.appendFrom(mParcel, 0, mParcel.dataSize());
    }

    public static final ClassLoaderCreator<ParcelableParcel> CREATOR
            = new ClassLoaderCreator<ParcelableParcel>() {
        public ParcelableParcel createFromParcel(Parcel in) {
            return new ParcelableParcel(in, null);
        }

        public ParcelableParcel createFromParcel(Parcel in, ClassLoader loader) {
            return new ParcelableParcel(in, loader);
        }

        public ParcelableParcel[] newArray(int size) {
            return new ParcelableParcel[size];
        }
    };
}
