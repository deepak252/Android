package com.example.a32a_retrofit_demo

import android.app.Activity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide

class NewsAdapter(private val articles : MutableList<Article>,private val context : Activity )  : RecyclerView.Adapter<NewsAdapter.NewsViewHolder>() {
    class NewsViewHolder(view : View) : RecyclerView.ViewHolder(view) {
        val imgArticle : ImageView
        val tvTitle : TextView
        val tvAuthor : TextView
        val tvDescription : TextView

        init {
            imgArticle = view.findViewById(R.id.imgArticle)
            tvTitle = view.findViewById(R.id.tvTitle)
            tvAuthor = view.findViewById(R.id.tvAuthor)
            tvDescription = view.findViewById(R.id.tvDescription)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.article_card_view,parent,false)
        return NewsViewHolder(view)
    }

    override fun getItemCount(): Int {
        return articles.size
    }

    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val article = articles[position]
        holder.tvTitle.text = article.title
        holder.tvAuthor.text = article.author
        holder.tvDescription.text = article.description

        Glide.with(context)
            .load(article.urlToImage)
            .placeholder(R.drawable.baseline_image_24)
            .into(holder.imgArticle)


    }
}