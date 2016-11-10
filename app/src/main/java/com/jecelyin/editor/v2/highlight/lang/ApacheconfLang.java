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
public class ApacheconfLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "-";
        PROPERTY2.NAME = "noWordSep";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

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
        SPAN_REGEXP1.DELEGATE = "VHOST";
        SPAN_REGEXP1.HASH_CHAR = "<VirtualHost";
        BEGIN BEGIN2 = new BEGIN();
        END END2 = new END();
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "MARKUP";
        SPAN_REGEXP2.DELEGATE = "DIRECTIVE";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN3 = new BEGIN();
        END END3 = new END();
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"Off", "On", "None", });
        KEYWORDS1.add("KEYWORD1", new String[]{"AcceptMutex", "AcceptPathInfo", "AccessFileName", "Action", "AddAlt", "AddAltByEncoding", "AddAltByType", "AddCharset", "AddDefaultCharset", "AddDescription", "AddEncoding", "AddHandler", "AddIcon", "AddIconByEncoding", "AddIconByType", "AddInputFilter", "AddLanguage", "AddModuleInfo", "AddOutputFilter", "AddOutputFilterByType", "AddType", "Alias", "AliasMatch", "AllowCONNECT", "AllowEncodedSlashes", "AuthDigestNcCheck", "AuthDigestShmemSize", "AuthLDAPCharsetConfig", "BS2000Account", "BrowserMatch", "BrowserMatchNoCase", "CacheDefaultExpire", "CacheDirLength", "CacheDirLevels", "CacheDisable", "CacheEnable", "CacheExpiryCheck", "CacheFile", "CacheForceCompletion", "CacheGcClean", "CacheGcDaily", "CacheGcInterval", "CacheGcMemUsage", "CacheGcUnused", "CacheIgnoreCacheControl", "CacheIgnoreNoLastMod", "CacheLastModifiedFactor", "CacheMaxExpire", "CacheMaxFileSize", "CacheMinFileSize", "CacheNegotiatedDocs", "CacheRoot", "CacheSize", "CacheTimeMargin", "CharsetDefault", "CharsetOptions", "CharsetSourceEnc", "CheckSpelling", "ChildPerUserID", "ContentDigest", "CookieDomain", "CookieExpires", "CookieLog", "CookieName", "CookieStyle", "CookieTracking", "CoreDumpDirectory", "CustomLog", "DavDepthInfinity", "DavLockDB", "DavMinTimeout", "DefaultIcon", "DefaultLanguage", "DefaultType", "DeflateBufferSize", "DeflateCompressionLevel", "DeflateFilterNote", "DeflateMemLevel", "DeflateWindowSize", "DirectoryIndex", "DirectorySlash", "DocumentRoot", "EnableExceptionHook", "EnableMMAP", "EnableSendfile", "ErrorDocument", "ErrorLog", "Example", "ExpiresActive", "ExpiresByType", "ExpiresDefault", "ExtFilterDefine", "ExtendedStatus", "FileETag", "ForceLanguagePriority", "ForensicLog", "Group", "Header", "HeaderName", "HostnameLookups", "ISAPIAppendLogToErrors", "ISAPIAppendLogToQuery", "ISAPICacheFile", "ISAPIFakeAsync", "ISAPILogNotSupported", "ISAPIReadAheadBuffer", "IdentityCheck", "ImapBase", "ImapDefault", "ImapMenu", "Include", "IndexIgnore", "IndexOptions", "IndexOrderDefault", "KeepAlive", "KeepAliveTimeout", "LDAPCacheEntries", "LDAPCacheTTL", "LDAPOpCacheEntries", "LDAPOpCacheTTL", "LDAPSharedCacheFile", "LDAPSharedCacheSize", "LDAPTrustedCA", "LDAPTrustedCAType", "LanguagePriority", "LimitInternalRecursion", "LimitRequestBody", "LimitRequestFields", "LimitRequestFieldsize", "LimitRequestLine", "LimitXMLRequestBody", "Listen", "ListenBacklog", "LoadFile", "LoadModule", "LockFile", "LogFormat", "LogLevel", "MCacheMaxObjectCount", "MCacheMaxObjectSize", "MCacheMaxStreamingBuffer", "MCacheMinObjectSize", "MCacheRemovalAlgorithm", "MCacheSize", "MMapFile", "MaxClients", "MaxKeepAliveRequests", "MaxMemFree", "MaxRequestsPerChild", "MaxRequestsPerThread", "MaxSpareServers", "MaxSpareThreads", "MaxThreads", "MaxThreadsPerChild", "MetaDir", "MetaFiles", "MetaSuffix", "MimeMagicFile", "MinSpareServers", "MinSpareThreads", "MultiviewsMatch", "NWSSLTrustedCerts", "NWSSLUpgradeable", "NameVirtualHost", "NoProxy", "NumServers", "Options", "PassEnv", "PidFile", "ProtocolEcho", "ProxyBadHeader", "ProxyBlock", "ProxyDomain", "ProxyErrorOverride", "ProxyIOBufferSize", "ProxyMaxForwards", "ProxyPass", "ProxyPassReverse", "ProxyPreserveHost", "ProxyReceiveBufferSize", "ProxyRemote", "ProxyRemoteMatch", "ProxyRequests", "ProxyTimeout", "ProxyVia", "RLimitCPU", "RLimitMEM", "RLimitNPROC", "ReadmeName", "Redirect", "RedirectMatch", "RedirectPermanent", "RedirectTemp", "RequestHeader", "RewriteBase", "RewriteCond", "RewriteEngine", "RewriteLock", "RewriteLog", "RewriteLogLevel", "RewriteMap", "RewriteOptions", "RewriteRule", "SSIEndTag", "SSIErrorMsg", "SSIStartTag", "SSITimeFormat", "SSIUndefinedEcho", "SSLCACertificateFile", "SSLCACertificatePath", "SSLCARevocationFile", "SSLCARevocationPath", "SSLCertificateChainFile", "SSLCertificateFile", "SSLCertificateKeyFile", "SSLCipherSuite", "SSLEngine", "SSLMutex", "SSLOptions", "SSLPassPhraseDialog", "SSLProtocol", "SSLProxyCACertificateFile", "SSLProxyCACertificatePath", "SSLProxyCARevocationFile", "SSLProxyCARevocationPath", "SSLProxyCipherSuite", "SSLProxyEngine", "SSLProxyMachineCertificateFile", "SSLProxyMachineCertificatePath", "SSLProxyProtocol", "SSLProxyVerify", "SSLProxyVerifyDepth", "SSLRandomSeed", "SSLSessionCache", "SSLSessionCacheTimeout", "SSLVerifyClient", "SSLVerifyDepth", "ScoreBoardFile", "Script", "ScriptAlias", "ScriptAliasMatch", "ScriptInterpreterSource", "ScriptLog", "ScriptLogBuffer", "ScriptLogLength", "ScriptSock", "SecureListen", "SendBufferSize", "ServerAdmin", "ServerLimit", "ServerName", "ServerRoot", "ServerSignature", "ServerTokens", "SetEnv", "SetEnvIf", "SetEnvIfNoCase", "SetHandler", "SetInputFilter", "SetOutputFilter", "StartServers", "StartThreads", "SuexecUserGroup", "ThreadLimit", "ThreadStackSize", "ThreadsPerChild", "TimeOut", "TransferLog", "TypesConfig", "UnsetEnv", "UseCanonicalName", "User", "UserDir", "VirtualDocumentRoot", "VirtualDocumentRootIP", "VirtualScriptAlias", "VirtualScriptAliasIP", "Win32DisableAcceptEx", "XBitHack", });
        KEYWORDS1.add("KEYWORD4", new String[]{"AddModule", "ClearModuleList", "ServerType", "Port", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

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
        SPAN_REGEXP1.DELEGATE = "VHOST";
        SPAN_REGEXP1.HASH_CHAR = "<VirtualHost";
        BEGIN BEGIN2 = new BEGIN();
        END END2 = new END();
        SPAN_REGEXP1.END = new END[] { END2, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN_REGEXP SPAN_REGEXP2 = new SPAN_REGEXP();
        SPAN_REGEXP2.TYPE = "MARKUP";
        SPAN_REGEXP2.DELEGATE = "DIRECTIVE";
        SPAN_REGEXP2.HASH_CHAR = "<";
        BEGIN BEGIN3 = new BEGIN();
        END END3 = new END();
        SPAN_REGEXP2.END = new END[] { END3, };

        SPAN_REGEXP2.BEGIN = new BEGIN[] { BEGIN3, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"All", "ExecCGI", "FollowSymLinks", "Includes", "IncludesNOEXEC", "Indexes", "MultiViews", "None", "Off", "On", "SymLinksIfOwnerMatch", "from", });
        KEYWORDS1.add("KEYWORD1", new String[]{"DirectorySlash", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AcceptMutex", "AcceptPathInfo", "AccessFileName", "Action", "AddAlt", "AddAltByEncoding", "AddAltByType", "AddCharset", "AddDefaultCharset", "AddDescription", "AddEncoding", "AddHandler", "AddIcon", "AddIconByEncoding", "AddIconByType", "AddInputFilter", "AddLanguage", "AddModuleInfo", "AddOutputFilter", "AddOutputFilterByType", "AddType", "Alias", "AliasMatch", "Allow", "AllowCONNECT", "AllowEncodedSlashes", "AllowOverride", "Anonymous", "Anonymous_Authoritative", "Anonymous_LogEmail", "Anonymous_MustGiveEmail", "Anonymous_NoUserID", "Anonymous_VerifyEmail", "AuthAuthoritative", "AuthDBMAuthoritative", "AuthDBMGroupFile", "AuthDBMType", "AuthDBMUserFile", "AuthDigestAlgorithm", "AuthDigestDomain", "AuthDigestFile", "AuthDigestGroupFile", "AuthDigestNcCheck", "AuthDigestNonceFormat", "AuthDigestNonceLifetime", "AuthDigestQop", "AuthDigestShmemSize", "AuthGroupFile", "AuthLDAPAuthoritative", "AuthLDAPBindDN", "AuthLDAPBindPassword", "AuthLDAPCharsetConfig", "AuthLDAPCompareDNOnServer", "AuthLDAPDereferenceAliases", "AuthLDAPEnabled", "AuthLDAPFrontPageHack", "AuthLDAPGroupAttribute", "AuthLDAPGroupAttributeIsDN", "AuthLDAPRemoteUserIsDN", "AuthLDAPUrl", "AuthName", "AuthType", "AuthUserFile", "BS2000Account", "BrowserMatch", "BrowserMatchNoCase", "CGIMapExtension", "CacheDefaultExpire", "CacheDirLength", "CacheDirLevels", "CacheDisable", "CacheEnable", "CacheExpiryCheck", "CacheFile", "CacheForceCompletion", "CacheGcClean", "CacheGcDaily", "CacheGcInterval", "CacheGcMemUsage", "CacheGcUnused", "CacheIgnoreCacheControl", "CacheIgnoreNoLastMod", "CacheLastModifiedFactor", "CacheMaxExpire", "CacheMaxFileSize", "CacheMinFileSize", "CacheNegotiatedDocs", "CacheRoot", "CacheSize", "CacheTimeMargin", "CharsetDefault", "CharsetOptions", "CharsetSourceEnc", "CheckSpelling", "ChildPerUserID", "ContentDigest", "CookieDomain", "CookieExpires", "CookieLog", "CookieName", "CookieStyle", "CookieTracking", "CoreDumpDirectory", "CustomLog", "Dav", "DavDepthInfinity", "DavLockDB", "DavMinTimeout", "DefaultIcon", "DefaultLanguage", "DefaultType", "DeflateBufferSize", "DeflateCompressionLevel", "DeflateFilterNote", "DeflateMemLevel", "DeflateWindowSize", "Deny", "DirectoryIndex", "DocumentRoot", "EnableMMAP", "EnableSendfile", "ErrorDocument", "ErrorLog", "Example", "ExpiresActive", "ExpiresByType", "ExpiresDefault", "ExtFilterDefine", "ExtFilterOptions", "ExtendedStatus", "FileETag", "ForceLanguagePriority", "ForceType", "Group", "Header", "HeaderName", "HostnameLookups", "ISAPIAppendLogToErrors", "ISAPIAppendLogToQuery", "ISAPICacheFile", "ISAPIFakeAsync", "ISAPILogNotSupported", "ISAPIReadAheadBuffer", "IdentityCheck", "ImapBase", "ImapDefault", "ImapMenu", "Include", "IndexIgnore", "IndexOptions", "IndexOrderDefault", "KeepAlive", "KeepAliveTimeout", "LDAPCacheEntries", "LDAPCacheTTL", "LDAPOpCacheEntries", "LDAPOpCacheTTL", "LDAPSharedCacheSize", "LDAPTrustedCA", "LDAPTrustedCAType", "LanguagePriority", "LimitInternalRecursion", "LimitRequestBody", "LimitRequestFields", "LimitRequestFieldsize", "LimitRequestLine", "LimitXMLRequestBody", "Listen", "ListenBacklog", "LoadFile", "LoadModule", "LockFile", "LogFormat", "LogLevel", "MCacheMaxObjectCount", "MCacheMaxObjectSize", "MCacheMaxStreamingBuffer", "MCacheMinObjectSize", "MCacheRemovalAlgorithm", "MCacheSize", "MMapFile", "MaxClients", "MaxKeepAliveRequests", "MaxMemFree", "MaxRequestsPerChild", "MaxRequestsPerThread", "MaxSpareServers", "MaxSpareThreads", "MaxThreads", "MaxThreadsPerChild", "MetaDir", "MetaFiles", "MetaSuffix", "MimeMagicFile", "MinSpareServers", "MinSpareThreads", "ModMimeUsePathInfo", "MultiviewsMatch", "NWSSLTrustedCerts", "NameVirtualHost", "NoProxy", "NumServers", "Options", "Order", "PassEnv", "PidFile", "ProtocolEcho", "ProxyBadHeader", "ProxyBlock", "ProxyDomain", "ProxyErrorOverride", "ProxyIOBufferSize", "ProxyMaxForwards", "ProxyPass", "ProxyPassReverse", "ProxyPreserveHost", "ProxyReceiveBufferSize", "ProxyRemote", "ProxyRemoteMatch", "ProxyRequests", "ProxyTimeout", "ProxyVia", "RLimitCPU", "RLimitMEM", "RLimitNPROC", "ReadmeName", "Redirect", "RedirectMatch", "RedirectPermanent", "RedirectTemp", "RemoveCharset", "RemoveEncoding", "RemoveHandler", "RemoveInputFilter", "RemoveLanguage", "RemoveOutputFilter", "RemoveType", "RequestHeader", "Require", "RewriteBase", "RewriteCond", "RewriteEngine", "RewriteLock", "RewriteLog", "RewriteLogLevel", "RewriteMap", "RewriteOptions", "RewriteRule", "SSIEndTag", "SSIErrorMsg", "SSIStartTag", "SSITimeFormat", "SSIUndefinedEcho", "SSLCACertificateFile", "SSLCACertificatePath", "SSLCARevocationFile", "SSLCARevocationPath", "SSLCertificateChainFile", "SSLCertificateFile", "SSLCertificateKeyFile", "SSLCipherSuite", "SSLEngine", "SSLMutex", "SSLOptions", "SSLPassPhraseDialog", "SSLProtocol", "SSLProxyCACertificateFile", "SSLProxyCACertificatePath", "SSLProxyCARevocationFile", "SSLProxyCARevocationPath", "SSLProxyCipherSuite", "SSLProxyEngine", "SSLProxyMachineCertificateFile", "SSLProxyMachineCertificatePath", "SSLProxyProtocol", "SSLProxyVerify", "SSLProxyVerifyDepth", "SSLRandomSeed", "SSLRequire", "SSLRequireSSL", "SSLSessionCache", "SSLSessionCacheTimeout", "SSLVerifyClient", "SSLVerifyDepth", "Satisfy", "ScoreBoardFile", "Script", "ScriptAlias", "ScriptAliasMatch", "ScriptInterpreterSource", "ScriptLog", "ScriptLogBuffer", "ScriptLogLength", "ScriptSock", "SecureListen", "SendBufferSize", "ServerAdmin", "ServerLimit", "ServerName", "ServerRoot", "ServerSignature", "ServerTokens", "SetEnv", "SetEnvIf", "SetEnvIfNoCase", "SetHandler", "SetInputFilter", "SetOutputFilter", "StartServers", "StartThreads", "SuexecUserGroup", "ThreadLimit", "ThreadStackSize", "ThreadsPerChild", "TimeOut", "TransferLog", "TypesConfig", "UnsetEnv", "UseCanonicalName", "User", "UserDir", "VirtualDocumentRoot", "VirtualDocumentRootIP", "VirtualScriptAlias", "VirtualScriptAliasIP", "XBitHack", });
        KEYWORDS1.add("KEYWORD3", new String[]{"SVNPath", "SVNParentPath", "SVNIndexXSLT", "PythonHandler", "PythonDebug", });
        KEYWORDS1.add("KEYWORD4", new String[]{"AddModule", "ClearModuleList", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, SPAN_REGEXP2, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    private RULES RULES3() {
        RULES RULES1 = new RULES();
        RULES1.SET = "VHOST";
        RULES1.DEFAULT = "NULL";
        RULES1.IGNORE_CASE = "TRUE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT2";
        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "MARKUP";
        SPAN_REGEXP1.DELEGATE = "DIRECTIVE";
        SPAN_REGEXP1.HASH_CHAR = "<";
        BEGIN BEGIN1 = new BEGIN();
        END END1 = new END();
        SPAN_REGEXP1.END = new END[] { END1, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN1 = new SPAN();
        SPAN1.NO_LINE_BREAK = "TRUE";
        SPAN1.TYPE = "LITERAL1";
        SPAN1.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN1.END = new END[] { END2, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN2, };

        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"Off", "On", "None", });
        KEYWORDS1.add("KEYWORD1", new String[]{"DirectorySlash", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AcceptMutex", "AcceptPathInfo", "AccessFileName", "Action", "AddAlt", "AddAltByEncoding", "AddAltByType", "AddCharset", "AddDefaultCharset", "AddDescription", "AddEncoding", "AddHandler", "AddIcon", "AddIconByEncoding", "AddIconByType", "AddInputFilter", "AddLanguage", "AddModuleInfo", "AddOutputFilter", "AddOutputFilterByType", "AddType", "Alias", "AliasMatch", "AllowCONNECT", "AllowEncodedSlashes", "AssignUserID", "AuthDigestNcCheck", "AuthDigestShmemSize", "AuthLDAPCharsetConfig", "BS2000Account", "BrowserMatch", "BrowserMatchNoCase", "CacheDefaultExpire", "CacheDirLength", "CacheDirLevels", "CacheDisable", "CacheEnable", "CacheExpiryCheck", "CacheFile", "CacheForceCompletion", "CacheGcClean", "CacheGcDaily", "CacheGcInterval", "CacheGcMemUsage", "CacheGcUnused", "CacheIgnoreCacheControl", "CacheIgnoreNoLastMod", "CacheLastModifiedFactor", "CacheMaxExpire", "CacheMaxFileSize", "CacheMinFileSize", "CacheNegotiatedDocs", "CacheRoot", "CacheSize", "CacheTimeMargin", "CharsetDefault", "CharsetOptions", "CharsetSourceEnc", "CheckSpelling", "ChildPerUserID", "ContentDigest", "CookieDomain", "CookieExpires", "CookieLog", "CookieName", "CookieStyle", "CookieTracking", "CoreDumpDirectory", "CustomLog", "DavDepthInfinity", "DavLockDB", "DavMinTimeout", "DefaultIcon", "DefaultLanguage", "DefaultType", "DeflateBufferSize", "DeflateCompressionLevel", "DeflateFilterNote", "DeflateMemLevel", "DeflateWindowSize", "DirectoryIndex", "DocumentRoot", "EnableMMAP", "EnableSendfile", "ErrorDocument", "ErrorLog", "Example", "ExpiresActive", "ExpiresByType", "ExpiresDefault", "ExtFilterDefine", "ExtendedStatus", "FileETag", "ForceLanguagePriority", "ForensicLog", "Group", "Header", "HeaderName", "HostnameLookups", "ISAPIAppendLogToErrors", "ISAPIAppendLogToQuery", "ISAPICacheFile", "ISAPIFakeAsync", "ISAPILogNotSupported", "ISAPIReadAheadBuffer", "IdentityCheck", "ImapBase", "ImapDefault", "ImapMenu", "Include", "IndexIgnore", "IndexOptions", "IndexOrderDefault", "JkMount", "KeepAlive", "KeepAliveTimeout", "LDAPCacheEntries", "LDAPCacheTTL", "LDAPOpCacheEntries", "LDAPOpCacheTTL", "LDAPSharedCacheSize", "LDAPTrustedCA", "LDAPTrustedCAType", "LanguagePriority", "LimitInternalRecursion", "LimitRequestBody", "LimitRequestFields", "LimitRequestFieldsize", "LimitRequestLine", "LimitXMLRequestBody", "Listen", "ListenBacklog", "LoadFile", "LoadModule", "LockFile", "LogFormat", "LogLevel", "MCacheMaxObjectCount", "MCacheMaxObjectSize", "MCacheMaxStreamingBuffer", "MCacheMinObjectSize", "MCacheRemovalAlgorithm", "MCacheSize", "MMapFile", "MaxClients", "MaxKeepAliveRequests", "MaxMemFree", "MaxRequestsPerChild", "MaxRequestsPerThread", "MaxSpareServers", "MaxSpareThreads", "MaxThreads", "MaxThreadsPerChild", "MetaDir", "MetaFiles", "MetaSuffix", "MimeMagicFile", "MinSpareServers", "MinSpareThreads", "MultiviewsMatch", "NWSSLTrustedCerts", "NameVirtualHost", "NoProxy", "NumServers", "Options", "PassEnv", "PidFile", "ProtocolEcho", "ProxyBadHeader", "ProxyBlock", "ProxyDomain", "ProxyErrorOverride", "ProxyIOBufferSize", "ProxyMaxForwards", "ProxyPass", "ProxyPassReverse", "ProxyPreserveHost", "ProxyReceiveBufferSize", "ProxyRemote", "ProxyRemoteMatch", "ProxyRequests", "ProxyTimeout", "ProxyVia", "RLimitCPU", "RLimitMEM", "RLimitNPROC", "ReadmeName", "Redirect", "RedirectMatch", "RedirectPermanent", "RedirectTemp", "RemoveCharset", "RemoveEncoding", "RemoveHandler", "RemoveInputFilter", "RemoveLanguage", "RemoveOutputFilter", "RemoveType", "RequestHeader", "RewriteBase", "RewriteCond", "RewriteEngine", "RewriteLock", "RewriteLog", "RewriteLogLevel", "RewriteMap", "RewriteOptions", "RewriteRule", "SSIEndTag", "SSIErrorMsg", "SSIStartTag", "SSITimeFormat", "SSIUndefinedEcho", "SSLCACertificateFile", "SSLCACertificatePath", "SSLCARevocationFile", "SSLCARevocationPath", "SSLCertificateChainFile", "SSLCertificateFile", "SSLCertificateKeyFile", "SSLCipherSuite", "SSLEngine", "SSLMutex", "SSLOptions", "SSLPassPhraseDialog", "SSLProtocol", "SSLProxyCACertificateFile", "SSLProxyCACertificatePath", "SSLProxyCARevocationFile", "SSLProxyCARevocationPath", "SSLProxyCipherSuite", "SSLProxyEngine", "SSLProxyMachineCertificateFile", "SSLProxyMachineCertificatePath", "SSLProxyProtocol", "SSLProxyVerify", "SSLProxyVerifyDepth", "SSLRandomSeed", "SSLSessionCache", "SSLSessionCacheTimeout", "SSLVerifyClient", "SSLVerifyDepth", "ScoreBoardFile", "Script", "ScriptAlias", "ScriptAliasMatch", "ScriptInterpreterSource", "ScriptLog", "ScriptLogBuffer", "ScriptLogLength", "ScriptSock", "SecureListen", "SendBufferSize", "ServerAdmin", "ServerAlias", "ServerLimit", "ServerName", "ServerPath", "ServerRoot", "ServerSignature", "ServerTokens", "SetEnv", "SetEnvIf", "SetEnvIfNoCase", "SetHandler", "SetInputFilter", "SetOutputFilter", "StartServers", "StartThreads", "SuexecUserGroup", "ThreadLimit", "ThreadStackSize", "ThreadsPerChild", "TimeOut", "TransferLog", "TypesConfig", "UnsetEnv", "UseCanonicalName", "User", "UserDir", "VirtualDocumentRoot", "VirtualDocumentRootIP", "VirtualScriptAlias", "VirtualScriptAliasIP", "XBitHack", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

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
