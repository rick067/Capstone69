package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ExerciseQuiz extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_quiz);
    }

    public void startGame(View view) {
        Intent intent = new Intent(ExerciseQuiz.this, StartGame.class);
        startActivity(intent);
        finish();
    }
}