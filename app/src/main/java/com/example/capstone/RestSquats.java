package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestSquats extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_squats);

        restbutton = findViewById(R.id.restbutton21);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSquats.this, Planks_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton22);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSquats.this, Squats_Timer.class);
            startActivity(intent);
        });
    }
}