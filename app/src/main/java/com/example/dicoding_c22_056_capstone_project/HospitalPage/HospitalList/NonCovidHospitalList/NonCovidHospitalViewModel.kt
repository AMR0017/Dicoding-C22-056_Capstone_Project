package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.API.ApiConfig

import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class NonCovidHospitalViewModel(application: Application) : AndroidViewModel(application) {
    val listCovHospital = MutableLiveData<ArrayList<HospitalsItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getCovHospital() : LiveData<ArrayList<HospitalsItem>> = listCovHospital

    fun getAdaptCovHospital(provinceid:String, cityid : String, type:String = "1"){
        _isLoading.value = true
        val setAdapter1 = ApiConfig.getApiService().getHospitalNonCovid(provinceid, cityid, type)
        setAdapter1.enqueue(object : Callback<NonCovidResponseResponse> {
            override fun onResponse(
                call: Call<NonCovidResponseResponse>,
                response: Response<NonCovidResponseResponse>
            ) {
                if (response.isSuccessful){
                    listCovHospital.value = response.body()?.hospitals
                    println(listCovHospital)
                }else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<NonCovidResponseResponse>, t: Throwable) {
                _isLoading.value = true
                Log.d("Failure : ", t.message.toString())
            }
        })
    }
}