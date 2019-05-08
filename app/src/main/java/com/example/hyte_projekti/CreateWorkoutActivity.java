package com.example.hyte_projekti;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;

import com.example.hyte_projekti.database.Workout;

import java.util.Calendar;

public class CreateWorkoutActivity extends AppCompatActivity {

    private EditText editDate;
    private EditText editTime;
    private EditText editName;
    private Calendar currentDate;
    private Calendar currentTime;
    private Button buttonConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_workout);

        editDate = (EditText) findViewById(R.id.txtDate);
        editTime = (EditText) findViewById(R.id.txtTime);
        editName = (EditText) findViewById(R.id.txtName);
        buttonConfirm = (Button) findViewById(R.id.buttonCreateWorkout);

        editDate.setOnClickListener(new View.OnClickListener() {
            /**
             * attach function to edit date plain text field
             * collect current date (year, month, day)
             * pass the above as params to Date Picker Dialog
             * show Date Picker Dialog
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                currentDate = Calendar.getInstance();
                int year = currentDate.get(Calendar.YEAR);
                int month = currentDate.get(Calendar.MONTH);
                int day = currentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(CreateWorkoutActivity.this, new DatePickerDialog.OnDateSetListener() {
                    /**
                     * update the content of edit name plain text field
                     * update the current date variable
                     *
                     * @param view
                     * @param pickedYear
                     * @param pickedMonth
                     * @param pickedDay
                     */
                    @Override
                    public void onDateSet(DatePicker view, int pickedYear, int pickedMonth, int pickedDay) {
                        editDate.setText(pickedYear + " - " + pickedMonth + " - " + pickedDay);
                        currentDate.set(pickedYear, pickedMonth, pickedDay);
                    }
                }, year, month, day);
                mDatePicker.show();
            }
        });

        editTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                currentTime = Calendar.getInstance();

                int hour = currentTime.get(Calendar.HOUR_OF_DAY);
                int minute = currentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker = new TimePickerDialog(CreateWorkoutActivity.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int pickedHour, int pickedMinute) {
                        editTime.setText(String.format("%02d:%02d", pickedHour, pickedMinute));
                        // currentTime.set(pickedHour, pickedMinute);
                    }
                }, hour, minute, true);
                mTimePicker.show();
            }
        });

        buttonConfirm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        String date = editDate.getText().toString();
                        String time = editTime.getText().toString();
                        String name = editName.getText().toString();

                        Workout workout = new Workout();
                        workout.setDate(date);
                        workout.setTime(time);
                        workout.setName(name);

                        GlobalModel.getInstance().getDatabase().workoutDAO().insert(workout);
                    }
                }).start();

                Intent intent = new Intent(CreateWorkoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}
