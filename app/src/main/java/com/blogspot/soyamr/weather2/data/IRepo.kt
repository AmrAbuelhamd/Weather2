package com.blogspot.soyamr.weather2.data

import com.blogspot.soyamr.weather2.domain.City
import dagger.Provides


interface IRepo {

    suspend fun getCities(): List<City>
    suspend fun getCity(cityId: Long): City
}
