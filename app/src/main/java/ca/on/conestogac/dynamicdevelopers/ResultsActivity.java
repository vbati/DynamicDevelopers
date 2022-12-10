package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Collections;
import java.util.Comparator;

public class ResultsActivity extends AppCompatActivity {

    private QuizletDatabaseHandler quizletDatabaseHandler;

    TextView firstPlacePlayerName;
    TextView secondPlacePlayerName;
    TextView thirdPlacePlayerName;
    TextView fourthPlacePlayerName;
    TextView fifthPlacePlayerName;

    TextView firstPlaceScore;
    TextView secondPlaceScore;
    TextView thirdPlaceScore;
    TextView fourthPlaceScore;
    TextView fifthPlaceScore;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        quizletDatabaseHandler = new QuizletDatabaseHandler(ResultsActivity.this);

        firstPlacePlayerName = findViewById(R.id.firstPlacePlayerName);
        secondPlacePlayerName = findViewById(R.id.secondPlacePlayerName);
        thirdPlacePlayerName = findViewById(R.id.thirdPlacePlayerName);
        fourthPlacePlayerName = findViewById(R.id.fourthPlacePlayerName);
        fifthPlacePlayerName = findViewById(R.id.fifthPlacePlayerName);

        firstPlaceScore = findViewById(R.id.firstPlaceScore);
        secondPlaceScore = findViewById(R.id.secondPlaceScore);
        thirdPlaceScore = findViewById(R.id.thirdPlaceScore);
        fourthPlaceScore = findViewById(R.id.fourthPlaceScore);
        fifthPlaceScore = findViewById(R.id.fifthPlaceScore);



        // display back button on actionBar
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
        }
        var tryingThisOut = quizletDatabaseHandler.Top10Results();

        var getSizeOfArray = tryingThisOut.size();


        Collections.sort(tryingThisOut, new Comparator<TopResults>() {
            @Override
            public int compare(TopResults topResults, TopResults t1) {
                return Float.compare(t1.getScore(), topResults.getScore());
            }
        });

        var iterationLoop = 4;
        if(getSizeOfArray < 5)
        {
            iterationLoop = getSizeOfArray - 1;
        }

        for(int i = 0; i <= iterationLoop; i++)
        {
            if ( i == 0)
            {
                firstPlacePlayerName.setText(tryingThisOut.get(i).getPlayerName());
                firstPlaceScore.setText(String.valueOf(tryingThisOut.get(i).getScore()));
            }
            if ( i == 1)
            {
                secondPlacePlayerName.setText(tryingThisOut.get(i).getPlayerName());
                secondPlaceScore.setText(String.valueOf(tryingThisOut.get(i).getScore()));
            }
            if ( i == 2)
            {
                thirdPlacePlayerName.setText(tryingThisOut.get(i).getPlayerName());
                thirdPlaceScore.setText(String.valueOf(tryingThisOut.get(i).getScore()));
            }
            if ( i == 3)
            {
                fourthPlacePlayerName.setText(tryingThisOut.get(i).getPlayerName());
                fourthPlaceScore.setText(String.valueOf(tryingThisOut.get(i).getScore()));
            }
            if ( i == 4)
            {
                fifthPlacePlayerName.setText(tryingThisOut.get(i).getPlayerName());
                fifthPlaceScore.setText(String.valueOf(tryingThisOut.get(i).getScore()));
            }
        }

        var firstScore = tryingThisOut.get(0).getScore();
        Toast.makeText(this, String.valueOf(firstScore), Toast.LENGTH_SHORT).show();
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