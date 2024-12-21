package com.example.ucp2_pertemuan11.ui.View.ViewMataKuliah

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.FormErrorState
import com.example.ucp2_pertemuan11.ui.ViewModel.ViewModelMataKuliah.MataKuliahEvent
import com.example.ucp2_pertemuan11.ui.costumwidget.DynamicSelectedField
import com.example.ucp2_pertemuan11.ui.navigation.AlamatNavigasi

object DestinasiInsertMataKuliah : AlamatNavigasi {
    override val route: String = "insert_MataKuliah"
}

@Composable
fun FormMataKuliah(
    mataKuliahEvent: MataKuliahEvent = MataKuliahEvent(),
    onValueChange: (MataKuliahEvent) -> Unit = {},
    errorState: FormErrorState = FormErrorState(),
    modifier: Modifier = Modifier,
    listDosen: List<Dosen>
){
    val SKS = listOf("1", "2", "3")
    val Jenis = listOf("Wajib", "Peminatan")
    val LISTDOSEN = listDosen.map { it.Nama }

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
        Spacer(modifier = Modifier.height(16.dp))
        Text(text = "Pilih Dosen Pengampu mata kuliah", fontWeight = FontWeight.Bold)
        Text(
            text = "pilih dosen pengampu",
            fontSize = 12.sp,
            fontWeight = FontWeight.Light
        )
        Spacer(modifier = Modifier.padding(8.dp))
        DynamicSelectedField(
            selectedValue = mataKuliahEvent.DosenPengampu,
            options = LISTDOSEN,
            label = "Dosen Pengampu",
            onValueChangedEvent = {
                onValueChange(mataKuliahEvent.copy(DosenPengampu = it))
            }
        )
        Text(text = errorState.DosenPengampu ?:"",
            color = Color.Red
        )
    }
}