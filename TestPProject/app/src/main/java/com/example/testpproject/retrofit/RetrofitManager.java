package com.example.testpproject.retrofit;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class RetrofitManager {

    public void testRetrofit() {

        RetrofitService client = RetrofitClient.getClient();

        Call<List<String>> listCall = client.formLogin("login", "hanqi", "123");

//        异步执行
        listCall.enqueue(new Callback<List<String>>() {
            @Override
            public void onResponse(Call<List<String>> call, Response<List<String>> response) {


                response.isSuccessful();

                List<String> body = response.body();
            }

            @Override
            public void onFailure(Call<List<String>> call, Throwable t) {

            }
        });


//        同步执行
        try {
            Response<List<String>> execute = listCall.execute();
            List<String> body = execute.body();

        } catch (IOException e) {
            e.printStackTrace();
        }


    }


    public void publicMethod() {
        RetrofitService client = RetrofitClient.getClient();

        Call<ResponseBody> listCall = client.publicMethod("123", "123");

        listCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {
                    response.body().string();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {

            }
        });


    }
}
