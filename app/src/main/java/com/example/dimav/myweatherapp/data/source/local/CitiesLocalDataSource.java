package com.example.dimav.myweatherapp.data.source.local;

import android.support.annotation.NonNull;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;
import com.example.dimav.myweatherapp.data.source.CitiesDataSource;
import com.example.dimav.myweatherapp.utils.AppExecutors;

public class CitiesLocalDataSource implements CitiesDataSource {

    private static volatile CitiesLocalDataSource INSTANCE;

    private CurrentCityWeatherDao citiesDao;

    private AppExecutors appExecutors;

    private CitiesLocalDataSource(@NonNull CurrentCityWeatherDao citiesDao,
                                  @NonNull AppExecutors appExecutors) {
        this.citiesDao = citiesDao;
        this.appExecutors = appExecutors;
    }

    public static CitiesLocalDataSource getInstance(@NonNull AppExecutors appExecutors,
                                                    @NonNull CurrentCityWeatherDao citiesDao) {
        if(INSTANCE == null) {
            synchronized (CitiesLocalDataSource.class) {
                if(INSTANCE == null) {
                    INSTANCE = new CitiesLocalDataSource(citiesDao, appExecutors);
                }
            }
        }
        return INSTANCE;
    }



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
