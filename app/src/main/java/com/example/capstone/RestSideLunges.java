package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

public class RestSideLunges extends AppCompatActivity {

    Button restbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rest_side_lunges);

        restbutton = findViewById(R.id.restbutton17);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSideLunges.this, MainMenu.class);
            startActivity(intent);
        });

        restbutton = findViewById(R.id.restbutton18);
        restbutton.setOnClickListener(v -> {
            Intent intent = new Intent(RestSideLunges.this, SideLunges_Timer.class);
            startActivity(intent);
        });
    }
}