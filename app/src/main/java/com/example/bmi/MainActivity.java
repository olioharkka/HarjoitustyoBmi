package com.example.bmi;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

public class MainActivity extends AppCompatActivity {


    RelativeLayout WeightPlus, WeightMinus, AgePlus, AgeMinus; // Displays child views in relative positions
    boolean male_clk = true, female_clk = true, check1 = true, check2 = true;
    float height,weight;
    int count_weight = 50,count_age = 19;
    TextView HeightTxt,age;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        HeightTxt = findViewById(R.id.HeightTxt);

       // final TextView female_text = findViewById(R.id.female);
        //final TextView male_text = findViewById(R.id.male);

        CardView card_female = findViewById(R.id.cardView_female);
        CardView card_male = findViewById(R.id.cardView_male);

        AgeMinus = findViewById(R.id.AgeMinus);
        AgePlus = findViewById(R.id.age_plus);

        WeightMinus = findViewById(R.id.weight_minus);
        WeightPlus = findViewById(R.id.weight_plus);

       /* card_male.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check1) {

                    if (male_clk) {

                        male_text.setTextColor(Color.parseColor("#FFFFFF"));
                        male_text.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.male_white,0,0);
                        male_clk = false;
                        check2 = false;

                    } else {

                        male_text.setTextColor(Color.parseColor("#8D8E99"));
                        male_text.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.male,0,0);
                        male_clk = true;
                        check2 = true;
                    }
                }
            }
        });

        card_female.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (check2) {
                    if (female_clk) {
                        female_text.setTextColor(Color.parseColor("#FFFFFF"));
                        female_text.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.female_white,0,0);
                        female_clk = false;
                        check1 = false;
                    }
                    else  {

                        female_text.setTextColor(Color.parseColor("#8D8E99"));
                        female_text.setCompoundDrawablesWithIntrinsicBounds(0,R.drawable.female,0,0);
                        female_clk = true;
                        check1 = true;
                    }
                }
            }
        });*/

        CheckSeekbarStatus();

        CheckWeight();

        CheckAge();

        Button calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                CalculateBMI();
            }
        });

    }


    private void CheckAge() {  //nappuloita

        age = findViewById(R.id.age);

        age_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_age++;
                age.setText(String.valueOf(count_age));
            }
        });

        age_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_age--;
                age.setText(String.valueOf(count_age));
            }
        });
    }

    private void CheckWeight() {            //nappuloita

        final TextView weight_txt = findViewById(R.id.weight);

        weight_plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_weight++;
                weight_txt.setText(String.valueOf(count_weight));
            }
        });

        weight_minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                count_weight--;
                weight_txt.setText(String.valueOf(count_weight));
            }
        });

        weight = Float.parseFloat(weight_txt.getText().toString());

    }

    private void CheckSeekbarStatus() {

        SeekBar Seekbar = findViewById(R.id.Seekbar);
        Seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                String ht = progress + getResources().getString(R.string.cm);
                height_txt.setText(ht);
                height = (float)(progress)/100;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

   /* private void CalculateBMI() {   // tänne ulkoinen rajapinta

        float BMI = weight / (height * height);
        Intent intent = new Intent(MainActivity.this,ResultActivity.class);
        intent.putExtra("BMI",BMI);
        intent.putExtra("age",age.getText().toString());
        startActivity(intent);
    }*/
}
    }
}