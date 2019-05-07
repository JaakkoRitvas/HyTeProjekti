package com.example.hyte_projekti;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListAdapter;

import com.example.hyte_projekti.database.Workout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FloatingActionButton lisaaTreeni = (FloatingActionButton) findViewById(R.id.floatingActionButton);
    }

    public void onClick(View v) {
        Intent intent = new Intent(MainActivity.this, TreeninLisays.class);
        startActivity(intent);
    }



}
