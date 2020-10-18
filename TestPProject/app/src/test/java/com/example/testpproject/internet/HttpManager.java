package com.example.testpproject.internet;

import android.os.Handler;

import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Type;
import java.util.Map;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class HttpManager {

    public static final MediaType JSON = MediaType.parse("application/json; charset=utf-8");

    private static HttpManager mInstance;
    private OkHttpClient client;
    private Gson mGson;
    private Handler handler = new Handler();

    private enum Method {
        GET, POST
    }

    private HttpManager() {
        client = new OkHttpClient();
        mGson = new Gson();
    }

    public static HttpManager getInstance() {
        if (mInstance == null) {
            mInstance = new HttpManager();
        }
        return mInstance;
    }

    public interface HttpManagerCallback<T> {
        public void onSuccess(T response);
        public void onFailed(String message);
    }

    /**
     * post请求 提交实体类
     *
     * @param url
     * @param bean
     * @param httpManagerCallback
     */
    public void postResult(String url, String bean, Class mClass, HttpManagerCallback httpManagerCallback) {
        doRequest(Method.POST, url, bean, mClass, httpManagerCallback);
    }

    /**
     * post请求 提交表单
     *
     * @param url
     * @param params
     * @param httpManagerCallback
     */
    public void postResult(String url, Map<String, String> params, Class mClass, HttpManagerCallback httpManagerCallback) {
        doRequest(Method.POST, url, params, mClass, httpManagerCallback);
    }

    /**
     * get请求 提交表单
     *  @param url
     * @param params
     * @param httpManagerCallback
     */
    public void getResult(String url, Map<String, String> params, Class mClass, HttpManagerCallback httpManagerCallback) {
        doRequest(Method.GET, url, params, mClass, httpManagerCallback);
    }

    public void doRequest(Method method, String url, String params, Class mClass, final HttpManagerCallback httpManagerCallback) {
        Callback callback = initCallback(mClass, httpManagerCallback);
        Request.Builder builder = new Request.Builder();
        switch (method) {
            case GET:
                builder.url(params == null ? url : url + "?" + params);
                break;
            case POST:
                RequestBody requestBody = RequestBody.create(JSON, params);
                builder.url(url).post(requestBody);
                break;
        }

        Request request = builder.build();
        if (request != null) {
            client.newCall(request).enqueue(callback);
        }
    }

    public void doRequest(Method method, String url, Map<String, String> params, Class mClass, final HttpManagerCallback httpManagerCallback) {
        Callback callback = initCallback(mClass, httpManagerCallback);
        Request.Builder builder = new Request.Builder();
        switch (method) {
            case GET:
                builder.url(params == null ? url : url + "?" + addParams(params));
                break;
            case POST:
                FormBody.Builder paramBuilder = new FormBody.Builder();
                if (params != null) {
                    for (Map.Entry<String, String> item : params.entrySet()) {
                        paramBuilder.add(item.getKey(), item.getValue());
                    }
                }
                builder.url(url).post(paramBuilder.build());
                break;

        }

        Request request = builder.build();
        if (request != null) {
            client.newCall(request).enqueue(callback);
        }
    }

    private Callback initCallback(final Object type, final HttpManagerCallback httpManagerCallback) {
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
                if (httpManagerCallback == null) {
                    return;
                }

                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        try {
                            if (jsonObject.getBoolean("action")) {
                                if (httpManagerCallback != null) {
                                    if (type == null) {
                                        httpManagerCallback.onSuccess(jsonObject.getString("result"));
                                    } else if (type instanceof Class || type instanceof Type) {
                                        httpManagerCallback.onSuccess(mGson.fromJson(jsonObject.getString("result"), type instanceof Class ? (Class) type : (Type) type));
                                    }
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
                if (httpManagerCallback != null) {
                    httpManagerCallback.onFailed(message);
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
        builder.append("timestamp_now=").append(System.currentTimeMillis());
        return builder.toString();
    }

    private class T {
    }
}
