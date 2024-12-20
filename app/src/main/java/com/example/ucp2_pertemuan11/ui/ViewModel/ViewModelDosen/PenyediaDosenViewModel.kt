package com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen

import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.createSavedStateHandle
import androidx.lifecycle.viewmodel.CreationExtras
import androidx.lifecycle.viewmodel.initializer
import androidx.lifecycle.viewmodel.viewModelFactory
import com.example.ucp2_pertemuan11.UnivApp

object PenyediaDosenViewModel{
    val Factory = viewModelFactory {
        initializer {
            DosenViewModel(
                UnivApp().containerApp.repositoryDosen
            )
        }
        initializer {
            HomeDosenViewModel(
                UnivApp().containerApp.repositoryDosen
            )
        }
        initializer {
            DetailDosenViewModel(
                createSavedStateHandle(),
                UnivApp().containerApp.repositoryDosen
            )
        }
    }
}

fun CreationExtras.UnivApp(): UnivApp =
    (this[ViewModelProvider.AndroidViewModelFactory.APPLICATION_KEY] as UnivApp)