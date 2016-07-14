
package com.jecelyin.editor.v2.highlight.jedit.syntax;

/**
 * A simple text style class. It can specify the color, italic flag,
 * and bold flag of a run of text.
 *
 * @author Slava Pestov
 * @version $Id: SyntaxStyle.java 21831 2012-06-18 22:54:17Z ezust $
 */
public class SyntaxStyle {
    //{{{ SyntaxStyle constructor

    /**
     * Creates a new SyntaxStyle.
     *
     * @param fgColor The text color
     * @param bgColor The background color
     */
    public SyntaxStyle(int fgColor, int bgColor) {
        this.fgColor = fgColor;
        this.bgColor = bgColor;
    } //}}}

    //{{{ getForegroundColor() method

    /**
     * Returns the text color.
     */
    public int getForegroundColor() {
        return fgColor;
    } //}}}

    //{{{ getBackgroundColor() method

    /**
     * Returns the background color.
     */
    public int getBackgroundColor() {
        return bgColor;
    } //}}}

    //{{{ Private members
    private int fgColor;
    private int bgColor;
    //}}}
}
