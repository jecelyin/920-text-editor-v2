
package com.jecelyin.editor.v2.highlight.jedit.syntax;

//{{{ Imports

import java.util.*;
import java.util.regex.Pattern;
//}}}

/**
 * A set of parser rules.
 *
 * @author mike dillon
 * @version $Id: ParserRuleSet.java 22883 2013-03-23 17:58:56Z thomasmey $
 */
public class ParserRuleSet {
    //{{{ getStandardRuleSet() method

    /**
     * Returns a parser rule set that highlights everything with the
     * specified token type.
     *
     * @param id The token type
     */
    public static ParserRuleSet getStandardRuleSet(byte id) {
        return standard[id];
    } //}}}

    //{{{ ParserRuleSet constructor
    public ParserRuleSet(String modeName, String setName) {
        this.modeName = modeName;
        this.setName = setName;
        ruleMap = new HashMap<Character, List<ParserRule>>();
        imports = new ArrayList<ParserRuleSet>();
    } //}}}

    //{{{ getModeName() method
    public String getModeName() {
        return modeName;
    } //}}}

    //{{{ getSetName() method
    public String getSetName() {
        return setName;
    } //}}}

    //{{{ getName() method
    public String getName() {
        return modeName + "::" + setName;
    } //}}}

    //{{{ getProperties() method
    public Hashtable<String, String> getProperties() {
        return props;
    } //}}}

    //{{{ setProperties() method
    public void setProperties(Hashtable<String, String> props) {
        this.props = props;
        _noWordSep = null;
    } //}}}

    //{{{ resolveImports() method

    /**
     * Resolves all rulesets added with {@link #addRuleSet(ParserRuleSet)}.
     *
     * @since jEdit 4.2pre3
     */
    public void resolveImports() {
        for (ParserRuleSet ruleset : imports) {
            if (ruleset == null)
                continue;
            if (!ruleset.imports.isEmpty()) {
                //prevent infinite recursion
                ruleset.imports.remove(this);
                ruleset.resolveImports();
            }

            for (List<ParserRule> rules : ruleset.ruleMap.values()) {
                for (ParserRule rule : rules) {
                    addRule(rule);
                }
            }

            if (ruleset.keywords != null) {
                if (keywords == null)
                    keywords = new KeywordMap(ignoreCase);
                keywords.add(ruleset.keywords);
            }
        }
        imports.clear();
    } //}}}

    //{{{ addRuleSet() method

    /**
     * Adds all rules contained in the given ruleset.
     *
     * @param ruleset The ruleset
     * @since jEdit 4.2pre3
     */
    public void addRuleSet(ParserRuleSet ruleset) {
        imports.add(ruleset);
    } //}}}

    //{{{ addRule() method
    public void addRule(ParserRule r) {
        ruleCount++;
        Character[] keys;
        if (null == r.upHashChars) {
            keys = new Character[1];
            if ((null == r.upHashChar) || (0 >= r.upHashChar.length)) {
                keys[0] = null;
            } else {
                keys[0] = r.upHashChar[0];
            }
        } else {
            keys = new Character[r.upHashChars.length];
            int i = 0;
            for (char upHashChar : r.upHashChars) {
                keys[i++] = upHashChar;
            }
        }
        for (Character key : keys) {
            List<ParserRule> rules = ruleMap.get(key);
            if (null == rules) {
                rules = new ArrayList<ParserRule>();
                ruleMap.put(key, rules);
            }
            rules.add(r);
        }
    } //}}}

    //{{{ getRules() method
    public List<ParserRule> getRules(Character key) {
        List<ParserRule> rulesForNull = ruleMap.get(null);
        boolean emptyForNull = rulesForNull == null || rulesForNull.isEmpty();
        Character upperKey = key == null ? null : Character.toUpperCase(key);
        List<ParserRule> rulesForKey = upperKey == null ? null : ruleMap.get(upperKey);
        boolean emptyForKey = rulesForKey == null || rulesForKey.isEmpty();
        if (emptyForNull && emptyForKey) {
            return Collections.emptyList();
        } else if (emptyForKey) {
            return rulesForNull;
        } else if (emptyForNull) {
            return rulesForKey;
        } else {
            int size = rulesForNull.size() + rulesForKey.size();
            List<ParserRule> mixed = new ArrayList<ParserRule>(size);
            mixed.addAll(rulesForKey);
            mixed.addAll(rulesForNull);
            return mixed;
        }
    } //}}}

