package com.example.testpproject.mvp;

import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.mvp.presenter.BasePresenter;
import com.example.testpproject.mvp.view.IBaseView;
import com.example.testpproject.mvp.view.IGirlView;

import java.util.List;

public abstract class BaseActivity<T extends BasePresenter, V extends IBaseView> extends AppCompatActivity {


    //    表示层
//    protected T presenter;

    protected List<T> listPresenters;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


//        presenter = createPresenter();

        listPresenters = createPresenters();

        init();
        for (int i = 0; i < listPresenters.size(); i++) {
            listPresenters.get(i).attachView((V) this);
        }
        System.out.println(this);

//        presenter.attachView((V) this);

        registerSDK();


    }

    protected abstract void init();

    protected abstract List<T> createPresenters();

    public abstract T createPresenter();

    protected abstract void unRegisterSDK();

    protected abstract void registerSDK();

    @Override
    protected void onDestroy() {
        super.onDestroy();

//        presenter.detachView();

        for (int i = 0; i < listPresenters.size(); i++) {
            listPresenters.get(i).detachView();

        }

        unRegisterSDK();
    }
}
