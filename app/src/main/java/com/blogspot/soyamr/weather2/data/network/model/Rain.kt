package com.blogspot.soyamr.weather2.data.network.model

import kotlinx.serialization.SerialName

import kotlinx.serialization.Serializable

@Serializable
data class Rain(
    @SerialName("1h")
    val oneH: Double
)