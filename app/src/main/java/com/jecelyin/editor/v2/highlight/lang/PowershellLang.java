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

package com.jecelyin.editor.v2.highlight.lang;

import com.jecelyin.editor.v2.highlight.LangDefine;
import com.jecelyin.editor.v2.highlight.syntax.*;
/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class PowershellLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "<#";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "#>";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "#";
        PROPERTY3.NAME = "lineComment";
        PROPERTY PROPERTY4 = new PROPERTY();
        PROPERTY4.VALUE = "{";
        PROPERTY4.NAME = "indentOpenBrackets";
        PROPERTY PROPERTY5 = new PROPERTY();
        PROPERTY5.VALUE = "}";
        PROPERTY5.NAME = "indentCloseBrackets";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, PROPERTY4, PROPERTY5, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PS_OPERATOR";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "-eq";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "-ne";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "-gt";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "-ge";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "-lt";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "-le";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "-ieq";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "-ine";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "-igt";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "-ige";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "-ilt";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "-ile";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "-ceq";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "-cne";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "-cgt";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "-cge";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "-clt";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "-cle";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "-like";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "-notlike";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "-match";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "-notmatch";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "-ilike";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "-inotlike";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "-imatch";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "-inotmatch";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "-clike";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "-cnotlike";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "-cmatch";
        SEQ29.TYPE = "OPERATOR";
        SEQ SEQ30 = new SEQ();
        SEQ30.text = "-cnotmatch";
        SEQ30.TYPE = "OPERATOR";
        SEQ SEQ31 = new SEQ();
        SEQ31.text = "-contains";
        SEQ31.TYPE = "OPERATOR";
        SEQ SEQ32 = new SEQ();
        SEQ32.text = "-notcontains";
        SEQ32.TYPE = "OPERATOR";
        SEQ SEQ33 = new SEQ();
        SEQ33.text = "-icontains";
        SEQ33.TYPE = "OPERATOR";
        SEQ SEQ34 = new SEQ();
        SEQ34.text = "-inotcontains";
        SEQ34.TYPE = "OPERATOR";
        SEQ SEQ35 = new SEQ();
        SEQ35.text = "-ccontains";
        SEQ35.TYPE = "OPERATOR";
        SEQ SEQ36 = new SEQ();
        SEQ36.text = "-cnotcontains";
        SEQ36.TYPE = "OPERATOR";
        SEQ SEQ37 = new SEQ();
        SEQ37.text = "-isnot";
        SEQ37.TYPE = "OPERATOR";
        SEQ SEQ38 = new SEQ();
        SEQ38.text = "-is";
        SEQ38.TYPE = "OPERATOR";
        SEQ SEQ39 = new SEQ();
        SEQ39.text = "-as";
        SEQ39.TYPE = "OPERATOR";
        SEQ SEQ40 = new SEQ();
        SEQ40.text = "-replace";
        SEQ40.TYPE = "OPERATOR";
        SEQ SEQ41 = new SEQ();
        SEQ41.text = "-ireplace";
        SEQ41.TYPE = "OPERATOR";
        SEQ SEQ42 = new SEQ();
        SEQ42.text = "-creplace";
        SEQ42.TYPE = "OPERATOR";
        SEQ SEQ43 = new SEQ();
        SEQ43.text = "-and";
        SEQ43.TYPE = "OPERATOR";
        SEQ SEQ44 = new SEQ();
        SEQ44.text = "-or";
        SEQ44.TYPE = "OPERATOR";
        SEQ SEQ45 = new SEQ();
        SEQ45.text = "-band";
        SEQ45.TYPE = "OPERATOR";
        SEQ SEQ46 = new SEQ();
        SEQ46.text = "-bor";
        SEQ46.TYPE = "OPERATOR";
        SEQ SEQ47 = new SEQ();
        SEQ47.text = "-not";
        SEQ47.TYPE = "OPERATOR";
        SEQ SEQ48 = new SEQ();
        SEQ48.text = "-bnot";
        SEQ48.TYPE = "OPERATOR";
        SEQ SEQ49 = new SEQ();
        SEQ49.text = "-f";
        SEQ49.TYPE = "OPERATOR";
        SEQ SEQ50 = new SEQ();
        SEQ50.text = "-xor";
        SEQ50.TYPE = "OPERATOR";
        SEQ SEQ51 = new SEQ();
        SEQ51.text = "-bxor";
        SEQ51.TYPE = "OPERATOR";
        SEQ SEQ52 = new SEQ();
        SEQ52.text = "+=";
        SEQ52.TYPE = "OPERATOR";
        SEQ SEQ53 = new SEQ();
        SEQ53.text = "-=";
        SEQ53.TYPE = "OPERATOR";
        SEQ SEQ54 = new SEQ();
        SEQ54.text = "*=";
        SEQ54.TYPE = "OPERATOR";
        SEQ SEQ55 = new SEQ();
        SEQ55.text = "/=";
        SEQ55.TYPE = "OPERATOR";
        SEQ SEQ56 = new SEQ();
        SEQ56.text = "%=";
        SEQ56.TYPE = "OPERATOR";
        SEQ SEQ57 = new SEQ();
        SEQ57.text = "--";
        SEQ57.TYPE = "OPERATOR";
        SEQ SEQ58 = new SEQ();
        SEQ58.text = "++";
        SEQ58.TYPE = "OPERATOR";
        SEQ SEQ59 = new SEQ();
        SEQ59.text = "+";
        SEQ59.TYPE = "OPERATOR";
        SEQ SEQ60 = new SEQ();
        SEQ60.text = "*";
        SEQ60.TYPE = "OPERATOR";
        SEQ SEQ61 = new SEQ();
        SEQ61.text = "/";
        SEQ61.TYPE = "OPERATOR";
        SEQ SEQ62 = new SEQ();
        SEQ62.text = "%";
        SEQ62.TYPE = "OPERATOR";
        SEQ SEQ63 = new SEQ();
        SEQ63.text = "=";
        SEQ63.TYPE = "OPERATOR";
        SEQ SEQ64 = new SEQ();
        SEQ64.text = "!";
        SEQ64.TYPE = "OPERATOR";
        SEQ SEQ65 = new SEQ();
        SEQ65.text = "`";
        SEQ65.TYPE = "OPERATOR";
        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, SEQ30, SEQ31, SEQ32, SEQ33, SEQ34, SEQ35, SEQ36, SEQ37, SEQ38, SEQ39, SEQ40, SEQ41, SEQ42, SEQ43, SEQ44, SEQ45, SEQ46, SEQ47, SEQ48, SEQ49, SEQ50, SEQ51, SEQ52, SEQ53, SEQ54, SEQ55, SEQ56, SEQ57, SEQ58, SEQ59, SEQ60, SEQ61, SEQ62, SEQ63, SEQ64, SEQ65, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "PS_PREVAR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD2", new String[]{"$foreach", "$LastExitCode", "$Match", "$OFS", "$StackTrace", "$Error", "$DebugPreference", "$PROFILE", "$HOME", "$Host", "$MaximumHistoryCount", "$MaximumAliasCount", "$input", "$ReportErrorShowSource", "$ExecutionContext", "$true", "$VerbosePreference", "$ShellId", "$false", "$switch", "$null", "$MaximumFunctionCount", "$line", "$ConsoleFileName", "$ReportErrorShowStackTrace", "$FormatEnumerationLimit", "$PSHOME", "$lastWord", "$MyInvocation", "$PWD", "$ReportErrorShowExceptionClass", "$ProgressPreference", "$ErrorActionPreference", "$args", "$MaximumErrorCount", "$NestedPromptLevel", "$WhatIfPreference", "$ReportErrorShowInnerException", "$ErrorView", "$WarningPreference", "$PID", "$ConfirmPreference", "$MaximumDriveCount", "$MaximumVariableCount", "$this", "$$", "$^", "$_", "$?", });
        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.DIGIT_RE = "[0-9][0-9a-zA-Z]*";
        RULES1.NO_WORD_SEP = "-";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT2";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "<#";
        END END1 = new END();
        END1.text = "#>";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SEQ_REGEXP SEQ_REGEXP1 = new SEQ_REGEXP();
        SEQ_REGEXP1.text = "[\\$]+[a-zA-Z_\\x7f-\\xff][a-zA-Z0-9_\\x7f-\\xff]*";
        SEQ_REGEXP1.TYPE = "KEYWORD2";
        SEQ_REGEXP1.HASH_CHAR = "$";
        IMPORT IMPORT1 = new IMPORT();
        IMPORT1.DELEGATE = "PS_PREVAR";
        IMPORT IMPORT2 = new IMPORT();
        IMPORT2.DELEGATE = "PS_OPERATOR";
        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL4";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SEQ SEQ1 = new SEQ();
        SEQ1.text = ",";
        SEQ1.TYPE = "MARKUP";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = ".";
        SEQ2.TYPE = "MARKUP";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "::";
        SEQ3.TYPE = "MARKUP";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "|";
        SEQ4.TYPE = "MARKUP";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "{";
        SEQ5.TYPE = "MARKUP";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "}";
        SEQ6.TYPE = "MARKUP";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ">";
        SEQ7.TYPE = "MARKUP";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ">>";
        SEQ8.TYPE = "MARKUP";
        SPAN SPAN4 = new SPAN();
        SPAN4.TYPE = "LABEL";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "[";
        END END4 = new END();
        END4.text = "]";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "MARKUP";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = ")";
        SEQ9.TYPE = "MARKUP";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"begin", "break", "catch", "continue", "default", "do", "else", "elseif", "end", "filter", "finally", "for", "foreach", "function", "if", "in", "param", "process", "return", "switch", "throw", "trap", "try", "until", "where", "while", "ref", });
        KEYWORDS1.add("KEYWORD3", new String[]{"Add-Computer", "Add-Content", "Add-History", "Add-Member", "Add-PSSnapin", "Add-Type", "Checkpoint-Computer", "Clear-Content", "Clear-EventLog", "Clear-History", "Clear-Item", "Clear-ItemProperty", "Clear-Variable", "Compare-Object", "Complete-Transaction", "Connect-WSMan", "ConvertFrom-Csv", "ConvertFrom-SecureString", "ConvertFrom-StringData", "Convert-Path", "ConvertTo-Csv", "ConvertTo-Html", "ConvertTo-SecureString", "ConvertTo-Xml", "Copy-Item", "Copy-ItemProperty", "Debug-Process", "Disable-ComputerRestore", "Disable-PSBreakpoint", "Disable-PSSessionConfiguration", "Disable-WSManCredSSP", "Disconnect-WSMan", "Enable-ComputerRestore", "Enable-PSBreakpoint", "Enable-PSSessionConfiguration", "Enable-WSManCredSSP", "Enter-PSSession", "Exit-PSSession", "Export-Alias", "Export-Clixml", "Export-Console", "Export-Counter", "Export-Csv", "Export-FormatData", "Export-ModuleMember", "Export-PSSession", "ForEach-Object", "Format-Custom", "Format-List", "Format-Table", "Format-Wide", "Get-Acl", "Get-Alias", "Get-AuthenticodeSignature", "Get-ChildItem", "Get-Command", "Get-ComputerRestorePoint", "Get-Content", "Get-Counter", "Get-Credential", "Get-Culture", "Get-Date", "Get-Event", "Get-EventLog", "Get-EventSubscriber", "Get-ExecutionPolicy", "Get-FormatData", "Get-Help", "Get-History", "Get-Host", "Get-HotFix", "Get-Item", "Get-ItemProperty", "Get-Job", "Get-Location", "Get-Member", "Get-Module", "Get-PfxCertificate", "Get-Process", "Get-PSBreakpoint", "Get-PSCallStack", "Get-PSDrive", "Get-PSProvider", "Get-PSSession", "Get-PSSessionConfiguration", "Get-PSSnapin", "Get-Random", "Get-Service", "Get-TraceSource", "Get-Transaction", "Get-UICulture", "Get-Unique", "Get-Variable", "Get-WinEvent", "Get-WmiObject", "Get-WSManCredSSP", "Get-WSManInstance", "Group-Object", "Import-Alias", "Import-Clixml", "Import-Counter", "Import-Csv", "Import-LocalizedData", "Import-Module", "Import-PSSession", "Invoke-Command", "Invoke-Expression", "Invoke-History", "Invoke-Item", "Invoke-WmiMethod", "Invoke-WSManAction", "Join-Path", "Limit-EventLog", "Measure-Command", "Measure-Object", "Move-Item", "Move-ItemProperty", "New-Alias", "New-Event", "New-EventLog", "New-Item", "New-ItemProperty", "New-Module", "New-ModuleManifest", "New-Object", "New-PSDrive", "New-PSSession", "New-Service", "New-TimeSpan", "New-Variable", "New-WebServiceProxy", "New-WSManInstance", "New-WSManSessionOption", "Out-Default", "Out-File", "Out-GridView", "Out-Host", "Out-Null", "Out-Printer", "Out-String", "Pop-Location", "Push-Location", "Read-Host", "Receive-Job", "Register-EngineEvent", "Register-ObjectEvent", "Register-PSSessionConfiguration", "Register-WmiEvent", "Remove-Computer", "Remove-Event", "Remove-EventLog", "Remove-Item", "Remove-ItemProperty", "Remove-Job", "Remove-Module", "Remove-PSBreakpoint", "Remove-PSDrive", "Remove-PSSession", "Remove-PSSnapin", "Remove-Variable", "Remove-WmiObject", "Remove-WSManInstance", "Rename-Computer", "Rename-Item", "Rename-ItemProperty", "Reset-ComputerMachinePassword", "Resolve-Path", "Restart-Computer", "Restart-Service", "Restore-Computer", "Resume-Service", "Select-Object", "Select-String", "Select-Xml", "Send-MailMessage", "Set-Acl", "Set-Alias", "Set-AuthenticodeSignature", "Set-Content", "Set-Date", "Set-ExecutionPolicy", "Set-Item", "Set-ItemProperty", "Set-Location", "Set-PSBreakpoint", "Set-PSDebug", "Set-PSSessionConfiguration", "Set-Service", "Set-StrictMode", "Set-TraceSource", "Set-Variable", "Set-WmiInstance", "Set-WSManInstance", "Set-WSManQuickConfig", "Show-EventLog", "Sort-Object", "Split-Path", "Start-Job", "Start-Process", "Start-Service", "Start-Sleep", "Start-Transaction", "Start-Transcript", "Stop-Computer", "Stop-Job", "Stop-Process", "Stop-Service", "Stop-Transcript", "Suspend-Service", "Tee-Object", "Test-ComputerSecureChannel", "Test-Connection", "Test-ModuleManifest", "Test-Path", "Test-WSMan", "Trace-Command", "Undo-Transaction", "Unregister-Event", "Unregister-PSSessionConfiguration", "Update-FormatData", "Update-List", "Update-TypeData", "Use-Transaction", "Wait-Event", "Wait-Job", "Wait-Process", "Where-Object", "Write-Debug", "Write-Error", "Write-EventLog", "Write-Host", "Write-Output", "Write-Progress", "Write-Verbose", "Write-Warning", "ac", "asnp", "cat", "cd", "chdir", "clc", "clear", "clhy", "cli", "clp", "cls", "clv", "compare", "copy", "cp", "cpi", "cpp", "cvpa", "dbp", "del", "diff", "dir", "ebp", "echo", "emm", "epal", "epcsv", "EPSN", "erase", "ETSN", "EXSN", "fc", "fl", "ft", "fw", "gal", "gbp", "gc", "gci", "gcm", "gcs", "gdr", "ghy", "gi", "gjb", "gl", "gm", "gmo", "gp", "gps", "grid", "group", "gsn", "gsnp", "gsv", "gu", "gv", "gwmi", "h", "history", "icm", "iex", "ihy", "ii", "imo", "ipal", "ipcsv", "IPSN", "iwmi", "kill", "lp", "ls", "man", "md", "measure", "mi", "mount", "move", "mp", "mv", "nal", "ndr", "ni", "nmo", "nsn", "nv", "ogv", "oh", "popd", "ps", "pushd", "pwd", "r", "rbp", "rcjb", "rd", "rdr", "ren", "ri", "rjb", "rm", "rmdir", "rni", "rnp", "rp", "rsn", "rsnp", "rv", "rvpa", "rwmi", "sajb", "sal", "sasv", "sbp", "sc", "select", "set", "si", "sl", "sleep", "sort", "sp", "spjb", "spps", "spsv", "start", "sv", "swmi", "tee", "type", "wjb", "write", });
        RULES1.IMPORT = new IMPORT[] { IMPORT1, IMPORT2, };

        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, };

        RULES1.SEQ_REGEXP = new SEQ_REGEXP[] { SEQ_REGEXP1, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), RULES3(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
