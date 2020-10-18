package com.example.testpproject.jetpack.livedatabus;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;

import com.example.testpproject.R;

public class MainActivity extends AppCompatActivity {


    TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_livedata);

        //消费者订阅消息
        LiveDataBus.getInstance().with("huawei", Huawei.class)
                .observe(this, new Observer<Huawei>() {
                    @Override
                    public void onChanged(Huawei huawei) {
                        if (huawei != null) {
//                            Toast.makeText(MainActivity.this, huawei.getType(), Toast.LENGTH_SHORT).show();
                            textView.setText(huawei.getType());
                        }
                    }
                });

        LiveDataBus.getInstance().with("hanqi", String.class)
                .observe(this, new Observer<String>() {
                    @Override
                    public void onChanged(String string) {
                        if (string != null) {
//                            Toast.makeText(MainActivity.this, huawei.getType(), Toast.LENGTH_SHORT).show();
                            textView.setText(string);
                        }
                    }
                });


        textView = findViewById(R.id.txt);

    }

    /**
     * 这里就是一个发布者(苹果，华为)
     *
     * @param view
     */
    public void sendMessage(View view) {
        Huawei huawei = new Huawei("META-20");



        //厂家发布消息
        LiveDataBus.getInstance().with("huawei", Huawei.class).postValue(huawei);
    }


    public void startSecActivity(View view) {
        Intent intent = new Intent(this, SecActivity.class);
        startActivity(intent);
    }
}










