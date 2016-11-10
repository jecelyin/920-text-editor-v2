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
public class PgSqlLang implements LangDefine {
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

        SPAN_REGEXP SPAN_REGEXP1 = new SPAN_REGEXP();
        SPAN_REGEXP1.TYPE = "LITERAL2";
        SPAN_REGEXP1.HASH_CHAR = "$";
        BEGIN BEGIN4 = new BEGIN();
        END END4 = new END();
        END4.text = "$1\\$";
        END4.REGEXP = "TRUE";
        SPAN_REGEXP1.END = new END[] { END4, };

        SPAN_REGEXP1.BEGIN = new BEGIN[] { BEGIN4, };

        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "--";
        EOL_SPAN1.TYPE = "COMMENT2";
        MARK_PREVIOUS MARK_PREVIOUS1 = new MARK_PREVIOUS();
        MARK_PREVIOUS1.text = "(";
        MARK_PREVIOUS1.TYPE = "FUNCTION";
        MARK_PREVIOUS1.MATCH_TYPE = "OPERATOR";
        MARK_PREVIOUS MARK_PREVIOUS2 = new MARK_PREVIOUS();
        MARK_PREVIOUS2.text = ":";
        MARK_PREVIOUS2.TYPE = "LABEL";
        MARK_PREVIOUS2.AT_LINE_START = "TRUE";
        MARK_FOLLOWING MARK_FOLLOWING1 = new MARK_FOLLOWING();
        MARK_FOLLOWING1.text = "\\";
        MARK_FOLLOWING1.AT_WHITESPACE_END = "TRUE";
        MARK_FOLLOWING1.TYPE = "LITERAL3";
        MARK_FOLLOWING1.MATCH_TYPE = "OPERATOR";
        SEQ SEQ1 = new SEQ();
        SEQ1.text = "&";
        SEQ1.TYPE = "OPERATOR";
        SEQ SEQ2 = new SEQ();
        SEQ2.text = "(";
        SEQ2.TYPE = "OPERATOR";
        SEQ SEQ3 = new SEQ();
        SEQ3.text = ")";
        SEQ3.TYPE = "OPERATOR";
        SEQ SEQ4 = new SEQ();
        SEQ4.text = "*";
        SEQ4.TYPE = "OPERATOR";
        SEQ SEQ5 = new SEQ();
        SEQ5.text = "+";
        SEQ5.TYPE = "OPERATOR";
        SEQ SEQ6 = new SEQ();
        SEQ6.text = ",";
        SEQ6.TYPE = "OPERATOR";
        SEQ SEQ7 = new SEQ();
        SEQ7.text = "-";
        SEQ7.TYPE = "OPERATOR";
        SEQ SEQ8 = new SEQ();
        SEQ8.text = ".";
        SEQ8.TYPE = "OPERATOR";
        SEQ SEQ9 = new SEQ();
        SEQ9.text = "/";
        SEQ9.TYPE = "OPERATOR";
        SEQ SEQ10 = new SEQ();
        SEQ10.text = ":";
        SEQ10.TYPE = "OPERATOR";
        SEQ SEQ11 = new SEQ();
        SEQ11.text = "<";
        SEQ11.TYPE = "OPERATOR";
        SEQ SEQ12 = new SEQ();
        SEQ12.text = "<<";
        SEQ12.TYPE = "OPERATOR";
        SEQ SEQ13 = new SEQ();
        SEQ13.text = "=";
        SEQ13.TYPE = "OPERATOR";
        SEQ SEQ14 = new SEQ();
        SEQ14.text = ">";
        SEQ14.TYPE = "OPERATOR";
        SEQ SEQ15 = new SEQ();
        SEQ15.text = ">>";
        SEQ15.TYPE = "OPERATOR";
        SEQ SEQ16 = new SEQ();
        SEQ16.text = "@";
        SEQ16.TYPE = "OPERATOR";
        SEQ SEQ17 = new SEQ();
        SEQ17.text = "[";
        SEQ17.TYPE = "OPERATOR";
        SEQ SEQ18 = new SEQ();
        SEQ18.text = "]";
        SEQ18.TYPE = "OPERATOR";
        SEQ SEQ19 = new SEQ();
        SEQ19.text = "^";
        SEQ19.TYPE = "OPERATOR";
        SEQ SEQ20 = new SEQ();
        SEQ20.text = "|";
        SEQ20.TYPE = "OPERATOR";
        SEQ SEQ21 = new SEQ();
        SEQ21.text = "%";
        SEQ21.TYPE = "OPERATOR";
        SEQ SEQ22 = new SEQ();
        SEQ22.text = "|/";
        SEQ22.TYPE = "OPERATOR";
        SEQ SEQ23 = new SEQ();
        SEQ23.text = "||/";
        SEQ23.TYPE = "OPERATOR";
        SEQ SEQ24 = new SEQ();
        SEQ24.text = "!";
        SEQ24.TYPE = "OPERATOR";
        SEQ SEQ25 = new SEQ();
        SEQ25.text = "!!";
        SEQ25.TYPE = "OPERATOR";
        SEQ SEQ26 = new SEQ();
        SEQ26.text = "@";
        SEQ26.TYPE = "OPERATOR";
        SEQ SEQ27 = new SEQ();
        SEQ27.text = "#";
        SEQ27.TYPE = "OPERATOR";
        SEQ SEQ28 = new SEQ();
        SEQ28.text = "~";
        SEQ28.TYPE = "OPERATOR";
        SEQ SEQ29 = new SEQ();
        SEQ29.text = "`";
        SEQ29.TYPE = "OPERATOR";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("KEYWORD1", new String[]{"ABORT", "ABSOLUTE", "ACCESS", "ACTION", "ADD", "ADMIN", "AFTER", "AGGREGATE", "ALL", "ALSO", "ALTER", "ALWAYS", "ANALYSE", "ANALYZE", "AND", "ANY", "ARRAY", "AS", "ASC", "ASSERTION", "ASSIGNMENT", "ASYMMETRIC", "AT", "ATTRIBUTE", "AUTHORIZATION", "BACKWARD", "BEFORE", "BEGIN", "BETWEEN", "BIGINT", "BINARY", "BIT", "BOOLEAN", "BOTH", "BY", "CACHE", "CALLED", "CASCADE", "CASCADED", "CASE", "CAST", "CATALOG", "CHAIN", "CHAR", "CHARACTER", "CHARACTERISTICS", "CHECK", "CHECKPOINT", "CLASS", "CLOSE", "CLUSTER", "COLLATE", "COLLATION", "COLUMN", "COMMENT", "COMMENTS", "COMMIT", "COMMITTED", "CONCURRENTLY", "CONFIGURATION", "CONNECTION", "CONSTRAINT", "CONSTRAINTS", "CONTENT", "CONTINUE", "CONVERSION", "COPY", "COST", "CREATE", "CREATEDB", "CREATEROLE", "CREATEUSER", "CROSS", "CSV", "CURRENT", "CURRENT_CATALOG", "CURRENT_ROLE", "CURRENT_SCHEMA", "CURRENT_USER", "CURSOR", "CYCLE", "DATA", "DATABASE", "DAY", "DEALLOCATE", "DEC", "DECIMAL", "DECLARE", "DEFAULT", "DEFAULTS", "DEFERRABLE", "DEFERRED", "DEFINER", "DELETE", "DELIMITER", "DELIMITERS", "DESC", "DICTIONARY", "DISABLE", "DISCARD", "DISTINCT", "DO", "DOCUMENT", "DOMAIN", "DOUBLE", "DROP", "EACH", "ELSE", "ENABLE", "ENCODING", "ENCRYPTED", "END", "ENUM", "ESCAPE", "EXCEPT", "EXCEPTION", "EXCLUDE", "EXCLUDING", "EXCLUSIVE", "EXECUTE", "EXISTS", "EXPLAIN", "EXTENSION", "EXTERNAL", "FALSE", "FAMILY", "FETCH", "FIRST", "FLOAT", "FOLLOWING", "FOR", "FORCE", "FOREIGN", "FORWARD", "FREEZE", "FROM", "FULL", "FUNCTION", "FUNCTIONS", "GLOBAL", "GRANT", "GRANTED", "GROUP", "HANDLER", "HAVING", "HEADER", "HOLD", "HOUR", "IDENTITY", "ILIKE", "IMMEDIATE", "IMMUTABLE", "IMPLICIT", "IN", "INCLUDING", "INCREMENT", "INDEX", "INDEXES", "INHERIT", "INHERITS", "INITIALLY", "INLINE", "INNER", "INOUT", "INPUT", "INSENSITIVE", "INSERT", "INSTEAD", "INT", "INTEGER", "INTERSECT", "INTERVAL", "INTO", "INVOKER", "IS", "ISNULL", "ISOLATION", "JOIN", "KEY", "LABEL", "LANGUAGE", "LARGE", "LAST", "LC_COLLATE", "LC_CTYPE", "LEADING", "LEAKPROOF", "LEFT", "LEVEL", "LIKE", "LIMIT", "LISTEN", "LOAD", "LOCAL", "LOCATION", "LOCK", "LOGIN", "MAPPING", "MATCH", "MAXVALUE", "MINUTE", "MINVALUE", "MODE", "MONTH", "MOVE", "NAME", "NAMES", "NATIONAL", "NATURAL", "NCHAR", "NEW", "NEXT", "NO", "NOCREATEDB", "NOCREATEROLE", "NOCREATEUSER", "NOINHERIT", "NOLOGIN", "NONE", "NOSUPERUSER", "NOT", "NOTHING", "NOTIFY", "NOTNULL", "NOWAIT", "NULL", "NULLS", "NUMERIC", "OBJECT", "OF", "OFF", "OFFSET", "OIDS", "OLD", "ON", "ONLY", "OPERATOR", "OPTION", "OPTIONS", "OR", "ORDER", "OUT", "OUTER", "OVER", "OVERLAPS", "OVERLAY", "OWNED", "OWNER", "PARSER", "PARTIAL", "PARTITION", "PASSING", "PASSWORD", "PLACING", "PLANS", "POSITION", "PRECEDING", "PRECISION", "PREPARE", "PREPARED", "PRESERVE", "PRIMARY", "PRIOR", "PRIVILEGES", "PROCEDURAL", "PROCEDURE", "QUOTE", "RANGE", "READ", "REAL", "REASSIGN", "RECHECK", "RECURSIVE", "REF", "REFERENCES", "REINDEX", "RELATIVE", "RELEASE", "RENAME", "REPEATABLE", "REPLACE", "REPLICA", "RESET", "RESTART", "RESTRICT", "RETURN", "RETURNING", "RETURNS", "REVOKE", "RIGHT", "ROLE", "ROLLBACK", "ROW", "ROWS", "RULE", "SAVEPOINT", "SCHEMA", "SCROLL", "SEARCH", "SECOND", "SECURITY", "SELECT", "SEQUENCE", "SEQUENCES", "SERIALIZABLE", "SERVER", "SESSION", "SESSION_USER", "SET", "SETOF", "SHARE", "SHOW", "SIMILAR", "SIMPLE", "SMALLINT", "SNAPSHOT", "STABLE", "STANDALONE", "START", "STATEMENT", "STATISTICS", "STDIN", "STDOUT", "STORAGE", "STRICT", "STRIP", "SUBSTRING", "SUPERUSER", "SYMMETRIC", "SYSID", "SYSTEM", "TABLE", "TABLES", "TABLESPACE", "TEMP", "TEMPLATE", "TEMPORARY", "TEXT", "THEN", "TIME", "TIMESTAMP", "TO", "TRAILING", "TRANSACTION", "TREAT", "TRIGGER", "TRIM", "TRUE", "TRUNCATE", "TRUSTED", "TYPE", "TYPES", "UNBOUNDED", "UNCOMMITTED", "UNENCRYPTED", "UNION", "UNIQUE", "UNKNOWN", "UNLISTEN", "UNLOGGED", "UNTIL", "UPDATE", "USER", "USING", "VACUUM", "VALID", "VALIDATE", "VALIDATOR", "VALUE", "VALUES", "VARCHAR", "VARIADIC", "VARYING", "VERBOSE", "VERSION", "VIEW", "VOLATILE", "WHEN", "WHERE", "WHITESPACE", "WINDOW", "WITH", "WITHOUT", "WORK", "WRAPPER", "WRITE", "XML", "XMLATTRIBUTES", "XMLCONCAT", "XMLELEMENT", "XMLEXISTS", "XMLFOREST", "XMLPARSE", "XMLPI", "XMLROOT", "XMLSERIALIZE", "YEAR", "YES", "ZONE", "IF", "ELSIF", "PERFORM", "SERIAL", "TEXT", "ROWTYPE", "VOID", });
        KEYWORDS1.add("KEYWORD2", new String[]{"AT TIME ZONE", "COALESCE", "CURRENT_TIME(", "CURRENT_TIME", "CURRENT_TIMESTAMP(", "CURRENT_TIMESTAMP", "EXTRACT", "GREATEST", "LEAST", "LOCALTIME(", "LOCALTIME", "LOCALTIMESTAMP(", "LOCALTIMESTAMP", "NOT IN", "NULLIF", "SIMILAR TO", "SOME", "XMLEXISTS(", "abbrev(", "abs(", "acos(", "age(", "area(", "array_agg(", "array_append(", "array_cat(", "array_dims(", "array_fill(", "array_length(", "array_lower(", "array_ndims(", "array_prepend(", "array_to_json(", "array_to_string(", "array_upper(", "ascii(", "ascii_to_mic", "ascii_to_utf8", "asin(", "atan(", "atan2(", "avg(", "big5_to_euc_tw", "big5_to_mic", "big5_to_utf8", "bit_and(", "bit_length(", "bit_or(", "bool_and(", "bool_or(", "box(", "broadcast(", "btrim(", "cbrt(", "ceil(", "ceiling(", "center(", "char_length(", "chr(", "circle(", "clock_timestamp(", "col_description(", "concat(", "concat_ws(", "convert(", "convert_from(", "convert_to(", "corr(", "cos(", "cot(", "count(", "covar_pop(", "covar_samp(", "cume_dist(", "current_catalog", "current_database(", "current_date", "current_query(", "current_schema", "current_schema(", "current_schemas(", "current_setting(", "current_time", "current_timestamp", "current_user", "currval(", "cursor_to_xml(", "cursor_to_xmlschema(", "database_to_xml(", "database_to_xml_and_xmlschema(", "database_to_xmlschema(", "date_part(", "date_trunc(", "decode(", "degrees(", "dense_rank(", "diameter(", "div(", "encode(", "enum_first(", "enum_last(", "enum_range(", "euc_cn_to_mic", "euc_cn_to_utf8", "euc_jis_2004_to_shift_jis_2004", "euc_jis_2004_to_utf8", "euc_jp_to_mic", "euc_jp_to_sjis", "euc_jp_to_utf8", "euc_kr_to_mic", "euc_kr_to_utf8", "euc_tw_to_big5", "euc_tw_to_mic", "euc_tw_to_utf8", "every(", "exp(", "extract(", "family(", "first_value(", "floor(", "format(", "format_type(", "gb18030_to_utf8", "gbk_to_utf8", "generate_series(", "generate_subscripts(", "get_bit(", "get_byte(", "get_current_ts_config(", "has_any_column_privilege(", "has_column_privilege(", "has_database_privilege(", "has_foreign_data_wrapper_privilege(", "has_function_privilege(", "has_language_privilege(", "has_schema_privilege(", "has_sequence_privilege(", "has_server_privilege(", "has_table_privilege(", "has_tablespace_privilege(", "height(", "host(", "hostmask(", "inet_client_addr(", "inet_client_port(", "inet_server_addr(", "inet_server_port(", "initcap(", "isclosed(", "isempty(", "isfinite(", "iso_8859_1_to_mic", "iso_8859_1_to_utf8", "iso_8859_2_to_mic", "iso_8859_2_to_utf8", "iso_8859_2_to_windows_1250", "iso_8859_3_to_mic", "iso_8859_3_to_utf8", "iso_8859_4_to_mic", "iso_8859_4_to_utf8", "iso_8859_5_to_koi8_r", "iso_8859_5_to_mic", "iso_8859_5_to_utf8", "iso_8859_5_to_windows_866", "iso_8859_5_to_windows_1251", "iso_8859_6_to_utf8", "iso_8859_7_to_utf8", "iso_8859_8_to_utf8", "iso_8859_9_to_utf8", "iso_8859_10_to_utf8", "iso_8859_13_to_utf8", "iso_8859_14_to_utf8", "iso_8859_15_to_utf8", "iso_8859_16_to_utf8", "isopen(", "johab_to_utf8", "justify_days(", "justify_hours(", "justify_interval(", "koi8_r_to_iso_8859_5", "koi8_r_to_mic", "koi8_r_to_utf8", "koi8_r_to_windows_866", "koi8_r_to_windows_1251", "koi8_u_to_utf8", "lag(", "last_value(", "lastval(", "lead(", "left(", "length(", "ln(", "localtime", "localtimestamp", "log(", "lower(", "lower_inc(", "lower_inf(", "lpad(", "lseg(", "ltrim(", "masklen(", "max(", "md5(", "mic_to_ascii", "mic_to_big5", "mic_to_euc_cn", "mic_to_euc_jp", "mic_to_euc_kr", "mic_to_euc_tw", "mic_to_iso_8859_1", "mic_to_iso_8859_2", "mic_to_iso_8859_3", "mic_to_iso_8859_4", "mic_to_iso_8859_5", "mic_to_koi8_r", "mic_to_sjis", "mic_to_windows_866", "mic_to_windows_1250", "mic_to_windows_1251", "min(", "mod(", "netmask(", "network(", "nextval(", "now(", "npoints(", "nth_value(", "ntile(", "numnode(", "obj_description(", "octet_length(", "overlay(", "path(", "pclose(", "percent_rank(", "pg_advisory_lock(", "pg_advisory_lock_shared(", "pg_advisory_unlock(", "pg_advisory_unlock_all(", "pg_advisory_unlock_shared(", "pg_advisory_xact_lock(", "pg_advisory_xact_lock_shared(", "pg_backend_pid(", "pg_cancel_backend(", "pg_client_encoding(", "pg_collation_is_visible(", "pg_column_size(", "pg_conf_load_time(", "pg_conversion_is_visible(", "pg_create_restore_point(", "pg_current_xlog_insert_location(", "pg_current_xlog_location(", "pg_database_size(", "pg_describe_object(", "pg_export_snapshot(", "pg_function_is_visible(", "pg_get_constraintdef(", "pg_get_expr(", "pg_get_function_arguments(", "pg_get_function_identity_arguments(", "pg_get_function_result(", "pg_get_functiondef(", "pg_get_indexdef(", "pg_get_keywords(", "pg_get_ruledef(", "pg_get_serial_sequence(", "pg_get_triggerdef(", "pg_get_userbyid(", "pg_get_viewdef(", "pg_has_role(", "pg_indexes_size(", "pg_is_in_recovery(", "pg_is_other_temp_schema(", "pg_is_xlog_replay_paused(", "pg_last_xact_replay_timestamp(", "pg_last_xlog_receive_location(", "pg_last_xlog_replay_location(", "pg_listening_channels(", "pg_ls_dir(", "pg_my_temp_schema(", "pg_opclass_is_visible(", "pg_operator_is_visible(", "pg_opfamily_is_visible(", "pg_options_to_table(", "pg_postmaster_start_time(", "pg_read_binary_file(", "pg_read_file(", "pg_relation_filenode(", "pg_relation_filepath(", "pg_relation_size(", "pg_reload_conf(", "pg_rotate_logfile(", "pg_size_pretty(", "pg_start_backup(", "pg_stat_file(", "pg_stop_backup(", "pg_switch_xlog(", "pg_table_is_visible(", "pg_table_size(", "pg_tablespace_databases(", "pg_tablespace_location(", "pg_tablespace_size(", "pg_terminate_backend(", "pg_total_relation_size(", "pg_trigger_depth(", "pg_try_advisory_lock(", "pg_try_advisory_lock_shared(", "pg_try_advisory_xact_lock(", "pg_try_advisory_xact_lock_shared(", "pg_ts_config_is_visible(", "pg_ts_dict_is_visible(", "pg_ts_parser_is_visible(", "pg_ts_template_is_visible(", "pg_type_is_visible(", "pg_typeof(", "pg_xlog_location_diff(", "pg_xlog_replay_pause(", "pg_xlog_replay_resume(", "pg_xlogfile_name(", "pg_xlogfile_name_offset(", "pi(", "plainto_tsquery(", "point(", "polygon(", "popen(", "position(", "power(", "query_to_xml(", "query_to_xml_and_xmlschema(", "query_to_xmlschema(", "querytree(", "quote_ident(", "quote_literal(", "quote_nullable(", "radians(", "radius(", "random(", "rank(", "regexp_matches(", "regexp_replace(", "regexp_split_to_array(", "regexp_split_to_table(", "regr_avgx(", "regr_avgy(", "regr_count(", "regr_intercept(", "regr_r2(", "regr_slope(", "regr_sxx(", "regr_sxy(", "regr_syy(", "repeat(", "replace(", "reverse(", "right(", "round(", "row_number(", "row_to_json(", "rpad(", "rtrim(", "schema_to_xml(", "schema_to_xml_and_xmlschema(", "schema_to_xmlschema(", "session_user", "set_bit(", "set_byte(", "set_config(", "set_masklen(", "setseed(", "setval(", "setweight(", "shift_jis_2004_to_euc_jis_2004", "shift_jis_2004_to_utf8", "shobj_description(", "sign(", "sin(", "sjis_to_euc_jp", "sjis_to_mic", "sjis_to_utf8", "split_part(", "sqrt(", "statement_timestamp(", "stddev(", "stddev_pop(", "stddev_samp(", "string_agg(", "string_to_array(", "strip(", "strpos(", "substr(", "substring(", "sum(", "table_to_xml(", "table_to_xml_and_xmlschema(", "table_to_xmlschema(", "tan(", "tcvn_to_utf8", "text(", "timeofday(", "to_ascii(", "to_char(", "to_date(", "to_hex(", "to_number(", "to_timestamp(", "to_tsquery(", "to_tsvector(", "transaction_timestamp(", "translate(", "trim(", "trunc(", "ts_debug(", "ts_headline(", "ts_lexize(", "ts_parse(", "ts_rank(", "ts_rank_cd(", "ts_rewrite(", "ts_stat(", "ts_token_type(", "tsvector_update_trigger(", "tsvector_update_trigger_column(", "txid_current(", "txid_current_snapshot(", "txid_snapshot_xip(", "txid_snapshot_xmax(", "txid_snapshot_xmin(", "txid_visible_in_snapshot(", "uhc_to_utf8", "unnest(", "upper(", "upper_inc(", "upper_inf(", "user", "ut8_to_euc_jis_2004", "ut8_to_shift_jis_2004", "utf8_to_ascii", "utf8_to_big5", "utf8_to_euc_cn", "utf8_to_euc_jp", "utf8_to_euc_kr", "utf8_to_euc_tw", "utf8_to_gb18030", "utf8_to_gbk", "utf8_to_iso_8859_1", "utf8_to_iso_8859_2", "utf8_to_iso_8859_3", "utf8_to_iso_8859_4", "utf8_to_iso_8859_5", "utf8_to_iso_8859_6", "utf8_to_iso_8859_7", "utf8_to_iso_8859_8", "utf8_to_iso_8859_9", "utf8_to_iso_8859_10", "utf8_to_iso_8859_13", "utf8_to_iso_8859_14", "utf8_to_iso_8859_15", "utf8_to_iso_8859_16", "utf8_to_johab", "utf8_to_koi8_r", "utf8_to_koi8_u", "utf8_to_sjis", "utf8_to_tcvn", "utf8_to_uhc", "utf8_to_windows_866", "utf8_to_windows_874", "utf8_to_windows_1250", "utf8_to_windows_1251", "utf8_to_windows_1252", "utf8_to_windows_1253", "utf8_to_windows_1254", "utf8_to_windows_1255", "utf8_to_windows_1256", "utf8_to_windows_1257", "var_pop(", "var_samp(", "variance(", "version(", "width(", "width_bucket(", "windows_866_to_iso_8859_5", "windows_866_to_koi8_r", "windows_866_to_mic", "windows_866_to_utf8", "windows_866_to_windows_1251", "windows_874_to_utf8", "windows_1250_to_iso_8859_2", "windows_1250_to_mic", "windows_1250_to_utf8", "windows_1251_to_iso_8859_5", "windows_1251_to_koi8_r", "windows_1251_to_mic", "windows_1251_to_utf8", "windows_1251_to_windows_866", "windows_1252_to_utf8", "windows_1256_to_utf8", "xip_list", "xmax", "xmin", "xml_is_well_formed(", "xml_is_well_formed_content(", "xml_is_well_formed_document(", "xmlagg(", "xmlcomment(", "xmlconcat(", "xmlelement(", "xmlforest(", "xmlpi(", "xmlroot(", "xpath(", "xpath_exists(", });
        KEYWORDS1.add("KEYWORD3", new String[]{"pg_aggregate", "pg_am", "pg_amop", "pg_amproc", "pg_attrdef", "pg_attribute", "pg_auth_members", "pg_authid", "pg_available_extension_versions", "pg_available_extensions", "pg_cast", "pg_class", "pg_collation", "pg_constraint", "pg_conversion", "pg_cursors", "pg_database", "pg_db_role_setting", "pg_default_acl", "pg_depend", "pg_description", "pg_enum", "pg_extension", "pg_foreign_data_wrapper", "pg_foreign_server", "pg_foreign_table", "pg_group", "pg_index", "pg_indexes", "pg_inherits", "pg_language", "pg_largeobject", "pg_largeobject_metadata", "pg_locks", "pg_namespace", "pg_opclass", "pg_operator", "pg_opfamily", "pg_pltemplate", "pg_prepared_statements", "pg_prepared_xacts", "pg_proc", "pg_range", "pg_rewrite", "pg_roles", "pg_rules", "pg_seclabel", "pg_seclabels", "pg_settings", "pg_shadow", "pg_shdepend", "pg_shdescription", "pg_shseclabel", "pg_statistic", "pg_stats", "pg_tables", "pg_tablespace", "pg_timezone_abbrevs", "pg_timezone_names", "pg_trigger", "pg_ts_config", "pg_ts_config_map", "pg_ts_dict", "pg_ts_parser", "pg_ts_template", "pg_type", "pg_user", "pg_user_mapping", "pg_user_mappings", "pg_views", "administrable_role_authorizations", "applicable_roles", "attributes", "character_sets", "check_constraint_routine_usage", "check_constraints", "collation_character_set_applicability", "collations", "column_domain_usage", "column_options", "column_privileges", "column_udt_usage", "columns", "constraint_column_usage", "constraint_table_usage", "data_type_privileges", "domain_constraints", "domain_udt_usage", "domains", "element_types", "enabled_roles", "foreign_data_wrapper_options", "foreign_data_wrappers", "foreign_server_options", "foreign_servers", "foreign_table_options", "foreign_tables", "information_schema_catalog_name", "key_column_usage", "parameters", "referential_constraints", "role_column_grants", "role_routine_grants", "role_table_grants", "role_udt_grants", "role_usage_grants", "routine_privileges", "routines", "schemata", "sequences", "sql_features", "sql_implementation_info", "sql_languages", "sql_packages", "sql_parts", "sql_sizing", "sql_sizing_profiles", "table_constraints", "table_privileges", "tables", "triggered_update_columns", "triggers", "udt_privileges", "usage_privileges", "user_defined_types", "user_mapping_options", "user_mappings", "view_column_usage", "view_routine_usage", "view_table_usage", "views", });
        KEYWORDS1.add("KEYWORD4", new String[]{"alnum", "alpha", "blank", "cntrl", "digit", "graph", "lower", "print", "punct", "space", "upper", "xdigit", "RAISE", "DEBUG", "LOG", "INFO", "NOTICE", "WARNING", "plpgsql", "pltcl", "pltclu", "plperl", "plperlu", "plpythonu", });
        RULES1.MARK_PREVIOUS = new MARK_PREVIOUS[] { MARK_PREVIOUS1, MARK_PREVIOUS2, };

        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

        RULES1.SPAN = new SPAN[] { SPAN1, SPAN2, SPAN3, };

        RULES1.SPAN_REGEXP = new SPAN_REGEXP[] { SPAN_REGEXP1, };

        RULES1.MARK_FOLLOWING = new MARK_FOLLOWING[] { MARK_FOLLOWING1, };

        RULES1.SEQ = new SEQ[] { SEQ1, SEQ2, SEQ3, SEQ4, SEQ5, SEQ6, SEQ7, SEQ8, SEQ9, SEQ10, SEQ11, SEQ12, SEQ13, SEQ14, SEQ15, SEQ16, SEQ17, SEQ18, SEQ19, SEQ20, SEQ21, SEQ22, SEQ23, SEQ24, SEQ25, SEQ26, SEQ27, SEQ28, SEQ29, };

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
