// Quiz Activity
// Sources Used:

package ca.on.conestogac.dynamicdevelopers;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class QuizletActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
    }

    // list of questions used
    public static String questions [] = {
            " What provides essential information about an application for the Android OS? ",
            " What is the name of the service that interfaces the emulator or physical device with your computer?",
            " What provides the window in which the application draws its UI? ",
            " ",
            " What layouts align views horizontally or vertically and do not require extra work to correctly position?",
            " When working with layouts, what would you use to take up the maximum space? ",
            " ",
            " ",
            " Which is not an SQLite data type",
            " ",

    };

    // list of options that will be visible on the four buttons in thw MainActivity
   public static String options [] [] = {
            {"AndroidManifest.xml", "somequestion2", "some answer3", "some answer4"},
            {"Android Debug Bridge", "somequestion2", "some answer3", "some answer4"},
            {"Activity", "somequestion2", "some answer3", "some answer4"},
            {"", "somequestion2", "some answer3", "some answer4"},
            {"Relative", "Linear", "Horizontal", "Nested"},
            {"wrap_parent", "match_parent", "match_layout", "wrap_content"},
            {"", "somequestion2", "some answer3", "some answer4"},
            {"", "somequestion2", "some answer3", "some answer4"},
            {"Integer", "Real", "Text", "String"},
            {"", "somequestion2", "some answer3", "some answer4"},

    };

    public static String answers [] ={
            "AndroidManifest.xml",
            "Android Debug Bridge",
            "Activity",
            "",
            "Linear",
            "match_parent",
            "",
            "",
            "String",
            "",
    };


}