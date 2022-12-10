package com.example.dicoding_c22_056_capstone_project.NewsPage.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityHoaxBinding
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityNewsBinding

class HoaxActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHoaxBinding
    private lateinit var adapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHoaxBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        adapter = NewsAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@HoaxActivity)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        with(newsViewModel){
            getAdaptHoax()
            showLoading(true)
            getNews().observe(this@HoaxActivity){
                if (it != null){
                    showLoading(false)
                    adapter.setNewsList(it)
                } else{
                    showLoading(false)
                }
            }
        }
    }

    private fun showLoading(loading:Boolean){
        binding.progressBar5.visibility = if (loading) View.VISIBLE else View.GONE
    }
}