package ca.on.conestogac.dynamicdevelopers;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class QuizletDatabaseHandler extends SQLiteOpenHelper {

    // creating a constant variables for our database.
    // below variable is for our database name.
    private static final String DB_NAME = "coursedb";

    // below int is our database version
    private static final int DB_VERSION = 1;

    // below variable is for our table name.
    private static final String TABLE_NAME = "questionsFOrQuiz";
    private static final String RESULT_TABLE_NAME = "resultsForUser";


    // below variable is for our id column.
    private static final String ID_COL = "id";
    private static final String RESULT_ID_COL = "resultId";

    SQLiteDatabase mDB;


    // below variable is for our course name column
    private  String QUESTION = "question";
    private  String OPTION1 = "option1";
    private  String OPTION2 = "option2";
    private  String OPTION3 = "option3";
    private  String OPTION4 = "option4";
    private String ANSWER = "answer";
    public boolean tableAlreadyExists = false;

    //Results page
    private String USERNAME = "Blank";
    private String USERSCORE = "Blanks";


    // below variable id for our course duration column.
    // creating a constructor for our database handler.
    public QuizletDatabaseHandler(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
        mDB = this.getWritableDatabase();
    }

    // below method is for creating a database by running a sqlite query
    @Override
    public void onCreate(SQLiteDatabase db) {
        // on below line we are creating
        // an sqlite query and we are
        // setting our column names
        // along with their data types.
        String query = "CREATE TABLE " + TABLE_NAME + " ("
                + ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + QUESTION + " TEXT,"
                + OPTION1 + " TEXT,"
                + OPTION2 + " TEXT,"
                + OPTION3 + " TEXT,"
                + OPTION4 + " TEXT,"
                + ANSWER + " TEXT)"
                ;
        db.execSQL(query);
        String query2 = "CREATE TABLE " + RESULT_TABLE_NAME + " ("
                + RESULT_ID_COL + " INTEGER PRIMARY KEY AUTOINCREMENT, "
                + USERNAME + " TEXT,"
                + USERSCORE + " TEXT)";
        // at last we are calling a exec sql
        // method to execute above sql query
        db.execSQL(query2);



        // at last we are calling a exec sql
        // method to execute above sql query


    }

    //add file of questions answers and correct answer to db
    public void addFileOfChoosingToDb(Context context) throws IOException {
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorQuestions = db.rawQuery("SELECT count(*) FROM " + TABLE_NAME, null);
        long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        if(count < 2) {
            FileInputStream is;
            BufferedReader reader;
            Log.d("DO I Make It", "DO I Make It");
            //if(file.exists()) {

            final InputStream file = context.getAssets().open("QuizletDatabaseContent.txt");
            reader = new BufferedReader(new InputStreamReader(file));
            String line = reader.readLine();

            while(line != null){
                var splitLine = line.split("[,]");
                Log.d("File seems to exist", String.valueOf(splitLine.length));
                String questionPart = splitLine[0];
                String option1 = splitLine[1];
                String option2 = splitLine[2];
                String option3 = splitLine[3];
                String option4 = splitLine[4];
                String answer = splitLine[5];
                addNewCourse(questionPart,option1,option2,option3,option4,answer);
                line = reader.readLine();
            }
        }
    }


    //add file of questions answers and correct answer to db
    public void AddUserScoreToDB(Context context, String playerName, float score) throws IOException {
        SQLiteDatabase db = this.getReadableDatabase();
        ContentValues values = new ContentValues();
        // on below line we are passing all values
        // along with its key and value pair.
        values.put(USERNAME, playerName);
        values.put(USERSCORE, String.valueOf(score));
        // after adding all values we are passing
        // content values to our table.
        db.insert(RESULT_TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }

    public int tableExists(){
        boolean flag = false;
        String sql = "select count(*) from questionsFOrQuiz";
        Cursor cursor = mDB.rawQuery(sql, null);
        int rowcount = cursor.getCount();
        cursor.close();
        return rowcount;
    }

    // this method is use to add new course to our sqlite database.
    public void addNewCourse(String questionString, String option1String,String option2String,String option3String,String option4String,String answerString) {

        // on below line we are creating a variable for
        // our sqlite database and calling writable method
        // as we are writing data in our database.
        SQLiteDatabase db = this.getWritableDatabase();

        // on below line we are creating a
        // variable for content values.
        ContentValues values = new ContentValues();

        // on below line we are passing all values
        // along with its key and value pair.
        values.put(QUESTION, questionString);
        values.put(OPTION1, option1String);
        values.put(OPTION2, option2String);
        values.put(OPTION3, option3String);
        values.put(OPTION4, option4String);
        values.put(ANSWER, answerString);


        // after adding all values we are passing
        // content values to our table.
        db.insert(TABLE_NAME, null, values);

        // at last we are closing our
        // database after adding database.
        db.close();
    }


    public ArrayList<QuestionModel> getQuestions(){
        SQLiteDatabase db = this.getReadableDatabase();
        long count = DatabaseUtils.queryNumEntries(db, TABLE_NAME);
        Cursor cursorQuestions = db.rawQuery("SELECT * FROM " + TABLE_NAME, null);
        ArrayList<QuestionModel> courseModalArrayList = new ArrayList<QuestionModel>();

        if (cursorQuestions.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new QuestionModel(cursorQuestions.getString(1),
                        cursorQuestions.getString(2),
                        cursorQuestions.getString(3),
                        cursorQuestions.getString(4),
                        cursorQuestions.getString(5),
                        cursorQuestions.getString(6)));
            } while (cursorQuestions.moveToNext());
            // moving our cursor to next.
        }

        cursorQuestions.close();
        return courseModalArrayList;
    }


    public ArrayList<TopResults> Top10Results(){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursorQuestions = db.rawQuery("SELECT * FROM " + RESULT_TABLE_NAME, null);
        ArrayList<TopResults> courseModalArrayList = new ArrayList<TopResults>();

        if (cursorQuestions.moveToFirst()) {
            do {
                // on below line we are adding the data from cursor to our array list.
                courseModalArrayList.add(new TopResults(cursorQuestions.getString(1),
                        cursorQuestions.getFloat(2)));
            } while (cursorQuestions.moveToNext());
            // moving our cursor to next.
        }

        cursorQuestions.close();
        return courseModalArrayList;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // this method is called to check if the table exists already.
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + RESULT_TABLE_NAME);

        onCreate(db);
    }
}
