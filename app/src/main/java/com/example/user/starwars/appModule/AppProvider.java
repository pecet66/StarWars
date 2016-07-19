package com.example.user.starwars.appModule;

import com.example.user.starwars.databaseModule.people.PeopleRepository;
import com.example.user.starwars.netModule.StarWarsService;
import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;

/**
 * Created by user on 15.07.2016.
 */
public interface AppProvider {

    OkHttpClient getOkHttpClient();

    Gson getGson();

    Retrofit getRetrofit();

    StarWarsService getStarWarsService();

    PeopleRepository getPeopleRepository();

}
