package com.blogspot.soyamr.weather2.repository.network

import com.jakewharton.retrofit2.converter.kotlinx.serialization.asConverterFactory
import kotlinx.serialization.json.Json
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit

object OWMService {

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

    val retrofit: OWMApi by lazy {
        Retrofit.Builder()
            .baseUrl("http://api.openweathermap.org/data/2.5/")
            .client(okHttpClient)
            .addConverterFactory(
                Json {
                    ignoreUnknownKeys = true
                }.asConverterFactory("application/json".toMediaType())
            )
            .build()
            .create(OWMApi::class.java)
    }

}