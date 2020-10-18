package com.example.testpproject.retrofit;


import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by tzhang on 2016/9/13.
 */
public class RetrofitClient {

    private static RetrofitService sRetrofitService;

    public static RetrofitService getClient() {
        if (sRetrofitService == null) {

            OkHttpClient okClient = new OkHttpClient();

            Retrofit client = new Retrofit.Builder()
                    .baseUrl("ConstantData.BASE_URL")
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();

            sRetrofitService = client.create(RetrofitService.class);
        }
        return sRetrofitService;
    }

}
