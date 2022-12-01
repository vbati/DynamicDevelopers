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
     //   imageViewDeveloper = findViewById(R.id.imageViewDeveloper);

        // listener for event when gurjot button is clicked by app user
        buttonGurjot.setOnClickListener(view -> {
                    // set users image view to rock
                   // imageViewDeveloper.setImageResource(R.drawable.ic_gurjot);
            // set developer textView
            developerInfo.setText("Gurjot");
        });

        // listener for event when harshit button is clicked by app user
        buttonHarshit.setOnClickListener(view -> {
            // set developer imageView to harshit
           // imageViewDeveloper.setImageResource(R.drawable.ic_harshit);
            // set developer textView
            developerInfo.setText("Harshit");
        });

        // listener for event when manpreet button is clicked by app user
        buttonManpreet.setOnClickListener(view -> {
            // set developer imageView to manpreet
            //imageViewDeveloper.setImageResource(R.drawable.ic_manpreet);
            // set developer textView
            developerInfo.setText("Manpreet");
        });

        // listener for event when viva button is clicked by app user
        buttonViva.setOnClickListener(view -> {
            // set developer imageView to viva`s image
           //imageViewDeveloper.setImageResource(R.drawable.ic_viva);
            // set developer textView
            developerInfo.setText("Viva Batista");
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