package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.model.City

interface GetCityUseCase {
    suspend operator fun invoke(cityId: Long): City
}