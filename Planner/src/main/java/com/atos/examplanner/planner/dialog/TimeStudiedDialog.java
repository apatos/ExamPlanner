package com.atos.examplanner.planner.dialog;

import android.app.DialogFragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.atos.examplanner.planner.R;

import java.io.Serializable;

/**
 * Created by andrewpatterson on 17/06/2014.
 */
public class TimeStudiedDialog extends DialogFragment {

    private static final String REQUEST_CODE_KEY = "request code";
    private static final String LISTENER_KEY = "listener";
    private static final String POSITION_KEY = "position";
    private TimeStudiedInteractionListener listener;

    private int requestCode;
    private int position;
    private EditText editText;

    /**
     * Called when Dialog is created. Passes information to rest of fragment
     * @param requestCode
     * @param position
     * @param listener
     * @return fragment
     */
    public static TimeStudiedDialog getInstance(int requestCode, int position, TimeStudiedInteractionListener listener) {

        //Create a bundle and put the information in it
        Bundle bundle = new Bundle();
        bundle.putInt(REQUEST_CODE_KEY, requestCode);
        bundle.putSerializable(LISTENER_KEY, listener);
        bundle.putInt(POSITION_KEY, position);

        //Create fragment and attach arguments to it
        TimeStudiedDialog fragment = new TimeStudiedDialog();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Get the arguments if they are not null and get the information out of it
        if (getArguments() != null) {
            requestCode = getArguments().getInt(REQUEST_CODE_KEY);
            position = getArguments().getInt(POSITION_KEY);
            listener = (TimeStudiedInteractionListener) getArguments().getSerializable(LISTENER_KEY);
        }

    }

    /**
     * called to create view.
     * Find buttons in the dialog and set the required on click listeners
     * @param inflater
     * @param container
     * @param savedInstanceState
     * @return the rootView
     */
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_time_studied, container, false);
        /**
         * TODO Day 3 Task 13
         * Get the buttons from view. For each button call upon appropriate function to select
         * or cancel the dialog. Remember to set the title for the dialog
         */

        return rootView;
    }

    /**
     * When time ok button is pressed this function is called.
     */
    private void timeSelected() {
        //Check to see if listener has been created. Get the text from information from the editText and pass it on

    }
    /**
     * Dismisses the dialog fragment
     */
    private void cancelDialog() {

    }

    /**
     * An interface that must be implemented for any activity that displays this Dialog fragment
     * Pass back information to the activity by calling this function
     */
    public interface TimeStudiedInteractionListener extends Serializable {

        public void onTimeSelected(String timeEntered, int requestCode, int position);

    }
}
