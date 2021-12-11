package com.example.inventory.presentation.viewmodel



import androidx.lifecycle.ViewModel
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.domain.usecase.AddArticleUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(private val addArticleUseCase: AddArticleUseCase): ViewModel() {
    private val _id = MutableStateFlow(0L)
    val id: StateFlow<Long> = _id

    fun addArticle(articleModel: ArticleModel){
            addArticleUseCase.addArticle(articleModel)

    }

}