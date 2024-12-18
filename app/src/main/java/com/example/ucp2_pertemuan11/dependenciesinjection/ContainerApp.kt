package com.example.ucp2_pertemuan11.dependenciesinjection

import android.content.Context
import com.example.ucp2_pertemuan11.data.database.UnivDatabase
import com.example.ucp2_pertemuan11.repository.LocalRepositoryDosen
import com.example.ucp2_pertemuan11.repository.LocalRepositoryMataKuliah
import com.example.ucp2_pertemuan11.repository.RepositoryDosen
import com.example.ucp2_pertemuan11.repository.RepositoryMataKuliah

interface InterfaceContainerApp {
    val repositoryDosen: RepositoryDosen
    val repositoryMataKuliah: RepositoryMataKuliah
}

class ContainerApp(private val context: Context) : InterfaceContainerApp{
    override val repositoryDosen: RepositoryDosen by lazy {
        LocalRepositoryDosen(UnivDatabase.getDatabase(context).dosenDao())
    }
    override val repositoryMataKuliah: RepositoryMataKuliah by lazy {
        LocalRepositoryMataKuliah(UnivDatabase.getDatabase(context).mataKuliahDao())
    }
}