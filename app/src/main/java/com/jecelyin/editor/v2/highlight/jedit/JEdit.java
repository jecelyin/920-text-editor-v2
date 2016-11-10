
package com.jecelyin.editor.v2.highlight.jedit;

import com.jecelyin.editor.v2.highlight.SyntaxParser;
import com.jecelyin.editor.v2.highlight.jedit.syntax.ModeProvider;

/**
 * Created by jecelyin on 15/9/9.
 */
public class JEdit {

    //{{{ getMode() method

    /**
     * Returns the edit mode with the specified name.
     *
     * @param name The edit mode
     */
    public static Mode getMode(String name) {
        return ModeProvider.instance.getMode(name);
    } //}}}

    //{{{ getModes() method

    /**
     * Returns an array of installed edit modes.
     */
    public static Mode[] getModes() {
        return ModeProvider.instance.getModes();
    } //}}}

    //{{{ loadMode() method

    /**
     * Loads an XML-defined edit mode from the specified reader.
     *
     * @param mode The edit mode
     */
    /* package-private */
    static void loadMode(Mode mode) {
        SyntaxParser.loadMode(mode);
    } //}}}

}
