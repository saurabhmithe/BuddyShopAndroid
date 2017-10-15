package com.teqsquash.buddyshop.activity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.teqsquash.buddyshop.R;
import com.teqsquash.buddyshop.preference.PreferenceManager;

public class SplashActivity extends AppCompatActivity {

    private static final int DELAY = 2000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        PreferenceManager.initializePreferenceManager(this);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                // Create an Intent that will start the LoginActivity after the specified delay.
                Log.e("PREF", String.valueOf(PreferenceManager.getSharedPreferencesInstance().getBoolean(getString(R.string.logout_key), true)));
                if (PreferenceManager.getSharedPreferencesInstance().getBoolean(getString(R.string.logout_key), true)) {
                    Intent loginIntent = new Intent(SplashActivity.this, LoginActivity.class);
                    SplashActivity.this.startActivity(loginIntent);
                    SplashActivity.this.finish();
                } else {
                    Intent listIntent = new Intent(SplashActivity.this, ListActivity.class);
                    SplashActivity.this.startActivity(listIntent);
                    SplashActivity.this.finish();
                }

            }
        }, DELAY);
    }
}
