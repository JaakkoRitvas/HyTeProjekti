package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.hyte_projekti.database.Exercise;
import com.example.hyte_projekti.database.Workout;
import com.example.hyte_projekti.database.WorkoutExercise;

public class DeleteExerciseActivity extends AppCompatActivity {
    private String id;
    private Exercise exercise;
    private WorkoutExercise workoutExercise;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_exercise);

        Intent intent = getIntent();
        id = intent.getStringExtra(GlobalModel.ID_TAG);
        exercise = GlobalModel.getInstance().getDatabase().exerciseDAO().getExerciseById(id);
        workoutExercise = GlobalModel.getInstance().getDatabase().workoutExerciseDAO().getWorkoutExerciseByExerciseId(id);

        Button buttonConfirmDeletion = findViewById(R.id.buttonConfirmDeletion);
        Button buttonCancelDeletion = findViewById(R.id.buttonCancelDeletion);
        buttonConfirmDeletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GlobalModel.getInstance().getDatabase().exerciseDAO().delete(exercise);
                        GlobalModel.getInstance().getDatabase().workoutExerciseDAO().delete(workoutExercise);
                    }
                }).start();
                startExerciseListActivity();
            }
        });
        buttonCancelDeletion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startExerciseListActivity();
            }
        });
    }

    private void startExerciseListActivity() {
        Intent intent = new Intent(this, ExerciseListActivity.class);
        startActivity(intent);
    }
}
