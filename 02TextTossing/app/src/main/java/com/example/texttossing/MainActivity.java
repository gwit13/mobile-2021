package com.example.texttossing;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button confirm;
    TextView display;
    EditText input;
    String temp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        confirm = findViewById(R.id.confirm_button);
        display = findViewById(R.id.display);
        input = findViewById(R.id.text_input_1);
    }

    public void nameConfirm(View view) {
        temp = input.getText().toString();
        if(temp.length() > 0) {
            input.setText("");
            display.setText("Hello, " + temp + " !");
        }
    }
}