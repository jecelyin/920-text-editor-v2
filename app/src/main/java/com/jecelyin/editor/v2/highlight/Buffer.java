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

package com.jecelyin.editor.v2.highlight;


import android.content.Context;
import android.text.Editable;

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.core.text.SpannableStringBuilder;
import com.jecelyin.editor.v2.highlight.jedit.LineManager;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.Segment;
import com.jecelyin.editor.v2.highlight.jedit.syntax.DefaultTokenHandler;
import com.jecelyin.editor.v2.highlight.jedit.syntax.DummyTokenHandler;
import com.jecelyin.editor.v2.highlight.jedit.syntax.ParserRuleSet;
import com.jecelyin.editor.v2.highlight.jedit.syntax.Token;
import com.jecelyin.editor.v2.highlight.jedit.syntax.TokenHandler;
import com.jecelyin.editor.v2.highlight.jedit.syntax.TokenMarker;
import com.jecelyin.editor.v2.highlight.jedit.util.IntegerArray;


/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class Buffer {
    private final Context context;
    private TokenMarker tokenMarker;
    private LineManager lineMgr;
    private Editable editable;
    private final IntegerArray integerArray;
    private Mode mode;

    public Buffer(Context context) {
        this.context = context;
        editable = new SpannableStringBuilder();
        lineMgr = new LineManager();
        integerArray = new IntegerArray();

//        ModeProvider.instance.setAssets(context.getAssets());
    }

    public LineManager getLineManager() {
        return lineMgr;
    }

    public Context getContext() {
        return context;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
        tokenMarker = mode == null ? null : mode.getTokenMarker();
    }

    public Mode getMode() {
        return mode;
    }

    public boolean isCanHighlight() {
        return mode != null && tokenMarker != null;
    }

    public int getOffset() {
        return editable.length();
    }

    /**
     * Returns the specified line in a <code>Segment</code>.<p>
     * <p/>
     * Using a <classname>Segment</classname> is generally more
     * efficient than using a <classname>String</classname> because it
     * results in less memory allocation and array copying.<p>
     * <p/>
     * This method is thread-safe.
     *
     * @param line The line
     * @since jEdit 4.0pre1
     */
    public void getLineText(int line, Segment segment) {
        getLineText(line, 0, segment);
    }

    /**
     * Returns the specified line from the starting point passed in relativeStartOffset  in a <code>Segment</code>.<p>
     * <p/>
     * Using a <classname>Segment</classname> is generally more
     * efficient than using a <classname>String</classname> because it
     * results in less memory allocation and array copying.<p>
     * <p/>
     * This method is thread-safe.
     *
     * @param line The line
     * @since jEdit 4.0pre1
     */
    public void getLineText(int line, int relativeStartOffset, Segment segment) {
        if (line < 0 || line >= lineMgr.getLineCount())
            throw new ArrayIndexOutOfBoundsException(line);

        int start = (line == 0 ? 0 : lineMgr.getLineEndOffset(line - 1));
        int end = lineMgr.getLineEndOffset(line);
        if ((start + relativeStartOffset) > end) {
            throw new IllegalArgumentException("This index is outside the line length (start+relativeOffset):" + start + " + " + relativeStartOffset + " > " + "endffset:" + end);
        } else {
            getText(start + relativeStartOffset, end - start - relativeStartOffset - 1, segment);
        }

    } //}}}

    public void getText(int start, int length, Segment seg) {
        if (start < 0 || length < 0
                || start + length > editable.length())
            throw new ArrayIndexOutOfBoundsException(start + "+" + length + " > " + editable.length());

//        editable.getText(start, length, seg);
        getTextByContentManager(start, length, seg);
    } //}}}

    /**
     * Returns the specified text range in a <code>Segment</code>.<p>
     * <p/>
     * Using a <classname>Segment</classname> is generally more
     * efficient than using a <classname>String</classname> because it
     * results in less memory allocation and array copying.<p>
     *
     * @param start The start offset
     * @param len   The number of characters to get
     * @param seg   The segment to copy the text to
     */
    private void getTextByContentManager(int start, int len, Segment seg) {
//        if (start >= gapStart) {
//            seg.array = text;
//            seg.offset = start + gapLength();
//            seg.count = len;
//        } else if (start + len <= gapStart) {
//            seg.array = text;
//            seg.offset = start;
//            seg.count = len;
//        } else {
//            seg.array = new char[len];
//
//            // copy text before gap
//            System.arraycopy(text, start, seg.array, 0, gapStart - start);
//
//            // copy text after gap
//            System.arraycopy(text, gapEnd(), seg.array, gapStart - start,
//                    len + start - gapStart);
//
//            seg.offset = 0;
//            seg.count = len;
//        }
        char[] dest = new char[len];
        editable.getChars(start, start+len, dest, 0);
        seg.array = dest;
        seg.offset = 0;
        seg.count = len;
    } //}}}

    protected TokenMarker.LineContext markTokens(Segment seg, TokenMarker.LineContext prevContext,
                                                 TokenHandler _tokenHandler) {
        TokenMarker.LineContext context;
//            if (longBufferMode && longLineLimit != 0 && longLineLimit < seg.length())
//            {
//                context = tokenMarker.markTokens(prevContext, _tokenHandler, seg);
//            }
//            else
//            {
        context = tokenMarker.markTokens(prevContext, _tokenHandler, seg);
//            }
        return context;
    }

    //{{{ markTokens() method

    /**
     * Returns the syntax tokens for the specified line.
     *
     * @param lineIndex    The line number
     * @param tokenHandler The token handler that will receive the syntax
     *                     tokens
     * @since jEdit 4.1pre1
     */
    public void markTokens(int lineIndex, TokenHandler tokenHandler) {
        Segment seg = new Segment();

        if (lineIndex < 0 || lineIndex >= lineMgr.getLineCount()) {
            L.e(new ArrayIndexOutOfBoundsException("lineCount=" + lineMgr.getLineCount() + "; index=" + lineIndex));
            return;
        }

        int firstInvalidLineContext = lineMgr.getFirstInvalidLineContext();
        int start;
        if (firstInvalidLineContext == -1) {
            start = lineIndex;
        } else {
            start = Math.min(firstInvalidLineContext,
                    lineIndex);
        }

//            if(Debug.TOKEN_MARKER_DEBUG)
//                Log.log(Log.DEBUG, this, "tokenize from " + start + " to " + lineIndex);
        TokenMarker.LineContext oldContext = null;
        TokenMarker.LineContext context = null;
        for (int i = start; i <= lineIndex; i++) {
            getLineText(i, seg);

            oldContext = lineMgr.getLineContext(i);

            TokenMarker.LineContext prevContext = (
                    (i == 0) ? null
                            : lineMgr.getLineContext(i - 1)
            );

            TokenHandler _tokenHandler = i == lineIndex ? tokenHandler : DummyTokenHandler.INSTANCE;
            context = markTokens(seg, prevContext, _tokenHandler);
            lineMgr.setLineContext(i, context);
        }

        int lineCount = lineMgr.getLineCount();
        if (lineCount - 1 == lineIndex)
            lineMgr.setFirstInvalidLineContext(-1);
        else if (oldContext != context)
            lineMgr.setFirstInvalidLineContext(lineIndex + 1);
        else if (firstInvalidLineContext == -1)
            /* do nothing */ ;
        else {
            lineMgr.setFirstInvalidLineContext(Math.max(
                    firstInvalidLineContext, lineIndex + 1));
        }
    } //}}}

    //{{{ getRuleSetAtOffset() method

    /**
     * Returns the syntax highlighting ruleset at the specified offset.
     *
     * @since jEdit 4.1pre1
     */
    public ParserRuleSet getRuleSetAtOffset(int offset) {
        int line = lineMgr.getLineOfOffset(offset);
        offset -= lineMgr.getLineEndOffset(line - 1);
        if (offset != 0)
            offset--;

        DefaultTokenHandler tokens = new DefaultTokenHandler();
        markTokens(line, tokens);
        Token token = getTokenAtOffset(tokens.getTokens(), offset);
        return token.rules;
    } //}}}

    /**
     * Returns the token that contains the specified offset.
     *
     * @param tokens The token list
     * @param offset The offset
     * @since jEdit 4.0pre3
     */
    public static Token getTokenAtOffset(Token tokens, int offset) {
        if (offset == 0 && tokens.id == Token.END)
            return tokens;

        for (; ; ) {
            if (tokens.id == Token.END)
                throw new ArrayIndexOutOfBoundsException("offset > line length");

            if (tokens.offset + tokens.length > offset)
                return tokens;
            else
                tokens = tokens.next;
        }
    } //}}}

    public void setLineManager(LineManager lineManager) {
        this.lineMgr = lineManager;
    }

    //{{{ contentInserted() method
    private void contentInserted(int offset, int length,
                                 IntegerArray endOffsets) {
        int startLine = lineMgr.getLineOfOffset(offset);
        int numLines = endOffsets.getSize();

        lineMgr.contentInserted(startLine, offset, numLines, length,
                endOffsets);
    } //}}}

    /**
     * Inserts a string into the buffer.
     *
     * @param offset The offset
     * @param seq    The charsequence
     * @since jEdit 5.0pre1
     */
    public void insert(int offset, CharSequence seq) {
        if (seq == null)
            return;

        int len = seq.length();

        if (len == 0)
            return;

        if (offset < 0 || offset > editable.length())
            throw new ArrayIndexOutOfBoundsException(offset);

//        contentMgr.insert(offset, seq);

        integerArray.clear();

        char c;
        for (int i = 0; i < len; i++) {
            c = seq.charAt(i);
            if (c == '\r' || c == '\n')
                integerArray.add(i + 1);
        }

        contentInserted(offset, len, integerArray);
    } //}}}

    /**
     * Removes the specified rang efrom the buffer.
     * @param offset The start offset
     * @param length The number of characters to remove
     */
    public void remove(int offset, int length)
    {
        if(length == 0)
            return;
// 来到这里就删除了，不能再判断了
//        if(offset < 0 || length < 0
//                || offset + length > editable.length())
//            throw new ArrayIndexOutOfBoundsException(offset + ":" + length);

        int startLine = lineMgr.getLineOfOffset(offset);
        int endLine = lineMgr.getLineOfOffset(offset + length);

        int numLines = endLine - startLine;

//        contentMgr.remove(offset,length);
        lineMgr.contentRemoved(startLine,offset,numLines,length);
    } //}}}

    @Override
    public String toString() {
//        if (contentMgr == null)
//            return "";
//        return contentMgr.getText(0, contentMgr.getLength());
        return editable.toString();
    }

    public void setEditable(Editable editable) {
        if (this.editable == editable)
            return;

        if (!(editable instanceof SpannableStringBuilder))
            throw new RuntimeException("Can't set a " + editable.getClass().getName() + " to Buffer");

        this.editable = editable;
    }
}
