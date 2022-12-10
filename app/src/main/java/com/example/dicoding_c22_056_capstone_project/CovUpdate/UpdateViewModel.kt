package com.example.dicoding_c22_056_capstone_project.CovUpdate

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.dicoding_c22_056_capstone_project.CovUpdate.UpdateApi.UpdateApiConfig
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UpdateViewModel(application: Application) : AndroidViewModel(application) {
    private val _updateCovid = MutableLiveData<UpdateResponse>()
    val updateCovid : LiveData<UpdateResponse> = _updateCovid

    private val _isLoading = MutableLiveData<Boolean>()
    val isLoading : LiveData<Boolean> = _isLoading

    private val _intent = MutableLiveData<Boolean>()
    val intent : LiveData<Boolean> = _intent

    private val _message = MutableLiveData<String>()
    val message1 : LiveData<String> = _message

    fun getCovidUpdate(){
        val setUpdate = UpdateApiConfig.getApiService().getData()
        setUpdate.enqueue(object : Callback<UpdateResponse> {
            override fun onResponse(
                call: Call<UpdateResponse>,
                response: Response<UpdateResponse>
            ) {
                if (response.isSuccessful){
                    _updateCovid.value = response.body()
                } else{
                    _message.value = response.message()
                }
            }

            override fun onFailure(call: Call<UpdateResponse>, t: Throwable) {
                _isLoading.value = false
                Log.d("Failure : ", t.message.toString())
            }

        })
    }
}