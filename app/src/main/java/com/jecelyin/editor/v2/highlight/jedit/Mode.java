
package com.jecelyin.editor.v2.highlight.jedit;

//{{{ Imports

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.highlight.SyntaxParser;
import com.jecelyin.editor.v2.highlight.jedit.syntax.TokenMarker;

import java.util.Hashtable;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;
//}}}

/**
 * An edit mode defines specific settings for editing some type of file.
 * One instance of this class is created for each supported edit mode.
 *
 * @author Slava Pestov
 * @version $Id: Mode.java 23224 2013-09-30 20:51:42Z shlomy $
 */
public class Mode {
    private final String fileNameGlob;
    private final String firstLineGlob;
    private String file;

    //{{{ Private members
    protected final String name;
    protected final Map<String, Object> props;
    private Matcher firstlineMatcher;
    private Matcher filepathMatcher;
    protected TokenMarker marker;
    //	private List<IndentRule> indentRules;
    private String electricKeys;
    private boolean ignoreWhitespace;
    //}}}

    //{{{ Mode constructor

    /**
     * Creates a new edit mode.
     *
     * @param name The name used in mode listings and to query mode
     *             properties
     */
    public Mode(String name, String syntaxFilename, String fileNameGlob, String firstLineGlob) {
        this.fileNameGlob = fileNameGlob;
        this.firstLineGlob = firstLineGlob;
        this.name = name;
        this.file = syntaxFilename;
        this.ignoreWhitespace = true;
        props = new Hashtable<String, Object>();
        init();
    } //}}}

    //{{{ init() method

    /**
     * Initializes the edit mode. Should be called after all properties
     * are loaded and set.
     */
    public void init() {
        try {
            filepathMatcher = null;
            if (fileNameGlob != null && !fileNameGlob.isEmpty()) {

                this.filepathMatcher = Pattern.compile(fileNameGlob, Pattern.CASE_INSENSITIVE).matcher("");
            }

            firstlineMatcher = null;
            if (firstLineGlob != null && !firstLineGlob.isEmpty()) {
                firstlineMatcher = Pattern.compile(firstLineGlob,
                        Pattern.CASE_INSENSITIVE).matcher("");
            }
        } catch (PatternSyntaxException re) {
            L.e("Invalid filename/firstline"
                    + " globs in mode " + name, re);
        }

        // Fix for this bug:
        // -- Put a mode into the user dir with the same name as one
        //    on the system dir.
        // -- Reload edit modes.
        // -- Old mode from system dir still used for highlighting
        //    until jEdit restart.
        marker = null;
    } //}}}

    //{{{ getTokenMarker() method

    /**
     * Returns the token marker for this mode.
     */
    public TokenMarker getTokenMarker() {
        loadIfNecessary();
        return marker;
    } //}}}

    //{{{ setTokenMarker() method

    /**
     * Sets the token marker for this mode.
     *
     * @param marker The new token marker
     */
    public void setTokenMarker(TokenMarker marker) {
        this.marker = marker;
    } //}}}

    //{{{ loadIfNecessary() method

    /**
     * Loads the mode from disk if it hasn't been loaded already.
     *
     * @since jEdit 2.5pre3
     */
    public void loadIfNecessary() {
        if (marker == null) {
            SyntaxParser.loadMode(this);
//			ModeProvider.instance.loadMode(this);
            if (marker == null)
                L.e("Mode not correctly loaded, token marker is still null");
        }
    } //}}}

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
//	//{{{ getProperty() method
//	/**
//	 * Returns a mode property.
//	 * @param key The property name
//	 *
//	 * @since jEdit 2.2pre1
//	 */
//	public Object getProperty(String key)
//	{
//		return props.get(key);
//	} //}}}
//
//	//{{{ getBooleanProperty() method
//	/**
//	 * Returns the value of a boolean property.
//	 * @param key The property name
//	 *
//	 * @since jEdit 2.5pre3
//	 */
//	public boolean getBooleanProperty(String key)
//	{
//		Object value = getProperty(key);
//		return TextUtilities.getBoolean(value, false);
//	} //}}}
//
//	//{{{ setProperty() method
//	/**
//	 * Sets a mode property.
//	 * @param key The property name
//	 * @param value The property value
//	 */
//	public void setProperty(String key, Object value)
//	{
//		props.put(key,value);
//	} //}}}
//
//	//{{{ unsetProperty() method
//	/**
//	 * Unsets a mode property.
//	 * @param key The property name
//	 * @since jEdit 3.2pre3
//	 */
//	public void unsetProperty(String key)
//	{
//		props.remove(key);
//	} //}}}
//
//	//{{{ setProperties() method
//	/**
//	 * Should only be called by <code>XModeHandler</code>.
//	 * @since jEdit 4.0pre3
//	 */
//	public void setProperties(Map props)
//	{
//		if(props == null)
//			return;
//
//		ignoreWhitespace = !"false".equalsIgnoreCase(
//					(String)props.get("ignoreWhitespace"));
//
//		this.props.putAll(props);
//	} //}}}

