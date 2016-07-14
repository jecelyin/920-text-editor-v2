
package com.jecelyin.editor.v2.highlight.jedit.util;

/**
 * A simple collection that stores integers and grows automatically.
 */
public class IntegerArray {
    //{{{ IntegerArray constructor
    public IntegerArray() {
        this(2000);
    } //}}}

    //{{{ IntegerArray constructor
    public IntegerArray(int initialSize) {
        array = new int[initialSize];
    } //}}}

    //{{{ add() method
    public void add(int num) {
        if (len >= array.length) {
            int[] arrayN = new int[len * 2];
            System.arraycopy(array, 0, arrayN, 0, len);
            array = arrayN;
        }

        array[len++] = num;
    } //}}}

    //{{{ get() method
    public final int get(int index) {
        return array[index];
    } //}}}

    //{{{ getSize() method
    public final int getSize() {
        return len;
    } //}}}

    //{{{ setSize() method
    public final void setSize(int len) {
        this.len = len;
    } //}}}

    //{{{ clear() method
    public final void clear() {
        len = 0;
    } //}}}

    //{{{ getArray() method
    public int[] getArray() {
        return array;
    } //}}}

    //{{{ Private members
    private int[] array;
    private int len;
    //}}}
}
