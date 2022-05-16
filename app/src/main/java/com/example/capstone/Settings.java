package com.example.capstone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Settings extends AppCompatActivity {

    EditText editseconds;
    Button buttonsecs;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);

        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        editseconds=findViewById(R.id.text_input);
        buttonsecs=findViewById(R.id.secsbutton);
        DB=new DBHelper(this);

        int data = DB.getTimerData();
        Toast.makeText(Settings.this,"timerData: "+data, Toast.LENGTH_SHORT).show();
        editseconds.setText(data+"");

        buttonsecs.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String secs = editseconds.getText().toString();
                int time = Integer.parseInt(secs);
                Boolean updateData = DB.updateTimerData(time);

                if(updateData==true){
                    Toast.makeText(Settings.this,"Success", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(Settings.this,"Failed", Toast.LENGTH_SHORT).show();
                }


            }
        });

    }
}