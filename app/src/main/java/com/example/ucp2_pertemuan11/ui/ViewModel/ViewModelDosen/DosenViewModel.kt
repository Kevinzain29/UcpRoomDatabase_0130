package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import com.example.ucp2_pertemuan11.data.Entity.Dosen

fun DosenEvent.toDosenEntity(): Dosen = Dosen(
    Nidn = Nidn,
    Nama = Nama,
    JenisKelamin = JenisKelamin
)

data class DosenEvent(
    val Nidn: String = "",
    val Nama: String = "",
    val JenisKelamin: String = ""
)