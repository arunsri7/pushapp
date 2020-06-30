package com.example.pushapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView countTv;
    RelativeLayout increment;
    Button reset;
    int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization.
        countTv = findViewById(R.id.count_tv);
        increment = findViewById(R.id.increment);
        reset = findViewById(R.id.reset);

        increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                count++;//increment the count
                countTv.setText(String.valueOf(count));// view in the text
            }

        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int refreshedValue = 0;
                countTv.setText(String.valueOf(refreshedValue));
            }
        });
    }
}