package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.R

class NonCovidHospitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_non_covid_hospital)
    }

    companion object{
        const val P_ID = "id"
        const val C_ID = "id"
        const val CovHospital = 1
    }
}