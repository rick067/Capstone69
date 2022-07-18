package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestJumpingJacks extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_jumping_jacks);

        restbutton = findViewById(R.id.restbutton9);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestJumpingJacks.this, ArmReach_Timer.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton10);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestJumpingJacks.this, JumpingJacks_Timer.class);
            startActivity(intent);
        });
    }
}