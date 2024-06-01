package com.maninmiddle.presentation.tests

import com.maninmiddle.domain.model.Test

data class TestsUiState (
    val tests: List<Test>? = null,
    val isLoading: Boolean = false,
    val error: String? = null
)