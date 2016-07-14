
package com.jecelyin.editor.v2.highlight.jedit;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Reader;
import java.util.LinkedList;
import java.util.List;
import java.util.Properties;

class PropertyManager {
    //{{{ getProperties() method
    Properties getProperties() {
        Properties total = new Properties();
        total.putAll(system);
        for (Properties plugin : plugins)
            total.putAll(plugin);
        total.putAll(site);
        total.putAll(localization);
        for (Properties pluginLocalization : pluginLocalizations)
            total.putAll(pluginLocalization);
        total.putAll(user);
        return total;
    } //}}}

    //{{{ loadSystemProps() method
    void loadSystemProps(Reader in)
            throws IOException {
        loadProps(system, in);
    } //}}}

    //{{{ loadSiteProps() method
    void loadSiteProps(InputStream in)
            throws IOException {
        loadProps(site, in);
    } //}}}

    //{{{ loadLocalizationProps() method
    void loadLocalizationProps(Reader in)
            throws IOException {
        if (in == null)
            localization.clear();
        else
            loadProps(localization, in);
    } //}}}

    //{{{ loadUserProps() method
    void loadUserProps(InputStream in)
            throws IOException {
        loadProps(user, in);
    } //}}}

    //{{{ saveUserProps() method
    void saveUserProps(OutputStream out)
            throws IOException {
        user.store(out, "jEdit properties");
    } //}}}

    //{{{ loadPluginProps() method
    Properties loadPluginProps(InputStream in)
            throws IOException {
        Properties plugin = new Properties();
        loadProps(plugin, in);
        plugins.add(plugin);
        return plugin;
    } //}}}

    //{{{ addPluginProps() method
    void addPluginProps(Properties props) {
        plugins.add(props);
    } //}}}

    //{{{ removePluginProps() method
    void removePluginProps(Properties props) {
        plugins.remove(props);
    } //}}}

    //{{{ loadPluginLocalizationProps() method
    Properties loadPluginLocalizationProps(Reader in)
            throws IOException {
        Properties pluginLocalization = new Properties();
        loadProps(pluginLocalization, in);
        pluginLocalizations.add(pluginLocalization);
        return pluginLocalization;
    } //}}}

    //{{{ addPluginLocalizationProps() method
    void addPluginLocalizationProps(Properties props) {
        pluginLocalizations.add(props);
    } //}}}

    //{{{ removePluginLocalizationProps() method
    void removePluginLocalizationProps(Properties props) {
        pluginLocalizations.remove(props);
    } //}}}

    //{{{ getProperty() method
    String getProperty(String name) {
        String value = user.getProperty(name);
        if (value != null)
            return value;

        for (Properties pluginLocalization : pluginLocalizations) {
            value = pluginLocalization.getProperty(name);
            if (value != null)
                return value;
        }

        value = localization.getProperty(name);
        if (value != null)
            return value;

        return getDefaultProperty(name);
    } //}}}

    //{{{ setProperty() method
    void setProperty(String name, String value) {
        String prop = getDefaultProperty(name);

		/* if value is null:
         * - if default is null, unset user prop
		 * - else set user prop to ""
		 * else
		 * - if default equals value, ignore
		 * - if default doesn't equal value, set user
		 */
        if (value == null) {
            if (prop == null || prop.length() == 0)
                user.remove(name);
            else
                user.setProperty(name, "");
        } else {
            if (value.equals(prop))
                user.remove(name);
            else
                user.setProperty(name, value);
        }
    } //}}}

    //{{{ setTemporaryProperty() method
    public void setTemporaryProperty(String name, String value) {
        user.remove(name);
        system.setProperty(name, value);
    } //}}}

    //{{{ unsetProperty() method
    void unsetProperty(String name) {
        if (getDefaultProperty(name) != null)
            user.setProperty(name, "");
        else
            user.remove(name);
    } //}}}

    //{{{ resetProperty() method
    public void resetProperty(String name) {
        user.remove(name);
    } //}}}

    //{{{ Private members
    private final Properties system = new Properties();
    private final List<Properties> plugins = new LinkedList<Properties>();
    private final Properties site = new Properties();
    private final Properties localization = new Properties();
    private final List<Properties> pluginLocalizations = new LinkedList<Properties>();
    private final Properties user = new Properties();

    //{{{ getDefaultProperty() method
    private String getDefaultProperty(String name) {
        String value = site.getProperty(name);
        if (value != null)
            return value;

        for (Properties plugin : plugins) {
            value = plugin.getProperty(name);
            if (value != null)
                return value;
        }

        return system.getProperty(name);
    } //}}}

    //{{{ loadProps() method
    private static void loadProps(Properties into, InputStream in)
            throws IOException {
        try {
            into.load(in);
        } finally {
            in.close();
        }
    } //}}}

    //{{{ loadProps() method
    private static void loadProps(Properties into, Reader in)
            throws IOException {
        try {
            into.load(in);
        } finally {
            in.close();
        }
    } //}}}

    //}}}
}
