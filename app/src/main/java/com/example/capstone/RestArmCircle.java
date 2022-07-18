package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestArmCircle extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_arm_circle);

        restbutton = findViewById(R.id.restbutton2);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestArmCircle.this, ArmCircle_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton1);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestArmCircle.this, SideReach_Timer.class);
            startActivity(intent);
        });
    }
}