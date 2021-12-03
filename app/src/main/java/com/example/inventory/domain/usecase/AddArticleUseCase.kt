package com.example.inventory.domain.usecase

import com.example.inventory.data.models.ArticleModel
import com.example.inventory.data.models.ArticleResponse
import com.example.inventory.domain.ArticleRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject


class AddArticleUseCase  @Inject constructor(private val articleRepository: ArticleRepository) {
    fun addArticle(articleModel: ArticleModel) =
        articleRepository.addArticle(articleModel)

}