package com.example.layoutswitchingpracticing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity6 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_6);
        Intent intent = getIntent();
    }

    public void next(View view) {
        Intent intent = new Intent(getApplicationContext(), Activity7.class);
        startActivity(intent);
    }
}