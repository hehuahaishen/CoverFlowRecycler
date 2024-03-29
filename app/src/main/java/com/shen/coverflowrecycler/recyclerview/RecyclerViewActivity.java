package com.shen.coverflowrecycler.recyclerview;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.shen.coverflowrecycler.R;

/**
 * 嵌套RecyclerView Demo
 *
 */
public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView mList;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recyclerview);
        initList();
    }

    private void initList() {
        mList = (RecyclerView) findViewById(R.id.list);
        mList.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        mList.setAdapter(new ListAdapter());
    }
}
