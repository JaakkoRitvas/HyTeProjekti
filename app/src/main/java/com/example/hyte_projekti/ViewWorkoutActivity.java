package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.hyte_projekti.database.Exercise;
import com.example.hyte_projekti.database.Workout;

import java.util.List;

public class ViewWorkoutActivity extends AppCompatActivity {
    private String id;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_workout);

        final Intent intent = getIntent();
        final String id = intent.getStringExtra(GlobalModel.ID_TAG);
        final Workout workout = GlobalModel.getInstance().getDatabase().workoutDAO().getWorkoutById(id);
        List<Exercise> exercises = GlobalModel.getInstance().getDatabase().workoutExerciseDAO().getExercisesByWorkoutId(id);

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

        Button buttonAddExercise = findViewById(R.id.buttonAddExercise);
        Button buttonFinishWorkout = findViewById(R.id.buttonFinishWorkout);
        buttonAddExercise.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent1 = new Intent(ViewWorkoutActivity.this, CreateExerciseActivity.class);
                intent1.putExtra(GlobalModel.ID_TAG, id);
                startActivity(intent1);
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
                Intent newIntent = new Intent(ViewWorkoutActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }
}
