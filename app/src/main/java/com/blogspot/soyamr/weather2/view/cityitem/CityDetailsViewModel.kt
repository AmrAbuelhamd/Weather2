package com.blogspot.soyamr.weather2.view.cityitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.soyamr.weather2.SingleLiveEvent
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo


class CityDetailsViewModel(private val repo: Repo, val cityId: Long) : ViewModel() {

    val city: LiveData<City> = MutableLiveData(repo.getCity(cityId))

    private val _finish = SingleLiveEvent<Unit>()
    val finish: LiveData<Unit> = _finish

    fun save(cityName: String, countryName: String) {
        repo.editCity(
            cityId,
            name = if (cityName.isNotEmpty()) cityName else city.value!!.name,
            country = if (countryName.isNotEmpty()) countryName else city.value!!.country,
        )
        _finish.invoke()
    }

}

fun SingleLiveEvent<Unit>.invoke() {
    this.value = Unit
}
