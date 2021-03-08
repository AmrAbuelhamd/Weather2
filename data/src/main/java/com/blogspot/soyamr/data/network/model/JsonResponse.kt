package com.blogspot.soyamr.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class JsonResponse(
    val cod: String,
    val count: Int,
    val list: List<City>,
    val message: String
)