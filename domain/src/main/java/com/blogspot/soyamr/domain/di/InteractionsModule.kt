package com.blogspot.soyamr.domain.di

import com.blogspot.soyamr.domain.interactors.GetCitiesUseCase
import com.blogspot.soyamr.domain.interactors.GetCitiesUseCaseImpl
import com.blogspot.soyamr.domain.interactors.GetCityUseCase
import com.blogspot.soyamr.domain.interactors.GetCityUseCaseImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class InteractionsModule {

    @Binds
    abstract fun citiesUseCase(getCitiesUseCaseImpl: GetCitiesUseCaseImpl): GetCitiesUseCase

    @Binds
    abstract fun cityUseCase(getCityUseCaseImpl: GetCityUseCaseImpl): GetCityUseCase
}