package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.Serializable


@Serializable
data class Main(
    val feels_like: Double,
    val grnd_level: Int? = null,
    val humidity: Int,
    val pressure: Int,
    val sea_level: Int? = null,
    val temp: Double,
    val temp_max: Double,
    val temp_min: Double
)