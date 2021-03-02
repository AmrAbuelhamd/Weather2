package com.blogspot.soyamr.weather2.view.cityitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogspot.soyamr.weather2.SingleLiveEvent
import com.blogspot.soyamr.weather2.repository.Repo
import com.blogspot.soyamr.weather2.repository.domain.City
import kotlinx.coroutines.launch


class CityDetailsViewModel(private val repo: Repo, val cityId: Long) : ViewModel() {

    private val _city = MutableLiveData<City>()
    val city: LiveData<City> = _city

    private val _finish = SingleLiveEvent<Unit>()
    val finish: LiveData<Unit> = _finish

    val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            loading.value = true
            _city.value = repo.getCity(cityId)
            loading.value = false

        }
    }


    fun goBack() {
        _finish.invoke()
    }
//    fun save(cityName: String, countryName: String) {
//        repo.editCity(
//            cityId,
//            name = if (cityName.isNotEmpty()) cityName else city.value!!.name,
//            country = if (countryName.isNotEmpty()) countryName else city.value!!.country,
//        )
//        _finish.invoke()
//    }

}

fun SingleLiveEvent<Unit>.invoke() {
    this.value = Unit
}
