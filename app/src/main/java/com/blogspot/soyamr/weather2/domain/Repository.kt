package com.blogspot.soyamr.weather2.domain

import com.blogspot.soyamr.weather2.domain.model.City
import io.reactivex.Single


interface Repository {
    //probably it shouldn't return Single since it's in domain, but i couldn't find other way than this in rxjava
    fun getCities(): Single<List<City>>
    fun getCity(cityId: Long): Single<City>
}