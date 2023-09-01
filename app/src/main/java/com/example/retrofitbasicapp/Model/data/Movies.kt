package com.example.retrofitbasicapp.Model.data

data class Movies(
    val id :Int?,
    val Movie:List<detail>?
){
    data class detail(
        val id: Long?=0,
        val original_title: String?="",
        val overview: String?="",
        val poster_path: String?="",
        val vote_average:String?=""
    )
}
