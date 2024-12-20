package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.repository.RepositoryMataKuliah
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.launch

class UpdateMataKuliahViewModel(
    savedStateHandle: SavedStateHandle,
    private val repositoryMataKuliah: RepositoryMataKuliah
) : ViewModel() {

    var updateUIState by mutableStateOf(MataKuliahUIState())
        private set

    private val _Kode: String = checkNotNull(savedStateHandle[DestinasiUpdateMataKuliah.Kode])

    init {
        viewModelScope.launch {
            updateUIState = repositoryMataKuliah.getMataKuliah(_Kode)
                .filterNotNull()
                .first()
                .toUIStateMataKuliah()
        }
    }

    fun updateState(mataKuliahEvent: MataKuliahEvent) {
        updateUIState = updateUIState.copy(
            mataKuliahEvent = mataKuliahEvent
        )
    }
}

fun MataKuliah.toUIStateMataKuliah(): MataKuliahUIState = MataKuliahUIState(
    mataKuliahEvent = this.toDetailUiEvent()
)