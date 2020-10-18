package com.example.testpproject.screenmatch;

import android.content.Context;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ConstraintActivity extends AppCompatActivity {
//    @BindView(R.id.cancel_tv)
//    TextView cancelTv;


//    @BindView(R.id.bt1)
//    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog_cancel_or_ok);
        setContentView(R.layout.activity_constraint);
        ButterKnife.bind(this);

        printResolution(this);

//        cancelTv.postDelayed(() -> {
//
//            cancelTv.performClick();
//        }, 3000);


    }


    public void printResolution(Context context) {
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        int height = dm.heightPixels;
        int width = dm.widthPixels;
        int sw = context.getResources().getConfiguration().smallestScreenWidthDp;
        Log.e("=========", "屏幕分辨率:" + width + "*" + height + ",dpi:" + dm.densityDpi + ",sw:" + sw);
    }

//    @OnClick(R.id.cancel_tv)
//    public void onViewClicked() {
//
//        Toast.makeText(this, "你牛逼", Toast.LENGTH_SHORT).show();
//
//    }


//    @OnClick(R.id.bt1)
//    public void onViewClicked() {
//
//        bt1.setText("haha");
//
//    }


}
