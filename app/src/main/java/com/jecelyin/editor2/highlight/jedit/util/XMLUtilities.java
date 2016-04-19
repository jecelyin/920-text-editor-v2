
package com.jecelyin.editor2.highlight.jedit.util;

//{{{ Imports

import com.jecelyin.common.utils.L;
import com.jecelyin.editor2.highlight.jedit.syntax.ModeProvider;

import org.xml.sax.InputSource;
import org.xml.sax.XMLReader;
import org.xml.sax.helpers.DefaultHandler;
import org.xml.sax.helpers.XMLReaderFactory;

import java.io.BufferedInputStream;
import java.io.InputStream;
//}}}

/**
 * XML utility methods that only depend on the JDK.
 *
 * @author Marcelo Vanzin
 * @version $Id: XMLUtilities.java 22883 2013-03-23 17:58:56Z thomasmey $
 * @since 4.3pre6
 */
public class XMLUtilities {

    //{{{ charsToEntities() method

    /**
     * Converts &lt;, &gt;, &amp; in the string to their HTML entity
     * equivalents.
     * <p/>
     * <p>If <code>xml11</code> is true, then character entities
     * are used to convert illegal XML characters (mainly ASCII
     * control characters).</p>
     *
     * @param str   The string
     * @param xml11 Whether to allow XML 1.1 constructs.
     */
    public static String charsToEntities(String str, boolean xml11) {
        StringBuilder buf = new StringBuilder(str.length());
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            // control characters, excluding \t, \r and \n
            // See: http://www.w3.org/International/questions/qa-controls
            if (((0x00 <= ch && ch <= 0x1F) || (0x7F <= ch && ch <= 0x9F))
                    && ch != '\r' && ch != '\n' && ch != '\t') {
                if (xml11 && ch != 0x00) {
                    buf.append("&#").append((int) ch).append(';');
                } else {
                    // The character is illegal.
                    // But put a PI instead, to make it
                    // recoverable in certain apps.
                    buf.append("<?illegal-xml-character ")
                            .append((int) ch)
                            .append("?>");
                }
                continue;
            }

            switch (ch) {
                case '<':
                    buf.append("&lt;");
                    break;
                case '>':
                    buf.append("&gt;");
                    break;
                case '&':
                    buf.append("&amp;");
                    break;
                default:
                    buf.append(ch);
                    break;
            }
        }
        return buf.toString();
    } //}}}

    //{{{ parseXML() method

    /**
     * Convenience method for parsing an XML file. This method will
     * wrap the resource in an InputSource and set the source's
     * systemId to "jedit.jar" (so the source should be able to
     * handle any external entities by itself).
     * <p/>
     * <p>SAX Errors are caught and are not propagated to the caller;
     * instead, an error message is printed to jEdit's activity
     * log. So, if you need custom error handling, <b>do not use
     * this method</b>.
     * <p/>
     * <p>The given stream is closed before the method returns,
     * regardless whether there were errors or not.</p>
     *
     * @return true if any error occured during parsing, false if success.
     */
    public static boolean parseXML(InputStream in, DefaultHandler handler)
            throws Exception {
        XMLReader parser = XMLReaderFactory.createXMLReader();
        InputSource isrc = new InputSource(new BufferedInputStream(in));
        isrc.setSystemId("jedit.jar");
        parser.setContentHandler(handler);
        parser.setDTDHandler(handler);
        parser.setEntityResolver(handler);
        parser.setErrorHandler(handler);
        parser.parse(isrc);
        IOUtilities.closeQuietly(in);

        return false;
    } //}}}

    //{{{ resolveEntity() method

    /**
     * Tries to find the given systemId in the context of the given
     * class. If the given systemId ends with the given test string,
     * then try to load a resource using the Class's
     * <code>getResourceAsStream()</code> method using the test string
     * as the resource.
     * <p/>
     * <p>This is used a lot internally while parsing XML files used
     * by jEdit, but anyone is free to use the method if it sounds
     * usable.</p>
     */
    public static InputSource findEntity(String systemId, String test, Class<?> where) {
        if (systemId != null && systemId.endsWith(test)) {
            try {
//				return new InputSource(new BufferedInputStream(where.getResourceAsStream(test)));
//				return new InputSource(new BufferedInputStream(new FileInputStream(systemId.substring("file://".length()))));
                return new InputSource(new BufferedInputStream(ModeProvider.instance.getAssets().open(test)));
            } catch (Exception e) {
                L.e("Error while opening " + test + ":", e);
            }
        }

        return null;
    } //}}}

    private XMLUtilities() {
    }
}

