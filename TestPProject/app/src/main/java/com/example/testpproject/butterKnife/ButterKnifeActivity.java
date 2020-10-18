package com.example.testpproject.butterKnife;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.testpproject.R;

import butterknife.BindArray;
import butterknife.BindBitmap;
import butterknife.BindColor;
import butterknife.BindString;
import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ButterKnifeActivity extends AppCompatActivity {


    @BindView(R.id.txt_1)
    TextView mText;

    @BindString(R.string.app_name)
    String str;

    @BindArray(R.array.city)
    public String[] strs;

    @BindBitmap(R.mipmap.ic_banner_start)
    public Bitmap bitmap;

    @BindColor(R.color.colorAccent)
    int color;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_butter_knife);

        ButterKnife.bind(this);
//        LayoutInflater.from(this).inflate();

        mText.setTextColor(color);

    }

    @OnClick({R.id.txt_1, R.id.txt_2, R.id.txt_3})
    public void onClick(TextView view) {

        switch (view.getId()) {

            case R.id.txt_1:


                view.setText("456");

                break;
            case R.id.txt_2:


                view.setText("789");

                break;
        }

    }
}
