package com.example.testpproject.animation;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SecondActivity extends AppCompatActivity {

    @BindView(R.id.txt1)
    TextView txt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.txt1)
    public void onViewClicked() {

        finishAfterTransition();
    }
}
