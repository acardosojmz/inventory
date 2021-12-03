package com.example.inventory.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "article")
data class ArticleEntity (
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id")
    var id: Int = 0,
    @SerializedName("article")
    var article: String = "",
    @SerializedName("description")
    var description: String = "",
    @SerializedName("brand")
    var brand: String = "",
    @SerializedName("category")
    var category: String = "",
    @SerializedName("price")
    var price: Double=0.0,
    @SerializedName("image")
    var image: String = "",

)