package com.example.dimav.myweatherapp.utils.mappers;

import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;
import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;

import java.util.Date;

public class FromEntityStrategy implements
        MapperBase.MapperStrategy<CurrentCityWeather, CurrentCityWeatherEntity>{


    @Override
    public CurrentCityWeather execute(CurrentCityWeatherEntity item) {
        CurrentCityWeather city = new CurrentCityWeather();
        city.setId(item.getId());
        city.setCity(item.getCity());
        city.setCountry(item.getCountry());
        city.setDate(new Date(item.getDate()));
        city.setTemperature(item.getTemperature());
        city.setUnit(item.getUnit());

        return city;
    }
}
