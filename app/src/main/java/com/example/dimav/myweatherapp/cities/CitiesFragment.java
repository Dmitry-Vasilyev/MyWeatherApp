package com.example.dimav.myweatherapp.cities;


import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.content.ContextCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import com.example.dimav.myweatherapp.R;
import com.example.dimav.myweatherapp.data.models.CurrentCityWeather;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

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
        Random rnd = new Random();
        arrayList.add(new CurrentCityWeather(rnd));
        arrayList.add(new CurrentCityWeather(rnd));
        arrayList.add(new CurrentCityWeather(rnd));
        arrayList.add(new CurrentCityWeather(rnd));
        citiesAdapter.replaceData(arrayList);
    }

    @Override
    public void onResume() {
        super.onResume();
        presenter.start();
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


        FloatingActionButton fab =
                (FloatingActionButton) getActivity().findViewById(R.id.fab_add_city);

        fab.setImageResource(R.drawable.ic_add);

        fab.setOnClickListener(view -> presenter.addNewCity());

        final SwipeRefreshLayout swipeRefreshLayout =
                (SwipeRefreshLayout) root.findViewById(R.id.refresh_layout);
        swipeRefreshLayout.setColorSchemeColors(
                ContextCompat.getColor(getActivity(), R.color.colorPrimary),
                ContextCompat.getColor(getActivity(), R.color.colorAccent),
                ContextCompat.getColor(getActivity(), R.color.colorPrimaryDark)
        );

        swipeRefreshLayout.setOnRefreshListener(() -> presenter.loadCities());

        return root;
    }



    CityItemListener<CurrentCityWeather> itemListener =
            this::showCityDetails;

    @Override
    public void setLoadingIndicator(boolean active) {
        if(getView() == null) {
            return;
        }

        final SwipeRefreshLayout srl =
                (SwipeRefreshLayout) getView().findViewById(R.id.refresh_layout);

        srl.post(() -> srl.setRefreshing(active));
    }

    @Override
    public void showCities(List<CurrentCityWeather> cities) {
        citiesAdapter.replaceData(cities);
    }

    @Override
    public void showAddCity() {
        Toast.makeText(getContext(), "ShowAddCity()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void showCityDetails(CurrentCityWeather city) {
        Toast.makeText(getContext(), city.getCity(), Toast.LENGTH_LONG).show();
    }

    @Override
    public boolean isActive() {
        return isAdded();
    }
}
