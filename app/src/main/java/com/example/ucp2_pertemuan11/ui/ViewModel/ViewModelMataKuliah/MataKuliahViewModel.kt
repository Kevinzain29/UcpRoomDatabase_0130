package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.repository.RepositoryMataKuliah
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.FormErrorState

class MataKuliahViewModel(private val repositoryMataKuliah: RepositoryMataKuliah) : ViewModel() {

    var uiState by mutableStateOf(MataKuliahUIState())

    fun updateState(mataKuliahEvent: MataKuliahEvent) {
        uiState = uiState.copy(
            mataKuliahEvent = mataKuliahEvent,
        )
    }

    //validasi data input pengguna
    private fun validateFields(): Boolean {
        val event = uiState.mataKuliahEvent
        val errorState = FormErrorState(
            Kode = if (event.Kode.isNotEmpty()) null else "Kode tidak boleh kosong",
            Nama = if (event.Nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            SKS = if (event.SKS.isNotEmpty()) null else "SKS tidak boleh kosong",
            Semester = if (event.Semester.isNotEmpty()) null else "Semester tidak boleh kosong",
            Jenis = if (event.Jenis.isNotEmpty()) null else "Jenis tidak boleh kosong",
            DosenPengampu = if (event.DosenPengampu.isNotEmpty()) null else "DosenPengampu tidak boleh kosong"
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
}

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