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

import android.location.Location;

import com.slobodanantonijevic.openweathermapsdk.api.OpenWeather;
import com.slobodanantonijevic.openweathermapsdk.api.OpenWeatherApi;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    private OpenWeatherMap owm;
    private RequestParameters rqParams = new RequestParameters();

    RequestBuilder(OpenWeatherMap owm) {
        this.owm = owm;
    }

    /**
     *
     * @param appId
     * @return
     */
    public RequestBuilder appId(String appId) {
        this.rqParams.setAppId(appId);
        return this;
    }

    /**
     *
     * @param lang
     * @return
     */
    public RequestBuilder lang(String lang) {
        this.rqParams.setLang(lang);
        return this;
    }

    /**
     *
     * @param units
     * @return
     */
    public RequestBuilder units(String units) {
        this.rqParams.setUnits(units);
        return this;
    }

    /**
     *
     * @param start
     * @return
     */
    public RequestBuilder start(Integer start) {
        this.rqParams.setStart(start);
        return this;
    }

    /**
     *
     * @param end
     * @return
     */
    public RequestBuilder end(Integer end) {
        this.rqParams.setEnd(end);
        return this;
    }

    /**
     *
     * @param count
     * @return
     */
    public RequestBuilder count(Integer count) {
        this.rqParams.setCount(count);
        return this;
    }

    /**
     *
     * @param id
     * @return
     */
    public OpenWeatherMap getCurrentWeatherById(Integer id) {
        owm.getCurrentWeather(id, null, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param name
     * @return
     */
    public OpenWeatherMap getCurrentWeatherByName(String name) {
        owm.getCurrentWeather(null, name, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getCurrentWeatherByGeo(Double lat, Double lon) {
        owm.getCurrentWeather(null, null, lat, lon, null, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getCurrentWeatherByGeo(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getCurrentWeatherByGeo(lat, lon);
    }

    /**
     *
     * @param zipCode
     * @return
     */
    public OpenWeatherMap getCurrentWeatherByZip(String zipCode) {
        owm.getCurrentWeather(null, null, null, null, zipCode, rqParams);
        return owm;
    }

    /**
     *
     * @param id
     * @return
     */
    public OpenWeatherMap getDailyForecastById(Integer id) {
        owm.getDailyForecast(id, null, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param name
     * @return
     */
    public OpenWeatherMap getDailyForecastByName(String name) {
        owm.getDailyForecast(null, name, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getDailyForecastByGeo(Double lat, Double lon) {
        owm.getDailyForecast(null, null, lat, lon, null, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getDailyForecastByGeo(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getDailyForecastByGeo(lat, lon);
    }

    /**
     *
     * @param zipCode
     * @return
     */
    public OpenWeatherMap getDailyForecastByZip(String zipCode) {
        owm.getDailyForecast(null, null, null, null, zipCode, rqParams);
        return owm;
    }

    /**
     *
     * @param id
     * @return
     */
    public OpenWeatherMap getFiveDaysThreeHourForecastById(Integer id) {
        owm.getFiveDaysThreeHourForecast(id, null, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param name
     * @return
     */
    public OpenWeatherMap getFiveDaysThreeHourForecastByName(String name) {
        owm.getFiveDaysThreeHourForecast(null, name, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getFiveDaysThreeHourForecastByGeo(Double lat, Double lon) {
        owm.getFiveDaysThreeHourForecast(null, null, lat, lon, null, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getFiveDaysThreeHourForecastByGeo(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getFiveDaysThreeHourForecastByGeo(lat, lon);
    }

    /**
     *
     * @param zipCode
     * @return
     */
    public OpenWeatherMap getFiveDaysThreeHourForecastByZip(String zipCode) {
        owm.getFiveDaysThreeHourForecast(null, null, null, null, zipCode, rqParams);
        return owm;
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getUvIndex(Double lat, Double lon) {
        owm.getUvIndex(lat, lon, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getUvIndex(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getUvIndex(lat, lon);
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getUvIndexForecast(Double lat, Double lon) {
        owm.getForecastUvIndex(lat, lon, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getUvIndexForecast(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getUvIndexForecast(lat, lon);
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getUvIndexHistorical(Double lat, Double lon) {
        owm.getHistoricalUvIndex(lat, lon, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getUvIndexHistorical(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getUvIndexHistorical(lat, lon);
    }

    /**
     *
     * @param id
     * @return
     */
    public OpenWeatherMap getHistoricalDataById(Integer id) {
        owm.getHistoricalData(id, null, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param name
     * @return
     */
    public OpenWeatherMap getHistoricalDataByName(String name) {
        owm.getHistoricalData(null, name, null, null, null, rqParams);
        return owm;
    }

    /**
     *
     * @param lat
     * @param lon
     * @return
     */
    public OpenWeatherMap getHistoricalDataByGeo(Double lat, Double lon) {
        owm.getHistoricalData(null, null, lat, lon, null, rqParams);
        return owm;
    }

    /**
     *
     * @param location
     * @return
     */
    public OpenWeatherMap getHistoricalDataByGeo(Location location) {
        Double lat = location.getLatitude();
        Double lon = location.getLongitude();
        return getHistoricalDataByGeo(lat, lon);
    }
}
