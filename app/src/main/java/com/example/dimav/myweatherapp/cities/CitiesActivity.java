package com.example.dimav.myweatherapp.cities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.dimav.myweatherapp.ActivityUtils;
import com.example.dimav.myweatherapp.R;

public class CitiesActivity extends AppCompatActivity {

    private CitiesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities_act);

        CitiesFragment citiesFragment =
                (CitiesFragment)getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if(citiesFragment == null) {
            //Create fragment
            citiesFragment = CitiesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), citiesFragment,
                    R.id.contentFrame);
        }
        //Create the presenter
        presenter = new CitiesPresenter();
    }


}
