package com.example.filingcabinet.ui.employees

import android.graphics.drawable.InsetDrawable
import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import androidx.recyclerview.widget.DividerItemDecoration
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.FragmentEmployeesBinding
import com.example.filingcabinet.ui.MainViewModel
import com.example.filingcabinet.ui.identity.IdentityUiModel
import org.koin.androidx.viewmodel.ext.android.sharedViewModel
import java.util.*

class EmployeesFragment : Fragment(R.layout.fragment_employees) {

    private val viewBinding: FragmentEmployeesBinding by viewBinding()

    private val viewModel: MainViewModel by sharedViewModel()

    private val args: EmployeesFragmentArgs by navArgs()

    private val itemClickListener = OnItemClickListener { employee ->
        val identityModel = IdentityUiModel(
            fullName = employee.fullName,
            birthday = employee.birthdayFormat,
            age = employee.age,
            avatar = employee.avatar,
            specialty = args.specialtyName
        )
        val action = EmployeesFragmentDirections.actionEmployeesToIdentity(identityModel)
        findNavController().navigate(action)
    }
    private val adapter = EmployeesAdapter(EmployeeComparator, itemClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        attachObservers()
    }

    private fun initRecyclerView() {
        viewBinding.employeeList.run {
            adapter = this@EmployeesFragment.adapter
            setHasFixedSize(true)

            val ATTRS = intArrayOf(android.R.attr.listDivider)

            val a = requireContext().obtainStyledAttributes(ATTRS)
            val divider = a.getDrawable(0)
            val inset = resources.getDimensionPixelSize(R.dimen.item_margin_divider_72dp)
            val insetDivider = InsetDrawable(divider, inset, 0, 0, 0)
            a.recycle()

            val itemDecoration = DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL)
            itemDecoration.setDrawable(insetDivider)

            addItemDecoration(itemDecoration)
        }
    }

    private fun attachObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            val employees = viewModel.getEmployees(args.specialtyId)
            adapter.submitList(employees)
        }
    }

}