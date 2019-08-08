package com.shen.coverflowrecycler;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.shen.coverflowrecycler.view.CoverFlowLayoutManger;
import com.shen.coverflowrecycler.view.CoverFlowRecyclerView;


public class JustCoverFlowActivity extends AppCompatActivity implements Adapter.onItemClick {

    private CoverFlowRecyclerView mRv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_just_coverflow);
        initList();
    }

    private void initList() {
        mRv = (CoverFlowRecyclerView) findViewById(R.id.list);
//        mRv.setFlatFlow(true); //平面滚动
//        mRv.setGreyItem(true); //设置灰度渐变
//        mRv.setAlphaItem(true); //设置半透渐变
        mRv.setAdapter(new Adapter(this, this));
        mRv.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                ((TextView)findViewById(R.id.index)).setText((position+1)+"/"+ mRv.getLayoutManager().getItemCount());
            }
        });
    }

    @Override
    public void clickItem(int pos) {
        mRv.smoothScrollToPosition(pos);
    }
}
