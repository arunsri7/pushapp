package com.example.pushapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

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

        //Pull to Refresh
        final SwipeRefreshLayout pullToRefresh = findViewById(R.id.pullToRefresh);
        pullToRefresh.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                int refreshedValue = 0;
                countTv.setText(String.valueOf(refreshedValue));
                pullToRefresh.setRefreshing(false);
            }
        });

        //Initialization.
        countTv = findViewById(R.id.count_tv);
        increment = findViewById(R.id.increment);

        increment.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view)
            {
                count++;//increment the count
                countTv.setText(String.valueOf(count));// view in the text
            }

        });
    }
}