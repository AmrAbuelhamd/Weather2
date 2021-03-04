package com.blogspot.soyamr.weather2.repository

import android.content.Context
import com.blogspot.soyamr.weather2.repository.domain.City
import com.blogspot.soyamr.weather2.repository.network.OWMApi
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Repo @Inject constructor(@ApplicationContext val context: Context, private val apiService: OWMApi) {


    suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            apiService.getCities().list.map { it.toDomain() }
        }

    suspend fun getCity(cityId: Long): City =
        withContext(Dispatchers.IO) {
            apiService.getCity(cityId).toDomain()
        }
}