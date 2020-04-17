package com.example.nasaapi.common.model
import com.example.nasaapi.common.model.marsroverphotos.Photos
import com.google.gson.annotations.SerializedName

data class NasaMainBase (

	@SerializedName("photos") val photos : List<Photos>
)