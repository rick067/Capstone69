package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ArmCircleDescription extends AppCompatActivity {

    ImageButton imagebackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_circle_description);

        imagebackbutton = findViewById(R.id.imagebackbutton1);
        imagebackbutton.setOnClickListener(v -> {
            Intent intent= new Intent(ArmCircleDescription.this, ArmCircle_Timer.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}