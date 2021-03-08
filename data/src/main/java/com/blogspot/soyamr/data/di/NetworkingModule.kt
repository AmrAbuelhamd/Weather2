package com.blogspot.soyamr.data.di

import com.blogspot.soyamr.data.network.WeatherApi
import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit


@Module
@InstallIn(SingletonComponent::class)
object WeatherService {
    private val okHttpClient: OkHttpClient by lazy {
        OkHttpClient.Builder().addInterceptor { chain ->
            var request = chain.request()
            val url = request.url
            request = request.newBuilder()
                .url(
                    url.newBuilder()
                        .addQueryParameter("appid", "05e088d732dd897fe987fdb5e17b9521")
                        .build()
                )
                .build()
            chain.proceed(request)
        }.addInterceptor(
            HttpLoggingInterceptor()
                .setLevel(HttpLoggingInterceptor.Level.BODY)
        ).build()
    }

    @Provides
    fun getRetrofitObject():WeatherApi = RETROFIT

    private val RETROFIT: WeatherApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .client(okHttpClient)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(WeatherApi::class.java)
    }

}