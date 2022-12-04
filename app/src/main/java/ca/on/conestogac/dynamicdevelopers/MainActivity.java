// FinalProject:
// Group 4: Dynamic Developers - Quizlet
// Programming: Mobile Applications II
// Created: 11/28/2022
// Last modified: 12/03/2022 VB
// Resources used:
// https://developer.android.com/
// https://conestoga.desire2learn.com/

package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.preference.PreferenceManager;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    // declared variables
    private SharedPreferences sharedPref;
    TextView questionsRemaining;
    TextView questionView;
    Button answerA;
    Button answerB;
    Button answerC;
    Button answerD;
    String usersAnswer = "";
    int score = 0;
    int remainingQuestions = 0;
    int currentQuestionIndex = 0;
    int totalQuizletQuestions = QuizletActivity.questions.length;
    ArrayList<Integer> randomArray = new ArrayList<Integer>();

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // set main theme for Quizlet application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Find all needed ids on main activity
        questionsRemaining = findViewById(R.id.questionsRemaining);
        questionView =findViewById(R.id.questionView);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        // random questions so they are not always in same order
        for(int i = 0; i < totalQuizletQuestions; i++)
        {
            randomArray.add(i);
            Collections.shuffle(randomArray);
        }

        // When game first starts Player Name is empty and prompt them to fill it in via settings tab
        questionsRemaining.setText("Please Go To Settings And Enter Player Name");
        // pop the first element in randomized array from above and set to current index
        currentQuestionIndex = (int) randomArray.get(0);
        randomArray.remove(0);

        // set onClickListener to all answer buttons
        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);

        // display questions in main activity
        displayQuestion();

        // Preference manager
        PreferenceManager.setDefaultValues(this, R.xml.root_preferences, false);
        // Read and modify saved inputs
        sharedPref = PreferenceManager.getDefaultSharedPreferences(this);
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

    @Override
    public void onClick(View view) {
        Button selectedButton = (Button) view;
        usersAnswer = selectedButton.getText().toString();

        var getCorrectAnswer = QuizletActivity.answers[currentQuestionIndex];
        if(getCorrectAnswer == usersAnswer){
            score++;
            Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "You are very wrong", Toast.LENGTH_SHORT).show();
        }

        if(randomArray.size() == 0)
        {
            Intent newIntent = new Intent(getApplicationContext(), GameOverActivity.class);
            newIntent.putExtra("correctAnswers",score);
            newIntent.putExtra("totalQuestions",totalQuizletQuestions);
            String fetchPlayerName = sharedPref.getString("player_name", "");
            newIntent.putExtra("userName", fetchPlayerName);
            startActivity(newIntent);
        }
        currentQuestionIndex = (int) randomArray.get(0);

        randomArray.remove(0);
        String getStringFromTextView = questionsRemaining.getText().toString();
        if(getStringFromTextView.contains("Welcome"))
        {
            String fetchPlayerName = sharedPref.getString("player_name", "");
            questionsRemaining.setText(fetchPlayerName + " you have " + String.valueOf(remainingQuestions) + " questions remaining");
        }
        displayQuestion();
    }

    //
    void displayQuestion(){
        questionView.setText(QuizletActivity.questions[currentQuestionIndex]);
        answerA.setText(QuizletActivity.options[currentQuestionIndex][0]);
        answerB.setText(QuizletActivity.options[currentQuestionIndex][1]);
        answerC.setText(QuizletActivity.options[currentQuestionIndex][2]);
        answerD.setText(QuizletActivity.options[currentQuestionIndex][3]);
    }

    @Override
    // listener for event when app is reactivated or resumed
    protected void onResume() {
        super.onResume();
        Intent intent = new Intent();
        boolean fetchThemeToggle = sharedPref.getBoolean("toggle_dark_theme", false);
        String fetchPlayerName = sharedPref.getString("player_name", "");
        if(fetchPlayerName == ""){
            questionsRemaining.setText("Please Go To Settings And Enter Player Name");
        }
        else{
            questionsRemaining.setText("Welcome " + fetchPlayerName + " you have " + String.valueOf(remainingQuestions) + " questions remaining");
        }

        if (fetchThemeToggle != true) {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        } else {
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        // retrieve game theme settings selections
        // toggleSave = sharedPref.getBoolean("toggle_save", false);
        boolean toggleTheme = sharedPref.getBoolean("toggle_dark_theme", false);
    }
}