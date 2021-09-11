package com.notchdev.newsapp.data.source.remote

import com.notchdev.newsapp.data.model.NewsResponse
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Query

interface NewsApi {

    @GET("top-headlines")
    fun getAllNews(
        @Query("country") countryCode: String,
        @Query("page")
        pageNumber: Int = 1,
        @Query("apiKey") apiKey: String
    ): Observable<NewsResponse>
}