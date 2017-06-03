package com.zj.example.recyclerview.view;

import android.content.Context;
import android.support.annotation.Nullable;
import android.support.v7.widget.RecyclerView;
import android.util.AttributeSet;
import android.view.MotionEvent;

/**
 * Created by zj on 2017/6/3.
 */

public class ScrollViewRecyclerView extends RecyclerView {
    public ScrollViewRecyclerView(Context context) {
        super(context);
    }

    public ScrollViewRecyclerView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public ScrollViewRecyclerView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent e) {

        /**
         * 经过测试发现RecyclerView的onInterceptTouchEvent方法
         * 在move的时候会返回true, 代表会拦截move事件,所以move的时候
         * 外层的ScrollView不能响应move,造成滑动不流畅,所以在move的时候
         * 返回false, 让外层scrollview来处理move事件 log如下:
         * 06-03 08:07:03.779  onInterceptTouchEvent ACTION_DOWN =false
         * 06-03 08:07:03.802  onInterceptTouchEvent ACTION_MOVE =false
         * 06-03 08:07:03.819  onInterceptTouchEvent ACTION_MOVE =false
         * 06-03 08:07:03.835  onInterceptTouchEvent ACTION_MOVE =true
         */

        /*boolean intercept = super.onInterceptTouchEvent(e);
        if (e.getAction() == MotionEvent.ACTION_MOVE) {
            System.out.println("onInterceptTouchEvent ACTION_MOVE =" + intercept);
        } else if (e.getAction() == MotionEvent.ACTION_DOWN) {
            System.out.println("onInterceptTouchEvent ACTION_DOWN =" + intercept);
        } else if (e.getAction() == MotionEvent.ACTION_UP) {
            System.out.println("onInterceptTouchEvent ACTION_UP =" + intercept);
        }*/

        /*if (e.getAction() == MotionEvent.ACTION_MOVE) {
            return false;
        }*/

        return false;
    }
}
