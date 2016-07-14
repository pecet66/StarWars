package com.example.user.starwars.mvp.contract;

/**
 * Created by user on 14.07.2016.
 */


import android.support.annotation.StringRes;


import com.example.user.starwars.pojo.Starships;

import java.util.List;

/**
 * Created by user on 13.07.2016.
 */
public interface StarshipsListContract {

    interface Presenter {

        void getData();
    }

    interface View {

        void onDataLoaded(List<Starships> items);

        void onErrorOccured(@StringRes int errorMessage);

    }

}
