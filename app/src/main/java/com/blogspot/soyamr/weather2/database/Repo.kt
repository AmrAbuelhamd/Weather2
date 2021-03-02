package com.blogspot.soyamr.weather2.database

import android.content.Context

object Repo {

    operator fun invoke(context: Context): Repo {
        return this
    }

    private val cities = mutableListOf(
        City(0, "tomsk 0", "russia 0"),
        City(1, "tomsk 1", "russia 1"),
        City(2, "tomsk 2", "russia 2"),
        City(3, "tomsk 3", "russia 3"),
        City(4, "tomsk 4", "russia 4"),
        City(5, "tomsk 5", "russia 5"),
        City(6, "tomsk 6", "russia 6"),
        City(7, "tomsk 7", "russia 7"),
        City(8, "tomsk 8", "russia 8"),
        City(9, "tomsk 9", "russia 9"),
        City(10, "tomsk 10", "russia 10"),
        City(11, "tomsk 11", "russia 11"),
        City(12, "tomsk 12", "russia 12"),
        City(13, "tomsk 13", "russia 13"),
        City(14, "tomsk 14", "russia 14"),
        City(15, "tomsk 15", "russia 15"),
        City(16, "tomsk 16", "russia 16"),
        City(17, "tomsk 17", "russia 17"),
        City(18, "tomsk 18", "russia 18"),
        City(19, "tomsk 19", "russia 19"),
        City(20, "tomsk 20", "russia 20"),
    )


    fun getCities(): List<City> = cities

    fun editCity(id: Long, name: String, country: String) {
        val cityToEditIndex = cities.indexOfFirst { it.id == id }
        if (cityToEditIndex >= 0) {
            cities[cityToEditIndex] = City(
                id = id,
                name = name,
                country = country
            )
        }
    }

    fun getCity(cityId: Long): City = cities[cities.indexOfFirst { it.id == cityId }]


}