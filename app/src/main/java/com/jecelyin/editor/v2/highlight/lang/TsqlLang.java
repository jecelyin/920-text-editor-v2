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
public class TsqlLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "/*";
        PROPERTY1.NAME = "commentStart";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "*/";
        PROPERTY2.NAME = "commentEnd";
        PROPERTY PROPERTY3 = new PROPERTY();
        PROPERTY3.VALUE = "--";
        PROPERTY3.NAME = "lineComment";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, PROPERTY3, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "TRUE";
        SPAN SPAN1 = new SPAN();
        SPAN1.TYPE = "COMMENT1";
        BEGIN BEGIN1 = new BEGIN();
        BEGIN1.text = "/*";
        END END1 = new END();
        END1.text = "*/";
        SPAN1.END = new END[] { END1, };

        SPAN1.BEGIN = new BEGIN[] { BEGIN1, };

        SPAN SPAN2 = new SPAN();
        SPAN2.TYPE = "LITERAL1";
        SPAN2.ESCAPE = "\\";
        BEGIN BEGIN2 = new BEGIN();
        BEGIN2.text = "\"";
        END END2 = new END();
        END2.text = "\"";
        SPAN2.END = new END[] { END2, };

        SPAN2.BEGIN = new BEGIN[] { BEGIN2, };

        SPAN SPAN3 = new SPAN();
        SPAN3.TYPE = "LITERAL1";
        SPAN3.ESCAPE = "\\";
        BEGIN BEGIN3 = new BEGIN();
        BEGIN3.text = "'";
        END END3 = new END();
        END3.text = "'";
        SPAN3.END = new END[] { END3, };

        SPAN3.BEGIN = new BEGIN[] { BEGIN3, };

        SPAN SPAN4 = new SPAN();
        SPAN4.NO_LINE_BREAK = "TRUE";
        SPAN4.TYPE = "LITERAL1";
        SPAN4.ESCAPE = "\\";
        BEGIN BEGIN4 = new BEGIN();
        BEGIN4.text = "[";
        END END4 = new END();
        END4.text = "]";
        SPAN4.END = new END[] { END4, };

        SPAN4.BEGIN = new BEGIN[] { BEGIN4, };

        SPAN SPAN5 = new SPAN();
        SPAN5.TYPE = "LITERAL2";
        SPAN5.ESCAPE = "\\";
        BEGIN BEGIN5 = new BEGIN();
        BEGIN5.text = "`";
        END END5 = new END();
        END5.text = "`";
        SPAN5.END = new END[] { END5, };

        SPAN5.BEGIN = new BEGIN[] { BEGIN5, };

        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = ")";
        SEQ1.TYPE = "OPERATOR";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT1";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "+";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = "-";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "/";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "*";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = "=";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = ">";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = "<";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "%";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = "&";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "|";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "^";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "~";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = "!=";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = "!>";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "!<";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "::";
        SEQ17.TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.AT_LINE_START = "TRUE";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "@";
        MARK_FOLLOWING1.TYPE = "LITERAL2";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"ABSOLUTE", "ADD", "ALTER", "ANSI_NULLS", "AS", "ASC", "AUTHORIZATION", "BACKUP", "BEGIN", "BREAK", "BROWSE", "BULK", "BY", "CASCADE", "CHECK", "CHECKPOINT", "CLOSE", "CLUSTERED", "COLUMN", "COMMIT", "COMMITTED", "COMPUTE", "CONFIRM", "CONSTRAINT", "CONTAINS", "CONTAINSTABLE", "CONTINUE", "CONTROLROW", "CREATE", "CURRENT", "CURRENT_DATE", "CURRENT_TIME", "CURSOR", "DATABASE", "DBCC", "DEALLOCATE", "DECLARE", "DEFAULT", "DELETE", "DENY", "DESC", "DISK", "DISTINCT", "DISTRIBUTED", "DOUBLE", "DROP", "DUMMY", "DUMP", "DYNAMIC", "ELSE", "END", "ERRLVL", "ERROREXIT", "ESCAPE", "EXCEPT", "EXEC", "EXECUTE", "EXIT", "FAST_FORWARD", "FETCH", "FILE", "FILLFACTOR", "FIRST", "FLOPPY", "FOR", "FOREIGN", "FORWARD_ONLY", "FREETEXT", "FREETEXTTABLE", "FROM", "FULL", "FUNCTION", "GLOBAL", "GOTO", "GRANT", "GROUP", "HAVING", "HOLDLOCK", "ID", "IDENTITYCOL", "IDENTITY_INSERT", "IF", "INDEX", "INNER", "INSENSITIVE", "INSERT", "INTO", "IS", "ISOLATION", "KEY", "KEYSET", "KILL", "LAST", "LEVEL", "LINENO", "LOAD", "LOCAL", "MAX", "MIN", "MIRROREXIT", "NATIONAL", "NEXT", "NOCHECK", "NONCLUSTERED", "OF", "OFF", "OFFSETS", "ON", "ONCE", "ONLY", "OPEN", "OPENDATASOURCE", "OPENQUERY", "OPENROWSET", "OPTIMISTIC", "OPTION", "ORDER", "OUTPUT", "OVER", "PERCENT", "PERM", "PERMANENT", "PIPE", "PLAN", "PRECISION", "PREPARE", "PRIMARY", "PRINT", "PRIOR", "PRIVILEGES", "PROC", "PROCEDURE", "PROCESSEXIT", "PUBLIC", "QUOTED_IDENTIFIER", "RAISERROR", "READ", "READTEXT", "READ_ONLY", "RECONFIGURE", "REFERENCES", "RELATIVE", "REPEATABLE", "REPLICATION", "RESTORE", "RESTRICT", "RETURN", "RETURNS", "REVOKE", "ROLLBACK", "ROWGUIDCOL", "RULE", "SAVE", "SCHEMA", "SCROLL", "SCROLL_LOCKS", "SELECT", "SERIALIZABLE", "SET", "SETUSER", "SHUTDOWN", "STATIC", "STATISTICS", "TABLE", "TAPE", "TEMP", "TEMPORARY", "TEXTIMAGE_ON", "THEN", "TO", "TOP", "TRAN", "TRANSACTION", "TRIGGER", "TRUNCATE", "TSEQUAL", "UNCOMMITTED", "UNION", "UNIQUE", "UPDATE", "UPDATETEXT", "USE", "VALUES", "VARYING", "VIEW", "WAITFOR", "WHEN", "WHERE", "WHILE", "WITH", "WORK", "WRITETEXT", "binary", "bit", "char", "character", "datetime", "decimal", "float", "image", "int", "integer", "money", "name", "numeric", "nchar", "nvarchar", "ntext", "real", "smalldatetime", "smallint", "smallmoney", "text", "timestamp", "tinyint", "uniqueidentifier", "varbinary", "varchar", "ALL", "AND", "ANY", "BETWEEN", "CROSS", "EXISTS", "IN", "INTERSECT", "JOIN", "LIKE", "NOT", "NULL", "OR", "OUTER", "SOME", });
        KEYWORDS1.add("KEYWORD2", new String[]{"@@CONNECTIONS", "@@CPU_BUSY", "@@CURSOR_ROWS", "@@DATEFIRST", "@@DBTS", "@@ERROR", "@@FETCH_STATUS", "@@IDENTITY", "@@IDLE", "@@IO_BUSY", "@@LANGID", "@@LANGUAGE", "@@LOCK_TIMEOUT", "@@MAX_CONNECTIONS", "@@MAX_PRECISION", "@@NESTLEVEL", "@@OPTIONS", "@@PACKET_ERRORS", "@@PACK_RECEIVED", "@@PACK_SENT", "@@PROCID", "@@REMSERVER", "@@ROWCOUNT", "@@SERVERNAME", "@@SERVICENAME", "@@SPID", "@@TEXTSIZE", "@@TIMETICKS", "@@TOTAL_ERRORS", "@@TOTAL_READ", "@@TOTAL_WRITE", "@@TRANCOUNT", "@@VERSION", "ABS", "ACOS", "APP_NAME", "ASCII", "ASIN", "ATAN", "ATN2", "AVG", "BINARY_CHECKSUM", "CASE", "CAST", "CEILING", "CHARINDEX", "CHECKSUM", "CHECKSUM_AGG", "COALESCE", "COLLATIONPROPERTY", "COLUMNPROPERTY", "COL_LENGTH", "COL_NAME", "CONVERT", "COS", "COT", "COUNT", "COUNT_BIG", "CURRENT_DATE", "CURRENT_TIME", "CURRENT_TIMESTAMP", "CURRENT_USER", "CURSOR_STATUS", "DATABASEPROPERTY", "DATALENGTH", "DATEADD", "DATEDIFF", "DATENAME", "DATEPART", "DAY", "DB_ID", "DB_NAME", "DEGREES", "DIFFERENCE", "EXP", "FILEGROUPPROPERTY", "FILEGROUP_ID", "FILEGROUP_NAME", "FILEPROPERTY", "FILE_ID", "FILE_NAME", "FLOOR", "FORMATMESSAGE", "FULLTEXTCATALOGPROPERTY", "FULLTEXTSERVICEPROPERTY", "GETANSINULL", "GETDATE", "GETUTCDATE", "GROUPING", "HOST_ID", "HOST_NAME", "IDENTITY", "IDENTITY_INSERT", "IDENT_CURRENT", "IDENT_INCR", "IDENT_SEED", "INDEXPROPERTY", "INDEX_COL", "ISDATE", "ISNULL", "ISNUMERIC", "IS_MEMBER", "IS_SRVROLEMEMBER", "LEFT", "LEN", "LOG10", "LOG", "LOWER", "LTRIM", "MONTH", "NEWID", "NULLIF", "OBJECTPROPERTY", "OBJECT_ID", "OBJECT_NAME", "PARSENAME", "PATINDEX", "PERMISSIONS", "PI", "POWER", "QUOTENAME", "RADIANS", "RAND", "REPLACE", "REPLICATE", "REVERSE", "RIGHT", "ROUND", "ROWCOUNT_BIG", "RTRIM", "SCOPE_IDENTITY", "SERVERPROPERTY", "SESSIONPROPERTY", "SESSION_USER", "SIGN", "SIN", "SOUNDEX", "SPACE", "SQRT", "SQUARE", "STATS_DATE", "STDEV", "STDEVP", "STR", "STUFF", "SUBSTRING", "SUM", "SUSER_ID", "SUSER_NAME", "SUSER_SID", "SUSER_SNAME", "SYSTEM_USER", "TAN", "TEXTPTR", "TEXTVALID", "TYPEPROPERTY", "UNICODE", "UPPER", "USER", "USER_ID", "USER_NAME", "VAR", "VARP", "YEAR", });
        KEYWORDS1.add("KEYWORD3", new String[]{"sp_add_agent_parameter", "sp_add_agent_profile", "sp_add_alert", "sp_add_category", "sp_add_data_file_recover_suspect_db", "sp_add_job", "sp_add_jobschedule", "sp_add_jobserver", "sp_add_jobstep", "sp_add_log_file_recover_suspect_db", "sp_add_notification", "sp_add_operator", "sp_add_targetservergroup", "sp_add_targetsvrgrp_member", "sp_addalias", "sp_addapprole", "sp_addarticle", "sp_adddistpublisher", "sp_adddistributiondb", "sp_adddistributor", "sp_addextendedproc", "sp_addgroup", "sp_addlinkedserver", "sp_addlinkedsrvlogin", "sp_addlinkedsrvlogin", "sp_addlogin", "sp_addmergearticle", "sp_addmergefilter", "sp_addmergepublication", "sp_addmergepullsubscription", "sp_addmergepullsubscription_agent", "sp_addmergesubscription", "sp_addmessage", "sp_addpublication", "sp_addpublication_snapshot", "sp_addpublisher70", "sp_addpullsubscription", "sp_addpullsubscription_agent", "sp_addremotelogin", "sp_addrole", "sp_addrolemember", "sp_addserver", "sp_addsrvrolemember", "sp_addsubscriber", "sp_addsubscriber_schedule", "sp_addsubscription", "sp_addsynctriggers", "sp_addtabletocontents", "sp_addtask", "sp_addtype", "sp_addumpdevice", "sp_adduser", "sp_altermessage", "sp_apply_job_to_targets", "sp_approlepassword", "sp_article_validation", "sp_articlecolumn", "sp_articlefilter", "sp_articlesynctranprocs", "sp_articleview", "sp_attach_db", "sp_attach_single_file_db", "sp_autostats", "sp_bindefault", "sp_bindrule", "sp_bindsession", "sp_browsereplcmds", "sp_catalogs", "sp_certify_removable", "sp_change_agent_parameter", "sp_change_agent_profile", "sp_change_subscription_properties", "sp_change_users_login", "sp_changearticle", "sp_changedbowner", "sp_changedistpublisher", "sp_changedistributiondb", "sp_changedistributor_password", "sp_changedistributor_property", "sp_changegroup", "sp_changemergearticle", "sp_changemergefilter", "sp_changemergepublication", "sp_changemergepullsubscription", "sp_changemergesubscription", "sp_changeobjectowner", "sp_changepublication", "sp_changesubscriber", "sp_changesubscriber_schedule", "sp_changesubstatus", "sp_check_for_sync_trigger", "sp_column_privileges", "sp_column_privileges_ex", "sp_columns", "sp_columns_ex", "sp_configure", "sp_create_removable", "sp_createorphan", "sp_createstats", "sp_cursor", "sp_cursor_list", "sp_cursorclose", "sp_cursorexecute", "sp_cursorfetch", "sp_cursoropen", "sp_cursoroption", "sp_cursorprepare", "sp_cursorunprepare", "sp_cycle_errorlog", "sp_databases", "sp_datatype_info", "sp_dbcmptlevel", "sp_dbfixedrolepermission", "sp_dboption", "sp_defaultdb", "sp_defaultlanguage", "sp_delete_alert", "sp_delete_backuphistory", "sp_delete_category", "sp_delete_job", "sp_delete_jobschedule", "sp_delete_jobserver", "sp_delete_jobstep", "sp_delete_notification", "sp_delete_operator", "sp_delete_targetserver", "sp_delete_targetservergroup", "sp_delete_targetsvrgrp_member", "sp_deletemergeconflictrow", "sp_denylogin", "sp_depends", "sp_describe_cursor", "sp_describe_cursor_columns", "sp_describe_cursor_tables", "sp_detach_db", "sp_drop_agent_parameter", "sp_drop_agent_profile", "sp_dropalias", "sp_dropapprole", "sp_droparticle", "sp_dropdevice", "sp_dropdistpublisher", "sp_dropdistributiondb", "sp_dropdistributor", "sp_dropextendedproc", "sp_dropgroup", "sp_droplinkedsrvlogin", "sp_droplinkedsrvlogin", "sp_droplogin", "sp_dropmergearticle", "sp_dropmergefilter", "sp_dropmergepublication", "sp_dropmergepullsubscription", "sp_dropmergesubscription", "sp_dropmessage", "sp_droporphans", "sp_droppublication", "sp_droppullsubscription", "sp_dropremotelogin", "sp_droprole", "sp_droprolemember", "sp_dropserver", "sp_dropsrvrolemember", "sp_dropsubscriber", "sp_dropsubscription", "sp_droptask", "sp_droptype", "sp_dropuser", "sp_dropwebtask", "sp_dsninfo", "sp_dumpparamcmd", "sp_enumcodepages", "sp_enumcustomresolvers", "sp_enumdsn", "sp_enumfullsubscribers", "sp_execute", "sp_executesql", "sp_expired_subscription_cleanup", "sp_fkeys", "sp_foreignkeys", "sp_fulltext_catalog", "sp_fulltext_column", "sp_fulltext_database", "sp_fulltext_service", "sp_fulltext_table", "sp_generatefilters", "sp_get_distributor", "sp_getbindtoken", "sp_getmergedeletetype", "sp_grant_publication_access", "sp_grantdbaccess", "sp_grantlogin", "sp_help", "sp_help_agent_default", "sp_help_agent_parameter", "sp_help_agent_profile", "sp_help_alert", "sp_help_category", "sp_help_downloadlist", "sp_help_fulltext_catalogs", "sp_help_fulltext_catalogs_cursor", "sp_help_fulltext_columns", "sp_help_fulltext_columns_cursor", "sp_help_fulltext_tables", "sp_help_fulltext_tables_cursor", "sp_help_job", "sp_help_jobhistory", "sp_help_jobschedule", "sp_help_jobserver", "sp_help_jobstep", "sp_help_notification", "sp_help_operator", "sp_help_publication_access", "sp_help_targetserver", "sp_help_targetservergroup", "sp_helparticle", "sp_helparticlecolumns", "sp_helpconstraint", "sp_helpdb", "sp_helpdbfixedrole", "sp_helpdevice", "sp_helpdistpublisher", "sp_helpdistributiondb", "sp_helpdistributor", "sp_helpextendedproc", "sp_helpfile", "sp_helpfilegroup", "sp_helpgroup", "sp_helphistory", "sp_helpindex", "sp_helplanguage", "sp_helplinkedsrvlogin", "sp_helplogins", "sp_helpmergearticle", "sp_helpmergearticleconflicts", "sp_helpmergeconflictrows", "sp_helpmergedeleteconflictrows", "sp_helpmergefilter", "sp_helpmergepublication", "sp_helpmergepullsubscription", "sp_helpmergesubscription", "sp_helpntgroup", "sp_helppublication", "sp_helppullsubscription", "sp_helpremotelogin", "sp_helpreplicationdboption", "sp_helprole", "sp_helprolemember", "sp_helprotect", "sp_helpserver", "sp_helpsort", "sp_helpsrvrole", "sp_helpsrvrolemember", "sp_helpsubscriberinfo", "sp_helpsubscription", "sp_helpsubscription_properties", "sp_helptask", "sp_helptext", "sp_helptrigger", "sp_helpuser", "sp_indexes", "sp_indexoption", "sp_link_publication", "sp_linkedservers", "sp_lock", "sp_makewebtask", "sp_manage_jobs_by_login", "sp_mergedummyupdate", "sp_mergesubscription_cleanup", "sp_monitor", "sp_msx_defect", "sp_msx_enlist", "sp_OACreate", "sp_OADestroy", "sp_OAGetErrorInfo", "sp_OAGetProperty", "sp_OAMethod", "sp_OASetProperty", "sp_OAStop", "sp_password", "sp_pkeys", "sp_post_msx_operation", "sp_prepare", "sp_primarykeys", "sp_processmail", "sp_procoption", "sp_publication_validation", "sp_purge_jobhistory", "sp_purgehistory", "sp_reassigntask", "sp_recompile", "sp_refreshsubscriptions", "sp_refreshview", "sp_reinitmergepullsubscription", "sp_reinitmergesubscription", "sp_reinitpullsubscription", "sp_reinitsubscription", "sp_remoteoption", "sp_remove_job_from_targets", "sp_removedbreplication", "sp_rename", "sp_renamedb", "sp_replcmds", "sp_replcounters", "sp_repldone", "sp_replflush", "sp_replication_agent_checkup", "sp_replicationdboption", "sp_replsetoriginator", "sp_replshowcmds", "sp_repltrans", "sp_reset_connection", "sp_resync_targetserver", "sp_revoke_publication_access", "sp_revokedbaccess", "sp_revokelogin", "sp_runwebtask", "sp_script_synctran_commands", "sp_scriptdelproc", "sp_scriptinsproc", "sp_scriptmappedupdproc", "sp_scriptupdproc", "sp_sdidebug", "sp_server_info", "sp_serveroption", "sp_serveroption", "sp_setapprole", "sp_setnetname", "sp_spaceused", "sp_special_columns", "sp_sproc_columns", "sp_srvrolepermission", "sp_start_job", "sp_statistics", "sp_stop_job", "sp_stored_procedures", "sp_subscription_cleanup", "sp_table_privileges", "sp_table_privileges_ex", "sp_table_validation", "sp_tableoption", "sp_tables", "sp_tables_ex", "sp_unbindefault", "sp_unbindrule", "sp_unprepare", "sp_update_agent_profile", "sp_update_alert", "sp_update_category", "sp_update_job", "sp_update_jobschedule", "sp_update_jobstep", "sp_update_notification", "sp_update_operator", "sp_update_targetservergroup", "sp_updatestats", "sp_updatetask", "sp_validatelogins", "sp_validname", "sp_who", "xp_cmdshell", "xp_deletemail", "xp_enumgroups", "xp_findnextmsg", "xp_findnextmsg", "xp_grantlogin", "xp_logevent", "xp_loginconfig", "xp_logininfo", "xp_msver", "xp_readmail", "xp_revokelogin", "xp_sendmail", "xp_sprintf", "xp_sqlinventory", "xp_sqlmaint", "xp_sqltrace", "xp_sscanf", "xp_startmail", "xp_stopmail", "xp_trace_addnewqueue", "xp_trace_deletequeuedefinition", "xp_trace_destroyqueue", "xp_trace_enumqueuedefname", "xp_trace_enumqueuehandles", "xp_trace_eventclassrequired", "xp_trace_flushqueryhistory", "xp_trace_generate_event", "xp_trace_getappfilter", "xp_trace_getconnectionidfilter", "xp_trace_getcpufilter", "xp_trace_getdbidfilter", "xp_trace_getdurationfilter", "xp_trace_geteventfilter", "xp_trace_geteventnames", "xp_trace_getevents", "xp_trace_gethostfilter", "xp_trace_gethpidfilter", "xp_trace_getindidfilter", "xp_trace_getntdmfilter", "xp_trace_getntnmfilter", "xp_trace_getobjidfilter", "xp_trace_getqueueautostart", "xp_trace_getqueuedestination", "xp_trace_getqueueproperties", "xp_trace_getreadfilter", "xp_trace_getserverfilter", "xp_trace_getseverityfilter", "xp_trace_getspidfilter", "xp_trace_getsysobjectsfilter", "xp_trace_gettextfilter", "xp_trace_getuserfilter", "xp_trace_getwritefilter", "xp_trace_loadqueuedefinition", "xp_trace_pausequeue", "xp_trace_restartqueue", "xp_trace_savequeuedefinition", "xp_trace_setappfilter", "xp_trace_setconnectionidfilter", "xp_trace_setcpufilter", "xp_trace_setdbidfilter", "xp_trace_setdurationfilter", "xp_trace_seteventclassrequired", "xp_trace_seteventfilter", "xp_trace_sethostfilter", "xp_trace_sethpidfilter", "xp_trace_setindidfilter", "xp_trace_setntdmfilter", "xp_trace_setntnmfilter", "xp_trace_setobjidfilter", "xp_trace_setqueryhistory", "xp_trace_setqueueautostart", "xp_trace_setqueuecreateinfo", "xp_trace_setqueuedestination", "xp_trace_setreadfilter", "xp_trace_setserverfilter", "xp_trace_setseverityfilter", "xp_trace_setspidfilter", "xp_trace_setsysobjectsfilter", "xp_trace_settextfilter", "xp_trace_setuserfilter", "xp_trace_setwritefilter", "fn_helpcollations", "fn_servershareddrives", "fn_virtualfilestats", "backupfile", "backupmediafamily", "backupmediaset", "backupset", "MSagent_parameters", "MSagent_profiles", "MSarticles", "MSdistpublishers", "MSdistribution_agents", "MSdistribution_history", "MSdistributiondbs", "MSdistributor", "MSlogreader_agents", "MSlogreader_history", "MSmerge_agents", "MSmerge_contents", "MSmerge_delete_conflicts", "MSmerge_genhistory", "MSmerge_history", "MSmerge_replinfo", "MSmerge_subscriptions", "MSmerge_tombstone", "MSpublication_access", "Mspublications", "Mspublisher_databases", "MSrepl_commands", "MSrepl_errors", "Msrepl_originators", "MSrepl_transactions", "MSrepl_version", "MSreplication_objects", "MSreplication_subscriptions", "MSsnapshot_agents", "MSsnapshot_history", "MSsubscriber_info", "MSsubscriber_schedule", "MSsubscription_properties", "MSsubscriptions", "restorefile", "restorefilegroup", "restorehistory", "sysalerts", "sysallocations", "sysaltfiles", "sysarticles", "sysarticleupdates", "syscacheobjects", "syscategories", "syscharsets", "syscolumns", "syscomments", "sysconfigures", "sysconstraints", "syscurconfigs", "sysdatabases", "sysdatabases", "sysdepends", "sysdevices", "sysdownloadlist", "sysfilegroups", "sysfiles", "sysforeignkeys", "sysfulltextcatalogs", "sysindexes", "sysindexkeys", "sysjobhistory", "sysjobs", "sysjobschedules", "sysjobservers", "sysjobsteps", "syslanguages", "syslockinfo", "syslogins", "sysmembers", "sysmergearticles", "sysmergepublications", "sysmergeschemachange", "sysmergesubscriptions", "sysmergesubsetfilters", "sysmessages", "sysnotifications", "sysobjects", "sysobjects", "sysoledbusers", "sysoperators", "sysperfinfo", "syspermissions", "sysprocesses", "sysprotects", "syspublications", "sysreferences", "sysremotelogins", "sysreplicationalerts", "sysservers", "sysservers", "syssubscriptions", "systargetservergroupmembers", "systargetservergroups", "systargetservers", "systaskids", "systypes", "sysusers", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, SPAN4, SPAN5, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.KEYWORDS = new KEYWORDS[] { KEYWORDS1, };

        return RULES1;
    }

    public RULES[] RULES() {
        return new RULES[] {RULES1(), };
    }

    public PROPS[] PROPS() {
        return new PROPS[] {PROPS1(), };
    }


}
