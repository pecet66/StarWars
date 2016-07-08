package com.example.user.starwars;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Path;

/**
 * Created by user on 08.07.2016.
 */
public interface PeopleApiInterfaceService {

    @GET("http://swapi.co/api/people/")

    public void getPeopleContent(Callback<Person> callback);
}
