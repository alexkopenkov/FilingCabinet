package com.example.filingcabinet.ui.employees

import androidx.recyclerview.widget.DiffUtil
import com.example.filingcabinet.domain.model.EmployeeModel

object EmployeeComparator : DiffUtil.ItemCallback<EmployeeModel>() {

    override fun areItemsTheSame(oldItem: EmployeeModel, newItem: EmployeeModel): Boolean {
        return oldItem.firstName + oldItem.lastName == newItem.firstName + newItem.lastName
    }

    override fun areContentsTheSame(oldItem: EmployeeModel, newItem: EmployeeModel): Boolean {
        return oldItem == newItem
    }

}
