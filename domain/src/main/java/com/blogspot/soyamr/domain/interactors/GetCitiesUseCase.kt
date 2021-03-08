package com.blogspot.soyamr.domain.interactors

import com.blogspot.soyamr.domain.model.City

interface GetCitiesUseCase {
    suspend operator fun invoke(): List<City>
}