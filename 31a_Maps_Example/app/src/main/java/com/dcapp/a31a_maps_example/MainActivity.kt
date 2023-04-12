package com.dcapp.a31a_maps_example

import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat

class MainActivity : AppCompatActivity() {
    lateinit var btnOsmView : Button
    lateinit var btnCheckLocationPermission : Button
    lateinit var btnRequestLocationPermission : Button

    val locationPermissionRequest = registerForActivityResult(
        ActivityResultContracts.RequestMultiplePermissions()
    ) { permissions ->
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            when {
                permissions.getOrDefault(android.Manifest.permission.ACCESS_COARSE_LOCATION, false) -> {
                    showToast("ACCESS_COARSE_LOCATION Granted")
                }
                permissions.getOrDefault(android.Manifest.permission.ACCESS_FINE_LOCATION, false) -> {
                    showToast("ACCESS_FINE_LOCATION Granted")
                }
                else -> {
                    showToast("No Location Permission Granted")
                }
            }
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOsmView = findViewById(R.id.btnOsm)
        btnCheckLocationPermission = findViewById(R.id.btnCheckLocationPermission)
        btnRequestLocationPermission = findViewById(R.id.btnRequestLocationPermission)
        btnOsmView.setOnClickListener{
            val intent = Intent(this,OSMExample::class.java)
            startActivity(intent)
        }
        btnCheckLocationPermission.setOnClickListener{
            checkLocationPermission()
        }

        btnRequestLocationPermission.setOnClickListener{
            requestLocationPermission()
        }
    }

    fun checkLocationPermission(){
        if(ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_COARSE_LOCATION
            )!=PackageManager.PERMISSION_GRANTED){
            showToast("ACCESS_COARSE_LOCATION not granted")
        }else{
            showToast("ACCESS_COARSE_LOCATION  granted")
        }

        if(ContextCompat.checkSelfPermission(
                this, android.Manifest.permission.ACCESS_FINE_LOCATION
            )!=PackageManager.PERMISSION_GRANTED){
            showToast("ACCESS_FINE_LOCATION not granted")
        }else{
            showToast("ACCESS_FINE_LOCATION  granted")
        }

    }
    private fun requestLocationPermission(){
        val permissions = arrayOf(
            android.Manifest.permission.ACCESS_FINE_LOCATION,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        )
        locationPermissionRequest.launch(permissions)
    }

    private fun showToast(message : String){
        Log.d("MyTag", message)
        Toast.makeText(this,message,Toast.LENGTH_SHORT).show()
    }


}