package com.notchdev.newsapp.ui

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.notchdev.newsapp.R
import com.notchdev.newsapp.adapter.NewsAdapter
import com.notchdev.newsapp.databinding.FragmentNewsFeedBinding
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class NewsFeedFragment : Fragment() {

    val newsViewModel: NewsViewModel by viewModels()
    private var _binding:FragmentNewsFeedBinding? = null

    @Inject
    lateinit var newsAdapter: NewsAdapter
    private val binding:FragmentNewsFeedBinding
        get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = DataBindingUtil.inflate(inflater, R.layout.fragment_news_feed, container, false)

        setupRecyclerView()
        fetchNews()
        newsViewModel.articles.observe({lifecycle}) {
            it?.let {
                Log.d("NewsFragment", "onCreateView: $it ")
                newsAdapter.submitList(it)
            }
        }
        return binding.root
    }

    private fun fetchNews() {
        newsViewModel.articles.observe({lifecycle}) {
            if (it != null) {
                Log.d("NewsFragment", "fetchNews: $it ")
                newsAdapter.submitList(it)
            } else {
                Log.d("NewsFragment", "fetchNews: kuch Problem ho gayi hai maaalik ")
            }
        }
    }

    private fun setupRecyclerView() {
        binding.rvNews.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = newsAdapter
        }
    }

}