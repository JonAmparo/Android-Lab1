package com.lab1.mainscreen;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    public Button aboutMeBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button aboutMeBtn = findViewById(R.id.aboutBtn);
        aboutMeBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent startIntent = new Intent(getApplicationContext(), AboutMe.class);
                startActivity(startIntent);
            }
        });

        TextView dateSetter = findViewById(R.id.dateTV);
        setDate(dateSetter);
    }


    public void setDate(TextView view) {
        String str = String.format("%tc", new Date());
        view.setText(str);
    }


}
