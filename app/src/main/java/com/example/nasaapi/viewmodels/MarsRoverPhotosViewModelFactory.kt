package com.example.nasaapi.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.nasaapi.common.network.MarsRoverPhotosRepository

class MarsRoverPhotosViewModelFactory (private val repository: MarsRoverPhotosRepository):ViewModelProvider.Factory{
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return MarsRoverPhotosViewModel(repository) as T
    }
}