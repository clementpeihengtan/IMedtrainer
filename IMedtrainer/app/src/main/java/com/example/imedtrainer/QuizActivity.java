package com.example.imedtrainer;

import android.animation.Animator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.ImageView;

import uk.co.senab.photoview.PhotoViewAttacher;

public class QuizActivity extends AppCompatActivity {

    public ImageInfo [] questionBank = new ImageInfo []{
                new ImageInfo(R.mipmap.image81, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image1, "abnormal", "This is a patient with a good medical record", R.mipmap.ans1),
                new ImageInfo(R.mipmap.image2, "abnormal", "This is a patient with a good medical record", R.mipmap.ans2),
                new ImageInfo(R.mipmap.image82, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image3, "abnormal", "This is a patient with a good medical record", R.mipmap.ans3),
                new ImageInfo(R.mipmap.image85, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image83, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image34, "abnormal", "This is a patient with a good medical record", R.mipmap.ans34),
                new ImageInfo(R.mipmap.image35, "abnormal", "This is a patient with a good medical record", R.mipmap.ans35),
                new ImageInfo(R.mipmap.image84, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image8, "abnormal", "This is a patient with a good medical record", R.mipmap.ans8),
                new ImageInfo(R.mipmap.image92, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image9, "abnormal", "This is a patient with a good medical record", R.mipmap.ans9),
                new ImageInfo(R.mipmap.image86, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image10, "abnormal", "This is a patient with a good medical record", R.mipmap.ans10),
                new ImageInfo(R.mipmap.image11, "abnormal", "This is a patient with a good medical record", R.mipmap.ans11),
                new ImageInfo(R.mipmap.image87, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image12, "abnormal", "This is a patient with a good medical record", R.mipmap.ans12),
                new ImageInfo(R.mipmap.image88, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image89, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image13, "abnormal", "This is a patient with a good medical record", R.mipmap.ans13),
                new ImageInfo(R.mipmap.image14, "abnormal", "This is a patient with a good medical record", R.mipmap.ans14),
                new ImageInfo(R.mipmap.image15, "abnormal", "This is a patient with a good medical record", R.mipmap.ans15),
                new ImageInfo(R.mipmap.image90, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image91, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image16, "abnormal", "This is a patient with a good medical record", R.mipmap.ans16),
                new ImageInfo(R.mipmap.image93, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image17, "abnormal", "This is a patient with a good medical record", R.mipmap.ans17),
                new ImageInfo(R.mipmap.image36, "abnormal", "This is a patient with a good medical record", R.mipmap.ans36),
                new ImageInfo(R.mipmap.image94, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image37, "abnormal", "This is a patient with a good medical record", R.mipmap.ans37),
                new ImageInfo(R.mipmap.image95, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image38, "abnormal", "This is a patient with a good medical record", R.mipmap.ans38),
                new ImageInfo(R.mipmap.image96, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image39, "abnormal", "This is a patient with a good medical record", R.mipmap.ans39),
                new ImageInfo(R.mipmap.image97, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image98, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image40, "abnormal", "This is a patient with a good medical record", R.mipmap.ans40),
                new ImageInfo(R.mipmap.image41, "abnormal", "This is a patient with a good medical record", R.mipmap.ans41),
                new ImageInfo(R.mipmap.image99, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image100, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image42, "abnormal", "This is a patient with a good medical record", R.mipmap.ans42),
                new ImageInfo(R.mipmap.image43, "abnormal", "This is a patient with a good medical record", R.mipmap.ans43),
                new ImageInfo(R.mipmap.image101, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image102, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image103, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image44, "abnormal", "This is a patient with a good medical record", R.mipmap.ans44),
                new ImageInfo(R.mipmap.image64, "abnormal", "This is a patient with a good medical record", R.mipmap.ans64),
                new ImageInfo(R.mipmap.image104, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image105, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image106, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image65, "abnormal", "This is a patient with a good medical record", R.mipmap.ans65),
                new ImageInfo(R.mipmap.image107, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image66, "abnormal", "This is a patient with a good medical record", R.mipmap.ans66),
                new ImageInfo(R.mipmap.image108, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image67, "abnormal", "This is a patient with a good medical record", R.mipmap.ans67),
                new ImageInfo(R.mipmap.image109, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image110, "normal", "This is a patient with a good medical record", 0),
                new ImageInfo(R.mipmap.image76, "abnormal", "This is a patient with a good medical record", R.mipmap.ans76),
                new ImageInfo(R.mipmap.image75, "abnormal", "This is a patient with a good medical record", R.mipmap.ans75)
    };
    public ImageView mImageButton;
    public Button normal;
    public Button abnormal;
    public FloatingActionButton fb;
    private Animator mCurrentAnimator;
    private int mShortAnimationDuration;


