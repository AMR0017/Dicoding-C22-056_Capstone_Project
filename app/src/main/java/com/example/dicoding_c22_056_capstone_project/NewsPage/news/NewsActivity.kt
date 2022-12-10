package com.example.dicoding_c22_056_capstone_project.NewsPage.news

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.dicoding_c22_056_capstone_project.R
import com.example.dicoding_c22_056_capstone_project.databinding.ActivityNewsBinding

class NewsActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNewsBinding
    private lateinit var adapter: NewsAdapter
    private lateinit var newsViewModel: NewsViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        adapter = NewsAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            recyclerView.layoutManager = LinearLayoutManager(this@NewsActivity)
            recyclerView.setHasFixedSize(true)
            recyclerView.adapter = adapter
        }
        newsViewModel = ViewModelProvider(this)[NewsViewModel::class.java]
        with(newsViewModel){
            getAdaptNews()
            showLoading(true)
            getNews().observe(this@NewsActivity){
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