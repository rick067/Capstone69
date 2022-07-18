package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestPlanks extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_planks);

        restbutton = findViewById(R.id.restbutton13);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestPlanks.this, Jogging_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton14);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestPlanks.this, Planks_Timer.class);
            startActivity(intent);
        });
    }
}