package com.example.liaochunsheng.androiddemo;

import android.app.Application;
import android.content.Context;

import com.nostra13.universalimageloader.cache.disc.naming.HashCodeFileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.LruMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;

/**
 * Created by zhoumanqing on 2017/3/10.
 */

public class App extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        initImageLoader(this);
    }

    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);
    }


    private void initImageLoader(Context context) {
        // This configuration tuning is custom. You can tune every option, you
        // may tune some of them,
        // or you can create default configuration by
        // ImageLoaderConfiguration.createDefault(this);
        // method.
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(context).threadPoolSize(3)
                .threadPriority(Thread.NORM_PRIORITY - 2).diskCacheFileNameGenerator(new HashCodeFileNameGenerator())
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // .writeDebugLogs()
                // common

                // .memoryCache(new CustomeMemoryCache(5*1024*1024))
                .memoryCache(new LruMemoryCache(50 * 1024 * 1024)).memoryCacheSize(50 * 1024 * 1024)
                // default
                .diskCacheSize(300 * 1024 * 1024).diskCacheFileCount(1000).build();

        // ImageLoaderConfiguration config = new
        // ImageLoaderConfiguration.Builder(context)
        // .threadPriority(Thread.NORM_PRIORITY - 2)
        // .denyCacheImageMultipleSizesInMemory()
        // .diskCacheFileNameGenerator(new Md5FileNameGenerator())
        // .diskCacheSize(50 * 1024 * 1024) // 50 Mb
        // .tasksProcessingOrder(QueueProcessingType.LIFO)
        // .writeDebugLogs() // Remove for release app
        // .build();

        // Initialize ImageLoader with configuration.
        ImageLoader.getInstance().init(config);
    }
}
