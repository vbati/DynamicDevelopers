// FinalProject:
// Group 4: Dynamic Developers
// Programming: Mobile Applications II
// Created: 11/28/2022
// Last modified: 11/28/2022
// Resources used:
// https://developer.android.com/
// https://conestoga.desire2learn.com/

package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


    }


    @Override
    // listener for orientation changes (landscape vs. portrait)
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);

        // Checks the screen orientation
        if (newConfig.orientation == Configuration.ORIENTATION_LANDSCAPE) {
        }
        else if (newConfig.orientation == Configuration.ORIENTATION_PORTRAIT){
        }
    }

    @Override
    // listener for event when menu has been handled, the menu will be displayed
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return true;
    }

    @Override
    // listener for which option is selected in menu
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean return_selection = true;

        switch (item.getItemId()){
            case R.id.menu_item:
                // Provide information to pass along to StartActivity to perform an action
                startActivity(new Intent(getApplicationContext(), ResultsActivity.class));
                break;
            case R.id.menu_settings:
                // Provide information to pass along to StartActivity to perform an action
                startActivity(new Intent(getApplicationContext(), SettingsActivity.class));
                break;
            case R.id.menu_about:
                // Provide information to pass along to StatisticsActivity to perform an action
                startActivity(new Intent(getApplicationContext(), AboutActivity.class));
                break;
            default:
                return_selection = super.onOptionsItemSelected(item);
                break;
        }
        return return_selection;
    }
}