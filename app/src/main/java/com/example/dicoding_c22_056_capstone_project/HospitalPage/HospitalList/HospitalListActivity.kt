package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList.NonCovidHospitalActivity
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityHospitalListBinding

class HospitalListActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHospitalListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHospitalListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.cardHospitalCovid.setOnClickListener {
            val intent = Intent(this, CovidHospitalActivity::class.java)
            startActivity(intent)
        }
        binding.cardHospitalNonCovid.setOnClickListener {
            val intent = Intent(this, NonCovidHospitalActivity::class.java)
            startActivity(intent)
        }
    }
}