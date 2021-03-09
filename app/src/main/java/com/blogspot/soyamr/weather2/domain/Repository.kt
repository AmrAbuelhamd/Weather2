package com.blogspot.soyamr.weather2.domain

import com.blogspot.soyamr.weather2.domain.model.City
import io.reactivex.Single


interface Repository {
    fun getCities(): Single<List<City>>
    fun getCity(cityId: Long): Single<City>
}