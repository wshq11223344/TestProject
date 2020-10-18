package com.example.testpproject.mvp.presenter;

import android.util.Log;

import androidx.lifecycle.Lifecycle;
import androidx.lifecycle.OnLifecycleEvent;

import com.example.testpproject.mvp.bean.Girl;
import com.example.testpproject.mvp.databus.RegisterRxBus;
import com.example.testpproject.mvp.model.GirlModel;
import com.example.testpproject.mvp.model.IGirlModel;
import com.example.testpproject.mvp.view.IBaseView;
import com.example.testpproject.mvp.view.IGirlView;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class GirlPresenter<T extends IGirlView> extends BasePresenter<T> {

    //    持有view层引用
//    IGirlView iGirlView;

    //    持有model层引用
    IGirlModel iGirlModel = new GirlModel();

//    //    持有view的弱引用
//    WeakReference<T> iGirlView;

//    public GirlPresenter(T iGirlView) {
////        this.iGirlView = iGirlView;
//        this.iGirlView = new WeakReference<T>(iGirlView);
//    }

//    public void attachView(T view) {
//
//        this.iGirlView = new WeakReference<T>(view);
//    }
//
//    public void detachView() {
//
//        if (iGirlView != null) {
//            iGirlView.clear();
//            iGirlView = null;
//        }
//
//    }


    public GirlPresenter() {
        iGirlModel.loadGirlData();

    }


    @Override
    public void setOnStartListener() {
        super.setOnStartListener();
        Log.e("====", "start");
    }


    @Override
    public void setOnStopListener() {
//        super.setOnStopListener();
        Log.e("====", "stop");

    }

    @RegisterRxBus("")
    public void getShowGirlsData(ArrayList<Girl> girls) {
        iBaseView.get().showGirlView(girls);
    }


//    public void fetch() {
//
//        if (iGirlView.get() != null && iGirlModel != null) {
//
//            iGirlModel.loadGirlData(new IGirlModel.OnloadListener() {
//                @Override
//                public void complete(List<Girl> girls) {
//                    //girl上面就是model来的数据
//                    iGirlView.get().showGirlView(girls);
//
//                }
//            });
//
//        }
//
//
//    }
}
