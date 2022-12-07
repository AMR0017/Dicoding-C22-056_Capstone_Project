package com.example.dicoding_c22_056_capstone_project.API

import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CityResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvincesItem
import retrofit2.Call
import retrofit2.http.*

interface ApiServices {

    @GET("get-provinces")
    fun getProvinceList() : Call<ProvinceResponse>

    @GET("get-cities?")
    fun getCity(
        @Query("provinceid") provinceid : String
    ) : Call<CityResponse>

    @GET("get-hospitals?")
    fun getHospitalCovid(
        @Query("provinceid") provinceid : String,
        @Query("cityid") cityid : String,
        @Query("type") type : String
    ) : Call<CovidHospitalResponse>

    @GET("get-hospitals?")
    fun getHospitalNonCovid(
        @Query("provinceid") provinceid : String,
        @Query("cityid") cityid : String,
        @Query("type") type : Int = 2
    ) : Call<CovidHospitalResponse>
}