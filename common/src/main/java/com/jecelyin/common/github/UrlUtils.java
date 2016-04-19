
package com.jecelyin.common.github;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.Map;
import java.util.Map.Entry;

import static com.jecelyin.common.github.IGitHubConstants.CHARSET_ISO_8859_1;

/**
 * URL utilities
 */
public abstract class UrlUtils {


    /**
     * URL-encode value using 'ISO-8859-1' character set
     *
     * @param value
     * @return encoded value
     */
    public static String encode(final String value) {
        try {
            return URLEncoder.encode(value, CHARSET_ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * URL-decode value using 'ISO-8859-1' character set
     *
     * @param value
     * @return encoded value
     */
    public static String decode(final String value) {
        try {
            return URLDecoder.decode(value, CHARSET_ISO_8859_1);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException(e);
        }
    }

    /**
     * Add encoded parameter to URI
     *
     * @param name
     * @param value
     * @param uri
     */
    public static void addParam(final String name, final String value,
                                final StringBuilder uri) {
        if (uri.length() > 0)
            uri.append('&');
        uri.append(encode(name)).append('=');
        if (value != null)
            uri.append(encode(value));
    }

    /**
     * Add request parameters to URI
     *
     * @param params
     * @param uri
     */
    public static void addParams(final Map<String, String> params,
                                 final StringBuilder uri) {
        if (params == null || params.isEmpty())
            return;
        for (Entry<String, String> param : params.entrySet())
            addParam(param.getKey(), param.getValue(), uri);
    }

    /**
     * Get parameter value with name
     *
     * @param uri
     * @param name
     * @return value or null if not found in URI query
     */
    public static String getParam(final URI uri, final String name) {
        final String query = uri.getRawQuery();
        if (query == null || query.length() == 0)
            return null;
        final String[] params = query.split("&"); //$NON-NLS-1$
        for (String param : params) {
            final String[] parts = param.split("="); //$NON-NLS-1$
            if (parts.length != 2)
                continue;
            if (!name.equals(parts[0]))
                continue;
            return decode(parts[1]);
        }
        return null;
    }
}
