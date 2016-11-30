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

import java.io.File;

import static com.jecelyin.editor.v2.tools.Tool.*;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */

public class ConvertCatalog {

    public static void main(String[] args) {
        File f = new File(".");
        String path = f.getAbsolutePath();

        File highlightPath = new File(path, "app/src/main/java/com/jecelyin/editor/v2/highlight");
        File assetsPath = new File(path, "tools/assets");
        File jedit = new File(highlightPath, "jedit");

        StringBuilder mapCode = new StringBuilder();

        for (Mode mode : modes) {
            mapCode.append(space(12)).append("map.put(")
                    .append(textString(mode.name)).append(", ")
                    .append("new Mode(")
                    .append(textString(mode.name)).append(", ")
                    .append(textString(mode.file)).append(", ");

            if (mode.fileNameGlob == null || mode.fileNameGlob.isEmpty()) {
                mapCode.append("null, ");
            } else {
                // translate glob to regex
                String filepathRE = globToRE(mode.fileNameGlob);
                // if glob includes a path separator (both are supported as
                // users can supply them in the GUI and thus will copy
                // Windows paths in there)
                if (filepathRE.contains("/") || filepathRE.contains("\\\\")) {
                    // replace path separators by both separator possibilities in the regex
                    filepathRE = filepathRE.replaceAll("/|\\\\\\\\", "[/\\\\\\\\]");
                } else {
                    // glob is for a filename without path, prepend the regex with
                    // an optional path prefix to be able to match against full paths
                    filepathRE = String.format("(?:.*[/\\\\])?%s", filepathRE);
                }
                mapCode.append(textString(filepathRE)).append(", ");
            }
            if (mode.firstLineGlob == null || mode.firstLineGlob.isEmpty()) {
                mapCode.append("null");
            } else {
                mapCode.append(textString(globToRE(mode.firstLineGlob)));
            }
            mapCode.append("));\n");
        }
        try {
            String code = readFile(new File(assetsPath, "catalog.tpl"));
            code = code.replace("@MAP@", mapCode.toString());
            writeFile(new File(jedit, "Catalog.java"), code);
        }catch (Exception e) {
            e.printStackTrace();
        }

    }

    static class Mode {
        private final String fileNameGlob;
        private final String firstLineGlob;
        private final String name;
        private final String file;

