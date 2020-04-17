package com.example.nasaapi.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.nasaapi.common.model.NasaMainBase
import com.example.nasaapi.common.model.marsroverphotos.Photos
import com.example.nasaapi.common.network.MarsRoverPhotosRepository
import io.reactivex.disposables.CompositeDisposable

class MarsRoverPhotosViewModel (private val repo:MarsRoverPhotosRepository):ViewModel(){
    val _mLoadingMarsRoverPhotoState = MutableLiveData<LoadingMarsRoverPhotoState>()

    private val compositeDisposable = CompositeDisposable()
    fun getMarsRoverPhotoDate(){
        _mLoadingMarsRoverPhotoState.postValue(LoadingMarsRoverPhotoState.IN_PROGRESS)
        compositeDisposable.add(
            repo.getData()
                .subscribe({
                    if(it.photos.isEmpty()){
                        _mLoadingMarsRoverPhotoState.value = LoadingMarsRoverPhotoState.ERROR("No Mars Photos Found")
                    }else{
                        _mLoadingMarsRoverPhotoState.value = LoadingMarsRoverPhotoState.SUCCESS(it.photos)
                    }
                },{
                    _mLoadingMarsRoverPhotoState.value = LoadingMarsRoverPhotoState.ERROR(it.localizedMessage?:"Some error occurred")
                })
        )
    }

    sealed class LoadingMarsRoverPhotoState{
        object IN_PROGRESS: LoadingMarsRoverPhotoState()
        data class SUCCESS(val repo: List<Photos>):LoadingMarsRoverPhotoState()
        data class ERROR(val message:String):LoadingMarsRoverPhotoState()
    }

    override fun onCleared() {
        compositeDisposable.clear()
        super.onCleared()
    }


}


