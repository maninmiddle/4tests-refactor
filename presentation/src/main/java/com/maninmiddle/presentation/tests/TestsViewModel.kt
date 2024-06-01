package com.maninmiddle.presentation.tests

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.maninmiddle.data.repository.TestsRepositoryImpl
import com.maninmiddle.domain.util.ApiState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class TestsViewModel @Inject constructor(
    private val repository: TestsRepositoryImpl
) : ViewModel() {
    private val _state = MutableStateFlow(TestsUiState())
    val state: StateFlow<TestsUiState>
        get() = _state

    init {
        getTests()
    }

    private fun getTests() {
        viewModelScope.launch {
            _state.value = state.value.copy(
                tests = null,
                isLoading = true,
                error = null
            )
            when (val result = repository.getTests()) {
                is ApiState.Success -> {
                    _state.value = state.value.copy(
                        tests = result.data,
                        isLoading = false,
                        error = null
                    )
                }

                is ApiState.Error -> {
                    _state.value = state.value.copy(
                        tests = null,
                        isLoading = false,
                        error = result.message
                    )
                }

                else -> _state.value = state.value.copy(
                    tests = null,
                    isLoading = false,
                    error = "Unexpected error"
                )
            }
        }
    }
}