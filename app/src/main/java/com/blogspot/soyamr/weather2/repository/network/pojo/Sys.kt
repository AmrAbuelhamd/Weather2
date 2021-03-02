package com.blogspot.soyamr.weather2.repository.network.pojo

import kotlinx.serialization.Serializable


@Serializable
data class Sys(
    val country: String
)