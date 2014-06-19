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

    private ExamListAdaptor examListAdaptor;
    private ArrayList<Exam> examList;
    private static final int ADD_SUBJECT_REQUEST_CODE = 1;
    private FileUtils fileUtils;

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
        fileUtils = new FileUtils();
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //create a new exam ArrayList of Exam object and get load list if it has been created.
        examList = new ArrayList<Exam>();
        ArrayList<Exam> loadedList = fileUtils.loadListFromFile(examList);

        if ( loadedList != null) {
          examList = loadedList;
        }

        // Create the view
        createListView();
    }

    /**
     * When button is pressed this starts the new activity
     * @param view The view of the button that has been pressed
     */
    public void addNewItem(View view) {

        //Intent for activity
        Intent addIntent = new Intent(this, AddSubjectActivity.class);
        //Starts the activity with the Intent and request code
        startActivityForResult(addIntent, ADD_SUBJECT_REQUEST_CODE);
    }

    /**
     * This is called when the Add Subject activity is finished and returns a result
     * @param requestCode The request code that has been passed back
     * @param resultCode The result code from then addSubjectActivity
     * @param data The object that has been passed back
     */
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        if (requestCode == ADD_SUBJECT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK){
                //Get the information out of the Intent
                Exam exam = (Exam) data.getSerializableExtra("ExamTag");
                //Add the exam to the examList
                examList.add(exam);
                //call upon createListFunction
                createListView();
            }
        }
    }

    /**
     * This function creates the list view and sets up the click listeners for the items
     */
    public void createListView () {

        //Find the listView from the main view
        ListView listView = (ListView) findViewById(R.id.list_exam);

        //Pass the adaptor the array list and the context of the current activity
        examListAdaptor = new ExamListAdaptor(examList, this);

        //Set the adaptor to the listView
        listView.setAdapter(examListAdaptor);

        //Set setOnItemClickListener for the list view. Creates a custom dialog to add time to the item
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                createTimeDialog(position);
            }
        });

        //Set setOnItemLongClickListener. This calls upon a function to create an alert dialog that allows the item to be deleted
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {

                //Calls the createDeleteDialog function and passes it the position of the item that has been clicked
                createDeleteDialog(position);

                return true;
            }
        });
    }

    /**
     * When a time has been selected in the dialog this function is called to update the item selected
     * @param timeEntered time that has been entered in the dialog
     * @param requestCode the request code for the dialog
     * @param position the position of the item within the list
     */
    @Override
    public void onTimeSelected(String timeEntered, int requestCode, int position) {

        //Get the Exam object that has been pressed
        Exam selectedExam = examList.get(position);
        //Set the Revision time currently with the timeEntered string
        selectedExam.setRevisionTimeCurrently(timeEntered);
        //Save the change
        fileUtils.writeListToFile(examList);
        //Inform the adaptor that the examList has changed
        examListAdaptor.notifyDataSetChanged();

    }


    /**
     * Creates the custom time dialog and shows it
     * @param position
     */
    private void createTimeDialog (int position) {
        //Create the dialog and pass the information to the getInstance function of the Dialog
        TimeStudiedDialog timeStudiedDialog = TimeStudiedDialog.getInstance(1, position, MainActivity.this);
        //Show the timeStudiedDialog by giving it a fragment manager.
        timeStudiedDialog.show(getFragmentManager(), null);
    }
    /**
     * Function to create dialog to allow the item pressed to be deleted
     * @param position
     */
    private void createDeleteDialog (final int position) {

        //Get the alertDialog builder
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
        //Set the title, message, PositiveButton and NegativeButtons.
        alertDialogBuilder.setTitle("Delete");
        alertDialogBuilder.setMessage("Delete this message?");
        alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //Remove the selected item from the examList
                examList.remove(position);
                examListAdaptor.notifyDataSetChanged();
                fileUtils.writeListToFile(examList);
                dialogInterface.cancel();
            }
        });
        alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.cancel();
            }
        });

        //Create the alertDialog and then show it
        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }
}
