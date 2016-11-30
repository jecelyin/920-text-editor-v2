
package com.jecelyin.editor.v2.highlight.jedit.util;

//{{{ Imports

import com.jecelyin.editor.v2.highlight.jedit.syntax.Token;

import java.util.Collection;
import java.util.Iterator;
import java.util.Stack;
//}}}

/**
 * Contains several text manipulation methods.
 * <p/>
 * <ul>
 * <li>Bracket matching
 * <li>Word start and end offset calculation
 * <li>String comparison
 * <li>Converting tabs to spaces and vice versa
 * <li>Wrapping text
 * <li>String case conversion
 * </ul>
 *
 * @author Slava Pestov
 * @version $Id: TextUtilities.java 21831 2012-06-18 22:54:17Z ezust $
 */
public class TextUtilities {
    // to avoid slowdown with large files; only scan 10000 lines either way
    public static final int BRACKET_MATCH_LIMIT = 10000;
    public static final int WHITESPACE = 0;
    public static final int WORD_CHAR = 1;
    public static final int SYMBOL = 2;


    //{{{ getTokenAtOffset() method

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

    //{{{ getComplementaryBracket() method

    /**
     * Given an opening bracket, return the corresponding closing bracket
     * and store true in <code>direction[0]</code>. Given a closing bracket,
     * return the corresponding opening bracket and store false in
     * <code>direction[0]</code>. Otherwise, return <code>\0</code>.
     *
     * @since jEdit 4.3pre2
     */
    public static char getComplementaryBracket(char ch, boolean[] direction) {
        switch (ch) {
            case '(':
                if (direction != null) direction[0] = true;
                return ')';
            case ')':
                if (direction != null) direction[0] = false;
                return '(';
            case '[':
                if (direction != null) direction[0] = true;
                return ']';
            case ']':
                if (direction != null) direction[0] = false;
                return '[';
            case '{':
                if (direction != null) direction[0] = true;
                return '}';
            case '}':
                if (direction != null) direction[0] = false;
                return '{';
            case '<':
                if (direction != null) direction[0] = true;
                return '>';
            case '>':
                if (direction != null) direction[0] = false;
                return '<';
            default:
                return '\0';
        }
    } //}}}

    //{{{ join() method

    /**
     * Similar to perl's join() method on lists,
     * but works with all collections.
     *
     * @param c     An iterable collection of Objects
     * @param delim a string to put between each object
     * @return a joined toString() representation of the collection
     * @since jedit 4.3pre3
     */
    public static String join(Collection<?> c, String delim) {
        StringBuilder retval = new StringBuilder();
        Iterator<?> itr = c.iterator();
        if (itr.hasNext())
            retval.append(itr.next());
        else
            return "";
        while (itr.hasNext()) {
            retval.append(delim);
            retval.append(itr.next());
        }
        return retval.toString();
    } //}}}

