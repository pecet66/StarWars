package com.example.user.starwars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @BindView(R.id.peopleRecycleView)
    RecyclerView peopleRecycleView;
    private RestClient restClient;
    private PeopleAdapter peopleAdapter;
    private ArrayList<Person> people = new ArrayList<>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        ArrayList<Person> people = new ArrayList<>();
        restClient = new RestClient();
        Call<ResultSet> resultSetCall= restClient.getPeopleService().getPeopleContent();
        peopleRecycleView.setLayoutManager(new LinearLayoutManager(this));
        final PeopleAdapter peopleAdapter = new PeopleAdapter(people, getLayoutInflater());
        peopleRecycleView.setAdapter(peopleAdapter);

        resultSetCall.enqueue(new Callback<ResultSet>() {
            @Override
            public void onResponse(Call<ResultSet> call, Response<ResultSet> response) {
                if(response.isSuccessful()) {
                    ResultSet resultSet = response.body();
                    Log.i("asd", response.body().getCount());
                    ArrayList<Person> people = new ArrayList<>(response.body().getResults());
                    Log.i("asd", people.size()+"");
                    peopleAdapter.add(people);
                    peopleAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<ResultSet> call, Throwable t) {
                Log.i("asd", t.getMessage());
            }
        });


    }
}
