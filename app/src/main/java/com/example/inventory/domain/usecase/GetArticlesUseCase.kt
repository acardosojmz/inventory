package com.example.inventory.domain.usecase

import com.example.inventory.data.models.ArticleModel
import com.example.inventory.domain.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class GetArticlesUseCase  @Inject constructor(private val articleRepository: ArticleRepository) {
    fun getAll(): Flow<List<ArticleModel>> = articleRepository.getAll()

}