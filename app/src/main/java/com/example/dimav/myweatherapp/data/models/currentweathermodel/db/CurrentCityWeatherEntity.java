package com.example.dimav.myweatherapp.data.models.currentweathermodel.db;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

import java.util.Objects;
import java.util.Random;

/**
 * Immutable model class for CurrentCityWeather
 */
@Entity(tableName = "Cities")
public final class CurrentCityWeatherEntity {
    @PrimaryKey
    @ColumnInfo(name = "entryid")
    private final int id;
    private final String country;
    private final String city;
    private final Long date;
    private final int temperature;
    private final String unit;

    public CurrentCityWeatherEntity(int id, String country, String city,
                                    long date, int temperature, String unit) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.unit = unit;
    }

    @Ignore
    public CurrentCityWeatherEntity() {
        Random random = new Random();
        this.id = random.nextInt();
        this.country = String.valueOf(random.nextInt(1000000));
        this.city = String.valueOf(random.nextInt(1000000));
        this.date = random.nextLong();
        this.temperature = random.nextInt(100);
        this.unit = String.valueOf(random.nextInt(100));
    }

    public int getId() {
        return id;
    }

    public String getCountry() {
        return country;
    }

    public String getCity() {
        return city;
    }

    public Long getDate() {
        return date;
    }

    public int getTemperature() {
        return temperature;
    }

    public String getUnit() {
        return unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCityWeatherEntity that = (CurrentCityWeatherEntity) o;
        return temperature == that.temperature &&
                Objects.equals(id, that.id) &&
                Objects.equals(country, that.country) &&
                Objects.equals(city, that.city) &&
                Objects.equals(date, that.date) &&
                Objects.equals(unit, that.unit);
    }

    @Override
    public int hashCode() {

        return Objects.hash(id, country, city, date, temperature, unit);
    }

    @Override
    public String toString() {
        return "CurrentCityWeather{" +
                "id='" + id + '\'' +
                ", country='" + country + '\'' +
                ", city='" + city + '\'' +
                ", date=" + date +
                ", temperature=" + temperature +
                ", unit='" + unit + '\'' +
                '}';
    }
}
