package com.example.nasaapi.di.component

import com.example.nasaapi.MainActivity
import com.example.nasaapi.di.module.MarsRoverPhotosViewModule
import com.example.nasaapi.di.scope.ActivityScope
import dagger.Component
@ActivityScope
@Component(modules = [MarsRoverPhotosViewModule::class], dependencies = [AppComponent::class])
interface MarsRoverPhotoComponent{
    fun inject(mainActivity: MainActivity)
}