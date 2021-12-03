package com.example.inventory.core.di

import com.example.inventory.data.entity.ArticleEntity
import com.example.inventory.data.models.ArticleModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flatMapConcat
import kotlinx.coroutines.flow.toList


suspend fun <T> Flow<List<T>>.convertToList() =
    flatMapConcat { it.asFlow() }.toList()

fun ArticleEntity.toModel() = ArticleModel(
    id=id,
    article= article,
    description= description,
    brand= brand,
    category= category,
    price= price,
    image= image
)
fun ArticleModel.toEntity() = ArticleEntity(
    id=id,
    article= article,
    description= description,
    brand= brand,
    category= category,
    price= price,
    image= image
)

fun List<ArticleModel>.toListArticleEntity () =
    map {it.toEntity() }

fun List<ArticleEntity>.toListArticleModel () =
    map {it.toModel() }