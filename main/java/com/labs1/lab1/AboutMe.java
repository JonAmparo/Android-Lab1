package com.labs1.lab1;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.Button;

public class AboutMe extends AppCompatActivity {

    private Button backMoveBtn;

    private Button secretMoveBtn;
    private Button secretGoBackMoveBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_me);

        // Back Button - Button Listener
        backMoveBtn = findViewById(R.id.backBtn);
        backMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToBack();
            }
        });

        // Secret Button - Button Listener
        secretMoveBtn = findViewById(R.id.secretBtn);
        secretMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyCustomAlertDialog();
            }
        });
    }

    // Secret Dialog - Custom Alert Dialog
    public void MyCustomAlertDialog(){
        final Dialog MyDialog = new Dialog(AboutMe.this);
        MyDialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        MyDialog.setContentView(R.layout.customdialog);
        MyDialog.setTitle("My Custom Dialog");

        secretGoBackMoveBtn = MyDialog.findViewById(R.id.secretGoBackBtn);

        secretGoBackMoveBtn.setEnabled(true);

        secretGoBackMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MyDialog.cancel();
            }
        });
        MyDialog.show();
    }

    // Back Button - New Activity Method
    private void moveToBack(){
        Intent aboutMeIntent = new Intent(AboutMe.this, MainActivity.class);
        startActivity(aboutMeIntent);
    }

}
