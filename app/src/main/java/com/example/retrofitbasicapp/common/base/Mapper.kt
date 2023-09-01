package com.example.retrofitbasicapp.common.base

import com.example.retrofitbasicapp.Model.data.Movies


interface Mapper<F,T> {

    fun fromMap(from:F): List<Movies.detail>?
}