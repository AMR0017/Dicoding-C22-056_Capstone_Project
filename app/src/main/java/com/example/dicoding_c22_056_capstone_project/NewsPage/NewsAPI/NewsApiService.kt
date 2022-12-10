package com.example.dicoding_c22_056_capstone_project.NewsPage.NewsAPI

import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceResponse
import com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse.NewsResponse
import com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse.NewsResponseItem
import retrofit2.Call
import retrofit2.http.GET

interface NewsApiService {
    @GET("news")
    fun getNewsList() : Call<ArrayList<NewsResponseItem>>

    @GET("hoaxes")
    fun getHoaxList() : Call<ArrayList<NewsResponseItem>>
}