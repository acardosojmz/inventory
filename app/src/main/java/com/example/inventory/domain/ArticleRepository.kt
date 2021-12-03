package com.example.inventory.domain

import com.example.inventory.data.models.ArticleModel
import kotlinx.coroutines.flow.Flow

interface ArticleRepository {
    fun getAll(): Flow<List<ArticleModel>>
    fun addArticle(articleModel: ArticleModel)
}