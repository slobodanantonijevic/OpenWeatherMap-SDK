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

package com.slobodanantonijevic.openweathermapsdk;

public class RequestParameters {

    public static final String UNITS_METRIC = "metric";
    public static final String UNITS_IMPERIAL = "imperial";

    private String appId;
    private String lang;
    private String units;
    private Integer start;
    private Integer end;
    private Integer count;

    String getAppId() {
        return appId;
    }

    void setAppId(String appId) {
        this.appId = appId;
    }

    String getLang() {
        return lang;
    }

    void setLang(String lang) {
        this.lang = lang;
    }

    String getUnits() {
        return units;
    }

    void setUnits(String units) {
        this.units = units;
    }

    Integer getStart() {
        return start;
    }

    void setStart(Integer start) {
        this.start = start;
    }

    Integer getEnd() {
        return end;
    }

    void setEnd(Integer end) {
        this.end = end;
    }

    Integer getCount() {
        return count;
    }

    void setCount(Integer count) {
        this.count = count;
    }
}
