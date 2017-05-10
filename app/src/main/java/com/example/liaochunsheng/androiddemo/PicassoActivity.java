package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.nostra13.universalimageloader.core.DisplayImageOptions;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.squareup.picasso.Picasso;

public class PicassoActivity extends Activity {
    private final String URL_IMAGE = "http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png";

    private final String URL_IMAGE1 = "http://pic47.nipic.com/20140904/18981839_095218870000_2.jpg";

    private String[] datas = {URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1};

    private GridView mGridView;

    private DisplayImageOptions options=new DisplayImageOptions.Builder().cacheOnDisk(true).cacheInMemory(true).build();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_picasso);
        mGridView = (GridView) findViewById(R.id.gridView);
        mGridView.setAdapter(new ImageAdapter());
    }

    class ImageAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return datas.length;
        }

        @Override
        public Object getItem(int i) {
            return datas[i];
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            Holder holder;
            if (view == null) {
                holder = new Holder();
                view = LayoutInflater.from(PicassoActivity.this).inflate(R.layout.imageview, null);
                holder.imageView= (ImageView) view.findViewById(R.id.imageView);
                view.setTag(R.id.key_tag2, holder);
            } else {
                holder = (Holder) view.getTag(R.id.key_tag2);
            }
            Glide.with(PicassoActivity.this).load(datas[i]).crossFade().into(holder.imageView);
//            Picasso.with(PicassoActivity.this).load(datas[i]).into(holder.imageView);
//            ImageLoader.getInstance().displayImage(datas[i],holder.imageView,options);
            return view;
        }

        class Holder {
            ImageView imageView;
        }
    }
}
