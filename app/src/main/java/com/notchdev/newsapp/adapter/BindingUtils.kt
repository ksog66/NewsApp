package com.notchdev.newsapp.adapter

import android.widget.ImageView
import android.widget.TextView
import androidx.databinding.BindingAdapter
import com.bumptech.glide.Glide
import com.notchdev.newsapp.data.model.Article


@BindingAdapter("articleTitleString")
fun TextView.setTitle(item: Article) {
    text = item.title
}

@BindingAdapter("articleSourceString")
fun TextView.setSource(item:Article) {
    text = item.source.name
}

@BindingAdapter("articleDateString")
fun TextView.setDate(item:Article) {
    text = item.publishedAt
}

@BindingAdapter("articleImage")
fun ImageView.setArticleImage(item:Article) {
    Glide.with(this).load(item.urlToImage).into(this)
}