package com.example.dimav.myweatherapp.cities;

import android.widget.Toast;

import java.util.concurrent.TimeUnit;

public class CitiesPresenter implements CitiesContract.Presenter {

    private final CitiesContract.View citiesView;

    private boolean firstLoad = true;


    public CitiesPresenter(CitiesContract.View citiesView) {
        this.citiesView = citiesView;

        citiesView.setPresenter(this);
    }

    @Override
    public void start() {
        loadCities();
    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadCities() {
        citiesView.setLoadingIndicator(true);

        Runnable runnable = () -> {
            try {
                TimeUnit.SECONDS.sleep(3);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            citiesView.setLoadingIndicator(false);
        };

        new Thread(runnable).start();
    }



    @Override
    public void addNewCity() {
        citiesView.showAddCity();
    }
}
