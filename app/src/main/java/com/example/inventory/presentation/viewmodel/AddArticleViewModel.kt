package com.example.inventory.presentation.viewmodel


import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.domain.usecase.AddArticleUseCase

import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class AddArticleViewModel @Inject constructor(private val addArticleUseCase: AddArticleUseCase): ViewModel() {
    private val _id = MutableStateFlow(0L)
    val id: StateFlow<Long> = _id


    fun addArticle(articleModel: ArticleModel){
        viewModelScope.launch {
            addArticleUseCase.addArticle(articleModel)
            //Log.e("ID",id.toString())
        }
    }
}