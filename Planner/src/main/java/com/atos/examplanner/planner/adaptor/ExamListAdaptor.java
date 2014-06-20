package com.atos.examplanner.planner.adaptor;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.atos.examplanner.planner.R;
import com.atos.examplanner.planner.model.Exam;

import java.util.ArrayList;

/**
 * Created by andrewpatterson on 17/06/2014.
 */
public class ExamListAdaptor extends BaseAdapter{

    private final ArrayList<Exam> ExamList;
    private final Context context;

    /**
     * Constructor to take in the string list passed to the dialog and the context.
     * @param ExamList The string list is going to be displayed in the list
     * @param context The dialog fragment currently displayed
     */
    public ExamListAdaptor(ArrayList<Exam> ExamList, Context context) {
        this.ExamList = ExamList;
        this.context = context;
    }

    @Override
    public int getCount() {
        return ExamList.size();
    }

    @Override
    public Object getItem(int position) {
        return ExamList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        if (convertView == null) {
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = inflater.inflate(R.layout.exam_row_list, parent, false);
        }

        setupView(position, convertView);

        return convertView;
    }

    /**
     * Set up the view for each row. Get the position of the item and sets the text for it.
     * @param position the position of the item in the list view
     * @param convertView the individual row view of each item in the list view
     */
    private void setupView(int position, View convertView ) {

        /**
         * TODO DAY 2 TASK 11
         * Get the Exam object from the correct position. Find the TextViews from the convertView
         * Set the Text from the object to the TextViews
         * If the current revision time has not yet been set to anything set the text to a 00.00
         */

    }
}
