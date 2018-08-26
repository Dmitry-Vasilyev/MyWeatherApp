package com.example.dimav.myweatherapp.utils.mappers;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;
import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;

public class ToEntityStrategy implements
        MapperBase.MapperStrategy<CurrentCityWeatherEntity, CurrentCityWeather> {
    @Override
    public CurrentCityWeatherEntity execute(CurrentCityWeather city) {
        CurrentCityWeatherEntity entity = new CurrentCityWeatherEntity(
                city.getId(),
                city.getCity(),
                city.getCountry(),
                city.getDate().getTime(),
                city.getTemperature(),
                city.getUnit()
        );
        return entity;
    }
}
