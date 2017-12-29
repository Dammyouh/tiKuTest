package com.example.yangxiaoyu.tikutest;

import android.content.Context;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by YangXiaoyu on 2017/12/29.
 */

public class shouyeAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private LayoutInflater mInflater;
    private Context mContext;
    private static final int  MRYL = 1;
    private static final int  ZTJL = 2;
    private static final int  SCLX = 3;
    private static final int  XQKM = 4;

    public shouyeAdapter(Context context) {
        mInflater = LayoutInflater.from(context);
        mContext = context;
    }


    @Override
    public int getItemViewType(int position) {
            if(position == 0){
                return 1;
            }else if(position == 1){
                return 2;
            }else if(position == 2){
                return 3;
            }else {
                return 4;
            }
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        RecyclerView.ViewHolder myViewHolder = new ViewHolder1(mInflater.inflate(R.layout.activity_meiriyilian,parent, false));
        switch (viewType){
            case MRYL:
                myViewHolder = new ViewHolder1(mInflater.inflate(R.layout.activity_meiriyilian,parent, false));
                break;
            case ZTJL:
                myViewHolder = new ViewHolder2(mInflater.inflate(R.layout.cuoti_layout,parent, false));
                break;
            case SCLX:
                myViewHolder = new ViewHolder3(mInflater.inflate(R.layout.shangci_layout,parent, false));
                break;
            case XQKM:
                myViewHolder = new ViewHolder4(mInflater.inflate(R.layout.xueqikemu_layout,parent, false),mContext);
                break;
        }
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    }


    @Override
    public int getItemCount() {
        return 10;
    }


    public  static class ViewHolder4 extends RecyclerView.ViewHolder implements ClickInterface  {
        @BindView(R.id.kecheng)
        RecyclerView kecheng;
        private Context mContext;

        public ViewHolder4(View itemView,Context context) {
            super(itemView);
            mContext = context;
            ButterKnife.bind(this, itemView);
            LinearLayoutManager linearLayoutManager = new LinearLayoutManager(context);
            linearLayoutManager.setOrientation(LinearLayoutManager.HORIZONTAL);
            kecheng.setLayoutManager(linearLayoutManager);
            kecheng.setAdapter(new kechengAdapter(context,this));
        }
        @Override
        public void onItemclick(int position) {
            Toast.makeText(mContext,"You have clicked the item"+position,Toast.LENGTH_SHORT).show();
        }

    }

    public  class ViewHolder1 extends RecyclerView.ViewHolder {
        public ViewHolder1(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ViewHolder2 extends RecyclerView.ViewHolder {
        public ViewHolder2(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }

    public static class ViewHolder3 extends RecyclerView.ViewHolder {
        public ViewHolder3(View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
        }
    }
}
