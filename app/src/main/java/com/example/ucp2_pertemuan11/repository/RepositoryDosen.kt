package com.example.ucp2_pertemuan11.repository
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import kotlinx.coroutines.flow.Flow


interface RepositoryDosen {
    suspend fun insertDosen(dosen: Dosen)
    fun getAllDosen(): Flow<List<Dosen>>
    fun getDosen(Nidn: String): Flow<Dosen>
}