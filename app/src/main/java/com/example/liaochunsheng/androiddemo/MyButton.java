package com.example.liaochunsheng.androiddemo;

import android.content.Context;
import android.os.Looper;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.Button;

import com.example.liaochunsheng.androiddemo.util.Logger;

/**
 * Created by zhoumanqing on 2017/3/22.
 */

public class MyButton extends Button {
    Logger log = Logger.getLogger();

    public MyButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        log.d("dispatchTouchEvent....");
        return false;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log.d("onTouchEvent....");
        return super.onTouchEvent(event);
    }
}
