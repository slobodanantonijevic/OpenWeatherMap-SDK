# OpenWeatherMap SDK for Android
Unofficial open source SDK built for retrieving weather data from [OpenWeatherMap API](https://openweathermap.org/api)
This SDK is not proffesionally related in any way to [OpenWeatherMap](https://openweathermap.org/), and represents only a contribution to OpenSource world. If you like this piece of work, please support it by sharing, using, forking, it is all free :)

![Apache License](https://img.shields.io/badge/license-Apache--2.0-blue.svg) ![api 16+](https://img.shields.io/badge/Android%20API-16%2B-green.svg) ![Tech used](https://img.shields.io/badge/tech-RxJava%20%7C%20Retrofit2%20%7C%20Dagger2-red.svg) ![Data source](https://img.shields.io/badge/Weather%20API-www.OpenWeatherMap.org-orange.svg)

## Notable technologies used
RxJava, Dagger 2, Retrofit 2

## Usage and docs
The wiki and Javadoc are still a work in progress, and will be updated over the course of next few days or so.

### Adding to project
#### Gradle: ####
Step 1. Add it in your root build.gradle:
```groovy
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

Step 2. Add the dependency
```groovy
dependencies {
      ...
      implementation 'com.github.slobodanantonijevic:OpenWeatherMap-SDK:1.0.0'
      ...
}
```
#### Maven: ####
Step 1. Add the JitPack repository to your build file:
```groovy
<repositories>
    <repository>
        <id>jitpack.io</id>
        <url>https://jitpack.io</url>
    </repository>
</repositories>
```

Step 2. Add the dependency
```groovy
<dependency>
    <groupId>com.github.slobodanantonijevic</groupId>
    <artifactId>OpenWeatherMap-SDK</artifactId>
    <version>1.0.0</version>
</dependency>
```

### Usage
The usage is rather literal and quite simple

#### Current Weather
```groovy
        OpenWeatherMap.request() // init the request
                .appId(YOUR_OPENWEATHERMAP_APP_ID) // mandatory, app id from OpenWeatherMap
                .lang("en") // optional, default is en
                .units(RequestParameters.UNITS_METRIC) // optional, null or omit for Kelvin, UNITS_METRIC = Celsius, UNITS_IMPERIAL = Fahrenheit
                .getCurrentWeatherByName("London,UK") // for all possible methods see the wiki docs
                .onResponse(new Result<CurrentWeather>() {

                    @Override
                    public void onResponse(CurrentWeather weather) {
                        // Yeey, success code here
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        // Boo, failure code here
                    }
                });
```
#### Daily Forecast
```groovy
        OpenWeatherMap.request() // init the request
                .appId(YOUR_OPENWEATHERMAP_APP_ID)
                .lang("de") 
                .getDailyForecastById(2643743) // for all possible methods see the wiki docs
                .onResponse(new Result<DailyForecast>() {

                    @Override
                    public void onResponse(DailyForecast forecast) {
                        // Yeey, success code here
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        // Boo, failure code here
                    }
                });
```
#### 5 days/3 hour forecast API
```groovy
        OpenWeatherMap.request() // init the request
                .appId(YOUR_OPENWEATHERMAP_APP_ID)
                .units(RequestParameters.UNITS_IMPERIAL)
                .getFiveDaysThreeHourForecastByGeo(51.51, -0.13) // for all possible methods see the wiki docs
                .onResponse(new Result<FiveDaysThreeHourForecast>() {

                    @Override
                    public void onResponse(FiveDaysThreeHourForecast forecast) {
                        // Yeey, success code here
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        // Boo, failure code here
                    }
                });
```

## License
```
                                 Apache License
                           Version 2.0, January 2004
                        http://www.apache.org/licenses/

   Copyright 2019 Slobodan Antonijević

   Licensed under the Apache License, Version 2.0 (the "License");
   you may not use this file except in compliance with the License.
   You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

   Unless required by applicable law or agreed to in writing, software
   distributed under the License is distributed on an "AS IS" BASIS,
   WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
   See the License for the specific language governing permissions and
   limitations under the License.
```
