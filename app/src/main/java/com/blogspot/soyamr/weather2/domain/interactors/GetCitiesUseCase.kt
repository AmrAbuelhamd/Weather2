package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.model.City
import io.reactivex.Single

interface GetCitiesUseCase {
    operator fun invoke(): Single<List<City>>
}