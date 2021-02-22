package com.example.preferencesharingtoasting;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    final int toastDuration = Toast.LENGTH_SHORT;
    Toast toast;
    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    TextView green, red, yellow, blue, temp;
    SeekBar seekBar;
    int maxSeek;
    int id;
    String name;
    Context context;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        context = getApplicationContext();
        sharedPreferences = getSharedPreferences("Counters", MODE_PRIVATE);
        editor = sharedPreferences.edit();
        seekBar = findViewById(R.id.seekBar);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                green.setTextSize(progress);
                red.setTextSize(progress);
                yellow.setTextSize(progress);
                blue.setTextSize(progress);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
        maxSeek = seekBar.getMax();
        green = findViewById(R.id.view1);
        red = findViewById(R.id.view2);
        yellow = findViewById(R.id.view3);
        blue = findViewById(R.id.view4);
        green.setOnClickListener(this);
        red.setOnClickListener(this);
        yellow.setOnClickListener(this);
        blue.setOnClickListener(this);
        replaceValues();
    }

    public void onClick(View v) {
        temp = (TextView)v;
        temp.setText("" + (Integer.parseInt((String) temp.getText()) + 1));
        id = temp.getId();
        switch(id){
            case R.id.view1: name = "Green Tile";
            break;
            case R.id.view2: name = "Red Tile";
            break;
            case R.id.view3: name = "Yellow Tile";
            break;
            case R.id.view4: name = "Blue Tile";
            break;
            default: name = "Undefined";
            break;
        }
        toast = Toast.makeText(context, (name+ ": " + temp.getText() + " clicks"), toastDuration);
        toast.show();
        updateValues();
    }

    private void updateValues() {
        editor.putInt("green", Integer.parseInt((String) green.getText()));
        editor.putInt("red", Integer.parseInt((String) red.getText()));
        editor.putInt("yellow", Integer.parseInt((String) yellow.getText()));
        editor.putInt("blue", Integer.parseInt((String) blue.getText()));
        editor.apply();
    }

    private void replaceValues() {
        green.setText("" + sharedPreferences.getInt("green", 0));
        red.setText("" + sharedPreferences.getInt("red", 0));
        yellow.setText("" + sharedPreferences.getInt("yellow", 0));
        blue.setText("" + sharedPreferences.getInt("blue", 0));
    }
}