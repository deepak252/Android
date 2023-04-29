package com.example.a32a_retrofit_demo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    private lateinit var rvNews : RecyclerView
    private val articles = mutableListOf<Article>()
    lateinit var loader : ProgressBar
//    private var articles =
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loader = findViewById(R.id.loader)
        rvNews = findViewById(R.id.rvNews)
        loader.visibility = View.VISIBLE
        rvNews.adapter = NewsAdapter( articles,this@MainActivity)
        rvNews.layoutManager = LinearLayoutManager(this@MainActivity)

        fetchNews()
    }

    fun fetchNews(){
        val news = NewsService.INSTANCE.getNews()
        news.enqueue(object : Callback<News>{
            override fun onResponse(call: Call<News>, response: Response<News>) {
                Log.d("MyTag", response.body().toString())
                loader.visibility = View.INVISIBLE
                if(response.body()!=null){
                    articles.addAll(response.body()!!.articles)
                    rvNews.adapter?.notifyDataSetChanged()
//                    rvNews.adapter = NewsAdapter(response.body()!!.articles, this@MainActivity)
//                    rvNews.layoutManager = LinearLayoutManager(this@MainActivity)
                }
            }

            override fun onFailure(call: Call<News>, t: Throwable) {
                Log.d("MyTag", "${t.message}")
                loader.visibility = View.INVISIBLE
                Toast.makeText(this@MainActivity,"${t.message}", Toast.LENGTH_SHORT).show()
            }

        })
    }
}