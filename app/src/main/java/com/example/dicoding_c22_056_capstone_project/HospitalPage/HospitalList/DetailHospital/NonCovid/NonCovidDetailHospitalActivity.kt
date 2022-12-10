package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.NonCovid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedList.CovBedListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Covid.CovDetailHosViewModel
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityDetailHospitalBinding
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityNonCovidDetailHospitalBinding

class NonCovidDetailHospitalActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNonCovidDetailHospitalBinding
    private lateinit var hospitalViewModel: CovDetailHosViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNonCovidDetailHospitalBinding.inflate(layoutInflater)
        setContentView(binding.root)

        hospitalViewModel = ViewModelProvider(this)[CovDetailHosViewModel::class.java]
        val hospital = DataHospital.nonCovHospitalID
        val type = "2"

        hospitalViewModel.getDetailHospital(hospital,type)
        showLoading(true)
        hospitalViewModel.listHospital.observe(this){
                detailHospital ->
            showLoading(false)
            binding.apply {
                tvHospitalName.text = detailHospital.name
                tvAddress.text = detailHospital.address
                tvPhoneNumber.text = detailHospital.phone
            }
            binding.CovButton.setOnClickListener {
                startActivity(Intent(this@NonCovidDetailHospitalActivity, CovBedListActivity::class.java))
            }
            binding.NonCovButton.setOnClickListener {
                startActivity(Intent(this@NonCovidDetailHospitalActivity, CovBedListActivity::class.java))
            }
        }
        hospitalViewModel.isLoading.observe(this){
            showLoading(it)
        }
    }

    private fun showLoading(loading:Boolean){
        binding.progressBar4.visibility = if (loading) View.VISIBLE else View.GONE
    }
}