package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestPushup extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_pushup);

        restbutton = findViewById(R.id.restbutton15);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestPushup.this, Triceps_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton16);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestPushup.this, Pushup_Timer.class);
            startActivity(intent);
        });
    }
}