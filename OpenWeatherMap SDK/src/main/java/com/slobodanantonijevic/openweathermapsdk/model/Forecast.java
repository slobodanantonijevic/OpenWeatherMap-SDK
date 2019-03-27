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

public class Forecast {

    @SerializedName("dt")
    @Expose
    private int dt;

    @SerializedName("dt_txt")
    @Expose
    private String dtTxt;

    @SerializedName("temp")
    @Expose
    private Temp temp;

    @SerializedName("pressure")
    @Expose
    private double pressure;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("weather")
    @Expose
    private List<Weather> weather = null;

    @SerializedName("speed")
    @Expose
    private double speed;

    @SerializedName("deg")
    @Expose
    private int deg;

    @SerializedName("clouds")
    @Expose
    private int clouds;

    @SerializedName("rain")
    @Expose
    private double rain;

    @SerializedName("main")
    @Expose
    private Main main;

    @SerializedName("wind")
    @Expose
    private Wind wind;

    @SerializedName("sys")
    @Expose
    private Sys sys;

    @SerializedName("rain")
    @Expose
    private Rain rain3h;

    public int getDt() {

        return dt;
    }

    public void setDt(int dt) {

        this.dt = dt;
    }

    public Temp getTemp() {

        return temp;
    }

    public void setTemp(Temp temp) {

        this.temp = temp;
    }

    public double getPressure() {

        return pressure;
    }

    public void setPressure(double pressure) {

        this.pressure = pressure;
    }

    public int getHumidity() {

        return humidity;
    }

    public void setHumidity(int humidity) {

        this.humidity = humidity;
    }

    public java.util.List<Weather> getWeather() {

        return weather;
    }

    public void setWeather(java.util.List<Weather> weather) {

        this.weather = weather;
    }

    public double getSpeed() {

        return speed;
    }

    public void setSpeed(double speed) {

        this.speed = speed;
    }

    public int getDeg() {

        return deg;
    }

    public void setDeg(int deg) {

        this.deg = deg;
    }

    public int getClouds() {

        return clouds;
    }

    public void setClouds(int clouds) {

        this.clouds = clouds;
    }

    public double getRain() {

        if (rain3h != null) {

            return rain3h.get3h();
        }

        return rain;
    }

    public void setRain(Rain rain3h) {

        this.rain3h = rain3h;
    }

    public void setRain(double rain) {

        this.rain = rain;
    }

    public Wind getWind() {

        return wind;
    }

    public void setWind(Wind wind) {

        this.wind = wind;
    }

    public Sys getSys() {

        return sys;
    }

    public void setSys(Sys sys) {

        this.sys = sys;
    }

    public String getDtTxt() {

        return dtTxt;
    }

    public void setDtTxt(String dtTxt) {

        this.dtTxt = dtTxt;
    }

    public Main getMain() {

        return main;
    }

    public void setMain(Main main) {

        this.main = main;
    }

    public class Rain {

        @SerializedName("3h")
        @Expose
        private double _3h;

        public double get3h() {

            return _3h;
        }

        public void set3h(double _3h) {

            this._3h = _3h;
        }
    }

    public class Temp {

        @SerializedName("day")
        @Expose
        private double day;

        @SerializedName("min")
        @Expose
        private double min;

        @SerializedName("max")
        @Expose
        private double max;

        @SerializedName("night")
        @Expose
        private double night;

        @SerializedName("eve")
        @Expose
        private double eve;

        @SerializedName("morn")
        @Expose
        private double morn;

        public double getDay() {

            return day;
        }

        public void setDay(double day) {

            this.day = day;
        }

        public double getMin() {

            return min;
        }

        public void setMin(double min) {

            this.min = min;
        }

        public double getMax() {

            return max;
        }

        public void setMax(double max) {

            this.max = max;
        }

        public double getNight() {

            return night;
        }

        public void setNight(double night) {

            this.night = night;
        }

        public double getEve() {

            return eve;
        }

        public void setEve(double eve) {

            this.eve = eve;
        }

        public double getMorn() {

            return morn;
        }

        public void setMorn(double morn) {

            this.morn = morn;
        }
    }
}