package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestHipRotation extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_hip_rotation);

        restbutton = findViewById(R.id.restbutton5);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestHipRotation.this, KneesLift_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton6);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestHipRotation.this, HipRotation_Timer.class);
            startActivity(intent);
        });
    }
}