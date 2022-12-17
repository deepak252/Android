package com.academy.a26_broadcast_receivers

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ImageView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val imageView = findViewById<ImageView>(R.id.imageView)

//        Toast.makeText(this,"Action : ${intent.action}, Type : ${intent.type}",Toast.LENGTH_SHORT).show()
        if(intent.type!=null){
            if(intent.action==Intent.ACTION_SEND){
//                Log.d("Image 1","${Intent.EXTRA_STREAM}");
                imageView.setImageURI(intent.getParcelableExtra(Intent.EXTRA_STREAM))
            }else if(intent.action==Intent.ACTION_VIEW){
//                Log.d("Image 2","${intent.data}");
                imageView.setImageURI(intent.data)
            }
        }

    }
}