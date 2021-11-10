package com.c.countdowntimer;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    Timer timer;
    int i=0;

    Handler handler = new Handler();
    Runnable runnable;
    int delay = 15000;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        timer=new Timer();
        timer.schedule(new TimerTask() {
            @Override
            public void run() {
                Log.d("jay", "run: "+i++);

            }
        },0,1000);


    }


    @Override
    protected void onResume() {
        handler.postDelayed(runnable = new Runnable() {
            public void run() {
                handler.postDelayed(runnable, delay);
                Toast.makeText(MainActivity.this, "This method is run every 15 seconds",
                        Toast.LENGTH_SHORT).show();
            }
        }, delay);
        super.onResume();
    }
    @Override
    protected void onPause() {
        super.onPause();
        handler.removeCallbacks(runnable); //stop handler when activity not visible super.onPause();
    }

//    @Override
//    protected void onPause() {
//        super.onPause();
//        if(timer!=null){
//            timer.cancel();
//        }
//    }

}