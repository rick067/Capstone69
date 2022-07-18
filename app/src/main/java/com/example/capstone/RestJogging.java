package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestJogging extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_jogging);

        restbutton = findViewById(R.id.restbutton7);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestJogging.this, JumpingJacks_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton8);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestJogging.this, Jogging_Timer.class);
            startActivity(intent);
        });
    }
}