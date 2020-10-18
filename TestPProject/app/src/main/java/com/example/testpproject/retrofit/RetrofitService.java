package com.example.testpproject.retrofit;

import android.util.ArrayMap;

import java.util.HashMap;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.HeaderMap;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.QueryMap;
import retrofit2.http.Url;

public interface RetrofitService<T> {


    @GET("/project/{link}/send")
    Call<T> login(@Path("link") String link, @Query("userName") String userName, @Query("pwsword") String pwsword);

    @GET("/project/{link}")
    @Headers({"token:123"})
    Call<T> register(@Path("link") String link, @QueryMap ArrayMap<String, String> arrayMap);


    @GET("/project/{link}")
    Call<T> heades(@Header("token") String token, @Path("link") String link, @QueryMap ArrayMap<String, String> arrayMap);

    @GET("/project/{link}")
    Call<T> headers(@HeaderMap ArrayMap<String, String> headerMap, @Path("link") String link, @QueryMap ArrayMap<String, String> arrayMap);

    @POST("/project/{link}")
    Call<T> postRequest(@Path("link") String link, @Body Object o);

    @FormUrlEncoded
    @POST("/project/{link}")
    Call<List<String>> formLogin(@Path("link") String link, @Field("userName") String name, @Field("userpwd") String pwd);


    @FormUrlEncoded
    @POST("/project/{link}")
    Call<ResponseBody> publicMethod(@Path("link") String path, @Field("field1") String field);
}
