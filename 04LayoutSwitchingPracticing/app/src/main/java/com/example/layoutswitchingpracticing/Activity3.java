package com.example.layoutswitchingpracticing;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

public class Activity3 extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);
        Intent intent = getIntent();
    }

    public void next(View view) {
        Intent intent = new Intent(getApplicationContext(), Activity4.class);
        startActivity(intent);
    }
}
