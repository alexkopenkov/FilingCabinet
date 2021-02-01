package com.example.filingcabinet.ui.employees

import com.example.filingcabinet.domain.model.EmployeeModel

fun interface OnItemClickListener {

    fun onItemClick(employee: EmployeeModel)

}
