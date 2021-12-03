package com.example.inventory.presentation.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.viewModels
import androidx.lifecycle.lifecycleScope
import com.example.inventory.data.models.ArticleModel
import com.example.inventory.databinding.ActivityAddArticleBinding
import com.example.inventory.presentation.viewmodel.AddArticleViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddArticleActivity : AppCompatActivity() {
    private lateinit var binding: ActivityAddArticleBinding
    private val addArticleModel: AddArticleViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityAddArticleBinding.inflate(layoutInflater)
        setContentView(binding.root)
        addArticleModel.let {  }
        binding.btnSave.setOnClickListener {
            with(binding){
                val article = etArticle.text.toString()
                val description = etDescription.text.toString()
                val brand = etBrand.text.toString()
                val category = etCategory.text.toString()
                val price = etPrice.text.toString().toDouble()
                val image = etImage.text.toString()
                val message="Datos: $article, $description, $brand, $category, $price, $image"
                Toast.makeText(this@AddArticleActivity,message, Toast.LENGTH_LONG).show()

                val articleModel=ArticleModel(id=0,article=article,description=description,
                    brand=brand,category=category,price=price,image=image)
                lifecycleScope.launch(Dispatchers.IO) {
                    addArticleModel.addArticle(articleModel)
                }

            }
        }
        observer()
    }

    private fun observer(){
        lifecycleScope.launch(Dispatchers.IO) {
            Log.e("ID", "${addArticleModel.id.value.toString()}")
        }
    }
}