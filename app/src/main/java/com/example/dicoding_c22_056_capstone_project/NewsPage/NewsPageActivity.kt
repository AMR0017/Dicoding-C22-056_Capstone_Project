package com.example.dicoding_c22_056_capstone_project.NewsPage

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.dicoding_c22_056_capstone_project.NewsPage.news.HoaxActivity
import com.example.dicoding_c22_056_capstone_project.NewsPage.news.NewsActivity
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityNewsPageBinding

class NewsPageActivity : AppCompatActivity() {
    private lateinit var binding: ActivityNewsPageBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsPageBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.cardNews.setOnClickListener {
            startActivity(Intent(this, NewsActivity::class.java))
        }
        binding.cardHoaks.setOnClickListener {
            startActivity(Intent(this, HoaxActivity::class.java))
        }
    }
}