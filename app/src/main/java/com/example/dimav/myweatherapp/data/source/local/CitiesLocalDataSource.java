package com.example.dimav.myweatherapp.data.source.local;

import android.support.annotation.NonNull;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;
import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;
import com.example.dimav.myweatherapp.data.source.CitiesDataSource;
import com.example.dimav.myweatherapp.utils.AppExecutors;
import com.example.dimav.myweatherapp.utils.mappers.FromEntityStrategy;
import com.example.dimav.myweatherapp.utils.mappers.FromListEntityStrategy;
import com.example.dimav.myweatherapp.utils.mappers.Mapper;
import com.example.dimav.myweatherapp.utils.mappers.ToEntityStrategy;

import java.util.List;

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
        Runnable runnable = () -> {
            final List<CurrentCityWeatherEntity> entities = citiesDao.getCities();



            final List<CurrentCityWeather> cities =
                    new Mapper<>
                            (new FromListEntityStrategy(new FromEntityStrategy()))
                            .from(entities);


            appExecutors.mainThreadIO().execute(() -> {
                if(cities.isEmpty()) {
                    callback.onDataNotAvailable();
                } else {
                    callback.onCitiesLoaded(cities);
                }
            });
        };
        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void saveCity(@NonNull final CurrentCityWeather city) {
        Runnable runnable = () -> {
            citiesDao.insertCity(new Mapper<>(new ToEntityStrategy())
            .from(city));
        };

        appExecutors.diskIO().execute(runnable);
    }

    @Override
    public void deleteAllCities() {

    }

    @Override
    public void deleteCity(@NonNull CurrentCityWeather city) {

    }
}
