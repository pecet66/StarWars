package com.example.user.starwars.mvp.presenter;

import android.content.Intent;

import com.example.user.starwars.pojo.Person;
import com.example.user.starwars.mvp.contract.DetailsContract;

/**
 * Created by user on 13.07.2016.
 */
public class PeopleDetailsPresenter implements DetailsContract.Presenter {

    Intent intent;
    DetailsContract.View view;

    public PeopleDetailsPresenter(Intent intent, DetailsContract.View view) {
        this.intent = intent;
        this.view = view;
    }

    @Override
    public void getData() {
        Person person = (Person) intent.getExtras().getSerializable(Person.PERSON_KEY);
        view.onDataLoaded(person);
    }
}
