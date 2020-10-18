package com.example.testpproject.dialog;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class DialogFragmentActivity extends AppCompatActivity implements ViewDialogFragment.Callback {

    MyDialogFragment dialogFragment;
    MyDialogFragment2 myDialogFragment2;
    @BindView(R.id.tv_dialog)
    TextView tvDialog;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dialog_fragment);
        ButterKnife.bind(this);

    }

    @OnClick(R.id.tv_dialog)
    public void onViewClicked() {

//        dialogFragment = new MyDialogFragment();
////        dialogFragment.show(getSupportFragmentManager(), "dialog");
//
//        dialogFragment.show("", "", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.e("======", "确定");
//            }
//        }, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//                Log.e("======", "取消");
//
//            }
//        }, getSupportFragmentManager());
//        myDialogFragment2 = new MyDialogFragment2();
//        myDialogFragment2.show(getSupportFragmentManager(), "");

        ViewDialogFragment viewDialogFragment = new ViewDialogFragment();
        viewDialogFragment.show(getSupportFragmentManager());
    }

    @Override
    public void onClick(String userName, String password) {
        Log.e("=======", userName);
        Log.e("=======", password);

    }

}