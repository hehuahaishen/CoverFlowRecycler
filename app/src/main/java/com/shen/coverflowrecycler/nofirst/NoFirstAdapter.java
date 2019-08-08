package com.shen.coverflowrecycler.nofirst;

import android.app.Activity;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.shen.coverflowrecycler.R;

/**
 * Created by chenxiaoping on 2017/3/28.
 */
public class NoFirstAdapter extends RecyclerView.Adapter<NoFirstAdapter.ViewHolder> {

    private Context mContext;
    private int[] mColors = {R.mipmap.item1,R.mipmap.item2,R.mipmap.item3,R.mipmap.item4,
            R.mipmap.item5,R.mipmap.item6};

    private onItemClick clickCb;

    public NoFirstAdapter(Context c) {
        mContext = c;
    }

    public NoFirstAdapter(Context c, onItemClick cb) {
        mContext = c;
        clickCb = cb;
    }

    public void setOnClickLstn(onItemClick cb) {
        this.clickCb = cb;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.layout_item, parent, false);

        final int width = ((Activity) mContext).getWindowManager().getDefaultDisplay().getWidth();
        ViewGroup.LayoutParams layoutParams = v.getLayoutParams();
        layoutParams.width = (int) (width * 0.33);
        v.setLayoutParams(layoutParams);

        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, final int position) {
        Glide.with(mContext).load(mColors[position % mColors.length]).into(holder.img);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(mContext, "点击了："+position, Toast.LENGTH_SHORT).show();
                if (clickCb != null) {
                    clickCb.clickItem(position);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return 12;
        //return Integer.MAX_VALUE;
    }


    class ViewHolder extends RecyclerView.ViewHolder {
        ImageView img;
        public ViewHolder(View itemView) {
            super(itemView);
            img = (ImageView) itemView.findViewById(R.id.img);
        }
    }

    interface onItemClick {
        void clickItem(int pos);
    }
}
