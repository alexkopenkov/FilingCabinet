package com.example.filingcabinet.ui.employees

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.isVisible
import androidx.recyclerview.widget.RecyclerView
import coil.load
import coil.transform.CircleCropTransformation
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.ItemEmployeeBinding
import com.example.filingcabinet.domain.model.EmployeeModel

class EmployeeViewHolder(
    private val parent: ViewGroup,
    private val listener: OnItemClickListener
) : RecyclerView.ViewHolder(
    LayoutInflater.from(parent.context).inflate(R.layout.item_employee, parent, false)
) {

    private val binding = ItemEmployeeBinding.bind(itemView)
    private val employeeCard = binding.employeeCard
    private val employeeFullName = binding.employeeName
    private val employeePhoto = binding.employeePhoto
    private val employeeAge = binding.employeeAge

    fun bind(employee: EmployeeModel) {
        employeeFullName.text = employee.fullName
        if (employee.age == 0) employeeAge.isVisible = false
        else employeeAge.text = parent.context.getString(R.string.employee_age, employee.age)

        if (employee.avatar.isNullOrBlank())
            employeePhoto.setImageResource(R.drawable.ic_no_photo)
        else employeePhoto.load(employee.avatar) {
            placeholder(R.drawable.ic_no_photo)
            error(R.drawable.ic_no_photo)
            transformations(CircleCropTransformation())
        }
        employeeCard.setOnClickListener { listener.onItemClick(employee) }


    }

}
