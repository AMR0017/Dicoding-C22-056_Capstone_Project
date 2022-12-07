package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.R

class DetailHospitalActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_hospital)
    }
    companion object{
        const val HOSPITAL_ID = "id"
    }
}