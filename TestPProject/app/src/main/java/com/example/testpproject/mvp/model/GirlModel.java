package com.example.testpproject.mvp.model;

import android.util.Log;

import com.example.testpproject.R;
import com.example.testpproject.mvp.bean.Girl;
import com.example.testpproject.mvp.databus.RxBus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import io.reactivex.rxjava3.functions.Function;


public class GirlModel implements IGirlModel {


    List<Girl> data = new ArrayList<>();


    @Override
    public void loadGirlData() {
        RxBus.getInstance().chainProcess((Object o) -> {
            List<Girl> data = new ArrayList<>();
            data.add(new Girl(R.drawable.f1, "一星", "****"));
            data.add(new Girl(R.drawable.f2, "一星", "****"));
            data.add(new Girl(R.drawable.f3, "一星", "****"));
            data.add(new Girl(R.drawable.f4, "一星", "****"));
            data.add(new Girl(R.drawable.f5, "一星", "****"));
            data.add(new Girl(R.drawable.f6, "一星", "****"));
            data.add(new Girl(R.drawable.f7, "一星", "****"));
            data.add(new Girl(R.drawable.f8, "一星", "****"));
            data.add(new Girl(R.drawable.f9, "一星", "****"));
            data.add(new Girl(R.drawable.f10, "一星", "****"));
            return data;
        });
    }


//    @Override
//    public void loadGirlData(OnloadListener onloadListener) {
//
//        data.add(new Girl(R.drawable.f1, "一星", "****"));
//        data.add(new Girl(R.drawable.f2, "一星", "****"));
//        data.add(new Girl(R.drawable.f3, "一星", "****"));
//        data.add(new Girl(R.drawable.f4, "一星", "****"));
//        data.add(new Girl(R.drawable.f5, "一星", "****"));
//        data.add(new Girl(R.drawable.f6, "一星", "****"));
//        data.add(new Girl(R.drawable.f7, "一星", "****"));
//        data.add(new Girl(R.drawable.f8, "一星", "****"));
//        data.add(new Girl(R.drawable.f9, "一星", "****"));
//        data.add(new Girl(R.drawable.f10, "一星", "****"));
//
//        onloadListener.complete(data);
//
//
//
//
//    }
}
