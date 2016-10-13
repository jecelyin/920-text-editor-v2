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
import java.io.File;
import java.io.FileInputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

public class XML2JSON {
    public static void main(String[] args) {
        File f = new File(".");
        String path = f.getAbsolutePath();
        File syntax = new File(path, "app/src/main/assets/syntax");

        File[] files = syntax.listFiles(new FilenameFilter() {
            @Override
            public boolean accept(File file, String s) {
                return s.endsWith(".xml");
            }
        });

        try {
            for (File file : files) {
//                String xml = readFile(file);
//                JSONObject jsonObject = XML.toJSONObject(xml);
//                String jsonString = jsonObject.toString();
//                System.out.println("xml: " + file.getPath());

                o("File: %s", file.getName());
                parseXml(file);
                break;
            }
        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void o(String format, Object... args) {
        System.out.println(String.format(format, args));
    }

    private static void parseXml(final File file) throws Exception {
        DocumentBuilderFactory dbFactory
                = DocumentBuilderFactory.newInstance();
//        dbFactory.setValidating(false);
        DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
        dBuilder.setEntityResolver(new EntityResolver() {
            @Override
            public InputSource resolveEntity(String s, String systemId) throws SAXException, IOException {
                if (systemId.contains("xmode.dtd")) {
                    return new InputSource(new FileInputStream(new File(file.getParentFile().getParent(), "xmode.dtd")));
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
                JSONObject jsonObject = new JSONObject();
                parseNode((Element)item, jsonObject);
                o("json: %s", jsonObject.toString());
                break;
            }
        }
    }

    private static void parseNode(Element item, JSONObject jsonObject) {
//        o("  name: %s", item.getTagName());
        NamedNodeMap attributes = item.getAttributes();
        int length = attributes.getLength();
        JSONObject attrs = new JSONObject();
        for (int i = 0; i < length; i++) {
            Node node = attributes.item(i);
            attrs.put(node.getNodeName(), node.getNodeValue());
        }
        jsonObject.put("tag", item.getNodeName());
        if (attrs.length() > 0)
            jsonObject.put("attrs", attrs);

        List<JSONObject> childs = new ArrayList<>();

        NodeList childNodes = item.getChildNodes();
        length = childNodes.getLength();

        for (int i = 0; i < length; i++) {
            Node child = childNodes.item(i);

            short nodeType = child.getNodeType();
            if (nodeType == Node.ELEMENT_NODE) {
                JSONObject childObj = new JSONObject();
                parseNode((Element) child, childObj);
                childs.add(childObj);
            } else if (nodeType == Node.TEXT_NODE) {
                jsonObject.put("text", child.getTextContent().trim());
            }
        }
        if (!childs.isEmpty())
            jsonObject.put("child", childs);
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
