package com.example.user.starwars.mvp.contract;

import com.example.user.starwars.pojo.Starships;

public interface StarshipsContract {

    interface Presenter {

        void getData();
    }

    interface View {

        void onDataLoaded(Starships item);
    }
}