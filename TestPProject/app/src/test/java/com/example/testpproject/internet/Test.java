package com.example.testpproject.internet;

import com.example.testpproject.zyhs.set.Person;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class Test {


    public static void main(String[] args) {


        OkHttpClient okHttpClient = new OkHttpClient();

//        RequestBody requestBody = RequestBody.create();


//        表单格式提交数据
        FormBody.Builder formBody = new FormBody.Builder();
        formBody.add("", "");
        formBody.add("", "");

//       提交json格式数据
        MediaType JSON = MediaType.parse("application/json; charset=utf-8");
        RequestBody requestBody = RequestBody.create(JSON, "gson转化后的数据");

//        Gson gson = new Gson();
//        String json = gson.toJson("123");
//        String fromJson = gson.fromJson(json, String.class);
//        System.out.println(fromJson);

        Gson gson = new Gson();
        List<String> list = new ArrayList<>(6);
        list.add("123");
        list.add("456");
        list.add("789");
        String json = gson.toJson(list);
        System.out.println(json);
//        List<String> orderDetailList = new ArrayList<>();//接收的 对象
//        orderDetailList = gson.fromJson(json, new TypeToken<List<String>>() {
//        }.getType());
//        for (int i = 0; i < orderDetailList.size(); i++) {
//
//            System.out.println(orderDetailList.get(i));
//        }


//        提交File文件
        MediaType fileType = MediaType.parse("File/*");
        File file = new File("path");//file对象.
        RequestBody requestBody1 = RequestBody.create(fileType, file);


//        使用MultipartBody同时传递键值对参数和File对象

        File file1 = new File("");
        MultipartBody multipartBody = new MultipartBody.Builder()
                .setType(MultipartBody.FORM)
                .addFormDataPart("", "")
                .addFormDataPart("", "")
                .addFormDataPart("file", file1.getName(), RequestBody.create(MediaType.parse("File/*"), file1))
                .build();

        Request request = new Request.Builder()
//                .get()
                .addHeader("113", "1213")
                .url("")
                .post(formBody.build())
                .post(requestBody)
                .post(multipartBody)
                .build();

        Call call = okHttpClient.newCall(request);

        call.enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
            }
        });


    }


}