    //{{{ findWordStart() methods

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line      The text
     * @param pos       The position
     * @param noWordSep Characters that are non-alphanumeric, but
     *                  should be treated as word characters anyway
     */
    public static int findWordStart(String line, int pos, String noWordSep) {
        return findWordStart(line, pos, noWordSep, true, false);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line      The text
     * @param pos       The position
     * @param noWordSep Characters that are non-alphanumeric, but
     *                  should be treated as word characters anyway
     * @since jEdit 4.3pre15
     */
    public static int findWordStart(CharSequence line,
                                    int pos,
                                    String noWordSep) {
        return findWordStart(line, pos, noWordSep, true, false, false);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @since jEdit 4.2pre5
     */
    public static int findWordStart(String line, int pos, String noWordSep,
                                    boolean joinNonWordChars) {
        return findWordStart(line, pos, noWordSep, joinNonWordChars, false);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param eatWhitespace    Include whitespace at start of word
     * @since jEdit 4.1pre2
     */
    public static int findWordStart(String line, int pos, String noWordSep,
                                    boolean joinNonWordChars, boolean eatWhitespace) {
        return findWordStart(line, pos, noWordSep, joinNonWordChars,
                false, eatWhitespace);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param camelCasedWords  Treat "camelCased" parts as words
     * @param eatWhitespace    Include whitespace at start of word
     * @since jEdit 4.3pre10
     */
    public static int findWordStart(String line, int pos, String noWordSep,
                                    boolean joinNonWordChars, boolean camelCasedWords,
                                    boolean eatWhitespace) {
        return findWordStart((CharSequence) line, pos, noWordSep,
                joinNonWordChars, camelCasedWords,
                eatWhitespace);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param camelCasedWords  Treat "camelCased" parts as words
     * @param eatWhitespace    Include whitespace at start of word
     * @since jEdit 4.3pre15
     */
    public static int findWordStart(CharSequence line,
                                    int pos,
                                    String noWordSep,
                                    boolean joinNonWordChars,
                                    boolean camelCasedWords,
                                    boolean eatWhitespace) {
        return findWordStart(line, pos, noWordSep, joinNonWordChars, camelCasedWords, eatWhitespace, false);
    }

    /**
     * Locates the start of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param camelCasedWords  Treat "camelCased" parts as words
     * @param eatWhitespace    Include whitespace at start of word
     * @param eatOnlyAfterWord Eat only whitespace after a word,
     *                         in effect this finds actual word starts even if eating
     * @since jEdit 4.4pre1
     */
    public static int findWordStart(CharSequence line, int pos, String noWordSep,
                                    boolean joinNonWordChars, boolean camelCasedWords,
                                    boolean eatWhitespace, boolean eatOnlyAfterWord) {
        char ch = line.charAt(pos);

        if (noWordSep == null)
            noWordSep = "";

        //{{{ the character under the cursor changes how we behave.
        int type = getCharType(ch, noWordSep);
        //}}}

        for (int i = pos; i >= 0; i--) {
            char lastCh = ch;
            ch = line.charAt(i);
            switch (type) {
                //{{{ Whitespace...
                case WHITESPACE:
                    // only select other whitespace in this case, unless eating only after words
                    if (Character.isWhitespace(ch))
                        break;
                        // word char or symbol; stop, unless eating only after words
                    else if (!eatOnlyAfterWord) {
                        return i + 1;
                    }
                    // we have eaten after-word-whitespace and now continue until word start
                    else if (Character.isLetterOrDigit(ch) || noWordSep.indexOf(ch) != -1) {
                        type = WORD_CHAR;
                    } else
                        type = SYMBOL;
                    break; //}}}
                //{{{ Word character...
                case WORD_CHAR:
                    // stop at next last (in writing direction) upper case char if camel cased
                    // (don't stop at every upper case char, don't treat noWordSep as word chars)
                    if (camelCasedWords && Character.isUpperCase(ch) && !Character.isUpperCase(lastCh)
                            && Character.isLetterOrDigit(lastCh)) {
                        return i;
                    }
                    // stop at next first (in writing direction) upper case char if camel cased
                    // (don't stop at every upper case char)
                    else if (camelCasedWords && !Character.isUpperCase(ch) && Character.isUpperCase(lastCh)) {
                        return i + 1;
                    }
                    // word char; keep going
                    else if (Character.isLetterOrDigit(ch) ||
                            noWordSep.indexOf(ch) != -1) {
                        break;
                    }
                    // whitespace; include in word if eating, but not if only eating after word
                    else if (Character.isWhitespace(ch)
                            && eatWhitespace && !eatOnlyAfterWord) {
                        type = WHITESPACE;
                        break;
                    } else
                        return i + 1; //}}}
                    //{{{ Symbol...
                case SYMBOL:
                    if (!joinNonWordChars && pos != i)
                        return i + 1;

                    // whitespace; include in word if eating, but not if only eating after word
                    if (Character.isWhitespace(ch)) {
                        if (eatWhitespace && !eatOnlyAfterWord) {
                            type = WHITESPACE;
                            break;
                        } else
                            return i + 1;
                    } else if (Character.isLetterOrDigit(ch) ||
                            noWordSep.indexOf(ch) != -1) {
                        return i + 1;
                    } else {
                        break;
                    } //}}}
            }
        }

        return 0;
    } //}}}

    //{{{ findWordEnd() methods

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line      The text
     * @param pos       The position
     * @param noWordSep Characters that are non-alphanumeric, but
     *                  should be treated as word characters anyway
     */
    public static int findWordEnd(String line, int pos, String noWordSep) {
        return findWordEnd(line, pos, noWordSep, true);
    }

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line      The text
     * @param pos       The position
     * @param noWordSep Characters that are non-alphanumeric, but
     *                  should be treated as word characters anyway
     * @since jEdit 4.3pre15
     */
    public static int findWordEnd(CharSequence line,
                                  int pos,
                                  String noWordSep) {
        return findWordEnd(line, pos, noWordSep, true, false, false);
    }

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @since jEdit 4.1pre2
     */
    public static int findWordEnd(String line, int pos, String noWordSep,
                                  boolean joinNonWordChars) {
        return findWordEnd(line, pos, noWordSep, joinNonWordChars, false);
    }

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param eatWhitespace    Include whitespace at end of word
     * @since jEdit 4.2pre5
     */
    public static int findWordEnd(String line, int pos, String noWordSep,
                                  boolean joinNonWordChars, boolean eatWhitespace) {
        return findWordEnd(line, pos, noWordSep, joinNonWordChars,
                false, eatWhitespace);
    }

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param camelCasedWords  Treat "camelCased" parts as words
     * @param eatWhitespace    Include whitespace at end of word
     * @since jEdit 4.3pre10
     */
    public static int findWordEnd(String line, int pos, String noWordSep,
                                  boolean joinNonWordChars, boolean camelCasedWords,
                                  boolean eatWhitespace) {
        return findWordEnd((CharSequence) line, pos, noWordSep,
                joinNonWordChars, camelCasedWords,
                eatWhitespace);
    }

    /**
     * Locates the end of the word at the specified position.
     *
     * @param line             The text
     * @param pos              The position
     * @param noWordSep        Characters that are non-alphanumeric, but
     *                         should be treated as word characters anyway
     * @param joinNonWordChars Treat consecutive non-alphanumeric
     *                         characters as one word
     * @param camelCasedWords  Treat "camelCased" parts as words
     * @param eatWhitespace    Include whitespace at end of word
     * @since jEdit 4.3pre15
     */
    public static int findWordEnd(CharSequence line,
                                  int pos,
                                  String noWordSep,
                                  boolean joinNonWordChars,
                                  boolean camelCasedWords,
                                  boolean eatWhitespace) {
        if (pos != 0)
            pos--;

        char ch = line.charAt(pos);

        if (noWordSep == null)
            noWordSep = "";

        //{{{ the character under the cursor changes how we behave.
        int type = getCharType(ch, noWordSep);
        //}}}

        for (int i = pos; i < line.length(); i++) {
            char lastCh = ch;
            ch = line.charAt(i);
            switch (type) {
                //{{{ Whitespace...
                case WHITESPACE:
                    // only select other whitespace in this case
                    if (Character.isWhitespace(ch))
                        break;
                    else
                        return i; //}}}
                    //{{{ Word character...
                case WORD_CHAR:
                    // stop at next last upper case char if camel cased
                    // (don't stop at every upper case char, don't treat noWordSep as word chars)
                    if (camelCasedWords && i > pos + 1 && !Character.isUpperCase(ch) && Character.isLetterOrDigit(ch)
                            && Character.isUpperCase(lastCh)) {
                        return i - 1;
                    }
                    // stop at next first upper case char if camel caseg (don't stop at every upper case char)
                    else if (camelCasedWords && Character.isUpperCase(ch) && !Character.isUpperCase(lastCh)) {
                        return i;
                    } else if (Character.isLetterOrDigit(ch) ||
                            noWordSep.indexOf(ch) != -1) {
                        break;
                    }
                    // whitespace; include in word if eating
                    else if (Character.isWhitespace(ch)
                            && eatWhitespace) {
                        type = WHITESPACE;
                        break;
                    } else
                        return i; //}}}
                    //{{{ Symbol...
                case SYMBOL:
                    if (!joinNonWordChars && i != pos)
                        return i;

                    // if we see whitespace, set flag.
                    if (Character.isWhitespace(ch)) {
                        if (eatWhitespace) {
                            type = WHITESPACE;
                            break;
                        } else
                            return i;
                    } else if (Character.isLetterOrDigit(ch) ||
                            noWordSep.indexOf(ch) != -1) {
                        return i;
                    } else {
                        break;
                    } //}}}
            }
        }

        return line.length();
    } //}}}

    //{{{ getCharType() method

    /**
     * Returns the type of the char.
     *
     * @param ch        the character
     * @param noWordSep Characters that are non-alphanumeric, but
     *                  should be treated as word characters anyway, it must not be null
     * @return the type of the char : {@link #WHITESPACE},
     * {@link #WORD_CHAR}, {@link #SYMBOL}
     * @since jEdit 4.4pre1
     */
    public static int getCharType(char ch, String noWordSep) {
        int type;
        if (Character.isWhitespace(ch))
            type = WHITESPACE;
        else if (Character.isLetterOrDigit(ch)
                || noWordSep.indexOf(ch) != -1)
            type = WORD_CHAR;
        else
            type = SYMBOL;
        return type;
    } //}}}

    //{{{ tabsToSpaces() method

    /**
     * Converts tabs to consecutive spaces in the specified string.
     *
     * @param in      The string
     * @param tabSize The tab size
     */
    public static String tabsToSpaces(String in, int tabSize) {
        StringBuilder buf = new StringBuilder();
        int width = 0;
        for (int i = 0; i < in.length(); i++) {
            switch (in.charAt(i)) {
                case '\t':
                    int count = tabSize - (width % tabSize);
                    width += count;
                    while (--count >= 0)
                        buf.append(' ');
                    break;
                case '\n':
                    width = 0;
                    buf.append(in.charAt(i));
                    break;
                default:
                    width++;
                    buf.append(in.charAt(i));
                    break;
            }
        }
        return buf.toString();
    } //}}}

    //{{{ indexIgnoringWhitespace() method

    /**
     * Inverse of <code>ignoringWhitespaceIndex()</code>.
     *
     * @param str   a string (not an empty string)
     * @param index The index
     * @return The number of non-whitespace characters that precede the index.
     * @since jEdit 4.3pre2
     */
    public static int indexIgnoringWhitespace(String str, int index) {
        int j = 0;
        for (int i = 0; i < index; i++)
            if (!Character.isWhitespace(str.charAt(i))) j++;
        return j;
    } //}}}

    //{{{ ignoringWhitespaceIndex() method

    /**
     * Inverse of <code>indexIgnoringWhitespace()</code>.
     *
     * @param str   a string (not an empty string)
     * @param index The index
     * @return The index into the string where the number of non-whitespace
     * characters that precede the index is count.
     * @since jEdit 4.3pre2
     */
    public static int ignoringWhitespaceIndex(String str, int index) {
        int j = 0;
        for (int i = 0; ; i++) {
            if (!Character.isWhitespace(str.charAt(i))) j++;

            if (j > index)
                return i;
            if (i == str.length() - 1)
                return i + 1;
        }
    } //}}}

    //{{{ getStringCase() methods
    public static final int MIXED = 0;
    public static final int LOWER_CASE = 1;
    public static final int UPPER_CASE = 2;
    public static final int TITLE_CASE = 3;

    /**
     * Returns if the specified string is all upper case, all lower case,
     * or title case (first letter upper case, rest lower case).
     *
     * @param str The string
     * @since jEdit 4.4pre1
     */
    public static int getStringCase(CharSequence str) {
        if (str.length() == 0)
            return MIXED;

        int state = -1;

        char ch = str.charAt(0);
        if (Character.isLetter(ch)) {
            if (Character.isUpperCase(ch))
                state = UPPER_CASE;
            else
                state = LOWER_CASE;
        }

        for (int i = 1; i < str.length(); i++) {
            ch = str.charAt(i);
            if (!Character.isLetter(ch))
                continue;

            switch (state) {
                case UPPER_CASE:
                    if (Character.isLowerCase(ch)) {
                        if (i == 1)
                            state = TITLE_CASE;
                        else
                            return MIXED;
                    }
                    break;
                case LOWER_CASE:
                case TITLE_CASE:
                    if (Character.isUpperCase(ch))
                        return MIXED;
                    break;
            }
        }

        return state;
    }

    /**
     * Returns if the specified string is all upper case, all lower case,
     * or title case (first letter upper case, rest lower case).
     *
     * @param str The string
     * @since jEdit 4.0pre1
     */
    public static int getStringCase(String str) {
        return getStringCase((CharSequence) str);
    } //}}}

    //{{{ toTitleCase() method

    /**
     * Converts the specified string to title case, by capitalizing the
     * first letter.
     *
     * @param str The string
     * @since jEdit 4.0pre1
     */
    public static String toTitleCase(String str) {
        if (str.length() == 0)
            return str;
        else {
            return Character.toUpperCase(str.charAt(0))
                    + str.substring(1).toLowerCase();
        }
    } //}}}

    //{{{ escapeText() method

    /**
     * Escapes a given string for use in a java.util.regex pattern.
     *
     * @since jEdit 4.5pre1
     */
    public static String escapeText(String text) {
        // Make sure that every "\E" appearing in the text is escaped, and then
        // surround it with the quotation tags \Q and \E.
        String result = text.replace("\\E", "\\\\E");
        return "\\Q" + result + "\\E";
    } //}}}


    //{{{ globToRE() method

    /**
     * Converts a Unix-style glob to a regular expression.<p>
     * <p/>
     * ? becomes ., * becomes .*, {aa,bb} becomes (aa|bb).
     *
     * @param glob The glob pattern
     * @since jEdit 4.3pre7
     */
    public static String globToRE(String glob) {
        if (glob.startsWith("(re)")) {
            return glob.substring(4);
        }

        final Object NEG = new Object();
        final Object GROUP = new Object();
        Stack<Object> state = new Stack<Object>();

        StringBuilder buf = new StringBuilder();
        boolean backslash = false;

        int length = glob.length();
        for (int i = 0; i < length; i++) {
            char c = glob.charAt(i);
            if (backslash) {
                buf.append('\\');
                buf.append(c);
                backslash = false;
                continue;
            }

            switch (c) {
                case '\\':
                    backslash = true;
                    break;
                case '?':
                    buf.append('.');
                    break;
                case '.':
                case '+':
                case '(':
                case ')':
                    buf.append('\\');
                    buf.append(c);
                    break;
                case '*':
                    buf.append(".*");
                    break;
                case '|':
                    if (backslash)
                        buf.append("\\|");
                    else
                        buf.append('|');
                    break;
                case '{':
                    buf.append('(');
                    if (i + 1 != length && glob.charAt(i + 1) == '!') {
                        buf.append('?');
                        state.push(NEG);
                    } else
                        state.push(GROUP);
                    break;
                case ',':
                    if (!state.isEmpty() && state.peek() == GROUP)
                        buf.append('|');
                    else
                        buf.append(',');
                    break;
                case '}':
                    if (!state.isEmpty()) {
                        buf.append(')');
                        if (state.pop() == NEG)
                            buf.append(".*");
                    } else
                        buf.append('}');
                    break;
                default:
                    buf.append(c);
            }
        }

        return buf.toString();
    } //}}}

    //{{{ getBoolean() method

    /**
     * Returns a boolean from a given object.
     *
     * @param obj the object
     * @param def The default value
     * @return the boolean value if obj is a Boolean,
     * true if the value is "true", "yes", "on",
     * false if the value is "false", "no", "off"
     * def if the value is null or anything else
     * @since jEdit 4.3pre17
     */
    public static boolean getBoolean(Object obj, boolean def) {
        if (obj == null)
            return def;
        else if (obj instanceof Boolean)
            return ((Boolean) obj).booleanValue();
        else if ("true".equals(obj) || "yes".equals(obj)
                || "on".equals(obj))
            return true;
        else if ("false".equals(obj) || "no".equals(obj)
                || "off".equals(obj))
            return false;

        return def;
    } //}}}
}
