package com.example.dimav.myweatherapp.data.source.local;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;

@Database(entities = {CurrentCityWeatherEntity.class}, version = 1)
public abstract class ToDoDatabase extends RoomDatabase {

    private static ToDoDatabase INSTANCE;

    public abstract CurrentCityWeatherDao currentCityWeatherDao();

    private static final Object lock = new Object();

    public static ToDoDatabase getInstance(Context context) {
        synchronized (lock) {
            if(INSTANCE == null) {
                INSTANCE = Room.databaseBuilder(context.getApplicationContext(),
                        ToDoDatabase.class, "Cities.db")
                        .build();
            }
            return INSTANCE;
        }
    }
}