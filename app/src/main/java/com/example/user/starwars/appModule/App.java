package com.example.user.starwars.appModule;

import android.app.Application;

import com.example.user.starwars.BuildConfig;
import com.example.user.starwars.netModule.DaggerNetComponent;
import com.example.user.starwars.netModule.NetComponent;
import com.example.user.starwars.netModule.NetModule;
import com.facebook.stetho.Stetho;

import timber.log.Timber;

/**
 * Created by user on 11.07.2016.
 */
public class App extends Application {

    private NetComponent mNetComponent;


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

        mNetComponent = DaggerNetComponent.builder()
                .appModule(new AppModule(this))
                .netModule(new NetModule(HTTP_SWAPI_CO_API))
                .build();
    }

    public NetComponent getNetComponent() {return mNetComponent;}
}

