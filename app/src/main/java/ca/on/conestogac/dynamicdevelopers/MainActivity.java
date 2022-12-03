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

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView questionsRemaining;
    TextView questionView;
    Button answerA;
    Button answerB;
    Button answerC;
    Button answerD;

    // declare variables
    int score = 0;
    int totalQuizletQuestions = QuizletActivity.questions.length;
    int currentQuestionIndex = 0;
    String usersAnswer = "";
    int remainingQuestions = 0;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        questionsRemaining = findViewById(R.id.questionsRemaining);
        questionView =findViewById(R.id.questionView);
        answerA = findViewById(R.id.answerA);
        answerB = findViewById(R.id.answerB);
        answerC = findViewById(R.id.answerC);
        answerD = findViewById(R.id.answerD);

        // set onClickListener to all answer buttons
        answerA.setOnClickListener(this);
        answerB.setOnClickListener(this);
        answerC.setOnClickListener(this);
        answerD.setOnClickListener(this);

        displayQuestion();
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
            Toast.makeText(this, "You are correct", Toast.LENGTH_SHORT).show();
        }
        else{
            Toast.makeText(this, "You are very wrong", Toast.LENGTH_SHORT).show();
        }

        currentQuestionIndex++;
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
}