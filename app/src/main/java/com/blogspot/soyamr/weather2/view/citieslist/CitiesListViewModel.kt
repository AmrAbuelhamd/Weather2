package com.blogspot.soyamr.weather2.view.citieslist

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.blogspot.soyamr.weather2.repository.Repo
import com.blogspot.soyamr.weather2.repository.domain.City
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject


@HiltViewModel
class CitiesListViewModel  @Inject constructor(val repo: Repo) : ViewModel() {

    val loading: MutableLiveData<Boolean> = MutableLiveData()

    private val _cities = MutableLiveData<List<City>>()
    val cities: LiveData<List<City>> = _cities

    init {
        viewModelScope.launch {
            loading.value = true
            _cities.value = repo.getCities()
            loading.value = false
        }
    }

}