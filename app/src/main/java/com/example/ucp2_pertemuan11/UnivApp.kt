package com.example.ucp2_pertemuan11

import android.app.Application
import com.example.ucp2_pertemuan11.dependenciesinjection.ContainerApp

class UnivApp : Application() {
    //untuk menyimpan instance ContainerApp
    lateinit var containerApp: ContainerApp

    override fun onCreate() {
        super.onCreate()
        containerApp = ContainerApp(this)
    }
}