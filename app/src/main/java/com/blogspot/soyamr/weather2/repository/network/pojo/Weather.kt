package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.Serializable


@Serializable
data class Weather(
    val description: String,
    val icon: String,
    val id: Int,
    val main: String
)