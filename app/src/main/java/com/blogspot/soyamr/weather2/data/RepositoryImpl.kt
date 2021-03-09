package com.blogspot.soyamr.weather2.data

import com.blogspot.soyamr.weather2.data.network.WeatherApi
import com.blogspot.soyamr.weather2.domain.Repository
import com.blogspot.soyamr.weather2.domain.model.City
import io.reactivex.Single
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: WeatherApi
) : Repository {


    override fun getCities(): Single<List<City>> =
        apiService.getCities().map { jsonResponse ->
            jsonResponse.list.map { it.toDomain() }
        }.subscribeOn(Schedulers.io())


    override fun getCity(cityId: Long): Single<City> =
        apiService.getCity(cityId).map { it.toDomain() }.subscribeOn(Schedulers.io())

}