package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

data class DetailHospitalResponse(

	@field:SerializedName("data")
	val data: Data? = null,

	@field:SerializedName("status")
	val status: Int? = null
)

@Parcelize
data class Stats(
	@field:SerializedName("bed_empty")
	val bedEmpty: Int,

	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("bed_available")
	val bedAvailable: Int,

	@field:SerializedName("queue")
	val queue: Int
) : Parcelable

@Parcelize
data class BedDetailItem(
	@field:SerializedName("stats")
	val stats: Stats,

	@field:SerializedName("time")
	val time: String
) : Parcelable

@Parcelize
data class Data(
	@field:SerializedName("address")
	val address: String,

	@field:SerializedName("phone")
	val phone: String,

	@field:SerializedName("bedDetail")
	val bedDetail: ArrayList<BedDetailItem>,

	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
) : Parcelable
