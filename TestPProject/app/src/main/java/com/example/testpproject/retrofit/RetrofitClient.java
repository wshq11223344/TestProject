package com.example.testpproject.retrofit;

import java.util.List;
import java.util.concurrent.Executor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitClient {

    private static RetrofitService retrofitService;

    public static RetrofitService getClient() {

        if (retrofitService == null) {

            synchronized (RetrofitClient.class) {

                if (retrofitService == null) {

                    OkHttpClient okHttpClient = new OkHttpClient();

                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://10.50.8.10:8080")
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                            .client(okHttpClient)
                            .build();

                    retrofitService = retrofit.create(RetrofitService.class);
                }

            }


        }


        return retrofitService;

    }


}
