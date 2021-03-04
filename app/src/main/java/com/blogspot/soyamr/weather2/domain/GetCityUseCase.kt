package com.blogspot.soyamr.weather2.domain

import com.blogspot.soyamr.weather2.data.IRepo
import javax.inject.Inject

class GetCityUseCase @Inject constructor(private val repository: IRepo) {
    suspend operator fun invoke(cityId: Long) = repository.getCity(cityId)
}