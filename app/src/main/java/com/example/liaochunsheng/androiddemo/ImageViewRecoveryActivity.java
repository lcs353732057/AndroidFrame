package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class ImageViewRecoveryActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view_recovery);
        ScrollView scrollView = (ScrollView) findViewById(R.id.scrollView);
    }
}
