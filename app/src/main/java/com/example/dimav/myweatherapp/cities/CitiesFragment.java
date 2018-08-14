package com.example.dimav.myweatherapp.cities;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;

public class CitiesFragment extends Fragment implements CitiesContract.View{

    private CitiesContract.Presenter presenter;

    public CitiesFragment() {

    }

    public static CitiesFragment newInstance() {
        return new CitiesFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setPresenter(CitiesContract.Presenter presenter) {
        this.presenter = presenter;
    }
}
