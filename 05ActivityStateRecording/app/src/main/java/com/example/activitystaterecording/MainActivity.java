package com.example.activitystaterecording;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView create, start, resume, pause, stop, restart, destroy;
    int createi, starti, resumei, pausei, stopi, restarti, destroyi = 0;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

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

        sharedPreferences = getSharedPreferences("Counters", MODE_PRIVATE);
        editor = sharedPreferences.edit();

        if(sharedPreferences.contains("create"))
            editor.putInt("create", (sharedPreferences.getInt("create", 0)) + 1);
        else
            editor.putInt("create", 1);

        editor.apply();
        createi++;
        print();
    }
    @Override
    protected void onStart() {
        super.onStart();
        starti++;
        editor.putInt("start", (sharedPreferences.getInt("start", 0)) + 1);
        editor.apply();
        print();
    }

    protected void onResume() {
        super.onResume();
        resumei++;
        editor.putInt("resume", (sharedPreferences.getInt("resume", 0)) + 1);
        editor.apply();
        print();
    }

    protected void onPause() {
        super.onPause();
        pausei++;
        editor.putInt("pause", (sharedPreferences.getInt("pause", 0)) + 1);
        editor.apply();
        print();
    }

    protected void onStop() {
        super.onStop();
        stopi++;
        editor.putInt("stop", (sharedPreferences.getInt("stop", 0)) + 1);
        editor.apply();
        print();
    }

    protected void onRestart() {
        super.onRestart();
        restarti++;
        editor.putInt("restart", (sharedPreferences.getInt("restart", 0)) + 1);
        editor.apply();
        print();
    }

    protected void onDestroy() {
        super.onDestroy();
        destroyi++;
        editor.putInt("destroy", (sharedPreferences.getInt("destroy", 0)) + 1);
        editor.apply();
        print();
    }

    private void print() {
        create.setText("onCreate: called " + createi + " times session, " + sharedPreferences.getInt("create", 0) + " total.");
        start.setText("onStart: called " + starti + " times session, " + sharedPreferences.getInt("start", 0) + " total.");
        resume.setText("onResume: called " + resumei + " times session, " + sharedPreferences.getInt("resume", 0) + " total.");
        pause.setText("onPause: called " + pausei + " times session, " + sharedPreferences.getInt("pause", 0) + " total.");
        stop.setText("onStop: called " + stopi + " times session, " + sharedPreferences.getInt("stop", 0) + " total.");
        restart.setText("onRestart: called " + restarti + " times session, " + sharedPreferences.getInt("restart", 0) + " total.");
        destroy.setText("onDestroy: called " + destroyi + " times session, " + sharedPreferences.getInt("destroy", 0) + " total.");
    }
}