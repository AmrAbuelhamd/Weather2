package com.blogspot.soyamr.weather2.presentation.citieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.blogspot.soyamr.weather2.R
import com.blogspot.soyamr.weather2.databinding.FragmentCitiesListBinding
import com.blogspot.soyamr.weather2.domain.City
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class CitiesListFragment : Fragment(R.layout.fragment_cities_list) {

    private val binding: FragmentCitiesListBinding by viewBinding()

    private val viewModel: CitiesListViewModel by viewModels()

    private lateinit var adapter: CitiesAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        adapter = CitiesAdapter() {
            findNavController().navigate(
                CitiesListFragmentDirections.actionCitiesListFragment2ToCityDetailsFragment(
                    it.id
                )
            )
        }
        binding.citiesList.adapter = adapter

        viewModel.loading.observe(viewLifecycleOwner, ::showLoadingState)
    }

    private fun showLoadingState(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }

    override fun onResume() {
        super.onResume()
        viewModel.cities.observe(this, ::updateRecyclerList)
    }

    private fun updateRecyclerList(list: List<City>?) {
        list.let {
            adapter.submitList(it)
        }
    }
}
