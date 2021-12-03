package com.example.inventory.data

import com.example.inventory.data.models.ArticleModel
import kotlinx.coroutines.flow.Flow

interface LocalDataSource {
    fun getAll(): Flow<List<ArticleModel>>
    fun addArticle(articleModel: ArticleModel)
}