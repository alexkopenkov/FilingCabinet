package com.example.filingcabinet.ui.specialties

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.findNavController
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.filingcabinet.R
import com.example.filingcabinet.databinding.FragmentSpecialtiesBinding
import com.example.filingcabinet.ui.MainViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.onEach
import org.koin.androidx.viewmodel.ext.android.sharedViewModel

class SpecialtiesFragment : Fragment(R.layout.fragment_specialties) {

    private val viewBinding: FragmentSpecialtiesBinding by viewBinding()

    private val viewModel: MainViewModel by sharedViewModel()

    private val itemClickListener = OnItemClickListener { id, name ->
        val action = SpecialtiesFragmentDirections.actionSpecialityToEmployees(id, name)
        findNavController().navigate(action)
    }
    private val adapter = SpecialtiesAdapter(SpecialtyComparator, itemClickListener)

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initRecyclerView()
        attachObservers()
    }

    private fun initRecyclerView() {
        viewBinding.specialtyList.run {
            adapter = this@SpecialtiesFragment.adapter
            setHasFixedSize(true)
        }
    }

    private fun attachObservers() {
        viewLifecycleOwner.lifecycleScope.launchWhenCreated {
            viewModel.specialties
                .onEach { adapter.submitList(it) }
                .catch { }
                .collect()
        }
    }

}