package com.example.nasaapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.nasaapi.R
import com.example.nasaapi.common.model.NasaMainBase
import com.example.nasaapi.common.model.marsroverphotos.Photos
import kotlinx.android.synthetic.main.list_of_mars_rover.view.*

class NasaAdapter (private val nasaMainBase: List<Photos>):RecyclerView.Adapter<NasaAdapter.NasaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
        return NasaViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_mars_rover,parent,false))
    }

    override fun getItemCount(): Int {
        return nasaMainBase.size
    }

    override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {
        holder.name.text = nasaMainBase[position].earth_date
    }

    class NasaViewHolder(viewItem:View):RecyclerView.ViewHolder(viewItem) {
        var name:TextView = viewItem.marsRoverName_id
    }
}