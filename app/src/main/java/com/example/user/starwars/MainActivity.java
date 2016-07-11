package com.example.user.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.peopleRecycleView)
    RecyclerView peopleRecycleView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        //peopleRecycleView.setLayoutManager(new LinearLayoutManager(this));
        configViews();

    }

    private void configViews() {
        peopleRecycleView = (RecyclerView)this.findViewById(R.id.peopleRecycleView);
        peopleRecycleView.setHasFixedSize(true);
        peopleRecycleView.setRecycledViewPool(new RecyclerView.RecycledViewPool());
        peopleRecycleView.setAdapter(new PeopleAdapter());
    }
}
