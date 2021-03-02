package com.blogspot.soyamr.weather2.view.cityitem

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blogspot.soyamr.weather2.repository.domain.City
import com.blogspot.soyamr.weather2.repository.Repo
import com.blogspot.soyamr.weather2.databinding.FragmentCityDetailsBinding

class CityDetailsFragment : Fragment() {


    private var _binding: FragmentCityDetailsBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    private val viewModel: CityDetailsViewModel by viewModels {
        object : ViewModelProvider.Factory {
            override fun <T : ViewModel?> create(modelClass: Class<T>): T =
                modelClass.getConstructor(Repo::class.java, Long::class.java)
                    .newInstance(Repo(requireContext()), args.cityId)
        }
    }

    val args: CityDetailsFragmentArgs by navArgs()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        _binding = FragmentCityDetailsBinding.inflate(inflater, container, false)

        setListeners()
        setViewModelListeners()
        return binding.root
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

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
    private fun Context.getStringResourceByName(stringName: String): String {
        val resId = resources.getIdentifier(stringName, "string", packageName)
        return getString(resId)
    }
}