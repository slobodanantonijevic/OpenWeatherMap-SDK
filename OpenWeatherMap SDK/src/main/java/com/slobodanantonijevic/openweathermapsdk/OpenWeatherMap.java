/*
 * Copyright (C) 2019 Slobodan Antonijević
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.slobodanantonijevic.openweathermapsdk;

import android.util.Log;

import com.slobodanantonijevic.openweathermapsdk.api.OpenWeather;
import com.slobodanantonijevic.openweathermapsdk.model.CurrentWeather;
import com.slobodanantonijevic.openweathermapsdk.model.DailyForecast;
import com.slobodanantonijevic.openweathermapsdk.model.FiveDaysThreeHourForecast;
import com.slobodanantonijevic.openweathermapsdk.model.HistoricalData;
import com.slobodanantonijevic.openweathermapsdk.model.UvIndex;

import java.util.List;

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
     * @param rqParams
     */
    void getCurrentWeather(Integer id, String name, Double lat, Double lon, String zip,
                           RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getCurrentWeather(id, name, lat, lon, zip,
                        rqParams.getLang(), rqParams.getUnits(), rqParams.getAppId())
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
     * @param rqParams
     */
    void getDailyForecast(Integer id, String name, Double lat, Double lon, String zip,
                          RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getDailyForecast(id, name, lat, lon, zip,
                        rqParams.getLang(), rqParams.getUnits(), rqParams.getAppId())
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
     * @param rqParams
     */
    void getFiveDaysThreeHourForecast(Integer id, String name, Double lat, Double lon, String zip,
                                      RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getFiveDaysThreeHourForecast(id, name, lat, lon, zip,
                        rqParams.getLang(), rqParams.getUnits(), rqParams.getAppId())
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
     * @param lat
     * @param lon
     * @param rqParams
     */
    void getUvIndex(Double lat, Double lon,RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getUvIndex(lat, lon, rqParams.getAppId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<UvIndex>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(UvIndex uvIndex) {
                        if (listener != null) listener.onResponse(uvIndex);
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
     * @param lat
     * @param lon
     * @param rqParams
     */
    void getForecastUvIndex(Double lat, Double lon, RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getForecastUvIndex(lat, lon, rqParams.getCount(), rqParams.getAppId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UvIndex>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(List<UvIndex> uvIndex) {
                        if (listener != null) listener.onResponse(uvIndex);
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
     * @param lat
     * @param lon
     * @param rqParams
     */
    void getHistoricalUvIndex(Double lat, Double lon, RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getHistoricalUvIndex(lat, lon, rqParams.getStart(), rqParams.getEnd(),
                        rqParams.getCount(), rqParams.getAppId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<List<UvIndex>>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(List<UvIndex> uvIndex) {
                        if (listener != null) listener.onResponse(uvIndex);
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
     * @param rqParams
     */
    void getHistoricalData(Integer id, String name, Double lat, Double lon, String zip,
                           RequestParameters rqParams) {
        OpenWeather.getOwmRetrofitInstance()
                .getHistoricalData(id, name, lat, lon, rqParams.getStart(), rqParams.getEnd(),
                        rqParams.getCount(), rqParams.getLang(), rqParams.getUnits(),
                        rqParams.getAppId())
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<HistoricalData>() {
                    @Override
                    public void onSubscribe(Disposable d) {}

                    @Override
                    public void onNext(HistoricalData historicalData) {
                        if (listener != null) listener.onResponse(historicalData);
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
