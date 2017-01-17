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

package com.jecelyin.editor.v2.highlight;

import com.jecelyin.editor.v2.R;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class LangMap {
    public static int get(String filename) {
        switch(filename) {
            case "actionscript.xml": return R.raw.actionscript_lang;
            case "ada.xml": return R.raw.ada_lang;
            case "ada95.xml": return R.raw.ada95_lang;
            case "ant.xml": return R.raw.ant_lang;
            case "antlr.xml": return R.raw.antlr_lang;
            case "apacheconf.xml": return R.raw.apacheconf_lang;
            case "apdl.xml": return R.raw.apdl_lang;
            case "applescript.xml": return R.raw.applescript_lang;
            case "asp.xml": return R.raw.asp_lang;
            case "aspect_j.xml": return R.raw.aspect_j_lang;
            case "assembly_agc.xml": return R.raw.assembly_agc_lang;
            case "assembly_ags.xml": return R.raw.assembly_ags_lang;
            case "assembly_m68k.xml": return R.raw.assembly_m68k_lang;
            case "assembly_macro32.xml": return R.raw.assembly_macro32_lang;
            case "assembly_mcs51.xml": return R.raw.assembly_mcs51_lang;
            case "assembly_parrot.xml": return R.raw.assembly_parrot_lang;
            case "assembly_r2000.xml": return R.raw.assembly_r2000_lang;
            case "assembly_x86.xml": return R.raw.assembly_x86_lang;
            case "autohotkey.xml": return R.raw.autohotkey_lang;
            case "avro.xml": return R.raw.avro_lang;
            case "awk.xml": return R.raw.awk_lang;
            case "b.xml": return R.raw.b_lang;
            case "batch.xml": return R.raw.batch_lang;
            case "bbj.xml": return R.raw.bbj_lang;
            case "bcel.xml": return R.raw.bcel_lang;
            case "bibtex.xml": return R.raw.bibtex_lang;
            case "binsource_agc.xml": return R.raw.binsource_agc_lang;
            case "c.xml": return R.raw.c_lang;
            case "cfscript.xml": return R.raw.cfscript_lang;
            case "chill.xml": return R.raw.chill_lang;
            case "cil.xml": return R.raw.cil_lang;
            case "clips.xml": return R.raw.clips_lang;
            case "clojure.xml": return R.raw.clojure_lang;
            case "cmake.xml": return R.raw.cmake_lang;
            case "cobol.xml": return R.raw.cobol_lang;
            case "coffeescript.xml": return R.raw.coffeescript_lang;
            case "coldfusion.xml": return R.raw.coldfusion_lang;
            case "cplexlp.xml": return R.raw.cplexlp_lang;
            case "cplusplus.xml": return R.raw.cplusplus_lang;
            case "csharp.xml": return R.raw.csharp_lang;
            case "css.xml": return R.raw.css_lang;
            case "csv.xml": return R.raw.csv_lang;
            case "cvs_commit.xml": return R.raw.cvs_commit_lang;
            case "d.xml": return R.raw.d_lang;
            case "dart.xml": return R.raw.dart_lang;
            case "django.xml": return R.raw.django_lang;
            case "dot.xml": return R.raw.dot_lang;
            case "doxygen.xml": return R.raw.doxygen_lang;
            case "dsssl.xml": return R.raw.dsssl_lang;
            case "eiffel.xml": return R.raw.eiffel_lang;
            case "embperl.xml": return R.raw.embperl_lang;
            case "erlang.xml": return R.raw.erlang_lang;
            case "factor.xml": return R.raw.factor_lang;
            case "fhtml.xml": return R.raw.fhtml_lang;
            case "forth.xml": return R.raw.forth_lang;
            case "fortran.xml": return R.raw.fortran_lang;
            case "fortran90.xml": return R.raw.fortran90_lang;
            case "foxpro.xml": return R.raw.foxpro_lang;
            case "freemarker.xml": return R.raw.freemarker_lang;
            case "gcbasic.xml": return R.raw.gcbasic_lang;
            case "gettext.xml": return R.raw.gettext_lang;
            case "gnuplot.xml": return R.raw.gnuplot_lang;
            case "go.xml": return R.raw.go_lang;
            case "gradle.xml": return R.raw.gradle_lang;
            case "groovy.xml": return R.raw.groovy_lang;
            case "haskell.xml": return R.raw.haskell_lang;
            case "haxe.xml": return R.raw.haxe_lang;
            case "hex.xml": return R.raw.hex_lang;
            case "hlsl.xml": return R.raw.hlsl_lang;
            case "htaccess.xml": return R.raw.htaccess_lang;
            case "html.xml": return R.raw.html_lang;
            case "hxml.xml": return R.raw.hxml_lang;
            case "i4gl.xml": return R.raw.i4gl_lang;
            case "ical.xml": return R.raw.ical_lang;
            case "icon.xml": return R.raw.icon_lang;
            case "idl.xml": return R.raw.idl_lang;
            case "inform.xml": return R.raw.inform_lang;
            case "ini.xml": return R.raw.ini_lang;
            case "inno_setup.xml": return R.raw.inno_setup_lang;
            case "interlis.xml": return R.raw.interlis_lang;
            case "io.xml": return R.raw.io_lang;
            case "jamon.xml": return R.raw.jamon_lang;
            case "java.xml": return R.raw.java_lang;
            case "javacc.xml": return R.raw.javacc_lang;
            case "javafx.xml": return R.raw.javafx_lang;
            case "javascript.xml": return R.raw.javascript_lang;
            case "jcl.xml": return R.raw.jcl_lang;
            case "jflex.xml": return R.raw.jflex_lang;
            case "jhtml.xml": return R.raw.jhtml_lang;
            case "jmk.xml": return R.raw.jmk_lang;
            case "json.xml": return R.raw.json_lang;
            case "jsp.xml": return R.raw.jsp_lang;
            case "kotlin.xml": return R.raw.kotlin_lang;
            case "latex.xml": return R.raw.latex_lang;
            case "lex.xml": return R.raw.lex_lang;
            case "lilypond.xml": return R.raw.lilypond_lang;
            case "lisp.xml": return R.raw.lisp_lang;
            case "literate_haskell.xml": return R.raw.literate_haskell_lang;
            case "logs.xml": return R.raw.logs_lang;
            case "logtalk.xml": return R.raw.logtalk_lang;
            case "lotos.xml": return R.raw.lotos_lang;
            case "lua.xml": return R.raw.lua_lang;
            case "macroscheduler.xml": return R.raw.macroscheduler_lang;
            case "mail.xml": return R.raw.mail_lang;
            case "makefile.xml": return R.raw.makefile_lang;
            case "maple.xml": return R.raw.maple_lang;
            case "markdown.xml": return R.raw.markdown_lang;
            case "maven.xml": return R.raw.maven_lang;
            case "ml.xml": return R.raw.ml_lang;
            case "modula3.xml": return R.raw.modula3_lang;
            case "moin.xml": return R.raw.moin_lang;
            case "mpost.xml": return R.raw.mpost_lang;
            case "mqsc.xml": return R.raw.mqsc_lang;
            case "mxml.xml": return R.raw.mxml_lang;
            case "myghty.xml": return R.raw.myghty_lang;
            case "mysql.xml": return R.raw.mysql_lang;
            case "n3.xml": return R.raw.n3_lang;
            case "netrexx.xml": return R.raw.netrexx_lang;
            case "nqc.xml": return R.raw.nqc_lang;
            case "nsis2.xml": return R.raw.nsis2_lang;
            case "objective_c.xml": return R.raw.objective_c_lang;
            case "objectrexx.xml": return R.raw.objectrexx_lang;
            case "occam.xml": return R.raw.occam_lang;
            case "omnimark.xml": return R.raw.omnimark_lang;
            case "osql.xml": return R.raw.osql_lang;
            case "outline.xml": return R.raw.outline_lang;
            case "pascal.xml": return R.raw.pascal_lang;
            case "patch.xml": return R.raw.patch_lang;
            case "perl.xml": return R.raw.perl_lang;
            case "pg_sql.xml": return R.raw.pg_sql_lang;
            case "php.xml": return R.raw.php_lang;
            case "pike.xml": return R.raw.pike_lang;
            case "pl1.xml": return R.raw.pl1_lang;
            case "pl_sql.xml": return R.raw.pl_sql_lang;
            case "plaintex.xml": return R.raw.plaintex_lang;
            case "pop11.xml": return R.raw.pop11_lang;
            case "postscript.xml": return R.raw.postscript_lang;
            case "povray.xml": return R.raw.povray_lang;
            case "powercenter_parameter_file.xml": return R.raw.powercenter_parameter_file_lang;
            case "powerdynamo.xml": return R.raw.powerdynamo_lang;
            case "powershell.xml": return R.raw.powershell_lang;
            case "progress.xml": return R.raw.progress_lang;
            case "prolog.xml": return R.raw.prolog_lang;
            case "props.xml": return R.raw.props_lang;
            case "psp.xml": return R.raw.psp_lang;
            case "ptl.xml": return R.raw.ptl_lang;
            case "pure.xml": return R.raw.pure_lang;
            case "pvwave.xml": return R.raw.pvwave_lang;
            case "pyrex.xml": return R.raw.pyrex_lang;
            case "python.xml": return R.raw.python_lang;
            case "r.xml": return R.raw.r_lang;
            case "rcp.xml": return R.raw.rcp_lang;
            case "rd.xml": return R.raw.rd_lang;
            case "rebol.xml": return R.raw.rebol_lang;
            case "redcode.xml": return R.raw.redcode_lang;
            case "regex.xml": return R.raw.regex_lang;
            case "relax_ng_compact.xml": return R.raw.relax_ng_compact_lang;
            case "rest.xml": return R.raw.rest_lang;
            case "rfc.xml": return R.raw.rfc_lang;
            case "rhtml.xml": return R.raw.rhtml_lang;
            case "rib.xml": return R.raw.rib_lang;
            case "roff.xml": return R.raw.roff_lang;
            case "rpmspec.xml": return R.raw.rpmspec_lang;
            case "rtf.xml": return R.raw.rtf_lang;
            case "ruby.xml": return R.raw.ruby_lang;
            case "rust.xml": return R.raw.rust_lang;
            case "rview.xml": return R.raw.rview_lang;
            case "sas.xml": return R.raw.sas_lang;
            case "scala.xml": return R.raw.scala_lang;
            case "scheme.xml": return R.raw.scheme_lang;
            case "sdl_pr.xml": return R.raw.sdl_pr_lang;
            case "sgml.xml": return R.raw.sgml_lang;
            case "shellscript.xml": return R.raw.shellscript_lang;
            case "shtml.xml": return R.raw.shtml_lang;
            case "sip.xml": return R.raw.sip_lang;
            case "slate.xml": return R.raw.slate_lang;
            case "slax.xml": return R.raw.slax_lang;
            case "smalltalk.xml": return R.raw.smalltalk_lang;
            case "smarty.xml": return R.raw.smarty_lang;
            case "smi_mib.xml": return R.raw.smi_mib_lang;
            case "splus.xml": return R.raw.splus_lang;
            case "sql_loader.xml": return R.raw.sql_loader_lang;
            case "sqr.xml": return R.raw.sqr_lang;
            case "squidconf.xml": return R.raw.squidconf_lang;
            case "ssharp.xml": return R.raw.ssharp_lang;
            case "stata.xml": return R.raw.stata_lang;
            case "svn_commit.xml": return R.raw.svn_commit_lang;
            case "swig.xml": return R.raw.swig_lang;
            case "tcl.xml": return R.raw.tcl_lang;
            case "tex.xml": return R.raw.tex_lang;
            case "texinfo.xml": return R.raw.texinfo_lang;
            case "text.xml": return R.raw.text_lang;
            case "tld.xml": return R.raw.tld_lang;
            case "tpl.xml": return R.raw.tpl_lang;
            case "tsp.xml": return R.raw.tsp_lang;
            case "tsql.xml": return R.raw.tsql_lang;
            case "tthtml.xml": return R.raw.tthtml_lang;
            case "turbobasic.xml": return R.raw.turbobasic_lang;
            case "twiki.xml": return R.raw.twiki_lang;
            case "typoscript.xml": return R.raw.typoscript_lang;
            case "url.xml": return R.raw.url_lang;
            case "uscript.xml": return R.raw.uscript_lang;
            case "vala.xml": return R.raw.vala_lang;
            case "vbscript.xml": return R.raw.vbscript_lang;
            case "velocity.xml": return R.raw.velocity_lang;
            case "velocity_pure.xml": return R.raw.velocity_pure_lang;
            case "verilog.xml": return R.raw.verilog_lang;
            case "vhdl.xml": return R.raw.vhdl_lang;
            case "visualbasic.xml": return R.raw.visualbasic_lang;
            case "vrml2.xml": return R.raw.vrml2_lang;
            case "xml.xml": return R.raw.xml_lang;
            case "xq.xml": return R.raw.xq_lang;
            case "xsl.xml": return R.raw.xsl_lang;
            case "yab.xml": return R.raw.yab_lang;
            case "yaml.xml": return R.raw.yaml_lang;
            case "zpt.xml": return R.raw.zpt_lang;

        }
        return 0;
    }
}
