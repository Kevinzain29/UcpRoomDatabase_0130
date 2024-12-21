package com.example.ucp2_pertemuan11.ui.View.ViewMataKuliah

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.DetailUiState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.toMataKuliahEntity

@Composable
fun BodyDetailMataKuliah(
    modifier: Modifier = Modifier,
    detailUiState: DetailUiState = DetailUiState(),
    onDeleteClick: () -> Unit = {}
){
    var deleteConfirmationRequired by rememberSaveable { mutableStateOf(false) }
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
                ItemDetailMataKuliah(
                    mataKuliah = detailUiState.detailUiEvent.toMataKuliahEntity(),
                    modifier = Modifier
                )
                Spacer(modifier = Modifier.padding(8.dp))
                Button(
                    onClick = {
                        deleteConfirmationRequired = true
                    },
                    modifier = Modifier.fillMaxWidth()
                ){
                    Text(text = "Delete")
                }
                if (deleteConfirmationRequired){
                    DeleteConfirmationDialog(
                        onDeleteConfirm = {
                            deleteConfirmationRequired = false
                            onDeleteClick()
                        },
                        onDeleteCancel = {deleteConfirmationRequired = false},
                        modifier = Modifier.padding(8.dp)
                    )
                }
            }
        }

        detailUiState.isUiEventEmpty -> {
            Box(
                modifier = Modifier.fillMaxWidth(),
                contentAlignment = Alignment.Center
            ){
                Text(
                    text = "Data tidak ditemukan",
                    modifier = Modifier.padding(16.dp),
                )
            }
        }
    }
}

@Composable
fun ItemDetailMataKuliah(
    modifier: Modifier = Modifier,
    mataKuliah: MataKuliah
){
    Card(
        modifier = modifier
            .fillMaxWidth(),
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.primaryContainer,
            contentColor = MaterialTheme.colorScheme.onPrimaryContainer
        )
    ){
        Column(
            modifier = Modifier.padding(16.dp)
        ){
            ComponentDetailMataKuliah(judul = "Kode", isinya = mataKuliah.Kode)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailMataKuliah(judul = "Nama", isinya = mataKuliah.Nama)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailMataKuliah(judul = "SKS", isinya = mataKuliah.SKS)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailMataKuliah(judul = "Semester", isinya = mataKuliah.Semester)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailMataKuliah(judul = "Jenis", isinya = mataKuliah.Jenis)
            Spacer(modifier = Modifier.padding(4.dp))

            ComponentDetailMataKuliah(judul = "DosenPengampu", isinya = mataKuliah.DosenPengampu)
        }
    }
}

@Composable
fun ComponentDetailMataKuliah(
    modifier: Modifier = Modifier,
    judul: String,
    isinya: String,
){
    Column(
        modifier = modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.Start
    ){
        Text(
            text = " $judul :",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Gray
        )
        Text(
            text = isinya, fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
private fun DeleteConfirmationDialog(
    onDeleteConfirm: () -> Unit, onDeleteCancel: () -> Unit, modifier: Modifier =
        Modifier
) {
    AlertDialog(onDismissRequest = {},
        title = { Text("Delete Data Mata Kuliah") },
        text =  { Text("apakah anda yakin ingin menghapus data Mata Kuliah?") },
        modifier = modifier,
        dismissButton = {
            TextButton(onClick = onDeleteCancel) {
                Text(text = "Cancel")
            }
        },
        confirmButton = {
            TextButton(onClick = onDeleteConfirm) {
                Text(text = "Delete")
            }
        })
}