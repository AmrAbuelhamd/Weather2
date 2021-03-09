package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.Repository
import javax.inject.Inject

class GetCityUseCaseImpl @Inject constructor(private val repository: Repository) : GetCityUseCase {
    override operator fun invoke(cityId: Long) = repository.getCity(cityId)
}