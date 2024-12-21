package com.example.ucp2_pertemuan11.ui.View.ViewMataKuliah

import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.HomeMataKuliahViewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.PenyediaMataKuliahViewModel
import com.example.ucp2_pertemuan11.ui.costumwidget.TopAppBar

@Composable
fun HomeMataKuliahView(
    viewModel: HomeMataKuliahViewModel = viewModel(factory = PenyediaMataKuliahViewModel.Factory),
    onAddMataKuliah: () -> Unit = {},
    onDetailClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Daftar Mata Kuliah",
                showBackButton = false,
                onBack = {},
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddMataKuliah,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Mata Kuliah",
                )

            }
        }
    ){ innerpadding ->
        val homeUiState by viewModel.homeUiState.collectAsState()

        BodyHomeMhsView(
            homeUiState = homeUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerpadding)
        )
    }
}