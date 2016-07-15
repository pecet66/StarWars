package com.example.user.starwars;

import com.example.user.starwars.pojo.Person;
import com.example.user.starwars.pojo.Planets;
import com.example.user.starwars.pojo.Starships;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

/**
 * Created by user on 11.07.2016.
 */
public interface StarWarsService {

    @GET("people/")
    Call<ResultSet<Person>> listPeople();

    @GET("planets/")
    Call<ResultSet<Planets>> listPlanets();

    @GET("starships/")
    Call<ResultSet<Starships>> listStarships();


}
