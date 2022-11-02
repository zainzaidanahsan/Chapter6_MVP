package com.example.chapter6_mvp.View

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chapter6_mvp.Model.DataCarItem
import com.example.chapter6_mvp.Presenter.CarPresenter
import com.example.chapter6_mvp.Presenter.CarView
import com.example.chapter6_mvp.R
import com.example.chapter6_mvp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), CarView {
    lateinit var carPresenter: CarPresenter
    lateinit var binding : ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        carPresenter = CarPresenter(this)
        carPresenter.getCar()
    }

    override fun onSuccess(msg: String, car: List<DataCarItem>) {
        binding.rvHome.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)
        binding.rvHome.adapter = CarAdapter(car)
    }

    override fun onFailure(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}