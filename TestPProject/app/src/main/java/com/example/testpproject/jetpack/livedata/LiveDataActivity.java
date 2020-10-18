package com.example.testpproject.jetpack.livedata;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.testpproject.R;
import com.example.testpproject.mvp.adapter.GirlAdapter;
import com.example.testpproject.mvp.bean.Girl;

import java.util.ArrayList;
import java.util.List;

public class LiveDataActivity extends AppCompatActivity {


    ListView listView;

    LiveDatas liveDatas;
    List<Girl> data;

    GirlAdapter girlAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_data);
        listView = (ListView) findViewById(R.id.listview);
        init();

        girlAdapter = new GirlAdapter(LiveDataActivity.this, data);
        listView.setAdapter(girlAdapter);


        liveDatas = new ViewModelProvider(this).get(LiveDatas.class);

        Log.e("========", liveDatas.hashCode() + "");


        Observer<List<Girl>> observer = new Observer<List<Girl>>() {
            @Override
            public void onChanged(List<Girl> girls) {

                data.clear();
                data.addAll(girls);
                girlAdapter.notifyDataSetChanged();

//                listView.setAdapter(new GirlAdapter(LiveDataActivity.this, girls));

            }
        };

        liveDatas.getInstance().observe(this, observer);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {

                liveDatas.loadData();

//                startActivity(new Intent(LiveDataActivity.this, LIveSecondActivity.class));
            }
        });


    }


    //初始化默认数据
    private void init() {
        data = new ArrayList<>();
        data.add(new Girl(R.drawable.f1, "一星", "****"));
        data.add(new Girl(R.drawable.f2, "一星", "****"));
        data.add(new Girl(R.drawable.f3, "一星", "****"));
        data.add(new Girl(R.drawable.f4, "一星", "****"));
        data.add(new Girl(R.drawable.f5, "一星", "****"));
        data.add(new Girl(R.drawable.f6, "一星", "****"));
        data.add(new Girl(R.drawable.f7, "一星", "****"));
        data.add(new Girl(R.drawable.f8, "一星", "****"));
        data.add(new Girl(R.drawable.f9, "一星", "****"));
        data.add(new Girl(R.drawable.f10, "一星", "****"));
    }

}
