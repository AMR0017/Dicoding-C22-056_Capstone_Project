package com.example.dicoding_c22_056_capstone_project.NewsPage.news

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.NewsPage.NewsAPI.NewsApiConfig
import com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse.NewsResponse
import com.example.dicoding_c22_056_capstone_project.NewsPage.newsResponse.NewsResponseItem
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NewsViewModel(application: Application) : AndroidViewModel(application){
    val newsList = MutableLiveData<ArrayList<NewsResponseItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getNews() : LiveData<ArrayList<NewsResponseItem>> = newsList

    fun getAdaptNews(){
        _isLoading.value = true
        val setAdapt = NewsApiConfig.getApiService().getNewsList()
        setAdapt.enqueue(object : Callback<ArrayList<NewsResponseItem>>{
            override fun onResponse(call: Call<ArrayList<NewsResponseItem>>, response: Response<ArrayList<NewsResponseItem>>) {
                if (response.isSuccessful){
                    newsList.value = response.body()
                }else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<ArrayList<NewsResponseItem>>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }
        })
    }

    fun getAdaptHoax(){
        _isLoading.value = true
        val setAdapt = NewsApiConfig.getApiService().getHoaxList()
        setAdapt.enqueue(object : Callback<ArrayList<NewsResponseItem>>{
            override fun onResponse(call: Call<ArrayList<NewsResponseItem>>, response: Response<ArrayList<NewsResponseItem>>) {
                if (response.isSuccessful){
                    newsList.value = response.body()
                }else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<ArrayList<NewsResponseItem>>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }
        })
    }
}