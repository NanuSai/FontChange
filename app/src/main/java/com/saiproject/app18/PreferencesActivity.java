package com.saiproject.app18;

import android.os.Bundle;
import android.preference.PreferenceActivity;

public class PreferencesActivity extends PreferenceActivity {       //PreferenceActivity is needed to use intent


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences_files); //preferences_files is referenced here (similar to setContent view)

    }
}
