
package com.jecelyin.editor2.highlight.jedit.util;


//{{{ Imports

import android.graphics.Color;

import com.jecelyin.common.utils.L;
import com.jecelyin.editor2.highlight.jedit.syntax.SyntaxStyle;
import com.jecelyin.editor2.highlight.jedit.syntax.Token;

import java.util.HashMap;
import java.util.Locale;
import java.util.StringTokenizer;
//}}}

/**
 * Syntax utilities that depends on JDK only and syntax package.
 *
 * @author Matthieu Casanova
 * @version $Id: StandardUtilities.java 9871 2007-06-28 16:33:20Z Vampire0 $
 * @since 4.3pre13
 */
public class StyleUtilities {

    //{{{ getColorHexString() method

    /**
     * Converts a color object to its hex value. The hex value
     * prefixed is with `#', for example `#ff0088'.
     *
     * @param c The color object
     * @since jEdit 4.3pre13
     */
    public static String getColorHexString(int c) {
        String colString = Integer.toHexString(c & 0xffffff);
        return "#000000".substring(0, 7 - colString.length()).concat(colString);
    } //}}}

    //{{{ parseColor() method

    /**
     * @since jEdit 4.3pre13
     */
    public static int parseColor(String name, int defaultColor) {
        if (name == null || name.length() == 0)
            return defaultColor;

        name = name.trim();

        try {
            return Color.parseColor(name);
        } catch (Exception e) {
            L.e("color parse error!", e);
            return defaultColor;
        }
    } //}}}

    //{{{ parseStyle() method

    /**
     * Converts a style string to a style object.
     *
     * @param str            The style string
     * @param family         Style strings only specify font style, not font family
     * @param size           Style strings only specify font style, not font family
     * @param color          If false, the styles will be monochrome
     * @param defaultFgColor Default foreground color (if not specified in style string)
     * @throws IllegalArgumentException if the style is invalid
     * @since jEdit 4.3pre17
     */
    public static SyntaxStyle parseStyle(String str, String family, int size,
                                         boolean color, int defaultFgColor)
            throws IllegalArgumentException {
        int fgColor = defaultFgColor;
        int bgColor = 0;
        boolean italic = false;
        boolean bold = false;
        StringTokenizer st = new StringTokenizer(str);
        while (st.hasMoreTokens()) {
            String s = st.nextToken();
            if (s.startsWith("color:")) {
                if (color)
                    fgColor = parseColor(s.substring(6), Color.BLACK);
            } else if (s.startsWith("bgColor:")) {
                if (color)
                    bgColor = parseColor(s.substring(8), 0);
            } else if (s.startsWith("style:")) {
                for (int i = 6; i < s.length(); i++) {
                    if (s.charAt(i) == 'i')
                        italic = true;
                    else if (s.charAt(i) == 'b')
                        bold = true;
                    else
                        throw new IllegalArgumentException(
                                "Invalid style: " + s);
                }
            } else
                throw new IllegalArgumentException(
                        "Invalid directive: " + s);
        }
        return new SyntaxStyle(fgColor, bgColor);
    } //}}}

    //{{{ parseStyle() method

    /**
     * Converts a style string to a style object.
     *
     * @param str    The style string
     * @param family Style strings only specify font style, not font family
     * @param size   Style strings only specify font style, not font family
     * @param color  If false, the styles will be monochrome
     * @throws IllegalArgumentException if the style is invalid
     * @since jEdit 4.3pre13
     */
    public static SyntaxStyle parseStyle(String str, String family, int size,
                                         boolean color)
            throws IllegalArgumentException {
        return parseStyle(str, family, size, color, Color.BLACK);
    } //}}}

    //{{{ loadStyles() methods

    /**
     * Loads the syntax styles from the properties, giving them the specified
     * base font family and size.
     *
     * @param family The font family
     * @param size   The font size
     * @since jEdit 4.3pre13
     */
    public static SyntaxStyle[] loadStyles(String family, int size) {
        return loadStyles(family, size, true);
    }

    /**
     * Loads the syntax styles from the properties, giving them the specified
     * base font family and size.
     *
     * @param family The font family
     * @param size   The font size
     * @param color  If false, the styles will be monochrome
     * @since jEdit 4.3pre13
     */
    public static SyntaxStyle[] loadStyles(String family, int size, boolean color) {
        SyntaxStyle[] styles = new SyntaxStyle[Token.ID_COUNT];
        HashMap<String, String> map = new HashMap<>();
        map.put("view.style.comment1", "color:#cc0000");
        map.put("view.style.comment2", "color:#ff8400");
        map.put("view.style.comment3", "color:#6600cc");
        map.put("view.style.comment4", "color:#cc6600");
        map.put("view.style.digit", "color:#ff0000");
        map.put("view.style.foldLine.0", "color:#000000 bgColor:#dafeda style:b");
        map.put("view.style.foldLine.1", "color:#000000 bgColor:#fff0cc style:b");
        map.put("view.style.foldLine.2", "color:#000000 bgColor:#e7e7ff style:b");
        map.put("view.style.foldLine.3", "color:#000000 bgColor:#ffe0f0 style:b");
        map.put("view.style.function", "color:#9966ff");
        map.put("view.style.invalid", "color:#ff0066 bgColor:#ffffcc");
        map.put("view.style.keyword1", "color:#006699 style:b");
        map.put("view.style.keyword2", "color:#009966 style:b");
        map.put("view.style.keyword3", "color:#0099ff style:b");
        map.put("view.style.keyword4", "color:#66ccff style:b");
        map.put("view.style.label", "color:#02b902");
        map.put("view.style.literal1", "color:#ff00cc");
        map.put("view.style.literal2", "color:#cc00cc");
        map.put("view.style.literal3", "color:#9900cc");
        map.put("view.style.literal4", "color:#6600cc");
        map.put("view.style.markup", "color:#0000ff");
        map.put("view.style.operator", "color:#000000 style:b");
        // start at 1 not 0 to skip Token.NULL
        for (int i = 1; i < styles.length; i++) {
            try {
                String styleName = "view.style."
                        + Token.tokenToString((byte) i)
                        .toLowerCase(Locale.ENGLISH);
                styles[i] = parseStyle(map.get(styleName), family, size, color);
            } catch (Exception e) {
                L.e(e.getMessage(), e);
            }
        }

        return styles;
    } //}}}

    private StyleUtilities() {
    }
}
