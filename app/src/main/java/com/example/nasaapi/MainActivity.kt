package com.example.nasaapi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.nasaapi.adapter.NasaAdapter
import com.example.nasaapi.di.component.DaggerMarsRoverPhotoComponent
import com.example.nasaapi.di.module.MarsRoverPhotosViewModule
import com.example.nasaapi.viewmodels.MarsRoverPhotosViewModel
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {
    @Inject
    lateinit var marsRoverPhotosViewModel: MarsRoverPhotosViewModel


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        DaggerMarsRoverPhotoComponent.builder().appComponent((applicationContext as MyApp).component())
            .marsRoverPhotosViewModule(MarsRoverPhotosViewModule(this))
            .build().inject(this)


        recycler_view_mars_rover_main.layoutManager = LinearLayoutManager(this)
        marsRoverPhotosViewModel._mLoadingMarsRoverPhotoState.observe(this, Observer {
            when(it){
                is MarsRoverPhotosViewModel.LoadingMarsRoverPhotoState.IN_PROGRESS -> displayProgress()
                is MarsRoverPhotosViewModel.LoadingMarsRoverPhotoState.SUCCESS -> {
                    recycler_view_mars_rover_main.adapter = NasaAdapter(it.repo)
                }
                is MarsRoverPhotosViewModel.LoadingMarsRoverPhotoState.ERROR -> displayToast(it.message)
            }
        })
        marsRoverPhotosViewModel.getMarsRoverPhotoDate()
    }

    private fun displayProgress(){
        displayToast("Fetching hospital list")
    }
    private fun displayToast(message:String){
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show()
    }
}
