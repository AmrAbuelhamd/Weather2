package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.Serializable


@Serializable
data class JsonResponse(
    val cod: String,
    val count: Int,
    val list: List<City>,
    val message: String
)