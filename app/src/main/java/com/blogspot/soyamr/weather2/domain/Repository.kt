package com.blogspot.soyamr.weather2.domain

import com.blogspot.soyamr.weather2.domain.model.City


interface Repository {
    suspend fun getCities(): List<City>
    suspend fun getCity(cityId: Long): City
}