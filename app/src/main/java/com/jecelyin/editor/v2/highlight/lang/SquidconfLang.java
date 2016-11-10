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
public class SquidconfLang implements LangDefine {
        private PROPS PROPS1() {
        PROPS PROPS1 = new PROPS();
        PROPERTY PROPERTY1 = new PROPERTY();
        PROPERTY1.VALUE = "#";
        PROPERTY1.NAME = "lineComment";
        PROPERTY PROPERTY2 = new PROPERTY();
        PROPERTY2.VALUE = "true";
        PROPERTY2.NAME = "contextInsensitive";
        PROPS1.PROPERTY = new PROPERTY[] { PROPERTY1, PROPERTY2, };

        return PROPS1;
    }

    private RULES RULES1() {
        RULES RULES1 = new RULES();
        RULES1.HIGHLIGHT_DIGITS = "TRUE";
        RULES1.IGNORE_CASE = "FALSE";
        EOL_SPAN EOL_SPAN1 = new EOL_SPAN();
        EOL_SPAN1.text = "#";
        EOL_SPAN1.TYPE = "COMMENT1";
        KEYWORDS KEYWORDS1 = new KEYWORDS();
        KEYWORDS1.add("LITERAL2", new String[]{"on", "off", "allow", "deny", });
        KEYWORDS1.add("KEYWORD1", new String[]{"http_port", "https_port", "ssl_unclean_shutdown", "icp_port", "htcp_port", "mcast_groups", "udp_incoming_address", "udp_outgoing_address", "cache_peer", "cache_peer_domain", "neighbor_type_domain", "icp_query_timeout", "maximum_icp_query_timeout", "mcast_icp_query_timeout", "dead_peer_timeout", "hierarchy_stoplist", "no_cache", "cache_mem", "cache_swap_low", "cache_swap_high", "maximum_object_size", "minimum_object_size", "maximum_object_size_in_memory", "ipcache_size", "ipcache_low", "ipcache_high", "fqdncache_size", "cache_replacement_policy", "memory_replacement_policy", "cache_dir", "cache_access_log", "cache_log", "cache_store_log", "cache_swap_log", "emulate_httpd_log", "log_ip_on_direct", "mime_table", "log_mime_hdrs", "useragent_log", "referer_log", "pid_filename", "debug_options", "log_fqdn", "client_netmask", "ftp_user", "ftp_list_width", "ftp_passive", "ftp_sanitycheck", "cache_dns_program", "dns_children", "dns_retransmit_interval", "dns_timeout", "dns_defnames", "dns_nameservers", "hosts_file", "diskd_program", "unlinkd_program", "pinger_program", "redirect_program", "redirect_children", "redirect_rewrites_host_header", "redirector_access", "auth_param", "authenticate_cache_garbage_interval", "authenticate_ttl", "authenticate_ip_ttl", "external_acl_type", "wais_relay_host", "wais_relay_port", "request_header_max_size", "request_body_max_size", "refresh_pattern", "quick_abort_min", "quick_abort_max", "quick_abort_pct", "negative_ttl", "positive_dns_ttl", "negative_dns_ttl", "range_offset_limit", "connect_timeout", "peer_connect_timeout", "read_timeout", "request_timeout", "persistent_request_timeout", "client_lifetime", "half_closed_clients", "pconn_timeout", "ident_timeout", "shutdown_lifetime", "acl", "http_access", "http_reply_access", "icp_access", "miss_access", "cache_peer_access", "ident_lookup_access", "tcp_outgoing_tos", "tcp_outgoing_address", "reply_body_max_size", "cache_mgr", "cache_effective_user", "cache_effective_group", "visible_hostname", "unique_hostname", "hostname_aliases", "announce_period", "announce_host", "announce_file", "announce_port", "httpd_accel_host", "httpd_accel_port", "httpd_accel_single_host", "httpd_accel_with_proxy", "httpd_accel_uses_host_header", "dns_testnames", "logfile_rotate", "append_domain", "tcp_recv_bufsize", "err_html_text", "deny_info", "memory_pools", "memory_pools_limit", "forwarded_for", "log_icp_queries", "icp_hit_stale", "minimum_direct_hops", "minimum_direct_rtt", "cachemgr_passwd", "store_avg_object_size", "store_objects_per_bucket", "client_db", "netdb_low", "netdb_high", "netdb_ping_period", "query_icmp", "test_reachability", "buffered_logs", "reload_into_ims", "always_direct", "never_direct", "header_access", "header_replace", "icon_directory", "error_directory", "maximum_single_addr_tries", "snmp_port", "snmp_access", "snmp_incoming_address", "snmp_outgoing_address", "as_whois_server", "wccp_router", "wccp_version", "wccp_incoming_address", "wccp_outgoing_address", "delay_pools", "delay_class", "delay_access", "delay_parameters", "delay_initial_bucket_level", "incoming_icp_average", "incoming_http_average", "incoming_dns_average", "min_icp_poll_cnt", "min_dns_poll_cnt", "min_http_poll_cnt", "max_open_disk_fds", "offline_mode", "uri_whitespace", "broken_posts", "mcast_miss_addr", "mcast_miss_ttl", "mcast_miss_port", "mcast_miss_encode_key", "nonhierarchical_direct", "prefer_direct", "strip_query_terms", "coredump_dir", "redirector_bypass", "ignore_unknown_nameservers", "digest_generation", "digest_bits_per_entry", "digest_rebuild_period", "digest_rewrite_period", "digest_swapout_chunk_size", "digest_rebuild_chunk_percentage", "chroot", "client_persistent_connections", "server_persistent_connections", "pipeline_prefetch", "extension_methods", "request_entities", "high_response_time_warning", "high_page_fault_warning", "high_memory_warning", "store_dir_select_algorithm", "forward_log", "ie_refresh", "vary_ignore_expire", "sleep_after_fork", });
        KEYWORDS1.add("KEYWORD2", new String[]{"dst", "src", "method", "port", "proxy_auth", });
        RULES1.EOL_SPAN = new EOL_SPAN[] { EOL_SPAN1, };

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
