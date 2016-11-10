/*
 * Copyright (C) 2016 Jecelyin Peng <jecelyin@gmail.com>
 *
 * This file is part of 920 Text Editor.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.jecelyin.editor.v2.tools;

import org.json.JSONObject;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NamedNodeMap;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.EntityResolver;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;



public class XML2JSON {
    private static File assetsPath;
    private static File highlightPath;
    private static File langPath;
    private static String langDefineTpl;
    private static String langDefineClassTpl;
    private static HashMap<String, Integer> classCounter = new HashMap<>();

    public static void main(String[] args) {
        File f = new File(".");
        String path = f.getAbsolutePath();

        highlightPath = new File(path, "app/src/main/java/com/jecelyin/editor/v2/highlight");
        assetsPath = new File(path, "tools/assets");
        File syntax = new File(assetsPath, "syntax");
        try {
            langDefineTpl = readFile(new File(assetsPath, "lang_define.tpl"));
            langDefineClassTpl = readFile(new File(assetsPath, "lang_define_class.tpl"));
        }catch (Exception e) {
            e.printStackTrace();
            return;
        }

        langPath = new File(highlightPath, "lang");
        for (File f2 : langPath.listFiles()) {
            f2.delete();
        }

        File[] files = syntax.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        });

        StringBuilder mapCode = new StringBuilder();
        try {
            for (File file : files) {
                o("File: %s", file.getName());
                parseXml(file, mapCode);
            }

            String langMap = readFile(new File(assetsPath, "lang_map.tpl"));
            langMap = langMap.replace("@MAP_LIST@", mapCode.toString());
            writeFile(new File(highlightPath, "LangMap.java"), langMap);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static boolean writeFile(File file, String text) {
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(file));
            bufferedWriter.write(text);
            bufferedWriter.flush();
            bufferedWriter.close();
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            file.delete();
            return false;
        }
    }

    private static void o(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    private static String fileNameToClassName(String filename) {
        StringBuilder sb = new StringBuilder(filename.length());
        int size = filename.length();
        sb.append(Character.toUpperCase(filename.charAt(0)));
        for (int i = 1; i < size; i++) {
            char c = filename.charAt(i);
            if (c == '_') {
                i++;
                sb.append(Character.toUpperCase(filename.charAt(i)));
            } else if (c == '.') {
                return sb.toString();
            } else {
                sb.append(filename.charAt(i));
            }
        }
        return sb.toString();
    }

    private static String textString(String string) {
        StringBuilder sb = new StringBuilder(string.length() * 2);
        sb.append('"');
        int size = string.length();
        for (int i = 0; i < size; i++) {
            char c = string.charAt(i);
            switch (c) {
                case '\\':
                    sb.append("\\\\");
                    break;
                case '"':
                    sb.append("\\\"");
                    break;
                default:
                    sb.append(c);
                    break;
            }
        }
        sb.append('"');
        return sb.toString();
    }

    private static void parseXml(final File file, StringBuilder mapCode) throws Exception {
        String clsName = fileNameToClassName(file.getName()) + "Lang";

        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();
//        dbFactory.setValidating(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String s, String systemId) throws SAXException, IOException {
                if (systemId.contains("xmode.dtd")) {
                    return new InputSource(new FileInputStream(new File(assetsPath, "xmode.dtd")));
                }
                return null;
            }
        });
        Document doc = dBuilder.parse(file);
        doc.getDocumentElement().normalize();

        NodeList nList = doc.getChildNodes();
        int length = nList.getLength();
        for (int i = 0; i < length; i++) {
            Node item = nList.item(i);
            o("node " + item.getNodeName() + " " + item.getNodeType());
            if (item.getNodeType() == Node.ELEMENT_NODE) {
                String code = langDefineTpl + " " + langDefineClassTpl;
                code = code.replace("@CLASS_NAME@", clsName);

                classCounter.clear();

                StringBuilder innerClass = new StringBuilder();
                code = parseNode((Element)item, code, null, innerClass);
                code = code.replace("@INNER_CLASS@", innerClass.toString());

                mapCode.append("        map.put( \"")
                        .append(file.getName()).append("\", new ").append(clsName).append("() );\n");

                File langFile = new File(langPath, clsName + ".java");
                writeFile(langFile, code);
            }
        }
    }

    private static String parseNode(Element item, String code, StringBuilder childrenCode, StringBuilder innerClass) {
//        o("  name: %s", item.getTagName());
        StringBuilder sb = new StringBuilder();

        NamedNodeMap attributes = item.getAttributes();
        int length = attributes.getLength();
        JSONObject attrs = new JSONObject();
        for (int i = 0; i < length; i++) {
            Node node = attributes.item(i);
            attrs.put(node.getNodeName(), node.getNodeValue());
            sb.append("        map.put(\"").append(node.getNodeName()).append("\", \"")
                    .append(node.getNodeValue()).append("\");\n");
        }

        boolean withoutRoot = false;
        String nodeName = item.getNodeName();
        if (code == null) {
            withoutRoot = true;

            code = "private static " + langDefineClassTpl;
            if (!classCounter.containsKey(nodeName)) {
                classCounter.put(nodeName, 0);
            }
            int count = classCounter.get(nodeName) + 1;
            classCounter.put(nodeName, count);
            String cls = fileNameToClassName(nodeName) + String.valueOf(count);
            code = code.replace("@CLASS_NAME@", cls);

            childrenCode.append("            new ")
            .append(cls).append("(),\n");
        }

        code = code.replace("@TAG@", nodeName);
        code = code.replace("@ATTRS@", sb.toString());
        sb.setLength(0);

        NodeList childNodes = item.getChildNodes();
        length = childNodes.getLength();
        StringBuilder childSb = new StringBuilder();

        String text = "null";
        for (int i = 0; i < length; i++) {
            Node child = childNodes.item(i);

            short nodeType = child.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {

                parseNode((Element) child, null, childSb, innerClass);
            } else if (nodeType == Node.TEXT_NODE) {
                text = textString(child.getTextContent().trim());
            }
        }
        code = code.replace("@TEXT@", text);
        code = code.replace("@CHILDREN@", childSb.toString());

        if (withoutRoot) {
            code = code.replace("@INNER_CLASS@", "");
            innerClass.append("\n\n").append(code).append("\n\n");
        }

        return code;
    }

    public static String readFile(File file) throws IOException {
        return readFile(file, "UTF-8");
    }

    public static String readFile(File file, String encoding) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file), encoding));
        char[] buf = new char[8192];
        int size;
        StringBuilder sb = new StringBuilder((int) file.length());
        while ((size = br.read(buf)) != -1) {
            sb.append(buf, 0, size);
        }
        return sb.toString();
    }
}
