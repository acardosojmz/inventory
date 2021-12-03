package com.example.inventory.data.models

import com.google.gson.annotations.SerializedName


data class ArticleResponse (
    @SerializedName("success")
    var success: Boolean,

    @SerializedName("message")
    var message: String,

    @SerializedName("data")
    var data: List<ArticleModel>
)