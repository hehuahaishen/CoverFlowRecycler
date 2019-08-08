package com.shen.coverflowrecycler;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.shen.coverflowrecycler.nofirst.NoFirstActivity;
import com.shen.coverflowrecycler.recyclerview.RecyclerViewActivity;
import com.shen.coverflowrecycler.viewpager.ViewpagerActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onJustCoverFlowClick(View view) {
        Intent intent = new Intent(this, JustCoverFlowActivity.class);
        startActivity(intent);
    }

    public void onViewPagerClick(View view) {
        Intent intent = new Intent(this, ViewpagerActivity.class);
        startActivity(intent);
    }

    public void onRecyclerViewClick(View view) {
        Intent intent = new Intent(this, RecyclerViewActivity.class);
        startActivity(intent);
    }


    public void onNoFirstClick(View view) {
        Intent intent = new Intent(this, NoFirstActivity.class);
        startActivity(intent);
    }
}
