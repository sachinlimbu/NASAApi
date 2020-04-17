package com.example.nasaapi.common.model.marsroverphotos
import com.google.gson.annotations.SerializedName

data class Rover (
	@SerializedName("id") val id : Int,
	@SerializedName("name") val name : String,
	@SerializedName("landing_date") val landing_date : String,
	@SerializedName("launch_date") val launch_date : String,
	@SerializedName("status") val status : String,
	@SerializedName("max_sol") val max_sol : Int,
	@SerializedName("max_date") val max_date : String,
	@SerializedName("total_photos") val total_photos : Int,
	@SerializedName("cameras") val cameras : List<Cameras>
)