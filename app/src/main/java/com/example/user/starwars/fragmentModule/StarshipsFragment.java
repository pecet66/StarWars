package com.example.user.starwars.fragmentModule;

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

import com.example.user.starwars.R;
import com.example.user.starwars.appModule.App;
import com.example.user.starwars.mvp.contract.ItemsListContract;
import com.example.user.starwars.mvp.view.StarshipsDetailsActivity;
import com.example.user.starwars.mvp.adapter.StarshipsAdapter;
import com.example.user.starwars.mvp.contract.StarshipsListContract;
import com.example.user.starwars.mvp.presenter.StarshipsListPresenter;
import com.example.user.starwars.pojo.PersonA;
import com.example.user.starwars.pojo.Starships;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by user on 14.07.2016.
 */
public class StarshipsFragment extends Fragment implements ItemsListContract.View, StarshipsAdapter.StarshipsClickListener {

    @BindView(R.id.itemRecyclerView)
    RecyclerView peopleRecycleView;

    @Inject
    public StarshipsListPresenter presenter;

    private StarshipsAdapter adapter;

    public static StarshipsFragment newInstance() {
        Bundle args = new Bundle();
        StarshipsFragment fragment = new StarshipsFragment();
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        DaggerFragmentComponent.builder()
                .netComponent(((App) getActivity().getApplication()).getNetComponent())
                .fragmentModule(new FragmentModule(this))
                .build()
                .inject(this);
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_items_list, container, false);
        ButterKnife.bind(this,view);
        //presenter = new StarshipsListPresenter(this, getContext());
        peopleRecycleView.setLayoutManager(new LinearLayoutManager(getContext()));
        presenter.getData();
        return view;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

    }


    @Override
    public void onDataLoaded(List items) {
        ensureAdapter(items);
    }

    @Override
    public void onErrorOccured(@StringRes int errorMessage) {
        Timber.e("blad");
    }

    private void ensureAdapter(List items) {
        if (adapter == null) {
            adapter = new StarshipsAdapter(items);
            adapter.setOnClickListener(this);
            peopleRecycleView.setAdapter(adapter);
        } else {
            adapter.setItems(items);
        }
    }

    @Override
    public void onPersonClick(Starships person) {
        Intent details = new Intent(getContext(), StarshipsDetailsActivity.class);
        details.putExtra("Starships", person);
        startActivity(details);

    }
}