    //{{{ getRuleCount() method
    public int getRuleCount() {
        return ruleCount;
    } //}}}

    //{{{ getTerminateChar() method

    /**
     * Returns the number of chars that can be read before the rule parsing stops.
     *
     * @return a number of chars or -1 (default value) if there is no limit
     */
    public int getTerminateChar() {
        return terminateChar;
    } //}}}

    //{{{ setTerminateChar() method
    public void setTerminateChar(int atChar) {
        terminateChar = (atChar >= 0) ? atChar : -1;
    } //}}}

    //{{{ getIgnoreCase() method
    public boolean getIgnoreCase() {
        return ignoreCase;
    } //}}}

    //{{{ setIgnoreCase() method
    public void setIgnoreCase(boolean b) {
        ignoreCase = b;
    } //}}}

    //{{{ getKeywords() method
    public KeywordMap getKeywords() {
        return keywords;
    } //}}}

    //{{{ setKeywords() method
    public void setKeywords(KeywordMap km) {
        keywords = km;
        _noWordSep = null;
    } //}}}

    //{{{ getHighlightDigits() method
    public boolean getHighlightDigits() {
        return highlightDigits;
    } //}}}

    //{{{ setHighlightDigits() method
    public void setHighlightDigits(boolean highlightDigits) {
        this.highlightDigits = highlightDigits;
    } //}}}

    //{{{ getDigitRegexp() method
    public Pattern getDigitRegexp() {
        return digitRE;
    } //}}}

    //{{{ setDigitRegexp() method
    public void setDigitRegexp(Pattern digitRE) {
        this.digitRE = digitRE;
    } //}}}

    //{{{ getEscapeRule() method
    public ParserRule getEscapeRule() {
        return escapeRule;
    } //}}}

    //{{{ setEscapeRule() method
    public void setEscapeRule(ParserRule escapeRule) {
        this.escapeRule = escapeRule;
    } //}}}

    //{{{ getDefault() method
    public byte getDefault() {
        return defaultToken;
    } //}}}

    //{{{ setDefault() method
    public void setDefault(byte def) {
        defaultToken = def;
    } //}}}

    //{{{ getNoWordSep() method
    public String getNoWordSep() {
        if (_noWordSep == null) {
            _noWordSep = noWordSep;
            if (noWordSep == null)
                noWordSep = "";
            if (keywords != null)
                noWordSep += keywords.getNonAlphaNumericChars();
        }
        return noWordSep;
    } //}}}

    //{{{ setNoWordSep() method
    public void setNoWordSep(String noWordSep) {
        this.noWordSep = noWordSep;
        _noWordSep = null;
    } //}}}

    //{{{ isBuiltIn() method

    /**
     * Returns if this is a built-in ruleset.
     *
     * @since jEdit 4.2pre1
     */
    public boolean isBuiltIn() {
        return builtIn;
    } //}}}

    //{{{ toString() method
    @Override
    public String toString() {
        return getClass().getName() + '[' + modeName + "::" + setName + ']';
    } //}}}

    //{{{ Private members
    private static final ParserRuleSet[] standard;

    static {
        standard = new ParserRuleSet[Token.ID_COUNT];
        for (byte i = 0; i < Token.ID_COUNT; i++) {
            standard[i] = new ParserRuleSet(null, null);
            standard[i].setDefault(i);
            standard[i].builtIn = true;
        }
    }

    private final String modeName;
    private final String setName;
    private Hashtable<String, String> props;

    KeywordMap keywords;

    int ruleCount;

    private final Map<Character, List<ParserRule>> ruleMap;

    private final List<ParserRuleSet> imports;

    /**
     * The number of chars that can be read before the parsing stops.
     * &lt;TERMINATE AT_CHAR="1" /&gt;
     */
    private int terminateChar = -1;
    boolean ignoreCase = true;
    private byte defaultToken;
    private ParserRule escapeRule;

    private boolean highlightDigits;
    private Pattern digitRE;

    private String _noWordSep;
    private String noWordSep;

    private boolean builtIn;
    //}}}
}
