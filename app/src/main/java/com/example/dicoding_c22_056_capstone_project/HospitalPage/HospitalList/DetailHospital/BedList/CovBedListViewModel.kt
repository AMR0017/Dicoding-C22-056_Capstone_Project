package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedList

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.API.ApiConfig
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedDetailItem
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Data
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.DetailHospitalResponse
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Stats
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CovBedListViewModel(application: Application) : AndroidViewModel(application) {
    val covBedListHospital = MutableLiveData<ArrayList<BedDetailItem>>()

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getCovBedHospital() : LiveData<ArrayList<BedDetailItem>> = covBedListHospital

    fun getAdaptDetailBedHospital(hospitalid : String, type :  String){
        _isLoading.value = true
        val setDetail = ApiConfig.getApiService().getAdaptHospitalBedDetail(hospitalid,type)
        setDetail.enqueue(object : Callback<Data> {
            override fun onResponse(
                call: Call<Data>,
                response: Response<Data>
            ) {
                if(response.isSuccessful){
                    covBedListHospital.value = response.body()?.bedDetail
                } else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<Data>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }

        })
    }

}