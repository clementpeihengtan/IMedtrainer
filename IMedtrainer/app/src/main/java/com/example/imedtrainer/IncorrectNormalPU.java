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

public class IncorrectNormalPU extends QuizActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.incorrect_normal);

//        TextView tv = (TextView) findViewById(R.id.hint_id);
        Intent myintent = getIntent();
        ImageView image = findViewById(R.id.answerImage);
        image.setImageResource(myintent.getIntExtra("imageID", 0));
//        tv.setText(myintent.getStringExtra("hint"));
        PhotoViewAttacher pAttacher = new PhotoViewAttacher(image);
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
