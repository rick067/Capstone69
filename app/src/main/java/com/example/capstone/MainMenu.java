package com.example.capstone;

import static android.app.NotificationManager.IMPORTANCE_DEFAULT;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.AlertDialog;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.VideoView;
import android.widget.MediaController;

public class MainMenu extends AppCompatActivity {
    Button mybutton;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);

        VideoView videoView =findViewById(R.id.videoView1);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.squatsvideo);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        mediaController.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mediaController);

        videoView.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

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
            Intent intent = new Intent(MainMenu.this, Pushup_Timer.class);
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
    @Override
    public void onBackPressed() {
        AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(this);
        alertDialogBuilder
                .setMessage("Do you want to exit?")
                .setCancelable(false)
                .setPositiveButton("Yes",
                        new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                moveTaskToBack(true);
                                android.os.Process.killProcess(android.os.Process.myPid());
                                System.exit(1);
                            }
                        })

                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {

                        dialog.cancel();
                    }
                });

        AlertDialog alertDialog = alertDialogBuilder.create();
        alertDialog.show();
    }



    }
