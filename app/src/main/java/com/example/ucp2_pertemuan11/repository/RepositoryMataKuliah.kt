package com.example.ucp2_pertemuan11.repository

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import kotlinx.coroutines.flow.Flow

interface RepositoryMataKuliah {
    suspend fun insertMataKuliah(mataKuliah: MataKuliah)
    fun getAllMataKuliah(): Flow<List<MataKuliah>>
    fun getMataKuliah(Kode: String): Flow<MataKuliah>
    suspend fun deleteMataKuliah(mataKuliah: MataKuliah)
    suspend fun updateMataKuliah(mataKuliah: MataKuliah)
}