package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah


data class HomeUiStateMataKuliah (
    val listMataKuliah: List<MataKuliah> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)