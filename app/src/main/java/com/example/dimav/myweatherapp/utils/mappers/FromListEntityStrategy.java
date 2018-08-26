package com.example.dimav.myweatherapp.utils.mappers;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;
import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;


import java.util.ArrayList;
import java.util.List;

public class FromListEntityStrategy
        implements MapperBase.MapperStrategy<List<CurrentCityWeather>,List<CurrentCityWeatherEntity>> {

    MapperBase.MapperStrategy<CurrentCityWeather, CurrentCityWeatherEntity> fromEntity;

    public FromListEntityStrategy(MapperBase.MapperStrategy<CurrentCityWeather,
            CurrentCityWeatherEntity> strategy) {
        fromEntity = strategy;
    }

    @Override
    public List<CurrentCityWeather> execute(List<CurrentCityWeatherEntity> entities) {
        ArrayList<CurrentCityWeather> cities = new ArrayList<>(entities.size());

        for(CurrentCityWeatherEntity item : entities) {
            cities.add(fromEntity.execute(item));
        }
        return cities;
    }
}
