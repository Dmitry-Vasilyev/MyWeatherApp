package com.example.dimav.myweatherapp.cities;

public class CitiesPresenter implements CitiesContract.Presenter {

    private final CitiesContract.View citiesView;


    public CitiesPresenter(CitiesContract.View citiesView) {
        this.citiesView = citiesView;

        citiesView.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void result(int requestCode, int resultCode) {

    }

    @Override
    public void loadCities() {

    }

    @Override
    public void addNewCity() {

    }
}
