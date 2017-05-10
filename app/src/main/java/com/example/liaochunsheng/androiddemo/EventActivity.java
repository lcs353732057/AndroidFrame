package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;

import com.example.liaochunsheng.androiddemo.util.Logger;

public class EventActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);
        Button button = (Button) findViewById(R.id.button);
        button.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                log.d("Button onTouch....");
                return true;
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                log.d("Button onClick...");
            }
        });
    }

    Logger log = Logger.getLogger();

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        log.d("dispatchTouchEvent...."+event.getAction());
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log.d("onTouchEvent....");
        return super.onTouchEvent(event);
    }
}
