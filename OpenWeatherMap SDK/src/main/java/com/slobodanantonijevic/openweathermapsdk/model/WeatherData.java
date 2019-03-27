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

package com.slobodanantonijevic.openweathermapsdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class WeatherData {

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("clouds")
    @Expose
    private Clouds clouds;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;

    @SerializedName("dt")
    @Expose
    private int dt;

    public Main getMain() {

        return main;
    }

    public void setMain(Main main) {

        this.main = main;
    }

    public Wind getWind() {

        return wind;
    }

    public void setWind(Wind wind) {

        this.wind = wind;
    }

    public Clouds getClouds() {

        return clouds;
    }

    public void setClouds(Clouds clouds) {

        this.clouds = clouds;
    }

    public List<Weather> getWeather() {

        return weather;
    }

    public void setWeather(List<Weather> weather) {

        this.weather = weather;
    }

    public int getDt() {

        return dt;
    }

    public void setDt(int dt) {

        this.dt = dt;
    }

    public class Clouds {

        @SerializedName("all")
        @Expose
        private int all;

        public int getAll() {

            return all;
        }

        public void setAll(int all) {

            this.all = all;
        }

    }
}
