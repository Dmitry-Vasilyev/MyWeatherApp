package com.example.dimav.myweatherapp.cities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dimav.myweatherapp.R;
import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

import java.util.ArrayList;
import java.util.Arrays;

public class CitiesFragment extends Fragment implements CitiesContract.View{

    private CitiesContract.Presenter presenter;

    private CitiesAdapter citiesAdapter;

    public CitiesFragment() {

    }

    public static CitiesFragment newInstance() {
        return new CitiesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        citiesAdapter = new CitiesAdapter(new ArrayList<CurrentCityWeather>(0),
                itemListener);
        ArrayList<CurrentCityWeather> arrayList = new ArrayList<>();
        arrayList.add(new CurrentCityWeather());
        arrayList.add(new CurrentCityWeather());
        arrayList.add(new CurrentCityWeather());
        arrayList.add(new CurrentCityWeather());
        citiesAdapter.replaceData(arrayList);
    }

    @Override
    public void setPresenter(CitiesContract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.cities_frag, container, false);

        ListView listView = (ListView) root.findViewById(R.id.cities_list);
        listView.setAdapter(citiesAdapter);

        return root;
    }

    CityItemListener<CurrentCityWeather> itemListener = new CityItemListener<CurrentCityWeather>() {
        @Override
        public void onCityClick(CurrentCityWeather city) {
            Toast.makeText(getContext(), city.getCity(), Toast.LENGTH_LONG).show();
        }
    };

}
