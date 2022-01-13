package com.example.inventory.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.databinding.ActivityListArticleBinding
import com.example.inventory.presentation.viewmodel.ListArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@AndroidEntryPoint
class ListArticleActivity : AppCompatActivity() {
    private lateinit var binding : ActivityListArticleBinding
    private lateinit var articleAdapter: ArticleAdapter
    private lateinit var articleList : List<ArticleModel>
    private val listArticleViewModel: ListArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        observer()
    }

    private  fun observer() {
        listArticleViewModel.articleList.let {
           lifecycleScope.launch {
               listArticleViewModel.articleList.collect {
                   articleList = it
                   val layoutManager: RecyclerView.LayoutManager = LinearLayoutManager(this@ListArticleActivity)
                   binding.articleRecyclerView.layoutManager = layoutManager
                   articleAdapter = ArticleAdapter(articleList)
                   binding.articleRecyclerView.adapter = articleAdapter
               }
           }
        }
    }
}