package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.model.City
import io.reactivex.Single

interface GetCityUseCase {
    operator fun invoke(cityId: Long): Single<City>
}