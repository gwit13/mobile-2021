package com.example.buttonpresses;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView text;
    int i;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.button1);
        text = findViewById(R.id.text1);
        i = 0;

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick (View v) {
                Log.i("clickResponse", "Hi Mr. Tra!");
                System.out.println("Hey! Hope you're having a good day!");
                text.setText("Button pressed " + (++i) + " times!");
            }
        });
    }

    public void decrement(View view) {
        text.setText("Button pressed " + (--i) + " times!");
    }

    public void colorer(View view) {
        text.setTextColor(Color.RED);
    }
}