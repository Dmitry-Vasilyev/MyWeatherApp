package com.example.dimav.myweatherapp.data.models;

import android.arch.core.util.Function;

import java.util.Date;
import java.util.Objects;
import java.util.Random;

public class CurrentCityWeather {
    private int id;
    private String country;
    private String city;
    private Date date;
    private int temperature;
    private String unit;




    public CurrentCityWeather(int id, String country, String city,
                              Date date, int temperature, String unit) {
        this.id = id;
        this.country = country;
        this.city = city;
        this.date = date;
        this.temperature = temperature;
        this.unit = unit;
    }

    public CurrentCityWeather() {
        Random random = new Random();
        this.id = random.nextInt();
        this.country = String.valueOf(random.nextInt(3));
        this.city = String.valueOf(random.nextInt(3));
        this.date = new Date(random.nextLong());
        this.temperature = random.nextInt(3);
        this.unit = String.valueOf(random.nextInt(3));
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public int getTemperature() {
        return temperature;
    }

    public void setTemperature(int temperature) {
        this.temperature = temperature;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CurrentCityWeather that = (CurrentCityWeather) o;
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
