package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button mybutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        mybutton = findViewById(R.id.arm_reach_button);
        mybutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, ExerciseList.class);
            startActivity(intent);
        });
        mybutton = findViewById(R.id.quiz_button);
        mybutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, ExerciseQuiz.class);
            startActivity(intent);
        });








        //FULL Screen Display
        this.getWindow().getDecorView().setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                  |  View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                  |  View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                  |  View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                  |  View.SYSTEM_UI_FLAG_FULLSCREEN
                  |  View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
        );
    }


    }
