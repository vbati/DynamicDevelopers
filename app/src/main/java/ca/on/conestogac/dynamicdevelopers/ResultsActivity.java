package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

public class ResultsActivity extends AppCompatActivity {

    private QuizletDatabaseHandler quizletDatabaseHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        quizletDatabaseHandler = new QuizletDatabaseHandler(ResultsActivity.this);

        // display back button on actionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        var tryingThisOut = quizletDatabaseHandler.Top10Results();

        var firstScore = tryingThisOut.get(0).getScore();
        Toast.makeText(this, firstScore, Toast.LENGTH_SHORT).show();
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