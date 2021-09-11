package com.notchdev.newsapp.data.source.repository

import com.notchdev.newsapp.data.model.NewsResponse
import io.reactivex.Observable

interface NewsRepository {

    fun getAllNews(country:String): Observable<NewsResponse>
}