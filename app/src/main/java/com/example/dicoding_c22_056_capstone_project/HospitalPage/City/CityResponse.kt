package com.example.dicoding_c22_056_capstone_project.HospitalPage.City

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class CityResponse(
	@field:SerializedName("cities")
	val cities: ArrayList<CitiesItem>
): Parcelable

@Parcelize
data class CitiesItem(
	@field:SerializedName("name")
	val name: String,

	@field:SerializedName("id")
	val id: String
): Parcelable
