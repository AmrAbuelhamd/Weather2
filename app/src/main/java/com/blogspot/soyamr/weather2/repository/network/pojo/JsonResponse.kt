package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.Serializable

@Serializable
data class JsonResponse(
    val list: List<City>
)


@Serializable
data class City(
    val id: Long,
    val name: String,
    val sys: Sys,
) {
    fun toDomain() = com.blogspot.soyamr.weather2.repository.City(id,name,sys.country)
}

@Serializable
data class Sys(
    val country: String
)