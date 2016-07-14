
package com.jecelyin.editor.v2.highlight.jedit.syntax;

import java.lang.reflect.Field;

/**
 * A linked list of syntax tokens.
 *
 * @author Slava Pestov
 * @version $Id: Token.java 21831 2012-06-18 22:54:17Z ezust $
 */
public class Token {
    //{{{ stringToToken() method

    /**
     * Converts a token type string to a token type constant.
     *
     * @param value The token type
     * @since jEdit 4.1pre1
     */
    public static byte stringToToken(String value) {
        try {
            Field f = Token.class.getField(value);
            return f.getByte(null);
        } catch (Exception e) {
            return -1;
        }
    } //}}}

    //{{{ tokenToString() method

    /**
     * Converts a token type constant to a token type string.
     *
     * @since jEdit 4.2pre1
     */
    public static String tokenToString(byte token) {
        return (token == Token.END) ? "END" : TOKEN_TYPES[token];
    } //}}}

    //{{{ Token types
    public static final String[] TOKEN_TYPES = new String[]{
            "NULL",
            "COMMENT1",
            "COMMENT2",
            "COMMENT3",
            "COMMENT4",
            "DIGIT",
            "FUNCTION",
            "INVALID",
            "KEYWORD1",
            "KEYWORD2",
            "KEYWORD3",
            "KEYWORD4",
            "LABEL",
            "LITERAL1",
            "LITERAL2",
            "LITERAL3",
            "LITERAL4",
            "MARKUP",
            "OPERATOR"
    };

    public static final byte NULL = 0;

    public static final byte COMMENT1 = 1;
    public static final byte COMMENT2 = 2;
    public static final byte COMMENT3 = 3;
    public static final byte COMMENT4 = 4;
    public static final byte DIGIT = 5;
    public static final byte FUNCTION = 6;
    public static final byte INVALID = 7;
    public static final byte KEYWORD1 = 8;
    public static final byte KEYWORD2 = 9;
    public static final byte KEYWORD3 = 10;
    public static final byte KEYWORD4 = 11;
    public static final byte LABEL = 12;
    public static final byte LITERAL1 = 13;
    public static final byte LITERAL2 = 14;
    public static final byte LITERAL3 = 15;
    public static final byte LITERAL4 = 16;
    public static final byte MARKUP = 17;
    public static final byte OPERATOR = 18;
    //}}}

    public static final byte ID_COUNT = 19;

    // Special:
    public static final byte END = 127;

    //{{{ Instance variables
    /**
     * The id of this token.
     */
    public byte id;

    /**
     * The start offset of this token.
     */
    public int offset;

    /**
     * The length of this token.
     */
    public int length;

    /**
     * The rule set of this token.
     */
    public ParserRuleSet rules;

    /**
     * The next token in the linked list.
     */
    public Token next;
    //}}}

    //{{{ Token constructor

    /**
     * Creates a new token.
     *
     * @param id     The id of the token
     * @param offset The start offset of the token
     * @param length The length of the token
     * @param rules  The parser rule set that generated this token
     */
    public Token(byte id, int offset, int length, ParserRuleSet rules) {
        this.id = id;
        this.offset = offset;
        this.length = length;
        this.rules = rules;
    } //}}}

    //{{{ toString() method

    /**
     * Returns a string representation of this token.
     */
    public String toString() {
        return "[id=" + id + ",offset=" + offset + ",length=" + length + "]";
    } //}}}
}
