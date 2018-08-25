package com.example.dimav.myweatherapp.data.source;

import android.support.annotation.NonNull;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

import java.util.List;

public interface CitiesDataSource {
    interface LoadCitiesCallback {

        void onCitiesLoaded(List<CurrentCityWeather> cities);

        void onDataNotAvailable();
    }

    void getCities(@NonNull LoadCitiesCallback callback);

    void saveCity(@NonNull CurrentCityWeather city);

    void deleteAllCities();

    void deleteCity(@NonNull CurrentCityWeather city);
}
