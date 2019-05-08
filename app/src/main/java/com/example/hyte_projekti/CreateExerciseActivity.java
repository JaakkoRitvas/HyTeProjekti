package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.hyte_projekti.database.Exercise;

public class CreateExerciseActivity extends AppCompatActivity {
    private String workoutId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_exercise);

        final Intent intent = getIntent();
        workoutId = intent.getStringExtra(GlobalModel.ID_TAG);

        Button submit = findViewById(R.id.submitExerciseName);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        EditText input = findViewById(R.id.inputExerciseName);
                        String exerciseName = input.getText().toString();

                        Exercise exercise = new Exercise();
                        exercise.setWorkoutId(workoutId);
                        exercise.setName(exerciseName);
                        GlobalModel.getInstance().getDatabase().exerciseDAO().insert(exercise);

                        input.setText("");
                    }
                }).start();
            }
        });

        /*Button buttonQuitCreating = findViewById(R.id.buttonQuitCreating);

        buttonQuitCreating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentMain = new Intent(CreateExerciseActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });*/
    }

    public void onClick(View v) {
        Intent intentMain = new Intent(CreateExerciseActivity.this, ViewWorkoutActivity.class);
        intentMain.putExtra(GlobalModel.ID_TAG, workoutId);
        startActivity(intentMain);
    }
}
