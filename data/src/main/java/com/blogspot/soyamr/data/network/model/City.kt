package com.blogspot.soyamr.data.network.model

import com.blogspot.soyamr.domain.model.City
import kotlinx.serialization.Serializable

@Serializable
data class City(
    val clouds: Clouds,
    val coord: Coord,
    val dt: Int,
    val id: Int,
    val main: Main,
    val name: String,
    val rain: Rain? = null,
    val sys: Sys,
    val weather: List<Weather>,
    val wind: Wind,
    val timeZone: Int? = null,
    val cod: Int? = null,
) {
    fun toDomain() = City(id.toLong(), name, sys.country)
}