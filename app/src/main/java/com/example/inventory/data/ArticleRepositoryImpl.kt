package com.example.inventory.data

import com.example.inventory.data.models.ArticleModel
import com.example.inventory.domain.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepositoryImpl @Inject constructor(private val localDataSource: LocalDataSource): ArticleRepository {
    override  fun getAll(): Flow<List<ArticleModel>> {
        return localDataSource.getAll()
    }

    override fun addArticle(articleModel: ArticleModel) {
        localDataSource.addArticle(articleModel)
    }

}