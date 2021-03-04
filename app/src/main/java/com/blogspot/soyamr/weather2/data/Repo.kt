package com.blogspot.soyamr.weather2.data

import android.content.Context
import com.blogspot.soyamr.weather2.data.network.OWMApi
import com.blogspot.soyamr.weather2.domain.City
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor(
    val context: Context,
    private val apiService: OWMApi
) : IRepo {


    override suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            apiService.getCities().list.map { it.toDomain() }
        }

    override suspend fun getCity(cityId: Long): City =
        withContext(Dispatchers.IO) {
            apiService.getCity(cityId).toDomain()
        }
}