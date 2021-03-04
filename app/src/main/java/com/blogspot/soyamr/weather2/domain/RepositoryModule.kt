package com.blogspot.soyamr.weather2.domain

import android.content.Context
import com.blogspot.soyamr.weather2.data.IRepo
import com.blogspot.soyamr.weather2.data.Repo
import com.blogspot.soyamr.weather2.data.network.OWMApi
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent


@Module
@InstallIn(SingletonComponent::class)
object RepositoryModule {

    @Provides
    fun getRepo(@ApplicationContext context: Context, apiService: OWMApi): IRepo {
        return Repo(context, apiService)
    }
}