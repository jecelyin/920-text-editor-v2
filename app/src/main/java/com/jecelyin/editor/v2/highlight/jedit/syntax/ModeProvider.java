
package com.jecelyin.editor.v2.highlight.jedit.syntax;

//{{{ Imports

import com.jecelyin.common.utils.L;
import com.jecelyin.editor.v2.highlight.jedit.Mode;
import com.jecelyin.editor.v2.highlight.jedit.modes.Catalog;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
//}}}

/**
 * This class works like a singleton, the instance is initialized by jEdit.
 *
 * @author Matthieu Casanova
 * @version $Id: Buffer.java 8190 2006-12-07 07:58:34Z kpouer $
 * @since jEdit 4.3pre10
 */
public class ModeProvider {
    public static ModeProvider instance = new ModeProvider();

    private static final LinkedHashMap<String, Mode> modes = new LinkedHashMap<>(Catalog.modes.length);
    static {
        for (Mode mode : Catalog.modes) {
            modes.put(mode.getName().toUpperCase(), mode);
        }
    }

    //{{{ removeAll() method
//	public void removeAll()
//	{
//		modes.clear();
//	} //}}}

    //{{{ getMode() method

    /**
     * Returns the edit mode with the specified name.
     *
     * @param name The edit mode
     * @since jEdit 4.3pre10
     */
    public Mode getMode(String name) {
        return modes.get(name.toUpperCase());
    } //}}}

    //{{{ getModeForFile() method

    /**
     * Get the appropriate mode that must be used for the file
     *
     * @param filename  the filename
     * @param firstLine the first line of the file
     * @return the edit mode, or null if no mode match the file
     * @since jEdit 4.3pre12
     */
    public Mode getModeForFile(String filename, String firstLine) {
        return getModeForFile(null, filename, firstLine);
    } //}}}

    //{{{ getModeForFile() method

    /**
     * Get the appropriate mode that must be used for the file
     *
     * @param filepath  the filepath, can be {@code null}
     * @param filename  the filename, can be {@code null}
     * @param firstLine the first line of the file
     * @return the edit mode, or null if no mode match the file
     * @since jEdit 4.5pre1
     */
    public Mode getModeForFile(String filepath, String filename, String firstLine) {
        if (filepath != null && filepath.endsWith(".gz"))
            filepath = filepath.substring(0, filepath.length() - 3);
        if (filename != null && filename.endsWith(".gz"))
            filename = filename.substring(0, filename.length() - 3);

        List<Mode> acceptable = new ArrayList<Mode>(1);
        for (Mode mode : modes.values()) {
            if (mode.accept(filepath, filename, firstLine)) {
                acceptable.add(mode);
            }
        }
        if (acceptable.size() == 1) {
            return acceptable.get(0);
        }
        if (acceptable.size() > 1) {
            // The check should be in reverse order so that
            // modes from the user catalog get checked first!
            Collections.reverse(acceptable);

            // the very most acceptable mode is one whose file
            // name doesn't only match the file name as regular
            // expression but which is identical
            for (Mode mode : acceptable) {
                if (mode.acceptIdentical(filepath, filename)) {
                    return mode;
                }
            }

            // most acceptable is a mode that matches both the
            // filepath and the first line glob
            for (Mode mode : acceptable) {
                if (mode.acceptFile(filepath, filename) &&
                        mode.acceptFirstLine(firstLine)) {
                    return mode;
                }
            }
            // next best is filepath match
            for (Mode mode : acceptable) {
                if (mode.acceptFile(filepath, filename)) {
                    return mode;
                }
            }
            // all acceptable choices are by first line glob, and
            // they all match, so just return the first one.
            return acceptable.get(0);
        }
        // no matching mode found for this file
        return null;
    } //}}}

    //{{{ getModes() method

    /**
     * Returns an array of installed edit modes.
     *
     * @since jEdit 4.3pre10
     */
    public Mode[] getModes() {
//		return modes.values().toArray(new Mode[modes.size()]);
        return Catalog.modes;
    } //}}}

    //{{{ addMode() method

    /**
     * Do not call this method. It is only public so that classes
     * in the org.gjt.sp.jedit.syntax package can access it.
     *
     * @param mode The edit mode
     * @since jEdit 4.3pre10
     */
    public void addMode(Mode mode) {
        String name = mode.getName();

        // The removal makes the "insertion order" in modes
        // (LinkedHashMap) follow the order of addMode() calls.
        modes.remove(name);

        modes.put(name, mode);
    } //}}}


    //{{{ error() method
    protected void error(String file, Throwable e) {
        L.e(file, e);
    } //}}}

}
