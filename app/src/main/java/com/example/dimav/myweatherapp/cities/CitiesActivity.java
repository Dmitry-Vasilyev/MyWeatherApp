package com.example.dimav.myweatherapp.cities;

import android.os.Handler;
import android.os.Looper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.example.dimav.myweatherapp.data.models.currentweathermodel.db.CurrentCityWeatherEntity;
import com.example.dimav.myweatherapp.data.models.currentweathermodel.remote.CurrentWeatherRemote;
import com.example.dimav.myweatherapp.data.source.local.CurrentCityWeatherDao;
import com.example.dimav.myweatherapp.data.source.local.ToDoDatabase;
import com.example.dimav.myweatherapp.data.source.remote.ApiClient;
import com.example.dimav.myweatherapp.data.source.remote.WeatherService;
import com.example.dimav.myweatherapp.utils.ActivityUtils;
import com.example.dimav.myweatherapp.R;
import com.example.dimav.myweatherapp.utils.Constants;

import java.util.ArrayList;

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
        presenter = new CitiesPresenter(citiesFragment);





        WeatherService service = ApiClient.getApi();

        service.getWeatherForCityGroups("524901,703448,2643743",
                Constants.API_METRIC, Constants.API_KEY).enqueue(new Callback<CurrentWeatherRemote>() {
            @Override
            public void onResponse(Call<CurrentWeatherRemote> call, Response<CurrentWeatherRemote> response) {
                Log.d("My", response.code()+"");
                Toast.makeText(getApplicationContext(),"From onResponse", Toast.LENGTH_LONG).show();
                if(response.isSuccessful()) {
                    CurrentWeatherRemote result = response.body();
                    Log.d("My", result.getCityCur().get(0).getName());
                }
            }

            @Override
            public void onFailure(Call<CurrentWeatherRemote> call, Throwable t) {
                t.printStackTrace();
                Log.d("My", "from onFailure");
                Log.d("My", t.getMessage());
                Toast.makeText(getApplicationContext(),"Error loading from API", Toast.LENGTH_LONG).show();
            }
        });

        ToDoDatabase db = ToDoDatabase.getInstance(this);
        CurrentCityWeatherDao dao = db.currentCityWeatherDao();


        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                ArrayList<CurrentCityWeatherEntity> list = new ArrayList<>(dao.getCities());

                if(list.size() == 0) {
                    dao.insertCity(new CurrentCityWeatherEntity());
                    dao.insertCity(new CurrentCityWeatherEntity());
                    dao.insertCity(new CurrentCityWeatherEntity());

                    list = new ArrayList<>(dao.getCities());
                }
                Log.d("My", "Cities in DB: " + list.size());
                for(CurrentCityWeatherEntity item: list) {
                    Log.d("My", item.toString());
                }
            }
        };

        Thread thread = new Thread(runnable);
        thread.start();
    }


}
