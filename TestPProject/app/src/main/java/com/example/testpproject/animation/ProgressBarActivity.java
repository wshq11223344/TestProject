package com.example.testpproject.animation;

import android.app.ProgressDialog;
import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class ProgressBarActivity extends AppCompatActivity {


    @BindView(R.id.tv_test)
    TextView tvTest;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //请求窗口特色风格，这里设置成不明确的进度风格
//        requestWindowFeature(Window.FEATURE_INDETERMINATE_PROGRESS);
        requestWindowFeature(Window.FEATURE_PROGRESS);
        setContentView(R.layout.activity_progress_bar);
        ButterKnife.bind(this);

        //设置标题栏中的不明确的进度条是否可以显示
//        setProgressBarIndeterminateVisibility(true);
        setProgressBarVisibility(true);


    }


    @OnClick(R.id.tv_test)
    public void onViewClicked() {

//        progressBar.incrementProgressBy(20);
//
//        progressBar.incrementSecondaryProgressBy(20);
//
//        Log.e("=====", progressBar.getProgress() + "");
//        Log.e("=====", progressBar.getSecondaryProgress() + "");



    }
}
