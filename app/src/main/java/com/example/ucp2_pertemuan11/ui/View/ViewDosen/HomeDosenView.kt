package com.example.ucp2_pertemuan11.ui.View.ViewDosen

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Face
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Card
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
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.HomeDosenViewModel
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.HomeUiState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelDosen.PenyediaDosenViewModel
import com.example.ucp2_pertemuan11.ui.costumwidget.TopAppBar
import kotlinx.coroutines.launch

@Composable
fun HomeDosenView(
    viewModel: HomeDosenViewModel = viewModel(factory = PenyediaDosenViewModel.Factory),
    onAddDosen: () -> Unit = {},
    onDetailClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    Scaffold(
        topBar = {
            TopAppBar(
                judul = "Daftar Dosen",
                showBackButton = false,
                onBack = {},
                modifier = modifier
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = onAddDosen,
                shape = MaterialTheme.shapes.medium,
                modifier = Modifier.padding(16.dp)
            ){
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Tambah Dosen",
                )

            }
        }
    ){ innerpadding ->
        val homeUiState by viewModel.homeUiState.collectAsState()

        BodyHomeDosenView(
            homeUiState = homeUiState,
            onClick = {
                onDetailClick(it)
            },
            modifier = Modifier.padding(innerpadding)
        )
    }
}

@Composable
fun BodyHomeDosenView(
    homeUiState: HomeUiState,
    onClick: (String) -> Unit = {},
    modifier: Modifier = Modifier
){
    val coroutineScope = rememberCoroutineScope()
    val snackbarHostState = remember { SnackbarHostState() }
    when {
        homeUiState.isLoading -> {
            //menampilkan indikator loding
            Box(
                modifier = Modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                CircularProgressIndicator()
            }
        }
        homeUiState.isError -> {
            LaunchedEffect(homeUiState.errorMessage) {
                homeUiState.errorMessage.let { Message ->
                    coroutineScope.launch {
                        snackbarHostState.showSnackbar(Message)
                    }
                }
            }
        }
        homeUiState.listDosen.isEmpty() ->{
            Box(
                modifier = modifier.fillMaxSize(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Tidak ada data mahasiswa",
                    fontSize = 18.sp,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(16.dp)
                )
            }
        }
        else -> {
            ListDOSEN(
                listDosen = homeUiState.listDosen,
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

@Composable
fun ListDOSEN(
    listDosen: List<Dosen>,
    modifier: Modifier = Modifier,
    onClick: (String) -> Unit = {}
) {
    LazyColumn(
        modifier = modifier
    ) {
        items(
            items = listDosen,
            itemContent = { dsn ->
                Carddsn(
                    dsn = dsn,
                    onClick = { onClick(dsn.Nidn) }
                )
            }
        )
    }
}

@Composable
fun Carddsn(
    dsn : Dosen,
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {}
){
    Card(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
    ){
        Column(
            modifier = Modifier.padding(8.dp)
        ){
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically

            ){
                Icon(imageVector = Icons.Filled.Person, contentDescription = "")
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = dsn.Nidn,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Filled.DateRange, contentDescription = "")
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = dsn.Nama,
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                )
            }
            Row(
                modifier = Modifier.fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically
            ){
                Icon(imageVector = Icons.Filled.Home, contentDescription = "")
                Spacer(modifier = Modifier.padding(4.dp))
                Text(
                    text = dsn.JenisKelamin,
                    fontWeight = FontWeight.Bold,
                )
            }
        }
    }
}