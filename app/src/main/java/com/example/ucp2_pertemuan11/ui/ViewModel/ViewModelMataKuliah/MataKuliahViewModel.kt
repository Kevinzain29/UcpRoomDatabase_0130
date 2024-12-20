package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.DosenEvent

data class MataKuliahUIState(
    val mataKuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null
)

//untuk memvalidasi
data class FormErrorState(
    val Kode: String? = null,
    val Nama: String? = null,
    val SKS: String? = null,
    val Semester: String? = null,
    val Jenis: String? = null,
    val DosenPengampu: String? = null
){
    fun isValid(): Boolean {
        return Kode == null && Nama == null && SKS == null &&
                Semester == null && Jenis == null && DosenPengampu == null
    }
}

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