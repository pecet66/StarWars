package com.example.user.starwars.mvp.view;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.example.user.starwars.R;
import com.example.user.starwars.mvp.contract.PlanetsContract;
import com.example.user.starwars.mvp.presenter.PlanetsDetailsPresenter;
import com.example.user.starwars.pojo.Planets;

import butterknife.BindView;
import butterknife.ButterKnife;

public class PlanetsDetailsActivity extends AppCompatActivity implements PlanetsContract.View {

    @BindView(R.id.name_planet)
    TextView name_planet;
    @BindView(R.id.terrain)
    TextView terrain;
    @BindView(R.id.surface)
    TextView surface;
    @BindView(R.id.created)
    TextView created;
    @BindView(R.id.climate)
    TextView climate;
    @BindView(R.id.gravity)
    TextView gravity;



    PlanetsContract.Presenter presenter;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_planets_details);
        ButterKnife.bind(this);
        presenter = new PlanetsDetailsPresenter(getIntent(), this);
        presenter.getData();
    }

    @Override
    public void onDataLoaded(Planets item) {
        name_planet.setText(item.getName());
        terrain.setText(item.getTerrain());
        surface.setText(item.getSurface_water());
        created.setText(item.getCreated());
        climate.setText(item.getClimate());
        gravity.setText(item.getGravity() );
    }


}
