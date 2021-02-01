package com.example.filingcabinet.ui.specialties

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.ItemSpecialtyBinding
import com.example.filingcabinet.domain.model.SpecialtyModel

class SpecialtyViewHolder(
    parent: ViewGroup,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_specialty, parent, false)
) {

    private val binding = ItemSpecialtyBinding.bind(itemView)
    private val specialtyCard = binding.specialtyCard
    private val specialtyName = binding.specialtyName

    fun bind(specialty: SpecialtyModel) {
        specialtyName.text = specialty.name
        specialtyCard.setOnClickListener { listener.onItemClick(specialty.id, specialty.name) }
    }

}
