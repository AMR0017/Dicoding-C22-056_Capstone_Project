package com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.API.ApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class provinceViewModel(application: Application) : AndroidViewModel(application) {

    val listProvince = MutableLiveData<ArrayList<ProvincesItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getProvince(): LiveData<ArrayList<ProvincesItem>> = listProvince

    fun getAdaptProvince(){
        _isLoading.value = true
        val setAdapter = ApiConfig.getApiService().getProvinceList()
        setAdapter.enqueue(object : Callback<ProvinceResponse>{
            override fun onResponse(
                call: Call<ProvinceResponse>,
                response: Response<ProvinceResponse>
            ) {
                if (response.isSuccessful){
                    listProvince.value = response.body()?.provinces

                }else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<ProvinceResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }

        })
    }


}