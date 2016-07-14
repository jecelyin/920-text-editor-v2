
package com.jecelyin.editor.v2.highlight.jedit.util;

import com.jecelyin.editor.v2.highlight.jedit.Segment;

/**
 * Class that lets java.util.regex search within a javax.swing.text.Segment.
 *
 * @author Marcelo Vanzin
 */
public class SegmentCharSequence implements CharSequence {
    public SegmentCharSequence(Segment seg) {
        this(seg, 0, seg.count);
    }

    public SegmentCharSequence(Segment seg, int off, int len) {
        this.offset = off;
        this.length = len;
        this.seg = seg;
    }

    public char charAt(int index) {
        return seg.array[seg.offset + offset + index];
    }

    public int length() {
        return length;
    }

    public CharSequence subSequence(int start, int end) {
        return new SegmentCharSequence(seg, offset + start, end - start);
    }

    public String toString() {
        return new String(seg.array, offset + seg.offset, length);
    }

    private int offset;
    private int length;
    private Segment seg;
}

