package com.example.dimav.myweatherapp.cities;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dimav.myweatherapp.data.models.weathermodel.CurrentWeatherModel;
import com.example.dimav.myweatherapp.data.source.remote.ApiClient;
import com.example.dimav.myweatherapp.data.source.remote.WeatherService;
import com.example.dimav.myweatherapp.utils.ActivityUtils;
import com.example.dimav.myweatherapp.R;
import com.example.dimav.myweatherapp.utils.Constants;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CitiesActivity extends AppCompatActivity {

    private CitiesPresenter presenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cities_act);

        CitiesFragment citiesFragment =
                (CitiesFragment)getSupportFragmentManager().findFragmentById(R.id.contentFrame);

        if(citiesFragment == null) {
            //Create fragment
            citiesFragment = CitiesFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), citiesFragment,
                    R.id.contentFrame);
        }
        //Create the presenter
        presenter = new CitiesPresenter();



        WeatherService service = ApiClient.getApi();

        Log.d("My", Boolean.toString(ActivityUtils.hasConnection(getApplicationContext())));
        service.getWeatherForCityGroups("524901,703448,2643743",
                Constants.API_METRIC, Constants.API_KEY).enqueue(new Callback<CurrentWeatherModel>() {
            @Override
            public void onResponse(Call<CurrentWeatherModel> call, Response<CurrentWeatherModel> response) {
                Log.d("My", response.code()+"");
                Toast.makeText(getApplicationContext(),"From onResponse", Toast.LENGTH_LONG).show();
                if(response.isSuccessful()) {
                    CurrentWeatherModel result = response.body();
                    Log.d("My", result.getList().get(0).getName());


                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherModel> call, Throwable t) {
                t.printStackTrace();
                Log.d("My", t.getMessage());
                Toast.makeText(getApplicationContext(),"Error loading from API", Toast.LENGTH_LONG).show();
            }
        });
    }


}
