package com.blogspot.soyamr.domain

import com.blogspot.soyamr.domain.model.City


interface Repository {
    suspend fun getCities(): List<City>
    suspend fun getCity(cityId: Long): City
}
