package com.carbontech.timer;

import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.util.Log;
import  android.view.View;

public class MainActivity extends AppCompatActivity {

    TextView timer_text_view;
    SeekBar timer_inout;

    public void timerController(View view) {

        new CountDownTimer(timer_inout.getProgress() * 1000 + 100, 1000) {

            @Override
            public void onTick(long millisUntilFinished) {
                Log.i("timer", Long.toString(millisUntilFinished));
                updateTimer((int) millisUntilFinished / 1000);
            }

            @Override
            public void onFinish() {
                timer_text_view.setText("00:00");
                Log.i("timer", "done");
            }

        }.start();

    }

    public void updateTimer(int progress) {

        int mins;
        int seconds;

        mins = progress / 60;
        seconds = progress - mins * 60;

        String minsString = Integer.toString(mins);
        String secondsString = Integer.toString(seconds);

        if (seconds == 0){
            secondsString = "00";
        }

        if (seconds < 10) secondsString = "0" + Integer.toString(seconds);

        if (mins < 10) minsString = "0" + Integer.toString(mins);

        timer_text_view.setText(minsString + ":" + secondsString);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer_inout = (SeekBar) findViewById(R.id.timer_input);
        timer_text_view = (TextView) findViewById(R.id.timer_test_view);

        timer_inout.setMax(600);
        timer_inout.setProgress(30);

        timer_inout.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                updateTimer(progress);
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
