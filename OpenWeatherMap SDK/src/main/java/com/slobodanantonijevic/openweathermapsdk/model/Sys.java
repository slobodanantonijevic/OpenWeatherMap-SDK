package com.slobodanantonijevic.openweathermapsdk.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Sys {

    @SerializedName("type")
    @Expose
    private int type;

    @SerializedName("id")
    @Expose
    private int id;

    @SerializedName("message")
    @Expose
    private double message;

    @SerializedName("country")
    @Expose
    private String country;

    @SerializedName("sunrise")
    @Expose
    private int sunrise;

    @SerializedName("sunset")
    @Expose
    private int sunset;

    @SerializedName("pod")
    @Expose
    private String pod;

    public int getType() {

        return type;
    }

    public void setType(int type) {

        this.type = type;
    }

    public int getId() {

        return id;
    }

    public void setId(int id) {

        this.id = id;
    }

    public double getMessage() {

        return message;
    }

    public void setMessage(double message) {

        this.message = message;
    }

    public String getCountry() {

        return country;
    }

    public void setCountry(String country) {

        this.country = country;
    }

    public int getSunrise() {

        return sunrise;
    }

    public void setSunrise(int sunrise) {

        this.sunrise = sunrise;
    }

    public int getSunset() {

        return sunset;
    }

    public void setSunset(int sunset) {

        this.sunset = sunset;
    }

    public String getPod() {

        return pod;
    }

    public void setPod(String pod) {

        this.pod = pod;
    }
}
