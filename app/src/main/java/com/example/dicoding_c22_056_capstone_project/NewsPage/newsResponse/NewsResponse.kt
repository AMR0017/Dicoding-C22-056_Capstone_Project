package com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NewsResponse(
	@field:SerializedName("NewsResponse")
	val newsResponse: ArrayList<NewsResponseItem>
) : Parcelable

@Parcelize
data class NewsResponseItem(
	@field:SerializedName("title")
	val title: String,

	@field:SerializedName("url")
	val url: String,

	@field:SerializedName("timestamp")
	val timestamp: Long
) : Parcelable
