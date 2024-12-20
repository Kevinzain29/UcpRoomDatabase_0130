package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

data class DetailUiState(
    val detailUiEvent: MataKuliahEvent = MataKuliahEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) {
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == MataKuliahEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != MataKuliahEvent()
} //data class untuk menampung data yang akan ditampilkan di UI