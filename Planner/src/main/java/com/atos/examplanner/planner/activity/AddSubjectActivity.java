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

    /**
     * TODO Day 1 Task 5 Part B
     * Adding function to Activity
     * In on create find the views of the EditTexts
     * In button press function create a new exam object set the information from the Edit Texts to it
     * Link Button created in Part A to the function
     * Then finish the activity
     */

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

    }

    /**
     * Called when the Add button is pressed.
     * Creates a new exam object and puts info from editText fields into corresponding variables.
     * @param view
     */
    public void addButtonPressed(View view) {


        /**
         * TODO Day 2 Task 8 Part A
         * To return information back to the main activity.
         * Start a new intent and put the Exam object into it
         * Set the result of the activity as the intent.
         * Finish the activity
         */

    }

}
