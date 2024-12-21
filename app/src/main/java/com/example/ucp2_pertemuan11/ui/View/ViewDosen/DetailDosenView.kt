package com.example.ucp2_pertemuan11.ui.View.ViewDosen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.DetailDosenViewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.DetailUiState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.PenyediaDosenViewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.toDosenEntity
import com.example.ucp2_pertemuan11.ui.costumwidget.TopAppBar

@Composable
fun DetailDosenView(
    modifier: Modifier = Modifier,
    viewModel: DetailDosenViewModel = viewModel(factory = PenyediaDosenViewModel.Factory),
    onBack: () -> Unit = {},
){
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Detail Dosen",
                showBackButton = true,
                onBack = onBack,
                modifier = modifier
            )
        },
    ) { innerpadding ->
        val detailUiState by viewModel.detailUiState.collectAsState()

        BodyDetailDosen(
            modifier = Modifier.padding(innerpadding),
            detailUiState = detailUiState
        )
    }
}

@Composable
fun BodyDetailDosen(
    modifier: Modifier = Modifier,
    detailUiState: DetailUiState = DetailUiState(),
){
    when {
        detailUiState.isLoading -> {
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        detailUiState.isUiEventNotEmpty -> {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(16.dp)
            ){
                ItemDetailDosen(
                    dosen = detailUiState.detailUiEvent.toDosenEntity(),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(8.dp))
            }
        }
        detailUiState.isUiEventEmpty -> {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Data Dosen tidak ditemukan",
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}