// Quiz Activity used to hold questions, question options and correct answers
// Sources Used to develop questions:https://conestoga.desire2learn.com/d2l/home/628810

package ca.on.conestogac.dynamicdevelopers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game_over);
    }

    // list of questions used in Quizlet
    public static String questions [] = {
            "What provides essential information about an application for the Android OS? ",
            "What is the name of the service that interfaces the emulator or physical device with your computer?",
            "What provides the window in which the application draws its UI? ",
            //"What method in the main activity`s onCreate is used to change back to the original theme?",
            //"What layouts align views horizontally or vertically and do not require extra work to correctly position?",
            //"When working with layouts, what would you use to take up the maximum space? ",
            //"What allows an application to run code in the background even if application is deactivated? ",
            //"What method do you need to call to stop a timer from re-executing code at the next interval",
            //"Which is not an SQLite data type",
            //"Where do you create a new directory for a menu?",
    };

    // list of a list to store options per question
   public static String options [] [] = {
            {"Manifest", "Resources", "Gradle", "Preferences"},
            {"Debug Bridge", "somequestion2", "some answer3", "some answer4"},
            {"Activity", "Intent", "Preferences", "Layout"},
            //{"getTheme", "setTheme", "setView", "themeSet"},
            //{"Relative", "Linear", "Horizontal", "Nested"},
            //{"wrap_parent", "match_parent", "match_layout", "wrap_content"},
            //{"Service", "Preferences", "Intent", "Activity"},
            //{"destroy()", "hold()", "stop()", "cancel()"},
            //{"Integer", "Real", "Text", "String"},
            //{"layout", "res", "java", "mipmap"},
    };

    // list of correct answers
    public static String answers [] ={
            "AndroidManifest.xml",
            "Debug Bridge",
            "Activity",
            //"setTheme",
            //"Linear",
            //"match_parent",
            //"Service",
            //"cancel()",
            //"String",
            //"Res",
    };
}