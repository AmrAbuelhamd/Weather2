package com.blogspot.soyamr.domain.interactors

import com.blogspot.soyamr.domain.model.City

interface GetCityUseCase {
    suspend operator fun invoke(cityId: Long): City
}