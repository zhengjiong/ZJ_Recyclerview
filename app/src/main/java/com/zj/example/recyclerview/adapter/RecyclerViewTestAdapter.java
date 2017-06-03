package com.zj.example.recyclerview.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.zj.example.recyclerview.R;
import com.zj.example.recyclerview.viewholder.TestHolder;

/**
 * Created by zj on 2017/6/3.
 */

public class RecyclerViewTestAdapter extends RecyclerView.Adapter<TestHolder> {
    Context context;
    LayoutInflater inflater;
    public RecyclerViewTestAdapter(Context context){
        inflater = LayoutInflater.from(context);
        this.context = context;
    }
    @Override
    public TestHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return new TestHolder(inflater.inflate(R.layout.item_simple_layout, parent, false));
    }

    @Override
    public void onBindViewHolder(final TestHolder holder, int position) {
        holder.title.setText("title-"+position);
        ((View) holder.title.getParent()).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(context, holder.getAdapterPosition()+"", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return 10;
    }
}
