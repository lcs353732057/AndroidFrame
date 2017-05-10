package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ImageView;

import com.bumptech.glide.Glide;

import jp.wasabeef.glide.transformations.BlurTransformation;
import jp.wasabeef.glide.transformations.CropCircleTransformation;
import jp.wasabeef.glide.transformations.CropSquareTransformation;
import jp.wasabeef.glide.transformations.GrayscaleTransformation;
import jp.wasabeef.glide.transformations.RoundedCornersTransformation;


public class GlideActivity extends Activity {

    private ImageView imageView1, imageView2, imageView3, imageView4, imageView5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_glide);
        imageView1 = (ImageView) findViewById(R.id.imageView);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        imageView3 = (ImageView) findViewById(R.id.imageView3);
        imageView4 = (ImageView) findViewById(R.id.imageView4);
        imageView5 = (ImageView) findViewById(R.id.imageView5);
        //圆形处理
        Glide
                .with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .bitmapTransform(new CropCircleTransformation(this))
                .into(imageView1);
        //用原图的1/10作为缩略图，模糊处理

        Glide
                .with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .thumbnail(0.1f)
                .bitmapTransform(new BlurTransformation(this))
                .into(imageView2);

        //圆角处理
        Glide
                .with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .bitmapTransform(new RoundedCornersTransformation(this, 20, 20))
                .into(imageView3);

        //灰度处理
        Glide
                .with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .bitmapTransform(new GrayscaleTransformation(this))
                .into(imageView4);

        //截个正方形
        Glide
                .with(this)
                .load("http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png")
                .bitmapTransform(new CropSquareTransformation(this))
                .into(imageView5);
    }
}
