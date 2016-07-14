package com.example.user.starwars;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.starwars.mvp.contract.PeopleListContract;

import java.util.List;

import butterknife.ButterKnife;

/**
 * Created by user on 14.07.2016.
 */
public class PeopleFragment extends Fragment implements PeopleListContract.View {

    public static PeopleFragment newInstance() {
        Bundle args = new Bundle();
        PeopleFragment fragment = new PeopleFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_people_list, container, false);
        ButterKnife.bind(this,view);
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onDataLoaded(List<Person> items) {

    }

    @Override
    public void onErrorOccured(@StringRes int errorMessage) {

    }
}
