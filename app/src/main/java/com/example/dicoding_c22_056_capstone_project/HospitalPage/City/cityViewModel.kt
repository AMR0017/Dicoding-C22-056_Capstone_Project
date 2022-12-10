package com.example.dicoding_c22_056_capstone_project.HospitalPage.City

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.API.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class cityViewModel(application: Application) : AndroidViewModel(application) {

    val listCities = MutableLiveData<ArrayList<CitiesItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getCities(): LiveData<ArrayList<CitiesItem>> = listCities

    fun getAdaptCities(provienceid : String){
        _isLoading.value = true
        val setAdapter = ApiConfig.getApiService().getCity(provienceid)
        setAdapter.enqueue(object : Callback<CityResponse>{
            override fun onResponse(call: Call<CityResponse>, response: Response<CityResponse>) {
                if (response.isSuccessful){
                    listCities.value = response.body()?.cities
                }else{
                    _message.value = response.message()
                }
            }
            override fun onFailure(call: Call<CityResponse>, t: Throwable) {
               _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }

        })
    }
}