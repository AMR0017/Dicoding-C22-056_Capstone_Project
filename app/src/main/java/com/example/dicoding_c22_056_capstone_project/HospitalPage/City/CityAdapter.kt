package com.example.dicoding_c22_056_capstone_project.HospitalPage.City

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.HospitalListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList.ProvincesItem
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowProvinceBinding

class CityAdapter () : RecyclerView.Adapter<CityAdapter.ViewHolder>() {
    private val cityList = ArrayList<CitiesItem>()
    private val provinceList = ArrayList<ProvincesItem>()
    private var onItemClickCallback : OnItemClickCallback? = null

    fun setCitiesList(cityResponse: ArrayList<CitiesItem>){
        cityList.clear()
        cityList.addAll(cityResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemRowProvinceBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(cityResponse: CitiesItem){
            with(binding){
                tvItemIdProv.text = cityResponse.id
                tvItemProv.text = cityResponse.name
            }
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(cityResponse)
                val intent = Intent(itemView.context, HospitalListActivity::class.java)
                intent.putExtra(CovidHospitalActivity.C_ID, cityResponse.id)
                itemView.context.startActivity(intent)
                println(cityResponse.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowProvinceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(cityList[position])
    }

    override fun getItemCount(): Int = cityList.size

    interface OnItemClickCallback{
        fun onItemClicked(cityResponse: CitiesItem)
    }

}