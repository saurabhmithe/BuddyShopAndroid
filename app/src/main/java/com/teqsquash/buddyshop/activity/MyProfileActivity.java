package com.teqsquash.buddyshop.activity;

import android.os.Bundle;
import android.support.v4.view.GravityCompat;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;

import com.teqsquash.buddyshop.R;
import com.teqsquash.buddyshop.navigation.NavigationDrawerManager;

public class MyProfileActivity extends AppCompatActivity {

    private NavigationDrawerManager drawerManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_profile);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Initialize navigation drawer and related click handlers
        drawerManager = new NavigationDrawerManager(this);
        drawerManager.setClickHandlers();

        // Highlight current page in the navigation drawer
        TextView accountsTextView = (TextView) findViewById(R.id.myProfilePage);
        accountsTextView.setTextColor(getResources().getColor(R.color.colorAccent));

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
}

