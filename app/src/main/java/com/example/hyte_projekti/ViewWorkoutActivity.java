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
    private String subjectId;
    private List<Exercise> exercises;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        final Intent intent = getIntent();
        subjectId = intent.getStringExtra(GlobalModel.ID_TAG);
        final Workout workout = GlobalModel.getInstance().getDatabase().workoutDAO().getWorkoutById(subjectId);
        exercises = GlobalModel.getInstance().getDatabase().exerciseDAO().getExercisesByWorkoutId(subjectId);

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
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intentDelete = new Intent(ViewWorkoutActivity.this, DeleteExerciseActivity.class);
                Exercise exercise = exercises.get(position);
                String exerciseId = exercise.getId();
                intent.putExtra(GlobalModel.ID_TAG, exerciseId);
            }
        });

        Button buttonAddExercise = findViewById(R.id.buttonAddExercise);
        Button buttonFinishWorkout = findViewById(R.id.buttonFinishWorkout);
        buttonAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentCreate = new Intent(ViewWorkoutActivity.this, CreateExerciseActivity.class);
                intentCreate.putExtra(GlobalModel.ID_TAG, subjectId);
                startActivity(intentCreate);
            }
        });
        buttonFinishWorkout.setOnClickListener(new View.OnClickListener() {
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
