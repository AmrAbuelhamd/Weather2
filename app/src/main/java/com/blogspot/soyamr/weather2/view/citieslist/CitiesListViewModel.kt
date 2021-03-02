package com.blogspot.soyamr.weather2.view.citieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogspot.soyamr.weather2.repository.City
import com.blogspot.soyamr.weather2.repository.Repo
import kotlinx.coroutines.launch


class CitiesListViewModel(val repo: Repo) : ViewModel() {

    private val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> = _cities

    init {
        viewModelScope.launch {
            _cities.value = repo.getCities()
        }
    }

}