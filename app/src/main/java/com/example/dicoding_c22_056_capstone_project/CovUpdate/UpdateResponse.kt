package com.example.dicoding_c22_056_capstone_project.CovUpdate

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class UpdateResponse(
    @field:SerializedName("meninggal")
    val meninggal: Int? = null,

    @field:SerializedName("positif")
    val positif: Int? = null,

    @field:SerializedName("sembuh")
    val sembuh: Int? = null,

    @field:SerializedName("dirawat")
    val dirawat: Int? = null,

    @field:SerializedName("lastUpdate")
    val lastUpdate: String? = null
) : Parcelable