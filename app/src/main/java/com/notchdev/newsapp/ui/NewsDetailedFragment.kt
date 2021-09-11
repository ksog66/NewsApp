package com.notchdev.newsapp.ui

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import com.notchdev.newsapp.R
import com.notchdev.newsapp.databinding.FragmentNewsDetailedBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class NewsDetailedFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding:FragmentNewsDetailedBinding = DataBindingUtil.inflate(inflater,R.layout.fragment_news_detailed,container,false)
        return binding.root
    }
}