    //{{{ accept() method

    /**
     * Returns true if the edit mode is suitable for editing the specified
     * file. The buffer name and first line is checked against the
     * file name and first line globs, respectively.
     *
     * @param fileName  The buffer's name, can be {@code null}
     * @param firstLine The first line of the buffer
     * @since jEdit 3.2pre3
     */
    public boolean accept(String fileName, String firstLine) {
        return accept(null, fileName, firstLine);
    } //}}}

    //{{{ accept() method

    /**
     * Returns true if the edit mode is suitable for editing the specified
     * file. The buffer name and first line is checked against the
     * file name and first line globs, respectively.
     *
     * @param filePath  The buffer's path, can be {@code null}
     * @param fileName  The buffer's name, can be {@code null}
     * @param firstLine The first line of the buffer
     * @since jEdit 4.5pre1
     */
    public boolean accept(String filePath, String fileName, String firstLine) {
        return acceptFile(filePath, fileName)
                || acceptIdentical(filePath, fileName)
                || acceptFirstLine(firstLine);
    } //}}}

    //{{{ acceptFilename() method

    /**
     * Returns true if the buffer name matches the file name glob.
     *
     * @param fileName The buffer's name, can be {@code null}
     * @return true if the file name matches the file name glob.
     * @since jEdit 4.3pre18
     * @deprecated use {@link #acceptFile(String, String)} instead
     */
    @Deprecated
    public boolean acceptFilename(String fileName) {
        return acceptFile(null, fileName);
    } //}}}

    //{{{ acceptFile() method

    /**
     * Returns true if the buffer's name or path matches the file name glob.
     *
     * @param filePath The buffer's path, can be {@code null}
     * @param fileName The buffer's name, can be {@code null}
     * @return true if the file path or name matches the file name glob.
     * @since jEdit 4.5pre1
     */
    public boolean acceptFile(String filePath, String fileName) {
        if (filepathMatcher == null)
            return false;

        return fileName != null && filepathMatcher.reset(fileName).matches() ||
                filePath != null && filepathMatcher.reset(filePath).matches();
    } //}}}

    //{{{ acceptFilenameIdentical() method

    /**
     * Returns true if the buffer name is identical to the file name glob.
     * This works only for regular expressions that only represent themselves,
     * i.e. without any meta-characters.
     *
     * @param fileName The buffer's name, can be {@code null}
     * @return true if the file name matches the file name glob.
     * @since jEdit 4.4pre1
     */
    public boolean acceptFilenameIdentical(String fileName) {
        return acceptIdentical(null, fileName);
    } //}}}

    //{{{ acceptIdentical() method

    /**
     * Returns true if the buffer path or name is identical to the file name glob.
     * This works only for regular expressions that only represent themselves,
     * i.e. without any meta-characters.
     *
     * @param filePath The buffer's path, can be {@code null}
     * @param fileName The buffer's name, can be {@code null}
     * @return true if the file name matches the file name glob.
     * @since jEdit 4.5pre1
     */
    public boolean acceptIdentical(String filePath, String fileName) {
        if (fileNameGlob == null)
            return false;

        if (fileName != null && fileName.equalsIgnoreCase(fileNameGlob))
            return true;

        if (filePath != null) {
            // get the filename from the path
            // NOTE: can't use MiscUtilities.getFileName here as that breaks
            // the stand-alone text area build.
            int lastUnixPos = filePath.lastIndexOf('/');
            int lastWindowsPos = filePath.lastIndexOf('\\');
            int index = Math.max(lastUnixPos, lastWindowsPos);
            String filename = filePath.substring(index + 1);
            return filename != null && filename.equalsIgnoreCase(fileNameGlob);
        }

        return false;
    } //}}}

    //{{{ acceptFirstLine() method

    /**
     * Returns true if the first line matches the first line glob.
     *
     * @param firstLine The first line of the buffer
     * @return true if the first line matches the first line glob.
     * @since jEdit 4.3pre18
     */
    public boolean acceptFirstLine(String firstLine) {
        if (firstlineMatcher == null)
            return false;

        return firstLine != null && firstlineMatcher.reset(firstLine).matches();
    } //}}}

