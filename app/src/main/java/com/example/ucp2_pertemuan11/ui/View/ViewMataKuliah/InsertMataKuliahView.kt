package com.example.ucp2_pertemuan11.ui.View.ViewMataKuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.FormErrorState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.MataKuliahEvent

@Composable
fun FormMataKuliah(
    mataKuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    onValueChange: (MataKuliahEvent) -> Unit = {},
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier
){
    val SKS = listOf("1", "2", "3")
    val Jenis = listOf("Wajib", "Peminatan")

    Column(
        modifier = modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mataKuliahEvent.Nama,
            onValueChange = {
                onValueChange(mataKuliahEvent.copy(Nama = it))
            },
            label = { Text("Nama") },
            isError = errorState.Nama!=null,
            placeholder = { Text("Masukkan Nama") }
        )
        Text(
            text = errorState.Nama ?:"",
            color = Color.Red
        )
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mataKuliahEvent.Kode, onValueChange = {
                onValueChange(mataKuliahEvent.copy(Kode = it))
            },
            label = { Text("Kode Mata Kuliah") },
            isError = errorState.Kode!=null,
            placeholder = { Text("masukkan kode") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
        )
        Text(text = errorState.Kode ?: "", color = Color.Red)

        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "SKS")
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            SKS.forEach { sks ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    RadioButton(
                        selected = mataKuliahEvent.SKS == sks,
                        onClick = {
                            onValueChange(mataKuliahEvent.copy(SKS = sks))
                        },

                        )
                    Text(
                        text = sks,
                    )
                }
            }
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mataKuliahEvent.Semester,
            onValueChange = {
                onValueChange(mataKuliahEvent.copy(Semester = it))
            },
            label = { Text("Semester") },
            isError = errorState.Semester!=null,
            placeholder = { Text("Masukkan Semester") }
        )
        Text(text = errorState.Semester ?:"",
            color = Color.Red
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Jenis")
        Row (
            modifier = Modifier.fillMaxWidth()
        ){
            Jenis.forEach { jenis ->
                Row (
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start
                ){
                    RadioButton(
                        selected = mataKuliahEvent.Jenis == jenis,
                        onClick = {
                            onValueChange(mataKuliahEvent.copy(Jenis = jenis))
                        },

                        )
                    Text(
                        text = jenis,
                    )
                }
            }
        }
        OutlinedTextField(
            modifier = Modifier.fillMaxWidth(),
            value = mataKuliahEvent.DosenPengampu,
            onValueChange = {
                onValueChange(mataKuliahEvent.copy(DosenPengampu = it))
            },
            label = { Text("Dosen Pengampu") },
            isError = errorState.DosenPengampu!=null,
            placeholder = { Text("Masukkan Dosen Pengampu ") }
        )
        Text(text = errorState.DosenPengampu ?:"",
            color = Color.Red
        )
    }
}