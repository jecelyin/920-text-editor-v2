
package com.jecelyin.editor.v2.highlight.jedit.syntax;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

/**
 * A parser rule.
 *
 * @author mike dillon, Slava Pestov
 * @version $Id: ParserRule.java 21831 2012-06-18 22:54:17Z ezust $
 */
public class ParserRule {

    //{{{ Major actions
    public static final int MAJOR_ACTIONS = 0x000000FF;
    public static final int SEQ = 0;
    public static final int SPAN = 1 << 1;
    public static final int MARK_PREVIOUS = 1 << 2;
    public static final int MARK_FOLLOWING = 1 << 3;
    public static final int EOL_SPAN = 1 << 4;
    //}}}

    //{{{ Action hints
    public static final int ACTION_HINTS = 0x0000FF00;

    public static final int NO_LINE_BREAK = 1 << 9;
    public static final int NO_WORD_BREAK = 1 << 10;
    public static final int IS_ESCAPE = 1 << 11;

    public static final int REGEXP = 1 << 13;
    public static final int END_REGEXP = 1 << 14;
    //}}}

    //{{{ Special Match Token Types
    public static final byte MATCH_TYPE_CONTEXT = -1;
    public static final byte MATCH_TYPE_RULE = -2;
    //}}}

    //{{{ Position match hints
    public static final int AT_LINE_START = 1 << 1;
    public static final int AT_WHITESPACE_END = 1 << 2;
    public static final int AT_WORD_START = 1 << 3;
    //}}}

    //{{{ Instance variables
    /**
     * The upHashChar should be a String but it is stored
     * in an array making iterations much faster
     */
    public final char[] upHashChar;
    public final char[] upHashChars;
    public final int startPosMatch;
    public final char[] start;
    public final Matcher startRegexp;

    public final int endPosMatch;
    public final char[] end;
    public final Matcher endRegexp;

    public final int action;
    public final byte token;

    /**
     * matchType is the type of the token for the matched region. Special
     * values are: MATCH_TYPE_CONTEXT = default token for the context,
     * MATCH_TYPE_RULE = same token as the rule itself.
     *
     * @since jEdit 4.3pre10
     */
    public final byte matchType;

    /**
     * escapeRule is the rule-specific sequence used to escape other
     * characters while the rule is in effect. If this character is
     * non-zero, the character following the escape char will be skipped
     * during parsing, and highlighted with the rule's token.
     *
     * @since jEdit 4.3pre12
     */
    public final ParserRule escapeRule;

    public ParserRuleSet delegate;
    //}}}

