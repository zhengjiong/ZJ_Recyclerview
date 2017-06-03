package com.zj.example.recyclerview;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ListViewCompat;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;

/**
 * Created by zj on 2017年6月3日13:42:49.
 */
public class MainActivity extends AppCompatActivity {
    String[] items = {
            "demo1-ScrollView嵌套Recyclerview-解决滑动不平滑解决方案1(重写ScrollView)",
            "demo2-ScrollView嵌套Recyclerview-解决滑动不平滑解决方案2(重写RecyclerView)",
            "demo3"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListViewCompat listViewCompat = (ListViewCompat) findViewById(R.id.listview);
        listViewCompat.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, items));

        listViewCompat.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0:
                        startActivity(new Intent(MainActivity.this, Demo1.class));
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, Demo2.class));
                        break;
                }
            }
        });
    }
}
