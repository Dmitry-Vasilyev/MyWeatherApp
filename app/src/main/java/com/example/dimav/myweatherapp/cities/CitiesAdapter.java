package com.example.dimav.myweatherapp.cities;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;


import com.example.dimav.myweatherapp.R;
import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

import java.util.List;

public class CitiesAdapter extends BaseAdapter{

    private List<CurrentCityWeather> cities;

    private CityItemListener<CurrentCityWeather> itemListener;

    public CitiesAdapter(List<CurrentCityWeather> cities,
                         CityItemListener<CurrentCityWeather> itemListener) {
        this.cities = cities;
        this.itemListener = itemListener;
    }

    public void replaceData(List<CurrentCityWeather> cities) {
        this.cities = cities;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return cities.size();
    }

    @Override
    public CurrentCityWeather getItem(int i) {
        return cities.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View rowView = view;

        if(rowView == null) {
            LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());
            rowView = inflater.inflate(R.layout.city_item, viewGroup, false);
        }

        final CurrentCityWeather city = getItem(i);

        TextView countryTv = (TextView) rowView.findViewById(R.id.country_tv);
        countryTv.setText(city.getCountry());

        TextView cityTv = (TextView) rowView.findViewById(R.id.city_tv);
        cityTv.setText(city.getCity());

        TextView dateTv = (TextView) rowView.findViewById(R.id.date_tv);
        dateTv.setText(city.getDate().toString());

        TextView temperatureTv = (TextView) rowView.findViewById(R.id.temperature_tv);
        temperatureTv.setText(String.valueOf(city.getTemperature()));

        TextView unitsTv = (TextView) rowView.findViewById(R.id.temperature_units_tv);
        unitsTv.setText(city.getUnit());

        rowView.setOnClickListener((v) -> {
            itemListener.onCityClick(city);
        });

        return rowView;
    }
}
