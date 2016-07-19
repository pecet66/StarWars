package com.example.user.starwars.mvp.presenter;

import android.content.Context;

import com.example.user.starwars.appModule.AppProvider;
import com.example.user.starwars.pojo.Person;
import com.example.user.starwars.R;
import com.example.user.starwars.netModule.ResultSet;
import com.example.user.starwars.netModule.StarWarsService;
import com.example.user.starwars.databaseModule.people.PeopleRepository;
import com.example.user.starwars.databaseModule.people.specification.PeopleSpecification;
import com.example.user.starwars.mvp.contract.PeopleListContract;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by user on 13.07.2016.
 */
public class PeopleListPresenter implements PeopleListContract.Presenter {

    private final PeopleListContract.View view;
    private final StarWarsService service;
    private final PeopleRepository database;


    public PeopleListPresenter(PeopleListContract.View view, Context context) {
        this.view = view;
        AppProvider appProvider = (AppProvider) context.getApplicationContext();
        service = appProvider.getStarWarsService();
        database =  appProvider.getPeopleRepository();

    }

    @Override
    public void getData() {
        service.listPeople().enqueue(new Callback<ResultSet<Person>>() {
            @Override
            public void onResponse(Call<ResultSet<Person>> call, Response<ResultSet<Person>> response) {
                if(response.isSuccessful()){
                    Timber.i(response.body().getCount());
                    List<Person> people = new ArrayList<>(response.body().getResults());
                    Timber.i(people.size()+"");
                    database.add(people);
                    view.onDataLoaded(people);
                }
            }

            @Override
            public void onFailure(Call<ResultSet<Person>> call, Throwable t) {
                Timber.i("Bład komunikacji pobieram dane z bazy");
                if (t instanceof IOException) {
                    List<Person> people = database.query(new PeopleSpecification());
                    if(people.isEmpty()){
                        view.onErrorOccured(R.string.error_list_empty);
                    }
                    view.onDataLoaded(people);
                }
            }
        });

    }
}
