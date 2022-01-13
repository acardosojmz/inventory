package com.example.inventory.presentation.view

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.inventory.R
import com.example.inventory.databinding.ActivityListArticleBinding
import com.example.inventory.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnAgregar.setOnClickListener {
            val intent = Intent(this, AddArticleActivity::class.java)
            startActivity(intent)
        }
        binding.btnListar.setOnClickListener {
            val intent = Intent(this, ListArticleActivity::class.java)
            startActivity(intent)
        }
    }
}