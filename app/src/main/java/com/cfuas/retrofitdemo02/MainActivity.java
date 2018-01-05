package com.cfuas.retrofitdemo02;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Map<String, String> params = new HashMap<>(16);
        params.put("username", "CfTest");
        params.put("password", "123456");
        params.put("logintime", System.currentTimeMillis() + "");
        /**
         * 1. 创建Retrofit实例
         */
        Retrofit retrofit = new Retrofit.Builder().baseUrl(AppUrl.BASE_URL).build();

        /**
         * 3.用Retrofit创建一个LoginService的代理对象。
         */
        LoginService loginService = retrofit.create(LoginService.class);

        /**
         * 4.接口调用
         *  将请求发送到webserver并返回响应的改进方法的调用。每个调用都有自己的HTTP请求和响应对。
         *  使用{/@ link # clone}
         *  对相同的web服务器进行多个调用;这可以用于实现轮询或重试失败的调用。
         *
         *  调用可以与{@/ link # execute}同步执行，
         *  也可以与{@/ link # enqueue}异步执行。
         *  在任何情况下，都可以在任何时候取消调用{@/ link # cancel}。
         *  正在忙于编写请求或读取响应的调用可能会收到{@/ link IO异常};这是按设计工作的。
         *
         *  用法和OkHttp的call如出一辙,
         *  不同的是如果是Android系统回调方法执行在主线程
         */
        Call<ResponseBody> responseBodyCall = loginService.getLoginInfo(params);
//        responseBodyCall.cancel();
//        responseBodyCall.clone();
//        try {
//            responseBodyCall.execute();
//        } catch (IOException e) {
//            e.printStackTrace();
//        }

        responseBodyCall.enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    System.out.println(response.body().toString());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                t.printStackTrace();
            }
        });

    }
}
