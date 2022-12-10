package com.example.dicoding_c22_056_capstone_project.CovUpdate.UpdateApi

import com.example.dicoding_c22_056_capstone_project.CovUpdate.UpdateResponse
import retrofit2.Call
import retrofit2.http.GET

interface UpdateApiService {
    @GET("indonesia")
    fun getData(): Call<UpdateResponse>
}