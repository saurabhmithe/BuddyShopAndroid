package com.teqsquash.buddyshop.activity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.teqsquash.buddyshop.R;
import com.teqsquash.buddyshop.navigation.NavigationDrawerManager;
import com.teqsquash.buddyshop.preference.PreferenceManager;

public class SettingsActivity extends AppCompatActivity {

    LinearLayout logoutButton;
    private NavigationDrawerManager drawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize navigation drawer and related click handlers
        drawerManager = new NavigationDrawerManager(this);
        drawerManager.setClickHandlers();

        // Highlight current page in the navigation drawer
        TextView accountsTextView = (TextView) findViewById(R.id.settingsPage);
        accountsTextView.setTextColor(getResources().getColor(R.color.colorAccent));

        logoutButton = (LinearLayout) findViewById(R.id.logoutButton);
        logoutButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                showLogoutConfirmationDialog();
            }
        });

    }

    @Override
    public void onBackPressed() {
        boolean isDrawerOpen = drawerManager.getDrawerLayout().isDrawerOpen(GravityCompat.START);
        if (isDrawerOpen) {
            drawerManager.getDrawerLayout().closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    protected void onStart() {
        drawerManager.setClickHandlers();
        super.onStart();
    }

    // For slide drawer icon and arrow transition
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        drawerManager.getDrawerToggle().syncState();
    }

    // Assign functionality to action bar icons
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle
        // If it returns true, then it has handled
        // the nav drawer indicator touch event
        if (drawerManager.getDrawerToggle().onOptionsItemSelected(item)) {
            return true;
        }

        // Handle your other action bar items...

        return super.onOptionsItemSelected(item);
    }


    private void showLogoutConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Do you wish to log out?");
        builder.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                PreferenceManager.getSharedPreferencesInstance().edit().putBoolean(getString(R.string.logout_key), true).apply();
                startActivity(new Intent(SettingsActivity.this, LoginActivity.class));
                SettingsActivity.this.finishAffinity();
                Toast.makeText(SettingsActivity.this, "Successfully Logged Out", Toast.LENGTH_LONG).show();
            }
        });
        builder.setNegativeButton("NO", null);
        builder.create().show();
    }
}
