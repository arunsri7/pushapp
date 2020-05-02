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

public class MainActivity extends AppCompatActivity {

    TextView countTv;
    RelativeLayout increment;
    Button reset;
//      int count = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Initialization.
        countTv = findViewById(R.id.count_tv);
        increment = findViewById(R.id.increment_button);
        reset = findViewById(R.id.reset);

        // Getting shared prefs value using the SharedPreferences object.
        final SharedPreferences prefs = MainActivity.this.getSharedPreferences(Keys.PREFS_KEY, Context.MODE_PRIVATE);
        final int count = prefs.getInt(Keys.COUNT, 0);

        //Displaying the shared preferences value.
        countTv.setText(String.valueOf(count));

        increment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int value = prefs.getInt(Keys.COUNT, 0);

                //Incrementing the shared prefs, storing it and updating display.
                prefs.edit().putInt(Keys.COUNT, (value+1)).apply();
                int refreshedValue = prefs.getInt(Keys.COUNT, 0);
                countTv.setText(String.valueOf(refreshedValue));
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int refreshedValue = 0;
                countTv.setText(String.valueOf(refreshedValue));
                prefs.edit().putInt(Keys.COUNT, (0)).apply();
            }
        });

//        public void onClick(View view)
//        {
//            count++;//increment the count
//            TextView text=(TextView)findViewById(R.id.increment_button);// resorce location
//            text.setText(+count);// view in the text
//        }

    }
}
