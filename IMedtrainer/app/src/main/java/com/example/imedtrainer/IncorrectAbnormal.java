package com.example.imedtrainer;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

/**
 * Created by clementtan on 4/6/18.
 */

public class IncorrectAbnormal extends QuizActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.incorrect_abnormal);

//        TextView tv = (TextView) findViewById(R.id.hint_id);
        Intent myintent = getIntent();
//        tv.setText(myintent.getStringExtra("hint"));

        ImageView imageanswer = findViewById(R.id.answerImage);
        imageanswer.setImageResource(myintent.getIntExtra("imageID", 0));
        PhotoViewAttacher pAttacher = new PhotoViewAttacher(imageanswer);
        pAttacher.update();
        Button btn = findViewById(R.id.next);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width), (int) (height));
    }
}
