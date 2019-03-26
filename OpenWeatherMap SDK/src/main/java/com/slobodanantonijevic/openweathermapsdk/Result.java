package com.slobodanantonijevic.openweathermapsdk;

/**
 *
 * @param <T>
 */
public interface Result<T> {

    void onResponse(T weather);

    void onError(Throwable throwable);
}
