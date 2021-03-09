package com.blogspot.soyamr.weather2.data.network

import com.blogspot.soyamr.weather2.data.network.model.City
import com.blogspot.soyamr.weather2.data.network.model.JsonResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("find")
    fun getCities(
        @Query("lat") lat: Float = 29.5F,
        @Query("lon") lon: Float = 112.3F,
        @Query("cnt") cnt: Int = 50
    ): Single<JsonResponse>

    @GET("weather")
    fun getCity(
        @Query("id") id: Long,
    ): Single<City>
}