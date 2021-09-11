package com.notchdev.newsapp.di

import com.notchdev.newsapp.adapter.NewsAdapter
import com.notchdev.newsapp.data.source.remote.NewsApi
import com.notchdev.newsapp.data.source.repository.NewsRepository
import com.notchdev.newsapp.data.source.repository.NewsRepositoryImpl
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent
import dagger.hilt.android.scopes.ActivityRetainedScoped
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Singleton
    @Provides
    fun provideNewsRepository(
        newsApi: NewsApi
    ):NewsRepository {
        return NewsRepositoryImpl(newsApi = newsApi)
    }

    @Singleton
    @Provides
    fun provideNewsAdapter(): NewsAdapter = NewsAdapter()
}