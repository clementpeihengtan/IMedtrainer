package com.example.imedtrainer;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Result extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        Intent intent = getIntent();
        int correct = intent.getIntExtra("correct", -1);
        int wrong = intent.getIntExtra("wrong", -1);
        double score = correct/0.6;

        TextView wrongans = findViewById(R.id.wrong);
        wrongans.setText(String.valueOf(wrong));

        TextView correctans = findViewById(R.id.correct);
        correctans.setText(String.valueOf(correct));

        TextView res_score = findViewById(R.id.score);
        res_score.setText(String.format("%.1f", score)+"%");

        Button home = findViewById(R.id.home);
        home.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent backhome = new Intent(Result.this, MainActivity.class);
                backhome.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                startActivity(backhome);
            }
        });
//        Button statistic = findViewById(R.id.statistic);
//        statistic.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//
//            }
//        });

    }
}
