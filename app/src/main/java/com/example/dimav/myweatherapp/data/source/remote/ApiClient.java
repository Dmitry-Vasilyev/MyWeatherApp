package com.example.dimav.myweatherapp.data.source.remote;

import com.example.dimav.myweatherapp.utils.Constants;
import com.google.gson.GsonBuilder;

import okhttp3.OkHttpClient;;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class ApiClient {

    private static WeatherService INSTANCE = null;

    private static final Object lock = new Object();

    private ApiClient() {}

    public static WeatherService getApi() {
        synchronized (lock) {
            if (INSTANCE == null) {
                HttpLoggingInterceptor logging = new HttpLoggingInterceptor();

                logging.setLevel(HttpLoggingInterceptor.Level.BODY);

                OkHttpClient.Builder okHttpBuilder = new OkHttpClient.Builder();
                okHttpBuilder.addInterceptor(logging);

                INSTANCE = new Retrofit.Builder()
                        .baseUrl(Constants.API_BASE_URL)
                        .addConverterFactory(
                                GsonConverterFactory.create(new GsonBuilder()
                                        .setDateFormat("yyyy MMMMMMMMM dd")
                                        .create()))
                        .client(okHttpBuilder.build())
                        .build().create(WeatherService.class);
            }
        }
        return INSTANCE;
    }
}