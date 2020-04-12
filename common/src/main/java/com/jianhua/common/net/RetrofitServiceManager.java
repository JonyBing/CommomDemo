package com.jianhua.common.net;

import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.fastjson.FastJsonConverterFactory;

public class RetrofitServiceManager {

    private static final int DEFAULT_TIME_OUT = 30;//超时时间 30s

    private Retrofit mRetrofit;
    private static RetrofitServiceManager instance;

    private RetrofitServiceManager() {
        // 创建 OKHttpClient
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        builder.connectTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//连接超时时间
        builder.writeTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//写操作 超时时间
        builder.readTimeout(DEFAULT_TIME_OUT, TimeUnit.SECONDS);//读操作超时时间
        builder.retryOnConnectionFailure(false);

        // 创建Retrofit
        mRetrofit = new Retrofit.Builder()
                .client(builder.build())
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(FastJsonConverterFactory.create())
                .build();
    }



    public static RetrofitServiceManager getInstance() {
        if (instance == null) {
            synchronized (RetrofitServiceManager.class){
                if (instance == null) {
                    instance = new RetrofitServiceManager();
                }
            }
        }
        return instance;
    }


    public <T> T create(Class<T> service) {
        return mRetrofit.create(service);
    }

}
