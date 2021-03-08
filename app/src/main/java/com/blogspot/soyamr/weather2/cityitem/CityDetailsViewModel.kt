package com.blogspot.soyamr.weather2.cityitem

import androidx.lifecycle.*
import com.blogspot.soyamr.domain.interactors.GetCityUseCase
import com.blogspot.soyamr.domain.model.City
import com.blogspot.soyamr.weather2.SingleLiveEvent
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CityDetailsViewModel @Inject constructor(
    private val getCityUseCase: GetCityUseCase,
    private val savedStateHandle: SavedStateHandle,
) : ViewModel() {

    //it's bad, but i really couldn't find a normal way to inject the value from safe args
    private var cityId: Long? = savedStateHandle.get("cityId")

    private val _city = MutableLiveData<City>()
    val city: LiveData<City> = _city

    private val _finish = SingleLiveEvent<Unit>()
    val finish: LiveData<Unit> = _finish

    val loading: MutableLiveData<Boolean> = MutableLiveData()

    init {
        viewModelScope.launch {
            loading.value = true
            _city.value = getCityUseCase(cityId!!)!!
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
