package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalAdapter
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.covidHospitalViewModel
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityCovidHospitalBinding

class NonCovidHospitalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCovidHospitalBinding
    private lateinit var adapter: CovidHospitalAdapter
    private lateinit var covidHospitalViewModel1: covidHospitalViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Hospital List"

        adapter = CovidHospitalAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvCovidHospital.layoutManager = LinearLayoutManager(this@NonCovidHospitalActivity)
            rvCovidHospital.setHasFixedSize(true)
            rvCovidHospital.adapter = adapter
        }


        covidHospitalViewModel1 = ViewModelProvider(this)[covidHospitalViewModel::class.java]
        val provinceId = DataHospital.provID
        val citiesId = DataHospital.cityID
        val type = "2"

        println(provinceId)
        println(citiesId)
        println(type)

        with(covidHospitalViewModel1){
            if (provinceId != null || citiesId != null || type == "2"){
                if (provinceId != null) {
                    if (citiesId != null) {
                        getAdaptCovHospital(provinceId,citiesId,type)
                    }
                }
                showLoading(true)
                getCovHospital().observe(this@NonCovidHospitalActivity){
                    if (it != null){
                        showLoading(false)
                        adapter.setHospitalList(it)
                        println(provinceId)
                        println(citiesId)
                        println(type)
                    }
                }
            }
        }
    }
    /*test*/

    private fun showLoading(loading:Boolean){
        binding.progressBar3.visibility = if (loading) View.VISIBLE else View.GONE
    }


    companion object{
        const val P_ID = "provid"
        const val C_ID = "cityid"
        const val CovHospital = 1
    }
}