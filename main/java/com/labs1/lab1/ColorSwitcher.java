package com.labs1.lab1;

import android.content.Intent;
import android.graphics.Color;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.RadioButton;
import android.widget.Toast;

public class ColorSwitcher extends AppCompatActivity {

    private Button backMoveBtn;

    private RadioButton redRB, greenRB, blueRB;
    private CheckBox redCB, greenCB, blueCB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_color_switcher);

//        Drawable d = findViewById(R.drawable.boxes.);
//        d.setBackgroundDrawable( new DrawableGradient(new int[] { 0xff666666, 0xff111111, 0xffffffff }, 0).SetTransparency(10));

        // Back Button - Button Listener
        backMoveBtn = findViewById(R.id.backBtn);
        backMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                moveToBack();
            }
        });
    }

    // CheckBox Buttons
    public void onCheckBoxClicked(View view) {
        boolean checked2 = ((CheckBox) view).isChecked();

        redCB = findViewById(R.id.redCB);
        greenCB = findViewById(R.id.inclueTipCB);
        blueCB = findViewById(R.id.blueCB);

        int redColor2 = 0;
        int greenColor2 = 0;
        int blueColor2 = 0;

        switch (view.getId()) {
            case R.id.redCB:
                redColor2 = 255;
                if (checked2) {

                    Toast.makeText(getApplicationContext(), "Red dead! - " + redCB.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (greenCB.isChecked() && blueCB.isChecked()) {
                        greenColor2 = 255;
                        blueColor2 = 255;
                    } else if (greenCB.isChecked() && !blueCB.isChecked()) {
                        greenColor2 = 255;
                        blueColor2 = 0;
                    } else if (!greenCB.isChecked() && !blueCB.isChecked()) {
                        greenColor2 = 0;
                        blueColor2 = 0;
                    } else if (!greenCB.isChecked() && blueCB.isChecked()) {
                        greenColor2 = 0;
                        blueColor2 = 255;
                    }

                }
                break;

            case R.id.inclueTipCB:
                greenColor2 = 255;
                if (checked2) {

                    Toast.makeText(getApplicationContext(), "Green sucks! It's like puke! - " + greenCB.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (redCB.isChecked() && blueCB.isChecked()) {
                        redColor2 = 255;
                        blueColor2 = 255;
                    } else if (redCB.isChecked() && !blueCB.isChecked()) {
                        redColor2 = 255;
                        blueColor2 = 0;
                    } else if (!redCB.isChecked() && !blueCB.isChecked()) {
                        redColor2 = 0;
                        blueColor2 = 0;
                    } else if (!redCB.isChecked() && blueCB.isChecked()) {
                        redColor2 = 0;
                        blueColor2 = 255;
                    }
                }
                break;

            case R.id.blueCB:
                blueColor2 = 255;
                if (checked2) {

                    Toast.makeText(getApplicationContext(), "Blue rules!" + blueCB.getText().toString(), Toast.LENGTH_SHORT).show();
                    if (redCB.isChecked() && greenCB.isChecked()) {
                        redColor2 = 255;
                        greenColor2 = 255;
                    } else if (redCB.isChecked() && !greenCB.isChecked()) {
                        redColor2 = 255;
                        greenColor2 = 0;
                    } else if (!redCB.isChecked() && !greenCB.isChecked()) {
                        redColor2 = 0;
                        greenColor2 = 0;
                    } else if (!redCB.isChecked() && greenCB.isChecked()) {
                        redColor2 = 0;
                        greenColor2 = 255;
                    }
                }
                break;
        }

        int colorCB = Color.argb(155, redColor2, greenColor2, blueColor2);

        ConstraintLayout cbColor = findViewById(R.id.cbColorChanger);
        cbColor.setBackgroundColor(colorCB);
    }

    // Radio Buttons
    public void onRadioButtonClicked(View view) {
        // Is the button now checked?
        boolean checked = ((RadioButton) view).isChecked();
        redRB = findViewById(R.id.redRB);
        greenRB = findViewById(R.id.greenRB);
        blueRB = findViewById(R.id.blueRB);

        int redColor = 0;
        int greenColor = 0;
        int blueColor = 0;

        // Check which radio button was clicked
        switch (view.getId()) {
            case R.id.redRB:
                if (checked)
                    redColor = 255;
                Toast.makeText(getApplicationContext(), "Red dead!" + redRB.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.greenRB:
                if (checked)
                    greenColor = 255;
                Toast.makeText(getApplicationContext(), "Green sucks! It's like puke!" + greenRB.getText().toString(), Toast.LENGTH_SHORT).show();
                break;
            case R.id.blueRB:
                if (checked)
                    blueColor = 255;
                Toast.makeText(getApplicationContext(), "Blue rules!" + blueRB.getText().toString(), Toast.LENGTH_SHORT).show();
                break;

        }
        int colorRB = Color.argb(155, redColor, greenColor, blueColor);

        ConstraintLayout rbColor = findViewById(R.id.rbColorChanger);
        rbColor.setBackgroundColor(colorRB);
    }

    // TRIED TO GET MY DRAWABLE CLASS BOXES TO CHANGE TO START/END COLOR BUT I GUESS NOT
    // BECAUSE IT'S AN IMAGE???

//    int h = view.getHeight();
//    ShapeDrawable mDrawable = new ShapeDrawable(new RectShape());
//        mDrawable.getPaint().setShader(new LinearGradient(0,0,0, h, Color.parseColor("#330000FF"), Color.parseColor("#110000FF"), Shader.TileMode.REPEAT));
//        view.setBackground(mDrawable);

//    public class DrawableGradient extends GradientDrawable {
//        DrawableGradient(int[] colors, int cornerRadius) {
//            super(GradientDrawable.Orientation.TOP_BOTTOM, colors);
//
//            try {
//                this.setShape(GradientDrawable.RECTANGLE);
//                this.setGradientType(GradientDrawable.LINEAR_GRADIENT);
//                this.setCornerRadius(cornerRadius);
//            } catch (Exception e) {
//                e.printStackTrace();
//            }
//        }
//
//        public DrawableGradient SetTransparency(int transparencyPercent) {
//            this.setAlpha(255 - ((255 * transparencyPercent) / 100));
//
//            return this;
//        }
//    }


    // Back Button - New Activity Method
    private void moveToBack() {
        Intent colorSwitcherIntent = new Intent(ColorSwitcher.this, MainActivity.class);
        startActivity(colorSwitcherIntent);
    }
}
