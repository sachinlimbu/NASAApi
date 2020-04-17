package com.example.nasaapi.common.network
import com.example.nasaapi.common.API_KEY
import com.example.nasaapi.common.BASE_URL
import com.example.nasaapi.common.model.NasaMainBase
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface MarsRoverPhotosClient {
//    @GET("{BASE_URL}/rovers/curiosity/photos?sol=1000")
//    fun getMarsRoverPhotosChoosingRoverCameras(
//        @Query("api_key") api_key:String = API_KEY
//    ): Single<NasaMainBase>

    @GET(BASE_URL)
    fun getMarsRoverPhotosChoosingRoverCameras( @Query("api_key") api_key:String = API_KEY): Single<NasaMainBase>
}