package com.blogspot.soyamr.weather2.domain.interactors

import com.blogspot.soyamr.weather2.domain.Repository
import javax.inject.Inject

class GetCitiesUseCaseImpl @Inject constructor(private val repository: Repository) :
    GetCitiesUseCase {
    override suspend operator fun invoke() = repository.getCities()
}