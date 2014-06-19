package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.model.Exam;

/**
 * This activity is responsible for adding information about an activity to a exam object
 */
public class AddSubjectActivity extends Activity {

    //EditText Variables for each editText to be on screen
    private EditText examName;
    private EditText teacherName;
    private EditText examDate;
    private EditText timeWanted;
    private EditText desiredMark;
    private EditText examWorth;

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
        //Set the layout you want to appear
        setContentView(R.layout.activity_add_subject);

        //Finds the EditText views by their ids
        examName = (EditText)findViewById(R.id.text_box_name);
        teacherName = (EditText)findViewById(R.id.text_box_teacher);
        examDate  = (EditText)findViewById(R.id.text_box_exam_date);
        timeWanted  = (EditText)findViewById(R.id.text_box_time_aim);
        desiredMark = (EditText)findViewById(R.id.text_box_mark_wanted);
        examWorth = (EditText)findViewById(R.id.text_box_exam_worth);


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
        exam.setDesiredMark(Integer.parseInt(desiredMark.getText().toString()));
        exam.setExamWorth(Integer.parseInt(examWorth.getText().toString()));

        //Creates a new intent
        Intent intent = new Intent(this, MainActivity.class);
        //Puts the object into the intent with the Tag "Exam Tag"
        intent.putExtra("ExamTag", exam);
        //Sets the result of the activity
        setResult(Activity.RESULT_OK, intent);
        //Finishes the activity so cannot go back to it
        finish();
    }

}
