package com.example.activitystaterecording;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView create, start, resume, pause, stop, restart, destroy;
    int createi, starti, resumei, pausei, stopi, restarti, destroyi = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        create = findViewById(R.id.onCreateView);
        start = findViewById(R.id.onStartView);
        resume = findViewById(R.id.onResumeView);
        pause = findViewById(R.id.onPauseView);
        stop = findViewById(R.id.onStopView);
        restart = findViewById(R.id.onRestartView);
        destroy = findViewById(R.id.onDestroyView);

        create.setText("onCreate: called " + ++createi + " times.");
        start.setText("onStart: called 0 times.");
        resume.setText("onResume: called 0 times.");
        pause.setText("onPause: called 0 times.");
        stop.setText("onStop: called 0 times.");
        restart.setText("onRestart: called 0 times.");
        destroy.setText("onDestroy: called 0 times.");
    }
    @Override
    protected void onStart() {
        super.onStart();
        start.setText("onStart: called " + ++starti + " times.");
    }

    protected void onResume() {
        super.onResume();
        resume.setText("onResume: called " + ++resumei + " times.");
    }

    protected void onPause() {
        super.onPause();
        pause.setText("onPause: called " + ++pausei + " times.");
    }

    protected void onStop() {
        super.onStop();
        stop.setText("onPause: called " + ++stopi + " times.");
    }

    protected void onRestart() {
        super.onRestart();
        restart.setText("onRestart: called " + ++restarti + " times.");
    }

    protected void onDestroy() {
        super.onDestroy();
        destroy.setText("onDestroy: called " + ++destroyi + " times.");
    }
}