
package com.jecelyin.editor2.highlight.jedit;

import com.jecelyin.common.utils.L;
import com.jecelyin.editor2.highlight.jedit.syntax.ModeProvider;
import com.jecelyin.editor2.highlight.jedit.syntax.TokenMarker;
import com.jecelyin.editor2.highlight.jedit.syntax.XModeHandler;
import com.jecelyin.editor2.highlight.jedit.util.XMLUtilities;

import org.xml.sax.SAXParseException;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * Created by jecelyin on 15/9/9.
 */
public class JEdit {
    private static final String HOME = "/Users/jecelyin/IdeaProjects/Syntax";

    //{{{ reloadModes() method

    /**
     * Reloads all edit modes.  User defined edit modes are loaded after
     * global modes so that user modes supercede global modes.
     *
     * @since jEdit 3.2pre2
     */
    public static void reloadModes() {

//        ModeProvider.instance.removeAll();

        //{{{ Load the global catalog first
        loadModeCatalog("/modes/", "catalog");

//        //{{{ Load user catalog second so user modes override global modes.
//        if(settingsDirectory != null)
//        {
//            File userModeDir = new File(MiscUtilities.constructPath(
//                    settingsDirectory,"modes"));
//            if(!userModeDir.exists())
//                userModeDir.mkdirs();
//
//            File userCatalog = new File(MiscUtilities.constructPath(
//                    settingsDirectory,"modes","catalog"));
//            if(!userCatalog.exists())
//            {
//                // create dummy catalog
//                BufferedWriter out = null;
//                try
//                {
//
//                    out = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(userCatalog), "UTF-8"));
//                    out.write(jEdit.getProperty("defaultCatalog"));
//                }
//                catch(IOException io)
//                {
//                    Log.log(Log.ERROR,jEdit.class,io);
//                }
//                finally
//                {
//                    IOUtilities.closeQuietly((Closeable) out);
//                }
//            }
//
//            loadModeCatalog(userCatalog.getPath(),false);
//        } //}}}
//
//        Buffer buffer = buffersFirst;
//        while(buffer != null)
//        {
//            // This reloads the token marker and sends a message
//            // which causes edit panes to repaint their text areas
//            buffer.setMode();
//
//            buffer = buffer.next;
//        }
    } //}}}

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
        final String fileName = (String) mode.getFile(); //todo:
        XModeHandler xmh = new XModeHandler(mode.getName()) {
            @Override
            public void error(String what, Object subst) {
                String msg;

                Object line = "<unknown>";
                if (subst == null)
                    msg = "xmode-error." + what;
                else {
                    msg = "xmode-error." + what + subst.toString();
                    if (subst instanceof Throwable)
                        L.e(msg, subst);
                    if (subst instanceof SAXParseException) {
                        line = ((SAXParseException) subst).getLineNumber();
                    }
                }

//                Object[] args = { fileName, line, null, msg };
//                GUIUtilities.error(null,"xmode-error",args);
                L.e("xmode-error: " + fileName + "(#" + line + ")\n" + msg);
            }

            @Override
            public TokenMarker getTokenMarker(String modeName) {
                Mode mode = getMode(modeName);
                if (mode == null)
                    return null;
                else
                    return mode.getTokenMarker();
            }
        };
        ModeProvider.instance.loadMode(mode, xmh);
    } //}}}

    //{{{ loadModeCatalog() method

    /**
     * Loads a mode catalog file.
     *
     * @since jEdit 3.2pre2
     */
    private static void loadModeCatalog(String path, String filename) {
        String file = HOME + path + filename;
        ModeCatalogHandler handler = new ModeCatalogHandler(HOME + path) {
            @Override
            protected Mode instantiateMode(String modeName, String file, String fileNameGlob, String firstLineGlob) {
                return new Mode(modeName, file, fileNameGlob, firstLineGlob);
            }
        };
        try {
            InputStream _in;
            _in = new FileInputStream(file);
            XMLUtilities.parseXML(_in, handler);
        } catch (Exception e) {
//            Log.log(Log.ERROR, JEdit.class, e);
            throw new RuntimeException(e);
        }
    } //}}}

}
