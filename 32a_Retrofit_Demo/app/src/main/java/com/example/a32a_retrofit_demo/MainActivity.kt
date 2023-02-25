package com.example.a32a_retrofit_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.TextView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fetchNews()
    }

    fun fetchNews(){
        val news = NewsService.INSTANCE.getNews()
        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("MyTag", response.body().toString())
                findViewById<TextView>(R.id.tvNews).text = response.body().toString()
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MyTag", "${t.message}")
            }

        })
    }
}