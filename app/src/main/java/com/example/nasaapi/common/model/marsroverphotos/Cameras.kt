package com.example.nasaapi.common.model.marsroverphotos

import com.google.gson.annotations.SerializedName


data class Cameras (

	@SerializedName("name") val name : String,
	@SerializedName("full_name") val full_name : String
)