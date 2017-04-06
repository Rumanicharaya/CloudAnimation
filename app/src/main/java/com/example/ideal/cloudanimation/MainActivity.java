package com.example.ideal.cloudanimation;

import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.animation.ArgbEvaluator;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView ivGif = (ImageView) findViewById(R.id.ivGif);
        // Display the GIF (from raw resource) into the ImageView
        Glide.with(this).load(R.raw.rainfallanimation).asGif().into(ivGif);


        ImageView wheel=(ImageView)findViewById(R.id.wheel);

        AnimatorSet wheelSet=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.wheel_spin);
        wheelSet.setTarget(wheel);
        wheelSet.start();

        ImageView sun=(ImageView)findViewById(R.id.sun);
        AnimatorSet sunSet=(AnimatorSet) AnimatorInflater.loadAnimator(this,R.animator.sun_swing);
        sunSet.setTarget(sun);
        sunSet.start();


        ValueAnimator skyAnim = ObjectAnimator.ofInt
                (findViewById(R.id.car_layout), "backgroundColor",
                        Color.rgb(0x66, 0xcc, 0xff), Color.rgb(0x00, 0x66, 0x99));

        skyAnim.setDuration(3000);
        skyAnim.setRepeatCount(ValueAnimator.INFINITE);
        skyAnim.setRepeatMode(ValueAnimator.REVERSE);
        skyAnim.setEvaluator(new ArgbEvaluator());
        skyAnim.start();

        ObjectAnimator cloudAnim = ObjectAnimator.ofFloat(findViewById(R.id.cloud1), "x", -350);
        cloudAnim.setDuration(3000);
        cloudAnim.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim.start();

        ObjectAnimator cloudAnim1 = ObjectAnimator.ofFloat(findViewById(R.id.cloud2), "x", 300);
        cloudAnim1.setDuration(3000);
        cloudAnim1.setRepeatCount(ValueAnimator.INFINITE);
        cloudAnim1.setRepeatMode(ValueAnimator.REVERSE);
        cloudAnim1.start();

    }
}
