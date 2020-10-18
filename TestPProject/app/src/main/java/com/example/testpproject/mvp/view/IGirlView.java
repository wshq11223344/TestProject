package com.example.testpproject.mvp.view;

import com.example.testpproject.mvp.bean.Girl;

import java.util.List;

public interface IGirlView extends IBaseView{

    void showGirlView(List<Girl> list);
}
