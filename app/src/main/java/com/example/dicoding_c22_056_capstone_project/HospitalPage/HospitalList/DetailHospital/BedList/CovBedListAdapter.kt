package com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedList

import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dicoding_c22_056_capstone_project.HospitalPage.DataHospital
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.CovidHospitalAdapter
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.CovidHospitalList.HospitalsItem
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedDetailItem
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.BedList.BedListDetail.BedListDetailActivity
import com.example.dicoding_c22_056_capstone_project.HospitalPage.HospitalList.DetailHospital.Covid.CovidDetailHospitalActivity
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowBeddetailBinding
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowBedlistBinding
import com.example.dicoding_c22_056_capstone_project.databinding.ItemRowCovidhospitalBinding

class CovBedListAdapter () : RecyclerView.Adapter<CovBedListAdapter.ViewHolder>() {
    private val bedlist = ArrayList<BedDetailItem>()
    private val onItemClickCallback : OnItemClickCallback? =null

    fun setBedList(bedListResponse: ArrayList<BedDetailItem>){
        bedListResponse.clear()
        bedListResponse.addAll(bedListResponse)
        notifyDataSetChanged()
    }

    inner class ViewHolder(val binding: ItemRowBeddetailBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(bedResponse: BedDetailItem){
            with(binding){
                time.text = bedResponse.time
            }
            binding.root.setOnClickListener{
                onItemClickCallback?.onItemClicked(bedResponse)
                val intent = Intent(itemView.context, BedListDetailActivity::class.java)
                itemView.context.startActivity(intent)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = ItemRowBeddetailBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(bedlist[position])
    }

    override fun getItemCount(): Int = bedlist.size

    interface OnItemClickCallback{
        fun onItemClicked(bedResponse: BedDetailItem)
    }
}