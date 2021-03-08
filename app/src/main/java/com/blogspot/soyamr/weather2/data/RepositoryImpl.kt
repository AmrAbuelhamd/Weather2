package com.blogspot.soyamr.weather2.data

import com.blogspot.soyamr.weather2.data.network.WeatherApi
import com.blogspot.soyamr.weather2.domain.Repository
import com.blogspot.soyamr.weather2.domain.model.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton


@Singleton
class RepositoryImpl @Inject constructor(
    private val apiService: WeatherApi
) : Repository {


    override suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            apiService.getCities().list.map { it.toDomain() }
        }

    override suspend fun getCity(cityId: Long): City =
        withContext(Dispatchers.IO) {
            apiService.getCity(cityId).toDomain()
        }
}