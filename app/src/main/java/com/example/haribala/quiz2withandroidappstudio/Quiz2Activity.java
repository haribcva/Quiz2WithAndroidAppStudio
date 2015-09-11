package com.example.haribala.quiz2withandroidappstudio;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;


public class Quiz2Activity extends ActionBarActivity {

    private static final int FALSE = 0;
    private static final int TRUE = 1;
    int whichQuestion = 0;
    int nextQuestion = FALSE;
    int score = 0, tries = 0;
    static int class_var = 10;


    //Log.d("XXXX", "Top Level Code!!!");

     public Quiz2Activity () {
         //constructor; usually nothing gets done at the constructor, just
        Log.d("XXXXX", "Activity Constructor called!!!");
        StringBuilder str = new StringBuilder();
        str.append("object var whichQuestion is: ").append(whichQuestion);
        str.append("class var is: ").append(class_var);
        Log.d("XXXX", str.toString());

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.d("XXXXX", " onCreate called!!!");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz2);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_quiz2, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void onButtonClicked(View view) {
        Log.d("XXXXX", "Enter Button Clicked!!!");
               
        Toast.makeText(getApplicationContext(), "Not yet implemented....",
                Toast.LENGTH_LONG).show();
    }

    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        RadioGroup radio_group = (RadioGroup) findViewById(R.id.radioGroup);

        tries++;
        // Check which radio button was clicked
        switch(view.getId()) {

            case R.id.radioButton1:
                if (checked) {
                    // Pirates are the best
                    Toast.makeText(getApplicationContext(), "Correct Answer!!",
                            Toast.LENGTH_LONG).show();
                    Log.d("XXXXX", "correct answer!!!");

                    ++score;
                    nextQuestion = TRUE;
                } else {
                    Log.d("YYYYYY", "wrong answer!!!");
                }
                break;
            case R.id.radioButton2:
                if (checked)
                    Toast.makeText(getApplicationContext(), "Try Again!!",
                            Toast.LENGTH_LONG).show();
                nextQuestion = FALSE;

                radio_group.clearCheck();

                break;
        }
        if (nextQuestion == TRUE) {
            TextView  quiz_question = (TextView) findViewById(R.id.welcome);
            quiz_question.setText("Who is the hero in Harry Potter novels?");

            RadioButton pirate_button = (RadioButton)findViewById(R.id.radioButton1);
            pirate_button.setText("Harry Potter");
            RadioButton other_button = (RadioButton)findViewById(R.id.radioButton2);
            other_button.setText("Ron Weasley");
            radio_group.clearCheck();
            whichQuestion++;
        }

        if (whichQuestion == 2) {
            String result = "you took " + tries + " tries to finish, goodbye!!";
            Toast.makeText(getApplicationContext(), result,
                    Toast.LENGTH_LONG).show();
            whichQuestion = 0;
            finish();
        }
    }
}
