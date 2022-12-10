package com.example.dicoding_c22_056_capstone_project.NewsPage.news

import android.content.Intent
import android.net.Uri
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.NewsPage.DataNews
import com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse.NewsResponseItem
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowNewsBinding

class NewsAdapter () : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {
    private val newsList = ArrayList<NewsResponseItem>()
    private var onItemClickCallback : OnItemClickCallback? = null


    fun setNewsList(newsResponse : ArrayList<NewsResponseItem>){
        newsList.clear()
        newsList.addAll(newsResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder (val binding: ItemRowNewsBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(newsResponse : NewsResponseItem){
            with(binding){
                tvItemTitle.text = newsResponse.title
                tvItemUrl.text = newsResponse.url
            }
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(newsResponse)
                DataNews.NewsUrl = newsResponse.url
                val intent = Intent(Intent.ACTION_VIEW, Uri.parse(DataNews.NewsUrl))
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowNewsBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(newsList[position])
    }

    override fun getItemCount(): Int = newsList.size

    interface OnItemClickCallback{
        fun onItemClicked(newsResponse : NewsResponseItem)
    }

}