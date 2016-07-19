package com.example.user.starwars.netModule;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 11.07.2016.
 */
@Module
public class NetModule {
    String mBaseUrl;
    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttpClient(Cache cache) {
        return  new OkHttpClient.Builder()
                .cache(cache)
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }


    @Provides
    @Singleton
    public Cache getCache(Context context) {
        return new Cache(context.getCacheDir(), 10 * 10 *1024);
    }

    @Provides
    @Singleton
    public Gson getGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Provides
    @Singleton
    public Retrofit getRetrofit(Gson gson, OkHttpClient client) {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
    }

    @Provides
    @Singleton
    public StarWarsService getStarWarsService(Retrofit retrofit) {
        return retrofit.create(StarWarsService.class);
    }

    /*@Provides
    @Singleton
    public PeopleRepository getPeopleRepository() {
        return new PeopleRepository(new StarWarsSQLiteOpenhelper(this));
    }*/
}

