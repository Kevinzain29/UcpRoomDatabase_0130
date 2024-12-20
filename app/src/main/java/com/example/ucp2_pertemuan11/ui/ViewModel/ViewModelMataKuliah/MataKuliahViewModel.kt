package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah


//menyimpan input form ke dalam entity
fun MataKuliahEvent.toMataKuliahEntity(): MataKuliah = MataKuliah(
    Kode = Kode,
    Nama = Nama,
    SKS = SKS,
    Semester = Semester,
    Jenis = Jenis,
    DosenPengampu = DosenPengampu
)
//untuk menyimpan inputan dari textfield ke variabel/menghandle textfield
data class MataKuliahEvent(
    val Kode: String = "",
    val Nama: String = "",
    val SKS: String = "",
    val Semester: String = "",
    val Jenis: String = "",
    val DosenPengampu: String = ""
)