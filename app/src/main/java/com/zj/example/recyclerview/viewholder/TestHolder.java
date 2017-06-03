package com.zj.example.recyclerview.viewholder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.zj.example.recyclerview.R;

/**
 * Created by zj on 2017/6/3.
 */

public class TestHolder extends RecyclerView.ViewHolder {
    public TextView title;

    public TestHolder(View itemView) {
        super(itemView);
        title = (TextView) itemView.findViewById(R.id.title);
    }
}
