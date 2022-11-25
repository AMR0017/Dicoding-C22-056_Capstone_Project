package com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class ProvinceResponse(
	@field:SerializedName("provinces")
	val provinces: ArrayList<ProvincesItem>
) : Parcelable

@Parcelize
data class ProvincesItem(
	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
) : Parcelable
