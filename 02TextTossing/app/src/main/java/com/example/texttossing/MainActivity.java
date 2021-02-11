package com.example.texttossing;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    Resources res;
    Button confirm;
    ArrayList<String> namesMut = new ArrayList<>();
    ArrayList<String> classesMut = new ArrayList<>();
    ArrayList<String> monkeysMut = new ArrayList<>();

    TextView name;
    TextView graduatingClass;
    TextView favoriteMonkey;
    TextView[] views = new TextView[3];
    EditText input;

    String temp;
    int fieldInput;
    int presetInterator;
    int color;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        res = getResources();

        confirm = findViewById(R.id.confirm_button);
        name = findViewById(R.id.display);
        graduatingClass = findViewById(R.id.graduatingclass);
        favoriteMonkey = findViewById(R.id.favoritemonkey);
        input = findViewById(R.id.text_input_1);

        for(int i = 0; i < res.getStringArray(R.array.names).length; i++) {
            namesMut.add(res.getStringArray(R.array.names)[i]);
            classesMut.add(res.getStringArray(R.array.classes)[i]);
            monkeysMut.add(res.getStringArray(R.array.monkeys)[i]);
        }

        views[0] = name;
        views[1] = graduatingClass;
        views[2] = favoriteMonkey;
        fieldInput = 0;
        presetInterator = 0;
        color = name.getTextColors().getDefaultColor();

        name.setTextColor(Color.RED);
    }

    public void nameConfirm(View view) {
        temp = input.getText().toString();
        if(temp.length() > 0) {
            input.setText("");
            views[fieldInput].setText("" + temp);
            views[fieldInput].setTextColor(color);
            fieldInput = (++fieldInput)%3;
            views[fieldInput].setTextColor(Color.RED);
        }
    }

    public void cycleThrough(View view) {
        for(TextView t : views)
            t.setTextColor(Color.BLUE);
        views[0].setText(namesMut.get(presetInterator));
        views[1].setText(classesMut.get(presetInterator));
        views[2].setText(monkeysMut.get(presetInterator));
        presetInterator = (++presetInterator%(namesMut.size()));
    }

    public void save(View view) {
        namesMut.add(views[0].getText().toString());
        classesMut.add(views[1].getText().toString());
        monkeysMut.add(views[2].getText().toString());
    }
}