package com.example.user.starwars.appModule;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import javax.inject.Named;
import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

/**
 * Created by user on 18.07.2016.
 */
@Module
public class AppModule {
    Application mApplicaition;

    public AppModule(Application mApplicaition) {
        this.mApplicaition = mApplicaition;
    }

    @Provides
    @Singleton
    public Application provideApplication() {
        return mApplicaition;
    }

    @Provides
    @Singleton
    public Context providesContext() {
        return mApplicaition.getApplicationContext();
    }

    @Provides
    @Singleton
    @Named("user")
    public SharedPreferences providesUserSharedPreferences(Context context) {
        return context.getSharedPreferences("user_preferences", Context.MODE_PRIVATE);
    }

    @Provides
    @Singleton
    @Named("app")
    public SharedPreferences providesAppSharedPreferences(Context context) {
        return context.getSharedPreferences("app_preferences", Context.MODE_PRIVATE);
    }

}
