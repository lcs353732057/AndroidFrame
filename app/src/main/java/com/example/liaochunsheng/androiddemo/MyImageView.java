package com.example.liaochunsheng.androiddemo;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.liaochunsheng.androiddemo.util.Logger;

/**
 * Created by zhoumanqing on 2017/4/13.
 */

public class MyImageView extends ImageView {
    Logger log = Logger.getLogger();

    public MyImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public MyImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        log.d("the widthMeasureSpec is: " + widthMeasureSpec);
        log.d("the heightMeasureSpec is: " + heightMeasureSpec);
    }

    @Override
    protected void onLayout(boolean changed, int left, int top, int right, int bottom) {
        super.onLayout(changed, left, top, right, bottom);
        log.d("the changed is: " + changed);
        log.d("the left is: " + left);
        log.d("the top is: " + top);
        log.d("the right is: " + right);
        log.d("the bottom is: " + bottom);
    }

    @Override
    protected void onVisibilityChanged(View changedView, int visibility) {
        super.onVisibilityChanged(changedView, visibility);
        log.d("the changedView is: " + changedView);
        log.d("the visibility is: " + visibility);
    }
}
