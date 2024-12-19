package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.repository.RepositoryDosen

class DosenViewModel(private val repositoryDosen: RepositoryDosen) : ViewModel() {

    var uiState by mutableStateOf(DosenUIState())

    fun updateState(dosenEvent: DosenEvent) {
        uiState = uiState.copy(
            dosenEvent = dosenEvent,
        )
    }
    //validasi data input pengguna
    private fun validateFields(): Boolean {
        val event = uiState.dosenEvent
        val errorState = FormErrorState(
            Nidn = if (event.Nidn.isNotEmpty()) null else "Nidn tidak boleh kosong",
            Nama = if (event.Nama.isNotEmpty()) null else "Nama tidak boleh kosong",
            JenisKelamin = if (event.JenisKelamin.isNotEmpty()) null else "JenisKelamin tidak boleh kosong",
        )
        uiState = uiState.copy(isEntryValid = errorState)
        return errorState.isValid()
    }
}


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