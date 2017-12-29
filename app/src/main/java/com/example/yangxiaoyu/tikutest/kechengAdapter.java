package com.example.yangxiaoyu.tikutest;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;


/**
 * Created by YangXiaoyu on 2017/12/28.
 */

public class kechengAdapter extends RecyclerView.Adapter<kechengAdapter.ViewHolder> {


    private LayoutInflater mInflater;
    private static Context mContext;
    private ClickInterface mclickInterface;

    public kechengAdapter(Context context,ClickInterface clickInterface) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
        mclickInterface = clickInterface;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.kecheng_layout, parent, false);
        return new ViewHolder(view,mclickInterface);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        holder.bindImple(position);

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        @BindView(R.id.tupian)
        ImageView mTupian;
        @BindView(R.id.zhishidian)
        TextView mZhishidian;
        @BindView(R.id.zuotijindu)
        TextView mZuotijindu;

        int mPosition;
        private ClickInterface mclickInterface;


        public ViewHolder(View itemView,ClickInterface clickInterface) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            mclickInterface = clickInterface;
            itemView.setOnClickListener(this);
        }

        public  void bindImple(int position) {
            mPosition = position;
            if (position % 3 == 0) {
                mTupian.setBackgroundColor(Color.RED);
                mZhishidian.setText("30");
                mZuotijindu.setText("20/100");
            } else {
                mZhishidian.setText("80");
                mZuotijindu.setText("80/100");
            }
        }

        @Override
        public void onClick(View v) {
            mclickInterface.onItemclick(mPosition);
        }
    }

}
