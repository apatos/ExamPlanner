package com.atos.examplanner.planner.activity;

import android.app.Activity;
import android.content.Context;

import com.atos.examplanner.planner.model.Exam;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

/**
 * Class to be treated as black box. To save and load files
 * Created by andrewpatterson on 18/06/2014.
 */
public class FileUtils extends Activity {

    private static final String FILE_NAME = "ExamList";
    /**
     * Save function for list
     * @param examList the list of exams to be saved
     */
    public void writeListToFile (ArrayList<Exam> examList) {

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

    /**
     * Loads the array list of the files
     * @param examLoadList the list that is passed into the function
     * @return either the loaded list or null if no list exists
     */
    public ArrayList<Exam> loadListFromFile (ArrayList<Exam> examLoadList) {


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

            } catch (Exception e) {
                e.printStackTrace();
            }

        return examLoadList;
    }

}
