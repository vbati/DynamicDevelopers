// GameOverActivity screen used to display players Quizlet result

package ca.on.conestogac.dynamicdevelopers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.IOException;
import java.text.DecimalFormat;

public class GameOverActivity extends AppCompatActivity {

    // declare variables to hold views
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private SharedPreferences sharedPref;
    private ImageView imageViewGameResult;
    private Button buttonReset;
    private TextView textViewGameResult;
    private DBHandler dbHandler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        dbHandler = new DBHandler(GameOverActivity.this);

        // assign variables in the OnCreate
        setContentView(R.layout.activity_game_over);
        buttonReset = findViewById(R.id.button_reset);

        textViewGameResult = findViewById(R.id.game_over_results);
        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);
        // Read and modify saved inputs
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        boolean fetchThemeToggle = sharedPref.getBoolean("toggle_dark_theme", false);

        if (!fetchThemeToggle) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }
        Intent intent = getIntent();
        String fetchPlayerName = intent.getStringExtra("userName");
        float fetchCorrectAnswers = (float)intent.getIntExtra("correctAnswers", 0);
        float fetchTotalQuestions = (float)intent.getIntExtra("totalQuestions", 0);

        float calculateGamePercentage = (fetchCorrectAnswers / fetchTotalQuestions) * 100;

        imageViewGameResult = findViewById(R.id.show_game_result);

        // if player`s game results are greater than 50%
        imageViewGameResult = findViewById(R.id.show_game_result);
        try {
            dbHandler.AddUserScoreToDB(this, fetchPlayerName, calculateGamePercentage);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(calculateGamePercentage > 50.0){
            imageViewGameResult.setImageResource(R.drawable.ic_launcher_winner_cup);
            textViewGameResult.setText("Congrats on the Win " + fetchPlayerName + " your score was " + String.valueOf(calculateGamePercentage) + "%");
        }
        else{
            imageViewGameResult.setImageResource(R.drawable.ic_launcher_losing_cup);
            textViewGameResult.setText("You lose "+ fetchPlayerName + " your score was " + String.valueOf(calculateGamePercentage) + "%");
        }



        // listener for event when reset button is clicked by player
        buttonReset.setOnClickListener(view -> startActivity(new Intent(getApplicationContext(), MainActivity.class)));
    }
}