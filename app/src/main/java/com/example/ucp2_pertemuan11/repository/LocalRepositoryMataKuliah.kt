package com.example.ucp2_pertemuan11.repository

import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.data.dao.MataKuliahDao
import kotlinx.coroutines.flow.Flow

class LocalRepositoryMataKuliah (
    private val mataKuliahDao: MataKuliahDao
):RepositoryMataKuliah{
    override fun getAllMataKuliah(): Flow<List<MataKuliah>> {
        return mataKuliahDao.getAllMataKuliah()
    }
    override fun getMataKuliah(Kode: String): Flow<MataKuliah> {
        return mataKuliahDao.getMataKuliah(Kode)
    }

    override suspend fun insertMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.insertMataKuliah(mataKuliah)
    }

    override suspend fun deleteMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.deleteMataKuliah(mataKuliah)
    }

    override suspend fun updateMataKuliah(mataKuliah: MataKuliah) {
        mataKuliahDao.updateMataKuliah(mataKuliah)
    }
}