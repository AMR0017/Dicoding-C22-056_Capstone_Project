package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CovidHospitalResponse(
	@field:SerializedName("hospitals")
	val hospitals: List<HospitalsItem>,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class HospitalsItem(

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("bed_availability")
	val bedAvailability: Int,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("queue")
	val queue: Int,

	@field:SerializedName("info")
	val info: String
) : Parcelable
