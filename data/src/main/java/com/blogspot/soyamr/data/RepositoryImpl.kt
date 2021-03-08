package com.blogspot.soyamr.data

import com.blogspot.soyamr.data.network.WeatherApi
import com.blogspot.soyamr.domain.Repository
import com.blogspot.soyamr.domain.model.City
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