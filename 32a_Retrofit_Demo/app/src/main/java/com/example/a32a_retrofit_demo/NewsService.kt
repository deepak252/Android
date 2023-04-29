package com.example.a32a_retrofit_demo

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

//https://saurav.tech/NewsAPI/top-headlines/category/health/in.json

const val NEWS_URL = "https://saurav.tech/NewsAPI/"
interface NewsInterface{
    @GET("top-headlines/category/health/in.json")
    fun getNews() : Call<News>
}
// Singleton
object NewsService  {
    val INSTANCE : NewsInterface
    init {
        val retrofit = Retrofit.Builder()
            .baseUrl(NEWS_URL)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        INSTANCE = retrofit.create(NewsInterface::class.java)
    }
}