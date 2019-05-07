package com.example.hyte_projekti;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import com.example.hyte_projekti.database.Workout;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView listWorkouts;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listWorkouts = (ListView) findViewById(R.id.listWorkouts);
        FloatingActionButton buttonCreateWorkout = (FloatingActionButton) findViewById(R.id.buttonCreateWorkout);

        buttonCreateWorkout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CreateWorkoutActivity.class);
                startActivity(intent);
            }
        });

        new Thread(new Runnable() {
            @Override
            public void run() {
                GlobalModel.getInstance().activateDatabase(getApplicationContext());
                final List<Workout> workouts = GlobalModel.getInstance().getDatabase().workoutDAO().getWorkouts();

                listWorkouts.setAdapter(new ArrayAdapter<>(
                        getApplicationContext(),
                        android.R.layout.simple_list_item_1,
                        workouts
                ));

                listWorkouts.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        Workout workout = workouts.get(position);
                        String subjectId = workout.getId();

                        Intent intent = new Intent(MainActivity.this, ViewWorkoutActivity.class);
                        intent.putExtra(GlobalModel.ID_TAG, subjectId);
                        startActivity(intent);
                    }
                });
            }
        }).start();
    }
}
