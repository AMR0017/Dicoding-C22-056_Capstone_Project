package com.example.dicoding_c22_056_capstone_project.HospitalPage.City

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.HospitalListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceListActivity
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityCityListBinding

class CityListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityCityListBinding
    private lateinit var adapter: CityAdapter
    private lateinit var cityViewModel1: cityViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCityListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Cities List"

        adapter = CityAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvCity.layoutManager = LinearLayoutManager(this@CityListActivity)
            rvCity.setHasFixedSize(true)
            rvCity.adapter = adapter
        }

        cityViewModel1 = ViewModelProvider(this)[cityViewModel::class.java]
        val provinceId = intent.getStringExtra(P_ID)
        intent.putExtra(CityListActivity.P_ID, intent.getStringExtra(P_ID))
        with(cityViewModel1){
            if (provinceId != null) {
                getAdaptCities(provinceId)
                showLoading(true)
                getCities().observe(this@CityListActivity){
                    if (it != null){
                        showLoading(false)
                        adapter.setCitiesList(it)
                        println("provinceID : $provinceId")
                    }
                }
            }

        }
    }

    private fun showLoading(loading:Boolean){
        binding.progressBar2.visibility = if (loading) View.VISIBLE else View.GONE
    }

    companion object{
        const val P_ID = "id"
    }
}
