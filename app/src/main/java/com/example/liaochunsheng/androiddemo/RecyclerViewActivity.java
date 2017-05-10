package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.squareup.picasso.Picasso;

public class RecyclerViewActivity extends Activity {

    private RecyclerView mRecyclerView;

    private ImageViewAdapter mImageViewAdapter;

    private final String URL_IMAGE = "http://inthecheesefactory.com/uploads/source/nestedfragment/fragments.png";

    private final String URL_IMAGE1 = "http://pic47.nipic.com/20140904/18981839_095218870000_2.jpg";

    private String[] datas = {URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1, URL_IMAGE, URL_IMAGE1};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView1);
//        mRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
//        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL));
        mRecyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        mImageViewAdapter = new ImageViewAdapter(datas);
        mImageViewAdapter.notifyDataSetChanged();
        mRecyclerView.setAdapter(mImageViewAdapter);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.HORIZONTAL));
    }

    class ImageViewAdapter extends RecyclerView.Adapter<
            ImageViewAdapter.MyViewHolder> {
        private String[] list;

        private OnRecyclerViewItemListener onRecyclerViewItemListener;

        public ImageViewAdapter(String[] list) {
            this.list = list;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(
                    RecyclerViewActivity.this).inflate(R.layout.imageview, parent,
                    false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerViewItemListener != null) {
                        MyViewHolder holder = (MyViewHolder) view.getTag(R.id.key_tag1);
                        onRecyclerViewItemListener.onRecyclerViewItemListener(holder);
                    }
                }
            });
            MyViewHolder holder = new MyViewHolder(view);
            view.setTag(R.id.key_tag1, holder);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            Glide.with(RecyclerViewActivity.this).load(list[position]).crossFade().into(holder.iv);
//            Picasso.with(RecyclerViewActivity.this).load(list[position]).into(holder.iv);
        }

        @Override
        public int getItemCount() {
            return list.length;
        }

        public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
            this.onRecyclerViewItemListener = onRecyclerViewItemListener;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private ImageView iv;

            public MyViewHolder(View itemView) {
                super(itemView);
                iv = (ImageView) itemView.findViewById(R.id.imageView);
            }
        }
    }

    public interface OnRecyclerViewItemListener {
        public void onRecyclerViewItemListener(ImageViewAdapter.MyViewHolder holder);
    }
}
