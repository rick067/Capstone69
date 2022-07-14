package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.support.v4.app.INotificationSideChannel;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.VideoView;
import android.widget.MediaController;

import java.util.Locale;

public class HipRotation_Timer extends AppCompatActivity {

    ImageView img;
    ImageButton myImageHomeButton;
    //get timer data
    DBHelper DB = new DBHelper(this);

    private static long START_TIME_IN_MILLIS;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis;
    VideoView videoView;
    private INotificationSideChannel.Default someCountDownTimer;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hip_rotation_timer);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        //get timer data
        int data = DB.getTimerData();
        START_TIME_IN_MILLIS = data*1000;
        mTimeLeftInMillis = START_TIME_IN_MILLIS;

        VideoView videoView =findViewById(R.id.videoView4);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.hiprotationvideo);
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

        myImageHomeButton = findViewById(R.id.imageHomeButton3);
        myImageHomeButton.setOnClickListener(v -> {
            mCountDownTimer.cancel();
            mCountDownTimer = null;
            Intent intent= new Intent(HipRotation_Timer.this, MainMenu.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
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


        img = findViewById(R.id.imageView);

        img.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                MediaPlayer mp = MediaPlayer.create(HipRotation_Timer.this,R.raw.hiprotation);
                mp.start();
                return false;
            }
        });

        mTextViewCountDown = findViewById(R.id.countdown_text);
        mButtonStartPause = findViewById(R.id.startButton);
        mButtonReset = findViewById(R.id.resetButton);
        startTimer();
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                    videoView.pause();
                } else {
                    startTimer();
                    videoView.start();
                }

            }
        });
        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();

    }
    private void startTimer() {
        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),KneesLift_Timer.class));
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.VISIBLE);
    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Continue");
        mButtonReset.setVisibility(View.VISIBLE );
    }
    private void resetTimer(){
        //get timer data
        int data = DB.getTimerData();
        START_TIME_IN_MILLIS = data*1000;
        mTimeLeftInMillis = START_TIME_IN_MILLIS;

        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setText("Pause");
        mButtonStartPause.setVisibility(View.VISIBLE);

        VideoView videoView =findViewById(R.id.videoView4);
        videoView.setVideoPath("android.resource://"+getPackageName()+"/"+R.raw.hiprotationvideo);
        MediaController mediaController = new MediaController(this);
        mediaController.setAnchorView(videoView);
        videoView.setMediaController(mediaController);
        videoView.start();
        mediaController.setVisibility(View.INVISIBLE);
        videoView.setMediaController(mediaController);

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),KneesLift_Timer.class));
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.VISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }
    @Override
    public void onBackPressed() {
        mCountDownTimer.cancel();
        mCountDownTimer = null;

    }

}