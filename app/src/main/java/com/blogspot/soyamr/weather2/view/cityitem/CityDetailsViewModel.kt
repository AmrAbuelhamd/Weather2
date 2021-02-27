package com.blogspot.soyamr.weather2.view.cityitem

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo


class CityDetailsViewModelFactory(private val repo: Repo, val cityId: Long) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CityDetailsViewModel(repo, cityId) as T
    }
}

class CityDetailsViewModel(val repo: Repo, val cityId: Long) : ViewModel() {

    val city: LiveData<City> = MutableLiveData(repo.getCity(cityId))

    val name: MutableLiveData<String> = MutableLiveData("")
    val country: MutableLiveData<String> = MutableLiveData("")

    private val _finish = MutableLiveData<Boolean>(false)
    val finish: LiveData<Boolean> = _finish

    fun save() {
        repo.editCity(
            cityId,
            name = if (this.name.value.isNullOrBlank()) city.value!!.name else this.name.value!!,
            country = if (this.country.value.isNullOrBlank()) city.value!!.country else this.country.value!!,
        )
        _finish.value = true
    }

}