    //{{{ getName() method

    /**
     * Returns the internal name of this edit mode.
     */
    public String getName() {
        return name;
    } //}}}

    //{{{ toString() method

    /**
     * Returns a string representation of this edit mode.
     */
    public String toString() {
        return name;
    } //}}}

    //{{{ getIgnoreWhitespace() method
    public boolean getIgnoreWhitespace() {
        return ignoreWhitespace;
    } //}}}

    //{{{ Indent rules

//	//{{{ getIndentRules() method
//	public synchronized List<IndentRule> getIndentRules()
//	{
//		if (indentRules == null)
//		{
//			initIndentRules();
//		}
//		return indentRules;
//	} //}}}

//	//{{{ isElectricKey() method
//	public synchronized boolean isElectricKey(char ch)
//	{
//		if (electricKeys == null)
//		{
//			String[] props = {
//				"indentOpenBrackets",
//				"indentCloseBrackets",
//				"electricKeys"
//			};
//
//			StringBuilder buf = new StringBuilder();
//			for (String prop1 : props)
//			{
//				String prop = (String) getProperty(prop1);
//				if (prop != null)
//					buf.append(prop);
//			}
//
//			electricKeys = buf.toString();
//		}
//
//		return (electricKeys.indexOf(ch) >= 0);
//	} //}}}

    //{{{ initIndentRules() method
//	private void initIndentRules()
//	{
//		List<IndentRule> rules = new LinkedList<IndentRule>();
//
//		String[] regexpProps = {
//			"indentNextLine",
//			"indentNextLines"
//		};
//
//		for(int i = 0; i < regexpProps.length; i++)
//		{
//			IndentRule rule = createRegexpIndentRule(regexpProps[i]);
//			if(rule != null)
//				rules.add(rule);
//		}
//
//		String[] bracketProps = {
//			"indentOpenBracket",
//			"indentCloseBracket",
//			"unalignedOpenBracket",
//			"unalignedCloseBracket",
//		};
//
//		for (String bracketProp : bracketProps)
//			createBracketIndentRules(bracketProp, rules);
//
//		String[] finalProps = {
//			"unindentThisLine",
//			"unindentNextLines"
//		};
//
//		for(int i = 0; i < finalProps.length; i++)
//		{
//			IndentRule rule = createRegexpIndentRule(finalProps[i]);
//			if(rule != null)
//				rules.add(rule);
//		}
//
//		if (getBooleanProperty("deepIndent"))
//		{
//			String unalignedOpenBrackets = (String) getProperty("unalignedOpenBrackets");
//			if (unalignedOpenBrackets != null)
//			{
//				for (int i = 0 ; i < unalignedOpenBrackets.length();i++)
//				{
//					char openChar = unalignedOpenBrackets.charAt(i);
//					char closeChar = TextUtilities.getComplementaryBracket(openChar, null);
//					if (closeChar != '\0')
//						rules.add(new DeepIndentRule(openChar, closeChar));
//				}
//			}
//		}
//
//		if (!getIgnoreWhitespace())
//			rules.add(new WhitespaceRule());
//
//		indentRules = Collections.unmodifiableList(rules);
//	} //}}}
//
//	//{{{ createRegexpIndentRule() method
//	private IndentRule createRegexpIndentRule(String prop)
//	{
//		String value = (String) getProperty(prop);
//
//		try
//		{
//			if(value != null)
//			{
//				Method m = IndentRuleFactory.class.getMethod(
//					prop,new Class[] { String.class });
//				return (IndentRule)m.invoke(null, value);
//			}
//		}
//		catch(Exception e)
//		{
//			Log.log(Log.ERROR,this,"Bad indent rule " + prop
//				+ '=' + value + ':');
//			Log.log(Log.ERROR,this,e);
//		}
//
//		return null;
//	} //}}}
//
//	//{{{ createBracketIndentRules() method
//	private void createBracketIndentRules(String prop,
//						List<IndentRule> rules)
//	{
//		String value = (String) getProperty(prop + 's');
//
//		try
//		{
//			if(value != null)
//			{
//				for(int i = 0; i < value.length(); i++)
//				{
//					char ch = value.charAt(i);
//
//					Method m = IndentRuleFactory.class.getMethod(
//						prop,new Class[] { char.class });
//					rules.add((IndentRule) m.invoke(null, ch));
//				}
//			}
//		}
//		catch(Exception e)
//		{
//			Log.log(Log.ERROR,this,"Bad indent rule " + prop
//				+ '=' + value + ':');
//			Log.log(Log.ERROR,this,e);
//		}
//	} //}}}

    //}}}

}
