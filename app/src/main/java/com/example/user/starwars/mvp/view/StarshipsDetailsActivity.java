package com.example.user.starwars.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.starwars.R;
import com.example.user.starwars.mvp.contract.StarshipsContract;
import com.example.user.starwars.mvp.presenter.StarshipDetailsPresenter;
import com.example.user.starwars.pojo.Starships;

import butterknife.BindView;
import butterknife.ButterKnife;

public class StarshipsDetailsActivity extends AppCompatActivity implements StarshipsContract.View {

    @BindView(R.id.name_starship)
    TextView name_starship;
    @BindView(R.id.model)
    TextView model;
    @BindView(R.id.manufacturer)
    TextView manufacturer;
    @BindView(R.id.max_speed)
    TextView max_speed;
    @BindView(R.id.length)
    TextView length;



    StarshipsContract.Presenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starships_details);
        ButterKnife.bind(this);
        presenter = new StarshipDetailsPresenter(getIntent(), this);
        presenter.getData();
    }

    @Override
    public void onDataLoaded(Starships item) {
        name_starship.setText(item.getName());
        model.setText(item.getModel());
        manufacturer.setText(item.getManufacturer());
        max_speed.setText(item.getMax_atmosphering_speed());
        length.setText(item.getLength());
    }
}
