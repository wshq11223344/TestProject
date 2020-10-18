package com.example.testpproject.internet;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.widget.Toast;

import com.example.testpproject.MyApplication;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

import static com.example.testpproject.internet.HttpManager.JSON;


public class NetworkManager {
    private static NetworkManager mInstance;
    private OkHttpClient client;
    private Handler handler = new Handler(Looper.getMainLooper());
    private Gson mGson;
    private Context mContext;

    private enum Method {
        GET, POST
    }

    ;

    private NetworkManager() {
        client = new OkHttpClient();
        mGson = new Gson();
        mContext = MyApplication.getInstance();
    }


    public static NetworkManager getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkManager();
        }
        return mInstance;
    }


    public interface SuccessCallback<T> {
        public void onSuccess(T response);
    }

    public interface FailedCallback {
        public void onFailed(String message);
    }


    public void getResultString(String url, Map<String, String> params, SuccessCallback<String> successCallback, FailedCallback failedCallback) {
        doRequest(Method.GET, url, params, null, successCallback, failedCallback);
    }


    public void getResultClass(String url, Map<String, String> params, Class mClass, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.GET, url, params, mClass, successCallback, failedCallback);
    }

    public void getResultClass(String url, Map<String, String> params, Type mType, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.GET, url, params, mType, successCallback, failedCallback);
    }


    public void postResultString(String url, Map<String, String> params, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.POST, url, params, null, successCallback, failedCallback);
    }

    public void postResultClass(String url, Map<String, String> params, Class mClass, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.POST, url, params, mClass, successCallback, failedCallback);
    }

    public void postResultClass(String url, Map<String, String> params, Type mType, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.POST, url, params, mType, successCallback, failedCallback);
    }


    //用json格式发送
    public void postResultClass(String url, String json, Class mClass, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.POST, url, json, mClass, successCallback, failedCallback);
    }

    //用json格式发送
    public void postResultString(String url, String json, SuccessCallback successCallback, FailedCallback failedCallback) {
        doRequest(Method.POST, url, json, null, successCallback, failedCallback);
    }


    public void doRequest(Method method, String url, String json, final Object type, final SuccessCallback successCallback, final FailedCallback failedCallback) {
        Callback responseCallback = initCallback(type, successCallback, failedCallback);
        Request.Builder builder = new Request.Builder();
        switch (method) {
            case GET:
                builder.url(json == null ? url : url + "?" + json);
                break;
            case POST:

                RequestBody requestBody = RequestBody.create(JSON, json);
                builder.url(url).post(requestBody);

                break;

        }

        Request request = builder.build();
        if (request != null) {
            client.newCall(request).enqueue(responseCallback);
        }
    }


    public void doRequest(Method method, String url, Map<String, String> paramMap, final Object type, final SuccessCallback successCallback, final FailedCallback failedCallback) {
        Callback responseCallback = initCallback(type, successCallback, failedCallback);
        Request.Builder builder = new Request.Builder();
        switch (method) {
            case GET:
                builder.url(paramMap == null ? url : url + "?" + addParams(paramMap));
                break;
            case POST:
                FormBody.Builder paramBuilder = new FormBody.Builder();
                if (paramMap != null) {
                    for (Map.Entry<String, String> item : paramMap.entrySet()) {
                        paramBuilder.add(item.getKey(), item.getValue());
                    }
                }
                builder.url(url).post(paramBuilder.build());
                break;

        }

        Request request = builder.build();
        if (request != null) {
            client.newCall(request).enqueue(responseCallback);
        }

//        Call call = client.newCall(request);
//        call.enqueue(responseCallback);
    }

    private Callback initCallback(final Object type, final SuccessCallback successCallback, final FailedCallback failedCallback) {


        Callback responseCallback = new Callback() {
            @Override
            public void onFailure(Call call, final IOException e) {
                handleFailedRequest(e.getMessage());
            }

            @Override
            public void onResponse(Call call, final Response response) {
                try {
                    if (response == null) {
                        return;
                    }

                    //  Log.e("=========", response.body().string());
                    JSONObject jsonObject = new JSONObject(response.body().string());

                    handleResponseRequest(jsonObject);

                } catch (Exception e) {
                    handleFailedRequest(e.getMessage());
                    e.printStackTrace();
                }
            }

            private void handleResponseRequest(final JSONObject jsonObject) {
                if (successCallback == null) {
                    return;
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            //   JSONObject responseObject = new JSONObject(response);
                            if (jsonObject.getBoolean("action")) {
                                if (type == null) {
                                    successCallback.onSuccess(jsonObject.getString("result"));
                                } else if (type instanceof Class || type instanceof Type) {

//                                    JSONObject user = jsonObject.getJSONObject("user");

                                    successCallback.onSuccess(mGson.fromJson(jsonObject.getString("user"), type instanceof Class ? (Class) type : (Type) type));
                                }
                            } else {
                                setDefaultFailed(jsonObject.getString("result"));
                            }
                        } catch (Exception e) {
                            if (e == null) {
                                return;
                            }
                            setDefaultFailed(e.getMessage());
                            e.printStackTrace();
                        }
                    }
                });
            }

            private void handleFailedRequest(final String message) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        setDefaultFailed(message);
                    }
                });
            }

            private void setDefaultFailed(String message) {
                if (failedCallback != null) {
                    failedCallback.onFailed(message);
                } else {
                    Toast.makeText(mContext, message, Toast.LENGTH_SHORT).show();
                }
            }
        };
        return responseCallback;
    }

    private String addParams(Map<String, String> params) {
        StringBuilder builder = new StringBuilder();
        if (params != null) {
            for (Map.Entry<String, String> item : params.entrySet()) {
                builder.append(item.getKey()).append("=").append(item.getValue()).append("&");
            }
        }

        if (params != null) {

            StringBuilder builder1 = new StringBuilder();

            Set<Map.Entry<String, String>> entries = params.entrySet();

            Iterator<Map.Entry<String, String>> iterator = entries.iterator();

            while (iterator.hasNext()) {

                String key = iterator.next().getKey();
                String value = iterator.next().getValue();
                builder1.append(key).append("=").append(value).append("&");
            }
            builder.deleteCharAt(builder1.length());

        }


        //   builder.append("timestamp_now=").append(System.currentTimeMillis());
        return builder.toString();
    }


}
