package com.blogspot.soyamr.weather2.repository

import android.content.Context
import com.blogspot.soyamr.weather2.repository.domain.City
import com.blogspot.soyamr.weather2.repository.network.OWMApi
import com.blogspot.soyamr.weather2.repository.network.OWMService
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

object Repo {


    lateinit var apiService: OWMApi

    operator fun invoke(context: Context): Repo {
        println("incoke is called")
        apiService = OWMService.retrofit
        return this
    }

    suspend fun getCities(): List<City> =
        withContext(Dispatchers.IO) {
            apiService.getCities().list.map { it.toDomain() }
        }

    suspend fun getCity(cityId: Long): City =
        withContext(Dispatchers.IO) {
            apiService.getCity(cityId).toDomain()
        }


}