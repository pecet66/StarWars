package com.example.user.starwars.data.component;

import com.example.user.starwars.database.StarWarsSQLiteOpenhelper;
import com.example.user.starwars.database.people.PeopleRepository;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import javax.inject.Singleton;
import dagger.Provides;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by user on 11.07.2016.
 */
public class NetModule {
    String mBaseUrl;
    public NetModule(String mBaseUrl) {
        this.mBaseUrl = mBaseUrl;
    }

    @Provides
    @Singleton
    public OkHttpClient getOkHttpClient() {
        return  new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
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
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(mBaseUrl)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
    }

    /*@Provides
    @Singleton
    public StarWarsService getStarWarsService() {
        return getRetrofit().create(StarWarsService.class);
    }*/

    /*@Provides
    @Singleton
    public PeopleRepository getPeopleRepository() {
        return new PeopleRepository(new StarWarsSQLiteOpenhelper(this));
    }*/
}

