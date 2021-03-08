package com.blogspot.soyamr.data.di

import com.blogspot.soyamr.data.RepositoryImpl
import com.blogspot.soyamr.domain.Repository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    @Binds
    abstract fun getRepo(repository: RepositoryImpl): Repository
}