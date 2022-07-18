package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestArmReach extends AppCompatActivity {

    Button restbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_arm_reach);

        restbutton = findViewById(R.id.restbutton3);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestArmReach.this, ArmCircle_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton4);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestArmReach.this, ArmReach_Timer.class);
            startActivity(intent);
        });
    }
}