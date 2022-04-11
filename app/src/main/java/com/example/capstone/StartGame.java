package com.example.capstone;

import android.content.Intent;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;

public class StartGame extends AppCompatActivity {

    TextView tvTimer;
    TextView tvResult;
    ImageView ivShowImage;
    HashMap<String, Integer> map = new HashMap<>();
    ArrayList<String> techlist = new ArrayList<>();
    int index;
    Button btn1, btn2, btn3, btn4;
    TextView tvPoints;
    int points;
    CountDownTimer countDownTimer;
    long millisUntilFinished;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.start_game);
        tvTimer = findViewById(R.id.tvTimer);
        tvResult = findViewById(R.id.tvResult);
        ivShowImage = findViewById(R.id.ivShowimage);
        btn1 = findViewById(R.id.btn1);
        btn2 = findViewById(R.id.btn2);
        btn3 = findViewById(R.id.btn3);
        btn4 = findViewById(R.id.btn4);
        tvPoints = findViewById(R.id.tvPoints);
        index = 0;
        techlist.add("Planking");
        techlist.add("Push-Ups");
        techlist.add("Side Lunges");
        techlist.add("Side Reach");
        techlist.add("Squat");
        techlist.add("Triceps Warm-up");
        techlist.add("Arm Circle");
        techlist.add("Arm Reach");
        techlist.add("Jumping Jacks");
        techlist.add("Knees Lift");
        map.put(techlist.get(0), R.drawable.planking);
        map.put(techlist.get(1), R.drawable.pushups);
        map.put(techlist.get(2), R.drawable.sidelunges);
        map.put(techlist.get(3), R.drawable.sidereach);
        map.put(techlist.get(4), R.drawable.squats);
        map.put(techlist.get(5), R.drawable.tricepswarmup);
        map.put(techlist.get(6), R.drawable.armcircle);
        map.put(techlist.get(7), R.drawable.armreach);
        map.put(techlist.get(8), R.drawable.jumpingjacks);
        map.put(techlist.get(9), R.drawable.kneeslift);
        Collections.shuffle(techlist);
        millisUntilFinished = 1000;
        points = 0;
        startGame();

    }

    private void startGame() {
        millisUntilFinished = 10000;
        tvTimer.setText("" +(millisUntilFinished / 1000) + "s");
        tvPoints.setText(points + " / " + techlist.size());
        generateQuestions(index);
        countDownTimer = new CountDownTimer(millisUntilFinished, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                tvTimer.setText("" + (millisUntilFinished / 1000) + "s");

            }

            @Override
            public void onFinish() {
                index++;
                if (index > techlist.size() - 1){
                    ivShowImage.setVisibility(View.GONE);
                    btn1.setVisibility(View.GONE);
                    btn2.setVisibility(View.GONE);
                    btn3.setVisibility(View.GONE);
                    btn4.setVisibility(View.GONE);
                    Intent intent = new Intent(StartGame.this, GameOver.class);
                    intent.putExtra("points", points);
                    startActivity(intent);
                    finish();

                } else {
                    startGame();
                }
            }
        }.start();
    }

    private void generateQuestions(int index) {
        ArrayList<String> techListTemp = (ArrayList<String>) techlist.clone();
        String correctAnswer = techlist.get(index);
        techListTemp.remove(correctAnswer);
        Collections.shuffle(techListTemp);
        ArrayList<String> newList = new ArrayList<>();
        newList.add(techListTemp.get(0));
        newList.add(techListTemp.get(1));
        newList.add(techListTemp.get(2));
        newList.add(correctAnswer);
        Collections.shuffle(newList);
        btn1.setText(newList.get(0));
        btn2.setText(newList.get(1));
        btn3.setText(newList.get(2));
        btn4.setText(newList.get(3));
        ivShowImage.setImageResource(map.get(techlist.get(index)));


    }

    public void nextQuestion(View view) {
        countDownTimer.cancel();
        index++;
        if (index > techlist.size() - 1){
            ivShowImage.setVisibility(View.GONE);
            btn1.setVisibility(View.GONE);
            btn2.setVisibility(View.GONE);
            btn3.setVisibility(View.GONE);
            btn4.setVisibility(View.GONE);
            Intent intent = new Intent(StartGame.this, GameOver.class);
            intent.putExtra("points", points);
            startActivity(intent);
            finish();
        } else {
            startGame();
        }
    }

    public void answerSelected(View view) {
        countDownTimer.cancel();
        String answer = ((Button) view).getText().toString().trim();
        String correctAnswer = techlist.get(index);
        if (answer.equals(correctAnswer)) {
            points++;
            tvPoints.setText(points + " / " + techlist.size());
            tvResult.setText("Correct");
        } else {
            tvResult.setText("Wrong");

        }
    }
}
