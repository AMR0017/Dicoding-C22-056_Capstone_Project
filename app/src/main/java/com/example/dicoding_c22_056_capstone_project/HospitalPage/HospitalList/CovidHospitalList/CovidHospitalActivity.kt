package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.R

class CovidHospitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_covid_hospital)
    }
    /*test*/

    companion object{
        const val P_ID = "id"
        const val C_ID = "id"
        const val CovHospital = 1
    }
}