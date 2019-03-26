package com.slobodanantonijevic.openweathermapsdk;

import android.location.Location;

import com.slobodanantonijevic.openweathermapsdk.api.OpenWeatherApi;

import java.util.HashMap;
import java.util.Map;

public class RequestBuilder {

    public static final String UNITS_METRIC = "metric";
    public static final String UNITS_IMPERIAL = "imperial";

    private OpenWeatherMap owm;

    Map<String, String> rqParams = new HashMap<>();
    private String appId;
    private String lang;
    private String units;

    RequestBuilder(OpenWeatherMap owm) {
        this.owm = owm;
    }

    /**
     *
     * @param appId
     * @return
     */
    public RequestBuilder appId(String appId) {
        this.rqParams.put(OpenWeatherApi.APP_ID, appId);
        return this;
    }

    /**
     *
     * @param lang
     * @return
     */
    public RequestBuilder lang(String lang) {
        this.rqParams.put(OpenWeatherApi.LANG, lang);
        return this;
    }

    /**
     *
     * @param units
     * @return
     */
    public RequestBuilder units(String units) {
        this.rqParams.put(OpenWeatherApi.UNITS, units);
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
        owm.getCurrentWeather(null, null, lat, lon, null, rqParams);
        return owm;
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
        owm.getDailyForecast(null, null, lat, lon, null, rqParams);
        return owm;
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
        owm.getFiveDaysThreeHourForecast(null, null, lat, lon, null, rqParams);
        return owm;
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
}
