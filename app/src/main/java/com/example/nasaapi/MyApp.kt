package com.example.nasaapi

import android.app.Application
import com.example.nasaapi.di.component.AppComponent
import com.example.nasaapi.di.component.DaggerAppComponent
import com.example.nasaapi.di.module.NetworkModule

class MyApp : Application() {


    override fun onCreate() {
        super.onCreate()
        component()
    }


    fun component(): AppComponent {
        return DaggerAppComponent.builder()
            .networkModule(NetworkModule()).build()
    }
}
