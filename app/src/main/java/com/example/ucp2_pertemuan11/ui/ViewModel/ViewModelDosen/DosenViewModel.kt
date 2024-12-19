package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import com.example.ucp2_pertemuan11.data.Entity.Dosen

data class DosenUIState(
    val dosenEvent: DosenEvent = DosenEvent(),
    val isEntryValid: FormErrorState = FormErrorState(),
    val snackBarMessage: String? = null
)

//untuk memvalidasi
data class FormErrorState(
    val Nidn: String? = null,
    val Nama: String? = null,
    val JenisKelamin: String? = null,
){
    fun isValid(): Boolean {
        return Nidn == null && Nama == null && JenisKelamin == null
    }
}

//menyimpan input form ke dalam entity
fun DosenEvent.toDosenEntity(): Dosen = Dosen(
    Nidn = Nidn,
    Nama = Nama,
    JenisKelamin = JenisKelamin
)
//untuk menyimpan inputan dari textfield ke variabel/menghandle textfield
data class DosenEvent(
    val Nidn: String = "",
    val Nama: String = "",
    val JenisKelamin: String = ""
)