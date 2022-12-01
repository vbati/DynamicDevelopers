package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        // display back button on actionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
    }

    @Override
    // listener for when back button is clicked
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        boolean return_selection = true;

        switch (item.getItemId()) {
            case android.R.id.home:
                super.onBackPressed();
                break;
            default:
                return_selection = super.onOptionsItemSelected(item);
                break;
        }
        return return_selection;
    }

}