package com.notchdev.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.notchdev.newsapp.data.model.Article
import com.notchdev.newsapp.databinding.ListArticleBinding


class NewsAdapter : ListAdapter<Article, NewsAdapter.NewsViewHolder>(NewsDiffCallBack()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }


    class NewsViewHolder(val binding: ListArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article) {
            binding.article = item
            binding.executePendingBindings()
        }

        companion object {
            fun from(parent: ViewGroup): NewsViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val binding = ListArticleBinding.inflate(layoutInflater, parent, false)
                return NewsViewHolder(binding)
            }
        }
    }

}

class NewsDiffCallBack : DiffUtil.ItemCallback<Article>() {

    override fun areItemsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem.description == newItem.description
    }

    override fun areContentsTheSame(oldItem: Article, newItem: Article): Boolean {
        return oldItem == newItem
    }
}