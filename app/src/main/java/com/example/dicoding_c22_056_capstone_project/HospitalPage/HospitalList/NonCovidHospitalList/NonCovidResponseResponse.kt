package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NonCovidResponseResponse(

	@field:SerializedName("hospitals")
	val hospitals: ArrayList<HospitalsItem>,

	@field:SerializedName("status")
	val status: Int
) : Parcelable

@Parcelize
data class HospitalsItem(

	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("available_beds")
	val availableBeds: ArrayList<AvailableBedsItem>,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String,

	@field:SerializedName("bed_class")
	val bedClass: String,

	@field:SerializedName("room_name")
	val roomName: String,

	@field:SerializedName("available")
	val available: Int,

	@field:SerializedName("info")
	val info: String
):Parcelable

@Parcelize
data class AvailableBedsItem(
	@field:SerializedName("bed_class")
	val bedClass: String,

	@field:SerializedName("room_name")
	val roomName: String,

	@field:SerializedName("available")
	val available: Int,

	@field:SerializedName("info")
	val info: String
) : Parcelable
