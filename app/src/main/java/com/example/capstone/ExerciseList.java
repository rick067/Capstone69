package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageButton;

public class ExerciseList extends AppCompatActivity {

    ImageButton myImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        myImageButton = findViewById(R.id.planksIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer10.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.pushupIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer7.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.tricepsIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer8.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.squatIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer9.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.sidereachIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer3.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.sidelungesIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer2.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.KneesLiftIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer5.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.JumpingJacksIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer12.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.JoggingLegLiftsIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer11.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.HipRotationIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Timer4.class);
            startActivity(intent);
        });
    }
}