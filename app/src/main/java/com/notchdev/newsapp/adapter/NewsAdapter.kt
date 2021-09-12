package com.notchdev.newsapp.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.notchdev.newsapp.data.model.Article
import com.notchdev.newsapp.databinding.ListArticleBinding


class NewsAdapter : ListAdapter<Article, NewsAdapter.NewsViewHolder>(NewsDiffCallBack()) {


    private var onArticleClickListener: ArticleClickListener? = null

    fun setOnArticleClickListener(listener: ArticleClickListener) {
        onArticleClickListener = listener
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): NewsViewHolder {
        return NewsViewHolder.from(parent)
    }


    override fun onBindViewHolder(holder: NewsViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item,onArticleClickListener)
    }


    class NewsViewHolder(val binding: ListArticleBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(item: Article, onArticleClickListener: ArticleClickListener?) {
            binding.article = item
            binding.clickListener = onArticleClickListener
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

class ArticleClickListener(val listener: (url:String)-> Unit) {
    fun onClick(article: Article) = listener(article.url)
}