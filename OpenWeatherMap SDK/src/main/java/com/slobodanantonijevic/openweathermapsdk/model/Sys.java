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
