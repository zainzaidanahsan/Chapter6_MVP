package com.example.chapter6_mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.chapter6_mvp.R
import com.example.chapter6_mvp.databinding.ActivityDetailBinding

class DetailActivity : AppCompatActivity() {
    class DetailActivity : AppCompatActivity() {
        lateinit var binding: ActivityDetailBinding

        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityDetailBinding.inflate(layoutInflater)
            setContentView(binding.root)

            val id = intent.getStringExtra("id")
            val img = intent.getStringExtra("img")
            val nama = intent.getStringExtra("nama")
            val cat = intent.getStringExtra("cat")
            val price = intent.getStringExtra("price")

            Glide.with(this).load(img).into(binding.carImage)
            binding.txtId.text = id
            binding.txtName.text = nama
            binding.txtCategory.text = cat
            binding.txtHarga.text = price
        }
    }
}