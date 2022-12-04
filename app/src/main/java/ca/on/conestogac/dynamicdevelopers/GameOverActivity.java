package ca.on.conestogac.dynamicdevelopers;

import androidx.appcompat.app.AppCompatActivity;
import androidx.preference.PreferenceManager;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class GameOverActivity extends AppCompatActivity {

    // declare variables to hold views
    private static final DecimalFormat df = new DecimalFormat("0.00");
    private SharedPreferences sharedPref;
    private ImageView imageViewGameResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);

        // assign variables in the OnCreate
        //buttonReset = findViewById(R.id.button_reset);
        //textViewGameResult =findViewById(R.id.game_over_results);
        setContentView(R.layout.activity_game_over);
        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);
        // Read and modify saved inputs
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);

        Intent intent = getIntent();
        String fetchPlayerName = intent.getStringExtra("userName");
        float fetchCorrectAnswers = (float)intent.getIntExtra("correctAnswers", 0);
        float fetchTotalQuestions = (float)intent.getIntExtra("totalQuestions", 0);

        float calculateGamePercentage = (fetchCorrectAnswers / fetchTotalQuestions) * 100;
        Toast.makeText(this, String.valueOf(calculateGamePercentage), Toast.LENGTH_SHORT).show();
        imageViewGameResult = findViewById(R.id.show_game_result);
        imageViewGameResult.setImageResource(R.drawable.ic_launcher_winner_cup);

        // if player`s game results are greater than 50%
        if(calculateGamePercentage > 50.0){
            imageViewGameResult = findViewById(R.id.show_game_result);
            imageViewGameResult.setImageResource(R.drawable.ic_launcher_winner_cup);
        }
        else{
            imageViewGameResult = findViewById(R.id.show_game_result);
            imageViewGameResult.setImageResource(R.drawable.ic_launcher_losing_cup);
        }

        // listener for event when reset button is clicked by player
        //buttonReset.setOnClickListener(view -> {
         //   finish();
          //  startActivity(new Intent(getApplicationContext(), MainActivity.class));
        //});

    }
}