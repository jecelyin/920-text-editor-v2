
package com.jecelyin.editor.v2.highlight.jedit.syntax;


import com.jecelyin.editor.v2.highlight.jedit.Segment;

/**
 * A dummy token handler that discards tokens.
 *
 * @author Slava Pestov
 * @version $Id: DummyTokenHandler.java 21831 2012-06-18 22:54:17Z ezust $
 * @since jEdit 4.1pre1
 */
public class DummyTokenHandler implements TokenHandler {
    /**
     * To avoid having to create new instances of this class, use
     * this variable. This is allowed because instances of this
     * class do not store any state.
     */
    public static final DummyTokenHandler INSTANCE = new DummyTokenHandler();

    //{{{ handleToken() method

    /**
     * Called by the token marker when a syntax token has been parsed.
     *
     * @param seg     The segment containing the text
     * @param id      The token type (one of the constants in the
     *                {@link Token} class).
     * @param offset  The start offset of the token
     * @param length  The number of characters in the token
     * @param context The line context
     * @since jEdit 4.2pre3
     */
    public void handleToken(Segment seg, byte id, int offset, int length,
                            TokenMarker.LineContext context) {
    } //}}}

    //{{{ setLineContext() method

    /**
     * The token handler can compare this object with the object
     * previously given for this line to see if the token type at the end
     * of the line has changed (meaning subsequent lines might need to be
     * retokenized).
     *
     * @since jEdit 4.2pre6
     */
    public void setLineContext(TokenMarker.LineContext lineContext) {
    } //}}}
}
