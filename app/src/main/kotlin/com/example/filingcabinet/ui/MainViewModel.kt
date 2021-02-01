package com.example.filingcabinet.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.filingcabinet.domain.model.SpecialtyModel
import com.example.filingcabinet.domain.repository.FillingCabinetRepository
import com.example.filingcabinet.utils.Result
import kotlinx.coroutines.flow.*

class MainViewModel(
    private val repository: FillingCabinetRepository
) : ViewModel() {

    private val _specialties = MutableStateFlow<List<SpecialtyModel>>(emptyList())
    val specialties: StateFlow<List<SpecialtyModel>> get() = _specialties

    private val _isLoading = MutableSharedFlow<Boolean>()
    val isLoading: SharedFlow<Boolean> get() = _isLoading

    private val _isError = MutableSharedFlow<Boolean>()
    val isError: SharedFlow<Boolean> get() = _isError

    init {

        repository.getSpecialties()
            .onEach {
                when (it) {
                    Result.Loading -> { _isLoading.emit(true) }
                    is Result.Success -> {
                        _isLoading.emit(false)
                        _specialties.value = it.data
                    }
                    is Result.Error -> {
                        _isLoading.emit(false)
                        _isError.emit(true)
                    }
                }
            }
            .catch { _isError.emit(true) }
            .launchIn(viewModelScope)

    }

    suspend fun getEmployees(specialtyId: Int) = repository.getEmployees(specialtyId)

}