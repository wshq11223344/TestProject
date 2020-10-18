package com.example.testpproject.dialog.popwindow;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.testpproject.R;

public class Main2Activity extends AppCompatActivity implements View.OnClickListener {

    private Button send_show;
    private PopupWindow pop;
    private RelativeLayout send_zong;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        initView();
    }

    private void initView() {
        send_show = (Button) findViewById(R.id.send_show);
        send_show.setOnClickListener(this);
        send_zong = (RelativeLayout) findViewById(R.id.send_zong);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.send_show:
                //初使化pop窗口
                initPop();
                //在某个控件的下面显示出来
                pop.showAsDropDown(send_show);
                //相对于某个控件设置偏移量xoff 在水平方向的偏移 yoff 在垂直方向的偏移
//                pop.showAsDropDown(send_zong, 200, 100);
                //在屏幕的最下边显示  -----最后的两个参数 控制水平或垂直方向的偏移
//                pop.showAtLocation(send_zong, Gravity.CENTER, 0, 0);
                break;
        }
    }

    public void initPop() {
        //加载布局
        View contentView = View.inflate(Main2Activity.this, R.layout.pop, null);
        //创建pop窗口
        //1.contentView 内部布局
        //2.pop窗口的宽度与高度一般设置成 WRAP_CONTENT
        //3.最后一个参数 代表是否聚集
        pop = new PopupWindow(contentView, ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT, true);

        //在此pop的区域外点击关闭此窗口
        pop.setOutsideTouchable(false);
        pop.setFocusable(false);
        //设置一个背景
        //pop.setBackgroundDrawable(getResources().getDrawable(R.drawable.ic_launcher));
        //设置一个空背景
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), 100);
        pop.setBackgroundDrawable(new BitmapDrawable(getResources(), bitmap));

        //设置背景
        pop.setOnDismissListener(new PopupWindow.OnDismissListener() {
            @Override
            public void onDismiss() {
                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1.0f;
                getWindow().clearFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
                getWindow().setAttributes(lp);
            }
        });
        WindowManager.LayoutParams lp = getWindow().getAttributes();
        lp.alpha = 0.3f;
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DIM_BEHIND);
        getWindow().setAttributes(lp);

        //在布局内查找组件
        TextView tvAdd = (TextView) contentView.findViewById(R.id.tv_add);
        TextView tvChat = (TextView) contentView.findViewById(R.id.tv_chat);

        //点击时将pop窗口关掉
        tvAdd.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg0) {
                // TODO Auto-generated method stub
                //销毁当前pop窗口
                pop.dismiss();
            }
        });
    }
}
