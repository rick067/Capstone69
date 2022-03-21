package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        button = (Button) findViewById(R.id.button6);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openExerciseList();
            }
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

    private void openExerciseList() {
        Intent intent = new Intent( this, ExerciseList.class);
        startActivity(intent);
    }
}