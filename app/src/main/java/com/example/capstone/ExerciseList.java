package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;

public class ExerciseList extends AppCompatActivity {

    ImageButton myImageButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        myImageButton = findViewById(R.id.planksIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Planks_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.pushupIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Pushup_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.tricepsIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Triceps_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.squatIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Squats_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.sidereachIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, SideReach_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.sidelungesIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, SideLunges_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.KneesLiftIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, KneesLift_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.JumpingJacksIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, JumpingJacks_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.JoggingLegLiftsIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Jogging_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.HipRotationIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, HipRotation_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.ArmCircleIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, ArmCircle_Timer.class);
            startActivity(intent);
        });
        myImageButton = findViewById(R.id.KneesLiftIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, KneesLift_Timer.class);
            startActivity(intent);
        });
    }
}