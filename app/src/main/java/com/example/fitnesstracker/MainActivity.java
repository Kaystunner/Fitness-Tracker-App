package com.example.fitnesstracker;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.MotionEvent;
import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.viewpager2.widget.ViewPager2;
import com.google.android.material.navigation.NavigationView;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import androidx.core.view.GravityCompat;


public class MainActivity extends AppCompatActivity {

    private DrawerLayout drawerLayout;
    private ActionBarDrawerToggle toggle;
    private BottomNavigationView bottomNavigationView;
    private ViewPager2 viewPager;
    private ViewPagerAdapter viewPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        bottomNavigationView = findViewById(R.id.bottom_navigation);
        viewPager = findViewById(R.id.view_pager);

        // Setting up the toggle for the navigation drawer
        toggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar,
                R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();

        // Set up ViewPager2 with the adapter
        viewPagerAdapter = new ViewPagerAdapter(this);
        viewPager.setAdapter(viewPagerAdapter);
        viewPager.setOffscreenPageLimit(2); // Keep 2 fragments in memory for performance

        // Handle navigation drawer item clicks
        navigationView.setNavigationItemSelectedListener(item -> {
            handleNavigationItemSelected(item);
            return true; // Return true to indicate item selection was handled
        });

        // Handle bottom navigation item clicks
        bottomNavigationView.setOnNavigationItemSelectedListener(item -> {
            handleBottomNavigationItemSelected(item);
            return true; // Return true to indicate item selection was handled
        });

        // Add a page change listener to the ViewPager2
        viewPager.registerOnPageChangeCallback(new ViewPager2.OnPageChangeCallback() {
            @Override
            public void onPageSelected(int position) {
                // Update the selected item in the bottom navigation view
                if (position == 0) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_home);
                } else if (position == 1) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_workouts);
                } else if (position == 2) {
                    bottomNavigationView.setSelectedItemId(R.id.nav_progress);
                }
            }
        });
    }

    // Method to handle navigation drawer item selection
    private void handleNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            viewPager.setCurrentItem(0); // Opens HomeFragment
        } else if (item.getItemId() == R.id.nav_progress) {
            viewPager.setCurrentItem(2); // Opens ProgressFragment
        } else if (item.getItemId() == R.id.nav_workouts) {
            viewPager.setCurrentItem(1); // Opens WorkoutFragment
        } else if (item.getItemId() == R.id.nav_profile) { // Opens ProfileActivity
            startActivity(new Intent(MainActivity.this, ProfileActivity.class));
        } else if (item.getItemId() == R.id.nav_settings) { // Opens SettingsActivity
            startActivity(new Intent(MainActivity.this, SettingsActivity.class));
        }
        drawerLayout.closeDrawers(); // Close the drawer after selection
    }

    // Method to handle bottom navigation item selection
    private void handleBottomNavigationItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.nav_home) {
            viewPager.setCurrentItem(0); // Go to HomeFragment
        } else if (item.getItemId() == R.id.nav_workouts) {
            viewPager.setCurrentItem(1); // Go to WorkoutFragment
        } else if (item.getItemId() == R.id.nav_progress) {
            viewPager.setCurrentItem(2); // Go to ProgressFragment
        }
    }

    @Override
    public void onBackPressed() {
        if (drawerLayout.isDrawerOpen(GravityCompat.START)) {
            drawerLayout.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.overflow_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Check which item was selected and handle it
        if (item.getItemId() == R.id.action_notification) {
            // Handle notification action
            return true;
        } else {
            return super.onOptionsItemSelected(item);
        }
    }

    // Disable swipe from the toolbar
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        // Check if the touch event is a move event
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            // If the touch is within the toolbar area, consume the event
            if (ev.getY() <= findViewById(R.id.toolbar).getHeight()) {
                return true; // Disable drawer swipe from the toolbar
            }
        }
        return super.dispatchTouchEvent(ev);
    }
}
