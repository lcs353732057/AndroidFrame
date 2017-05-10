package com.example.liaochunsheng.androiddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ScrollView;

import com.example.liaochunsheng.androiddemo.util.Logger;

/**
 * Created by zhoumanqing on 2017/4/13.
 */

public class MyScrollView extends ScrollView {
    Logger log = Logger.getLogger();

    public MyScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onScrollChanged(int l, int t, int oldl, int oldt) {
        super.onScrollChanged(l, t, oldl, oldt);
        log.d("the l is: " + l);
        log.d("the t is: " + l);
        log.d("the oldl is: " + oldl);
        log.d("the oldt is: " + oldt);
    }
}
