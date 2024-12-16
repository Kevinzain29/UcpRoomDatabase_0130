package com.example.ucp2_pertemuan11.repository

import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.data.dao.DosenDao

class LocalRepositoryDosen(
    private val dosenDao: DosenDao
): RepositoryDosen {
    override suspend fun insertDosen(dosen: Dosen) {
        dosenDao.insertDosen(dosen)
    }
}