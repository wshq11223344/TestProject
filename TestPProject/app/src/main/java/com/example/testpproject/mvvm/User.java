package com.example.testpproject.mvvm;

import android.widget.ImageView;

import androidx.databinding.BaseObservable;
import androidx.databinding.Bindable;
import androidx.databinding.BindingAdapter;

import com.bumptech.glide.Glide;
import com.example.testpproject.BR;

public class User extends BaseObservable {

    private String name;
    private String password;

    private String header;

    public User(String name, String password, String header) {
        this.name = name;
        this.password = password;
        this.header = header;
    }

    @Bindable
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        notifyPropertyChanged(BR.name);
    }

    @Bindable
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
        notifyPropertyChanged(BR.password);
    }

    @Bindable
    public String getHeader() {
        return header;
    }

    public void setHeader(String header) {
        this.header = header;
        notifyPropertyChanged(BR.header);
    }


    //自定义属性：提供一个静态方法来加载image
    @BindingAdapter({"bind:header"})
    public static void loadImage(ImageView imageView, String url) {

        Glide.with(imageView.getContext()).load(url).into(imageView);

    }
}
