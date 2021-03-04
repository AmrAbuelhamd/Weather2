package com.blogspot.soyamr.weather2.presentation.cityitem

import android.content.Context
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
import com.blogspot.soyamr.weather2.databinding.FragmentCityDetailsBinding
import com.blogspot.soyamr.weather2.domain.City
import dagger.hilt.android.AndroidEntryPoint


@AndroidEntryPoint
class CityDetailsFragment : Fragment(R.layout.fragment_city_details) {

    private val binding: FragmentCityDetailsBinding by viewBinding()


    private val viewModel: CityDetailsViewModel by viewModels()


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setListeners()
        setViewModelListeners()
    }

    private fun setViewModelListeners() {
        viewModel.city.observe(viewLifecycleOwner, ::bindCityData)
        viewModel.finish.observe(viewLifecycleOwner, {
            findNavController().popBackStack()
        })
        viewModel.loading.observe(viewLifecycleOwner, ::showLoadingState)

    }

    private fun showLoadingState(state: Boolean) {
        binding.progressBar.visibility = if (state) View.VISIBLE else View.GONE
    }

    private fun setListeners() {
        binding.goBackButton.setOnClickListener {
            viewModel.goBack()
//            viewModel.save(
//                binding.cityNameEditText.text.toString().trim(),
//                binding.countryNameEditText.text.toString().trim()
//            )
        }
    }

    private fun bindCityData(city: City?) {
        city?.let {
            binding.cityNametextView.text = it.name
            binding.countryNameTextView.text = requireContext().getStringResourceByName(it.country)
            binding.idTextView.text = it.id.toString()
        }
    }

    private fun Context.getStringResourceByName(stringName: String): String {
        val resId = resources.getIdentifier(stringName, "string", packageName)
        return getString(resId)
    }
}