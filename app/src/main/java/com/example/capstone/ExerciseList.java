package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;



import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.widget.ImageButton;

public class ExerciseList extends AppCompatActivity {

    ImageButton myImageButton, myImageButton1, myImageButton2, myImageButton3, myImageButton4, myImageButton5, myImageButton6, myImageButton7, myImageButton8, myImageButton9, myImageButton10, myImageButton11, myImageBackgroundButtonList;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_list);

        myImageBackgroundButtonList = findViewById(R.id.imagebackbuttonlist);
        myImageBackgroundButtonList.setOnClickListener(v -> {
            Intent intent= new Intent(ExerciseList.this, MainMenu.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        });

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        myImageButton = findViewById(R.id.planksIcon);
        myImageButton.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Planks_Timer.class);
            startActivity(intent);
        });
        myImageButton1 = findViewById(R.id.pushupIcon);
        myImageButton1.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Pushup_Timer.class);
            startActivity(intent);
        });
        myImageButton2 = findViewById(R.id.tricepsIcon);
        myImageButton2.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Triceps_Timer.class);
            startActivity(intent);
        });
        myImageButton3 = findViewById(R.id.squatIcon);
        myImageButton3.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Squats_Timer.class);
            startActivity(intent);
        });
        myImageButton4 = findViewById(R.id.sidereachIcon);
        myImageButton4.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, SideReach_Timer.class);
            startActivity(intent);
        });
        myImageButton5 = findViewById(R.id.sidelungesIcon);
        myImageButton5.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, SideLunges_Timer.class);
            startActivity(intent);
        });
        myImageButton6 = findViewById(R.id.ArmReachIcon);
        myImageButton6.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, ArmReach_Timer.class);
            startActivity(intent);
        });
        myImageButton7 = findViewById(R.id.JumpingJacksIcon);
        myImageButton7.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, JumpingJacks_Timer.class);
            startActivity(intent);
        });
        myImageButton8 = findViewById(R.id.JoggingLegLiftsIcon);
        myImageButton8.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, Jogging_Timer.class);
            startActivity(intent);
        });
        myImageButton9 = findViewById(R.id.HipRotationIcon);
        myImageButton9.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, HipRotation_Timer.class);
            startActivity(intent);
        });
        myImageButton10 = findViewById(R.id.ArmCircleIcon);
        myImageButton10.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, ArmCircle_Timer.class);
            startActivity(intent);
        });
        myImageButton11 = findViewById(R.id.KneesLiftIcon);
        myImageButton11.setOnClickListener(v -> {
            Intent intent = new Intent(ExerciseList.this, KneesLift_Timer.class);
            startActivity(intent);
        });
    }
}