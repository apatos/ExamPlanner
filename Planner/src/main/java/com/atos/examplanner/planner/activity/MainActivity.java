package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.adaptor.ExamListAdaptor;
import com.atos.examplanner.planner.dialog.TimeStudiedDialog;
import com.atos.examplanner.planner.model.Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;


public class MainActivity extends Activity implements TimeStudiedDialog.TimeStudiedInteractionListener {

    private ExamListAdaptor examListAdaptor;
    private ArrayList<Exam> examList;
    private static final int ADD_SUBJECT_REQUEST_CODE = 1;
    private static final String FILE_NAME = "ExamList";
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

        if (loadListFromFile(examList) != null) {
          examList = loadListFromFile(examList);
        }

        createListView();
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
                //gets the information out of the Intent
                Exam exam = (Exam) data.getSerializableExtra("ExamTag");
                //Adds the exam to the examList
                examList.add(exam);
                //calls upon createListFunction
                createListView();
            }
        }

    }

    /**
     * This function creates the list view and sets up the click listeners for the items
     */
    public void createListView () {

        //finds the listView from the main view
        ListView listView = (ListView) findViewById(R.id.list_exam);

        //Passes the adaptor the array list and the context
        examListAdaptor = new ExamListAdaptor(examList, this);

        listView.setAdapter(examListAdaptor);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                TimeStudiedDialog timeStudiedDialog = TimeStudiedDialog.getInstance(1, position, MainActivity.this);
                timeStudiedDialog.show(getFragmentManager(), null);


            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, final int position, long id) {
                AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);

                alertDialogBuilder.setTitle("Delete");
                alertDialogBuilder.setMessage("Delete this message?");
                alertDialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        examList.remove(position);
                        examListAdaptor.notifyDataSetChanged();
                        writeListToFile(examList);
                        dialogInterface.cancel();
                    }
                });
                alertDialogBuilder.setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });

                AlertDialog alertDialog = alertDialogBuilder.create();
                alertDialog.show();

                return true;
            }
        });
    }

    @Override
    public void onTimeSelected(String timeEntered, int requestCode, int position) {

        Exam selectedExam = examList.get(position);
        selectedExam.setRevisionTimeCurrently(timeEntered);
        writeListToFile(examList);
        examListAdaptor.notifyDataSetChanged();

    }

    private void writeListToFile (ArrayList<Exam> examList) {

        File examFile = getFileStreamPath(FILE_NAME);

        try {
            if(examFile.exists() || examFile.createNewFile()) {

                FileOutputStream fileOutputStream = openFileOutput(FILE_NAME, Context.MODE_PRIVATE);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);
                objectOutputStream.writeObject(examList);
                fileOutputStream.close();

            }
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    private ArrayList<Exam> loadListFromFile (ArrayList<Exam> examLoadList) {

     File examFile = getFileStreamPath(FILE_NAME);
       try {
           if (examFile.exists()) {

               FileInputStream fileInputStream = openFileInput(FILE_NAME);
               ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);
               examLoadList = (ArrayList<Exam>) objectInputStream.readObject();
               fileInputStream.close();

           } else {
               return null;
           }

       }catch (Exception e) {
               e.printStackTrace();
           }

        return examLoadList;
    }

}
