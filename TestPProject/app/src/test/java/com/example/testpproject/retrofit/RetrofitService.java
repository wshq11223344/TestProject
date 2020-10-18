//package com.example.testpproject.retrofit;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import okhttp3.RequestBody;
//import okhttp3.Response;
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.http.Body;
//import retrofit2.http.Field;
//import retrofit2.http.FormUrlEncoded;
//import retrofit2.http.GET;
//import retrofit2.http.Header;
//import retrofit2.http.HeaderMap;
//import retrofit2.http.Headers;
//import retrofit2.http.Multipart;
//import retrofit2.http.POST;
//import retrofit2.http.Part;
//import retrofit2.http.Path;
//import retrofit2.http.Query;
//import retrofit2.http.QueryMap;
//import retrofit2.http.Streaming;
//
///**
// * Created by tzhang on 2016/9/13.
// */
//public interface RetrofitService {
//
//    @GET("/hpproject/{link}")
//    @Headers({"token:123456"})
//    Call<List<Goods>> getGoods(@Path("link") String link);
//
//    @GET("/hpproject/{link}")
//    Call<ResponseBody> login(@Header("token") String token, @HeaderMap HashMap<String, String> hashMap, @Path("link") String link, @Query("userphone") String phone, @Query("password") String pwd);
//
//
//    @GET("/hpproject/{link}")
//    Call<User> loginMap(@Path("link") String link, @QueryMap Map<String, String> map);
//
//
//    @POST("/hpproject/{link}")
//    Call<User> postObject(@Path("link") String link, @Body Goods goodModel);
//
//
//    @FormUrlEncoded
//    @POST("/hpproject/{link}")
//    Call<User> formLogin(@Path("link") String link, @Field("userphone") String first, @Field("password") String last);
//
//
//    @Multipart
//    @POST("/hpproject/{link}")
//    Call<ResponseBody> upPhoto(@Path("link") String link, @Part("photo") RequestBody photo, @Part("description") RequestBody description);
//
//
//}
