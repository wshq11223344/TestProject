package com.example.testpproject.jetpack.livedatabus;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.testpproject.R;

public class SecActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_livedata);
        //消费者订阅消息
//        LiveDataBus.getInstance().with("huawei", Huawei.class).observe(this, new Observer<Huawei>() {//观查者
//                    @Override
//                    public void onChanged(Huawei huawei) {
//                        if (huawei != null) {
//                            Toast.makeText(SecActivity.this, huawei.getType(), Toast.LENGTH_SHORT).show();
//                        }
//                    }
//                }
//
//        );
    }

    /**
     * 发布者
     *
     * @param view
     */
    public void sendMessage(View view) {
        Huawei huawei = new Huawei("META-30");
        //厂家发布消息
//        LiveDataBus.getInstance().with("huawei", Huawei.class).postValue(huawei);

        LiveDataBus.getInstance().with("hanqi",String.class).postValue("测试数据");
    }
}
