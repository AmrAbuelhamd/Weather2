package com.blogspot.soyamr.weather2.view.cityitem

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import com.blogspot.soyamr.weather2.database.Repo
import com.blogspot.soyamr.weather2.databinding.FragmentCityDetailsBinding

class CityDetailsFragment : Fragment() {


    private lateinit var binding: FragmentCityDetailsBinding
    private lateinit var viewModel: CityDetailsViewModel

    val args: CityDetailsFragmentArgs by navArgs()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentCityDetailsBinding.inflate(inflater, container, false)


        viewModel =
            ViewModelProvider(
                this,
                CityDetailsViewModelFactory(Repo(requireContext()), args.cityId)
            ).get(
                CityDetailsViewModel::class.java
            )
        binding.viewModel = viewModel
        binding.lifecycleOwner = this


        viewModel.finish.observe(viewLifecycleOwner, {
            it.let {
                if (it)
                    findNavController().popBackStack()
            }
        })
        return binding.root
    }

}