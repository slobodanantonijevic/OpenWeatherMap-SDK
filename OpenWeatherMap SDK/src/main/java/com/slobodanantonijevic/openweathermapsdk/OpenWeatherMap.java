package com.slobodanantonijevic.openweathermapsdk;

import android.util.Log;

import com.slobodanantonijevic.openweathermapsdk.api.OpenWeather;
import com.slobodanantonijevic.openweathermapsdk.api.OpenWeatherApi;
import com.slobodanantonijevic.openweathermapsdk.model.CurrentWeather;
import com.slobodanantonijevic.openweathermapsdk.model.DailyForecast;
import com.slobodanantonijevic.openweathermapsdk.model.FiveDaysThreeHourForecast;

import java.util.Map;

import javax.inject.Singleton;

import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

@Singleton
public class OpenWeatherMap {

    // Access to the variable acts as though it is enclosed in a synchronized block, synchronized on itself
    private static volatile OpenWeatherMap activeInstance;

    // Dummy object for synchronization
    private static final Object dummy = new Object();

    static RequestBuilder reqBuilder;

    /**
     *
     * @return
     */
    private static OpenWeatherMap instance() {
        OpenWeatherMap instance = activeInstance;
        if (instance == null) { // Lazy initialization
            Log.w("OWM", "IS NULL");
            synchronized (dummy) { // Synchronization
                Log.w("OWM", "SYNC");
                instance = activeInstance;
                if (instance == null) { // Extra safety
                    Log.w("OWM", "IS NULL AGAIN");
                    activeInstance = instance = new OpenWeatherMap();
                }
            }
        }
        return instance;
    }

    /**
     *
     * @param id
     * @param name
     * @param lat
     * @param lon
     * @param zip
     */
    void getCurrentWeather(Integer id, String name, Double lat, Double lon, String zip,
                          Map<String,String> rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getCurrentWeather(id, name, lat, lon, zip,
                        rqParams.get(OpenWeatherApi.LANG), rqParams.get(OpenWeatherApi.UNITS), rqParams.get(OpenWeatherApi.APP_ID))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CurrentWeather>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(CurrentWeather currentWeather) {
                        if (listener != null) listener.onResponse(currentWeather);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        listener.onError(throwable);
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    /**
     *
     * @param id
     * @param name
     * @param lat
     * @param lon
     * @param zip
     */
    void getDailyForecast(Integer id, String name, Double lat, Double lon, String zip,
                          Map<String,String> rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getDailyForecast(id, name, lat, lon, zip,
                        rqParams.get(OpenWeatherApi.LANG), rqParams.get(OpenWeatherApi.UNITS), rqParams.get(OpenWeatherApi.APP_ID))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<DailyForecast>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(DailyForecast dailyForecast) {
                        if (listener != null) listener.onResponse(dailyForecast);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        listener.onError(throwable);
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    /**
     *
     * @param id
     * @param name
     * @param lat
     * @param lon
     * @param zip
     */
    void getFiveDaysThreeHourForecast(Integer id, String name, Double lat, Double lon, String zip,
                          Map<String,String> rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getFiveDaysThreeHourForecast(id, name, lat, lon, zip,
                        rqParams.get(OpenWeatherApi.LANG), rqParams.get(OpenWeatherApi.UNITS), rqParams.get(OpenWeatherApi.APP_ID))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FiveDaysThreeHourForecast>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(FiveDaysThreeHourForecast fiveDaysThreeHourForecast) {
                        if (listener != null) listener.onResponse(fiveDaysThreeHourForecast);
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        listener.onError(throwable);
                    }

                    @Override
                    public void onComplete() {}
                });
    }

    /**
     *
     * @return
     */
    public static RequestBuilder request() {
        reqBuilder = new RequestBuilder(instance());
        return reqBuilder;
    }

    private Result listener;

    public void onResponse(Result l) {
        listener = l;
    }
}
