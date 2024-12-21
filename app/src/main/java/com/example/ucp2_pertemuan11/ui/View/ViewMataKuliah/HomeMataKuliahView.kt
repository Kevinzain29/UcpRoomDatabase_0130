package com.example.ucp2_pertemuan11.ui.View.ViewMataKuliah

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SnackbarHostState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.HomeUiState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.HomeMataKuliahViewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.HomeUiStateMataKuliah
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.PenyediaMataKuliahViewModel
import com.example.ucp2_pertemuan11.ui.costumwidget.TopAppBar
import kotlinx.coroutines.launch

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
        val homeUiState by viewModel.homeUiStateMataKuliah.collectAsState()

        BodyHomeMataKuliahView(
            homeUiStateMataKuliah = homeUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerpadding)
        )
    }
}

@Composable
fun BodyHomeMataKuliahView(
    homeUiStateMataKuliah: HomeUiStateMataKuliah,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    when {
        homeUiStateMataKuliah.isLoading -> {
            //menampilkan indikator loding
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        homeUiStateMataKuliah.isError -> {
            LaunchedEffect(homeUiStateMataKuliah.errorMessage) {
                homeUiStateMataKuliah.errorMessage.let { Message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(Message)
                    }
                }
            }
        }
        homeUiStateMataKuliah.listMataKuliah.isEmpty() ->{
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Tidak ada data Mata Kuliah",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        else -> {
            ListMATAKULIAH(
                listMataKuliah = homeUiStateMataKuliah.listMataKuliah,
                onClick = {
                    onClick(it)
                    println(
                        it
                    )
                },
                modifier = modifier
            )
        }
    }
}