package com.blogspot.soyamr.weather2.view.citieslist

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo


class CitiesListViewModelFactory(private val repo: Repo) : ViewModelProvider.Factory {
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return CitiesListViewModel(repo) as T
    }
}

class CitiesListViewModel(val repo: Repo) : ViewModel() {

    private val _cities = MutableLiveData<List<City>>(repo.getCities())
    val cities: LiveData<List<City>> = _cities

}