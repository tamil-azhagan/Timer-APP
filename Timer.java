package com.example.stopwatch;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Handler;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    private TextView result;
    private Button start,stop,reset;
    private int seconds=0;
    private boolean running_state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        StartTimer();
    }
    public void StartAction(View view){
        running_state=true;
    }
    public void PauseAction(View view){
        running_state=false;
    }
    public void ResetAction(View view){
        running_state=false;
        seconds=0;
    }
    //method to start the timer
    private void StartTimer(){
        result=(TextView) findViewById(R.id.maincount);
        Handler handle= new Handler();
        handle.post(new Runnable() {
            @Override
            public void run(){
                int hrs=seconds/3600;
                int min=(seconds%3600)/60;
                int sec=seconds%60;

                String time= String.format("%02d:%02d:%02d",hrs,min,sec);
                result.setText(time);

                if(running_state){
                    seconds++;
                }
                handle.postDelayed(this,1000);
            }
        });
    }

}
