package com.example.inventory.data

import com.example.inventory.core.di.toEntity
import com.example.inventory.core.di.toListArticleModel
import com.example.inventory.data.dao.ArticleDAO
import com.example.inventory.data.models.ArticleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import javax.inject.Inject



class LocalDataSourceImpl  @Inject constructor(private val articleDAO: ArticleDAO): LocalDataSource {

    override  fun getAll(): Flow<List<ArticleModel>> {
        val articles = articleDAO.getAll()
        return articles.map { it.toListArticleModel() }
    }

    override fun addArticle(articleModel: ArticleModel) {
        articleDAO.addArticle(articleModel.toEntity())
    }

}
