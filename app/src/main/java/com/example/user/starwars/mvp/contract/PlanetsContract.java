package com.example.user.starwars.mvp.contract;

import com.example.user.starwars.pojo.Planets;

/**
 * Created by user on 13.07.2016.
 */
public interface PlanetsContract {

    interface Presenter {

        void getData();
    }

    interface View {

        void onDataLoaded(Planets item);
    }
}