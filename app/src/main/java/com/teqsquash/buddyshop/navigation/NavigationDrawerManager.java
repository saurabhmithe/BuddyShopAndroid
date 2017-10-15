package com.teqsquash.buddyshop.navigation;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.view.View;
import android.widget.TextView;

import com.teqsquash.buddyshop.R;
import com.teqsquash.buddyshop.activity.GroupActivity;
import com.teqsquash.buddyshop.activity.ListActivity;
import com.teqsquash.buddyshop.activity.MyProfileActivity;
import com.teqsquash.buddyshop.activity.SettingsActivity;

/**
 * Created by SAURABH on 3/20/2016.
 */
public class NavigationDrawerManager {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle drawerToggle;
    private Activity activity;

    public NavigationDrawerManager(Activity actvty) {
        activity = actvty;
        drawerLayout = (DrawerLayout) activity.findViewById(R.id.drawer_layout_recents);
        drawerToggle = new ActionBarDrawerToggle(activity, drawerLayout, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);

                activity.invalidateOptionsMenu();
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);

                activity.invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
    }

    public DrawerLayout getDrawerLayout() {
        return drawerLayout;
    }

    public ActionBarDrawerToggle getDrawerToggle() {
        return drawerToggle;
    }

    public void setClickHandlers() {
        TextView myProfileTextView = (TextView) activity.findViewById(R.id.myProfilePage);
        myProfileTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(activity instanceof MyProfileActivity)) {
                    Intent intent = new Intent(activity, MyProfileActivity.class);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    activity.finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        TextView listsTextView = (TextView) activity.findViewById(R.id.listsPage);
        listsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(activity instanceof ListActivity)) {
                    Intent intent = new Intent(activity, ListActivity.class);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    activity.finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        TextView groupsTextView = (TextView) activity.findViewById(R.id.groupsPage);
        groupsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(activity instanceof GroupActivity)) {
                    Intent intent = new Intent(activity, GroupActivity.class);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    activity.finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });

        TextView settingsTextView = (TextView) activity.findViewById(R.id.settingsPage);
        settingsTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!(activity instanceof SettingsActivity)) {
                    Intent intent = new Intent(activity, SettingsActivity.class);
                    activity.startActivity(intent);
                    activity.overridePendingTransition(R.anim.fade_in, R.anim.fade_out);
                    activity.finish();
                }
                drawerLayout.closeDrawer(GravityCompat.START);
            }
        });
    }
}
