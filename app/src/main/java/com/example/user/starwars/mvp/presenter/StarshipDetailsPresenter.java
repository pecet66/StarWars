package com.example.user.starwars.mvp.presenter;

import android.content.Intent;

import com.example.user.starwars.pojo.Starships;
import com.example.user.starwars.mvp.contract.StarshipsContract;

/**
 * Created by user on 13.07.2016.
 */
public class StarshipDetailsPresenter implements StarshipsContract.Presenter {

    Intent intent;
    StarshipsContract.View view;

    public StarshipDetailsPresenter(Intent intent, StarshipsContract.View view) {
        this.intent = intent;
        this.view = view;
    }

    @Override
    public void getData() {
        Starships person = (Starships) intent.getExtras().getSerializable(Starships.STARSHIPS_KEY);
        view.onDataLoaded(person);
    }
}
