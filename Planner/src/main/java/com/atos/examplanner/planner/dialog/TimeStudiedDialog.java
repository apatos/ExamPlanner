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

    public static TimeStudiedDialog getInstance(int requestCode, int position, TimeStudiedInteractionListener listener) {

        Bundle bundle = new Bundle();
        bundle.putInt(REQUEST_CODE_KEY, requestCode);
        bundle.putSerializable(LISTENER_KEY, listener);
        bundle.putInt(POSITION_KEY, position);

        TimeStudiedDialog fragment = new TimeStudiedDialog();
        fragment.setArguments(bundle);

        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            requestCode = getArguments().getInt(REQUEST_CODE_KEY);
            position = getArguments().getInt(POSITION_KEY);
            listener = (TimeStudiedInteractionListener) getArguments().getSerializable(LISTENER_KEY);
        }

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.dialog_time_studied, container, false);

        Button cancelButton = (Button) rootView.findViewById(R.id.dialog_time_button_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                cancelDialog();
            }
        });

        Button selectButton = (Button) rootView.findViewById(R.id.dialog_time_button_select);
        selectButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                timeSelected();
            }
        });

        editText = (EditText) rootView.findViewById(R.id.dialog_time_edittext);

        getDialog().setTitle("Please Enter a time");

        return rootView;
    }

    private void timeSelected() {
        if (listener != null) {
            String timeEntered = editText.getText().toString();
            listener.onTimeSelected(timeEntered, requestCode, position);
        }

        dismiss();
    }
    /**
     * Cancels the dialog fragment
     */
    private void cancelDialog() {
        if (listener != null) {
            listener.onTimeSelectionCancelled(requestCode);
        }

        dismiss();
    }

    /**
     * An interface that must be implemented for any activity that displays this Dialog fragment
     */
    public interface TimeStudiedInteractionListener extends Serializable {

        public void onTimeSelected(String timeEntered, int requestCode, int position);
        /**
         * Called when the date selection dialog is cancelled
         *
         * @param requestCode Request code used to launch the fragment
         */
        public void onTimeSelectionCancelled(int requestCode);

    }
}
