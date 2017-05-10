package com.example.liaochunsheng.androiddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.LinearLayout;

import com.example.liaochunsheng.androiddemo.util.Logger;

/**
 * Created by zhoumanqing on 2017/3/22.
 */

public class MyLinearLayout extends LinearLayout {
    public MyLinearLayout(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public MyLinearLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    Logger log = Logger.getLogger();

    @Override
    public boolean dispatchTouchEvent(MotionEvent event) {
        log.e("dispatchTouchEvent....");
        return super.dispatchTouchEvent(event);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        log.e("onInterceptTouchEvent....");
        return super.onInterceptTouchEvent(ev);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        log.e("onTouchEvent....");
        return super.onTouchEvent(event);
    }
}
