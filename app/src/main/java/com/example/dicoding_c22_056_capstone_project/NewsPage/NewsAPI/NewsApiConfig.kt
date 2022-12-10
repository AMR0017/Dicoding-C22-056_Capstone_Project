package com.example.dicoding_c22_056_capstone_project.NewsPage.NewsAPI

import com.example.dicoding_c22_056_capstone_project.API.ApiServices
import com.example.dicoding_c22_056_capstone_project.BuildConfig
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class NewsApiConfig {
    companion object{
        fun getApiService(): NewsApiService {
            val loggingInterceptor = if (BuildConfig.DEBUG){
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY)
            }else{
                HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.NONE)
            }
            val client = OkHttpClient.Builder()
                .addInterceptor(loggingInterceptor)
                .build()
            val retrofit = Retrofit.Builder()
                .baseUrl("https://dekontaminasi.com/api/id/covid19/")
                .addConverterFactory(GsonConverterFactory.create())
                .client(client)
                .build()
            return retrofit.create(NewsApiService::class.java)
        }
    }
}