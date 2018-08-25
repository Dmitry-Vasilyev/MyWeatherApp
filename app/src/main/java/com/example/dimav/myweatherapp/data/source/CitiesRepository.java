package com.example.dimav.myweatherapp.data.source;

import android.support.annotation.NonNull;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

public class CitiesRepository implements CitiesDataSource {

    private static CitiesRepository INSTANCE = null;

    @Override
    public void getCities(@NonNull LoadCitiesCallback callback) {

    }

    @Override
    public void saveCity(@NonNull CurrentCityWeather city) {

    }

    @Override
    public void deleteAllCities() {

    }

    @Override
    public void deleteCity(@NonNull CurrentCityWeather city) {

    }
}
