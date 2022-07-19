package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class PlanksDescription extends AppCompatActivity {

    ImageButton imagebackbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planks_description);

        imagebackbutton = findViewById(R.id.imagebackbutton5);
        imagebackbutton.setOnClickListener(v -> {
            Intent intent = new Intent(PlanksDescription.this, Planks_Timer.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });
    }
}