package com.example.chapter6_mvp.Presenter

import com.example.chapter6_mvp.Model.DataCarItem

interface CarView {
    fun onSuccess(msg : String, car : List<DataCarItem>)
    fun onFailure(msg : String)
}