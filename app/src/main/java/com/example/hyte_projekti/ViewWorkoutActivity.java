package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hyte_projekti.database.Exercise;
import com.example.hyte_projekti.database.Workout;

import java.util.List;

public class ViewWorkoutActivity extends AppCompatActivity {
    private String workoutId;
    private List<Exercise> exercises;
    private Workout workout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        Intent intent = getIntent();
        workoutId = intent.getStringExtra(GlobalModel.ID_TAG);
        workout = GlobalModel.getInstance().getDatabase().workoutDAO().getWorkoutById(workoutId);
        exercises = GlobalModel.getInstance().getDatabase().exerciseDAO().getExercisesByWorkoutId(workoutId);

        TextView textDate = findViewById(R.id.textDate);
        TextView textTime = findViewById(R.id.textTime);
        textDate.setText(workout.getDate());
        textTime.setText(workout.getTime());

        ListView listExercises = findViewById(R.id.listExercises);

        listExercises.setAdapter(new ArrayAdapter<Exercise>(
                getApplicationContext(),
                android.R.layout.simple_list_item_1,
                exercises
        ));

        listExercises.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            /**
             * take clicked exercise to another activity to be deleted
             * attach exerciseId to intent as extra
             * start Delete Exercise Activity
             *
             * @param parent
             * @param view
             * @param position
             * @param id
             */
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Exercise exercise = exercises.get(position);
                String exerciseId = exercise.getId();

                Intent intentDelete = new Intent(ViewWorkoutActivity.this, DeleteExerciseActivity.class);
                intentDelete.putExtra(GlobalModel.ID_TAG, exerciseId);
                startActivity(intentDelete);
            }
        });

        Button buttonAddExercise = findViewById(R.id.buttonAddExercise);
        Button buttonFinishWorkout = findViewById(R.id.buttonFinishWorkout);

        buttonAddExercise.setOnClickListener(new View.OnClickListener() {
            /**
             * create new exercise
             * attach workoutId to intent as extra
             * start Create Exercise Activity
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(ViewWorkoutActivity.this, CreateExerciseActivity.class);
                intentCreate.putExtra(GlobalModel.ID_TAG, workoutId);
                startActivity(intentCreate);
            }
        });

        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
            /**
             * completion of workout
             * remove viewed workout from database
             * start Main Activity
             *
             * @param v
             */
            @Override
            public void onClick(View v) {
                new Thread(new Runnable() {
                    @Override
                    public void run() {
                        GlobalModel.getInstance().getDatabase().workoutDAO().delete(workout);
                    }
                }).start();
                Intent intentMain = new Intent(ViewWorkoutActivity.this, MainActivity.class);
                startActivity(intentMain);
            }
        });
    }
}
