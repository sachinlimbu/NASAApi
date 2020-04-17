package com.example.nasaapi.di.component

import com.example.nasaapi.MyApp
import com.example.nasaapi.common.network.MarsRoverPhotosClient
import com.example.nasaapi.di.module.NetworkModule
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [NetworkModule::class])
interface AppComponent {
    fun inject(myApp:MyApp)
    fun client(): MarsRoverPhotosClient
}