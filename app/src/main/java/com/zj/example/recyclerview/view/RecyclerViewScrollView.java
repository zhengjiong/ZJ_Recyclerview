package com.zj.example.recyclerview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.widget.ScrollView;

/**
 * Created by zj on 2017/6/3.
 */

public class RecyclerViewScrollView extends ScrollView {
    public RecyclerViewScrollView(Context context) {
        super(context);
    }

    public RecyclerViewScrollView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RecyclerViewScrollView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    public boolean onInterceptTouchEvent(MotionEvent ev) {
        //android5.0以上的事件直接传递给了内层的recyclerview,所以我们把滑动事件拦截就可以了
        if (ev.getAction() == MotionEvent.ACTION_MOVE) {
            return true;
        }
        return super.onInterceptTouchEvent(ev);
    }
}
