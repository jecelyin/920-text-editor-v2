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

package com.jecelyin.editor.v2.ui.settings;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.preference.CheckBoxPreference;
import android.preference.EditTextPreference;
import android.preference.ListPreference;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.PreferenceGroup;

import com.jecelyin.common.utils.UIUtils;
import com.jecelyin.editor.v2.Pref;
import com.jecelyin.editor.v2.R;
import com.jecelyin.editor.v2.preference.JecListPreference;
import com.jecelyin.editor.v2.ui.AboutActivity;
import com.jecelyin.editor.v2.ui.BrowserActivity;
import com.jecelyin.editor.v2.ui.FeedbackActivity;

/**
 * @author Jecelyin Peng <jecelyin@gmail.com>
 */
public class SettingsFragment extends PreferenceFragment implements Preference.OnPreferenceClickListener {
    /**
     * A preference value change listener that updates the preference's summary
     * to reflect its new value.
     */
    private static Preference.OnPreferenceChangeListener sBindPreferenceSummaryToValueListener = new Preference.OnPreferenceChangeListener() {
        @Override
        public boolean onPreferenceChange(Preference preference, Object value) {
            if (value == null)
                return true;
            String stringValue = value.toString();
            String key = preference.getKey();

            if (preference instanceof ListPreference) {
                // For list preferences, look up the correct display value in
                // the preference's 'entries' list.
                ListPreference listPreference = (ListPreference) preference;
                int index = listPreference.findIndexOfValue(stringValue);

                // Set the summary to reflect the new value.
                preference.setSummary(
                        index >= 0
                                ? listPreference.getEntries()[index]
                                : null);
            } else if (preference instanceof CheckBoxPreference) {
                ((CheckBoxPreference) preference).setChecked((boolean) value);
            } else if("pref_highlight_file_size_limit".equals(key)) {
                preference.setSummary(stringValue + " KB");
            } else {
                // For all other preferences, set the summary to the value's
                // simple string representation.
                preference.setSummary(String.valueOf(stringValue));
            }

            return true;
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preference);

        dependBindPreference(getPreferenceScreen());

        findPreference("pref_about").setOnPreferenceClickListener(this);
        findPreference("pref_translate").setOnPreferenceClickListener(this);
        findPreference("pref_feedback").setOnPreferenceClickListener(this);
//        findPreference("pref_donate").setOnPreferenceClickListener(this);
    }

    @Override
    public boolean onPreferenceClick(Preference preference) {
        Intent it;
        switch (preference.getKey()) {
            case "pref_about":
                it = new Intent(getActivity(), AboutActivity.class);
                startActivity(it);
                break;
            case "pref_translate":
                UIUtils.OnClickCallback callback = new UIUtils.OnClickCallback() {
                    @Override
                    public void onOkClick() {
                        BrowserActivity.startActivity(getActivity(), getString(R.string.help_translate), "https://www.getlocalization.com/920_Text_Editor_v2/");
                    }

                    @Override
                    public void onCancelClick() {
                        Intent it = new Intent();
                        it.putExtra("key", "pref_translate");
                        getActivity().setResult(Activity.RESULT_OK, it);
                        getActivity().finish();
                    }
                };
                UIUtils.showConfirmDialog(getActivity(), 0, R.string.translate_confirm_message, callback, R.string.translate_external_text, R.string.translate_internal_text);
                break;
            case "pref_feedback":
                FeedbackActivity.startActivity(getActivity(), null);
                break;
            case "pref_donate":
                it = new Intent(Intent.ACTION_VIEW, Uri.parse("https://jecelyin.github.io/donate/?project=920%20Text%20Editor"));
                startActivity(it);
                break;
        }
        return true;
    }

    private static void dependBindPreference(PreferenceGroup pg) {
        int count = pg.getPreferenceCount();
        Preference preference;
        String key;
        Object value;

        Pref pref = Pref.getInstance(pg.getContext());

        for(int i = 0; i < count; i++) {
            preference = pg.getPreference(i);
            key = preference.getKey();

            if(preference instanceof PreferenceGroup) {
                dependBindPreference((PreferenceGroup) preference);
                continue;
            }

            Class<? extends Preference> cls = preference.getClass();
            if(cls.equals(Preference.class))
                continue;

            value = pref.getValue(key);

            if(preference instanceof JecListPreference) {
//                if("pref_font_size".equals(key)) {
//                    new FontSizePreference((JecListPreference)preference);
//                } else if("pref_cursor_width".equals(key)) {
//                    new CursorWidthPreference((JecListPreference)preference);
//                }
            } else if(preference instanceof EditTextPreference) {
                ((EditTextPreference)preference).setText(String.valueOf(value));
            } else if(preference instanceof CheckBoxPreference) {
                ((CheckBoxPreference)preference).setChecked((boolean)value);
            }

            if (!Pref.KEY_SYMBOL.equals(key))
                bindPreferenceSummaryToValue(preference);
        }
    }

    /**
     * Binds a preference's summary to its value. More specifically, when the
     * preference's value is changed, its summary (line of text below the
     * preference title) is updated to reflect the value. The summary is also
     * immediately updated upon calling this method. The exact display format is
     * dependent on the type of preference.
     *
     * @see #sBindPreferenceSummaryToValueListener
     */
    private static void bindPreferenceSummaryToValue(Preference preference) {
        // Set the listener to watch for value changes.
        preference.setOnPreferenceChangeListener(sBindPreferenceSummaryToValueListener);

        String key = preference.getKey();
        Object value = Pref.getInstance(preference.getContext()).getValue(key);
        sBindPreferenceSummaryToValueListener.onPreferenceChange(preference, value);
    }

}
