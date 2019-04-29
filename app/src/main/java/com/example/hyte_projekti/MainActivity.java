package com.example.hyte_projekti;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button lisaaTreeni = (Button) findViewById(R.id.lisays);
    }

    public void onClick(View v) {
        Intent intent = new Intent(this, TreeninLisays.class);
        startActivity(intent);
    }
}
