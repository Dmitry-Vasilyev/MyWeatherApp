package com.example.dimav.myweatherapp.data.source.remote;

import com.example.dimav.myweatherapp.data.models.currentweathermodel.remote.CurrentWeatherRemote;
import com.example.dimav.myweatherapp.utils.Constants;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET(Constants.API_GROUP)
    Call<CurrentWeatherRemote> getWeatherForCityGroups(
            @Query("id") String citiesIds, @Query("units") String units,
            @Query("appid") String appid);
}