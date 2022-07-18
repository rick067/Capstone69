package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestKneesLift extends AppCompatActivity {

    Button restbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_knees_lift);

        restbutton = findViewById(R.id.restbutton11);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestKneesLift.this, SideLunges_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton12);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestKneesLift.this, KneesLift_Timer.class);
            startActivity(intent);
        });
    }
}