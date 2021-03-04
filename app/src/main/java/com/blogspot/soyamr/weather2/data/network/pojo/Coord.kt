package com.blogspot.soyamr.weather2.data.network.pojo

import kotlinx.serialization.Serializable


@Serializable
data class Coord(
    val lat: Double,
    val lon: Double
)