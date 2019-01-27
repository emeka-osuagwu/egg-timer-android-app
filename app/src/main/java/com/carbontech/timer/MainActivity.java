package com.carbontech.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timer_inout = (SeekBar) findViewById(R.id.timer_input);
        TextView timer_text_view = (TextView) findViewById(R.id.timer_test_view);

        timer_inout.setMax(600);
        timer_inout.setProgress(30);

    }
}
