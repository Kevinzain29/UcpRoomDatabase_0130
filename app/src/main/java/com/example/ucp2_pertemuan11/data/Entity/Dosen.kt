package com.example.ucp2_pertemuan11.data.Entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "dosen")
data class Dosen(
    @PrimaryKey
    val Nidn: String,
    val Nama: String,
    val JenisKelamin: String
)
