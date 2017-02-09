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

package com.jecelyin.editor.v2.highlight.jedit;

import java.util.HashMap;

public class Catalog {
    public static final String DEFAULT_MODE_NAME = "Text";
    public static final HashMap<String, Mode> map = new HashMap<>();

    static {
            map.put("ActionScript", new Mode("ActionScript", "actionscript.xml", "(?:.*[/\\\\])?.*\\.as", null));
            map.put("Ada", new Mode("Ada", "ada.xml", "(?:.*[/\\\\])?.*\\.(ada|adb|ads)", null));
            map.put("Ada95", new Mode("Ada95", "ada95.xml", null, null));
            //<MODE NAME="ahk" FILE="ahk.xml" FILE_NAME_GLOB="*.{ahk}"/>
            map.put("AutoHotkey", new Mode("AutoHotkey", "autohotkey.xml", "(?:.*[/\\\\])?.*\\.ahk", null));
            map.put("Ant", new Mode("Ant", "ant.xml", "(?:.*[/\\\\])?.*build\\.xml", ".*<project.*"));
            map.put("Antlr", new Mode("Antlr", "antlr.xml", "(?:.*[/\\\\])?.*\\.g", null));
            map.put("ApacheConf", new Mode("ApacheConf", "apacheconf.xml", "([/\\\\]etc[/\\\\]apache2[/\\\\](.*\\.conf|(conf\\.d|(mods|sites)-(available|enabled))[/\\\\].*)|.*httpd.*\\.conf)", null));
            map.put("Apdl", new Mode("Apdl", "apdl.xml", "(?:.*[/\\\\])?.*\\.(ans|inp|mak|mac)", null));
            map.put("AppleScript", new Mode("AppleScript", "applescript.xml", "(?:.*[/\\\\])?.*\\.applescript", null));
            map.put("ASP", new Mode("ASP", "asp.xml", "(?:.*[/\\\\])?.*\\.(asp|asa)", null));
            map.put("Aspect-j", new Mode("Aspect-j", "aspect_j.xml", "(?:.*[/\\\\])?.*\\.aj", null));
            map.put("Assembly-agc", new Mode("Assembly-agc", "assembly_agc.xml", "(?:.*[/\\\\])?.*\\.agc", null));
            map.put("Assembly-ags", new Mode("Assembly-ags", "assembly_ags.xml", "(?:.*[/\\\\])?.*\\.aea", null));
            map.put("Assembly-m68k", new Mode("Assembly-m68k", "assembly_m68k.xml", null, null));
            map.put("Assembly-macro32", new Mode("Assembly-macro32", "assembly_macro32.xml", "(?:.*[/\\\\])?.*\\.mar", null));
            map.put("Assembly-mcs51", new Mode("Assembly-mcs51", "assembly_mcs51.xml", null, null));
            map.put("Assembly-r2000", new Mode("Assembly-r2000", "assembly_r2000.xml", "(?:.*[/\\\\])?.*\\.mips", null));
            map.put("Assembly-parrot", new Mode("Assembly-parrot", "assembly_parrot.xml", "(?:.*[/\\\\])?.*\\.pasm", null));
            map.put("Assembly-x86", new Mode("Assembly-x86", "assembly_x86.xml", "(?:.*[/\\\\])?.*\\.asm", null));
            map.put("Avro", new Mode("Avro", "avro.xml", "(?:.*[/\\\\])?.*\\.avdl", null));
            map.put("AWK", new Mode("AWK", "awk.xml", "(?:.*[/\\\\])?.*\\.awk", "#!.*awk.*"));
            map.put("B", new Mode("B", "b.xml", "(?:.*[/\\\\])?.*\\.(imp|ref|mch)", null));
            map.put("Batch", new Mode("Batch", "batch.xml", "(?:.*[/\\\\])?.*\\.(bat|cmd)", null));
            map.put("Bbj", new Mode("Bbj", "bbj.xml", "(?:.*[/\\\\])?.*\\.bbj", null));
            map.put("Bcel", new Mode("Bcel", "bcel.xml", null, null));
            map.put("BeanShell", new Mode("BeanShell", "java.xml", "(?:.*[/\\\\])?.*\\.bsh", null));
            map.put("Bibtex", new Mode("Bibtex", "bibtex.xml", "(?:.*[/\\\\])?.*\\.bib", null));
            map.put("Binsource-agc", new Mode("Binsource-agc", "binsource_agc.xml", "(?:.*[/\\\\])?.*\\.binsource", null));
            map.put("C", new Mode("C", "c.xml", "(?:.*[/\\\\])?.*\\.c", null));
            map.put("CFScript", new Mode("CFScript", "cfscript.xml", "(?:.*[/\\\\])?.*\\.cfc", null));
            map.put("Chill", new Mode("Chill", "chill.xml", "(?:.*[/\\\\])?.*\\.(chl|mpol)", null));
            map.put("Cil", new Mode("Cil", "cil.xml", "(?:.*[/\\\\])?.*\\.il", null));
            map.put("Clips", new Mode("Clips", "clips.xml", "(?:.*[/\\\\])?.*\\.clp", null));
            map.put("Clojure", new Mode("Clojure", "clojure.xml", "(?:.*[/\\\\])?.*\\.clj", null));
            map.put("CMake", new Mode("CMake", "cmake.xml", "(?:.*[/\\\\])?CMakeLists\\.txt", null));
            map.put("Cobol", new Mode("Cobol", "cobol.xml", "(?:.*[/\\\\])?.*\\.(cbl|cob)", null));
            map.put("CoffeeScript", new Mode("CoffeeScript", "coffeescript.xml", "(?:.*[/\\\\])?.*\\.coffee", null));
            map.put("ColdFusion", new Mode("ColdFusion", "coldfusion.xml", "(?:.*[/\\\\])?.*\\.(cfm|dbm|cfc)", null));
            map.put("Cplex-lp", new Mode("Cplex-lp", "cplexlp.xml", "(?:.*[/\\\\])?.*\\.lp", null));
            map.put("C++", new Mode("C++", "cplusplus.xml", "(?:.*[/\\\\])?.*\\.(cc|cpp|h|hh|hpp|cxx)", null));
            map.put("C#", new Mode("C#", "csharp.xml", "(?:.*[/\\\\])?.*\\.cs", null));
            map.put("CSS", new Mode("CSS", "css.xml", "(?:.*[/\\\\])?.*\\.css", null));
            map.put("CSV", new Mode("CSV", "csv.xml", "(?:.*[/\\\\])?.*\\.csv", null));
            map.put("CVS-commit", new Mode("CVS-commit", "cvs_commit.xml", "(?:.*[/\\\\])?cvs.*\\.tmp", null));
            map.put("D", new Mode("D", "d.xml", "(?:.*[/\\\\])?.*\\.d", null));
            map.put("Dart", new Mode("Dart", "dart.xml", "(?:.*[/\\\\])?.*\\.dart", null));
            map.put("Django", new Mode("Django", "django.xml", null, null));
            map.put("Dot", new Mode("Dot", "dot.xml", "(?:.*[/\\\\])?.*\\.dot", null));
            map.put("Doxygen", new Mode("Doxygen", "doxygen.xml", "(?:.*[/\\\\])?doxyfile.*", null));
            map.put("Dsssl", new Mode("Dsssl", "dsssl.xml", "(?:.*[/\\\\])?.*\\.dsl", null));
            map.put("Embperl", new Mode("Embperl", "embperl.xml", "(?:.*[/\\\\])?.*\\.epl", null));
            map.put("Erlang", new Mode("Erlang", "erlang.xml", "(?:.*[/\\\\])?.*\\.(erl|hrl)", null));
            map.put("Eiffel", new Mode("Eiffel", "eiffel.xml", "(?:.*[/\\\\])?.*\\.e", null));
            map.put("Fhtml", new Mode("Fhtml", "fhtml.xml", "(?:.*[/\\\\])?.*\\.(furnace|fhtml)", null));
            map.put("Factor", new Mode("Factor", "factor.xml", "(?:.*[/\\\\])?.*\\.factor", null));
            map.put("Jflex", new Mode("Jflex", "jflex.xml", "(?:.*[/\\\\])?.*\\.flex", null));
            map.put("Forth", new Mode("Forth", "forth.xml", "(?:.*[/\\\\])?.*\\.f", null));
            map.put("Fortran", new Mode("Fortran", "fortran.xml", "(?:.*[/\\\\])?.*\\.(for|fort|f77)", null));
            map.put("Fortran90", new Mode("Fortran90", "fortran90.xml", "(?:.*[/\\\\])?.*\\.(f90|f95|f03)", null));
            map.put("FoxPro", new Mode("FoxPro", "foxpro.xml", "(?:.*[/\\\\])?.*\\.prg", null));
            map.put("FreeMarker", new Mode("FreeMarker", "freemarker.xml", "(?:.*[/\\\\])?.*\\.ftl", "<\\#ftl.*"));
            map.put("GCBasic", new Mode("GCBasic", "gcbasic.xml", "(?:.*[/\\\\])?.*\\.(gc|gcb)", "(.*GCBASIC.*|.*Great Cow BASIC.*)"));
            map.put("GetText", new Mode("GetText", "gettext.xml", "(?:.*[/\\\\])?.*\\.(po|pot)", null));
            map.put("GNUPlot", new Mode("GNUPlot", "gnuplot.xml", "(?:.*[/\\\\])?.*\\.(dem|plt)", null));
            map.put("Go", new Mode("Go", "go.xml", "(?:.*[/\\\\])?.*\\.go", null));
            map.put("Gradle", new Mode("Gradle", "gradle.xml", "(?:.*[/\\\\])?.*\\.(gradle)", null));
            map.put("Groovy", new Mode("Groovy", "groovy.xml", "(?:.*[/\\\\])?.*\\.(gant|groovy|grv)", null));
            map.put("GSP", new Mode("GSP", "jsp.xml", "(?:.*[/\\\\])?.*\\.(gsp)", null));
            map.put("Haskell", new Mode("Haskell", "haskell.xml", "(?:.*[/\\\\])?.*\\.hs", null));
            map.put("Haxe", new Mode("Haxe", "haxe.xml", "(?:.*[/\\\\])?.*\\.hx", null));
            map.put("Hxml", new Mode("Hxml", "hxml.xml", "(?:.*[/\\\\])?.*\\.hxml", null));
            map.put("Hex", new Mode("Hex", "hex.xml", null, null));
            map.put("Hlsl", new Mode("Hlsl", "hlsl.xml", "(?:.*[/\\\\])?.*\\.fx", null));
            map.put(".htaccess", new Mode(".htaccess", "htaccess.xml", "(?:.*[/\\\\])?\\.htaccess", null));
            map.put("Html", new Mode("Html", "html.xml", "(?:.*[/\\\\])?.*\\.(html|htm|hta)", null));
            map.put("I4gl", new Mode("I4gl", "i4gl.xml", "(?:.*[/\\\\])?.*\\.4gl", null));
            map.put("Icalendar", new Mode("Icalendar", "ical.xml", "(?:.*[/\\\\])?.*\\.ics", null));
            map.put("Icon", new Mode("Icon", "icon.xml", "(?:.*[/\\\\])?.*\\.icn", null));
            map.put("Idl", new Mode("Idl", "idl.xml", "(?:.*[/\\\\])?.*\\.idl", null));
            map.put("Inform", new Mode("Inform", "inform.xml", "(?:.*[/\\\\])?.*\\.inf", null));
            map.put("Inno-setup", new Mode("Inno-setup", "inno_setup.xml", "(?:.*[/\\\\])?.*\\.iss", null));
            map.put("Ini", new Mode("Ini", "ini.xml", "(?:.*[/\\\\])?.*\\.(ini|reg|milk)", null));
            map.put("Interlis", new Mode("Interlis", "interlis.xml", "(?:.*[/\\\\])?.*\\.ili", null));
            map.put("Io", new Mode("Io", "io.xml", "(?:.*[/\\\\])?.*\\.io", null));
            map.put("Jamon", new Mode("Jamon", "jamon.xml", "(?:.*[/\\\\])?.*\\.jamon", null));
            map.put("JavaCC", new Mode("JavaCC", "javacc.xml", "(?:.*[/\\\\])?.*\\.(jj|jjt)", null));
            map.put("Java", new Mode("Java", "java.xml", "(?:.*[/\\\\])?.*\\.java", null));
            map.put("JavaFX", new Mode("JavaFX", "javafx.xml", "(?:.*[/\\\\])?.*\\.fx", null));
            map.put("JavaScript", new Mode("JavaScript", "javascript.xml", "(?:.*[/\\\\])?(.*\\.js|Buildsub)", null));
            map.put("Jcl", new Mode("Jcl", "jcl.xml", "(?:.*[/\\\\])?.*\\.jcl", null));
            map.put("Jedit-Actions", new Mode("Jedit-Actions", "jedit_actions.xml", "(?:.*[/\\\\])?actions\\.xml", null));
            map.put("Jhtml", new Mode("Jhtml", "jhtml.xml", "(?:.*[/\\\\])?.*\\.jhtml", null));
            map.put("Jmk", new Mode("Jmk", "jmk.xml", "(?:.*[/\\\\])?.*\\.jmk", null));
            map.put("JSON", new Mode("JSON", "json.xml", "(?:.*[/\\\\])?.*\\.json", null));
            map.put("JSP", new Mode("JSP", "jsp.xml", "(?:.*[/\\\\])?.*\\.(jsp|jsf|jspf|tag)", null));
            map.put("Kotlin", new Mode("Kotlin", "kotlin.xml", "(?:.*[/\\\\])?.*\\.(kt)", null));
            map.put("Latex", new Mode("Latex", "latex.xml", "(?:.*[/\\\\])?.*\\.(tex|sty|ltx)", null));
            map.put("Lex", new Mode("Lex", "lex.xml", "(?:.*[/\\\\])?.*\\.l", null));
            map.put("Lilypond", new Mode("Lilypond", "lilypond.xml", "(?:.*[/\\\\])?.*\\.(ly|ily)", null));
            map.put("Lisp", new Mode("Lisp", "lisp.xml", "(?:.*[/\\\\])?.*\\.(lisp|lsp|el)", null));
            map.put("Literate-haskell", new Mode("Literate-haskell", "literate_haskell.xml", "(?:.*[/\\\\])?.*\\.lhs", null));
            map.put("Logs", new Mode("Logs", "logs.xml", "(?:.*[/\\\\])?.*\\.log", null));
            map.put("Logtalk", new Mode("Logtalk", "logtalk.xml", "(?:.*[/\\\\])?.*\\.lgt", null));
            map.put("Lotos", new Mode("Lotos", "lotos.xml", "(?:.*[/\\\\])?.*\\.(lot|lotos)", null));
            map.put("Lua", new Mode("Lua", "lua.xml", "(?:.*[/\\\\])?.*\\.lua", null));
            map.put("MacroScheduler", new Mode("MacroScheduler", "macroscheduler.xml", "(?:.*[/\\\\])?.*\\.scp", null));
            map.put("Mail", new Mode("Mail", "mail.xml", null, null));
            map.put("Makefile", new Mode("Makefile", "makefile.xml", "(?:.*[/\\\\])?.*makefile", null));
            map.put("Maple", new Mode("Maple", "maple.xml", "(?:.*[/\\\\])?.*\\.(mpl|mws)", null));
            map.put("Markdown", new Mode("Markdown", "markdown.xml", "(?:.*[/\\\\])?.*\\.(md|markdown)", null));
            map.put("Maven", new Mode("Maven", "maven.xml", "(?:.*[/\\\\])?pom\\.xml", null));
            map.put("Metapost", new Mode("Metapost", "mpost.xml", "(?:.*[/\\\\])?.*\\.mp", null));
            map.put("Mxml", new Mode("Mxml", "mxml.xml", "(?:.*[/\\\\])?.*\\.mxml", null));
            map.put("Ml", new Mode("Ml", "ml.xml", "(?:.*[/\\\\])?.*\\.(sml|ml)", null));
            map.put("Modula3", new Mode("Modula3", "modula3.xml", "(?:.*[/\\\\])?.*\\.[im]3", null));
            map.put("Moin", new Mode("Moin", "moin.xml", "(?:.*[/\\\\])?.*\\.moin", null));
            map.put("Mqsc", new Mode("Mqsc", "mqsc.xml", "(?:.*[/\\\\])?.*\\.mqsc", null));
            map.put("Myghty", new Mode("Myghty", "myghty.xml", "(?:.*[/\\\\])?(autohandler|dhandler|.*\\.myt)", null));
            map.put("MySQL", new Mode("MySQL", "mysql.xml", null, null));
            map.put("N3", new Mode("N3", "n3.xml", "(?:.*[/\\\\])?.*\\.n3", null));
            map.put("Netrexx", new Mode("Netrexx", "netrexx.xml", "(?:.*[/\\\\])?.*\\.nrx", null));
            map.put("Nqc", new Mode("Nqc", "nqc.xml", "(?:.*[/\\\\])?.*\\.nqc", null));
            map.put("Nsis2", new Mode("Nsis2", "nsis2.xml", "(?:.*[/\\\\])?.*\\.(nsi|nsh)", null));
            map.put("Objective-C", new Mode("Objective-C", "objective_c.xml", "(?:.*[/\\\\])?.*\\.(objc|m|mm)", null));
            map.put("Objectrexx", new Mode("Objectrexx", "objectrexx.xml", "(?:.*[/\\\\])?.*\\.(rex|orx)", null));
            map.put("Occam", new Mode("Occam", "occam.xml", "(?:.*[/\\\\])?.*\\.icc", null));
            map.put("Omnimark", new Mode("Omnimark", "omnimark.xml", "(?:.*[/\\\\])?.*\\.x(om|in)", null));
            map.put("Outline", new Mode("Outline", "outline.xml", "(?:.*[/\\\\])?.*\\.(outline)", null));
            map.put("Pascal", new Mode("Pascal", "pascal.xml", "(?:.*[/\\\\])?.*\\.(pas|dpr|dpk)", null));
            map.put("Patch", new Mode("Patch", "patch.xml", "(?:.*[/\\\\])?.*\\.(diff|patch)", "(# HG changeset patch|diff --git .*)"));
            map.put("Perl", new Mode("Perl", "perl.xml", "(?:.*[/\\\\])?.*\\.p([lmh]|od)", "#!/.*perl.*"));
            map.put("PHP", new Mode("PHP", "php.xml", "(?:.*[/\\\\])?.*\\.(php3|php4|php|phtml|inc)", "(<\\?php.*|#!/.*php.*)"));
            map.put("Pike", new Mode("Pike", "pike.xml", "(?:.*[/\\\\])?.*\\.(pike|pmod)", null));
            map.put("Plaintex", new Mode("Plaintex", "plaintex.xml", null, null));
            map.put("PostgreSQL", new Mode("PostgreSQL", "pg_sql.xml", "(?:.*[/\\\\])?.*\\.(pg_sql|pg-sql)", null));
            map.put("PowerCenter Parameter File", new Mode("PowerCenter Parameter File", "powercenter_parameter_file.xml", "(?:.*[/\\\\])?.*\\.par", null));
            map.put("Pl-sql", new Mode("Pl-sql", "osql.xml", "(?:.*[/\\\\])?.*\\.(pls|sql)", null));
            map.put("Pl-sql9", new Mode("Pl-sql9", "pl_sql.xml", null, null));
            map.put("Pl1", new Mode("Pl1", "pl1.xml", "(?:.*[/\\\\])?.*\\.pl[i1]", null));
            map.put("Pop11", new Mode("Pop11", "pop11.xml", "(?:.*[/\\\\])?.*\\.(p|pop11|p11)", null));
            map.put("PostScript", new Mode("PostScript", "postscript.xml", "(?:.*[/\\\\])?.*\\.(ps|eps)", null));
            map.put("Povray", new Mode("Povray", "povray.xml", "(?:.*[/\\\\])?.*\\.(pov|povray)", null));
            map.put("PowerDynamo", new Mode("PowerDynamo", "powerdynamo.xml", "(?:.*[/\\\\])?.*\\.(ssc|stm)", null));
            map.put("PowerShell", new Mode("PowerShell", "powershell.xml", "(?:.*[/\\\\])?.*\\.(ps1|psm1|psd1)", null));
            map.put("Prolog", new Mode("Prolog", "prolog.xml", "(?:.*[/\\\\])?.*\\.pro", null));
            map.put("Progress", new Mode("Progress", "progress.xml", "(?:.*[/\\\\])?.*\\.[piw]", null));
            map.put("Properties", new Mode("Properties", "props.xml", "(?:.*[/\\\\])?.*(properties|props)", null));
            map.put("Psp", new Mode("Psp", "psp.xml", "(?:.*[/\\\\])?.*\\.psp", null));
            map.put("Ptl", new Mode("Ptl", "ptl.xml", "(?:.*[/\\\\])?.*\\.ptl", null));
            map.put("Pure", new Mode("Pure", "pure.xml", "(?:.*[/\\\\])?.*\\.pure", "#!.*/.*pure"));
            map.put("Pvwave", new Mode("Pvwave", "pvwave.xml", "(?:.*[/\\\\])?.*\\.jou", null));
            map.put("Pyrex", new Mode("Pyrex", "pyrex.xml", "(?:.*[/\\\\])?.*\\.(pyx)", null));
            map.put("Python", new Mode("Python", "python.xml", "(?:.*[/\\\\])?.*\\.(py|pyw|sc|jy)", "#!.*/.*python.*"));
            map.put("R", new Mode("R", "r.xml", "(?:.*[/\\\\])?.*\\.r", null));
            map.put("Rebol", new Mode("Rebol", "rebol.xml", "(?:.*[/\\\\])?.*\\.rebol", null));
            map.put("Redcode", new Mode("Redcode", "redcode.xml", "(?:.*[/\\\\])?.*\\.(red|rc)", null));
            map.put("Relax-ng-compact", new Mode("Relax-ng-compact", "relax_ng_compact.xml", "(?:.*[/\\\\])?.*\\.rnc", null));
            map.put("Renderman-rib", new Mode("Renderman-rib", "rib.xml", "(?:.*[/\\\\])?.*\\.rib", null));
            map.put("Rd", new Mode("Rd", "rd.xml", "(?:.*[/\\\\])?.*\\.rd", null));
            map.put("Rest", new Mode("Rest", "rest.xml", "(?:.*[/\\\\])?.*\\.(rst|rest)", "(===|~~~).*"));
            map.put("Rhtml", new Mode("Rhtml", "rhtml.xml", "(?:.*[/\\\\])?.*\\.(rhtml|html\\.erb)", null));
            map.put("Roff", new Mode("Roff", "roff.xml", "(?:.*[/\\\\])?.*\\.(1|2|3|4|5|6|7|8|9|me|ms|mom|tmac)", null));
            map.put("Rpm-spec", new Mode("Rpm-spec", "rpmspec.xml", "(?:.*[/\\\\])?.*\\.spec", null));
            map.put("Rtf", new Mode("Rtf", "rtf.xml", "(?:.*[/\\\\])?.*\\.rtf", null));
            map.put("Rakefile", new Mode("Rakefile", "ruby.xml", "(?:.*[/\\\\])?.*Rakefile", null));
            map.put("Ruby", new Mode("Ruby", "ruby.xml", "(?:.*[/\\\\])?.*\\.(rb|rbw)", "#!.*/.*ruby.*"));
            map.put("Rust", new Mode("Rust", "rubst.xml", "(?:.*[/\\\\])?.*\\.(rbs)", null));
            map.put("Rview", new Mode("Rview", "rview.xml", "(?:.*[/\\\\])?.*\\.rvw", null));
            map.put("S+", new Mode("S+", "splus.xml", "(?:.*[/\\\\])?.*\\.ssc", null));
            map.put("S#", new Mode("S#", "ssharp.xml", "(?:.*[/\\\\])?.*\\.(ss|ssc|ssi|ssw|sts|aml)", null));
            map.put("Sas", new Mode("Sas", "sas.xml", "(?:.*[/\\\\])?.*\\.sas", null));
            map.put("Sbt", new Mode("Sbt", "scala.xml", "(?:.*[/\\\\])?.*\\.sbt", null));
            map.put("Scala", new Mode("Scala", "scala.xml", "(?:.*[/\\\\])?.*\\.scala", null));
            map.put("Scheme", new Mode("Scheme", "scheme.xml", "(?:.*[/\\\\])?.*\\.scm", null));
            map.put("Sgml", new Mode("Sgml", "sgml.xml", "(?:.*[/\\\\])?.*\\.(sgml|sgm|dtd)", null));
            map.put("Sip", new Mode("Sip", "sip.xml", null, null));
            map.put("Rcp", new Mode("Rcp", "rcp.xml", "(?:.*[/\\\\])?.*\\.rcp", null));
            map.put("ShellScript", new Mode("ShellScript", "shellscript.xml", "(?:.*[/\\\\])?.*\\.(csh|sh|bash|login|profile|bashrc|bash_profile)", "#!/.*sh.*"));
            map.put("SHTML", new Mode("SHTML", "shtml.xml", "(?:.*[/\\\\])?.*\\.(shtml|shtm|ssi)", null));
            map.put("Slate", new Mode("Slate", "slate.xml", "(?:.*[/\\\\])?.*\\.slate", null));
            map.put("Slax", new Mode("Slax", "slax.xml", "(?:.*[/\\\\])?.*\\.slax", null));
            map.put("Smalltalk", new Mode("Smalltalk", "smalltalk.xml", "(?:.*[/\\\\])?.*\\.(st|sources|changes)", null));
            map.put("Smarty", new Mode("Smarty", "smarty.xml", "(?:.*[/\\\\])?.*\\.tpl", null));
            map.put("Sdl/pr", new Mode("Sdl/pr", "sdl_pr.xml", "(?:.*[/\\\\])?.*\\.pr", null));
            map.put("Sql-loader", new Mode("Sql-loader", "sql_loader.xml", "(?:.*[/\\\\])?.*\\.ctl", null));
            map.put("Smi-mib", new Mode("Smi-mib", "smi_mib.xml", "(?:.*[/\\\\])?.*(\\.mib|-MIB\\.txt)", null));
            map.put("Sqr", new Mode("Sqr", "sqr.xml", "(?:.*[/\\\\])?.*\\.(sqr|sqc)", null));
            map.put("Squidconf", new Mode("Squidconf", "squidconf.xml", "(?:.*[/\\\\])?squid\\.conf", null));
            map.put("Stata", new Mode("Stata", "stata.xml", "(?:.*[/\\\\])?.*\\.(do|ado|mata)", null));
            map.put("Svn-commit", new Mode("Svn-commit", "svn_commit.xml", "(?:.*[/\\\\])?svn-commit.*\\.tmp", null));
            map.put("Swig", new Mode("Swig", "swig.xml", "(?:.*[/\\\\])?.*\\.(i|swg)", null));
            map.put("Tcl", new Mode("Tcl", "tcl.xml", "(?:.*[/\\\\])?.*\\.(tcl|tsh)", null));
            map.put("Texinfo", new Mode("Texinfo", "texinfo.xml", "(?:.*[/\\\\])?.*\\.texi", null));
            map.put("Tex", new Mode("Tex", "tex.xml", null, null));
            map.put("Text", new Mode("Text", "text.xml", "(?:.*[/\\\\])?.*\\.txt", null));
            map.put("Rfc", new Mode("Rfc", "rfc.xml", "(?:.*[/\\\\])?rfc.*\\.txt", null));
            map.put("Tld", new Mode("Tld", "tld.xml", "(?:.*[/\\\\])?.*\\.tld", null));
            map.put("Tsp", new Mode("Tsp", "tsp.xml", "(?:.*[/\\\\])?.*\\.tsp", null));
            map.put("Transact-sql", new Mode("Transact-sql", "tsql.xml", null, null));
            map.put("Template-toolkit", new Mode("Template-toolkit", "tthtml.xml", "(?:.*[/\\\\])?.*\\.tt(html|css|js)", null));
            map.put("Twiki", new Mode("Twiki", "twiki.xml", "(?:.*[/\\\\])?.*\\.twiki", null));
            map.put("Typoscript", new Mode("Typoscript", "typoscript.xml", "(?:.*[/\\\\])?.*\\.ts", null));
            map.put("Url", new Mode("Url", "url.xml", "(?:.*[/\\\\])?.*\\.url", null));
            map.put("Uscript", new Mode("Uscript", "uscript.xml", "(?:.*[/\\\\])?.*\\.uc", null));
            map.put("Vala", new Mode("Vala", "vala.xml", "(?:.*[/\\\\])?.*\\.vala", null));
            map.put("Vbscript", new Mode("Vbscript", "vbscript.xml", "(?:.*[/\\\\])?.*\\.(vbs|bas|cls)", null));
            map.put("Velocity", new Mode("Velocity", "velocity_pure.xml", "(?:.*[/\\\\])?.*\\.vm", null));
            map.put("Verilog", new Mode("Verilog", "verilog.xml", "(?:.*[/\\\\])?.*\\.(ver|v|sv)", null));
            map.put("Vhdl", new Mode("Vhdl", "vhdl.xml", "(?:.*[/\\\\])?.*\\.vh.*", null));
            map.put("Visualbasic", new Mode("Visualbasic", "visualbasic.xml", "(?:.*[/\\\\])?.*\\.(vb)", null));
            map.put("Vrml2", new Mode("Vrml2", "vrml2.xml", "(?:.*[/\\\\])?.*\\.(wrl|wrz)", null));
            map.put("Xml", new Mode("Xml", "xml.xml", "(?:.*[/\\\\])?.*\\.(xml|xhtml|xsd|qrc|ui|docbook)", "<\\?xml.*"));
            map.put("Xq", new Mode("Xq", "xq.xml", "(?:.*[/\\\\])?.*\\.x(q|qm|ql)", null));
            map.put("Xsl", new Mode("Xsl", "xsl.xml", "(?:.*[/\\\\])?.*\\.xsl", null));
            map.put("Yab", new Mode("Yab", "yab.xml", "(?:.*[/\\\\])?.*\\.yab", null));
            map.put("Yaml", new Mode("Yaml", "yaml.xml", "(?:.*[/\\\\])?.*\\.(yml|yaml)", null));
            map.put("Zpt", new Mode("Zpt", "zpt.xml", "(?:.*[/\\\\])?.*\\.(pt|zpt)", null));

    }

    public static Mode getModeByName(String name) {
        return map.get(name);
    }
}
