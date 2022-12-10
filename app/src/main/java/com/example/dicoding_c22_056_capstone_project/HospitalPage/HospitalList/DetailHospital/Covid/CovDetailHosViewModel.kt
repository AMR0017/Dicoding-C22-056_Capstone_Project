package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Covid

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.API.ApiConfig
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CityResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Data
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.DetailHospitalResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovDetailHosViewModel(application:Application) : AndroidViewModel(application) {
    private val _listHospital = MutableLiveData<Data>()
    val listHospital : LiveData<Data> = _listHospital

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getDetailHospital(hospitalid : String, type :  String){
        _isLoading.value = true
        val setDetail = ApiConfig.getApiService().getHospitalDetail(hospitalid,type)
        setDetail.enqueue(object : Callback<DetailHospitalResponse>{
            override fun onResponse(
                call: Call<DetailHospitalResponse>,
                response: Response<DetailHospitalResponse>
            ) {
                if(response.isSuccessful){
                    _listHospital.value = response.body()?.data
                } else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<DetailHospitalResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }

        })
    }
}