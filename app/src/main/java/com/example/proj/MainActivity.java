package com.example.proj;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private View mContentView;
    private Handler mHandler = new Handler();
    private Runnable mRunnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        setTitle("SkillSurfer");

        GradientDrawable gradientDrawable = new GradientDrawable(
                GradientDrawable.Orientation.TOP_BOTTOM,
                new int[]{Color.WHITE, Color.BLUE}
        );

        getWindow().setBackgroundDrawable(gradientDrawable);

        TextView titleTextView = findViewById(R.id.title);
        titleTextView.setText("Welcome to SkillSurfer");

        mRunnable = new Runnable() {
            @Override
            public void run() {
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
            }
        };
        mHandler.postDelayed(mRunnable, 5000);

        mContentView = findViewById(android.R.id.content);

        mContentView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                mHandler.removeCallbacks(mRunnable);
                startActivity(new Intent(MainActivity.this, LoginActivity.class));
                return true;
            }
        });
    }
}
