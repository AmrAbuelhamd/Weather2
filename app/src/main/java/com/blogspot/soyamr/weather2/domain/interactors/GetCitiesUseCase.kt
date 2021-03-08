package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.model.City

interface GetCitiesUseCase {
    suspend operator fun invoke(): List<City>
}