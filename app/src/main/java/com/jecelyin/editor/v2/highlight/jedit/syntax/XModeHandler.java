
package com.jecelyin.editor.v2.highlight.jedit.syntax;

//{{{ Imports

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.util.XMLUtilities;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import java.util.Hashtable;
import java.util.Stack;
import java.util.Vector;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
//}}}

/**
 * XML handler for mode definition files.
 *
 * @version $Id: XModeHandler.java 21831 2012-06-18 22:54:17Z ezust $
 */
public abstract class XModeHandler extends DefaultHandler {
    //{{{ XModeHandler constructor
    public XModeHandler(String modeName) {
        this.modeName = modeName;
        marker = new TokenMarker();
        marker.addRuleSet(new ParserRuleSet(modeName, "MAIN"));
        stateStack = new Stack<TagDecl>();
    } //}}}

    //{{{ resolveEntity() method
    public InputSource resolveEntity(String publicId, String systemId) {
        return XMLUtilities.findEntity(systemId, "xmode.dtd", XModeHandler.class);
    } //}}}

    //{{{ characters() method
    public void characters(char[] c, int off, int len) {
        peekElement().setText(c, off, len);
    } //}}}

    //{{{ startElement() method
    public void startElement(String uri, String localName,
                             String qName, Attributes attrs) {
        TagDecl tag = pushElement(qName, attrs);

        if (qName.equals("WHITESPACE")) {
            L.w(modeName + ": WHITESPACE rule "
                    + "no longer needed");
        } else if (qName.equals("KEYWORDS")) {
            keywords = new KeywordMap(rules.getIgnoreCase());
        } else if (qName.equals("RULES")) {
            if (tag.lastSetName == null)
                tag.lastSetName = "MAIN";
            rules = marker.getRuleSet(tag.lastSetName);
            if (rules == null) {
                rules = new ParserRuleSet(modeName, tag.lastSetName);
                marker.addRuleSet(rules);
            }
            rules.setIgnoreCase(tag.lastIgnoreCase);
            rules.setHighlightDigits(tag.lastHighlightDigits);
            if (tag.lastDigitRE != null) {
                try {
                    rules.setDigitRegexp(Pattern.compile(tag.lastDigitRE,
                            tag.lastIgnoreCase
                                    ? Pattern.CASE_INSENSITIVE : 0));
                } catch (PatternSyntaxException e) {
                    error("regexp", e);
                }
            }

            if (tag.lastEscape != null)
                rules.setEscapeRule(ParserRule.createEscapeRule(tag.lastEscape));
            rules.setDefault(tag.lastDefaultID);
            rules.setNoWordSep(tag.lastNoWordSep);
        }
    } //}}}

