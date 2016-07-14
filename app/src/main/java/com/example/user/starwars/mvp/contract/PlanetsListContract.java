package com.example.user.starwars.mvp.contract;

import android.support.annotation.StringRes;

import com.example.user.starwars.pojo.Planets;

import java.util.List;


/**
 * Created by user on 13.07.2016.
 */
public interface PlanetsListContract {

    interface Presenter {

        void getData();
    }

    interface View {

        void onDataLoaded(List<Planets> items);

        void onErrorOccured(@StringRes int errorMessage);

    }

}
