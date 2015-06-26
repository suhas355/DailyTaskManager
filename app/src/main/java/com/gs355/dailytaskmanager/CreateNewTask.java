package com.gs355.dailytaskmanager;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;


public class CreateNewTask extends ActionBarActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_new_task);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_create_new_task, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {

        RadioGroup priority;
        RadioButton priorityLow,priorityMedium,priorityHigh;
        TextView details;
        DatePicker datePicker;


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_create_new_task, container, false);

            priority = (RadioGroup) rootView.findViewById(R.id.radioPriority);

            priorityLow = (RadioButton) rootView.findViewById(R.id.priorityLow);
            priorityMedium = (RadioButton) rootView.findViewById(R.id.priorityMedium);
            priorityHigh = (RadioButton) rootView.findViewById(R.id.priorityHigh);

            priority.setVisibility(View.VISIBLE);
            priorityLow.setVisibility(View.VISIBLE);
            priorityMedium.setVisibility(View.VISIBLE);
            priorityHigh.setVisibility(View.VISIBLE);

            int selectedId = priority.getCheckedRadioButtonId();


            details = (TextView)rootView.findViewById(R.id.task_details);
            details.setVisibility(View.VISIBLE);

            datePicker = (DatePicker)rootView.findViewById(R.id.task_date);
            datePicker.setVisibility(View.VISIBLE);





            return rootView;
        }
    }
}