    //{{{ createSequenceRule() method
    public static ParserRule createSequenceRule(
            int posMatch, String seq, ParserRuleSet delegate, byte id) {
        return new ParserRule(SEQ, seq.substring(0, 1),
                posMatch, seq.toCharArray(), null,
                0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
    } //}}}

    //{{{ createRegexpSequenceRule() method
    public static ParserRule createRegexpSequenceRule(
            String hashChar, int posMatch, String seq,
            ParserRuleSet delegate, byte id, boolean ignoreCase)
            throws PatternSyntaxException {
        return new ParserRule(SEQ | REGEXP, hashChar, posMatch,
                null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
    } //}}}

    //{{{ createRegexpSequenceRule() method
    public static ParserRule createRegexpSequenceRule(
            int posMatch, char[] hashChars, String seq,
            ParserRuleSet delegate, byte id, boolean ignoreCase)
            throws PatternSyntaxException {
        return new ParserRule(hashChars, SEQ | REGEXP, posMatch,
                null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                0, null, null, delegate, id, MATCH_TYPE_CONTEXT, null);
    } //}}}

    //{{{ createSpanRule() method
    public static ParserRule createSpanRule(
            int startPosMatch, String start, int endPosMatch, String end,
            ParserRuleSet delegate, byte id, byte matchType,
            boolean noLineBreak, boolean noWordBreak, String escape) {
        int ruleAction = SPAN |
                ((noLineBreak) ? NO_LINE_BREAK : 0) |
                ((noWordBreak) ? NO_WORD_BREAK : 0);

        return new ParserRule(ruleAction, start.substring(0, 1), startPosMatch,
                start.toCharArray(), null,
                endPosMatch, end.toCharArray(),
                null, delegate, id, matchType, escape);
    } //}}}

    //{{{ createRegexpSpanRule() method
    public static ParserRule createRegexpSpanRule(
            String hashChar, int startPosMatch, String start,
            int endPosMatch, String end, ParserRuleSet delegate, byte id,
            byte matchType, boolean noLineBreak, boolean noWordBreak,
            boolean ignoreCase, String escape, boolean endRegexp)
            throws PatternSyntaxException {
        int ruleAction = SPAN | REGEXP |
                ((noLineBreak) ? NO_LINE_BREAK : 0) |
                ((noWordBreak) ? NO_WORD_BREAK : 0);

        Matcher endRegexpPattern;
        char[] endArray;
        if (endRegexp) {
            ruleAction |= END_REGEXP;
            endRegexpPattern = Pattern.compile(end, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher("");
            endArray = null;
        } else {
            endRegexpPattern = null;
            endArray = end.toCharArray();
        }

        return new ParserRule(ruleAction, hashChar, startPosMatch, null,
                Pattern.compile(start, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                endPosMatch, endArray, endRegexpPattern, delegate, id, matchType,
                escape);
    } //}}}

    //{{{ createRegexpSpanRule() method
    public static ParserRule createRegexpSpanRule(
            int startPosMatch, char[] hashChars, String start,
            int endPosMatch, String end, ParserRuleSet delegate, byte id,
            byte matchType, boolean noLineBreak, boolean noWordBreak,
            boolean ignoreCase, String escape, boolean endRegexp)
            throws PatternSyntaxException {
        int ruleAction = SPAN | REGEXP |
                ((noLineBreak) ? NO_LINE_BREAK : 0) |
                ((noWordBreak) ? NO_WORD_BREAK : 0);

        Matcher endRegexpPattern;
        char[] endArray;
        if (endRegexp) {
            ruleAction |= END_REGEXP;
            endRegexpPattern = Pattern.compile(end, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher("");
            endArray = null;
        } else {
            endRegexpPattern = null;
            endArray = end.toCharArray();
        }

        return new ParserRule(hashChars, ruleAction, startPosMatch, null,
                Pattern.compile(start, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                endPosMatch, endArray, endRegexpPattern, delegate, id,
                matchType, escape);
    } //}}}

    //{{{ createEOLSpanRule() method
    public static ParserRule createEOLSpanRule(
            int posMatch, String seq, ParserRuleSet delegate, byte id,
            byte matchType) {
        int ruleAction = EOL_SPAN | NO_LINE_BREAK;

        return new ParserRule(ruleAction, seq.substring(0, 1), posMatch,
                seq.toCharArray(), null, 0, null, null,
                delegate, id, matchType, null);
    } //}}}

    //{{{ createRegexpEOLSpanRule() method
    public static ParserRule createRegexpEOLSpanRule(
            String hashChar, int posMatch, String seq, ParserRuleSet delegate,
            byte id, byte matchType, boolean ignoreCase)
            throws PatternSyntaxException {
        int ruleAction = EOL_SPAN | REGEXP | NO_LINE_BREAK;

        return new ParserRule(ruleAction, hashChar, posMatch,
                null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                0, null, null, delegate, id, matchType, null);
    } //}}}

    //{{{ createRegexpEOLSpanRule() method
    public static ParserRule createRegexpEOLSpanRule(
            int posMatch, char[] hashChars, String seq, ParserRuleSet delegate,
            byte id, byte matchType, boolean ignoreCase)
            throws PatternSyntaxException {
        int ruleAction = EOL_SPAN | REGEXP | NO_LINE_BREAK;

        return new ParserRule(hashChars, ruleAction, posMatch,
                null, Pattern.compile(seq, (ignoreCase ? Pattern.CASE_INSENSITIVE : 0)).matcher(""),
                0, null, null, delegate, id, matchType, null);
    } //}}}

    //{{{ createMarkFollowingRule() method
    public static ParserRule createMarkFollowingRule(
            int posMatch, String seq, byte id, byte matchType) {
        int ruleAction = MARK_FOLLOWING;

        return new ParserRule(ruleAction, seq.substring(0, 1), posMatch,
                seq.toCharArray(), null, 0, null, null, null, id, matchType,
                null);
    } //}}}

    //{{{ createMarkPreviousRule() method
    public static ParserRule createMarkPreviousRule(
            int posMatch, String seq, byte id, byte matchType) {
        int ruleAction = MARK_PREVIOUS;

        return new ParserRule(ruleAction, seq.substring(0, 1), posMatch,
                seq.toCharArray(), null, 0, null, null, null, id, matchType,
                null);
    } //}}}

    //{{{ createEscapeRule() method
    public static ParserRule createEscapeRule(String seq) {
        int ruleAction = IS_ESCAPE;

        return new ParserRule(ruleAction, seq.substring(0, 1),
                0, seq.toCharArray(), null, 0, null, null,
                null, Token.NULL, MATCH_TYPE_CONTEXT, null);
    } //}}}

    //{{{ toString() method
    public String toString() {
        StringBuilder result = new StringBuilder();
        result.append(getClass().getName()).append("[action=");
        switch (action & MAJOR_ACTIONS) {
            case SEQ:
                result.append("SEQ");
                break;
            case SPAN:
                result.append("SPAN");
                break;
            case MARK_PREVIOUS:
                result.append("MARK_PREVIOUS");
                break;
            case MARK_FOLLOWING:
                result.append("MARK_FOLLOWING");
                break;
            case EOL_SPAN:
                result.append("EOL_SPAN");
                break;
            default:
                result.append("UNKNOWN");
                break;
        }
        int actionHints = action & ACTION_HINTS;
        result.append("[matchType=").append(matchType == MATCH_TYPE_CONTEXT ? "MATCH_TYPE_CONTEXT" : (matchType == MATCH_TYPE_RULE ? "MATCH_TYPE_RULE" : Token.tokenToString(matchType)));
        result.append(",NO_LINE_BREAK=").append((actionHints & NO_LINE_BREAK) != 0);
        result.append(",NO_WORD_BREAK=").append((actionHints & NO_WORD_BREAK) != 0);
        result.append(",IS_ESCAPE=").append((actionHints & IS_ESCAPE) != 0);
        result.append(",REGEXP=").append((actionHints & REGEXP) != 0);
        result.append("],upHashChar=").append(new String(upHashChar));
        result.append(",upHashChars=").append(Arrays.toString(upHashChars));
        result.append(",startPosMatch=");
        result.append("[AT_LINE_START=").append((startPosMatch & AT_LINE_START) != 0);
        result.append(",AT_WHITESPACE_END=").append((startPosMatch & AT_WHITESPACE_END) != 0);
        result.append(",AT_WORD_START=").append((startPosMatch & AT_WORD_START) != 0);
        result.append("],start=").append(null == start ? null : String.valueOf(start));
        result.append(",startRegexp=").append(startRegexp);
        result.append(",endPosMatch=");
        result.append("[AT_LINE_START=").append((endPosMatch & AT_LINE_START) != 0);
        result.append(",AT_WHITESPACE_END=").append((endPosMatch & AT_WHITESPACE_END) != 0);
        result.append(",AT_WORD_START=").append((endPosMatch & AT_WORD_START) != 0);
        result.append("],end=").append(null == end ? null : String.valueOf(end));
        result.append(",delegate=").append(delegate);
        result.append(",escapeRule=").append(escapeRule);
        result.append(",token=").append(Token.tokenToString(token)).append(']');
        return result.toString();
    } //}}}

    //{{{ Private members
    private ParserRule(int action, String hashChar,
                       int startPosMatch, char[] start, Matcher startRegexp,
                       int endPosMatch, char[] end, Matcher endRegexp,
                       ParserRuleSet delegate, byte token, byte matchType,
                       String escape) {
        this.action = action;
        this.upHashChar = null == hashChar ? null : hashChar.toUpperCase().toCharArray();
        this.upHashChars = null;
        this.startPosMatch = startPosMatch;
        this.start = start;
        this.startRegexp = startRegexp;
        this.endPosMatch = endPosMatch;
        this.end = end;
        this.endRegexp = endRegexp;
        this.delegate = delegate;
        this.token = token;
        this.matchType = matchType;
        this.escapeRule = (escape != null && escape.length() > 0) ?
                createEscapeRule(escape) : null;

        if (this.delegate == null) {
            if ((action & MAJOR_ACTIONS) != SEQ) {
                this.delegate = ParserRuleSet.getStandardRuleSet(token);
            }
        }
    }

    private ParserRule(char[] hashChars, int action,
                       int startPosMatch, char[] start, Matcher startRegexp,
                       int endPosMatch, char[] end, Matcher endRegexp,
                       ParserRuleSet delegate, byte token, byte matchType,
                       String escape) {
        this.action = action;
        this.upHashChar = null;
        Set<Character> hashCharsSet = new HashSet<Character>();
        for (char c : hashChars) {
            hashCharsSet.add(Character.toUpperCase(c));
        }
        this.upHashChars = new char[hashCharsSet.size()];
        int i = 0;
        for (Character c : hashCharsSet) {
            this.upHashChars[i++] = c;
        }
        Arrays.sort(this.upHashChars);
        this.startPosMatch = startPosMatch;
        this.start = start;
        this.startRegexp = startRegexp;
        this.endPosMatch = endPosMatch;
        this.end = end;
        this.endRegexp = endRegexp;
        this.delegate = delegate;
        this.token = token;
        this.matchType = matchType;
        this.escapeRule = (escape != null && escape.length() > 0) ?
                createEscapeRule(escape) : null;

        if (this.delegate == null) {
            if ((action & MAJOR_ACTIONS) != SEQ) {
                this.delegate = ParserRuleSet.getStandardRuleSet(token);
            }
        }
    } //}}}
}

