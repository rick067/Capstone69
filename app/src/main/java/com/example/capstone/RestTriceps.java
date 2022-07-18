package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestTriceps extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_triceps);

        restbutton = findViewById(R.id.restbutton23);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestTriceps.this, Squats_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton24);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestTriceps.this, Triceps_Timer.class);
            startActivity(intent);
        });
    }
}