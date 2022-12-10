package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityCovBedListBinding

class CovBedListActivity : AppCompatActivity() {
    private lateinit var binding : ActivityCovBedListBinding
    private lateinit var adapter: CovBedListAdapter
    private lateinit var covBedListViewModel: CovBedListViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCovBedListBinding.inflate(layoutInflater)
        setContentView(binding.root)
/*
        adapter = CovBedListAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvBedlist.layoutManager = LinearLayoutManager(this@CovBedListActivity)
            rvBedlist.setHasFixedSize(true)
            rvBedlist.adapter = adapter
        }

        covBedListViewModel = ViewModelProvider(this)[CovBedListViewModel::class.java]
        val hospitalID = DataHospital.covHospitalID
        val type = "1"

        with(covBedListViewModel){
            getAdaptDetailBedHospital(hospitalID,type)
            getCovBedHospital().observe(this@CovBedListActivity){
                if (it != null){
                    adapter.setBedList(it)
                }
            }
        }*/
    }
}