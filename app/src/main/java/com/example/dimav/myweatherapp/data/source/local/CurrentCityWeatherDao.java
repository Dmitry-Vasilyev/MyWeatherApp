package com.example.dimav.myweatherapp.data.source.local;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;

import java.util.List;

@Dao
public interface CurrentCityWeatherDao {
    /**
     * Select all cities from the City table.
     * @return all cities.
     */
    @Query("SELECT * FROM Cities")
    List<CurrentCityWeatherEntity> getCities();

    /**
     * Insert city in the database. If the city already exists, delete it.
     *
     * @param city the city that be inserted.
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertCity(CurrentCityWeatherEntity city);

    /**
     * Update a city.
     *
     * @param city city to be updated.
     * @return the number of cities updated. This should always be 1.
     */
    @Update
    int updateCity(CurrentCityWeatherEntity city);

    /**
     * Delete a city by id.
     *
     * @return the number of cities deleted. This should always be 1.
     */
    @Query("DELETE FROM Cities WHERE entryid = :cityId")
    int deleteCityById(int cityId);

    /**
     * Delete all cities
     */
    @Query("DELETE FROM Cities")
    void deleteCity();
}