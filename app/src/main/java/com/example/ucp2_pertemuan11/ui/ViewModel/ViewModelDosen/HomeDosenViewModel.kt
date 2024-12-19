package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import com.example.ucp2_pertemuan11.data.Entity.Dosen




data class HomeUiState (
    val listDosen: List<Dosen> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)