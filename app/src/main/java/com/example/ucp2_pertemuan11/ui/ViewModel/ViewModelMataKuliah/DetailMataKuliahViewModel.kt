package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah

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

fun MataKuliah.toDetailUiEvent(): MataKuliahEvent {
    return MataKuliahEvent(
        Kode = Kode,
        Nama = Nama,
        SKS = SKS,
        Semester = Semester,
        Jenis = Jenis,
        DosenPengampu = DosenPengampu
    )
}