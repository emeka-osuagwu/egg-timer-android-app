package com.carbontech.timer;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView timer_text_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        SeekBar timer_inout = (SeekBar) findViewById(R.id.timer_input);
        timer_text_view = (TextView) findViewById(R.id.timer_test_view);

        timer_inout.setMax(600);
        timer_inout.setProgress(30);

        timer_inout.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                int mins;
                int seconds;

                mins = progress / 60;
                seconds = progress - mins * 60;

                String minsString = Integer.toString(mins);
                String secondsString = Integer.toString(seconds);

                if (seconds == 0){
                    secondsString = "00";
                }

                if (mins < 10){
                    minsString = "0" + Integer.toString(mins);
                }

                timer_text_view.setText(minsString + ":" + secondsString);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });



    }
}
