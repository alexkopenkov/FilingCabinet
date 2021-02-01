package com.example.filingcabinet.ui.employees

import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import com.example.filingcabinet.domain.model.EmployeeModel
import com.example.filingcabinet.domain.model.SpecialtyModel
import com.example.filingcabinet.ui.specialties.SpecialtyViewHolder

class EmployeesAdapter(
    diffCallback: DiffUtil.ItemCallback<EmployeeModel>,
    private val listener: OnItemClickListener
) : ListAdapter<EmployeeModel, EmployeeViewHolder>(diffCallback) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        EmployeeViewHolder(parent, listener)

    override fun onBindViewHolder(holder: EmployeeViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}