    //{{{ endElement() method
    public void endElement(String uri, String localName, String name) {
        TagDecl tag = popElement();
        if (name.equals(tag.tagName)) {
            if (tag.lastDelegateSet != null
                    && !tag.tagName.equals("IMPORT")
                    && !tag.lastDelegateSet.getModeName().equals(modeName)) {
                Mode mode = ModeProvider.instance.getMode(tag.lastDelegateSet.getModeName());
                if (!reloadModes.contains(mode)) {
                    reloadModes.add(mode);
                }
            }
            //{{{ PROPERTY
            if (tag.tagName.equals("PROPERTY")) {
                props.put(propName, propValue);
            } //}}}
            //{{{ PROPS
            else if (tag.tagName.equals("PROPS")) {
                if (peekElement().tagName.equals("RULES"))
                    rules.setProperties(props);
                else
                    modeProps = props;

                props = new Hashtable<String, String>();
            } //}}}
            //{{{ RULES
            else if (tag.tagName.equals("RULES")) {
                rules.setKeywords(keywords);
                keywords = null;
                rules = null;
            } //}}}
            //{{{ IMPORT
            else if (tag.tagName.equals("IMPORT")) {
                // prevent lockups
                if (!rules.equals(tag.lastDelegateSet)) {
                    rules.addRuleSet(tag.lastDelegateSet);
                }
            } //}}}
            //{{{ TERMINATE
            else if (tag.tagName.equals("TERMINATE")) {
                rules.setTerminateChar(tag.termChar);
            } //}}}
            //{{{ SEQ
            else if (tag.tagName.equals("SEQ")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "SEQ");
                    return;
                }

                rules.addRule(ParserRule.createSequenceRule(
                        tag.lastStartPosMatch, tag.lastStart.toString(),
                        tag.lastDelegateSet, tag.lastTokenID));
            } //}}}
            //{{{ SEQ_REGEXP
            else if (tag.tagName.equals("SEQ_REGEXP")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "SEQ_REGEXP");
                    return;
                }

                try {
                    if (null != tag.lastHashChars) {
                        rules.addRule(ParserRule.createRegexpSequenceRule(
                                tag.lastStartPosMatch, tag.lastHashChars.toCharArray(),
                                tag.lastStart.toString(), tag.lastDelegateSet,
                                tag.lastTokenID, findParent("RULES").lastIgnoreCase));
                    } else {
                        rules.addRule(ParserRule.createRegexpSequenceRule(
                                tag.lastHashChar, tag.lastStartPosMatch,
                                tag.lastStart.toString(), tag.lastDelegateSet,
                                tag.lastTokenID, findParent("RULES").lastIgnoreCase));
                    }
                } catch (PatternSyntaxException re) {
                    error("regexp", re);
                }
            } //}}}
            //{{{ SPAN
            else if (tag.tagName.equals("SPAN")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "BEGIN");
                    return;
                }

                if (tag.lastEnd == null) {
                    error("empty-tag", "END");
                    return;
                }

                rules.addRule(ParserRule
                        .createSpanRule(
                                tag.lastStartPosMatch, tag.lastStart.toString(),
                                tag.lastEndPosMatch, tag.lastEnd.toString(),
                                tag.lastDelegateSet,
                                tag.lastTokenID, tag.lastMatchType,
                                tag.lastNoLineBreak,
                                tag.lastNoWordBreak,
                                tag.lastEscape));
            } //}}}
            //{{{ SPAN_REGEXP
            else if (tag.tagName.equals("SPAN_REGEXP")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "BEGIN");
                    return;
                }

                if (tag.lastEnd == null) {
                    error("empty-tag", "END");
                    return;
                }

                try {
                    if (null != tag.lastHashChars) {
                        rules.addRule(ParserRule
                                .createRegexpSpanRule(
                                        tag.lastStartPosMatch, tag.lastHashChars.toCharArray(),
                                        tag.lastStart.toString(),
                                        tag.lastEndPosMatch, tag.lastEnd.toString(),
                                        tag.lastDelegateSet,
                                        tag.lastTokenID,
                                        tag.lastMatchType,
                                        tag.lastNoLineBreak,
                                        tag.lastNoWordBreak,
                                        findParent("RULES").lastIgnoreCase,
                                        tag.lastEscape,
                                        tag.lastEndRegexp));
                    } else {
                        rules.addRule(ParserRule
                                .createRegexpSpanRule(
                                        tag.lastHashChar,
                                        tag.lastStartPosMatch, tag.lastStart.toString(),
                                        tag.lastEndPosMatch, tag.lastEnd.toString(),
                                        tag.lastDelegateSet,
                                        tag.lastTokenID,
                                        tag.lastMatchType,
                                        tag.lastNoLineBreak,
                                        tag.lastNoWordBreak,
                                        findParent("RULES").lastIgnoreCase,
                                        tag.lastEscape,
                                        tag.lastEndRegexp));
                    }
                } catch (PatternSyntaxException re) {
                    error("regexp", re);
                }
            } //}}}
            //{{{ EOL_SPAN
            else if (tag.tagName.equals("EOL_SPAN")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "EOL_SPAN");
                    return;
                }

                rules.addRule(ParserRule.createEOLSpanRule(
                        tag.lastStartPosMatch, tag.lastStart.toString(),
                        tag.lastDelegateSet, tag.lastTokenID,
                        tag.lastMatchType));
            } //}}}
            //{{{ EOL_SPAN_REGEXP
            else if (tag.tagName.equals("EOL_SPAN_REGEXP")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "EOL_SPAN_REGEXP");
                    return;
                }

                try {
                    if (null != tag.lastHashChars) {
                        rules.addRule(ParserRule.createRegexpEOLSpanRule(
                                tag.lastStartPosMatch, tag.lastHashChars.toCharArray(),
                                tag.lastStart.toString(), tag.lastDelegateSet,
                                tag.lastTokenID, tag.lastMatchType,
                                findParent("RULES").lastIgnoreCase));
                    } else {
                        rules.addRule(ParserRule.createRegexpEOLSpanRule(
                                tag.lastHashChar, tag.lastStartPosMatch,
                                tag.lastStart.toString(), tag.lastDelegateSet,
                                tag.lastTokenID, tag.lastMatchType,
                                findParent("RULES").lastIgnoreCase));
                    }
                } catch (PatternSyntaxException re) {
                    error("regexp", re);
                }
            } //}}}
            //{{{ MARK_FOLLOWING
            else if (tag.tagName.equals("MARK_FOLLOWING")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "MARK_FOLLOWING");
                    return;
                }

                rules.addRule(ParserRule
                        .createMarkFollowingRule(
                                tag.lastStartPosMatch, tag.lastStart.toString(),
                                tag.lastTokenID, tag.lastMatchType));
            } //}}}
            //{{{ MARK_PREVIOUS
            else if (tag.tagName.equals("MARK_PREVIOUS")) {
                if (tag.lastStart == null) {
                    error("empty-tag", "MARK_PREVIOUS");
                    return;
                }

                rules.addRule(ParserRule
                        .createMarkPreviousRule(
                                tag.lastStartPosMatch, tag.lastStart.toString(),
                                tag.lastTokenID, tag.lastMatchType));
            } //}}}
            //{{{ Keywords
            else if (
                    !tag.tagName.equals("END")
                            && !tag.tagName.equals("BEGIN")
                            && !tag.tagName.equals("KEYWORDS")
                            && !tag.tagName.equals("MODE")) {
                byte token = Token.stringToToken(tag.tagName);
                if (token != -1) {
                    if (tag.lastKeyword == null
                            || tag.lastKeyword.length() == 0) {
                        error("empty-keyword", null);
                    } else {
                        addKeyword(tag.lastKeyword.toString(), token);
                    }
                }
            } //}}}
        } else {
            // can't happen
            throw new InternalError();
        }
    } //}}}

    //{{{ startDocument() method
    public void startDocument() {
        props = new Hashtable<String, String>();
        pushElement(null, null);
        reloadModes = new Vector<Mode>();
    } //}}}

    //{{{ endDocument() method
    public void endDocument() {
        ParserRuleSet[] rulesets = marker.getRuleSets();
        for (int i = 0; i < rulesets.length; i++) {
            rulesets[i].resolveImports();
        }
        for (Mode mode : reloadModes) {
            mode.setTokenMarker(null);
            mode.loadIfNecessary();
        }
    } //}}}

    //{{{ getTokenMarker() method

    /**
     * Returns the TokenMarker.
     *
     * @return a TokenMarker it cannot be null
     */
    public TokenMarker getTokenMarker() {
        return marker;
    } //}}}

    //{{{ getModeProperties() method
    public Hashtable<String, String> getModeProperties() {
        return modeProps;
    } //}}}

    //{{{ Protected members

    //{{{ error() method

    /**
     * Reports an error.
     * You must override this method so that the mode loader can do error
     * reporting.
     *
     * @param msg   The error type
     * @param subst A <code>String</code> or a <code>Throwable</code>
     *              containing specific information
     * @since jEdit 4.2pre1
     */
    protected abstract void error(String msg, Object subst);
    //}}}

    //{{{ getTokenMarker() method

    /**
     * Returns the token marker for the given mode.
     * You must override this method so that the mode loader can resolve
     * delegate targets.
     *
     * @param mode The mode name
     * @since jEdit 4.2pre1
     */
    protected abstract TokenMarker getTokenMarker(String mode);
    //}}}

    //}}}

    //{{{ Private members

    //{{{ Instance variables
    private String modeName;
    /**
     * The token marker cannot be null.
     */
    private final TokenMarker marker;
    private KeywordMap keywords;
    /**
     * this stack can contains null elements.
     */
    private Stack<TagDecl> stateStack;
    private String propName;
    private String propValue;
    private Hashtable<String, String> props;
    private Hashtable<String, String> modeProps;
    private ParserRuleSet rules;
    /**
     * A list of modes to be reloaded at the end, loaded through DELEGATEs
     */
    private Vector<Mode> reloadModes;
    //}}}

    //{{{ addKeyword() method
    private void addKeyword(String k, byte id) {
        if (keywords == null) return;
        keywords.add(k, id);
    } //}}}

    //{{{ pushElement() method
    private TagDecl pushElement(String name, Attributes attrs) {
        if (name != null) {
            TagDecl tag = new TagDecl(name, attrs);
            stateStack.push(tag);
            return tag;
        } else {
            stateStack.push(null);
            return null;
        }
    } //}}}

    //{{{ peekElement() method
    private TagDecl peekElement() {
        return stateStack.peek();
    } //}}}

    //{{{ popElement() method
    private TagDecl popElement() {
        return stateStack.pop();
    } //}}}

    //{{{ findParent() method

    /**
     * Finds the first element whose tag matches 'tagName',
     * searching backwards in the stack.
     */
    private TagDecl findParent(String tagName) {
        for (int idx = stateStack.size() - 1; idx >= 0; idx--) {
            TagDecl tag = stateStack.get(idx);
            if (tag.tagName.equals(tagName))
                return tag;
        }
        return null;
    } //}}}

    //}}}

    /**
     * Hold info about what tag was read and what attributes were
     * set in the XML file, to be kept by the handler in a stack
     * (similar to the way tag names were kept in a stack before).
     */
    private class TagDecl {

        public TagDecl(String tagName, Attributes attrs) {
            this.tagName = tagName;

            String tmp;

            propName = attrs.getValue("NAME");
            propValue = attrs.getValue("VALUE");

            tmp = attrs.getValue("TYPE");
            if (tmp != null) {
                lastTokenID = Token.stringToToken(tmp);
                if (lastTokenID == -1)
                    error("token-invalid", tmp);
            }

            lastMatchType = ParserRule.MATCH_TYPE_RULE;
            // check for the deprecated "EXCLUDE_MATCH" and
            // warn if found.
            tmp = attrs.getValue("EXCLUDE_MATCH");
            if (tmp != null) {
                L.w(modeName + ": EXCLUDE_MATCH is deprecated");
                if ("TRUE".equalsIgnoreCase(tmp)) {
                    lastMatchType = ParserRule.MATCH_TYPE_CONTEXT;
                }
            }

            // override with the newer MATCH_TYPE if present
            tmp = attrs.getValue("MATCH_TYPE");
            if (tmp != null) {
                if ("CONTEXT".equals(tmp)) {
                    lastMatchType = ParserRule.MATCH_TYPE_CONTEXT;
                } else if ("RULE".equals(tmp)) {
                    lastMatchType = ParserRule.MATCH_TYPE_RULE;
                } else {
                    lastMatchType = Token.stringToToken(tmp);
                    if (lastMatchType == -1)
                        error("token-invalid", tmp);
                }
            }

            lastAtLineStart = "TRUE".equals(attrs.getValue("AT_LINE_START"));
            lastAtWhitespaceEnd = "TRUE".equals(attrs.getValue("AT_WHITESPACE_END"));
            lastAtWordStart = "TRUE".equals(attrs.getValue("AT_WORD_START"));
            lastNoLineBreak = "TRUE".equals(attrs.getValue("NO_LINE_BREAK"));
            lastNoWordBreak = "TRUE".equals(attrs.getValue("NO_WORD_BREAK"));
            lastIgnoreCase = (attrs.getValue("IGNORE_CASE") == null ||
                    "TRUE".equals(attrs.getValue("IGNORE_CASE")));
            lastHighlightDigits = "TRUE".equals(attrs.getValue("HIGHLIGHT_DIGITS"));
            lastRegexp = "TRUE".equals(attrs.getValue("REGEXP"));
            lastDigitRE = attrs.getValue("DIGIT_RE");

            tmp = attrs.getValue("NO_WORD_SEP");
            if (tmp != null)
                lastNoWordSep = tmp;

            tmp = attrs.getValue("AT_CHAR");
            if (tmp != null) {
                try {
                    termChar = Integer.parseInt(tmp);
                } catch (NumberFormatException e) {
                    error("termchar-invalid", tmp);
                    termChar = -1;
                }
            }

            lastEscape = attrs.getValue("ESCAPE");
            lastSetName = attrs.getValue("SET");

            tmp = attrs.getValue("DELEGATE");
            if (tmp != null) {
                String delegateMode, delegateSetName;

                int index = tmp.indexOf("::");

                if (index != -1) {
                    delegateMode = tmp.substring(0, index);
                    delegateSetName = tmp.substring(index + 2);
                } else {
                    delegateMode = modeName;
                    delegateSetName = tmp;
                }

                TokenMarker delegateMarker = getTokenMarker(delegateMode);
                if (delegateMarker == null)
                    error("delegate-invalid", tmp);
                else {
                    lastDelegateSet = delegateMarker
                            .getRuleSet(delegateSetName);
                    if (delegateMarker == marker
                            && lastDelegateSet == null) {
                        // stupid hack to handle referencing
                        // a rule set that is defined later!
                        lastDelegateSet = new ParserRuleSet(
                                delegateMode,
                                delegateSetName);
                        lastDelegateSet.setDefault(Token.INVALID);
                        marker.addRuleSet(lastDelegateSet);
                    } else if (lastDelegateSet == null)
                        error("delegate-invalid", tmp);
                }
            }

            tmp = attrs.getValue("DEFAULT");
            if (tmp != null) {
                lastDefaultID = Token.stringToToken(tmp);
                if (lastDefaultID == -1) {
                    error("token-invalid", tmp);
                    lastDefaultID = Token.NULL;
                }
            }

            lastHashChar = attrs.getValue("HASH_CHAR");
            lastHashChars = attrs.getValue("HASH_CHARS");
            if ((null != lastHashChar) && (null != lastHashChars)) {
                error("hash-char-and-hash-chars-mutually-exclusive", null);
                lastHashChars = null;
            }
        }

        public void setText(char[] c, int off, int len) {
            if (tagName.equals("EOL_SPAN") ||
                    tagName.equals("EOL_SPAN_REGEXP") ||
                    tagName.equals("MARK_PREVIOUS") ||
                    tagName.equals("MARK_FOLLOWING") ||
                    tagName.equals("SEQ") ||
                    tagName.equals("SEQ_REGEXP") ||
                    tagName.equals("BEGIN")
                    ) {
                TagDecl target = this;
                if (tagName.equals("BEGIN"))
                    target = stateStack.get(stateStack.size() - 2);

                if (target.lastStart == null) {
                    target.lastStart = new StringBuffer();
                    target.lastStart.append(c, off, len);
                    target.lastStartPosMatch = ((target.lastAtLineStart ? ParserRule.AT_LINE_START : 0)
                            | (target.lastAtWhitespaceEnd ? ParserRule.AT_WHITESPACE_END : 0)
                            | (target.lastAtWordStart ? ParserRule.AT_WORD_START : 0));
                    target.lastAtLineStart = false;
                    target.lastAtWordStart = false;
                    target.lastAtWhitespaceEnd = false;
                } else {
                    target.lastStart.append(c, off, len);
                }
            } else if (tagName.equals("END")) {
                TagDecl target = stateStack.get(stateStack.size() - 2);
                if (target.lastEnd == null) {
                    target.lastEnd = new StringBuffer();
                    target.lastEnd.append(c, off, len);
                    target.lastEndPosMatch = ((this.lastAtLineStart ? ParserRule.AT_LINE_START : 0)
                            | (this.lastAtWhitespaceEnd ? ParserRule.AT_WHITESPACE_END : 0)
                            | (this.lastAtWordStart ? ParserRule.AT_WORD_START : 0));
                    target.lastEndRegexp = this.lastRegexp;
                    target.lastAtLineStart = false;
                    target.lastAtWordStart = false;
                    target.lastAtWhitespaceEnd = false;
                } else {
                    target.lastEnd.append(c, off, len);
                }
            } else {
                if (lastKeyword == null)
                    lastKeyword = new StringBuffer();
                lastKeyword.append(c, off, len);
            }
        }

        public String tagName;
        public StringBuffer lastStart;
        public StringBuffer lastEnd;
        public StringBuffer lastKeyword;
        public String lastSetName;
        public String lastEscape;
        public ParserRuleSet lastDelegateSet;
        public String lastNoWordSep = "_";
        public ParserRuleSet rules;
        public byte lastDefaultID = Token.NULL;
        public byte lastTokenID;
        public byte lastMatchType;
        public int termChar = -1;
        public boolean lastNoLineBreak;
        public boolean lastNoWordBreak;
        public boolean lastIgnoreCase = true;
        public boolean lastHighlightDigits;
        public boolean lastAtLineStart;
        public boolean lastAtWhitespaceEnd;
        public boolean lastAtWordStart;
        public boolean lastRegexp;
        public boolean lastEndRegexp;
        public int lastStartPosMatch;
        public int lastEndPosMatch;
        public String lastDigitRE;
        public String lastHashChar;
        public String lastHashChars;
    }
}

