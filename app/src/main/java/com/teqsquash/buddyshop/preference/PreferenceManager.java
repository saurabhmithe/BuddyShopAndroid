package com.teqsquash.buddyshop.preference;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by saurabh on 10/14/17.
 */

public class PreferenceManager {

    private static SharedPreferences sharedPreferences = null;

    private PreferenceManager() {

    }

    public static void initializePreferenceManager(Context context) {
        if (sharedPreferences == null) {
            sharedPreferences = android.support.v7.preference.PreferenceManager.getDefaultSharedPreferences(context);
        }
    }

    public static SharedPreferences getSharedPreferencesInstance() {
        return sharedPreferences;
    }
}
