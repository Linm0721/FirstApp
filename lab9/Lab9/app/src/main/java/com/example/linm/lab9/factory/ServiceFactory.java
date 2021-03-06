package com.example.linm.lab9.factory;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by ACER on 2017/12/23.
 */

public class ServiceFactory {

    private static OkHttpClient createOkHttp(){
        OkHttpClient okHttpClient = new OkHttpClient.Builder()
                                        .connectTimeout(10, TimeUnit.SECONDS)
                                        .readTimeout(30, TimeUnit.SECONDS)
                                        .writeTimeout(10, TimeUnit.SECONDS)
                                        .build();
        return okHttpClient;
    }

    public static Retrofit createRetrofit(String baseUrl){
        return new Retrofit.Builder()
                .baseUrl(baseUrl)
                .addConverterFactory(GsonConverterFactory.create()) //添加GSon Converter
                .addCallAdapterFactory(RxJavaCallAdapterFactory.create()) //RxJavaCall Adapter
                .client(createOkHttp())
                .build();
    }

}
