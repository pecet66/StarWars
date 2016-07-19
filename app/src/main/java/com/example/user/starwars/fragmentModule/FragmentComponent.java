package com.example.user.starwars.fragmentModule;


import com.example.user.starwars.netModule.NetComponent;
import com.example.user.starwars.util.CustomScope;

import dagger.Component;

/**
 * Created by Aditya on 11-May-16.
 */
@CustomScope
@Component(dependencies = NetComponent.class, modules = FragmentModule.class)
public interface FragmentComponent {

//    void inject(MainActivity activity);

    void inject(PlanetsFragment fragment);
    void inject(PeopleFragment fragment);
}
