package com.blogspot.soyamr.weather2.view.citieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo
import com.blogspot.soyamr.weather2.databinding.FragmentCitiesListBinding

class CitiesListFragment : Fragment() {

    private lateinit var binding: FragmentCitiesListBinding
    private lateinit var viewModel: CitiesListViewModel
    private lateinit var adapter: CitiesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCitiesListBinding.inflate(inflater, container, false).also {
            viewModel =
                ViewModelProvider(this, CitiesListViewModelFactory(Repo(requireContext()))).get(
                    CitiesListViewModel::class.java
                )
            it.viewModel = viewModel
            it.lifecycleOwner = this
        }

        adapter = CitiesAdapter() {
            findNavController().navigate(
                CitiesListFragmentDirections.actionCitiesListFragment2ToCityDetailsFragment(
                    it.id
                )
            )
        }
        binding.citiesList.adapter = adapter

        return binding.root
    }

    override fun onResume() {
        super.onResume()
        viewModel.cities.observe(viewLifecycleOwner, {
            it?.let {
                val newList = mutableListOf<City>()
                it.forEach { item -> newList.add(item.copy()) }
                adapter.submitList(newList)
            }
        })
    }
}
