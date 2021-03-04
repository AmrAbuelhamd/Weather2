package com.blogspot.soyamr.weather2.domain

import com.blogspot.soyamr.weather2.data.IRepo
import javax.inject.Inject

class GetCitiesUseCase @Inject constructor(private val repository: IRepo) {
    suspend operator fun invoke() = repository.getCities()
}