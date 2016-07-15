package com.example.user.starwars;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.annotation.StringRes;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.user.starwars.mvp.adapter.PlanetsAdapter;
import com.example.user.starwars.mvp.contract.PlanetsListContract;
import com.example.user.starwars.mvp.presenter.PlanetsListPresenter;
import com.example.user.starwars.pojo.Planets;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by user on 14.07.2016.
 */
public class PlanetsFragment extends Fragment implements PlanetsListContract.View, PlanetsAdapter.PlanetsClickListener {

    @BindView(R.id.peopleRecycleView)
    RecyclerView peopleRecycleView;

    private PlanetsListContract.Presenter presenter;
    private PlanetsAdapter adapter;

    public static PlanetsFragment newInstance() {
        Bundle args = new Bundle();
        PlanetsFragment fragment = new PlanetsFragment();
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
        presenter = new PlanetsListPresenter(this, getContext());
        peopleRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.getData();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onDataLoaded(List<Planets> items) {
        ensureAdapter(items);
    }

    @Override
    public void onErrorOccured(@StringRes int errorMessage) {
        Timber.e("blad");
    }

    private void ensureAdapter(List<Planets> items) {
        if (adapter == null) {
            adapter = new PlanetsAdapter(items);
            adapter.setOnClickListener(this);
            peopleRecycleView.setAdapter(adapter);
        } else {
            adapter.setItems(items);
        }
    }

    @Override
    public void onPersonClick(Planets person) {
        Intent details = new Intent(getContext(), PlanetsDetailsActivity.class);
        details.putExtra(Planets.PLANETS_KEY, person);
        startActivity(details);

    }

}
