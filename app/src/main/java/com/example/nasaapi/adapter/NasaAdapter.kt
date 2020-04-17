package com.example.nasaapi.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.nasaapi.R
import com.example.nasaapi.common.model.NasaMainBase
import com.example.nasaapi.common.model.marsroverphotos.Photos
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.list_of_mars_rover.view.*
import org.w3c.dom.Text

class NasaAdapter (private val nasaMainBase: List<Photos>):RecyclerView.Adapter<NasaAdapter.NasaViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NasaViewHolder {
        return NasaViewHolder(LayoutInflater.from(parent.context)
            .inflate(R.layout.list_of_mars_rover,parent,false))
    }

    override fun getItemCount(): Int {
        return nasaMainBase.size
    }

    override fun onBindViewHolder(holder: NasaViewHolder, position: Int) {

        val imageUrlPath:String = nasaMainBase[position].img_src

        val finalImageUrlPath = imageUrlPath.replace("http","https")
        Picasso.get().load("https://mars.jpl.nasa.gov/msl-raw-images/msss/00001/mcam/0001MR0000001000C0_DXXX.jpg").into(holder.nasaImage)

        holder.cameraTitle.text = nasaMainBase[position].camera.name
          holder.cameraFullName.text = nasaMainBase[position].camera.full_name
          holder.earthDate.text = nasaMainBase[position].earth_date
          holder.roverName.text = nasaMainBase[position].rover.name

        //https://mars.jpl.nasa.gov/msl-raw-images/msss/00001/mcam/0001ML0000001000I1_DXXX.jpg
        //https://mars.jpl.nasa.gov/msl-raw-images/msss/00001/mcam/0001MR0000001000C0_DXXX.jpg

    }

    class NasaViewHolder(viewItem:View):RecyclerView.ViewHolder(viewItem) {
        var cameraTitle:TextView = viewItem.tv_camera_title_id
        var cameraFullName:TextView = viewItem.tv_camera_fullname_id
        var earthDate:TextView = viewItem.tv_earth_date_id
        var roverName:TextView = viewItem.tv_rover_name
        var nasaImage:ImageView = viewItem.iV_camera_id

    }
}