package com.example.ucp2_pertemuan11.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "matakuliah")
data class MataKuliah(
    @PrimaryKey
    val Kode: String,
    val Nama: String,
    val SKS: String,
    val Semester: String,
    val Jenis: String,
    val DosenPengampu: String
)
