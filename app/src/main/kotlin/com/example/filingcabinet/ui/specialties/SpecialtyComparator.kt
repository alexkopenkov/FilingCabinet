package com.example.filingcabinet.ui.specialties

import androidx.recyclerview.widget.DiffUtil
import com.example.filingcabinet.domain.model.SpecialtyModel

object SpecialtyComparator : DiffUtil.ItemCallback<SpecialtyModel>() {

    override fun areItemsTheSame(oldItem: SpecialtyModel, newItem: SpecialtyModel): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: SpecialtyModel, newItem: SpecialtyModel): Boolean {
        return oldItem == newItem
    }

}
