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
public class HtaccessLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-";
        PROPERTY2.NAME = "noWordSep";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "true";
        PROPERTY3.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "FALSE";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "DIRECTIVE";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        END END2 = new END();
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"AcceptPathInfo", "Action", "AddAlt", "AddAltByEncoding", "AddAltByType", "AddCharset", "AddDefaultCharset", "AddDescription", "AddEncoding", "AddHandler", "AddIcon", "AddIconByEncoding", "AddIconByType", "AddInputFilter", "AddLanguage", "AddOutputFilter", "AddOutputFilterByType", "AddType", "Allow", "Anonymous", "Anonymous_Authoritative", "Anonymous_LogEmail", "Anonymous_MustGiveEmail", "Anonymous_NoUserID", "Anonymous_VerifyEmail", "AuthAuthoritative", "AuthBasicAuthoritative", "AuthBasicProvider", "AuthDBMAuthoritative", "AuthDBMGroupFile", "AuthDBMType", "AuthDBMUserFile", "AuthDigestAlgorithm", "AuthDigestDomain", "AuthDigestFile", "AuthDigestGroupFile", "AuthDigestNonceFormat", "AuthDigestNonceLifetime", "AuthDigestQop", "AuthGroupFile", "AuthLDAPAuthoritative", "AuthLDAPBindDN", "AuthLDAPBindPassword", "AuthLDAPCompareDNOnServer", "AuthLDAPDereferenceAliases", "AuthLDAPEnabled", "AuthLDAPFrontPageHack", "AuthLDAPGroupAttribute", "AuthLDAPGroupAttributeIsDN", "AuthLDAPRemoteUserIsDN", "AuthLDAPUrl", "AuthName", "AuthType", "AuthUserFile", "BrowserMatch", "BrowserMatchNoCase", "CGIMapExtension", "CharsetDefault", "CharsetOptions", "CharsetSourceEnc", "CheckSpelling", "ContentDigest", "CookieDomain", "CookieExpires", "CookieName", "CookieStyle", "CookieTracking", "DefaultIcon", "DefaultLanguage", "DefaultType", "Deny", "DirectoryIndex", "DirectorySlash", "EnableMMAP", "EnableSendfile", "ErrorDocument", "Example", "ExpiresActive", "ExpiresByType", "ExpiresDefault", "FileETag", "ForceLanguagePriority", "ForceType", "Header", "HeaderName", "ImapBase", "ImapDefault", "ImapMenu", "IndexIgnore", "IndexOptions", "IndexOrderDefault", "ISAPIAppendLogToErrors", "ISAPIAppendLogToQuery", "ISAPIFakeAsync", "ISAPILogNotSupported", "ISAPIReadAheadBuffer", "LanguagePriority", "LimitRequestBody", "LimitXMLRequestBody", "MetaDir", "MetaFiles", "MetaSuffix", "MultiviewsMatch", "Options", "Order", "PassEnv", "ReadmeName", "Redirect", "RedirectMatch", "RedirectPermanent", "RedirectTemp", "RemoveCharset", "RemoveEncoding", "RemoveHandler", "RemoveInputFilter", "RemoveLanguage", "RemoveOutputFilter", "RemoveType", "RequestHeader", "Require", "RewriteBase", "RewriteCond", "RewriteEngine", "RewriteOptions", "RewriteRule", "RLimitCPU", "RLimitMEM", "RLimitNPROC", "Satisfy", "ScriptInterpreterSource", "ServerSignature", "SetEnv", "SetEnvIf", "SetEnvIfNoCase", "SetHandler", "SetInputFilter", "SetOutputFilter", "SSIErrorMsg", "SSITimeFormat", "SSLCipherSuite", "SSLOptions", "SSLProxyCipherSuite", "SSLProxyVerify", "SSLProxyVerifyDepth", "SSLRequire", "SSLRequireSSL", "SSLUserName", "SSLVerifyClient", "SSLVerifyDepth", "UnsetEnv", "XBitHack", });
        KEYWORDS1.add("LITERAL3", new String[]{"Basic", "Digest", "None", "Off", "On", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES2() {
        RULES RULES1 = new RULES();
        RULES1.SET = "DIRECTIVE";
        RULES1.DEFAULT = "NULL";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT2";
        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "\"";
        END END1 = new END();
        END1.text = "\"";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "DIRECTIVE";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN2 = new BEGIN();
        END END2 = new END();
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"All", "ExecCGI", "FollowSymLinks", "Includes", "IncludesNOEXEC", "Indexes", "MultiViews", "None", "Off", "On", "SymLinksIfOwnerMatch", "from", });
        KEYWORDS1.add("KEYWORD1", new String[]{"DirectorySlash", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AcceptMutex", "AcceptPathInfo", "AccessFileName", "Action", "AddAlt", "AddAltByEncoding", "AddAltByType", "AddCharset", "AddDefaultCharset", "AddDescription", "AddEncoding", "AddHandler", "AddIcon", "AddIconByEncoding", "AddIconByType", "AddInputFilter", "AddLanguage", "AddModuleInfo", "AddOutputFilter", "AddOutputFilterByType", "AddType", "Alias", "AliasMatch", "Allow", "AllowCONNECT", "AllowEncodedSlashes", "AllowOverride", "Anonymous", "Anonymous_Authoritative", "Anonymous_LogEmail", "Anonymous_MustGiveEmail", "Anonymous_NoUserID", "Anonymous_VerifyEmail", "AuthAuthoritative", "AuthBasicAuthoritative", "AuthBasicProvider", "AuthDBMAuthoritative", "AuthDBMGroupFile", "AuthDBMType", "AuthDBMUserFile", "AuthDigestAlgorithm", "AuthDigestDomain", "AuthDigestFile", "AuthDigestGroupFile", "AuthDigestNcCheck", "AuthDigestNonceFormat", "AuthDigestNonceLifetime", "AuthDigestQop", "AuthDigestShmemSize", "AuthGroupFile", "AuthLDAPAuthoritative", "AuthLDAPBindDN", "AuthLDAPBindPassword", "AuthLDAPCharsetConfig", "AuthLDAPCompareDNOnServer", "AuthLDAPDereferenceAliases", "AuthLDAPEnabled", "AuthLDAPFrontPageHack", "AuthLDAPGroupAttribute", "AuthLDAPGroupAttributeIsDN", "AuthLDAPRemoteUserIsDN", "AuthLDAPUrl", "AuthName", "AuthType", "AuthUserFile", "BS2000Account", "BrowserMatch", "BrowserMatchNoCase", "CGIMapExtension", "CacheDefaultExpire", "CacheDirLength", "CacheDirLevels", "CacheDisable", "CacheEnable", "CacheExpiryCheck", "CacheFile", "CacheForceCompletion", "CacheGcClean", "CacheGcDaily", "CacheGcInterval", "CacheGcMemUsage", "CacheGcUnused", "CacheIgnoreCacheControl", "CacheIgnoreNoLastMod", "CacheLastModifiedFactor", "CacheMaxExpire", "CacheMaxFileSize", "CacheMinFileSize", "CacheNegotiatedDocs", "CacheRoot", "CacheSize", "CacheTimeMargin", "CharsetDefault", "CharsetOptions", "CharsetSourceEnc", "CheckSpelling", "ChildPerUserID", "ContentDigest", "CookieDomain", "CookieExpires", "CookieLog", "CookieName", "CookieStyle", "CookieTracking", "CoreDumpDirectory", "CustomLog", "Dav", "DavDepthInfinity", "DavLockDB", "DavMinTimeout", "DefaultIcon", "DefaultLanguage", "DefaultType", "DeflateBufferSize", "DeflateCompressionLevel", "DeflateFilterNote", "DeflateMemLevel", "DeflateWindowSize", "Deny", "DirectoryIndex", "DocumentRoot", "EnableMMAP", "EnableSendfile", "ErrorDocument", "ErrorLog", "Example", "ExpiresActive", "ExpiresByType", "ExpiresDefault", "ExtFilterDefine", "ExtFilterOptions", "ExtendedStatus", "FileETag", "ForceLanguagePriority", "ForceType", "Group", "Header", "HeaderName", "HostnameLookups", "ISAPIAppendLogToErrors", "ISAPIAppendLogToQuery", "ISAPICacheFile", "ISAPIFakeAsync", "ISAPILogNotSupported", "ISAPIReadAheadBuffer", "IdentityCheck", "ImapBase", "ImapDefault", "ImapMenu", "Include", "IndexIgnore", "IndexOptions", "IndexOrderDefault", "KeepAlive", "KeepAliveTimeout", "LDAPCacheEntries", "LDAPCacheTTL", "LDAPOpCacheEntries", "LDAPOpCacheTTL", "LDAPSharedCacheSize", "LDAPTrustedCA", "LDAPTrustedCAType", "LanguagePriority", "LimitInternalRecursion", "LimitRequestBody", "LimitRequestFields", "LimitRequestFieldsize", "LimitRequestLine", "LimitXMLRequestBody", "Listen", "ListenBacklog", "LoadFile", "LoadModule", "LockFile", "LogFormat", "LogLevel", "MCacheMaxObjectCount", "MCacheMaxObjectSize", "MCacheMaxStreamingBuffer", "MCacheMinObjectSize", "MCacheRemovalAlgorithm", "MCacheSize", "MMapFile", "MaxClients", "MaxKeepAliveRequests", "MaxMemFree", "MaxRequestsPerChild", "MaxRequestsPerThread", "MaxSpareServers", "MaxSpareThreads", "MaxThreads", "MaxThreadsPerChild", "MetaDir", "MetaFiles", "MetaSuffix", "MimeMagicFile", "MinSpareServers", "MinSpareThreads", "ModMimeUsePathInfo", "MultiviewsMatch", "NWSSLTrustedCerts", "NameVirtualHost", "NoProxy", "NumServers", "Options", "Order", "PassEnv", "PidFile", "ProtocolEcho", "ProxyBadHeader", "ProxyBlock", "ProxyDomain", "ProxyErrorOverride", "ProxyIOBufferSize", "ProxyMaxForwards", "ProxyPass", "ProxyPassReverse", "ProxyPreserveHost", "ProxyReceiveBufferSize", "ProxyRemote", "ProxyRemoteMatch", "ProxyRequests", "ProxyTimeout", "ProxyVia", "RLimitCPU", "RLimitMEM", "RLimitNPROC", "ReadmeName", "Redirect", "RedirectMatch", "RedirectPermanent", "RedirectTemp", "RemoveCharset", "RemoveEncoding", "RemoveHandler", "RemoveInputFilter", "RemoveLanguage", "RemoveOutputFilter", "RemoveType", "RequestHeader", "Require", "RewriteBase", "RewriteCond", "RewriteEngine", "RewriteLock", "RewriteLog", "RewriteLogLevel", "RewriteMap", "RewriteOptions", "RewriteRule", "SSIEndTag", "SSIErrorMsg", "SSIStartTag", "SSITimeFormat", "SSIUndefinedEcho", "SSLCACertificateFile", "SSLCACertificatePath", "SSLCARevocationFile", "SSLCARevocationPath", "SSLCertificateChainFile", "SSLCertificateFile", "SSLCertificateKeyFile", "SSLCipherSuite", "SSLEngine", "SSLMutex", "SSLOptions", "SSLPassPhraseDialog", "SSLProtocol", "SSLProxyCACertificateFile", "SSLProxyCACertificatePath", "SSLProxyCARevocationFile", "SSLProxyCARevocationPath", "SSLProxyCipherSuite", "SSLProxyEngine", "SSLProxyMachineCertificateFile", "SSLProxyMachineCertificatePath", "SSLProxyProtocol", "SSLProxyVerify", "SSLProxyVerifyDepth", "SSLRandomSeed", "SSLRequire", "SSLRequireSSL", "SSLSessionCache", "SSLSessionCacheTimeout", "SSLVerifyClient", "SSLVerifyDepth", "Satisfy", "ScoreBoardFile", "Script", "ScriptAlias", "ScriptAliasMatch", "ScriptInterpreterSource", "ScriptLog", "ScriptLogBuffer", "ScriptLogLength", "ScriptSock", "SecureListen", "SendBufferSize", "ServerAdmin", "ServerLimit", "ServerName", "ServerRoot", "ServerSignature", "ServerTokens", "SetEnv", "SetEnvIf", "SetEnvIfNoCase", "SetHandler", "SetInputFilter", "SetOutputFilter", "StartServers", "StartThreads", "SuexecUserGroup", "ThreadLimit", "ThreadStackSize", "ThreadsPerChild", "TimeOut", "TransferLog", "TypesConfig", "UnsetEnv", "UseCanonicalName", "User", "UserDir", "VirtualDocumentRoot", "VirtualDocumentRootIP", "VirtualScriptAlias", "VirtualScriptAliasIP", "XBitHack", });
        KEYWORDS1.add("KEYWORD3", new String[]{"SVNPath", "SVNParentPath", "SVNIndexXSLT", "PythonHandler", "PythonDebug", "php_value", });
        KEYWORDS1.add("KEYWORD4", new String[]{"AddModule", "ClearModuleList", "php_flag", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), RULES2(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
