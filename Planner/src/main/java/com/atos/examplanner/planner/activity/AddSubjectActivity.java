package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.model.Exam;

/**
 * Created by andrewpatterson on 16/06/2014.
 */
public class AddSubjectActivity extends Activity {

    EditText examName;
    EditText teacherName;
    EditText examDate;
    EditText timeWanted;
    EditText desiredMark;
    EditText examWorth;

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

    public void addButtonPressed(View view) {
        Exam exam = new Exam();

        exam.setExamName(examName.getText().toString());
        exam.setTeacherName(teacherName.getText().toString());
        exam.setExamDate(examDate.getText().toString());
        exam.setRevisionTimeWanted(timeWanted.getText().toString());
        exam.setDesiredMark(Integer.parseInt(desiredMark.getText().toString()));
        exam.setExamWorth(Integer.parseInt(examWorth.getText().toString()));
    }
}