    int myCurrentIndex = 0;
    int wrongans = 0;
    int correctans = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);
        mImageButton = findViewById(R.id.imageQuestion);
        PhotoViewAttacher pAttacher = new PhotoViewAttacher(mImageButton);
        pAttacher.update();
        mShortAnimationDuration = getResources().getInteger(
                android.R.integer.config_shortAnimTime);
        updateQuestion();

        normal = (Button)findViewById(R.id.normal);
        normal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("normal");
            }
        });
        abnormal = (Button)findViewById(R.id.abnormal);
        abnormal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                checkAnswer("abnormal");
            }
        });

        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE);
        fb = findViewById(R.id.fabAdd);
        fb.startAnimation(animation);
        fb.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent popintent = new Intent(view.getContext(), Pop.class);
                popintent.putExtra("hint", questionBank[myCurrentIndex].gethint());
                startActivity(popintent);
                view.clearAnimation();
            }
        });
    }

    public void updateQuestion() {
        int question = questionBank[myCurrentIndex].getImage_id();
        mImageButton.setImageResource(question);
    }

    public void checkAnswer(String ans) {
        String answeristrue = questionBank[myCurrentIndex].getans();
        if(answeristrue.equals(ans)) {
            if(ans.equals("normal")) {
                Intent normalCpop = new Intent(this, CorrectNormalPU.class);
                normalCpop.putExtra("imageID", questionBank[myCurrentIndex].getImage_id());
                startActivity(normalCpop);
                myCurrentIndex+=1;
            }else{
                Intent abnormalCpop = new Intent(this, CorrectAbnormalPU.class);
                abnormalCpop.putExtra("imageID", questionBank[myCurrentIndex].getAns_image_id());
                startActivity(abnormalCpop);
                myCurrentIndex+=1;
            }
            correctans+=1;
        }else {
            if(answeristrue.equals("normal")) {
                Intent normalCpop = new Intent(this, IncorrectNormalPU.class);
                normalCpop.putExtra("imageID", questionBank[myCurrentIndex].getImage_id());
                startActivity(normalCpop);
                myCurrentIndex+=1;
            }else {
                //tell user it is incorrect, abnormal, show the abnormality
                Intent abnormalCpop = new Intent(this, IncorrectAbnormal.class);
                abnormalCpop.putExtra("imageID", questionBank[myCurrentIndex].getAns_image_id());
                startActivity(abnormalCpop);
                myCurrentIndex+=1;
            }
            wrongans+=1;
        }
        if(myCurrentIndex >= questionBank.length) {
            Intent respage = new Intent(this, Result.class);
            respage.putExtra("correct", correctans);
            respage.putExtra("wrong", wrongans);
            startActivity(respage);
            myCurrentIndex = 0;
        }else{
            Handler ha = new Handler();
            Runnable rn = new Runnable() {
                @Override
                public void run() {
                    mImageButton.setImageResource(questionBank[myCurrentIndex].getImage_id());
                }
            };
            ha.postDelayed(rn, 1000);
        }
        final Animation animation = new AlphaAnimation(1, 0); // Change alpha from fully visible to invisible
        animation.setDuration(500); // duration - half a second
        animation.setInterpolator(new LinearInterpolator()); // do not alter animation rate
        animation.setRepeatCount(Animation.INFINITE); // Repeat animation infinitely
        animation.setRepeatMode(Animation.REVERSE);
        fb = findViewById(R.id.fabAdd);
        fb.startAnimation(animation);
    }
}
