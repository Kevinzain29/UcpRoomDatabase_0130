package com.example.ucp2_pertemuan11.repository

import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.data.dao.DosenDao
import kotlinx.coroutines.flow.Flow

class LocalRepositoryDosen(
    private val dosenDao: DosenDao
): RepositoryDosen {
    override suspend fun insertDosen(dosen: Dosen) {
        dosenDao.insertDosen(dosen)
    }
    override fun getAllDosen(): Flow<List<Dosen>>{
        return dosenDao.getAllDosen()
    }
    override fun getDosen(Nidn: String): Flow<Dosen>{
        return dosenDao.getDosen(Nidn)
    }
}