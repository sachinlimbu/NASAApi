package com.example.nasaapi.di.module

import androidx.lifecycle.ViewModelProvider
import com.example.nasaapi.MainActivity
import com.example.nasaapi.common.network.MarsRoverPhotosClient
import com.example.nasaapi.common.network.MarsRoverPhotosImplementation
import com.example.nasaapi.common.network.MarsRoverPhotosRepository
import com.example.nasaapi.di.scope.ActivityScope
import com.example.nasaapi.viewmodels.MarsRoverPhotosViewModel
import com.example.nasaapi.viewmodels.MarsRoverPhotosViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MarsRoverPhotosViewModule (private val mainActivity: MainActivity){
    @Provides
    @ActivityScope
    fun provideViewModelFactory(repository: MarsRoverPhotosRepository):MarsRoverPhotosViewModelFactory{
        return MarsRoverPhotosViewModelFactory(repository)
    }

    @Provides
    @ActivityScope
    fun provideViewModel(factory:MarsRoverPhotosViewModelFactory):MarsRoverPhotosViewModel{
        return ViewModelProvider(mainActivity,factory).get(MarsRoverPhotosViewModel::class.java)
    }

    @Provides
    @ActivityScope
    fun provideMarsRoverPhotoRepository(client:MarsRoverPhotosClient):MarsRoverPhotosRepository{
        return MarsRoverPhotosImplementation(client)
    }
}