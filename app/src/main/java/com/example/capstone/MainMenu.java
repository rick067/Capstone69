package com.example.capstone;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainMenu extends AppCompatActivity {
    Button mybutton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            NotificationChannel channel = new NotificationChannel ("My Notification", "My Notification", IMPORTANCE_DEFAULT);
            NotificationManager manager = getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }

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
        mybutton = findViewById(R.id.button6);
        mybutton.setOnClickListener(v -> {
            Intent intent = new Intent(MainMenu.this, ExerciseList.class);
            startActivity(intent);


        //notification code

        NotificationCompat.Builder builder = new NotificationCompat.Builder(MainMenu.this, "My Notification");
        builder.setContentTitle("Warm-up Exercise App");
        builder.setContentText("You finished your warm-up exercise for today.");
        builder.setSmallIcon(R.drawable.squats);
        builder.setAutoCancel (true);

        NotificationManagerCompat managerCompat = NotificationManagerCompat.from(MainMenu.this);
        managerCompat.notify(1,builder.build());
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
