package com.slobodanantonijevic.openweathermapsdk.api;

import com.slobodanantonijevic.openweathermapsdk.model.CurrentWeather;
import com.slobodanantonijevic.openweathermapsdk.model.DailyForecast;
import com.slobodanantonijevic.openweathermapsdk.model.FiveDaysThreeHourForecast;

import io.reactivex.Observable;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherApi {

    String BASE_URL = "https://api.openweathermap.org/";

    String APP_ID = "appid";
    String UNITS = "units"; // null = Kelvin, metric = Celsius, imperial = Fahrenheit
    String CITY_ID = "id";
    String QUERY = "q"; // cityName(,countryCode)
    String LAT = "lat";
    String LON = "lon";
    String ZIP_CODE = "zip"; // zipCode(,countryCode)
    String LANG = "lang"; //
    String PATH = "/data/2.5/";

    @GET(PATH + "weather?")
    Observable<CurrentWeather> getCurrentWeather (

            @Query(CITY_ID) Integer id,
            @Query(QUERY) String query,
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(ZIP_CODE) String zip,
            @Query(LANG) String lang,
            @Query(UNITS) String units,
            @Query(APP_ID) String appId
    );

    @GET(PATH + "forecast/daily?")
    Observable<DailyForecast> getDailyForecast (

            @Query(CITY_ID) Integer id,
            @Query(QUERY) String query,
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(ZIP_CODE) String zip,
            @Query(LANG) String lang,
            @Query(UNITS) String units,
            @Query(APP_ID) String appId
    );

    @GET(PATH + "forecast?")
    Observable<FiveDaysThreeHourForecast> getFiveDaysThreeHourForecast (

            @Query(CITY_ID) Integer id,
            @Query(QUERY) String query,
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(ZIP_CODE) String zip,
            @Query(LANG) String lang,
            @Query(UNITS) String units,
            @Query(APP_ID) String appId
    );

    
}
