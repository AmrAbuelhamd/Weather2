package com.blogspot.soyamr.weather2.data.network.model

import kotlinx.serialization.Serializable

@Serializable
data class Clouds(
    val all: Int
)