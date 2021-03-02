package com.blogspot.soyamr.weather2.repository.network

import com.blogspot.soyamr.weather2.repository.network.pojo.JsonResponse
import retrofit2.http.GET
import retrofit2.http.Query

interface OWMApi {

    @GET("find")
    suspend fun getCities(
        @Query("lat") lat: Float = 29.5F,
        @Query("lon") lon: Float = 112.3F,
        @Query("cnt") cnt: Int = 50
    ): JsonResponse
}