package com.example.talku_talku;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgView;
    private static int splashTimeOut = 5000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgView = findViewById(R.id.welcome_screen);

        // splash to open another activity after the time out
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, OnboardingScreen.class);
                startActivity(intent);
                finish();
            }
        }, splashTimeOut);
        // create the animation
        Animation myAnim = AnimationUtils.loadAnimation(getApplicationContext(),R.anim.mysplashanimation);
        imgView.startAnimation(myAnim);


    }
}