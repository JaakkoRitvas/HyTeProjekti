package com.example.hyte_projekti;

import android.content.Intent;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.Room;
import com.example.hyte_projekti.database.Workout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    ListView lista;
    /*private Handler mHandler = new Handler() ;
    private Thread thread ;*/

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        GlobalModel.getInstance().activateDatabase(getApplicationContext());
        FloatingActionButton lisaaTreeni = (FloatingActionButton) findViewById(R.id.floatingActionButton);
        List<Workout> workouts = GlobalModel.getInstance().getDatabase().workoutDAO().getPlannedWorkouts();

        lista = (ListView) findViewById(R.id.lista);

        lista.setAdapter(new ArrayAdapter<Workout>(getApplicationContext(), android.R.layout.simple_list_item_1
                , workouts));

    }
    /*@Override
    protected void onResume() {
        super.onResume();

            /*thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    List<Workout> workouts = GlobalModel.getInstance().getDatabase().workoutDAO().getPlannedWorkouts();

                    lista = (ListView) findViewById(R.id.lista);

                    lista.setAdapter(new ArrayAdapter<Workout>(getApplicationContext(), android.R.layout.simple_list_item_1
                            , workouts));
                }
            });




    }*/
    public void onClick(View v) {

        Intent intent = new Intent(MainActivity.this, TreeninLisays.class);

        startActivity(intent);
    }



}
