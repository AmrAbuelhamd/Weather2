package com.blogspot.soyamr.data.network

import com.blogspot.soyamr.data.network.model.City
import com.blogspot.soyamr.data.network.model.JsonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface WeatherApi {

    @GET("find")
    suspend fun getCities(
        @Query("lat") lat: Float = 29.5F,
        @Query("lon") lon: Float = 112.3F,
        @Query("cnt") cnt: Int = 50
    ): JsonResponse

    @GET("weather")
    suspend fun getCity(
        @Query("id") id: Long,
    ): City
}