package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hyte_projekti.database.Exercise;

public class CreateExerciseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        final Button submit = findViewById(R.id.submitExerciseName);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        Exercise exercise = new Exercise();
                        exercise.setName(submit.getText().toString());
                        GlobalModel.getInstance().getDatabase().exerciseDAO().insert(exercise);
                        Intent intent = new Intent(CreateExerciseActivity.this, ExerciseListActivity.class);
                        startActivity(intent);
                    }
                }).start();
            }
        });
    }
}
