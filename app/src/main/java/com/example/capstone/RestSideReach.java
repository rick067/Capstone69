package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestSideReach extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_side_reach);

        restbutton = findViewById(R.id.restbutton19);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSideReach.this, HipRotation_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton20);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSideReach.this, SideReach_Timer.class);
            startActivity(intent);
        });
    }
}