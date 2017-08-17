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

package com.jecelyin.editor.v2.ui;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class ModeList {
    public static class Mode {
        public final String name;
        public final String mode;

        public Mode(String name, String mode) {
            this.name = name;
            this.mode = mode;
        }
    }

    public static Mode[] modes = new Mode[] {
//BEGIN-REPLACE
        new Mode("ABAP", "ace/mode/abap"),
        new Mode("ABC", "ace/mode/abc"),
        new Mode("ActionScript", "ace/mode/actionscript"),
        new Mode("ADA", "ace/mode/ada"),
        new Mode("Apache Conf", "ace/mode/apache_conf"),
        new Mode("AsciiDoc", "ace/mode/asciidoc"),
        new Mode("Assembly x86", "ace/mode/assembly_x86"),
        new Mode("AutoHotKey", "ace/mode/autohotkey"),
        new Mode("BatchFile", "ace/mode/batchfile"),
        new Mode("Bro", "ace/mode/bro"),
        new Mode("C and C++", "ace/mode/c_cpp"),
        new Mode("C#", "ace/mode/csharp"),
        new Mode("C9Search", "ace/mode/c9search"),
        new Mode("Cirru", "ace/mode/cirru"),
        new Mode("Clojure", "ace/mode/clojure"),
        new Mode("Cobol", "ace/mode/cobol"),
        new Mode("CoffeeScript", "ace/mode/coffee"),
        new Mode("ColdFusion", "ace/mode/coldfusion"),
        new Mode("CSS", "ace/mode/css"),
        new Mode("Curly", "ace/mode/curly"),
        new Mode("D", "ace/mode/d"),
        new Mode("Dart", "ace/mode/dart"),
        new Mode("Diff", "ace/mode/diff"),
        new Mode("Django", "ace/mode/django"),
        new Mode("Dockerfile", "ace/mode/dockerfile"),
        new Mode("Dot", "ace/mode/dot"),
        new Mode("Drools", "ace/mode/drools"),
        new Mode("Dummy", "ace/mode/dummy"),
        new Mode("DummySyntax", "ace/mode/dummysyntax"),
        new Mode("Eiffel", "ace/mode/eiffel"),
        new Mode("EJS", "ace/mode/ejs"),
        new Mode("Elixir", "ace/mode/elixir"),
        new Mode("Elm", "ace/mode/elm"),
        new Mode("Erlang", "ace/mode/erlang"),
        new Mode("Forth", "ace/mode/forth"),
        new Mode("Fortran", "ace/mode/fortran"),
        new Mode("FreeMarker", "ace/mode/ftl"),
        new Mode("Gcode", "ace/mode/gcode"),
        new Mode("Gherkin", "ace/mode/gherkin"),
        new Mode("Gitignore", "ace/mode/gitignore"),
        new Mode("Glsl", "ace/mode/glsl"),
        new Mode("Go", "ace/mode/golang"),
        new Mode("Gobstones", "ace/mode/gobstones"),
        new Mode("GraphQLSchema", "ace/mode/graphqlschema"),
        new Mode("Groovy", "ace/mode/groovy"),
        new Mode("HAML", "ace/mode/haml"),
        new Mode("Handlebars", "ace/mode/handlebars"),
        new Mode("Haskell", "ace/mode/haskell"),
        new Mode("Haskell Cabal", "ace/mode/haskell_cabal"),
        new Mode("haXe", "ace/mode/haxe"),
        new Mode("Hjson", "ace/mode/hjson"),
        new Mode("HTML", "ace/mode/html"),
        new Mode("HTML (Elixir)", "ace/mode/html_elixir"),
        new Mode("HTML (Ruby)", "ace/mode/html_ruby"),
        new Mode("INI", "ace/mode/ini"),
        new Mode("Io", "ace/mode/io"),
        new Mode("Jack", "ace/mode/jack"),
        new Mode("Jade", "ace/mode/jade"),
        new Mode("Java", "ace/mode/java"),
        new Mode("JavaScript", "ace/mode/javascript"),
        new Mode("JSON", "ace/mode/json"),
        new Mode("JSONiq", "ace/mode/jsoniq"),
        new Mode("JSP", "ace/mode/jsp"),
        new Mode("JSX", "ace/mode/jsx"),
        new Mode("Julia", "ace/mode/julia"),
        new Mode("Kotlin", "ace/mode/kotlin"),
        new Mode("LaTeX", "ace/mode/latex"),
        new Mode("LESS", "ace/mode/less"),
        new Mode("Liquid", "ace/mode/liquid"),
        new Mode("Lisp", "ace/mode/lisp"),
        new Mode("LiveScript", "ace/mode/livescript"),
        new Mode("LogiQL", "ace/mode/logiql"),
        new Mode("LSL", "ace/mode/lsl"),
        new Mode("Lua", "ace/mode/lua"),
        new Mode("LuaPage", "ace/mode/luapage"),
        new Mode("Lucene", "ace/mode/lucene"),
        new Mode("Makefile", "ace/mode/makefile"),
        new Mode("Markdown", "ace/mode/markdown"),
        new Mode("Mask", "ace/mode/mask"),
        new Mode("MATLAB", "ace/mode/matlab"),
        new Mode("Maze", "ace/mode/maze"),
        new Mode("MEL", "ace/mode/mel"),
        new Mode("MUSHCode", "ace/mode/mushcode"),
        new Mode("MySQL", "ace/mode/mysql"),
        new Mode("Nix", "ace/mode/nix"),
        new Mode("NSIS", "ace/mode/nsis"),
        new Mode("Objective-C", "ace/mode/objectivec"),
        new Mode("OCaml", "ace/mode/ocaml"),
        new Mode("Pascal", "ace/mode/pascal"),
        new Mode("Perl", "ace/mode/perl"),
        new Mode("pgSQL", "ace/mode/pgsql"),
        new Mode("PHP", "ace/mode/php"),
        new Mode("Pig", "ace/mode/pig"),
        new Mode("Powershell", "ace/mode/powershell"),
        new Mode("Praat", "ace/mode/praat"),
        new Mode("Prolog", "ace/mode/prolog"),
        new Mode("Properties", "ace/mode/properties"),
        new Mode("Protobuf", "ace/mode/protobuf"),
        new Mode("Python", "ace/mode/python"),
        new Mode("R", "ace/mode/r"),
        new Mode("Razor", "ace/mode/razor"),
        new Mode("RDoc", "ace/mode/rdoc"),
        new Mode("RHTML", "ace/mode/rhtml"),
        new Mode("RST", "ace/mode/rst"),
        new Mode("Ruby", "ace/mode/ruby"),
        new Mode("Rust", "ace/mode/rust"),
        new Mode("SASS", "ace/mode/sass"),
        new Mode("SCAD", "ace/mode/scad"),
        new Mode("Scala", "ace/mode/scala"),
        new Mode("Scheme", "ace/mode/scheme"),
        new Mode("SCSS", "ace/mode/scss"),
        new Mode("Search", "ace/mode/search"),
        new Mode("ShellScript", "ace/mode/shellscript"),
        new Mode("SJS", "ace/mode/sjs"),
        new Mode("Smali", "ace/mode/smali"),
        new Mode("Smarty", "ace/mode/smarty"),
        new Mode("snippets", "ace/mode/snippets"),
        new Mode("Soy Template", "ace/mode/soy_template"),
        new Mode("Space", "ace/mode/space"),
        new Mode("SQL", "ace/mode/sql"),
        new Mode("SQLServer", "ace/mode/sqlserver"),
        new Mode("Stylus", "ace/mode/stylus"),
        new Mode("SVG", "ace/mode/svg"),
        new Mode("Swift", "ace/mode/swift"),
        new Mode("Tcl", "ace/mode/tcl"),
        new Mode("Tex", "ace/mode/tex"),
        new Mode("Text", "ace/mode/text"),
        new Mode("Textile", "ace/mode/textile"),
        new Mode("Toml", "ace/mode/toml"),
        new Mode("TSX", "ace/mode/tsx"),
        new Mode("Twig", "ace/mode/twig"),
        new Mode("Typescript", "ace/mode/typescript"),
        new Mode("Vala", "ace/mode/vala"),
        new Mode("VBScript", "ace/mode/vbscript"),
        new Mode("Velocity", "ace/mode/velocity"),
        new Mode("Verilog", "ace/mode/verilog"),
        new Mode("VHDL", "ace/mode/vhdl"),
        new Mode("Wollok", "ace/mode/wollok"),
        new Mode("XML", "ace/mode/xml"),
        new Mode("XQuery", "ace/mode/xquery"),
        new Mode("YAML", "ace/mode/yaml"),

//END-REPLACE
    };
}
