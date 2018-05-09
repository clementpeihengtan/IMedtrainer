package com.example.imedtrainer;

import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.widget.TextView;

/**
 * Created by clementtan on 2/19/18.
 */

public class Pop extends QuizActivity {
    @Override
    protected void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.infowindow);

        TextView tv = (TextView) findViewById(R.id.hint_id);
        Intent myintent = getIntent();
        tv.setText(myintent.getStringExtra("hint"));

        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int) (width * .8), (int) (height*.6));
    }
}
