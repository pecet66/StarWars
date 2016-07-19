package com.example.user.starwars.mvp.presenter;

import com.example.user.starwars.mvp.contract.ItemsListContract;
import com.example.user.starwars.pojo.Planets;
import com.example.user.starwars.netModule.ResultSet;
import com.example.user.starwars.netModule.StarWarsService;
import com.example.user.starwars.mvp.contract.PlanetsListContract;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import timber.log.Timber;

/**
 * Created by user on 13.07.2016.
 */
public class PlanetsListPresenter implements ItemsListContract.Presenter {

    public static final String HTTP_SWAPI_CO_API = "http://swapi.co/api/";


    private final PlanetsListContract.View view;
    private final StarWarsService service;

    //PlanetsListContract.View mView;
    //private final PeopleRepository database;



    /*public PlanetsListPresenter(PlanetsListContract.View view, Context context) {
        this.view = view;
        OkHttpClient client = new OkHttpClient.Builder()
                .addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY))
                .build();
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(HTTP_SWAPI_CO_API)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();
        service = retrofit.create(StarWarsService.class);
        //database =  new PeopleRepository(new StarWarsSQLiteOpenhelper(context));
    }*/
    @Inject
    public PlanetsListPresenter(StarWarsService service, PlanetsListContract.View mView) {

        this.view = mView;
       this.service = service;
    }

    /*@Override
    public void getData() {
        retrofit.create(StarWarsService.class).listPlanets().subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .unsubscribeOn(Schedulers.io())
                .subscribe(new Observer<List<Planets>>() {
                    @Override
                    public void onCompleted() {
                        view.showComplete();
                    }

                    @Override
                    public void onError(Throwable e) {
                        mView.showError(e.getMessage());
                    }

                    @Override
                    public void onNext(List<Post> posts) {
                        mView.showPosts(posts);
                    }
                });
    }*/


    @Override
    public void getData() {
        service.listPlanets().enqueue(new Callback<ResultSet<Planets>>() {
            @Override
            public void onResponse(Call<ResultSet<Planets>> call, Response<ResultSet<Planets>> response) {
                if(response.isSuccessful()){
                    Timber.i(response.body().getCount());
                    List<Planets> items = new ArrayList<>(response.body().getResults());
                    Timber.i(items.size()+"");
                    //database.add(people);
                    view.onDataLoaded(items);
                }
            }

            @Override
            public void onFailure(Call<ResultSet<Planets>> call, Throwable t) {
                /*Timber.i("Bład komunikacji pobieram dane z bazy");
                if (t instanceof IOException) {
                    List<Person> people = database.query(new PeopleSpecification());
                    if(people.isEmpty()){
                        view.onErrorOccured(R.string.error_list_empty);
                    }
                    view.onDataLoaded(people);
                }*/
            }
        });

    }
}
