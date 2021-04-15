package com.example.bmi;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ResultsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);

        Intent intent = getIntent();

        float BMI  = Math.round((intent.getFloatExtra("BMI", 0) * 100) / 100); // MILLANEN MEILLÄ TULEE?
        //String age_value = intent.getStringExtra("age");

        TextView your_bmi = findViewById(R.id.your_bmi);
        your_bmi.setText(String.valueOf(BMI));

        //TextView age = findViewById(R.id.age);
        //age.setText(age_value);

        TextView category = findViewById(R.id.Category);
        Category category1 = new Category();
        category.setText(category1.getCategory(BMI));

        TextView condition = findViewById(R.id.healthiness);
        healthiness healthiness1 = new healthiness();
        condition.setText(healthiness1.getCategory(BMI));

        Button recalculate = findViewById(R.id.recalculate);
        recalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateUI();
            }
        });

    }

    private void updateUI() {
        Intent intent1 = new Intent(ResultsActivity.this,MainActivity.class);
        startActivity(intent1);
        fileList();
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        updateUI();
    }
}
    }
}