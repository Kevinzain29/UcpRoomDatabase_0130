package com.example.ucp2_pertemuan11.data.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import kotlinx.coroutines.flow.Flow

@Dao
interface MataKuliahDao {
    @Query("SELECT * FROM matakuliah")
    fun getAllMataKuliah() : Flow<List<MataKuliah>>
    @Query("SELECT * FROM matakuliah WHERE Kode = :Kode")
    fun getMataKuliah(Kode: String): Flow<MataKuliah>
    @Insert
    suspend fun insertMataKuliah(mataKuliah: MataKuliah)
    @Delete
    suspend fun deleteMataKuliah(mataKuliah: MataKuliah)
    @Update
    suspend fun updateMataKuliah(mataKuliah: MataKuliah)
}