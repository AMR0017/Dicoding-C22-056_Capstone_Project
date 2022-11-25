package com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityProvinceListBinding

class ProvinceListActivity : AppCompatActivity() {
    private lateinit var binding: ActivityProvinceListBinding
    private lateinit var adapter: provinceAdapter
    private lateinit var provinceViewModel1: provinceViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityProvinceListBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = "Province List"

        adapter = provinceAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvListProvince.layoutManager = LinearLayoutManager(this@ProvinceListActivity)
            rvListProvince.setHasFixedSize(true)
            rvListProvince.adapter = adapter
        }

        provinceViewModel1 = ViewModelProvider(this)[provinceViewModel::class.java]
        with(provinceViewModel1){
            getAdaptProvince()
            showLoading(true)
            getProvince().observe(this@ProvinceListActivity){
                if (it != null){
                    showLoading(false)
                    adapter.setProvinceList(it)
                }
            }
        }
    }

    private fun showLoading(loading: Boolean){
        binding.progressBar.visibility = if (loading) View.VISIBLE else View.GONE
    }

}