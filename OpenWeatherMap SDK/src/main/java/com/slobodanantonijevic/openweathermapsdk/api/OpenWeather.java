package com.slobodanantonijevic.openweathermapsdk.api;

import javax.inject.Singleton;

import io.reactivex.schedulers.Schedulers;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.slobodanantonijevic.openweathermapsdk.api.OpenWeatherApi.BASE_URL;

/*
 * A nearly perfect thread-safe singleton
 * At least I hope... :)
 */
@Singleton
public class OpenWeather {

    // Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself
    private static volatile OpenWeatherApi owmRetrofit;

    // Dummy object for synchronization
    private static final Object dummy = new Object();

    public static OpenWeatherApi getOwmRetrofitInstance() {

        OpenWeatherApi instance = owmRetrofit;

        if (instance == null) { // Lazy initialization
            synchronized (dummy) { // Synchronization
                instance = owmRetrofit;
                if (instance == null) { // Extra safety
                    /*
                     * In order to use RetroFit with RxJava we need to add RxJava2CallAdapterFactory
                     * Also in order to make network calls asynchronous we need to create it with Schedulers.io()
                     */
                    owmRetrofit = instance = new Retrofit.Builder()
                            .baseUrl(BASE_URL)
                            .addConverterFactory(GsonConverterFactory.create())
                            .addCallAdapterFactory(RxJava2CallAdapterFactory.createWithScheduler(Schedulers.io()))
                            .build()
                            .create(OpenWeatherApi.class);
                }
            }
        }

        return instance;
    }
}
