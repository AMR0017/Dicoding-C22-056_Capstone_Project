package com.example.dicoding_c22_056_capstone_project.CovUpdate

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityCovidUpdateBinding

class CovidUpdateActivity : AppCompatActivity() {

    private lateinit var binding: ActivityCovidUpdateBinding
    private lateinit var updateViewModel: UpdateViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovidUpdateBinding.inflate(layoutInflater)
        setContentView(binding.root)

        updateViewModel = ViewModelProvider(this)[UpdateViewModel::class.java]
        updateViewModel.getCovidUpdate()
        showLoading(true)
        updateViewModel.updateCovid.observe(this){
                update ->
            showLoading(false)
            binding.apply {
                tvPositive.text = update.positif.toString()
                tvRecover.text = update.sembuh.toString()
                tvDeath.text = update.meninggal.toString()
                tvHospitalized.text = update.dirawat.toString()
                println("Positif: ${update.positif}")
            }
        }
        updateViewModel.isLoading.observe(this){
            showLoading(it)
        }
    }

    private fun showLoading(loading:Boolean){
        binding.progressBar6.visibility = if (loading) View.VISIBLE else View.GONE
    }

}