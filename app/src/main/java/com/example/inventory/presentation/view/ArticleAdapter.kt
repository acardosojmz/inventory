package com.example.inventory.presentation.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.databinding.ItemArticleBinding


class ArticleAdapter(var articleList: List<ArticleModel>,) : RecyclerView.Adapter<ArticleAdapter.ViewHolder>() {
   inner class ViewHolder(val binding: ItemArticleBinding) : RecyclerView.ViewHolder(binding.root)

   override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemArticleBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        with(holder) {
            with(articleList[position]){
                binding.tvArticle.text = this.article
                binding.tvDescription.text = this.description
                binding.tvPrice.text= "$ ${this.price}"
            }
        }
    }

    override fun getItemCount(): Int {
        return articleList.size
    }
}