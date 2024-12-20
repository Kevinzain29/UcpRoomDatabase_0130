package com.example.ucp2_pertemuan11.ui.navigation

interface AlamatNavigasi {
    val route: String
}
object DestinasiHomeDosen : AlamatNavigasi{
    override val route = "home"
}
object DestinasiDetailDosen : AlamatNavigasi{
    override val route = "detail"
    const val Nidn = "Nidn"
    val routeWithArg = "$route/{$Nidn}"
}