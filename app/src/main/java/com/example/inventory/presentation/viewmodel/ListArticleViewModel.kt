package com.example.inventory.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.domain.usecase.GetArticlesUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject
@HiltViewModel
class ListArticleViewModel @Inject constructor(private val getArticlesUseCase: GetArticlesUseCase) :ViewModel() {

    val articleModel= ArticleModel(id = 0, article = "", description = "",brand="", category = "", price = 0.0,image="")

    private val listArticlesMutableStateFlow = MutableStateFlow(listOf(articleModel))

    val articleList: StateFlow<List<ArticleModel>> = listArticlesMutableStateFlow

    init {
        viewModelScope.launch {
            getArticlesUseCase.getAll().collect {
                listArticlesMutableStateFlow.value  =it
            }
        }
    }

}