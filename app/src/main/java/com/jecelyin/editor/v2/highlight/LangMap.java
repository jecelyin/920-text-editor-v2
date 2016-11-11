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

import com.jecelyin.editor.v2.highlight.lang.*;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class LangMap {
    public static LangDefine get(String filename) {
        switch(filename) {
            case "actionscript.xml": return new ActionscriptLang();
            case "ada.xml": return new AdaLang();
            case "ada95.xml": return new Ada95Lang();
            case "ant.xml": return new AntLang();
            case "antlr.xml": return new AntlrLang();
            case "apacheconf.xml": return new ApacheconfLang();
            case "apdl.xml": return new ApdlLang();
            case "applescript.xml": return new ApplescriptLang();
            case "asp.xml": return new AspLang();
            case "aspect_j.xml": return new AspectJLang();
            case "assembly_agc.xml": return new AssemblyAgcLang();
            case "assembly_ags.xml": return new AssemblyAgsLang();
            case "assembly_m68k.xml": return new AssemblyM68kLang();
            case "assembly_macro32.xml": return new AssemblyMacro32Lang();
            case "assembly_mcs51.xml": return new AssemblyMcs51Lang();
            case "assembly_parrot.xml": return new AssemblyParrotLang();
            case "assembly_r2000.xml": return new AssemblyR2000Lang();
            case "assembly_x86.xml": return new AssemblyX86Lang();
            case "avro.xml": return new AvroLang();
            case "awk.xml": return new AwkLang();
            case "b.xml": return new BLang();
            case "batch.xml": return new BatchLang();
            case "bbj.xml": return new BbjLang();
            case "bcel.xml": return new BcelLang();
            case "bibtex.xml": return new BibtexLang();
            case "binsource_agc.xml": return new BinsourceAgcLang();
            case "c.xml": return new CLang();
            case "cfscript.xml": return new CfscriptLang();
            case "chill.xml": return new ChillLang();
            case "cil.xml": return new CilLang();
            case "clips.xml": return new ClipsLang();
            case "clojure.xml": return new ClojureLang();
            case "cmake.xml": return new CmakeLang();
            case "cobol.xml": return new CobolLang();
            case "coffeescript.xml": return new CoffeescriptLang();
            case "coldfusion.xml": return new ColdfusionLang();
            case "cplexlp.xml": return new CplexlpLang();
            case "cplusplus.xml": return new CplusplusLang();
            case "csharp.xml": return new CsharpLang();
            case "css.xml": return new CssLang();
            case "csv.xml": return new CsvLang();
            case "cvs_commit.xml": return new CvsCommitLang();
            case "d.xml": return new DLang();
            case "dart.xml": return new DartLang();
            case "django.xml": return new DjangoLang();
            case "dot.xml": return new DotLang();
            case "doxygen.xml": return new DoxygenLang();
            case "dsssl.xml": return new DssslLang();
            case "eiffel.xml": return new EiffelLang();
            case "embperl.xml": return new EmbperlLang();
            case "erlang.xml": return new ErlangLang();
            case "factor.xml": return new FactorLang();
            case "fhtml.xml": return new FhtmlLang();
            case "forth.xml": return new ForthLang();
            case "fortran.xml": return new FortranLang();
            case "fortran90.xml": return new Fortran90Lang();
            case "foxpro.xml": return new FoxproLang();
            case "freemarker.xml": return new FreemarkerLang();
            case "gcbasic.xml": return new GcbasicLang();
            case "gettext.xml": return new GettextLang();
            case "gnuplot.xml": return new GnuplotLang();
            case "go.xml": return new GoLang();
            case "gradle.xml": return new GradleLang();
            case "groovy.xml": return new GroovyLang();
            case "haskell.xml": return new HaskellLang();
            case "haxe.xml": return new HaxeLang();
            case "hex.xml": return new HexLang();
            case "hlsl.xml": return new HlslLang();
            case "htaccess.xml": return new HtaccessLang();
            case "html.xml": return new HtmlLang();
            case "hxml.xml": return new HxmlLang();
            case "i4gl.xml": return new I4glLang();
            case "ical.xml": return new IcalLang();
            case "icon.xml": return new IconLang();
            case "idl.xml": return new IdlLang();
            case "inform.xml": return new InformLang();
            case "ini.xml": return new IniLang();
            case "inno_setup.xml": return new InnoSetupLang();
            case "interlis.xml": return new InterlisLang();
            case "io.xml": return new IoLang();
            case "jamon.xml": return new JamonLang();
            case "java.xml": return new JavaLang();
            case "javacc.xml": return new JavaccLang();
            case "javafx.xml": return new JavafxLang();
            case "javascript.xml": return new JavascriptLang();
            case "jcl.xml": return new JclLang();
            case "jflex.xml": return new JflexLang();
            case "jhtml.xml": return new JhtmlLang();
            case "jmk.xml": return new JmkLang();
            case "json.xml": return new JsonLang();
            case "jsp.xml": return new JspLang();
            case "kotlin.xml": return new KotlinLang();
            case "latex.xml": return new LatexLang();
            case "lex.xml": return new LexLang();
            case "lilypond.xml": return new LilypondLang();
            case "lisp.xml": return new LispLang();
            case "literate_haskell.xml": return new LiterateHaskellLang();
            case "logs.xml": return new LogsLang();
            case "logtalk.xml": return new LogtalkLang();
            case "lotos.xml": return new LotosLang();
            case "lua.xml": return new LuaLang();
            case "macroscheduler.xml": return new MacroschedulerLang();
            case "mail.xml": return new MailLang();
            case "makefile.xml": return new MakefileLang();
            case "maple.xml": return new MapleLang();
            case "markdown.xml": return new MarkdownLang();
            case "maven.xml": return new MavenLang();
            case "ml.xml": return new MlLang();
            case "modula3.xml": return new Modula3Lang();
            case "moin.xml": return new MoinLang();
            case "mpost.xml": return new MpostLang();
            case "mqsc.xml": return new MqscLang();
            case "mxml.xml": return new MxmlLang();
            case "myghty.xml": return new MyghtyLang();
            case "mysql.xml": return new MysqlLang();
            case "n3.xml": return new N3Lang();
            case "netrexx.xml": return new NetrexxLang();
            case "nqc.xml": return new NqcLang();
            case "nsis2.xml": return new Nsis2Lang();
            case "objective_c.xml": return new ObjectiveCLang();
            case "objectrexx.xml": return new ObjectrexxLang();
            case "occam.xml": return new OccamLang();
            case "omnimark.xml": return new OmnimarkLang();
            case "osql.xml": return new OsqlLang();
            case "outline.xml": return new OutlineLang();
            case "pascal.xml": return new PascalLang();
            case "patch.xml": return new PatchLang();
            case "perl.xml": return new PerlLang();
            case "pg_sql.xml": return new PgSqlLang();
            case "php.xml": return new PhpLang();
            case "pike.xml": return new PikeLang();
            case "pl1.xml": return new Pl1Lang();
            case "pl_sql.xml": return new PlSqlLang();
            case "plaintex.xml": return new PlaintexLang();
            case "pop11.xml": return new Pop11Lang();
            case "postscript.xml": return new PostscriptLang();
            case "povray.xml": return new PovrayLang();
            case "powercenter_parameter_file.xml": return new PowercenterParameterFileLang();
            case "powerdynamo.xml": return new PowerdynamoLang();
            case "powershell.xml": return new PowershellLang();
            case "progress.xml": return new ProgressLang();
            case "prolog.xml": return new PrologLang();
            case "props.xml": return new PropsLang();
            case "psp.xml": return new PspLang();
            case "ptl.xml": return new PtlLang();
            case "pure.xml": return new PureLang();
            case "pvwave.xml": return new PvwaveLang();
            case "pyrex.xml": return new PyrexLang();
            case "python.xml": return new PythonLang();
            case "r.xml": return new RLang();
            case "rcp.xml": return new RcpLang();
            case "rd.xml": return new RdLang();
            case "rebol.xml": return new RebolLang();
            case "redcode.xml": return new RedcodeLang();
            case "regex.xml": return new RegexLang();
            case "relax_ng_compact.xml": return new RelaxNgCompactLang();
            case "rest.xml": return new RestLang();
            case "rfc.xml": return new RfcLang();
            case "rhtml.xml": return new RhtmlLang();
            case "rib.xml": return new RibLang();
            case "roff.xml": return new RoffLang();
            case "rpmspec.xml": return new RpmspecLang();
            case "rtf.xml": return new RtfLang();
            case "ruby.xml": return new RubyLang();
            case "rust.xml": return new RustLang();
            case "rview.xml": return new RviewLang();
            case "sas.xml": return new SasLang();
            case "scala.xml": return new ScalaLang();
            case "scheme.xml": return new SchemeLang();
            case "sdl_pr.xml": return new SdlPrLang();
            case "sgml.xml": return new SgmlLang();
            case "shellscript.xml": return new ShellscriptLang();
            case "shtml.xml": return new ShtmlLang();
            case "sip.xml": return new SipLang();
            case "slate.xml": return new SlateLang();
            case "slax.xml": return new SlaxLang();
            case "smalltalk.xml": return new SmalltalkLang();
            case "smarty.xml": return new SmartyLang();
            case "smi_mib.xml": return new SmiMibLang();
            case "splus.xml": return new SplusLang();
            case "sql_loader.xml": return new SqlLoaderLang();
            case "sqr.xml": return new SqrLang();
            case "squidconf.xml": return new SquidconfLang();
            case "ssharp.xml": return new SsharpLang();
            case "stata.xml": return new StataLang();
            case "svn_commit.xml": return new SvnCommitLang();
            case "swig.xml": return new SwigLang();
            case "tcl.xml": return new TclLang();
            case "tex.xml": return new TexLang();
            case "texinfo.xml": return new TexinfoLang();
            case "text.xml": return new TextLang();
            case "tld.xml": return new TldLang();
            case "tpl.xml": return new TplLang();
            case "tsp.xml": return new TspLang();
            case "tsql.xml": return new TsqlLang();
            case "tthtml.xml": return new TthtmlLang();
            case "turbobasic.xml": return new TurbobasicLang();
            case "twiki.xml": return new TwikiLang();
            case "typoscript.xml": return new TyposcriptLang();
            case "url.xml": return new UrlLang();
            case "uscript.xml": return new UscriptLang();
            case "vala.xml": return new ValaLang();
            case "vbscript.xml": return new VbscriptLang();
            case "velocity.xml": return new VelocityLang();
            case "velocity_pure.xml": return new VelocityPureLang();
            case "verilog.xml": return new VerilogLang();
            case "vhdl.xml": return new VhdlLang();
            case "visualbasic.xml": return new VisualbasicLang();
            case "vrml2.xml": return new Vrml2Lang();
            case "xml.xml": return new XmlLang();
            case "xq.xml": return new XqLang();
            case "xsl.xml": return new XslLang();
            case "yab.xml": return new YabLang();
            case "yaml.xml": return new YamlLang();
            case "zpt.xml": return new ZptLang();

        }
        return null;
    }
}
