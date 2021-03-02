package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable


@Serializable
data class Rain(
    @SerialName("1h")
    val oneH: Double
)