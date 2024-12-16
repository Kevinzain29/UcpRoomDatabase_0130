package com.example.ucp2_pertemuan11.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import kotlinx.coroutines.flow.Flow

@Dao
interface DosenDao {
    @Query("SELECT * FROM dosen")
    fun getAllDosen() : Flow<List<Dosen>>
    @Query("SELECT * FROM dosen WHERE Nidn = :Nidn")
    fun getDosen(Nidn: String):Flow<Dosen>
    @Insert
    suspend fun insertDosen(dosen: Dosen)
}