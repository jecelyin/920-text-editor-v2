package com.jecelyin.editor.v2.core.content;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * A single undoable operation.  You must subclass this to implement the state
 * and behavior for your operation.  Instances of this class are placed and
 * managed in an {@link UndoManager}.
 *
 * @hide
 */
public abstract class UndoOperation<DATA> implements Parcelable {
    UndoOwner mOwner;

    /**
     * Create a new instance of the operation.
     * @param owner Who owns the data being modified by this undo state; must be
     * returned by {@link UndoManager#getOwner(String, Object) UndoManager.getOwner}.
     */
    public UndoOperation(UndoOwner owner) {
        mOwner = owner;
    }

    /**
     * Construct from a Parcel.
     */
    protected UndoOperation(Parcel src, ClassLoader loader) {
    }

    /**
     * Owning object as given to {@link #UndoOperation(UndoOwner)}.
     */
    public UndoOwner getOwner() {
        return mOwner;
    }

    /**
     * Synonym for {@link #getOwner()}.{@link UndoOwner#getData()}.
     */
    public DATA getOwnerData() {
        return (DATA)mOwner.getData();
    }

    /**
     * Return true if this undo operation is a member of the given owner.
     * The default implementation is <code>owner == getOwner()</code>.  You
     * can override this to provide more sophisticated dependencies between
     * owners.
     */
    public boolean matchOwner(UndoOwner owner) {
        return owner == getOwner();
    }

    /**
     * Return true if this operation actually contains modification data.  The
     * default implementation always returns true.  If you return false, the
     * operation will be dropped when the final undo state is being built.
     */
    public boolean hasData() {
        return true;
    }

    /**
     * Return true if this operation can be merged with a later operation.
     * The default implementation always returns true.
     */
    public boolean allowMerge() {
        return true;
    }

    /**
     * Called when this undo state is being committed to the undo stack.
     * The implementation should perform the initial edits and save any state that
     * may be needed to undo them.
     */
    public abstract void commit();

    /**
     * Called when this undo state is being popped off the undo stack (in to
     * the temporary redo stack).  The implementation should remove the original
     * edits and thus restore the target object to its prior value.
     */
    public abstract void undo();

    /**
     * Called when this undo state is being pushed back from the transient
     * redo stack to the main undo stack.  The implementation should re-apply
     * the edits that were previously removed by {@link #undo}.
     */
    public abstract void redo();

    public int describeContents() {
        return 0;
    }
}
