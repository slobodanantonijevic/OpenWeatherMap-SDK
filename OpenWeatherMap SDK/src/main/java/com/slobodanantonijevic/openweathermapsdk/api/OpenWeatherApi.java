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

package com.slobodanantonijevic.openweathermapsdk.api;

import com.slobodanantonijevic.openweathermapsdk.model.CurrentWeather;
import com.slobodanantonijevic.openweathermapsdk.model.DailyForecast;
import com.slobodanantonijevic.openweathermapsdk.model.FiveDaysThreeHourForecast;
import com.slobodanantonijevic.openweathermapsdk.model.HistoricalData;
import com.slobodanantonijevic.openweathermapsdk.model.UvIndex;

import java.util.List;

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
    String COUNT = "cnt";
    String START = "start"; // unix time, UTC time zone (seconds)
    String END = "end"; // unix time, UTC time zone (seconds)

    /**
     * <p>Request Current Weather from OpenWeatherMap API. All requests are async and threaded.</p>
     * <p>You can choose to search by either of the following:
     * <ul>
     * <li>City Id (check OWM API docs about mapping the cities to their IDs)</li>
     * <li>City name (for highest precision use "{city name}, {country code}" string, eg. "London, UK")</li>
     * <li>Zip code (use "{zip code}, {country code}" string, eg. "WC2N 5DU, UK",
     * in case you omit the country code the search will be don against USA cities)</li>
     * <li>Geo coordinates (both latitude and longitude have to be provided in this case)</li>
     * </ul></p>
     *
     * @param id City id. Check OpenWeatherMap website for details. Can be null if either cityName, lat/lon or zipCode is provided.
     * @param query City name. Can be provided as {cityName}, {countryCode}. Country code has to be provided as per ISO 3166. Can be null if either cityId, lat/lon or zipCode is provided.
     * @param lat Latitude. Mandatory if longitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param lon Longitude. Mandatory if latitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param zip Zip code. Can be provided as {zipCode}, {countryCode}. Country code has to be provided as per ISO 3166. if country code is null then zip search will be done as per USA. Can be null if either cityId, cityName or lat/lon is provided.
     * @param lang Language code. The language impacts only descriptive parts of the response.
     * @param units Units type. null for Kelvin, metric for Celsius, imperial for Fahrenheit
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return (@link CurrentWeather) object
     */
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

    /**
     * <p>Request Daily Forecast from OpenWeatherMap API. All requests are async and threaded.</p>
     * <p>You can choose to search by either of the following:
     * <ul>
     * <li>City Id (check OWM API docs about mapping the cities to their IDs)</li>
     * <li>City name (for highest precision use "{city name}, {country code}" string, eg. "London, UK")</li>
     * <li>Zip code (use "{zip code}, {country code}" string, eg. "WC2N 5DU, UK",
     * in case you omit the country code the search will be don against USA cities)</li>
     * <li>Geo coordinates (both latitude and longitude have to be provided in this case)</li>
     * </ul></p>
     *
     * @param id City id. Check OpenWeatherMap website for details. Can be null if either cityName, lat/lon or zipCode is provided.
     * @param query City name. Can be provided as {cityName}, {countryCode}. Country code has to be provided as per ISO 3166. Can be null if either cityId, lat/lon or zipCode is provided.
     * @param lat Latitude. Mandatory if longitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param lon Longitude. Mandatory if latitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param zip Zip code. Can be provided as {zipCode}, {countryCode}. Country code has to be provided as per ISO 3166. if country code is null then zip search will be done as per USA. Can be null if either cityId, cityName or lat/lon is provided.
     * @param lang Language code. The language impacts only descriptive parts of the response.
     * @param units Units type. null for Kelvin, metric for Celsius, imperial for Fahrenheit
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return (@link DailyForecast) object
     */
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

    /**
     * <p>Request Five Days Three Hours Forecast from OpenWeatherMap API. All requests are async and threaded.</p>
     * <p>You can choose to search by either of the following:
     * <ul>
     * <li>City Id (check OWM API docs about mapping the cities to their IDs)</li>
     * <li>City name (for highest precision use "{city name}, {country code}" string, eg. "London, UK")</li>
     * <li>Zip code (use "{zip code}, {country code}" string, eg. "WC2N 5DU, UK",
     * in case you omit the country code the search will be don against USA cities)</li>
     * <li>Geo coordinates (both latitude and longitude have to be provided in this case)</li>
     * </ul></p>
     *
     * @param id City id. Check OpenWeatherMap website for details. Can be null if either cityName, lat/lon or zipCode is provided.
     * @param query City name. Can be provided as {cityName}, {countryCode}. Country code has to be provided as per ISO 3166. Can be null if either cityId, lat/lon or zipCode is provided.
     * @param lat Latitude. Mandatory if longitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param lon Longitude. Mandatory if latitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param zip Zip code. Can be provided as {zipCode}, {countryCode}. Country code has to be provided as per ISO 3166. if country code is null then zip search will be done as per USA. Can be null if either cityId, cityName or lat/lon is provided.
     * @param lang Language code. The language impacts onlyd escriptive parts of the response.
     * @param units Units type. null for Kelvin, metric for Celsius, imperial for Fahrenheit
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return (@link FiveDaysThreeHourForecast) object
     */
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

    /**
     * <p>Request UV Index for given coordinates from OpenWeatherMap API. All requests are async and threaded.</p>
     *
     * @param lat Latitude
     * @param lon Longitude
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return (@link UvIndex) object
     */
    @GET(PATH + "uvi?")
    Observable<UvIndex> getUvIndex (
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(APP_ID) String appId
    );

    /**
     * <p>Request UV Index for given coordinates and for given days (can be omitted) in the future
     * from OpenWeatherMap API. All requests are async and threaded.</p>
     *
     * @param lat Latitude
     * @param lon Longitude
     * @param count Number of returned days
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return List<(@link UvIndex)> object
     */
    @GET(PATH + "uvi/forecast?")
    Observable<List<UvIndex>> getForecastUvIndex (
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(COUNT) Integer count,
            @Query(APP_ID) String appId
    );

    /**
     * <p>Request UV Index for given coordinates and for given days (can be omitted) in the past
     * from OpenWeatherMap API. All requests are async and threaded.</p>
     *
     * @param lat Latitude
     * @param lon Longitude
     * @param start Start date (unix time, UTC time zone)
     * @param end End date (unix time, UTC time zone)
     * @param count Number of returned days
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return List<(@link UvIndex)> object
     */
    @GET(PATH + "uvi/history?")
    Observable<List<UvIndex>> getHistoricalUvIndex (
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(START) Integer start,
            @Query(END) Integer end,
            @Query(COUNT) Integer count,
            @Query(APP_ID) String appId
    );

    /**
     * <p>Request Historical Weather Data from OpenWeatherMap API. All requests are async and threaded.</p>
     * <p>You can choose to search by either of the following:
     * <ul>
     * <li>City Id (check OWM API docs about mapping the cities to their IDs)</li>
     * <li>City name (for highest precision use "{city name}, {country code}" string, eg. "London, UK")</li>
     * in case you omit the country code the search will be don against USA cities)</li>
     * <li>Geo coordinates (both latitude and longitude have to be provided in this case)</li>
     * </ul></p>
     *
     * @param id City id. Check OpenWeatherMap website for details. Can be null if either cityName, lat/lon or zipCode is provided.
     * @param query City name. Can be provided as {cityName}, {countryCode}. Country code has to be provided as per ISO 3166. Can be null if either cityId, lat/lon or zipCode is provided.
     * @param lat Latitude. Mandatory if longitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param lon Longitude. Mandatory if latitude is provided. Can be null if either cityId, cityName or zipCode is provided.
     * @param start Start date (unix time, UTC time zone)
     * @param end End date (unix time, UTC time zone)
     * @param count Amount of returned data (one per hour, can be used instead of 'end')
     * @param lang Language code. The language impacts only descriptive parts of the response.
     * @param units Units type. null for Kelvin, metric for Celsius, imperial for Fahrenheit
     * @param appId App ID. Acquired upon registration on openwaethermap.org
     * @return (@link HistoricalData) object
     */
    @GET(PATH + "history/city?type=hour")
    Observable<HistoricalData> getHistoricalData (
            @Query(CITY_ID) Integer id,
            @Query(QUERY) String query,
            @Query(LAT) Double lat,
            @Query(LON) Double lon,
            @Query(START) Integer start,
            @Query(END) Integer end,
            @Query(COUNT) Integer count,
            @Query(LANG) String lang,
            @Query(UNITS) String units,
            @Query(APP_ID) String appId
    );
}
