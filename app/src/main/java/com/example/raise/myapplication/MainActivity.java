package com.example.raise.myapplication;

import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.LinearInterpolator;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
scoreView mScoreView;
Button submit;
EditText input;
String inputText;
    ValueAnimator valueAnimator;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        valueAnimator = ValueAnimator.ofInt(0);
        mScoreView = findViewById(R.id.scoreView);
        submit = (Button) findViewById(R.id.submit);
        input = (EditText) findViewById(R.id.input);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String inputText = input.getText().toString().trim();
              int inputContent =  Integer.parseInt(inputText);
               startAnimation(inputContent);
            }
        });

    }
    public void startAnimation(int score){
        if (valueAnimator.isRunning()){

            valueAnimator.cancel();

        }
        valueAnimator.setIntValues(0,score);
        valueAnimator.setDuration(4000);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {

                mScoreView.setCurrentScore((int)valueAnimator.getAnimatedValue());

            }
        });
        valueAnimator.start();

    }

}
