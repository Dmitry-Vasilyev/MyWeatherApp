package com.example.dimav.myweatherapp.cities;

import com.example.dimav.myweatherapp.BasePresenter;
import com.example.dimav.myweatherapp.BaseView;
import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

import java.util.List;

public interface CitiesContract {
    interface View extends BaseView<Presenter> {
        void setLoadingIndicator(boolean active);

        void showCities(List<CurrentCityWeather> cities);

        void showAddCity();

        void showCityDetails();

        boolean isActive();

    }
    interface Presenter extends BasePresenter {

        void result(int requestCode, int resultCode);

        void loadCities();

        void addNewCity();
    }
}
