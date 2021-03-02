package com.blogspot.soyamr.weather2.view.citieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo


class CitiesListViewModel(val repo: Repo) : ViewModel() {

    private val _cities = MutableLiveData<List<City>>(repo.getCities())
    val cities: LiveData<List<City>> = _cities

}