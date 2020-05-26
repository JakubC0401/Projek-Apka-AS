package com.example.multifunctionapp;

import androidx.appcompat.app.AppCompatActivity;

import android.media.Image;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.ImageView;

public class StopwatchActivity extends AppCompatActivity {

    Button btnStart, btnFinish;
    Chronometer chronometer;
    Animation animationR;
    ImageView imageView2;
    long pause;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stopwatch);

        btnStart=(Button)findViewById(R.id.btnStart);
        btnFinish=(Button)findViewById(R.id.btnFinish);
        chronometer=(Chronometer)findViewById(R.id.chronometer);
        imageView2=(ImageView)findViewById(R.id.imageView);

        animationR= AnimationUtils.loadAnimation(this,R.anim.anim_rotation);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView2.startAnimation(animationR);
                chronometer.setFormat("%s");
                chronometer.setBase(SystemClock.elapsedRealtime()-pause);
                chronometer.start();
                btnFinish.setVisibility(View.VISIBLE);
                btnStart.setVisibility(View.INVISIBLE);
            }
        });
        btnFinish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                chronometer.stop();
                chronometer.setBase(SystemClock.elapsedRealtime());
                pause=0;
                animationR.cancel();
                imageView2.setAnimation(animationR);
                btnStart.setVisibility(View.VISIBLE);
                btnFinish.setVisibility(View.INVISIBLE);


            }
        });
    }
}
