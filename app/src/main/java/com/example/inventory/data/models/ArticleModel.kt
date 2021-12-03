package com.example.inventory.data.models

data class ArticleModel(val id: Int,
                        val article: String,
                        val description:String,
                        val brand: String,
                        val category: String,
                        val price: Double,
                        val image: String
)
