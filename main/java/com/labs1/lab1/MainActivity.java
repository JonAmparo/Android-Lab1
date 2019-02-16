package com.labs1.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Date;

public class MainActivity extends AppCompatActivity {

    private Button aboutMeMoveBtn;
    private Button colorSwitcherMoveBtn;
    private Button tipCalculatorMoveBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // About Me - Button Listener
        aboutMeMoveBtn = findViewById(R.id.aboutBtn);
        aboutMeMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToAboutMe();
            }
        });

        // Color Switcher - Button Listener
        colorSwitcherMoveBtn = findViewById(R.id.backBtn);
        colorSwitcherMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToColorSwitcher();
            }
        });

        // Tip Calculator - Button Listener
        tipCalculatorMoveBtn = findViewById(R.id.secretBtn);
        tipCalculatorMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToTipCalculator();
            }
        });

        // Date Setter
        TextView dateSetter = findViewById(R.id.dateTV);
        setDate(dateSetter);
    }

    // About Me - New Activity Method
    private void moveToAboutMe(){
        Intent aboutMeIntent = new Intent(MainActivity.this, AboutMe.class);
        startActivity(aboutMeIntent);
    }

    // Color Switcher - New Activity Method
    private void moveToColorSwitcher(){
        Intent colorSwitcherIntent = new Intent(MainActivity.this, ColorSwitcher.class);
        startActivity(colorSwitcherIntent);
    }

    // Tip Calculator - New Activity Method
    private void moveToTipCalculator(){
        Intent tipCalculatorIntent = new Intent(MainActivity.this, TipCalculator.class);
        startActivity(tipCalculatorIntent);
    }

    // Date Setter Listener
    public void setDate(TextView view) {
        String str = String.format("%tc", new Date());
        view.setText(str);
    }
}
