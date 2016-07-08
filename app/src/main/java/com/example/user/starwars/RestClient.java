package com.example.user.starwars;

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
    private static final String BASE_URL = "http://swapi.co/api/people/";
    private static PeopleApiInterfaceService peopleApiInterfaceService;

    public static PeopleApiInterfaceService getClient() {
        if (peopleApiInterfaceService == null) {
            OkHttpClient okClient = new OkHttpClient();
            okClient.interceptors().add(new Interceptor() {
                @Override
                public Response intercept(Interceptor.Chain chain) throws IOException {
                    Response response = chain.proceed(chain.request());
                    return response;
                }
            });

            Retrofit client = new Retrofit.Builder()
                    .baseUrl("http://swapi.co/api/people/")
                    .client(okClient)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            peopleApiInterfaceService = client.create(PeopleApiInterfaceService.class);
        }
        return peopleApiInterfaceService;
    }
}
