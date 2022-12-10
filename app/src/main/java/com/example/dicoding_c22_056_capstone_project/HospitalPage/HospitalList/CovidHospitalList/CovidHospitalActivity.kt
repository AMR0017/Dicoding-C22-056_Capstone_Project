package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CityListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.cityViewModel
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvincesItem
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.provinceViewModel
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityCovidHospitalBinding

class CovidHospitalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCovidHospitalBinding
    private lateinit var adapter: CovidHospitalAdapter
    private lateinit var covidHospitalViewModel1: covidHospitalViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Covid Hospital List"

        adapter = CovidHospitalAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvCovidHospital.layoutManager = LinearLayoutManager(this@CovidHospitalActivity)
            rvCovidHospital.setHasFixedSize(true)
            rvCovidHospital.adapter = adapter
        }


        covidHospitalViewModel1 = ViewModelProvider(this)[covidHospitalViewModel::class.java]
        val provinceId = DataHospital.provID
        val citiesId = DataHospital.cityID
        val type = "1"

        with(covidHospitalViewModel1){
            getAdaptCovHospital(provinceId,citiesId,type)
            showLoading(true)
            getCovHospital().observe(this@CovidHospitalActivity){
                if (it != null){
                    showLoading(false)
                    adapter.setHospitalList(it)
                }
            }
        }
    }

    private fun showLoading(loading:Boolean){
        binding.progressBar3.visibility = if (loading) View.VISIBLE else View.GONE
    }


    companion object{
        const val P_ID = "provid"
        const val C_ID = "cityid"
        const val CovHospital = 1
    }
}