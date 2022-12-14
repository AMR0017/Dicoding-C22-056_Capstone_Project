package com.example.dicoding_c22_056_capstone_project.HospitalPage.provinceList

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CityAdapter
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CityListActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.HospitalListActivity
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowProvinceBinding


class provinceAdapter () : RecyclerView.Adapter<provinceAdapter.ViewHolder>(){

    private val provinceList =  ArrayList<ProvincesItem>()
    private var onItemClickCallback : OnItemClickCallback? = null

    fun setProvinceList(provinceResponse: ArrayList<ProvincesItem>){
        provinceList.clear()
        provinceList.addAll(provinceResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder (val binding: ItemRowProvinceBinding) : RecyclerView.ViewHolder(binding.root){
        fun bind(provinceResponse: ProvincesItem){
            with(binding){
                tvItemIdProv.text = provinceResponse.id
                tvItemProv.text = provinceResponse.name
            }
            binding.root.setOnClickListener{
                onItemClickCallback?.onItemClicked(provinceResponse)
                val intent1 = Intent(itemView.context, CityListActivity::class.java)
                intent1.putExtra(CityListActivity.P_ID, provinceResponse.id)
                DataHospital.provID = provinceResponse.id
                itemView.context.startActivity(intent1)
                println(provinceResponse.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowProvinceBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(provinceList[position])
    }

    override fun getItemCount(): Int = provinceList.size

    interface OnItemClickCallback {
        fun onItemClicked(provinceResponse: ProvincesItem)
    }

}