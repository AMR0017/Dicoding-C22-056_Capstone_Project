package com.example.dicoding_c22_056_capstone_project.Homepage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.CovUpdate.CovidUpdateActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvinceListActivity
import com.example.dicoding_c22_056_capstone_project.NewsPage.NewsPageActivity
import com.example.dicoding_c22_056_capstone_project.NewsPage.news.NewsActivity
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.cardHospital.setOnClickListener{
            startActivity(Intent(this, ProvinceListActivity::class.java))
        }
        binding.cardNews.setOnClickListener{
            startActivity(Intent(this, NewsPageActivity::class.java))
        }
        binding.cardCovidUpdate.setOnClickListener{
            startActivity(Intent(this, CovidUpdateActivity::class.java))
        }
    }
}