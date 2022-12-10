package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.NonCovidHospitalList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Covid.CovidDetailHospitalActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.NonCovid.NonCovidDetailHospitalActivity
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowNoncovidhospitalBinding

class NonCovidHospitalAdapter () : RecyclerView.Adapter<NonCovidHospitalAdapter.ViewHolder>() {
    private val hospitalList = ArrayList<HospitalsItem>()

    private val onItemClickCallback : OnItemClickCallback? = null

    fun setHospitalList(hospitalResponse: ArrayList<HospitalsItem>){
        hospitalList.clear()
        hospitalList.addAll(hospitalResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemRowNoncovidhospitalBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(hospitalResponse: HospitalsItem){
            with(binding){
                tvItemHospitalName.text = hospitalResponse.name
                tvItemHospitalAddress.text = hospitalResponse.address
            }
            binding.root.setOnClickListener {
                onItemClickCallback?.onItemClicked(hospitalResponse)
                val intent = Intent(itemView.context, NonCovidDetailHospitalActivity::class.java)
                intent.putExtra(CovidDetailHospitalActivity.HOSPITAL_ID, hospitalResponse.id)
                DataHospital.nonCovHospitalID = hospitalResponse.id
                itemView.context.startActivity(intent)
                println(hospitalResponse.id)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowNoncovidhospitalBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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