        public Mode(String name, String syntaxFilename, String fileNameGlob, String firstLineGlob) {
            this.fileNameGlob = fileNameGlob;
            this.firstLineGlob = firstLineGlob;
            this.name = name;
            this.file = syntaxFilename;
        }
    }
    public static Mode[] modes = new Mode[]{
            new Mode("ActionScript"      , "actionscript.xml"            , "*.as"                        , null),
            new Mode("Ada"               , "ada.xml"                     , "*.{ada,adb,ads}"             , null),
            new Mode("Ada95"             , "ada95.xml"                   , null                          , null),
            new Mode("Ant"               , "ant.xml"                     , "*build.xml"                  , "*<project*"),
            new Mode("Antlr"             , "antlr.xml"                   , "*.g"                         , null),
            new Mode("ApacheConf"        , "apacheconf.xml"              , "{/etc/apache2/{*.conf,{conf.d,{mods,sites}-{available,enabled}}/*},*httpd*.conf}", null),
            new Mode("Apdl"              , "apdl.xml"                    , "*.{ans,inp,mak,mac}"         , null),
            new Mode("AppleScript"       , "applescript.xml"             , "*.applescript"               , null),
            new Mode("ASP"               , "asp.xml"                     , "*.{asp,asa}"                 , null),
            new Mode("Aspect-j"          , "aspect_j.xml"                , "*.aj"                        , null),
            new Mode("Assembly-agc"      , "assembly_agc.xml"            , "*.agc"                       , null),
            new Mode("Assembly-ags"      , "assembly_ags.xml"            , "*.aea"                       , null),
            new Mode("Assembly-m68k"     , "assembly_m68k.xml"           , null                          , null),
            new Mode("Assembly-macro32"  , "assembly_macro32.xml"        , "*.mar"                       , null),
            new Mode("Assembly-mcs51"    , "assembly_mcs51.xml"          , null                          , null),
            new Mode("Assembly-r2000"    , "assembly_r2000.xml"          , "*.mips"                      , null),
            new Mode("Assembly-parrot"   , "assembly_parrot.xml"         , "*.pasm"                      , null),
            new Mode("Assembly-x86"      , "assembly_x86.xml"            , "*.asm"                       , null),
            new Mode("Avro"              , "avro.xml"                    , "*.avdl"                      , null),
            new Mode("AWK"               , "awk.xml"                     , "*.awk"                       , "#!*awk*"),
            new Mode("B"                 , "b.xml"                       , "*.{imp,ref,mch}"             , null),
            new Mode("Batch"             , "batch.xml"                   , "*.{bat,cmd}"                 , null),
            new Mode("Bbj"               , "bbj.xml"                     , "*.bbj"                       , null),
            new Mode("Bcel"              , "bcel.xml"                    , null                          , null),
            new Mode("BeanShell"         , "java.xml"                    , "*.bsh"                       , null),
            new Mode("Bibtex"            , "bibtex.xml"                  , "*.bib"                       , null),
            new Mode("Binsource-agc"     , "binsource_agc.xml"           , "*.binsource"                 , null),
            new Mode("C"                 , "c.xml"                       , "*.c"                         , null),
            new Mode("CFScript"          , "cfscript.xml"                , "*.cfc"                       , null),
            new Mode("Chill"             , "chill.xml"                   , "*.{chl,mpol}"                , null),
            new Mode("Cil"               , "cil.xml"                     , "*.il"                        , null),
            new Mode("Clips"             , "clips.xml"                   , "*.clp"                       , null),
            new Mode("Clojure"           , "clojure.xml"                 , "*.clj"                       , null),
            new Mode("CMake"             , "cmake.xml"                   , "CMakeLists.txt"              , null),
            new Mode("Cobol"             , "cobol.xml"                   , "*.{cbl,cob}"                 , null),
            new Mode("CoffeeScript"      , "coffeescript.xml"            , "*.coffee"                    , null),
            new Mode("ColdFusion"        , "coldfusion.xml"              , "*.{cfm,dbm,cfc}"             , null),
            new Mode("Cplex-lp"          , "cplexlp.xml"                 , "*.lp"                        , null),
            new Mode("C++"               , "cplusplus.xml"               , "*.{cc,cpp,h,hh,hpp,cxx}"     , null),
            new Mode("C#"                , "csharp.xml"                  , "*.cs"                        , null),
            new Mode("CSS"               , "css.xml"                     , "*.css"                       , null),
            new Mode("CSV"               , "csv.xml"                     , "*.csv"                       , null),
            new Mode("CVS-commit"        , "cvs_commit.xml"              , "cvs*.tmp"                    , null),
            new Mode("D"                 , "d.xml"                       , "*.d"                         , null),
            new Mode("Dart"              , "dart.xml"                    , "*.dart"                      , null),
            new Mode("Django"            , "django.xml"                  , null                          , null),
            new Mode("Dot"               , "dot.xml"                     , "*.dot"                       , null),
            new Mode("Doxygen"           , "doxygen.xml"                 , "doxyfile*"                   , null),
            new Mode("Dsssl"             , "dsssl.xml"                   , "*.dsl"                       , null),
            new Mode("Embperl"           , "embperl.xml"                 , "*.epl"                       , null),
            new Mode("Erlang"            , "erlang.xml"                  , "*.{erl,hrl}"                 , null),
            new Mode("Eiffel"            , "eiffel.xml"                  , "*.e"                         , null),
            new Mode("Fhtml"             , "fhtml.xml"                   , "*.{furnace,fhtml}"           , null),
            new Mode("Factor"            , "factor.xml"                  , "*.factor"                    , null),
            new Mode("Jflex"             , "jflex.xml"                   , "*.flex"                      , null),
            new Mode("Forth"             , "forth.xml"                   , "*.f"                         , null),
            new Mode("Fortran"           , "fortran.xml"                 , "*.{for,fort,f77}"            , null),
            new Mode("Fortran90"         , "fortran90.xml"               , "*.{f90,f95,f03}"             , null),
            new Mode("FoxPro"            , "foxpro.xml"                  , "*.prg"                       , null),
            new Mode("FreeMarker"        , "freemarker.xml"              , "*.ftl"                       , "<\\#ftl*"),
            new Mode("GCBasic"           , "gcbasic.xml"                 , "*.{gc,gcb}"                  , "{*GCBASIC*,*Great Cow BASIC*}"),
            new Mode("GetText"           , "gettext.xml"                 , "*.{po,pot}"                  , null),
            new Mode("GNUPlot"           , "gnuplot.xml"                 , "*.{dem,plt}"                 , null),
            new Mode("Go"                , "go.xml"                      , "*.go"                        , null),
            new Mode("Gradle"            , "gradle.xml"                  , "*.{gradle}"                  , null),
            new Mode("Groovy"            , "groovy.xml"                  , "*.{gant,groovy,grv}"         , null),
            new Mode("GSP"               , "jsp.xml"                     , "*.{gsp}"                     , null),
            new Mode("Haskell"           , "haskell.xml"                 , "*.hs"                        , null),
            new Mode("Haxe"              , "haxe.xml"                    , "*.hx"                        , null),
            new Mode("Hxml"              , "hxml.xml"                    , "*.hxml"                      , null),
            new Mode("Hex"               , "hex.xml"                     , null                          , null),
            new Mode("Hlsl"              , "hlsl.xml"                    , "*.fx"                        , null),
            new Mode(".htaccess"          , "htaccess.xml"                , ".htaccess"                   , null),
            new Mode("Html"              , "html.xml"                    , "*.{html,htm,hta}"            , null),
            new Mode("I4gl"              , "i4gl.xml"                    , "*.4gl"                       , null),
            new Mode("Icalendar"         , "ical.xml"                    , "*.ics"                       , null),
            new Mode("Icon"              , "icon.xml"                    , "*.icn"                       , null),
            new Mode("Idl"               , "idl.xml"                     , "*.idl"                       , null),
            new Mode("Inform"            , "inform.xml"                  , "*.inf"                       , null),
            new Mode("Inno-setup"        , "inno_setup.xml"              , "*.iss"                       , null),
            new Mode("Ini"               , "ini.xml"                     , "*.{ini,reg,milk}"            , null),
            new Mode("Interlis"          , "interlis.xml"                , "*.ili"                       , null),
            new Mode("Io"                , "io.xml"                      , "*.io"                        , null),
            new Mode("Jamon"             , "jamon.xml"                   , "*.jamon"                     , null),
            new Mode("JavaCC"            , "javacc.xml"                  , "*.{jj,jjt}"                  , null),
            new Mode("Java"              , "java.xml"                    , "*.java"                      , null),
            new Mode("JavaFX"            , "javafx.xml"                  , "*.fx"                        , null),
            new Mode("JavaScript"        , "javascript.xml"              , "{*.js,Buildsub}"             , null),
            new Mode("Jcl"               , "jcl.xml"                     , "*.jcl"                       , null),
            new Mode("Jedit-Actions"     , "jedit_actions.xml"           , "actions.xml"                 , null),
            new Mode("Jhtml"             , "jhtml.xml"                   , "*.jhtml"                     , null),
            new Mode("Jmk"               , "jmk.xml"                     , "*.jmk"                       , null),
            new Mode("JSON"              , "json.xml"                    , "*.json"                      , null),
            new Mode("JSP"               , "jsp.xml"                     , "*.{jsp,jsf,jspf,tag}"        , null),
            new Mode("Kotlin"            , "kotlin.xml"                  , "*.{kt}"                      , null),
            new Mode("Latex"             , "latex.xml"                   , "*.{tex,sty,ltx}"             , null),
            new Mode("Lex"               , "lex.xml"                     , "*.l"                         , null),
            new Mode("Lilypond"          , "lilypond.xml"                , "*.{ly,ily}"                  , null),
            new Mode("Lisp"              , "lisp.xml"                    , "*.{lisp,lsp,el}"             , null),
            new Mode("Literate-haskell"  , "literate_haskell.xml"        , "*.lhs"                       , null),
            new Mode("Logs"              , "logs.xml"                    , "*.log"                       , null),
            new Mode("Logtalk"           , "logtalk.xml"                 , "*.lgt"                       , null),
            new Mode("Lotos"             , "lotos.xml"                   , "*.{lot,lotos}"               , null),
            new Mode("Lua"               , "lua.xml"                     , "*.lua"                       , null),
            new Mode("MacroScheduler"    , "macroscheduler.xml"          , "*.scp"                       , null),
            new Mode("Mail"              , "mail.xml"                    , null                          , null),
            new Mode("Makefile"          , "makefile.xml"                , "*makefile"                   , null),
            new Mode("Maple"             , "maple.xml"                   , "*.{mpl,mws}"                 , null),
            new Mode("Markdown"          , "markdown.xml"                , "*.{md,markdown}"             , null),
            new Mode("Maven"             , "maven.xml"                   , "pom.xml"                     , null),
            new Mode("Metapost"          , "mpost.xml"                   , "*.mp"                        , null),
            new Mode("Mxml"              , "mxml.xml"                    , "*.mxml"                      , null),
            new Mode("Ml"                , "ml.xml"                      , "*.{sml,ml}"                  , null),
            new Mode("Modula3"           , "modula3.xml"                 , "*.[im]3"                     , null),
            new Mode("Moin"              , "moin.xml"                    , "*.moin"                      , null),
            new Mode("Mqsc"              , "mqsc.xml"                    , "*.mqsc"                      , null),
            new Mode("Myghty"            , "myghty.xml"                  , "{autohandler,dhandler,*.myt}", null),
            new Mode("MySQL"             , "mysql.xml"                   , null                          , null),
            new Mode("N3"                , "n3.xml"                      , "*.n3"                        , null),
            new Mode("Netrexx"           , "netrexx.xml"                 , "*.nrx"                       , null),
            new Mode("Nqc"               , "nqc.xml"                     , "*.nqc"                       , null),
            new Mode("Nsis2"             , "nsis2.xml"                   , "*.{nsi,nsh}"                 , null),
            new Mode("Objective-C"       , "objective_c.xml"             , "*.{objc,m,mm}"               , null),
            new Mode("Objectrexx"        , "objectrexx.xml"              , "*.{rex,orx}"                 , null),
            new Mode("Occam"             , "occam.xml"                   , "*.icc"                       , null),
            new Mode("Omnimark"          , "omnimark.xml"                , "*.x{om,in}"                  , null),
            new Mode("Outline"           , "outline.xml"                 , "*.{outline}"                 , null),
            new Mode("Pascal"            , "pascal.xml"                  , "*.{pas,dpr,dpk}"             , null),
            new Mode("Patch"             , "patch.xml"                   , "*.{diff,patch}"              , "{# HG changeset patch,diff --git *}"),
            new Mode("Perl"              , "perl.xml"                    , "*.p{[lmh],od}"               , "#!/*perl*"),
            new Mode("PHP"               , "php.xml"                     , "*.{php3,php4,php,phtml,inc}" , "{<\\?php*,#!/*php*}"),
            new Mode("Pike"              , "pike.xml"                    , "*.{pike,pmod}"               , null),
            new Mode("Plaintex"          , "plaintex.xml"                , null                          , null),
            new Mode("PostgreSQL"        , "pg_sql.xml"                  , "*.{pg_sql,pg-sql}"           , null),
            new Mode("PowerCenter Parameter File", "powercenter_parameter_file.xml", "*.par"                       , null),
            new Mode("Pl-sql"            , "osql.xml"                    , "*.{pls,sql}"                 , null),
            new Mode("Pl-sql9"           , "pl_sql.xml"                  , null                          , null),
            new Mode("Pl1"               , "pl1.xml"                     , "*.pl[i1]"                    , null),
            new Mode("Pop11"             , "pop11.xml"                   , "*.{p,pop11,p11}"             , null),
            new Mode("PostScript"        , "postscript.xml"              , "*.{ps,eps}"                  , null),
            new Mode("Povray"            , "povray.xml"                  , "*.{pov,povray}"              , null),
            new Mode("PowerDynamo"       , "powerdynamo.xml"             , "*.{ssc,stm}"                 , null),
            new Mode("PowerShell"        , "powershell.xml"              , "*.{ps1,psm1,psd1}"           , null),
            new Mode("Prolog"            , "prolog.xml"                  , "*.pro"                       , null),
            new Mode("Progress"          , "progress.xml"                , "*.[piw]"                     , null),
            new Mode("Properties"        , "props.xml"                   , "*{properties,props}"         , null),
            new Mode("Psp"               , "psp.xml"                     , "*.psp"                       , null),
            new Mode("Ptl"               , "ptl.xml"                     , "*.ptl"                       , null),
            new Mode("Pure"              , "pure.xml"                    , "*.pure"                      , "#!*/*pure"),
            new Mode("Pvwave"            , "pvwave.xml"                  , "*.jou"                       , null),
            new Mode("Pyrex"             , "pyrex.xml"                   , "*.{pyx}"                     , null),
            new Mode("Python"            , "python.xml"                  , "*.{py,pyw,sc,jy}"            , "#!*/*python*"),
            new Mode("R"                 , "r.xml"                       , "*.r"                         , null),
            new Mode("Rebol"             , "rebol.xml"                   , "*.rebol"                     , null),
            new Mode("Redcode"           , "redcode.xml"                 , "*.{red,rc}"                  , null),
            new Mode("Relax-ng-compact"  , "relax_ng_compact.xml"        , "*.rnc"                       , null),
            new Mode("Renderman-rib"     , "rib.xml"                     , "*.rib"                       , null),
            new Mode("Rd"                , "rd.xml"                      , "*.rd"                        , null),
            new Mode("Rest"              , "rest.xml"                    , "*.{rst,rest}"                , "{===,~~~}*"),
            new Mode("Rhtml"             , "rhtml.xml"                   , "*.{rhtml,html.erb}"          , null),
            new Mode("Roff"              , "roff.xml"                    , "*.{1,2,3,4,5,6,7,8,9,me,ms,mom,tmac}", null),
            new Mode("Rpm-spec"          , "rpmspec.xml"                 , "*.spec"                      , null),
            new Mode("Rtf"               , "rtf.xml"                     , "*.rtf"                       , null),
            new Mode("Rakefile"          , "ruby.xml"                    , "*Rakefile"                   , null),
            new Mode("Ruby"              , "ruby.xml"                    , "*.{rb,rbw}"                  , "#!*/*ruby*"),
            new Mode("Rust"              , "rubst.xml"                    , "*.{rbs}"                    , null),
            new Mode("Rview"             , "rview.xml"                   , "*.rvw"                       , null),
            new Mode("S+"                , "splus.xml"                   , "*.ssc"                       , null),
            new Mode("S#"                , "ssharp.xml"                  , "*.{ss,ssc,ssi,ssw,sts,aml}"  , null),
            new Mode("Sas"               , "sas.xml"                     , "*.sas"                       , null),
            new Mode("Sbt"               , "scala.xml"                   , "*.sbt"                       , null),
            new Mode("Scala"             , "scala.xml"                   , "*.scala"                     , null),
            new Mode("Scheme"            , "scheme.xml"                  , "*.scm"                       , null),
            new Mode("Sgml"              , "sgml.xml"                    , "*.{sgml,sgm,dtd}"            , null),
            new Mode("Sip"               , "sip.xml"                     , null                          , null),
            new Mode("Rcp"               , "rcp.xml"                     , "*.rcp"                       , null),
            new Mode("ShellScript"       , "shellscript.xml"             , "*.{csh,sh,bash,login,profile,bashrc,bash_profile}", "#!/*sh*"),
            new Mode("SHTML"             , "shtml.xml"                   , "*.{shtml,shtm,ssi}"          , null),
            new Mode("Slate"             , "slate.xml"                   , "*.slate"                     , null),
            new Mode("Slax"              , "slax.xml"                    , "*.slax"                      , null),
            new Mode("Smalltalk"         , "smalltalk.xml"               , "*.{st,sources,changes}"      , null),
            new Mode("Smarty"            , "smarty.xml"                  , "*.tpl"                       , null),
            new Mode("Sdl/pr"            , "sdl_pr.xml"                  , "*.pr"                        , null),
            new Mode("Sql-loader"        , "sql_loader.xml"              , "*.ctl"                       , null),
            new Mode("Smi-mib"           , "smi_mib.xml"                 , "*{.mib,-MIB.txt}"            , null),
            new Mode("Sqr"               , "sqr.xml"                     , "*.{sqr,sqc}"                 , null),
            new Mode("Squidconf"         , "squidconf.xml"               , "squid.conf"                  , null),
            new Mode("Stata"             , "stata.xml"                   , "*.{do,ado,mata}"             , null),
            new Mode("Svn-commit"        , "svn_commit.xml"              , "svn-commit*.tmp"             , null),
            new Mode("Swig"              , "swig.xml"                    , "*.{i,swg}"                   , null),
            new Mode("Tcl"               , "tcl.xml"                     , "*.{tcl,tsh}"                 , null),
            new Mode("Texinfo"           , "texinfo.xml"                 , "*.texi"                      , null),
            new Mode("Tex"               , "tex.xml"                     , null                          , null),
            new Mode("Text"              , "text.xml"                    , "*.txt"                       , null),
            new Mode("Rfc"               , "rfc.xml"                     , "rfc*.txt"                    , null),
            new Mode("Tld"               , "tld.xml"                     , "*.tld"                       , null),
            new Mode("Tsp"               , "tsp.xml"                     , "*.tsp"                       , null),
            new Mode("Transact-sql"      , "tsql.xml"                    , null                          , null),
            new Mode("Template-toolkit"  , "tthtml.xml"                  , "*.tt{html,css,js}"           , null),
            new Mode("Twiki"             , "twiki.xml"                   , "*.twiki"                     , null),
            new Mode("Typoscript"        , "typoscript.xml"              , "*.ts"                        , null),
            new Mode("Url"               , "url.xml"                     , "*.url"                       , null),
            new Mode("Uscript"           , "uscript.xml"                 , "*.uc"                        , null),
            new Mode("Vala"              , "vala.xml"                    , "*.vala"                      , null),
            new Mode("Vbscript"          , "vbscript.xml"                , "*.{vbs,bas,cls}"             , null),
            new Mode("Velocity"          , "velocity_pure.xml"           , "*.vm"                        , null),
            new Mode("Verilog"           , "verilog.xml"                 , "*.{ver,v,sv}"                , null),
            new Mode("Vhdl"              , "vhdl.xml"                    , "*.vh*"                       , null),
            new Mode("Visualbasic"       , "visualbasic.xml"             , "*.{vb}"                      , null),
            new Mode("Vrml2"             , "vrml2.xml"                   , "*.{wrl,wrz}"                 , null),
            new Mode("Xml"               , "xml.xml"                     , "*.{xml,xhtml,xsd,qrc,ui,docbook}", "<\\?xml*"),
            new Mode("Xq"                , "xq.xml"                      , "*.x{q,qm,ql}"                , null),
            new Mode("Xsl"               , "xsl.xml"                     , "*.xsl"                       , null),
            new Mode("Yab"               , "yab.xml"                     , "*.yab"                       , null),
            new Mode("Yaml"              , "yaml.xml"                    , "*.{yml,yaml}"                , null),
            new Mode("Zpt"               , "zpt.xml"                     , "*.{pt,zpt}"                  , null),
    };

}
