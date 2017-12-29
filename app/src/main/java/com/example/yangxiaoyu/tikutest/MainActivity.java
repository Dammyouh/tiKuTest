package com.example.yangxiaoyu.tikutest;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements ClickInterface {

//    @BindView(R.id.xueqiliebiao)
//    RecyclerView xueqiliebiao;
    @BindView(R.id.shouye)
    RecyclerView shouye;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        mContext = this;

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(mContext);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
//        xueqiliebiao.setLayoutManager(linearLayoutManager);
//        xueqiliebiao.setAdapter(new shouyeAdapter(mContext));

        shouye.setLayoutManager(linearLayoutManager);
        shouye.setAdapter(new shouyeAdapter(mContext));

    }

    @Override
    public void onItemclick(int position) {
        Toast.makeText(this, "You have clicked the item" + position, Toast.LENGTH_SHORT).show();
    }

}
