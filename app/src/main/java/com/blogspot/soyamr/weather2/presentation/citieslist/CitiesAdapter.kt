package com.blogspot.soyamr.weather2.presentation.citieslist

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.blogspot.soyamr.weather2.domain.model.City
import com.blogspot.soyamr.weather2.databinding.ListItemCityBinding


class CitiesAdapter(private val listener: (City) -> Unit) :
    ListAdapter<City, CitiesAdapter.ViewHolder>(CityDiffCallback()) {

    class ViewHolder(private val binding: ListItemCityBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(item: City, listener: (City) -> Unit) {
            binding.cityNameTextView.text = item.name
            binding.countryTextView.text = item.country
            binding.root.setOnClickListener { listener(item) }
        }

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListItemCityBinding.inflate(layoutInflater, parent, false)
                return ViewHolder(binding)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item, listener)
    }
}

class CityDiffCallback : DiffUtil.ItemCallback<City>() {
    override fun areItemsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem.id == newItem.id
    }


    override fun areContentsTheSame(oldItem: City, newItem: City): Boolean {
        return oldItem == newItem
    }

}