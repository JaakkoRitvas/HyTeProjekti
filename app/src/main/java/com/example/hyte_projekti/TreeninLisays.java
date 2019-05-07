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

public class TreeninLisays extends AppCompatActivity {

    EditText editDate;
    EditText editTime;
    EditText editTreeni;
    Calendar currentDate;
    Calendar currentTime;
    Button valmis;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_treenin_lisays);

        editDate = (EditText) findViewById(R.id.txtDate);
        editTime = (EditText) findViewById(R.id.txtTime);
        editTreeni = (EditText) findViewById(R.id.txtTreeni);
        valmis = (Button) findViewById(R.id.button3);

        valmis.setOnClickListener(click);
        editDate.setOnClickListener(click);
        editTime.setOnClickListener(click);

    }

    public View.OnClickListener click = new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            if (v == editDate) {
                currentDate = Calendar.getInstance();
                int vuosi = currentDate.get(Calendar.YEAR);
                int kuukaus = currentDate.get(Calendar.MONTH);
                int paiva = currentDate.get(Calendar.DAY_OF_MONTH);

                DatePickerDialog mDatePicker = new DatePickerDialog(TreeninLisays.this, new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int valittuVuosi, int valittuKuukaus, int valittuPaiva) {
                        editDate.setText(valittuPaiva + " - " + valittuKuukaus + " - " + valittuVuosi);
                        currentDate.set(valittuVuosi, valittuKuukaus, valittuPaiva);

                    }
                }, vuosi, kuukaus, paiva);
                mDatePicker.show();
            }
            else if(v == editTime) {
                currentTime = Calendar.getInstance();
                int tunti = currentTime.get(Calendar.HOUR_OF_DAY);
                int minuutti = currentTime.get(Calendar.MINUTE);

                TimePickerDialog mTimePicker = new TimePickerDialog(TreeninLisays.this, new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int valittuTunti, int valittuMinuutti) {
                        editTime.setText(String.format("%02d:%02d", valittuTunti, valittuMinuutti));
                        currentTime.set(valittuTunti, valittuMinuutti);

                    }
                }, tunti, minuutti,true);
                mTimePicker.show();
                }
            else if(v == valmis){
                String date = editDate.getText().toString();
                String time = editTime.getText().toString();
                String name = editTreeni.getText().toString();

                Workout workout = new Workout();
                workout.setDate(date);
                workout.setTime(time);
                workout.setName(name);
                GlobalModel.getInstance().getDatabase().workoutDAO().insert(workout);

                Intent intent = new Intent(TreeninLisays.this, MainActivity.class);
                startActivity(intent);
            }
        }
    };
}


