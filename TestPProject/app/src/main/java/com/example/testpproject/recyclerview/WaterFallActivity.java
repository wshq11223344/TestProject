package com.example.testpproject.recyclerview;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;


import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.testpproject.R;

import java.util.ArrayList;
import java.util.List;

public class WaterFallActivity extends AppCompatActivity implements DeliciousFoodAdapter.OnItemClickListener {
    RecyclerView mRecyclerView;
    // 集合数据填充recyclerview
    private List<DeliciousFoodModel> mDeliciousFoodList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_water);

        mRecyclerView = (RecyclerView) findViewById(R.id.forum_list);
        // 设置layoutManager

        // 2代表列数， StaggeredGridLayoutManager.VERTICAL代表垂直分布
        mRecyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        // 设置item之间的间隔， 6代表间隔大小
        SpacesItemDecoration decoration = new SpacesItemDecoration(6);
        mRecyclerView.addItemDecoration(decoration);

        // 设置数据
        initData();

        DeliciousFoodAdapter adapter = new DeliciousFoodAdapter(this, mDeliciousFoodList);


        adapter.setOnItemClistListener(this);

        RecyclerView.RecycledViewPool recycledViewPool = new RecyclerView.RecycledViewPool();

        recycledViewPool.setMaxRecycledViews(0, 50);

        mRecyclerView.setRecycledViewPool(recycledViewPool);


        mRecyclerView.setAdapter(adapter);


    }

    private void initData() {
        mDeliciousFoodList = new ArrayList<DeliciousFoodModel>();
        for (int i = 0; i < 500; i++) {
            DeliciousFoodModel delicious = new DeliciousFoodModel();
            delicious.foodName = "螺蛳粉" + i;
            delicious.foodDesc = "螺蛳粉是广西柳州特产！";
            if (i % 5 == 0) {
                delicious.foodImg = "http://imglife.gmw.cn/attachement/jpg/site2/20160906/c03fd543e6d419383c7203.jpg";
            } else if (i % 5 == 1) {
                delicious.foodImg = "http://img3.imgtn.bdimg.com/it/u=3576404707,510258566&fm=21&gp=0.jpg";
            } else if (i % 5 == 2) {
                delicious.foodImg = "http://www.people.com.cn/mediafile/pic/20160907/11/15223011696871426367.jpg";
            } else if (i % 5 == 3) {
                delicious.foodImg = "http://img5.duitang.com/uploads/item/201307/30/20130730150022_R42zK.jpeg";
            } else {
                delicious.foodImg = "http://www.people.com.cn/mediafile/pic/20160719/2/3012656097247174570.jpg";
            }
            mDeliciousFoodList.add(delicious);
        }
    }

    @Override
    public void onItemClick(int postion) {

        Log.e("DeliciousFoodVH", "onItemClick = " + postion);

        int viewCount = mRecyclerView.getRecycledViewPool().getRecycledViewCount(0);

        Log.e("======", viewCount + "");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();

        Handler handler;
    }
}
