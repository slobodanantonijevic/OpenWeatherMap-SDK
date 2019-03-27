# OpenWeatherMap SDK
Unoficial open source SDK built for retreiving weather data from [OpenWeatherMap API](https://openweathermap.org/api)

## Usage and docs

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
	    implementation 'com.github.slobodanantonijevic:OpenWeatherMap-SDK:Tag'
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
	    <version>Tag</version>
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
                        // Yeey, success your code here
                    }

                    @Override
                    public void onError(Throwable throwable) {
                        // Boo, failure code here
                    }
                });
```
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
