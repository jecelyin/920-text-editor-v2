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

import java.util.HashMap;
import com.jecelyin.editor.v2.highlight.lang.*;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class LangMap {
    public static final HashMap<String, LangDefine> map = new HashMap<>();

    static {
        map.put( "actionscript.xml", new ActionscriptLang() );
        map.put( "ada.xml", new AdaLang() );
        map.put( "ada95.xml", new Ada95Lang() );
        map.put( "ant.xml", new AntLang() );
        map.put( "antlr.xml", new AntlrLang() );
        map.put( "apacheconf.xml", new ApacheconfLang() );
        map.put( "apdl.xml", new ApdlLang() );
        map.put( "applescript.xml", new ApplescriptLang() );
        map.put( "asp.xml", new AspLang() );
        map.put( "aspect_j.xml", new AspectJLang() );
        map.put( "assembly_agc.xml", new AssemblyAgcLang() );
        map.put( "assembly_ags.xml", new AssemblyAgsLang() );
        map.put( "assembly_m68k.xml", new AssemblyM68kLang() );
        map.put( "assembly_macro32.xml", new AssemblyMacro32Lang() );
        map.put( "assembly_mcs51.xml", new AssemblyMcs51Lang() );
        map.put( "assembly_parrot.xml", new AssemblyParrotLang() );
        map.put( "assembly_r2000.xml", new AssemblyR2000Lang() );
        map.put( "assembly_x86.xml", new AssemblyX86Lang() );
        map.put( "avro.xml", new AvroLang() );
        map.put( "awk.xml", new AwkLang() );
        map.put( "b.xml", new BLang() );
        map.put( "batch.xml", new BatchLang() );
        map.put( "bbj.xml", new BbjLang() );
        map.put( "bcel.xml", new BcelLang() );
        map.put( "bibtex.xml", new BibtexLang() );
        map.put( "binsource_agc.xml", new BinsourceAgcLang() );
        map.put( "c.xml", new CLang() );
        map.put( "cfscript.xml", new CfscriptLang() );
        map.put( "chill.xml", new ChillLang() );
        map.put( "cil.xml", new CilLang() );
        map.put( "clips.xml", new ClipsLang() );
        map.put( "clojure.xml", new ClojureLang() );
        map.put( "cmake.xml", new CmakeLang() );
        map.put( "cobol.xml", new CobolLang() );
        map.put( "coffeescript.xml", new CoffeescriptLang() );
        map.put( "coldfusion.xml", new ColdfusionLang() );
        map.put( "cplexlp.xml", new CplexlpLang() );
        map.put( "cplusplus.xml", new CplusplusLang() );
        map.put( "csharp.xml", new CsharpLang() );
        map.put( "css.xml", new CssLang() );
        map.put( "csv.xml", new CsvLang() );
        map.put( "cvs_commit.xml", new CvsCommitLang() );
        map.put( "d.xml", new DLang() );
        map.put( "dart.xml", new DartLang() );
        map.put( "django.xml", new DjangoLang() );
        map.put( "dot.xml", new DotLang() );
        map.put( "doxygen.xml", new DoxygenLang() );
        map.put( "dsssl.xml", new DssslLang() );
        map.put( "eiffel.xml", new EiffelLang() );
        map.put( "embperl.xml", new EmbperlLang() );
        map.put( "erlang.xml", new ErlangLang() );
        map.put( "factor.xml", new FactorLang() );
        map.put( "fhtml.xml", new FhtmlLang() );
        map.put( "forth.xml", new ForthLang() );
        map.put( "fortran.xml", new FortranLang() );
        map.put( "fortran90.xml", new Fortran90Lang() );
        map.put( "foxpro.xml", new FoxproLang() );
        map.put( "freemarker.xml", new FreemarkerLang() );
        map.put( "gcbasic.xml", new GcbasicLang() );
        map.put( "gettext.xml", new GettextLang() );
        map.put( "gnuplot.xml", new GnuplotLang() );
        map.put( "go.xml", new GoLang() );
        map.put( "gradle.xml", new GradleLang() );
        map.put( "groovy.xml", new GroovyLang() );
        map.put( "haskell.xml", new HaskellLang() );
        map.put( "haxe.xml", new HaxeLang() );
        map.put( "hex.xml", new HexLang() );
        map.put( "hlsl.xml", new HlslLang() );
        map.put( "htaccess.xml", new HtaccessLang() );
        map.put( "html.xml", new HtmlLang() );
        map.put( "hxml.xml", new HxmlLang() );
        map.put( "i4gl.xml", new I4glLang() );
        map.put( "ical.xml", new IcalLang() );
        map.put( "icon.xml", new IconLang() );
        map.put( "idl.xml", new IdlLang() );
        map.put( "inform.xml", new InformLang() );
        map.put( "ini.xml", new IniLang() );
        map.put( "inno_setup.xml", new InnoSetupLang() );
        map.put( "interlis.xml", new InterlisLang() );
        map.put( "io.xml", new IoLang() );
        map.put( "jamon.xml", new JamonLang() );
        map.put( "java.xml", new JavaLang() );
        map.put( "javacc.xml", new JavaccLang() );
        map.put( "javafx.xml", new JavafxLang() );
        map.put( "javascript.xml", new JavascriptLang() );
        map.put( "jcl.xml", new JclLang() );
        map.put( "jflex.xml", new JflexLang() );
        map.put( "jhtml.xml", new JhtmlLang() );
        map.put( "jmk.xml", new JmkLang() );
        map.put( "json.xml", new JsonLang() );
        map.put( "jsp.xml", new JspLang() );
        map.put( "kotlin.xml", new KotlinLang() );
        map.put( "latex.xml", new LatexLang() );
        map.put( "lex.xml", new LexLang() );
        map.put( "lilypond.xml", new LilypondLang() );
        map.put( "lisp.xml", new LispLang() );
        map.put( "literate_haskell.xml", new LiterateHaskellLang() );
        map.put( "logs.xml", new LogsLang() );
        map.put( "logtalk.xml", new LogtalkLang() );
        map.put( "lotos.xml", new LotosLang() );
        map.put( "lua.xml", new LuaLang() );
        map.put( "macroscheduler.xml", new MacroschedulerLang() );
        map.put( "mail.xml", new MailLang() );
        map.put( "makefile.xml", new MakefileLang() );
        map.put( "maple.xml", new MapleLang() );
        map.put( "markdown.xml", new MarkdownLang() );
        map.put( "maven.xml", new MavenLang() );
        map.put( "ml.xml", new MlLang() );
        map.put( "modula3.xml", new Modula3Lang() );
        map.put( "moin.xml", new MoinLang() );
        map.put( "mpost.xml", new MpostLang() );
        map.put( "mqsc.xml", new MqscLang() );
        map.put( "mxml.xml", new MxmlLang() );
        map.put( "myghty.xml", new MyghtyLang() );
        map.put( "mysql.xml", new MysqlLang() );
        map.put( "n3.xml", new N3Lang() );
        map.put( "netrexx.xml", new NetrexxLang() );
        map.put( "nqc.xml", new NqcLang() );
        map.put( "nsis2.xml", new Nsis2Lang() );
        map.put( "objective_c.xml", new ObjectiveCLang() );
        map.put( "objectrexx.xml", new ObjectrexxLang() );
        map.put( "occam.xml", new OccamLang() );
        map.put( "omnimark.xml", new OmnimarkLang() );
        map.put( "osql.xml", new OsqlLang() );
        map.put( "outline.xml", new OutlineLang() );
        map.put( "pascal.xml", new PascalLang() );
        map.put( "patch.xml", new PatchLang() );
        map.put( "perl.xml", new PerlLang() );
        map.put( "pg_sql.xml", new PgSqlLang() );
        map.put( "php.xml", new PhpLang() );
        map.put( "pike.xml", new PikeLang() );
        map.put( "pl1.xml", new Pl1Lang() );
        map.put( "pl_sql.xml", new PlSqlLang() );
        map.put( "plaintex.xml", new PlaintexLang() );
        map.put( "pop11.xml", new Pop11Lang() );
        map.put( "postscript.xml", new PostscriptLang() );
        map.put( "povray.xml", new PovrayLang() );
        map.put( "powercenter_parameter_file.xml", new PowercenterParameterFileLang() );
        map.put( "powerdynamo.xml", new PowerdynamoLang() );
        map.put( "powershell.xml", new PowershellLang() );
        map.put( "progress.xml", new ProgressLang() );
        map.put( "prolog.xml", new PrologLang() );
        map.put( "props.xml", new PropsLang() );
        map.put( "psp.xml", new PspLang() );
        map.put( "ptl.xml", new PtlLang() );
        map.put( "pure.xml", new PureLang() );
        map.put( "pvwave.xml", new PvwaveLang() );
        map.put( "pyrex.xml", new PyrexLang() );
        map.put( "python.xml", new PythonLang() );
        map.put( "r.xml", new RLang() );
        map.put( "rcp.xml", new RcpLang() );
        map.put( "rd.xml", new RdLang() );
        map.put( "rebol.xml", new RebolLang() );
        map.put( "redcode.xml", new RedcodeLang() );
        map.put( "regex.xml", new RegexLang() );
        map.put( "relax_ng_compact.xml", new RelaxNgCompactLang() );
        map.put( "rest.xml", new RestLang() );
        map.put( "rfc.xml", new RfcLang() );
        map.put( "rhtml.xml", new RhtmlLang() );
        map.put( "rib.xml", new RibLang() );
        map.put( "roff.xml", new RoffLang() );
        map.put( "rpmspec.xml", new RpmspecLang() );
        map.put( "rtf.xml", new RtfLang() );
        map.put( "ruby.xml", new RubyLang() );
        map.put( "rust.xml", new RustLang() );
        map.put( "rview.xml", new RviewLang() );
        map.put( "sas.xml", new SasLang() );
        map.put( "scala.xml", new ScalaLang() );
        map.put( "scheme.xml", new SchemeLang() );
        map.put( "sdl_pr.xml", new SdlPrLang() );
        map.put( "sgml.xml", new SgmlLang() );
        map.put( "shellscript.xml", new ShellscriptLang() );
        map.put( "shtml.xml", new ShtmlLang() );
        map.put( "sip.xml", new SipLang() );
        map.put( "slate.xml", new SlateLang() );
        map.put( "slax.xml", new SlaxLang() );
        map.put( "smalltalk.xml", new SmalltalkLang() );
        map.put( "smarty.xml", new SmartyLang() );
        map.put( "smi_mib.xml", new SmiMibLang() );
        map.put( "splus.xml", new SplusLang() );
        map.put( "sql_loader.xml", new SqlLoaderLang() );
        map.put( "sqr.xml", new SqrLang() );
        map.put( "squidconf.xml", new SquidconfLang() );
        map.put( "ssharp.xml", new SsharpLang() );
        map.put( "stata.xml", new StataLang() );
        map.put( "svn_commit.xml", new SvnCommitLang() );
        map.put( "swig.xml", new SwigLang() );
        map.put( "tcl.xml", new TclLang() );
        map.put( "tex.xml", new TexLang() );
        map.put( "texinfo.xml", new TexinfoLang() );
        map.put( "text.xml", new TextLang() );
        map.put( "tld.xml", new TldLang() );
        map.put( "tpl.xml", new TplLang() );
        map.put( "tsp.xml", new TspLang() );
        map.put( "tsql.xml", new TsqlLang() );
        map.put( "tthtml.xml", new TthtmlLang() );
        map.put( "turbobasic.xml", new TurbobasicLang() );
        map.put( "twiki.xml", new TwikiLang() );
        map.put( "typoscript.xml", new TyposcriptLang() );
        map.put( "url.xml", new UrlLang() );
        map.put( "uscript.xml", new UscriptLang() );
        map.put( "vala.xml", new ValaLang() );
        map.put( "vbscript.xml", new VbscriptLang() );
        map.put( "velocity.xml", new VelocityLang() );
        map.put( "velocity_pure.xml", new VelocityPureLang() );
        map.put( "verilog.xml", new VerilogLang() );
        map.put( "vhdl.xml", new VhdlLang() );
        map.put( "visualbasic.xml", new VisualbasicLang() );
        map.put( "vrml2.xml", new Vrml2Lang() );
        map.put( "xml.xml", new XmlLang() );
        map.put( "xq.xml", new XqLang() );
        map.put( "xsl.xml", new XslLang() );
        map.put( "yab.xml", new YabLang() );
        map.put( "yaml.xml", new YamlLang() );
        map.put( "zpt.xml", new ZptLang() );

    }
}
