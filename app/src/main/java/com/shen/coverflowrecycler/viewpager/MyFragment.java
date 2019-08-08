package com.shen.coverflowrecycler.viewpager;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.shen.coverflowrecycler.Adapter;
import com.shen.coverflowrecycler.R;
import com.shen.coverflowrecycler.view.CoverFlowLayoutManger;
import com.shen.coverflowrecycler.view.CoverFlowRecyclerView;

/**
 *
 * @author Chen Xiaoping (562818444@qq.com)
 * @version RecyclerCoverFlow
 * @Datetime 2017-07-26 15:11
 * @since RecyclerCoverFlow
 */

public class MyFragment extends Fragment {
    private CoverFlowRecyclerView mList;
    private TextView mIndex;


    public static Fragment newInstance() {
        MyFragment fragment = new MyFragment();
        return fragment;
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fragment, container, false);
        initList(rootView);
        return rootView;
    }

    private void initList(View rootView) {
        mList = (CoverFlowRecyclerView) rootView.findViewById(R.id.list);
        mIndex = ((TextView)rootView.findViewById(R.id.index));
//        mList.setFlatFlow(true); //平面滚动
        mList.setGreyItem(true); //设置灰度渐变
//        mList.setAlphaItem(true); //设置半透渐变
        mList.setAdapter(new Adapter(getActivity()));
        mList.setOnItemSelectedListener(new CoverFlowLayoutManger.OnSelected() {
            @Override
            public void onItemSelected(int position) {
                mIndex.setText((position+1)+"/"+mList.getLayoutManager().getItemCount());
            }
        });
    }
}
