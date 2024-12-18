package com.example.ucp2_pertemuan11.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.ucp2_pertemuan11.data.Entity.Dosen
import com.example.ucp2_pertemuan11.data.Entity.MataKuliah
import com.example.ucp2_pertemuan11.data.dao.DosenDao
import com.example.ucp2_pertemuan11.data.dao.MataKuliahDao


@Database(entities = [Dosen::class, MataKuliah::class], version = 1, exportSchema = false)
abstract class UnivDatabase:RoomDatabase() {
    //mendefinisikan fungsi untuk mengakses data dosen dan matakuliah
    abstract fun dosenDao(): DosenDao
    abstract fun mataKuliahDao(): MataKuliahDao

    companion object{
        @Volatile
        private var Instance: UnivDatabase? = null

        fun getDatabase(context: Context): UnivDatabase{
            return (Instance ?: synchronized(this){
                Room.databaseBuilder(
                    context,
                    UnivDatabase::class.java,
                    "UnivDatabase"
                )
                    .build().also { Instance = it }
            })
        }
    }
}