//package com.example.testpproject.retrofit;
//
//import android.os.Environment;
//import android.os.Handler;
//import android.os.Message;
//import android.util.Log;
//
//import com.example.han.listviews.network.Goods;
//
//import java.io.File;
//import java.io.IOException;
//import java.lang.annotation.Annotation;
//import java.lang.reflect.Method;
//import java.util.List;
//import java.util.Map;
//
//import okhttp3.MediaType;
//import okhttp3.RequestBody;
//import okhttp3.ResponseBody;
//import retrofit2.Call;
//import retrofit2.Callback;
//import retrofit2.Response;
//import retrofit2.http.GET;
//import retrofit2.http.Header;
//
//import static com.example.testpproject.zyhs.lsn_15.数独问题.result;
//
//
//public class RetrofitManager {
//
//    private static Handler sHandler;
//
//    public static void setsHandler(Handler handler) {
//        sHandler = handler;
//    }
//
//    public static void getGoods() {
//
//        RetrofitService retrofitService = RetrofitClient.getClient();
//// 创建有一个回调对象
//        Call<List<Goods>> call = retrofitService.getGoods("QueryAllGoods");
//        // 用回调对象发起请求
//        call.enqueue(new Callback<List<Goods>>() {
//
//            // 回调方法
//            @Override
//            public void onResponse(Call<List<Goods>> call, Response<List<Goods>> response) {
//                if (response.isSuccessful()) {
//                    // request successful (status code 200, 201)
//                    List<Goods> result = response.body();
//                    Log.e("RetrofitManager", result.size() + "-----------");
//                    Message msg = sHandler.obtainMessage();
//                    msg.what = 0;
//                    msg.obj = result;
//                    sHandler.sendMessage(msg);
//
//
//                } else {
//
//                }
//            }
//
//            // 返回http状态码非成功的回调方法
//            @Override
//            public void onFailure(Call<List<Goods>> call, Throwable t) {
//
//            }
//        });
//
//    }
//
//    public static void getUser(String userPhone, String userPwd) {
//        RetrofitService retrofitService = RetrofitClient.getClient();
//        // 创建有一个回调对象
//        Call<ResponseBody> call = retrofitService.login("UserQuery", userPhone, userPwd);
//
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                // [200, 300)
//                if (response.isSuccessful()) {
//                    try {
//                        response.body().string();
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//
//                    Log.e("RetrofitManager", result.getUserName() + result.getUserPwd());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public static void getUserMap(Map<String, String> map) {
//        RetrofitService retrofitService = RetrofitClient.getClient();
//        // 创建有一个回调对象
//        Call<User> call = retrofitService.loginMap("UserQuery", map);
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                // [200, 300)
//                if (response.isSuccessful()) {
//                    User result = response.body();
//
//                    Log.e("RetrofitManager--", result.getUserName() + result.getPhoneNumber());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public static void postObject(Goods goodModel) {
//        RetrofitService retrofitService = RetrofitClient.getClient();
//        // 创建有一个回调对象
//        Call<User> call = retrofitService.postObject("UserQuery", goodModel);
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful()) {
//                    User result = response.body();
//
//                    Log.e("RetrofitManager--", result.getUserName() + result.getPhoneNumber());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public static void formLogin(String userPhone, String pwd) {
//        RetrofitService retrofitService = RetrofitClient.getClient();
//        // 创建有一个回调对象
//        Call<User> call = retrofitService.formLogin("UserQuery", userPhone, pwd);
//
//        call.enqueue(new Callback<User>() {
//            @Override
//            public void onResponse(Call<User> call, Response<User> response) {
//                if (response.isSuccessful()) {
//                    User result = response.body();
//
//                    Log.e("RetrofitManager--", result.getUserName() + result.getUserPwd());
//
//                }
//            }
//
//            @Override
//            public void onFailure(Call<User> call, Throwable t) {
//
//            }
//        });
//    }
//
//    public static void upPhoto() {
//        RetrofitService retrofitService = RetrofitClient.getClient();
//        Log.e("---", Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getPath());
//
//        File file = new File("/storage/emulated/0/0f63618b1.jpg");
//        RequestBody photo = RequestBody.create(MediaType.parse("application/octet-stream"), file);
//
//        //   File file1 = new File( Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_MUSIC), "aa.mp3");
//
//        String descriptionString = "这是我上传的图片";
//        RequestBody description = RequestBody.create(MediaType.parse("multipart/form-data"), descriptionString);
//
//      /*  RequestBody music =
//                RequestBody.create(MediaType.parse("application/octet-stream"), file1);*/
//        Call<ResponseBody> call = retrofitService.upPhoto("FileUpload", photo, description);
//
//        call.enqueue(new Callback<ResponseBody>() {
//            @Override
//            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
//                if (response.isSuccessful()) {
//                    try {
//                        Log.e("RetrofitManager", "response = " + response.body().string());
//                    } catch (IOException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//
//            @Override
//            public void onFailure(Call<ResponseBody> call, Throwable t) {
//
//            }
//        });
//    }
//
//}
//
