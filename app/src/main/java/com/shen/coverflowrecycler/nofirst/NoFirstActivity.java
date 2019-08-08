package com.shen.coverflowrecycler.nofirst;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.jude.easyrecyclerview.EasyRecyclerView;
import com.shen.coverflowrecycler.R;
import com.shen.coverflowrecycler.view.CoverFlowLayoutManger;

/**
 * author:  shen
 * date:    2019/8/7
 */
public class NoFirstActivity extends AppCompatActivity {
    private RecyclerView mRv;
    private EasyRecyclerView mErv;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_nofirst);
        initList();
    }

    private void initList() {
        mRv = findViewById(R.id.rv_NoFirstActivity);
        mErv = findViewById(R.id.erv_NoFirstActivity);

        CoverFlowLayoutManger.Builder managerBuilder = new CoverFlowLayoutManger.Builder();
        managerBuilder.setIntervalRatio(0.1f);
        managerBuilder.setFlat(false);
        managerBuilder.setItemSpace(10);
        mRv.setLayoutManager(managerBuilder.build());
        mRv.addItemDecoration(new RVItemDecoration(LinearLayoutManager.HORIZONTAL,200));
        mRv.setAdapter(new NoFirstAdapter(this));




        CoverFlowLayoutManger.Builder managerBuilder1 = new CoverFlowLayoutManger.Builder();
        managerBuilder1.setIntervalRatio(0.1f);
        managerBuilder1.setFlat(false);
        managerBuilder1.setItemSpace(10);
        mErv.setLayoutManager(managerBuilder1.build());
        mErv.addItemDecoration(new RVItemDecoration(LinearLayoutManager.HORIZONTAL,200));
        mErv.setAdapter(new NoFirstAdapter(this));

////        mRv.setFlatFlow(true); //平面滚动
////        mRv.setGreyItem(true); //设置灰度渐变
////        mRv.setAlphaItem(true); //设置半透渐变
//        mRv.setAdapter(new Adapter(this, this));
//        mRv.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
//            @Override
//            public void onItemSelected(int position) {
//                ((TextView)findViewById(R.id.tv_index_NoFirstActivity)).setText((position+1)+"/"+ mRv.getLayoutManager().getItemCount());
//            }
//        });
    }

//    @Override
//    public void clickItem(int pos) {
//        mRv.smoothScrollToPosition(pos);
//    }




}
