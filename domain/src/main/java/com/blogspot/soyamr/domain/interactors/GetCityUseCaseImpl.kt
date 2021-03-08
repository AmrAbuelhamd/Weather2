package com.blogspot.soyamr.domain.interactors

import com.blogspot.soyamr.domain.Repository
import javax.inject.Inject

class GetCityUseCaseImpl @Inject constructor(private val repository: Repository) : GetCityUseCase {
    override suspend operator fun invoke(cityId: Long) = repository.getCity(cityId)
}