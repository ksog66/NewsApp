package com.notchdev.newsapp.ui

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.notchdev.newsapp.data.model.Article
import com.notchdev.newsapp.data.model.NewsResponse
import com.notchdev.newsapp.data.source.repository.NewsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import io.reactivex.Observer
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

@HiltViewModel
class NewsViewModel @Inject constructor(
    private val newsRepository: NewsRepository
):ViewModel() {


    init {
        getTopHeadlines("us")
    }
    private val _articles = MutableLiveData<List<Article>?>()
    val articles: LiveData<List<Article>?> = _articles

    private val _url = MutableLiveData<String>()
    val url:LiveData<String> = _url

    fun setUrl(webUrl:String) {
        _url.value = webUrl
    }
    private fun getTopHeadlines(country:String) {
        newsRepository.getAllNews(country).subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe(getNewsObserver())
    }

    private fun getNewsObserver(): Observer<NewsResponse> {
        return object : Observer<NewsResponse> {
            override fun onSubscribe(d: Disposable) {
            }

            override fun onNext(t: NewsResponse) {
                _articles.postValue(t.articles)
            }

            override fun onError(e: Throwable) {
                Log.d("NewsVM", "onError: ${e.localizedMessage} ")
                _articles.postValue(null)
            }

            override fun onComplete() {
            }
        }
    }
}