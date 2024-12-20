package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import com.example.ucp2_pertemuan11.data.Entity.Dosen


data class DetailUiState(
    val detailUiEvent: DosenEvent = DosenEvent(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
) {
    val isUiEventEmpty: Boolean
        get() = detailUiEvent == DosenEvent()

    val isUiEventNotEmpty: Boolean
        get() = detailUiEvent != DosenEvent()
}  //data class digunakan untuk menampung data yang akan ditampilkan di UI

fun Dosen.toDetailUiEvent(): DosenEvent {
    return DosenEvent(
        Nidn = Nidn,
        Nama = Nama,
        JenisKelamin = JenisKelamin
    )
}