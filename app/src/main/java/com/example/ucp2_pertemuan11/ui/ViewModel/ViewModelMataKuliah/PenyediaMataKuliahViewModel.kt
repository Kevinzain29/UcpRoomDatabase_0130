package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2_pertemuan11.UnivApp

object PenyediaMataKuliahViewModel{
    val Factory = viewModelFactory {
        initializer {
            MataKuliahViewModel(
                UnivApp().containerApp.repositoryMataKuliah
            )
        }
        initializer {
            HomeMataKuliahViewModel(
                UnivApp().containerApp.repositoryMataKuliah
            )
        }
        initializer {
            DetailMataKuliahViewModel(
                createSavedStateHandle(),
                UnivApp().containerApp.repositoryMataKuliah
            )
        }
        initializer {
            UpdateMataKuliahViewModel(
                createSavedStateHandle(),
                UnivApp().containerApp.repositoryMataKuliah
            )
        }
    }
}

fun CreationExtras.UnivApp(): UnivApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UnivApp)