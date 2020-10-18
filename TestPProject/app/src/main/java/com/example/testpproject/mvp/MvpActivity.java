package com.example.testpproject.mvp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ListView;

import com.example.testpproject.R;
import com.example.testpproject.mvp.adapter.GirlAdapter;
import com.example.testpproject.mvp.bean.Girl;
import com.example.testpproject.mvp.databus.RxBus;
import com.example.testpproject.mvp.presenter.BasePresenter;
import com.example.testpproject.mvp.presenter.GirlPresenter;
import com.example.testpproject.mvp.view.IBaseView;
import com.example.testpproject.mvp.view.IGirlView;

import java.util.ArrayList;
import java.util.List;

public class MvpActivity extends BaseActivity<GirlPresenter<IGirlView>, IGirlView> implements IGirlView {


    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        System.out.println("子类");
        setContentView(R.layout.activity_mvp);

        listView = (ListView) findViewById(R.id.listview);

//        获取表示层数据
//        presenter.fetch();

    }

    @Override
    protected void init() {
        getLifecycle().addObserver(listPresenters.get(0));
    }

    @Override
    protected List createPresenters() {

        List list = new ArrayList<>();

        list.add(new GirlPresenter<IGirlView>());

        return list;
    }


    // 绑定表示层
    @Override
    public GirlPresenter<IGirlView> createPresenter() {
        return new GirlPresenter<>();
    }

    @Override
    protected void unRegisterSDK() {

        RxBus.getInstance().unRegister(listPresenters.get(0));
    }

    @Override
    protected void registerSDK() {

        RxBus.getInstance().register(listPresenters.get(0));

    }


    @Override
    public void showGirlView(List<Girl> list) {
        //表示层就会把数据填到girls上
        listView.setAdapter(new GirlAdapter(this, list));
    }

    @Override
    public void showErrorMessage(String msg) {

    }
}
