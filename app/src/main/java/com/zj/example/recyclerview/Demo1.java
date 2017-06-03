package com.zj.example.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zj.example.recyclerview.adapter.RecyclerViewTestAdapter;
import com.zj.example.recyclerview.layoutmanager.FullyLinearLayoutManager;

/**
 * Created by zj on 2017/6/3.
 */

public class Demo1 extends AppCompatActivity {
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.demo1_layout);

        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerview);
        /**
         * 在scrollview嵌套recyclerview有两种方式:
         * 1.重写LinearlayoutManager
         * 2.LinearLayoutManager开启自动测量
         *
         * 但是就算这样做了也会有滑动问题 如下:
         * 如果在recyclerview中滑动,会没有惯性效果,所以还需要重写ScrollView
         *
         *  解决滑动不平滑也有两种方式:
         * 1.重写scrollview
         * 2.重写recyclerview
         *
         * 本demo是方式1
         */
        FullyLinearLayoutManager fullyLinearLayoutManager = new FullyLinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        fullyLinearLayoutManager.setSmoothScrollbarEnabled(true);
        //mRecyclerView.setLayoutManager(fullyLinearLayoutManager);//嵌套解决方案1

        //嵌套解决方案2
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        linearLayoutManager.setAutoMeasureEnabled(true);//打开自动测量才可以在scrollview中显示, 如果false就不会显示出来
        mRecyclerView.setLayoutManager(linearLayoutManager);

        mRecyclerView.postDelayed(new Runnable() {
            @Override
            public void run() {
                mRecyclerView.setAdapter(new RecyclerViewTestAdapter(Demo1.this));
            }
        }, 1000);
    }
}
