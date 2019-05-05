package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.hyte_projekti.database.Exercise;

public class ViewExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_exercise);

        Intent intent = getIntent();
        final String subjectId = intent.getStringExtra(GlobalModel.ID_TAG);

        new Thread(new Runnable() {
            @Override
            public void run() {
                Exercise exercise = GlobalModel.getInstance().getDatabase().exerciseDAO().getExerciseById(subjectId);
                TextView tv = findViewById(R.id.textExerciseName);
                tv.setText(exercise.getName());
            }
        }).start();
    }
}
