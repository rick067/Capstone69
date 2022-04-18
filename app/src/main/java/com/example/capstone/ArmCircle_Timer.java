package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class ArmCircle_Timer extends AppCompatActivity {
    private static final  long START_TIME_IN_MILLIS = 10000;
    private TextView mTextViewCountDown;
    private Button mButtonStartPause;
    private Button mButtonReset;
    private CountDownTimer mCountDownTimer;
    private boolean mTimerRunning;
    private long mTimeLeftInMillis = START_TIME_IN_MILLIS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_arm_circle_timer);
        mTextViewCountDown = findViewById(R.id.countdown_text);
        mButtonStartPause = findViewById(R.id.startButton);
        mButtonReset = findViewById(R.id.resetButton);
        startTimer();
        mButtonStartPause.setOnClickListener(new View.OnClickListener() {



            @Override
            public void onClick(View v) {
                if (mTimerRunning) {
                    pauseTimer();
                } else {
                    startTimer();
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
                startActivity(new Intent(getApplicationContext(),SideReach_Timer.class));
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    private void pauseTimer(){
        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPause.setText("Continue");
        mButtonReset.setVisibility(View.VISIBLE );
    }
    private void resetTimer(){
        mTimeLeftInMillis = START_TIME_IN_MILLIS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
        mButtonStartPause.setText("Pause");
        mButtonStartPause.setVisibility(View.VISIBLE);

        mCountDownTimer = new CountDownTimer(mTimeLeftInMillis, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                mTimeLeftInMillis = millisUntilFinished;
                updateCountDownText();
            }
            @Override
            public void onFinish() {
                startActivity(new Intent(getApplicationContext(),SideReach_Timer.class));
            }
        }.start();
        mTimerRunning = true;
        mButtonStartPause.setText("Pause");
        mButtonReset.setVisibility(View.INVISIBLE);
    }
    private void updateCountDownText(){
        int minutes = (int) (mTimeLeftInMillis / 1000) / 60;
        int seconds = (int) (mTimeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        mTextViewCountDown.setText(timeLeftFormatted);
    }


}