package com.example.nasaapi.common.network

import com.example.nasaapi.common.model.NasaMainBase
import io.reactivex.Scheduler
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class MarsRoverPhotosImplementation @Inject constructor(
    private val repoClient:MarsRoverPhotosClient
):MarsRoverPhotosRepository{
    override fun getData(): Single<NasaMainBase> {
        return repoClient.getMarsRoverPhotosChoosingRoverCameras()
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
    }
}