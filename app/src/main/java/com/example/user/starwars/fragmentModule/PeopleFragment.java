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

import com.example.user.starwars.appModule.App;
import com.example.user.starwars.mvp.contract.ItemsListContract;
import com.example.user.starwars.mvp.view.PeopleDetailsActivity;
import com.example.user.starwars.R;
import com.example.user.starwars.mvp.adapter.PeopleAdapter;
import com.example.user.starwars.mvp.contract.PeopleListContract;
import com.example.user.starwars.mvp.presenter.PeopleListPresenter;
import com.example.user.starwars.pojo.Person;

import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import timber.log.Timber;

/**
 * Created by user on 14.07.2016.
 */
public class PeopleFragment extends Fragment implements ItemsListContract.View, PeopleAdapter.PeopleClickListener {

    @BindView(R.id.itemRecyclerView)
    RecyclerView itemRecyclerView;

    //public PeopleListContract.Presenter presenter;
    @Inject
    public PeopleListPresenter presenter;

    public PeopleAdapter adapter;

    public static PeopleFragment newInstance() {
        Bundle args = new Bundle();
        PeopleFragment fragment = new PeopleFragment();
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
        //presenter = new PeopleListPresenter(this, getContext());
        itemRecyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
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

    private void ensureAdapter(List<Person> items) {
        if (adapter == null) {
            adapter = new PeopleAdapter(items);
            adapter.setOnClickListener(this);
            itemRecyclerView.setAdapter(adapter);
        } else {
            adapter.setItems(items);
        }
    }

    @Override
    public void onPersonClick(Person person) {
        Intent details = new Intent(getContext(), PeopleDetailsActivity.class);
        details.putExtra("Person", person);
        startActivity(details);

    }
}
