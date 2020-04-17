package com.example.nasaapi.common.network

import com.example.nasaapi.common.model.NasaMainBase
import io.reactivex.Single

interface MarsRoverPhotosRepository {
    fun getData(): Single<NasaMainBase>
}