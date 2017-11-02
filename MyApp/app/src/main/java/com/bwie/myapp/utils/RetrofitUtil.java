package com.bwie.myapp.utils;

import android.util.Log;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by 13435 on 2017/11/2.
 */

public class RetrofitUtil {

    private static RetrofitUtil retrofitUtils;
    private RetrofitUtil(){

    }
    public static RetrofitUtil getInstance(){
        if(retrofitUtils == null){
            synchronized (RetrofitUtil.class){
                if(retrofitUtils == null){
                    retrofitUtils = new RetrofitUtil();
                }
            }
        }
        return retrofitUtils;
    }

    private static Retrofit retrofit;
    public static synchronized Retrofit getRetrofit(String url){

        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String msg) {
                Log.i("sss",msg);
            }
        });
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                .addInterceptor(httpLoggingInterceptor)
                .connectTimeout(5000, TimeUnit.SECONDS)
                .readTimeout(5000,TimeUnit.SECONDS)
                .retryOnConnectionFailure(false)
                .build();
        if(retrofit == null){
            retrofit = new Retrofit.Builder()
                    .baseUrl(url)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }
        return retrofit;
    }

    public <T>T getApiService(String url, Class<T> cl){
        Retrofit retrofit = getRetrofit(url);

        return retrofit.create(cl);
    }
}
