package com.example.user.starwars.fragmentModule;



import com.example.user.starwars.mvp.contract.ItemsListContract;

import com.example.user.starwars.mvp.presenter.PlanetsListPresenter;
import com.example.user.starwars.pojo.Planets;
import com.example.user.starwars.util.CustomScope;

import dagger.Module;
import dagger.Provides;

/**
 * Created by Aditya on 11-May-16.
 */
@Module
public class FragmentModule {

    private final PlanetsListPresenter mView;


    public FragmentModule(PlanetsListPresenter mView) {
        this.mView = mView;
    }

    @Provides
    @CustomScope
    public PlanetsListPresenter providesMainScreenContractView() {
        return mView;
    }

//    @Provides
//    @CustomScope
//    PlanetsListContract.Presenter providesPresenter(Retrofit retrofit) {
//        return new PlanetsListPresenter(retrofit, mView);
//    }
}
