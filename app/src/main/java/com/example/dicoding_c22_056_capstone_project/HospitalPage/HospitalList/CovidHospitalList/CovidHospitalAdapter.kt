package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.HospitalPage.City.CitiesItem
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.DetailHospitalActivity
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowCovidhospitalBinding

class CovidHospitalAdapter () : RecyclerView.Adapter<CovidHospitalAdapter.ViewHolder>(){
    private val hospitalList = ArrayList<HospitalsItem>()
    private val onItemClickCallback : OnItemClickCallback? = null

    fun setHospitalList(hospitalResponse: ArrayList<HospitalsItem>){
        hospitalList.clear()
        hospitalList.addAll(hospitalResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemRowCovidhospitalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hospitalResponse: HospitalsItem){
            with(binding){
                tvItemHospitalName.text = hospitalResponse.name
                tvItemHospitalAddress.text = hospitalResponse.address
                tvItemBedAvailabilityNumber.text = hospitalResponse.bedAvailability.toString()
                tvItemBedUpdate.text = hospitalResponse.info
            }
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(hospitalResponse)
                val intent = Intent(itemView.context, DetailHospitalActivity::class.java)
                intent.putExtra(DetailHospitalActivity.HOSPITAL_ID, hospitalResponse.id)
                itemView.context.startActivity(intent)
                println(hospitalResponse.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowCovidhospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(hospitalList[position])
    }

    override fun getItemCount(): Int = hospitalList.size

    interface OnItemClickCallback{
        fun onItemClicked(hospitalResponse: HospitalsItem)
    }
}