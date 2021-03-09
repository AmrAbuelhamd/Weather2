package com.blogspot.soyamr.weather2.presentation.citieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.soyamr.weather2.domain.interactors.GetCitiesUseCase
import com.blogspot.soyamr.weather2.domain.model.City
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.android.schedulers.AndroidSchedulers
import javax.inject.Inject


@HiltViewModel
class CitiesListViewModel @Inject constructor(private val getCitiesUseCase: GetCitiesUseCase) :
    ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData()

    private val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> = _cities

    init {
        loading.value = true
        val ss = getCitiesUseCase()
            .observeOn(AndroidSchedulers.mainThread())
            .doAfterTerminate {
                loading.value = false
            }
            .subscribe({
                _cities.value = it
            }, {})

    }

}