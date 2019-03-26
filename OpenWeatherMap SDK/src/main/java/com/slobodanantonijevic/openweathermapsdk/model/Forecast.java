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

    public void setRain(Rain rain3h) {

        this.rain3h = rain3h;
    }

    public Main getMain() {
        return main;
    }

    public void setMain(Main main) {
        this.main = main;
    }
}