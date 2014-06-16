package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.model.Exam;

import java.util.ArrayList;


public class MainActivity extends Activity {

    private ArrayList<Exam> examList;

    /**
     * When activity is first created this function is called
     *
     * @param savedInstanceState If the activity is being re-initialized after previously being
     *                           shut down then this Bundle contains the data it most recently
     *                           supplied in onSaveInstanceState(Bundle). <b>Note: Otherwise it
     *                           is null.</b>
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        examList = new ArrayList<Exam>();
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
     * When button is pressed this starts the new activity
     * @param view
     */
    public void addNewItem(View view) {

        //Intent for activity
        Intent addIntent = new Intent(this, AddSubjectActivity.class);
        startActivityForResult(addIntent, 1);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == 1) {
            if (resultCode == Activity.RESULT_OK){
                Exam exam = (Exam) data.getSerializableExtra("ExamTag");
                examList.add(exam);
            }
        }

    }

}
