package com.labs1.lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TipCalculator extends AppCompatActivity {

    private Button backMoveBtn;
    private Button calculateBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tip_calculator);

        // Back Button - Button Listener
        backMoveBtn = findViewById(R.id.backBtn);
        backMoveBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onBackPressed();
               finish();
            }
        });

        // Back Button - Button Listener
        calculateBtn = findViewById(R.id.calculateBtn);
        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tipCalculations();
            }
        });
    }

    public void tipCalculations() {
        Float bill_use = 0.0f;
        Float gst_user = 0.0f;
        Float hst_user = 0.0f;
        Float tip_user = 0.0f;
        Float number_people = 1.0f;
        Float tipperson = 0.0f;
        Float toltalperson = 0.0f;

        Float gst_amount = 0.0f;
        Float hst_amount = 0.0f;

        try {

            EditText b_user = findViewById(R.id.billTXT);
            if(b_user != null && !b_user.getText().equals("") && b_user.getText() != null) {
                bill_use = Float.valueOf(b_user.getText().toString());
            }

            EditText gt_user = (EditText) findViewById(R.id.gstTXT);
            if (gt_user != null && !gt_user.getText().equals("") && gt_user.getText() != null) {
                gst_user = Float.valueOf(gt_user.getText().toString());
            }

            EditText ht_user = (EditText) findViewById(R.id.hstTXT);
            if (ht_user != null && !ht_user.getText().equals("") && ht_user.getText() != null) {
                hst_user = Float.valueOf(ht_user.getText().toString());
            }

            EditText tp_user = (EditText) findViewById(R.id.tipPercentageTXT);
            if (tp_user != null && !tp_user.getText().equals("") && tp_user.getText() != null) {
                tip_user = Float.valueOf(tp_user.getText().toString());
            }

            EditText numberuser = (EditText) findViewById(R.id.numberOfPeopleTXT);
            if (numberuser != null && !numberuser.getText().equals("") && numberuser.getText() != null) {
                number_people = Float.valueOf(numberuser.getText().toString());
            }

            gst_amount = ((bill_use) * gst_user /100);
            hst_amount = (hst_user /100 * (bill_use));

            if (bill_use <= 50000 && gst_user <= 1500 && hst_user < 1500 && number_people <= 500)
                toltalperson = (bill_use + gst_amount + hst_amount) / number_people;

            CheckBox tipbox = (CheckBox) findViewById(R.id.inclueTipCB);

            if (bill_use <= 50000 && gst_user <= 1500 && hst_user < 1500 && number_people <= 500 && tip_user <= 1000) {

                if (tipbox.isChecked()) {
                    tipperson = ((bill_use + gst_user + hst_user) * tip_user / 100) / number_people;
                } else if (!tipbox.isChecked()) {
                    tipperson = (bill_use * tip_user / 100) / number_people;
                }
            }

            TextView total_user = (TextView) findViewById(R.id.amountTV1);
            total_user.setText("");
            total_user.setText(toltalperson.toString());


            TextView tipview = (TextView) findViewById(R.id.amountTV2);
            tipview.setText("");
            tipview.setText(tipperson.toString());

        } catch (Exception e) {
            Toast.makeText(getApplicationContext(), "Error!  please check your try catch" , Toast.LENGTH_LONG).show();
        }
    }

    public void calculate(View view) {

    }
}
