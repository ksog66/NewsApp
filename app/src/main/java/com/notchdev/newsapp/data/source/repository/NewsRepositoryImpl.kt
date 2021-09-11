package com.notchdev.newsapp.data.source.repository

import android.util.Log
import com.notchdev.newsapp.data.model.NewsResponse
import com.notchdev.newsapp.data.source.remote.NewsApi
import com.notchdev.newsapp.utils.Constants.API_KEY
import io.reactivex.Observable

class NewsRepositoryImpl(
    private val newsApi: NewsApi
) : NewsRepository {

    override fun getAllNews(country: String): Observable<NewsResponse> {
        val result = newsApi.getAllNews(countryCode = country,apiKey = API_KEY)
        Log.d("NewsRepo","$result")
        return result.doOnNext {
            Log.d("NewsRepo", "getAllNews: ${it.totalResults} ")
        }
    }
}