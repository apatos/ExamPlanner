package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.adaptor.ExamListAdaptor;
import com.atos.examplanner.planner.dialog.TimeStudiedDialog;
import com.atos.examplanner.planner.model.Exam;

import java.util.ArrayList;

/**
 * Main Activity of the application. This extends Activity and Impliments the TimeStudiedDialog Listener
 */
public class MainActivity extends Activity implements TimeStudiedDialog.TimeStudiedInteractionListener {

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

        /**
         * TODO Day 2 task 6
         * create a new exam ArrayList of Exam objects
         */

        /**
         * TODO Day 3 Task 17
         * Load Array List from fileUtils and set equal to the examList
         */

        // Create ListView
    }

    /**
     * When button is pressed this starts the new activity
     * @param view The view of the button that has been pressed
     */
    public void addNewItem(View view) {
        /**
         * TODO Day 1 Task 4
         * Add New Intent this current context and new activity you want to start
         * Start activity with the intent
         */

        /**
         * TODO Day 2 Task 7
         * Start the activity for a result.
         */
    }

    /**
     * This is called when the Add Subject activity is finished and returns a result
     * @param requestCode The request code that has been passed back
     * @param resultCode The result code from then addSubjectActivity
     * @param data The object that has been passed back
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        /**
         * TODO Day 2 Task 8 part 2
         * Check to see that the request code and result code are correct
         * Get the Exam object out of the Intent and add it to the exam list
         */

    }

    /**
     * This function creates the list view and sets up the click listeners for the items
     */
    public void createListView () {

        /**
         * TODO Day 2 Task 11 part 2
         * Find the ListView from the main view.
         * Pass the adaptor the array list and the context of the current activity.
         * Set the adaptor to the listView
         */

        /**
         * TODO Day 3 Task 12
         * Set on click listener to call upon create time dialog and pass it the position
         */

        /**
         * TODO Day 3 Task 15
         * Set an on item long click listener to call upon createDeleteDialog and pass it the position
         */

    }

    /**
     * When a time has been selected in the dialog this function is called to update the item selected
     * @param timeEntered time that has been entered in the dialog
     * @param requestCode the request code for the dialog
     * @param position the position of the item within the list
     */
    @Override
    public void onTimeSelected(String timeEntered, int requestCode, int position) {

        /**
         * TODO Day 3 Task 14
         * Get the Exam object that corresponds to item selected. Set the revision time currently
         */

    }

    /**
     * Creates the custom time dialog and shows it
     * @param position
     */
    private void createTimeDialog (int position) {
        /**
         * TODO Day 3 task 13 part 2
         * Get the timeStudiedDialog instance
         * Show the Dialog after giving it a fragment manager
         */
    }

    /**
     * Function to create dialog to allow the item pressed to be deleted
     * @param position
     */
    private void createDeleteDialog (final int position) {

        /**
         * TODO Day 3 Task 16
         * Create an alert dialog that allows you to delete the selected Item in the list
         * Remember to set titles and messages. Notify the adaptor that the arrayList has
         * changed once the Exam has been removed from the arrayList.
         */


    }
}
