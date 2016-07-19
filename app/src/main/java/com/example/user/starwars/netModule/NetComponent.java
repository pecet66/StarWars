package com.example.user.starwars.netModule;

import android.content.SharedPreferences;

import com.example.user.starwars.appModule.AppModule;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

/**
 * Created by user on 18.07.2016.
 */
@Singleton
@Component(modules = {AppModule.class, NetModule.class})
public interface NetComponent {

    Retrofit retrofit();

    StarWarsService service();

    @Named("app")
    SharedPreferences preferences();

    @Named("user")
    SharedPreferences preferences2();
}
