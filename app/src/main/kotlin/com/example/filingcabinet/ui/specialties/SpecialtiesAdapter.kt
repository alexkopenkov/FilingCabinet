package com.example.filingcabinet.ui.specialties

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.filingcabinet.domain.model.SpecialtyModel

class SpecialtiesAdapter(
    diffCallback: DiffUtil.ItemCallback<SpecialtyModel>,
    private val listener: OnItemClickListener
) : ListAdapter<SpecialtyModel, SpecialtyViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        SpecialtyViewHolder(parent, listener)

    override fun onBindViewHolder(holder: SpecialtyViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}
