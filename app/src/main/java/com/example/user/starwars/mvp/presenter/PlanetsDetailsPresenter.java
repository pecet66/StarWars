package com.example.user.starwars.mvp.presenter;

import android.content.Intent;

import com.example.user.starwars.pojo.Planets;
import com.example.user.starwars.mvp.contract.PlanetsContract;

/**
 * Created by user on 13.07.2016.
 */
public class PlanetsDetailsPresenter implements PlanetsContract.Presenter {

    Intent intent;
    PlanetsContract.View view;

    public PlanetsDetailsPresenter(Intent intent, PlanetsContract.View view) {
        this.intent = intent;
        this.view = view;
    }

    @Override
    public void getData() {
        Planets person = (Planets) intent.getExtras().getSerializable(Planets.PLANETS_KEY);
        view.onDataLoaded(person);
    }
}
