package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.model.Exam;

/**
 * Created by andrewpatterson on 16/06/2014.
 * This activity is responsible for adding information about an activity to a exam object
 */
public class AddSubjectActivity extends Activity {

    //EditText Variables
    EditText examName;
    EditText teacherName;
    EditText examDate;
    EditText timeWanted;
    EditText desiredMark;
    EditText examWorth;

    /**
     * When activity is first created this function is called.
     * It expands the layout and finds the EditText Views
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down then this Bundle contains the data it most recently
     *                           supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     *                           is null.</b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_subject);

        examName = (EditText)findViewById(R.id.text_box_name);
        teacherName = (EditText)findViewById(R.id.text_box_teacher);
        examDate  = (EditText)findViewById(R.id.text_box_exam_date);
        timeWanted  = (EditText)findViewById(R.id.text_box_time_aim);
        desiredMark = (EditText)findViewById(R.id.text_box_mark_wanted);
        examWorth = (EditText)findViewById(R.id.text_box_exam_worth);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Called when the Add button is pressed.
     * Creates a new exam object and puts info from editText fields into corresponding variables.
     * @param view
     */
    public void addButtonPressed(View view) {
        //Creates new exam object
        Exam exam = new Exam();

        //Calls the function from the model. Gets the text from the EditText view and converts it to a string
        exam.setExamName(examName.getText().toString());
        exam.setTeacherName(teacherName.getText().toString());
        exam.setExamDate(examDate.getText().toString());
        exam.setRevisionTimeWanted(timeWanted.getText().toString());
        exam.setDesiredMark(desiredMark.getText().toString());
        exam.setExamWorth(examWorth.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("ExamTag", exam);
        setResult(Activity.RESULT_OK, intent);
        finish();
    }
}
