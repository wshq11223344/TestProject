package com.example.testpproject.json;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.testpproject.R;

import org.json.JSONArray;
import org.json.JSONObject;

public class JsonActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_json);


        try {
            test4();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public void test() throws Exception {

        JSONArray pigs = new JSONArray();

        JSONObject pig1 = new JSONObject();
        pig1.put("name", "佩奇");
        pig1.put("age", "34");

        String namr = pig1.getString("name");
        System.out.println("===" + namr);

        JSONObject pig2 = new JSONObject();
        pig2.put("name", "猪猪侠");

        pigs.put("八戒");

        pigs.put(pig1);
        pigs.put(pig2);
        /*
         * 这样构造的JSONArray对象如下
         * ["八戒",{"name":"佩奇"},{"name":"猪猪侠"}]
         */
        System.out.println("==" + pigs.get(0));
        System.out.println("==" + pigs.getJSONObject(1));
        System.out.println("==" + pigs.getJSONObject(2));


    }


    public void test2() throws Exception {
        JSONObject student = new JSONObject();
        /*
         * put(key,value)其中key是键名，一般为字符串，用于调用后边的value,
         * value的值为String或JSONObject或JSONArray对象
         */
        //put(key,value)添加String对象
        student.put("name", "小明");
        student.put("sno", "20160000");

        JSONObject address = new JSONObject();
        address.put("city", "石家庄市");
        address.put("country", "长安区");
        //put(key,value)添加JSONObject对象
        student.put("address", address);

        System.out.println(student.toString());

        System.out.println(student.getJSONObject("address"));

    }


    public void test4() throws Exception {
        JSONObject student = new JSONObject();
        student.put("name", "小明");
        student.put("sno", "20160000");

        JSONArray family = new JSONArray();

        JSONObject father = new JSONObject();
        father.put("name", "小明老爸");
        father.put("age", 40);

        JSONObject mother = new JSONObject();
        mother.put("name", "小明老妈");
        mother.put("age", 41);
        /*add(value)是JSONArray对象添加元素方法
         * value可以是String和JSONObject对象或JSONArray对象
         */
        family.put(father);
        family.put(mother);
        //put(key,value)添加JSONArray对象
        student.put("family", family);
        /*
         * JSONObject对象调用元素用get(key)方法
         * key为键名
         */
        System.out.println(student.get("name"));
        //输出结果  小明
        System.out.println(student.get("sno"));

        System.out.println(student.getJSONArray("family"));

        JSONArray jsonArray = student.getJSONArray("family");

        for (int i = 0; i < jsonArray.length(); i++) {

            JSONObject jsonObject= (JSONObject) jsonArray.get(i);
            System.out.println(jsonObject);
        }
    }
}