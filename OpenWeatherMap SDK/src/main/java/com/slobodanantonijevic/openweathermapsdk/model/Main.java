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

public class Main {

    @SerializedName("temp")
    @Expose
    private double temp;

    @SerializedName("pressure")
    @Expose
    private int pressure;

    @SerializedName("humidity")
    @Expose
    private int humidity;

    @SerializedName("temp_min")
    @Expose
    private double tempMin;

    @SerializedName("temp_max")
    @Expose
    private double tempMax;

    @SerializedName("sea_level")
    @Expose
    private double seaLevel;

    @SerializedName("grnd_level")
    @Expose
    private double grndLevel;

    @SerializedName("temp_kf")
    @Expose
    private int tempKf;

    public double getTemp() {

        return temp;
    }

    public void setTemp(double temp) {

        this.temp = temp;
    }

    public int getPressure() {

        return pressure;
    }

    public void setPressure(int pressure) {

        this.pressure = pressure;
    }

    public int getHumidity() {

        return humidity;
    }

    public void setHumidity(int humidity) {

        this.humidity = humidity;
    }

    public double getTempMin() {

        return tempMin;
    }

    public void setTempMin(double tempMin) {

        this.tempMin = tempMin;
    }

    public double getTempMax() {

        return tempMax;
    }

    public void setTempMax(double tempMax) {

        this.tempMax = tempMax;
    }

    public double getSeaLevel() {

        return seaLevel;
    }

    public void setSeaLevel(double seaLevel) {

        this.seaLevel = seaLevel;
    }

    public double getGrndLevel() {

        return grndLevel;
    }

    public void setGrndLevel(double grndLevel) {

        this.grndLevel = grndLevel;
    }

    public int getTempKf() {

        return tempKf;
    }

    public void setTempKf(int tempKf) {

        this.tempKf = tempKf;
    }
}
