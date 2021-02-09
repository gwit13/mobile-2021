package com.example.texttossing;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    Button confirm;
    TextView name;
    TextView graduatingClass;
    TextView favoriteMonkey;
    TextView[] views = new TextView[3];
    EditText input;
    String temp;
    int field;
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        confirm = findViewById(R.id.confirm_button);
        name = findViewById(R.id.display);
        graduatingClass = findViewById(R.id.graduatingclass);
        favoriteMonkey = findViewById(R.id.favoritemonkey);
        input = findViewById(R.id.text_input_1);
        views[0] = name;
        views[1] = graduatingClass;
        views[2] = favoriteMonkey;
        field = 0;
        color = name.getTextColors().getDefaultColor();
        name.setTextColor(Color.RED);
    }

    public void nameConfirm(View view) {
        temp = input.getText().toString();
        if(temp.length() > 0) {
            input.setText("");
            views[field].setText("" + temp);
            views[field].setTextColor(color);
            field = (++field)%3;
            views[field].setTextColor(Color.RED);
        }
    }
}