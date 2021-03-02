package com.blogspot.soyamr.weather2.view.citieslist

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.blogspot.soyamr.weather2.database.City
import com.blogspot.soyamr.weather2.database.Repo
import com.blogspot.soyamr.weather2.databinding.FragmentCitiesListBinding

class CitiesListFragment : Fragment() {

    private lateinit var binding: FragmentCitiesListBinding
    private val viewModel: CitiesListViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass.getConstructor(Repo::class.java)
                    .newInstance(Repo(requireContext()))
        }
    }
    private lateinit var adapter: CitiesAdapter
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentCitiesListBinding.inflate(inflater, container, false).also {
            it.viewModel = this.viewModel
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
        viewModel.cities.observe(this, ::updateRecyclerList)
    }

    private fun updateRecyclerList(list: List<City>?) {
        list.let {
            adapter.submitList(it)
        }
    }
}
