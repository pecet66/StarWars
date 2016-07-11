package com.example.user.starwars;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;

import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by user on 08.07.2016.
 */
public class RestClient {
    private static final String BASE_URL = "http://swapi.co/api/";
    private static PeopleService peopleService;

    protected PeopleService getPeopleService() {
        if (peopleService == null) {

            Gson gson = new GsonBuilder()
                    .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                    .create();

            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();

            peopleService = retrofit.create(PeopleService.class);

        }
        return peopleService;
    }
}
