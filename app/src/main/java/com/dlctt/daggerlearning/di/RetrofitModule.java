package com.dlctt.daggerlearning.di;

import com.dlctt.daggerlearning.BackendApi;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.concurrent.TimeUnit;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class RetrofitModule
{
    @Singleton
    @Provides
    public static Gson provideGson()
    {
        return new GsonBuilder().create();
    }

    @Singleton
    @Provides
    public static OkHttpClient provideOkHttpClient()
    {
        return new OkHttpClient.Builder().
                readTimeout(1, TimeUnit.MINUTES).
                writeTimeout(1, TimeUnit.MINUTES).
                connectTimeout(1, TimeUnit.MINUTES).
                build();
    }

    @Singleton
    @Provides
    public static Retrofit provideRetrofit(OkHttpClient client, Gson gson)
    {
        return new Retrofit.Builder().
                baseUrl("https://www.google.com/").
                addConverterFactory(GsonConverterFactory.create(gson)).
                addCallAdapterFactory(RxJava2CallAdapterFactory.create()).
                client(client).
                build();
    }

    @Singleton
    @Provides
    public static BackendApi provideBackendApi(Retrofit retrofit)
    {
        return retrofit.create(BackendApi.class);
    }

}
