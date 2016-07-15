package com.example.user.starwars;

import android.app.Application;

import com.example.user.starwars.database.StarWarsSQLiteOpenhelper;
import com.example.user.starwars.database.people.PeopleRepository;
import com.facebook.stetho.Stetho;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

/**
 * Created by user on 11.07.2016.
 */
public class App extends Application implements AppProvider {
    public static final String HTTP_SWAPI_CO_API = "http://swapi.co/api/";

    @Override
    public void onCreate() {
        super.onCreate();
        if (BuildConfig.DEBUG) {
            Timber.plant(new Timber.DebugTree());
            Stetho.initializeWithDefaults(this);
//                    Stetho.newInitializerBuilder(this)
//                            .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
//                            .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
//                            .build());
        }
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }

    @Override
    public OkHttpClient getOkHttpClient() {
        return  new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
    }

    @Override
    public Gson getGson() {
        return new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
    }

    @Override
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                .baseUrl(HTTP_SWAPI_CO_API)
                .client(getOkHttpClient())
                .addConverterFactory(GsonConverterFactory.create(getGson()))
                .build();
    }

    @Override
    public StarWarsService getStarWarsService() {
        return getRetrofit().create(StarWarsService.class);
    }

    @Override
    public PeopleRepository getPeopleRepository() {
        return new PeopleRepository(new StarWarsSQLiteOpenhelper(this));
    }
}

