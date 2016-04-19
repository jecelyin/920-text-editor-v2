
package com.jecelyin.editor2.highlight.jedit;

//{{{ Imports

import com.jecelyin.common.utils.L;
import com.jecelyin.editor2.highlight.jedit.util.XMLUtilities;
import com.jecelyin.editor2.highlight.jedit.syntax.ModeProvider;

import org.xml.sax.Attributes;
import org.xml.sax.InputSource;
import org.xml.sax.helpers.DefaultHandler;

import java.io.File;
//}}}

/**
 * @author Slava Pestov
 */
class ModeCatalogHandler extends DefaultHandler {
    //{{{ ModeCatalogHandler constructor
    ModeCatalogHandler(String directory) {
        this.directory = directory;
    } //}}}

    //{{{ resolveEntity() method
    public InputSource resolveEntity(String publicId, String systemId) {
        return XMLUtilities.findEntity(systemId, "catalog.dtd", getClass());
    } //}}}

    //{{{ startElement() method
    public void startElement(String uri, String localName,
                             String qName, Attributes attrs) {
        if (qName.equals("MODE")) {
            String modeName = attrs.getValue("NAME");

            String file = attrs.getValue("FILE");
            if (file == null) {
                L.e(directory + "catalog:"
                        + " mode " + modeName + " doesn't have"
                        + " a FILE attribute");
            }

            String filenameGlob = attrs.getValue("FILE_NAME_GLOB");
            String firstlineGlob = attrs.getValue("FIRST_LINE_GLOB");

            Mode mode = instantiateMode(modeName, file, filenameGlob, firstlineGlob);

            ModeProvider.instance.addMode(mode); //TODO:

            String path = new File(directory, file).getPath();
            mode.setFile(path);
//			mode.setProperty("file",path);
//
//			mode.unsetProperty("filenameGlob");
//			if(filenameGlob != null)
//				mode.setProperty("filenameGlob",filenameGlob);
//
//			mode.unsetProperty("firstlineGlob");
//			if(firstlineGlob != null)
//				mode.setProperty("firstlineGlob",firstlineGlob);
//
//			mode.init();
        }
    } //}}}

    protected Mode instantiateMode(String modeName, String file, String fileNameGlob, String firstLineGlob) {
        return new Mode(modeName, file, fileNameGlob, firstLineGlob);
    }

    private String directory;

}

