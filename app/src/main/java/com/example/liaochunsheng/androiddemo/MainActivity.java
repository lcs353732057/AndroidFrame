package com.example.liaochunsheng.androiddemo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.example.liaochunsheng.androiddemo.util.Logger;

public class MainActivity extends Activity {
    Logger log = Logger.getLogger();

    private RecyclerView mRecyclerView;

    private HomeAdapter mHomeAdapter;

    private String[] datas = {"Glide", "RxJava", "RecyclerView", "Picasso", "Event", "TouchImageView", "ToolBar", "Vitamio", "ImageViewRecovery",
            "RecyclerView1", "RecyclerView2", "RecyclerView6", "RecyclerView5",};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mHomeAdapter = new HomeAdapter(datas);
        mRecyclerView.setAdapter(mHomeAdapter);
        //添加分割线
        mRecyclerView.addItemDecoration(new DividerItemDecoration(
                this, DividerItemDecoration.VERTICAL));
        mHomeAdapter.setOnRecyclerViewItemListener(new OnRecyclerViewItemListener() {
            @Override
            public void onRecyclerViewItemListener(HomeAdapter.MyViewHolder holder) {
                int pos = holder.getAdapterPosition();
                Toast.makeText(MainActivity.this, pos + "", Toast.LENGTH_SHORT).show();
                if (pos == 0) {
                    Intent intent = new Intent(MainActivity.this, GlideActivity.class);
                    startActivity(intent);
                } else if (pos == 1) {
                    Intent intent = new Intent(MainActivity.this, RxJavaActivity.class);
                    startActivity(intent);
                } else if (pos == 2) {
                    Intent intent = new Intent(MainActivity.this, RecyclerViewActivity.class);
                    startActivity(intent);
                } else if (pos == 3) {
                    Intent intent = new Intent(MainActivity.this, PicassoActivity.class);
                    startActivity(intent);
                } else if (pos == 4) {
                    Intent intent = new Intent(MainActivity.this, EventActivity.class);
                    startActivity(intent);
                } else if (pos == 5) {
                    Intent intent = new Intent(MainActivity.this, TouchImageViewActivity.class);
                    startActivity(intent);
                } else if (pos == 6) {
                    Intent intent = new Intent(MainActivity.this, ToolbarActivity.class);
                    startActivity(intent);
                } else if (pos == 7) {
                    Intent intent = new Intent(MainActivity.this, VitamioActivity.class);
                    startActivity(intent);
                } else if (pos == 8) {
                    Intent intent = new Intent(MainActivity.this, ImageViewRecoveryActivity.class);
                    startActivity(intent);
                }
            }
        });

        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.mipmap.guide_1);
        Logger.getLogger().d("======" + bitmap.getByteCount());

    }

    class HomeAdapter extends RecyclerView.Adapter<
            HomeAdapter.MyViewHolder> {
        private String[] list;

        private OnRecyclerViewItemListener onRecyclerViewItemListener;

        public HomeAdapter(String[] list) {
            this.list = list;
        }


        @Override
        public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            View view = LayoutInflater.from(
                    MainActivity.this).inflate(R.layout.textview, parent,
                    false);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (onRecyclerViewItemListener != null) {
                        MyViewHolder holder = (MyViewHolder) view.getTag();
                        onRecyclerViewItemListener.onRecyclerViewItemListener(holder);
                    }
                }
            });
            MyViewHolder holder = new MyViewHolder(view);
            view.setTag(holder);
            return holder;
        }

        @Override
        public void onBindViewHolder(MyViewHolder holder, int position) {
            holder.tv.setText(list[position]);
        }

        @Override
        public int getItemCount() {
            return list.length;
        }

        public void setOnRecyclerViewItemListener(OnRecyclerViewItemListener onRecyclerViewItemListener) {
            this.onRecyclerViewItemListener = onRecyclerViewItemListener;
        }

        class MyViewHolder extends RecyclerView.ViewHolder {
            private TextView tv;

            public MyViewHolder(View itemView) {
                super(itemView);
                tv = (TextView) itemView.findViewById(R.id.textView);
            }
        }
    }

    public interface OnRecyclerViewItemListener {
        public void onRecyclerViewItemListener(HomeAdapter.MyViewHolder holder);
    }
}
