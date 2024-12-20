package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.repository.RepositoryMataKuliah
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.filterNotNull
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.flow.stateIn

class HomeMataKuliahViewModel(
    private val repositoryMataKuliah: RepositoryMataKuliah
) : ViewModel() {
    val homeUiState: StateFlow<HomeUiStateMataKuliah> = repositoryMataKuliah.getAllMataKuliah()
        .filterNotNull()
        .map {
            HomeUiStateMataKuliah(
                listMataKuliah = it.toList(),
                isLoading = false,
            )
        }
        .onStart {
            emit(HomeUiStateMataKuliah(isLoading = true))
            delay(900)
        }
        .catch {
            emit(
                HomeUiStateMataKuliah(
                    isLoading = false,
                    isError = true,
                    errorMessage = it.message ?: "Terjadi Kesalahan"
                )
            )
        }
        .stateIn(
            scope = viewModelScope,
            started = SharingStarted.WhileSubscribed(5000),
            initialValue = HomeUiStateMataKuliah(
                isLoading = true,
            )
        )
}

data class HomeUiStateMataKuliah (
    val listMataKuliah: List<MataKuliah> = listOf(),
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = ""
)