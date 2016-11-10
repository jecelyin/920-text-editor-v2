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
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;


public class XML2Java {
    private static File assetsPath;
    private static File highlightPath;
    private static File langPath;
    private static String langDefineTpl;
    private static String code;

    public static void main(String[] args) {
        File f = new File(".");
        String path = f.getAbsolutePath();

        highlightPath = new File(path, "app/src/main/java/com/jecelyin/editor/v2/highlight");
        assetsPath = new File(path, "tools/assets");
        File syntax = new File(assetsPath, "syntax");
        try {
            langDefineTpl = readFile(new File(assetsPath, "lang_define.tpl"));
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
                code = langDefineTpl;
                code = code.replace("@CLASS_NAME@", clsName);

                if (!item.getNodeName().equals("MODE"))
                    throw new RuntimeException("!MODE: " + item.getNodeName());

                handleMode((Element)item);

                mapCode.append("        map.put( \"")
                        .append(file.getName()).append("\", new ").append(clsName).append("() );\n");

                File langFile = new File(langPath, clsName + ".java");
                writeFile(langFile, code);
            }
        }
    }

    private static void handleMode(Element element) {
        NodeList childNodes = element.getChildNodes();
        int length = childNodes.getLength();

        StringBuilder sb = new StringBuilder();
        HashMap<String, Integer> countMap = new HashMap<>();
        HashMap<String, Integer> countMap2 = new HashMap<>();

        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }

            String clsName = item.getNodeName();
            Integer count = countMap2.get(clsName);
            if (count == null) {
                count = 0;
            }
            count = count + 1;
            countMap2.put(clsName, count);
            String tag = clsName + count.toString();

            sb.append(space(4)).append("private ").append(clsName).append(" ")
                    .append(tag).append("() {\n");
            handleChild(item, sb, countMap);

            sb.append(space(8)).append("return ").append(clsName).append("1;\n")
                    .append(space(4)).append("}\n\n");
            countMap.clear();
        }

        for (Map.Entry<String, Integer> entry : countMap2.entrySet()) {
            String tag = entry.getKey();
            sb.append(space(4)).append("public ").append(tag).append("[] ")
                    .append(tag).append("() {\n");
            sb.append(space(8)).append("return new ")
            .append(tag).append("[] {");
            int max = entry.getValue();
            for (int i = 1; i <= max; i++) {
                sb.append(tag).append(i).append("(), ");
            }
            sb.append("};\n");
            sb.append(space(4)).append("}\n\n");
        }

        code = code.replace("@BODY@", sb.toString());
    }

    private static String handleChild(Node node, StringBuilder sb, HashMap<String, Integer> countMap) {
        String tag = node.getNodeName();

        Integer count = countMap.get(tag);
        if (count == null) {
            count = 0;
        }
        count = count + 1;
        countMap.put(tag, count);

        String varName = tag + count.toString();

        sb.append(space(8)).append(tag).append(" ").append(varName)
                .append(" = new ").append(tag).append("();\n");

        StringBuilder text = new StringBuilder();
        List<Node> nodes = nodes(node, text);
        if (text.length() > 0) {
            sb.append(space(8)).append(varName).append(".text = ")
                    .append(textString(text.toString()))
                    .append(";\n");
        }

        for (Map.Entry<String, String> entry : attrs(node).entrySet()) {
            sb.append(space(8))
                    .append(varName).append(".")
                    .append(entry.getKey())
                    .append(" = ")
                    .append(textString(entry.getValue()))
                    .append(";\n");
        }
        sb.append("\r\r");

        HashMap<String, ArrayList<String>> childMap = new HashMap<>();
        HashMap<String, StringBuilder> keywords = new HashMap<>();

        for (Node child : nodes) {
            String name = child.getNodeName();
            if (tag.equals("KEYWORDS")) {
                if (!"SEQ".equals(name)) {
                    StringBuilder strings = keywords.get(name);
                    if (strings == null) {
                        strings = new StringBuilder();
                        keywords.put(name, strings);
                    }
                    strings.append(textString(child.getTextContent().toString().trim()))
                    .append(", ");
                }
                continue;
            }
            ArrayList<String> list = childMap.get(name);
            if (list == null) {
                list = new ArrayList<>();
                childMap.put(name, list);
            }
            list.add(handleChild(child, sb, countMap));
        }

        for (Map.Entry<String, StringBuilder> entry : keywords.entrySet()) {
            sb.append(space(8))
                    .append(varName).append(".add(").append(textString(entry.getKey()))
                    .append(", new String[]{")
                    .append(entry.getValue().toString())
                    .append("});\n");
        }
        for (Map.Entry<String, ArrayList<String>> entry : childMap.entrySet()) {

            sb.append(space(8))
                    .append(varName).append(".")
                    .append(entry.getKey())
                    .append(" = new ")
                    .append(entry.getKey())
                    .append("[] { ");
            for(String var : entry.getValue()) {
                sb.append(var).append(", ");
            }
            sb.append("};\n\n");
        }

        return varName;
    }

    private static List<Node> nodes(Node node, StringBuilder text) {
        NodeList childNodes = node.getChildNodes();
        int length = childNodes.getLength();

        List<Node> list = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            if (item.getNodeType() == Node.TEXT_NODE) {
                String str = item.getTextContent().toString().trim();
                if (str.isEmpty())
                    continue;
                text.append(str);
                continue;
            } else if (item.getNodeType() != Node.ELEMENT_NODE) {
                continue;
            }
            list.add(item);
        }

        return list;
    }

    private static HashMap<String, String> attrs(Node node) {
        HashMap<String, String> map = new HashMap<String, String>();

        NamedNodeMap childNodes = node.getAttributes();
        if (childNodes == null)
            return map;

        int length = childNodes.getLength();

        for (int i = 0; i < length; i++) {
            Node item = childNodes.item(i);
            map.put(item.getNodeName(), item.getNodeValue());
        }

        return map;
    }

    private static String space(int count) {
        return new String(new char[count]).replace("\0", " ");
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
