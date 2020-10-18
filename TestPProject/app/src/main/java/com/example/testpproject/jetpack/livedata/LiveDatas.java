package com.example.testpproject.jetpack.livedata;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testpproject.R;
import com.example.testpproject.mvp.bean.Girl;

import java.util.ArrayList;
import java.util.List;

public class LiveDatas extends ViewModel {

    private MutableLiveData<List<Girl>> mutableLiveData;


    public LiveData<List<Girl>> getInstance() {

        if (mutableLiveData == null) {

            mutableLiveData = new MutableLiveData<>();

        }

        return mutableLiveData;
    }


    public void loadData() {
        List<Girl> data;
        data = new ArrayList<>();
        data.add(new Girl(R.drawable.f1, "二星", "****"));
        data.add(new Girl(R.drawable.f2, "二星", "****"));
        data.add(new Girl(R.drawable.f3, "二星", "****"));
        data.add(new Girl(R.drawable.f4, "二星", "****"));
        data.add(new Girl(R.drawable.f5, "二星", "****"));
        data.add(new Girl(R.drawable.f6, "二星", "****"));
        data.add(new Girl(R.drawable.f7, "二星", "****"));
        data.add(new Girl(R.drawable.f8, "二星", "****"));
        data.add(new Girl(R.drawable.f9, "二星", "****"));
        data.add(new Girl(R.drawable.f10, "二星", "****"));

        //把这些数据存放到容器里面
        mutableLiveData.setValue(data);

//        mutableLiveData.postValue(data);
    }


    //    //提供一个方法来改变数据
//    public void changeValue() {
//    List<Girl> value = mutableLiveData.getValue();
//        mutableLiveData.setValue(value);
//
//    }

}
