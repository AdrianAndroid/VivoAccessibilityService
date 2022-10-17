package com.joyy.androidproject;

import com.google.gson.Gson;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OKHttpUtils {
    private static final OkHttpClient client = new OkHttpClient();

    public static void getWeather(WeatherCallback weatherCallback) {
        String url = "https://api.seniverse.com/v3/weather/now.json?key=SlZjcr1nW8tuvzvd6&location=beijing&language=zh-Hans&unit=c";
        //创建一个Request
        Request request = new Request.Builder()
                .get()
                .url(url)
                .build();
        //通过client发起请求
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                weatherCallback.callback(new Weather());
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                if (response.isSuccessful()) {
                    // String str = response.body().string();
                    Gson gson = new Gson();
                    final Weather weather = gson.fromJson(response.body().string(), Weather.class);
                    System.out.println(weather);
                    weatherCallback.callback(weather);
                }
            }
        });
    }

    interface WeatherCallback {
        void callback(Weather weather);
    }

}
