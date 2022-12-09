// AboutActivity


package ca.on.conestogac.dynamicdevelopers;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class AboutActivity extends AppCompatActivity {

    // declare variables
    private Button buttonGurjot;
    private Button buttonHarshit;
    private Button buttonManpreet;
    private Button buttonViva;
    private ImageView imageViewDeveloper;
    private TextView developerInfo;
    private TextView devMail;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // set main theme for application
        setTheme(R.style.Theme_DynamicDevelopers);

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        // assign variables in the OnCreate
        buttonGurjot = findViewById(R.id.gurjot);
        buttonHarshit = findViewById(R.id.harshit);
        buttonManpreet = findViewById(R.id.manpreet);
        buttonViva = findViewById(R.id.viva);
        developerInfo = findViewById(R.id.developerInfo);
        devMail = findViewById(R.id.devMail);
        imageViewDeveloper = findViewById(R.id.imageViewDeveloper);
        devMail.setVisibility(View.INVISIBLE);
        imageViewDeveloper.setVisibility(View.INVISIBLE);

        // listener for event when gurjot button is clicked by app user
        buttonGurjot.setOnClickListener(view -> {
            // set users image view to rock
            // imageViewDeveloper.setImageResource(R.drawable.ic_gurjot);
            // set developer textView
            developerInfo.setText("Gurjot Singh");
            devMail.setVisibility(View.VISIBLE);
            imageViewDeveloper.setVisibility(View.VISIBLE);
            devMail.setText("Gurjotsingh6992@conestogac.on.ca");
            imageViewDeveloper.setImageResource(R.drawable.ic_vector_gurjot);
            devMail.setAlpha(0f);
            devMail.animate().alpha(1f).setDuration(2000);
            imageViewDeveloper.setAlpha(0f);
            imageViewDeveloper.animate().alpha(1f).setDuration(1000);
        });

        // listener for event when harshit button is clicked by app user
        buttonHarshit.setOnClickListener(view -> {
            // set developer imageView to harshit
            // imageViewDeveloper.setImageResource(R.drawable.ic_harshit);
            // set developer textView
            developerInfo.setText("Harshit Bhardwaj");
            devMail.setVisibility(View.VISIBLE);
            imageViewDeveloper.setVisibility(View.VISIBLE);
            devMail.setText("hbhardwaj6993@conestogac.on.ca");
            imageViewDeveloper.setImageResource(R.drawable.ic_vector_harshit);
            devMail.setAlpha(0f);
            devMail.animate().alpha(1f).setDuration(2000);
            imageViewDeveloper.setAlpha(0f);
            imageViewDeveloper.animate().alpha(1f).setDuration(1000);
        });

        // listener for event when manpreet button is clicked by app user
        buttonManpreet.setOnClickListener(view -> {
            // set developer imageView to manpreet
            //imageViewDeveloper.setImageResource(R.drawable.ic_manpreet);
            // set developer textView
            developerInfo.setText("Manpreet Kaur");
            devMail.setVisibility(View.VISIBLE);
            imageViewDeveloper.setVisibility(View.VISIBLE);
            devMail.setText("Mkaur7019@conestogac.on.ca");
            imageViewDeveloper.setImageResource(R.drawable.ic_vector_manpreet);
            devMail.setAlpha(0f);
            devMail.animate().alpha(1f).setDuration(2000);
            imageViewDeveloper.setAlpha(0f);
            imageViewDeveloper.animate().alpha(1f).setDuration(1000);
        });

        // listener for event when viva button is clicked by app user
        buttonViva.setOnClickListener(view -> {
            // set developer imageView to viva`s image
            //imageViewDeveloper.setImageResource(R.drawable.ic_viva);
            // set developer textView
            developerInfo.setText("Viva Batista");
            devMail.setVisibility(View.VISIBLE);
            imageViewDeveloper.setVisibility(View.VISIBLE);
            devMail.setText("Vbatista4879@conestogac.on.ca");
            imageViewDeveloper.setImageResource(R.drawable.ic_vector_viva);
            devMail.setAlpha(0f);
            devMail.animate().alpha(1f).setDuration(2000);
            imageViewDeveloper.setAlpha(0f);
            imageViewDeveloper.animate().alpha(1f).setDuration(1000);
        });

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

        switch (item.getItemId()){
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